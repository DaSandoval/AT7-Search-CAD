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

import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;

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


    /**
     * Method of Controller of search constructs.
     *
     * @param frameSearch .
     */
    public Controller(FrameSearch frameSearch) {
        this.frameSearch = frameSearch;
        this.criteria = new Criteria();
    }


    /**
     * Method that reads event from the search button.
     */
    public void star() {
        log.info("start: Start frame search");
        frameSearch.getPnSearch().getBtSearch().addActionListener(a -> getAtribut());
    }

    /**
     * Method to see the values ​​of the view and add the spaces.
     */
    private void getAtribut() {
        log.info("getAtribut: get Attributes");
        frameSearch.cleanTable();
        Search search = new Search();
        criteria.clean();
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
            if (frameSearch.getPnAdvanced().getChCreation().isSelected()) {
                log.debug("getAtribut: check date creation " + frameSearch.getPnAdvanced().getChCreation().isSelected());
                criteria.setIniCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationOne().getDate().getTime()));
                criteria.setFinCreationFile(new Timestamp(frameSearch.getPnAdvanced().getDateCreationTwo().getDate().getTime()));
                fileList = search.searchDateCreation(fileList, criteria);

            }
            if (frameSearch.getPnAdvanced().getChAccess().isSelected()) {
                log.debug("getAtribut: check date access " + frameSearch.getPnAdvanced().getChAccess().isSelected());
                criteria.setIniAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessOne().getDate().getTime()));
                criteria.setFinAccessFile(new Timestamp(frameSearch.getPnAdvanced().getDateAccessTwo().getDate().getTime()));
                fileList = search.searchDateAccess(fileList, criteria);

            }
            if (frameSearch.getPnAdvanced().getChFechas().isSelected()) {
                log.debug("getAtribut: check date " + frameSearch.getPnAdvanced().getChFechas().isSelected());
                criteria.setIniModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationOne().getDate().getTime()));
                criteria.setFinModFile(new Timestamp(frameSearch.getPnAdvanced().getDateModificationTwo().getDate().getTime()));
                fileList = search.searchDateMod(fileList, criteria);

            }
            if (frameSearch.getPnAdvanced().getChAttributes().isSelected()) {
                log.debug("getAtribut: check Attributes " + frameSearch.getPnAdvanced().getChAttributes().isSelected());
                criteria.setCheckMulti(frameSearch.getPnAdvanced().getChAttributes().isSelected());
                fileList = search.searchMultimedia(fileList, criteria);
                criteria.clean();
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

        for (Asset file : fileList) {
            log.info("getAttribut: " + file.getPath());
            search.searchSze(file.getPath());
            frameSearch.addRowTable(
                    new ImageIcon(Constantes.getFileIcon()),
                    file
            );

        }
        log.info("getAtribut: End");
    }

}