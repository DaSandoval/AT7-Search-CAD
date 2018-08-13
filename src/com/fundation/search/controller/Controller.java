/*
 * @(#)AssertFile.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.controller;

import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Search;
import com.fundation.search.view.FrameSearch;
import com.fundation.search.view.util.Constantes;

import javax.swing.*;
import java.awt.color.CMMException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import org.apache.log4j.Logger;


/**
 * This class Search.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class Controller {

    final static Logger log = Logger.getLogger(Controller.class);
    private FrameSearch frameSearch;
    private Criteria criteria;
    private Search search;


    /**
     * Method of Controller of search constructs.
     *
     * @param frameSearch .
     */
    public Controller(FrameSearch frameSearch) {
        this.frameSearch = frameSearch;
        this.criteria = new Criteria();
        search = new Search();
        getCriteriaSaved();

        frameSearch.getTpDataBase().getBtLoad().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buttonEventClicked(evt);
            }
        });
    }

    private void getCriteriaSaved(){
        try {
            Map<Integer,Criteria> mapCriteria = search.getDataBaseInHashMap();
            for (Integer key: mapCriteria.keySet()){
                Criteria cri = mapCriteria.get(key);
                System.out.println(cri.getPath());
                frameSearch.getTpDataBase().addRowTableDb(
                        (key),mapCriteria.get(key).getNameOwnwe());
           }
            cm = new HashMap<Integer,Criteria>(mapCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    Map<Integer,Criteria> cm = new HashMap<>();

    public void setExtencion (String listExtencion) {
        String[] aux = listExtencion.split(";");
        if (aux.length > 0) {
            for (String i : aux) {
                switch (i) {
                    case "pdf":{
                        frameSearch.getPnSearch().getChComplete().setSelected(true);
                        break;
                    }
                    case "doc":{
                        frameSearch.getPnSearch().getChMYmi().setSelected(true);
                        break;
                    }
                    case "ppt": {
                        frameSearch.getPnSearch().getChRegex().setSelected(true);
                        break;
                    }
                    case "exe":{
                        frameSearch.getPnSearch().getChUTF().setSelected(true);
                        break;
                    }
                    case "gif":{
                        frameSearch.getPnSearch().getChASCII().setSelected(true);
                        break;
                    }
                    case "log": {
                        frameSearch.getPnSearch().getChNoExists().setSelected(true);
                        break;
                    }
                    case "jpg":{
                        frameSearch.getPnSearch().getChUnicode().setSelected(true);

                        break;
                    }
                    case "rar": {
                        frameSearch.getPnSearch().getChHexa().setSelected(true);
                        break;
                    }
                    default : {
                        frameSearch.getPnSearch().getTxSearchText().setText(i);
                        break;
                    }
                }
            }
            frameSearch.getPnSearch().getChSearchText().setSelected(true);
        }
    }

    public void setExtencionMulti (ArrayList<String> listExtencion) {
        if (listExtencion.size() > 0) {
            for (String i : listExtencion) {
                switch (i) {
                    case "MPEG":{
                        frameSearch.getPnAdvanced().getChAtReading().setSelected(true);
                        break;
                    }
                    case "WMV":{
                        frameSearch.getPnAdvanced().getChAtSistema().setSelected(true);
                        break;
                    }
                    case "MP3": {
                        frameSearch.getPnAdvanced().getChAtComprimido().setSelected(true);
                        break;
                    }
                    case "MP4":{
                        frameSearch.getPnAdvanced().getChAtVideo().setSelected(true);
                        break;
                    }
                    case "ASF":{
                        frameSearch.getPnAdvanced().getChAtModify().setSelected(true);
                        break;
                    }
                    case "AVI": {
                        frameSearch.getPnAdvanced().getChAtHidden().setSelected(true);
                        break;
                    }
                    case "DIVX":{
                        frameSearch.getPnAdvanced().getChAtFolder().setSelected(true);

                        break;
                    }
                    case "FLV": {
                        frameSearch.getPnAdvanced().getChAtEncriptado().setSelected(true);
                        break;
                    }
                    default : {
                        break;
                    }
                }
            }
        }
    }
    /*public  void setDate (Timestamp a1,Timestamp a2, Timestamp b1, Timestamp b2, Timestamp c1, Timestamp c2) {
        Calendar aux = frameSearch.getPnAdvanced().getDateModificationOne().getCalendar();
        aux.setTimeInMillis(a1.getTime());
        frameSearch.getPnAdvanced().getDateModificationOne().setCalendar(aux);
    }*/

    public int setSelectedValue(JComboBox comboBox, String value){
        for (int i = 0; i < comboBox.getItemCount(); i++){
            String item = (String) comboBox.getItemAt(i);
            if (item.equals(value)){
                return i;
            }
        }
        return 0;
    }

    public void setSelectedDates( Timestamp mod1, Timestamp mod2, Timestamp acc1, Timestamp acc2,Timestamp cre1, Timestamp cre2){
        frameSearch.getPnAdvanced().getDateCreationOne().setDate(new Date(cre1.getTime()));
        frameSearch.getPnAdvanced().getDateCreationTwo().setDate(new Date(cre2.getTime()));
        frameSearch.getPnAdvanced().getDateModificationOne().setDate(new Date(mod1.getTime()));
        frameSearch.getPnAdvanced().getDateModificationTwo().setDate(new Date(mod2.getTime()));
        frameSearch.getPnAdvanced().getDateAccessOne().setDate(new Date(acc1.getTime()));
        frameSearch.getPnAdvanced().getDateAccessTwo().setDate(new Date(acc2.getTime()));
    }




    private void buttonEventClicked (MouseEvent evt){
        System.out.println("CLICK");
        if (!frameSearch.getTpDataBase().getTbBaseDate().getSelectionModel().isSelectionEmpty()) {
            String aux = frameSearch.getTpDataBase().getTbBaseDate().getModel().getValueAt(frameSearch.getTpDataBase().getTbBaseDate().getSelectedRow(),0).toString();
            int aux2 = Integer.parseInt(aux);
            frameSearch.getPnSearch().getTxLocation().setText(cm.get(aux2).getPath());
            frameSearch.getPnSearch().getTxtOwner().setText(cm.get(aux2).getOwner());
            frameSearch.getPnSearch().getTxSearch().setText(cm.get(aux2).getFileName());
            frameSearch.getPnSearch().getChFolder().setSelected(cm.get(aux2).isFolder());
            frameSearch.getPnSearch().getChKeySensitive().setSelected(cm.get(aux2).isKeySensitive());
            frameSearch.getPnSearch().getChFileHidden().setSelected(cm.get(aux2).isHidden());
            frameSearch.getPnSearch().getChReadOnly().setSelected(cm.get(aux2).isReadOnly());
            frameSearch.getPnSearch().getChContent().setSelected(cm.get(aux2).isCheckContent());
            frameSearch.getPnSearch().getChOwner().setSelected(cm.get(aux2).isCheckOwner());
            frameSearch.getPnSearch().getTxtContent().setText(cm.get(aux2).getContent());
            this.setExtencion(cm.get(aux2).getExtencionAux());
            frameSearch.getPnSearch().getChSearchText().setSelected(cm.get(aux2).isExtensionEnable());
            frameSearch.getPnAdvanced().getChFechas().setSelected(cm.get(aux2).isCheckMod());
            frameSearch.getPnAdvanced().getChCreation().setSelected(cm.get(aux2).isCheckCre());
            frameSearch.getPnAdvanced().getChAccess().setSelected(cm.get(aux2).isChecAccess());
            this.setSelectedDates(cm.get(aux2).getIniModFile(),cm.get(aux2).getFinModFile(),cm.get(aux2).getIniAccessFile(),cm.get(aux2).getFinAccessFile(),
                    cm.get(aux2).getIniCreationFile(),cm.get(aux2).getFinCreationFile());
            frameSearch.getPnAdvanced().getJcbSize().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getJcbSize(),cm.get(aux2).getTypeSize()));
            frameSearch.getPnAdvanced().getCbSize().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getCbSize(),cm.get(aux2).getSignSize()));
            frameSearch.getPnAdvanced().getTxSize().setText(String.valueOf(cm.get(aux2).getSize()));
            frameSearch.getPnAdvanced().getChsSize().setSelected(cm.get(aux2).isCheckSize());
            frameSearch.getPnAdvanced().getChAttributes().setSelected(cm.get(aux2).isCheckMulti());
            frameSearch.getPnAdvanced().getChTerm().setSelected(cm.get(aux2).isCheckDuration());
            frameSearch.getPnAdvanced().getJcbSizeDuration().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getJcbSizeDuration(),cm.get(aux2).getOperator()));
            frameSearch.getPnAdvanced().getCbTerm().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getCbTerm(),cm.get(aux2).getScale()));
            frameSearch.getPnAdvanced().getTxTerm().setText(String.valueOf(cm.get(aux2).getCantMulti()));
            this.setExtencionMulti(cm.get(aux2).getFormatsMulti());
            frameSearch.getPnAdvanced().getCbFrameRate().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getCbFrameRate(),cm.get(aux2).getFrameRate()));
            frameSearch.getPnAdvanced().getCbVideoCode().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getCbVideoCode(),cm.get(aux2).getVideoCode()));
            frameSearch.getPnAdvanced().getCbResolution().setSelectedIndex(this.setSelectedValue(frameSearch.getPnAdvanced().getCbResolution(),cm.get(aux2).getResolution()));



        }
    }
    /**
     * Method that reads event from the search button.
     */
    public void star() {
        log.info("start: Start frame search");
        frameSearch.getTpDataBase().getBtSave();
        frameSearch.getPnSearch().getBtSearch().addActionListener(a -> getAtribut());
        frameSearch.getTpDataBase().getBtSave().addActionListener(a -> getAtributOne());
    }
    public void getAtributOne(){
        log.info("getAtribut: get Attributes");
        //frameSearch.cleanTable();
       Search search = new Search();
        criteria.clean();

        criteria.setFolderNew(new File(frameSearch.getPnSearch().getTxLocation().getText()));
        criteria.setFileName(frameSearch.getPnSearch().getTxSearch().getText());
        criteria.setPath(frameSearch.getPnSearch().getTxLocation().getText());
        criteria.setHidden(frameSearch.getPnSearch().getChFileHidden().isSelected());
        criteria.setExtensionEnable(frameSearch.getPnSearch().getChSearchText().isSelected());
        criteria.setNameOwnwe(frameSearch.getTpDataBase().getTxBdata().getText());
        if (frameSearch.getPnSearch().getChKeySensitive().isSelected()) {
            log.debug("getAtribut: keySensitive select " + frameSearch.getPnSearch().getChKeySensitive().isSelected());
            criteria.setKeySensitive(false);
        } else {
            log.debug("getAtribut: key sensitive no select " + !frameSearch.getPnSearch().getChKeySensitive().isSelected());
            criteria.setKeySensitive(true);
        }
        log.info("getAtribut: set to criteria");
        criteria.setFolder(frameSearch.getPnSearch().getChFolder().isSelected());
        criteria.setOwner(frameSearch.getPnSearch().getTxtOwner().getText());
        criteria.setCheckOwner(frameSearch.getPnSearch().getChOwner().isSelected());
        criteria.setReadOnly(frameSearch.getPnSearch().getChReadOnly().isSelected());
        criteria.setContent(frameSearch.getPnSearch().getTxtContent().getText());
        criteria.setCheckContent(frameSearch.getPnSearch().getChContent().isSelected());
        criteria.setCheckMod(frameSearch.getPnAdvanced().getChFechas().isSelected());
        criteria.setCheckCre(frameSearch.getPnAdvanced().getChCreation().isSelected());
        criteria.setChecAccess(frameSearch.getPnAdvanced().getChAccess().isSelected());
        criteria.setCheckSize(frameSearch.getPnAdvanced().getChsSize().isSelected());
        criteria.setSignSize((String) frameSearch.getPnAdvanced().getJcbSize().getSelectedItem());
        ArrayList<String> resul = frameSearch.getPnSearch().getExtencion();
        ArrayList<Asset> fileList = new ArrayList<>();
        if (resul.size() > 0) {
            log.info("getAtribut: 0 <" + resul.size());
           for (String file : resul) {
                log.info("getAtribut: get extension " + criteria.getPath());
                criteria.setExtension(file);
                search.searchPath(criteria);
                fileList.addAll(search.getResult());
            }
        } else {
            log.debug("getAtribut: 0 > " + resul.size());
            search.searchPath(criteria);
            fileList = (ArrayList<Asset>) search.getResult();
        }
        if (criteria.isCheckOwner()) {
            log.debug("getAtribut: check Owner " + criteria.isCheckOwner());
            fileList = search.owner(fileList, criteria);
        }
        log.warn("getAtribut: check Owner " + criteria.isCheckOwner());
        if (criteria.isReadOnly()) {
            log.debug("getAtribut: check Read Only " + criteria.isReadOnly());
            fileList = search.searchReadOnly(fileList, criteria);
        }
        log.warn("getAtribut: check Read Only " + criteria.isReadOnly());
        if (criteria.isCheckContent()) {
            log.debug("getAtribut: check Content " + criteria.isCheckContent());
            fileList = search.searchContent(criteria, fileList);
        }
        log.warn("getAtribut: check Content " + criteria.isCheckContent());
        if (frameSearch.getChAdvanced().isSelected()) {
            log.debug("getAtribut: check Advanced " + frameSearch.getChAdvanced().isSelected());
            if (frameSearch.getPnAdvanced().getChsSize().isSelected()) {
                log.debug("getAtribut: size select " + frameSearch.getPnAdvanced().getChsSize().isSelected());
                criteria.setSignSize(frameSearch.getPnAdvanced().getCbSize().getSelectedItem().toString());
                criteria.setType(frameSearch.getPnAdvanced().getJcbSize().getSelectedItem().toString());
                criteria.setSize(Double.parseDouble(frameSearch.getPnAdvanced().getTxSize().getText()));
                fileList = search.searchSze(fileList, criteria);
            }
            if ((frameSearch.getPnAdvanced().getChCreation().isSelected()) | (frameSearch.getPnAdvanced().getChFechas().isSelected()) | (frameSearch.getPnAdvanced().getChAccess().isSelected())) {
                ArrayList<Asset> aux = (ArrayList<Asset>) fileList.clone();
                if (frameSearch.getPnAdvanced().getChCreation().isSelected()) {
                    log.debug("getAtribut: check date creation " + frameSearch.getPnAdvanced().getChCreation().isSelected());
                    criteria.setIniCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationOne().getDate().getTime()));
                    criteria.setFinCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationTwo().getDate().getTime()));
                   aux = search.searchDateCreation(aux, criteria);

                }
                if (frameSearch.getPnAdvanced().getChAccess().isSelected()) {
                    log.debug("getAtribut: check date access " + frameSearch.getPnAdvanced().getChAccess().isSelected());
                    criteria.setIniAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessOne().getDate().getTime()));
                    criteria.setFinAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessTwo().getDate().getTime()));
                   aux = search.searchDateAccess(aux, criteria);

                }
                if (frameSearch.getPnAdvanced().getChFechas().isSelected()) {
                    log.debug("getAtribut: check date " + frameSearch.getPnAdvanced().getChFechas().isSelected());
                    criteria.setIniModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationOne().getDate().getTime()));
                    criteria.setFinModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationTwo().getDate().getTime()));
                    aux = search.searchDateMod(aux, criteria);

                }
                fileList = aux;
            }
            if (frameSearch.getPnAdvanced().getChAttributes().isSelected()) {
                log.debug("getAtribut: check Attributes " + frameSearch.getPnAdvanced().getChAttributes().isSelected());
                criteria.setCheckMulti(frameSearch.getPnAdvanced().getChAttributes().isSelected());
               fileList = search.searchMultimedia(fileList, criteria);
                //criteria.clean();
                if (frameSearch.getPnAdvanced().getChAtModify().isSelected()) {
                    criteria.addItem("ASF");
                }
                if (frameSearch.getPnAdvanced().getChAtHidden().isSelected()) {
                    criteria.addItem("AVI");
                }
                if (frameSearch.getPnAdvanced().getChAtFolder().isSelected()) {
                    criteria.addItem("DIVX");
                }
                if (frameSearch.getPnAdvanced().getChAtEncriptado().isSelected()) {
                    criteria.addItem("FLV");
                }
                if (frameSearch.getPnAdvanced().getChAtReading().isSelected()) {
                    criteria.addItem("MPEG");
                }
                if (frameSearch.getPnAdvanced().getChAtSistema().isSelected()) {
                    criteria.addItem("WMV");
                }
                if (frameSearch.getPnAdvanced().getChAtComprimido().isSelected()) {
                    criteria.addItem("MP3");
                }
                if (frameSearch.getPnAdvanced().getChAtVideo().isSelected()) {
                    criteria.addItem("MP4");
                }
                if (criteria.getFormatsMulti().size() > 0) {
                  fileList = search.checkMulti(fileList, criteria);
                }
                if (!frameSearch.getPnAdvanced().selectFrame().equals("TODO")) {
                    criteria.setFrameRate(frameSearch.getPnAdvanced().selectFrame());
                    fileList = search.checkFrame(fileList, criteria);
                }
                if (!frameSearch.getPnAdvanced().selectVideo().equals("TODO")) {
                    criteria.setVideoCode(frameSearch.getPnAdvanced().selectVideo());
                    fileList = search.checkVideoCode(fileList, criteria);
                }
                if (!frameSearch.getPnAdvanced().selectResolution().equals("TODO")) {
                    criteria.setResolution(frameSearch.getPnAdvanced().selectResolution());
                    fileList = search.checkResolution(fileList, criteria);
                }
                if (frameSearch.getPnAdvanced().getChTerm().isSelected()) {
                    log.debug("getAtribut: check termination or extend " + frameSearch.getPnAdvanced().getChTerm().isSelected());
                    criteria.setScale(frameSearch.getPnAdvanced().getScaleDuration());
                    criteria.setOperator(frameSearch.getPnAdvanced().getJcbSizeDuration().getSelectedItem().toString());
                    criteria.setCantMulti(Double.parseDouble(frameSearch.getPnAdvanced().getTxTerm().getText()));
                   fileList = search.searcDuration(fileList, criteria);
                }
            }
        }
        criteria.setExtencionAux(String.join(";",resul));
        search.gsonCriterio(criteria);
        log.info("getAtribut: End");
    }

    /**
     * Method to see the values ​​of the view and add the spaces.
     */
    private void getAtribut() {
        log.info("getAtribut: get Attributes");
        frameSearch.cleanTable();
        //Search search = new Search();
        //criteria.clean();
        criteria.setFolderNew(new File(frameSearch.getPnSearch().getTxLocation().getText()));
        criteria.setFileName(frameSearch.getPnSearch().getTxSearch().getText());
        criteria.setPath(frameSearch.getPnSearch().getTxLocation().getText());
        criteria.setHidden(frameSearch.getPnSearch().getChFileHidden().isSelected());
        criteria.setExtensionEnable(frameSearch.getPnSearch().getChSearchText().isSelected());
        if (frameSearch.getPnSearch().getChKeySensitive().isSelected()) {
            log.debug("getAtribut: keySensitive select " + frameSearch.getPnSearch().getChKeySensitive().isSelected());
            criteria.setKeySensitive(false);
        } else {
            log.debug("getAtribut: key sensitive no select " + !frameSearch.getPnSearch().getChKeySensitive().isSelected());
            criteria.setKeySensitive(true);
        }
        log.info("getAtribut: set to criteria");
        criteria.setFolder(frameSearch.getPnSearch().getChFolder().isSelected());
        criteria.setOwner(frameSearch.getPnSearch().getTxtOwner().getText());
        criteria.setCheckOwner(frameSearch.getPnSearch().getChOwner().isSelected());
        criteria.setReadOnly(frameSearch.getPnSearch().getChReadOnly().isSelected());
        criteria.setContent(frameSearch.getPnSearch().getTxtContent().getText());
        criteria.setCheckContent(frameSearch.getPnSearch().getChContent().isSelected());

        ArrayList<String> resul = frameSearch.getPnSearch().getExtencion();
        ArrayList<Asset> fileList = new ArrayList<>();
        if (resul.size() > 0) {
            log.info("getAtribut: 0 <" + resul.size());
            for (String file : resul) {
                log.info("getAtribut: get extension " + criteria.getPath());
                criteria.setExtension(file);
                search.searchPath(criteria);
                fileList.addAll(search.getResult());
            }
        } else {
            log.debug("getAtribut: 0 > " + resul.size());
            search.searchPath(criteria);
            fileList = (ArrayList<Asset>) search.getResult();
        }
        if (criteria.isCheckOwner()) {
            log.debug("getAtribut: check Owner " + criteria.isCheckOwner());
            fileList = search.owner(fileList, criteria);
        }
        log.warn("getAtribut: check Owner " + criteria.isCheckOwner());
        if (criteria.isReadOnly()) {
            log.debug("getAtribut: check Read Only " + criteria.isReadOnly());
            fileList = search.searchReadOnly(fileList, criteria);
        }
        log.warn("getAtribut: check Read Only " + criteria.isReadOnly());
        if (criteria.isCheckContent()) {
            log.debug("getAtribut: check Content " + criteria.isCheckContent());
            fileList = search.searchContent(criteria, fileList);
        }
        log.warn("getAtribut: check Content " + criteria.isCheckContent());
        if (frameSearch.getChAdvanced().isSelected()) {
            log.debug("getAtribut: check Advanced " + frameSearch.getChAdvanced().isSelected());
            if (frameSearch.getPnAdvanced().getChsSize().isSelected()) {
                log.debug("getAtribut: size select " + frameSearch.getPnAdvanced().getChsSize().isSelected());
                criteria.setSignSize(frameSearch.getPnAdvanced().getCbSize().getSelectedItem().toString());
                criteria.setType(frameSearch.getPnAdvanced().getJcbSize().getSelectedItem().toString());
                criteria.setSize(Double.parseDouble(frameSearch.getPnAdvanced().getTxSize().getText()));
                fileList = search.searchSze(fileList, criteria);
            }
            if ((frameSearch.getPnAdvanced().getChCreation().isSelected()) | (frameSearch.getPnAdvanced().getChFechas().isSelected()) | (frameSearch.getPnAdvanced().getChAccess().isSelected())) {
                ArrayList<Asset> aux = (ArrayList<Asset>) fileList.clone();
                if (frameSearch.getPnAdvanced().getChCreation().isSelected()) {
                    log.debug("getAtribut: check date creation " + frameSearch.getPnAdvanced().getChCreation().isSelected());
                    criteria.setIniCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationOne().getDate().getTime()));
                    criteria.setFinCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationTwo().getDate().getTime()));
                    aux = search.searchDateCreation(aux, criteria);

                }
                if (frameSearch.getPnAdvanced().getChAccess().isSelected()) {
                    log.debug("getAtribut: check date access " + frameSearch.getPnAdvanced().getChAccess().isSelected());
                    criteria.setIniAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessOne().getDate().getTime()));
                    criteria.setFinAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessTwo().getDate().getTime()));
                    aux = search.searchDateAccess(aux, criteria);

                }
                if (frameSearch.getPnAdvanced().getChFechas().isSelected()) {
                    log.debug("getAtribut: check date " + frameSearch.getPnAdvanced().getChFechas().isSelected());
                    criteria.setIniModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationOne().getDate().getTime()));
                    criteria.setFinModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationTwo().getDate().getTime()));
                    aux = search.searchDateMod(aux, criteria);

                }
                fileList = aux;
            }
            criteria.setCheckDuration(frameSearch.getPnAdvanced().getChTerm().isSelected());
            if (frameSearch.getPnAdvanced().getChAttributes().isSelected()) {
                log.debug("getAtribut: check Attributes " + frameSearch.getPnAdvanced().getChAttributes().isSelected());
                criteria.setCheckMulti(frameSearch.getPnAdvanced().getChAttributes().isSelected());
                fileList = search.searchMultimedia(fileList, criteria);
                //criteria.clean();
                if (frameSearch.getPnAdvanced().getChAtModify().isSelected()) {
                    criteria.addItem("ASF");
                }
                if (frameSearch.getPnAdvanced().getChAtHidden().isSelected()) {
                    criteria.addItem("AVI");
                }
                if (frameSearch.getPnAdvanced().getChAtFolder().isSelected()) {
                    criteria.addItem("DIVX");
                }
                if (frameSearch.getPnAdvanced().getChAtEncriptado().isSelected()) {
                    criteria.addItem("FLV");
                }
                if (frameSearch.getPnAdvanced().getChAtReading().isSelected()) {
                    criteria.addItem("MPEG");
                }
                if (frameSearch.getPnAdvanced().getChAtSistema().isSelected()) {
                    criteria.addItem("WMV");
                }
                if (frameSearch.getPnAdvanced().getChAtComprimido().isSelected()) {
                    criteria.addItem("MP3");
                }
                if (frameSearch.getPnAdvanced().getChAtVideo().isSelected()) {
                    criteria.addItem("MP4");
                }
                criteria.setExtencionMulti(String.join(";",criteria.getFormatsMulti()));
                if (criteria.getFormatsMulti().size() > 0) {
                    fileList = search.checkMulti(fileList, criteria);

                }
                if (!frameSearch.getPnAdvanced().selectFrame().equals("TODO")) {
                    criteria.setFrameRate(frameSearch.getPnAdvanced().selectFrame());
                    fileList = search.checkFrame(fileList, criteria);
                }
                if (!frameSearch.getPnAdvanced().selectVideo().equals("TODO")) {
                    criteria.setVideoCode(frameSearch.getPnAdvanced().selectVideo());
                    fileList = search.checkVideoCode(fileList, criteria);
                }
                if (!frameSearch.getPnAdvanced().selectResolution().equals("TODO")) {
                    criteria.setResolution(frameSearch.getPnAdvanced().selectResolution());
                    fileList = search.checkResolution(fileList, criteria);
                }
                if (frameSearch.getPnAdvanced().getChTerm().isSelected()) {
                    log.debug("getAtribut: check termination or extend " + frameSearch.getPnAdvanced().getChTerm().isSelected());
                    criteria.setScale(frameSearch.getPnAdvanced().getScaleDuration());
                    criteria.setOperator(frameSearch.getPnAdvanced().getJcbSizeDuration().getSelectedItem().toString());
                    criteria.setCantMulti(Double.parseDouble(frameSearch.getPnAdvanced().getTxTerm().getText()));
                    fileList = search.searcDuration(fileList, criteria);
                }
            }
        }

        for (Asset file : fileList) {
            log.info("getAttribut: " + file.getPath());
            search.searchSze(file.getPath());
            frameSearch.addRowTable(
                    new ImageIcon(Constantes.getFileIcon()),
                    file
            );

        }

        //if(){}
        log.info("getAtribut: End");
    }

}