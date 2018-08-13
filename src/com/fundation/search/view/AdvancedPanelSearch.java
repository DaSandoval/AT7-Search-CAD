/*
 * @(#)View.java
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
package com.fundation.search.view;


import com.fundation.search.controller.Controller;
import com.fundation.search.view.util.Constantes;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javafx.scene.control.TextFormatter;


import com.fundation.search.controller.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Locale;


/**
 * This class AdvancedPanelSearch can be FileResult.
 * In everything that the date implies no comments or
 * translation from English to Spanish is contemplated
 * since the JCalender will be used for the calendar.
 * in this class I would be in the process of modification.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class AdvancedPanelSearch extends JPanel {
    /**
     * Declarationof Calendar.
     */
    private JCheckBox chFechas;
    private JDateChooser dateModificationOne;
    private JDateChooser dateModificationTwo;
    private JCheckBox chAccess;
    private JDateChooser dateAccessOne;
    private JDateChooser dateAccessTwo;
    private JCheckBox chCreation;
    private JDateChooser dateCreationOne;
    private JDateChooser dateCreationTwo;
    /**
     * Declaration of TextField.
     */
    private JTextField txTerm;
    private JTextField txSize;
    /**
     * Declaration of the CheckBox.
     */
    private JCheckBox chsSize;
    private JCheckBox chTerm;
    private JCheckBox chAttributes;
    private JCheckBox chAtModify;
    private JCheckBox chAtHidden;
    private JCheckBox chAtFolder;
    private JCheckBox chAtEncriptado;
    private JCheckBox chAtReading;
    private JCheckBox chAtSistema;
    private JCheckBox chAtComprimido;
    private JCheckBox chAtVideo;
    private JCheckBox chDuplicates;
    private JCheckBox chDupContent;
    private JCheckBox chDupName;
    private JCheckBox chDupSize;

    /**
     * Declaration boolean of activation true - false
     */
    private boolean isFechasEnabled;
    private boolean isAccessEnabled;
    private boolean isCreationEnabled;
    private boolean isTermEnabled;
    private boolean isSizeEnabled;
    private boolean isAttributesEnabled;
    private boolean isDuplicatesEnabled;
    /**
     * Declaration about content of ComboBox.
     */
    private JComboBox<String> jcbSize;
    private JComboBox<String> jcbSizeDuration;
    private JComboBox<String> cbTerm;
    private JComboBox<String> cbSize;
    private JComboBox<String> cbFrameRate;
    private JComboBox<String> cbVideoCode;
    private JComboBox<String> cbResolution;

    /**
     * Definition of JLabel
     */
    private JLabel lbImageAdv;
    private JLabel lbTitleAdvanced;
    private JLabel lbMultimedia;
    private JLabel lbVideo;
    private JLabel lbImageJalaAdv;

    /**
     * method of advanced of search constructs.
     */
    public AdvancedPanelSearch() {
        initComponents();
        settings();
    }

    /**
     * Method of advanced of search constructs.
     *
     * @param cn value of the into.
     */
    public AdvancedPanelSearch(Controller cn) {
        initComponents();
        settings();
    }

    /**
     * Method of the option position.
     */
    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        lbImageJalaAdv.setBounds(0, 0, 150, 45);
        lbImageJalaAdv.setIcon(new ImageIcon(Constantes.getSearchImageJala()));
        this.add(lbImageJalaAdv);

        lbTitleAdvanced.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitleAdvanced.setText("SEARCH ADVANCED");
        lbTitleAdvanced.setFont(new Font("Serif", Font.PLAIN, 20));
        lbTitleAdvanced.setBounds(150, 15, 203, 24);
        lbTitleAdvanced.setForeground(Color.decode("#074692"));
        this.add(lbTitleAdvanced);

        chFechas.setText("Modification Date:");
        chFechas.setBounds(15, 60, 150, 25);
        chFechas.setFont(new Font("Serif", Font.PLAIN, 16));
        chFechas.setForeground(Color.decode("#010a0c"));
        this.add(chFechas);

        dateModificationOne.getDate();
        dateModificationOne.setEnabled(false);
        dateModificationOne.setLocale(new Locale("en"));
        dateModificationOne.setBounds(175, 60, 110, 25);
        this.add(dateModificationOne);

        dateModificationTwo.getDate();
        dateModificationTwo.setEnabled(false);
        dateModificationTwo.setLocale(new Locale("en"));
        dateModificationTwo.setBounds(290, 60, 110, 25);
        this.add(dateModificationTwo);

        chAccess.setText("Access Date:");
        chAccess.setBounds(15, 100, 135, 25);
        chAccess.setFont(new Font("Serif", Font.PLAIN, 16));
        chAccess.setForeground(Color.decode("#010a0c"));
        this.add(chAccess);

        dateAccessOne.getDate();
        dateAccessOne.setEnabled(false);
        dateAccessOne.setLocale(new Locale("en"));
        dateAccessOne.setBounds(175, 100, 110, 25);
        this.add(dateAccessOne);

        dateAccessTwo.getDate();
        dateAccessTwo.setEnabled(false);
        dateAccessTwo.setLocale(new Locale("en"));
        dateAccessTwo.setBounds(290, 100, 110, 25);
        this.add(dateAccessTwo);

        chCreation.setText("Creation Date:");
        chCreation.setBounds(15, 135, 135, 25);
        chCreation.setFont(new Font("Serif", Font.PLAIN, 16));
        chCreation.setForeground(Color.decode("#010a0c"));
        this.add(chCreation);

        dateCreationOne.getDate();
        dateCreationOne.setEnabled(false);
        dateCreationOne.setLocale(new Locale("en"));
        dateCreationOne.setBounds(175, 135, 110, 25);
        this.add(dateCreationOne);

        dateCreationTwo.getDate();
        dateCreationTwo.setEnabled(false);
        dateCreationTwo.setLocale(new Locale("en"));
        dateCreationTwo.setBounds(290, 135, 110, 25);
        this.add(dateCreationTwo);

        chsSize.setText("Size:");
        chsSize.setBounds(450, 10, 80, 25);
        chsSize.setFont(new Font("Serif", Font.PLAIN, 14));
        chsSize.setForeground(Color.decode("#010a0c"));
        this.add(chsSize);

        jcbSize.setEnabled(false);
        jcbSize.setBounds(540, 10, 50, 25);
        this.add(jcbSize);
        jcbSize.addItem("=");
        jcbSize.addItem(">");
        jcbSize.addItem("<");

        txSize.setEnabled(false);
        txSize.setBounds(600, 10, 50, 25);
        this.add(txSize);

        cbSize.setModel(new DefaultComboBoxModel<>(new String[]{"bytes", "Kbytes", "Mbytes"}));
        cbSize.setEnabled(false);
        cbSize.setBounds(660, 10, 70, 25);
        this.add(cbSize);

        lbMultimedia.setText("Multimedia");
        lbMultimedia.setBounds(460, 50, 100, 25);
        lbMultimedia.setFont(new Font("Serif", Font.PLAIN, 16));
        lbMultimedia.setForeground(Color.decode("#010a0c"));
        this.add(lbMultimedia);

        lbVideo.setBounds(590, 40, 150, 75);
        lbVideo.setIcon(new ImageIcon(Constantes.getSearchImageVideo()));
        this.add(lbVideo);

        chAttributes.setText("Video && Music");
        chAttributes.setBounds(450, 80, 150, 25);
        chAttributes.setFont(new Font("Serif", Font.PLAIN, 14));
        chAttributes.setForeground(Color.decode("#010a0c"));
        this.add(chAttributes);

        chTerm.setText("Duration:");
        chTerm.setEnabled(false);
        chTerm.setBounds(450, 120, 90, 25);
        chTerm.setFont(new Font("Serif", Font.PLAIN, 14));
        chTerm.setForeground(Color.decode("#010a0c"));
        this.add(chTerm);

        jcbSizeDuration.setEnabled(false);
        jcbSizeDuration.setBounds(540, 120, 50, 25);
        this.add(jcbSizeDuration);
        jcbSizeDuration.addItem("=");
        jcbSizeDuration.addItem(">");
        jcbSizeDuration.addItem("<");

        txTerm.setEnabled(false);
        txTerm.setBounds(600, 120, 50, 25);
        this.add(txTerm);

        cbTerm.setModel(new DefaultComboBoxModel<>(new String[]{"Horas", "Minutes", "Second"}));
        cbTerm.setEnabled(false);
        cbTerm.setBounds(660, 120, 70, 25);
        this.add(cbTerm);

        chAtReading.setText("MPEG");
        chAtReading.setEnabled(false);
        chAtReading.setBounds(750, 10, 65, 25);
        this.add(chAtReading);

        chAtSistema.setText("WMV");
        chAtSistema.setEnabled(false);
        this.add(chAtSistema);
        chAtSistema.setBounds(830, 10, 65, 25);

        chAtComprimido.setText("MP3");
        chAtComprimido.setEnabled(false);
        this.add(chAtComprimido);
        chAtComprimido.setBounds(750, 50, 65, 25);

        chAtVideo.setText("MP4");
        chAtVideo.setEnabled(false);
        this.add(chAtVideo);
        chAtVideo.setBounds(830, 50, 65, 25);


        chAtModify.setText("ASF");
        chAtModify.setEnabled(false);
        chAtModify.setBounds(750, 95, 65, 25);
        this.add(chAtModify);

        chAtHidden.setText("AVI");
        chAtHidden.setEnabled(false);
        chAtHidden.setBounds(830, 95, 65, 25);
        this.add(chAtHidden);

        chAtFolder.setText("DIVX");
        chAtFolder.setEnabled(false);
        chAtFolder.setBounds(750, 140, 65, 25);
        this.add(chAtFolder);

        chAtEncriptado.setText("FLV");
        chAtEncriptado.setEnabled(false);
        this.add(chAtEncriptado);
        chAtEncriptado.setBounds(830, 140, 65, 25);

        lbImageAdv.setBounds(900, 10, 150, 75);
        lbImageAdv.setIcon(new ImageIcon(Constantes.getSearchImageAdv()));
        this.add(lbImageAdv);

        cbFrameRate.setModel(new DefaultComboBoxModel<>(new String[]{"All Trame Rate", "24", "25", "27", "30", "64"}));
        cbFrameRate.setEnabled(false);
        cbFrameRate.setBounds(900, 90, 150, 25);
        this.add(cbFrameRate);

        cbVideoCode.setModel(new DefaultComboBoxModel<>(new String[]{"All Video Code", "H264", "H263", "MPEG4", "WMV1",}));
        cbVideoCode.setEnabled(false);
        cbVideoCode.setBounds(900, 120, 150, 25);
        this.add(cbVideoCode);

        cbResolution.setModel(new DefaultComboBoxModel<>(new String[]{"All Resolution", "320 x 240", "480 x 360", "720 x 480", "1280 x 720", "1920 x 1080"}));
        cbResolution.setEnabled(false);
        cbResolution.setBounds(900, 150, 150, 25);
        this.add(cbResolution);

        chFechas.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chFechasStateChanged(evt);
            }
        });

        chAccess.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAccessStateChanged(evt);
            }
        });

        chCreation.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chCreationStateChanged(evt);
            }
        });

        chTerm.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chPlazoStateChanged(evt);
            }
        });

        chsSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chTamanoStateChanged(evt);
            }
        });

        chAttributes.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAtributosStateChanged(evt);
            }
        });
    }

    /**
     * Method value components.
     */
    public void initComponents() {
        chFechas = new JCheckBox();
        dateModificationOne = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        dateModificationTwo = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        chAccess = new JCheckBox();
        dateAccessOne = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        dateAccessTwo = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        chCreation = new JCheckBox();
        dateCreationOne = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        dateCreationTwo = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        chTerm = new JCheckBox();
        txTerm = new JTextField();
        cbTerm = new JComboBox<>();
        chsSize = new JCheckBox();
        txSize = new JTextField();
        cbSize = new JComboBox<>();

        cbFrameRate = new JComboBox<>();
        cbVideoCode = new JComboBox<>();
        cbResolution = new JComboBox<>();

        chAttributes = new JCheckBox();
        chAtModify = new JCheckBox();
        chAtHidden = new JCheckBox();
        chAtFolder = new JCheckBox();
        chAtEncriptado = new JCheckBox();
        chAtReading = new JCheckBox();
        chAtSistema = new JCheckBox();
        chAtComprimido = new JCheckBox();
        chAtVideo = new JCheckBox();
        chDuplicates = new JCheckBox();
        chDupName = new JCheckBox();
        chDupSize = new JCheckBox();
        chDupContent = new JCheckBox();
        jcbSize = new JComboBox<>();
        jcbSizeDuration = new JComboBox<>();

        lbTitleAdvanced = new JLabel();
        lbMultimedia = new JLabel();
        lbImageAdv = new JLabel();
        lbVideo = new JLabel();
        lbImageJalaAdv = new JLabel();

        this.isFechasEnabled = false;
        this.isAccessEnabled = false;
        this.isCreationEnabled = false;
        this.isTermEnabled = false;
        this.isSizeEnabled = false;
        this.isAttributesEnabled = false;
        this.isDuplicatesEnabled = false;
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chFechasStateChanged(ChangeEvent evt) {
        if (this.isFechasEnabled != chFechas.isSelected()) {
            this.isFechasEnabled = chFechas.isSelected();
            dateModificationOne.setEnabled(isFechasEnabled);
            dateModificationTwo.setEnabled(isFechasEnabled);
        }
    }

    /**
     * Method of the events Date Access.
     *
     * @param evt
     */
    private void chAccessStateChanged(ChangeEvent evt) {
        if (this.isAccessEnabled != chAccess.isSelected()) {
            this.isAccessEnabled = chAccess.isSelected();
            dateAccessOne.setEnabled(isAccessEnabled);
            dateAccessTwo.setEnabled(isAccessEnabled);
        }
    }

    /**
     * Method of the events Date Creation.
     *
     * @param evt
     */
    private void chCreationStateChanged(ChangeEvent evt) {
        if (this.isCreationEnabled != chCreation.isSelected()) {
            this.isCreationEnabled = chCreation.isSelected();
            dateCreationOne.setEnabled(isCreationEnabled);
            dateCreationTwo.setEnabled(isCreationEnabled);
        }
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chPlazoStateChanged(ChangeEvent evt) {
        if (this.isTermEnabled != chTerm.isSelected()) {
            this.isTermEnabled = chTerm.isSelected();
            txTerm.setEnabled(isTermEnabled);
            cbTerm.setEnabled(isTermEnabled);
            jcbSizeDuration.setEnabled(isTermEnabled);
        }
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chTamanoStateChanged(ChangeEvent evt) {
        if (this.isSizeEnabled != chsSize.isSelected()) {
            this.isSizeEnabled = chsSize.isSelected();
            txSize.setEnabled(isSizeEnabled);
            cbSize.setEnabled(isSizeEnabled);
            jcbSize.setEnabled(isSizeEnabled);
        }
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chAtributosStateChanged(ChangeEvent evt) {
        if (this.isAttributesEnabled != chAttributes.isSelected()) {
            this.isAttributesEnabled = chAttributes.isSelected();
            chAtModify.setEnabled(isAttributesEnabled);
            chAtHidden.setEnabled(isAttributesEnabled);
            chAtFolder.setEnabled(isAttributesEnabled);
            chAtEncriptado.setEnabled(isAttributesEnabled);
            chAtReading.setEnabled(isAttributesEnabled);
            chAtSistema.setEnabled(isAttributesEnabled);
            chAtComprimido.setEnabled(isAttributesEnabled);
            chAtVideo.setEnabled(isAttributesEnabled);
            cbFrameRate.setEnabled(isAttributesEnabled);
            cbVideoCode.setEnabled(isAttributesEnabled);
            cbResolution.setEnabled(isAttributesEnabled);
            chTerm.setEnabled(isAttributesEnabled);
        }
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chDuplicadosStateChanged(ChangeEvent evt) {
        if (this.isDuplicatesEnabled != chDuplicates.isSelected()) {
            this.isDuplicatesEnabled = chDuplicates.isSelected();
            chDupName.setEnabled(isDuplicatesEnabled);
            chDupSize.setEnabled(isDuplicatesEnabled);
            chDupContent.setEnabled(isDuplicatesEnabled);
        }
    }

    /**
     * Method that select option of Frame rate of multimedia.
     *
     * @return String.
     */
    public String selectFrame() {
        String aux = "";
        if (cbFrameRate.getSelectedIndex() == 0) {
            aux = "TODO";
        }
        if (cbFrameRate.getSelectedIndex() == 1) {
            aux = "24";
        }
        if (cbFrameRate.getSelectedIndex() == 2) {
            aux = "25";
        }
        if (cbFrameRate.getSelectedIndex() == 3) {
            aux = "27";
        }
        if (cbFrameRate.getSelectedIndex() == 4) {
            aux = "30";
        }
        if (cbFrameRate.getSelectedIndex() == 5) {
            aux = "64";
        }
        return aux;
    }

    /**
     * Method that select an option of Video code.
     *
     * @return String.
     */
    public String selectVideo() {
        String aux = "";
        if (cbVideoCode.getSelectedIndex() == 0) {
            aux = "TODO";
        }
        if (cbVideoCode.getSelectedIndex() == 1) {
            aux = "H264";
        }
        if (cbVideoCode.getSelectedIndex() == 2) {
            aux = "H263";
        }
        if (cbVideoCode.getSelectedIndex() == 3) {
            aux = "MPEG4";
        }
        if (cbVideoCode.getSelectedIndex() == 4) {
            aux = "WMV1";
        }
        return aux;
    }

    /**
     * Method that select option Resolution Multimedia.
     *
     * @return String.
     */
    public String selectResolution() {
        String aux = "";
        if (cbResolution.getSelectedIndex() == 0) {
            aux = "TODO";
        }
        if (cbResolution.getSelectedIndex() == 1) {
            aux = "320x240";
        }
        if (cbResolution.getSelectedIndex() == 2) {
            aux = "480x360";
        }
        if (cbResolution.getSelectedIndex() == 3) {
            aux = "720x480";
        }
        if (cbResolution.getSelectedIndex() == 4) {
            aux = "1280x720";
        }
        if (cbResolution.getSelectedIndex() == 5) {
            aux = "1920x1080";
        }
        return aux;
    }

    /**
     * Method that select option of Size Duration Multimedia.
     *
     * @return String.
     */
    public String getScaleDuration() {
        String aux = "";
        if (jcbSizeDuration.getSelectedIndex() == 0) {
            aux = "H";
        }
        if (jcbSizeDuration.getSelectedIndex() == 1) {
            aux = "M";
        }
        if (jcbSizeDuration.getSelectedIndex() == 2) {
            aux = "S";
        }
        return aux;
    }

    /**
     * Method get of Dates.
     *
     * @return boolean
     */
    public boolean getFechas() {
        return chFechas.isSelected();
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChFechas() {
        return chFechas;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChFechas(JCheckBox chFechas) {
        this.chFechas = chFechas;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateModificationOne() {
        return dateModificationOne;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateModificationOne(JDateChooser dateModificationOne) {
        this.dateModificationOne = dateModificationOne;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateModificationTwo() {
        return dateModificationTwo;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateModificationTwo(JDateChooser dateModificationTwo) {
        this.dateModificationTwo = dateModificationTwo;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAccess() {
        return chAccess;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAccess(JCheckBox chAccess) {
        this.chAccess = chAccess;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateAccessOne() {
        return dateAccessOne;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateAccessOne(JDateChooser dateAccessOne) {
        this.dateAccessOne = dateAccessOne;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateAccessTwo() {
        return dateAccessTwo;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateAccessTwo(JDateChooser dateAccessTwo) {
        this.dateAccessTwo = dateAccessTwo;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChCreation() {
        return chCreation;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChCreation(JCheckBox chCreation) {
        this.chCreation = chCreation;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateCreationOne() {
        return dateCreationOne;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateCreationOne(JDateChooser dateCreationOne) {
        this.dateCreationOne = dateCreationOne;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JDateChooser getDateCreationTwo() {
        return dateCreationTwo;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDateCreationTwo(JDateChooser dateCreationTwo) {
        this.dateCreationTwo = dateCreationTwo;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxTerm() {
        return txTerm;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxTerm(JTextField txTerm) {
        this.txTerm = txTerm;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxSize() {
        return txSize;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxSize(JTextField txSize) {
        this.txSize = txSize;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChsSize() {
        return chsSize;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChsSize(JCheckBox chsSize) {
        this.chsSize = chsSize;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChTerm() {
        return chTerm;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChTerm(JCheckBox chTerm) {
        this.chTerm = chTerm;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAttributes() {
        return chAttributes;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAttributes(JCheckBox chAttributes) {
        this.chAttributes = chAttributes;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtModify() {
        return chAtModify;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtModify(JCheckBox chAtModify) {
        this.chAtModify = chAtModify;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtHidden() {
        return chAtHidden;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtHidden(JCheckBox chAtHidden) {
        this.chAtHidden = chAtHidden;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtFolder() {
        return chAtFolder;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtFolder(JCheckBox chAtFolder) {
        this.chAtFolder = chAtFolder;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtEncriptado() {
        return chAtEncriptado;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtEncriptado(JCheckBox chAtEncriptado) {
        this.chAtEncriptado = chAtEncriptado;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtReading() {
        return chAtReading;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtReading(JCheckBox chAtReading) {
        this.chAtReading = chAtReading;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtSistema() {
        return chAtSistema;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtSistema(JCheckBox chAtSistema) {
        this.chAtSistema = chAtSistema;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtComprimido() {
        return chAtComprimido;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtComprimido(JCheckBox chAtComprimido) {
        this.chAtComprimido = chAtComprimido;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChAtVideo() {
        return chAtVideo;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChAtVideo(JCheckBox chAtVideo) {
        this.chAtVideo = chAtVideo;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChDuplicates() {
        return chDuplicates;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChDuplicates(JCheckBox chDuplicates) {
        this.chDuplicates = chDuplicates;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChDupContent() {
        return chDupContent;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChDupContent(JCheckBox chDupContent) {
        this.chDupContent = chDupContent;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChDupName() {
        return chDupName;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChDupName(JCheckBox chDupName) {
        this.chDupName = chDupName;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChDupSize() {
        return chDupSize;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChDupSize(JCheckBox chDupSize) {
        this.chDupSize = chDupSize;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getFechasEnabled() {
        return isFechasEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setFechasEnabled(boolean fechasEnabled) {
        isFechasEnabled = fechasEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getAccessEnabled() {
        return isAccessEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setAccessEnabled(boolean accessEnabled) {
        isAccessEnabled = accessEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getCreationEnabled() {
        return isCreationEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCreationEnabled(boolean creationEnabled) {
        isCreationEnabled = creationEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getTermEnabled() {
        return isTermEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTermEnabled(boolean termEnabled) {
        isTermEnabled = termEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getSizeEnabled() {
        return isSizeEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setSizeEnabled(boolean sizeEnabled) {
        isSizeEnabled = sizeEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getAttributesEnabled() {
        return isAttributesEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setAttributesEnabled(boolean attributesEnabled) {
        isAttributesEnabled = attributesEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getDuplicatesEnabled() {
        return isDuplicatesEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setDuplicatesEnabled(boolean duplicatesEnabled) {
        isDuplicatesEnabled = duplicatesEnabled;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getJcbSize() {
        return jcbSize;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setJcbSize(JComboBox<String> jcbSize) {
        this.jcbSize = jcbSize;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getJcbSizeDuration() {
        return jcbSizeDuration;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setJcbSizeDuration(JComboBox<String> jcbSizeDuration) {
        this.jcbSizeDuration = jcbSizeDuration;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getCbTerm() {
        return cbTerm;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCbTerm(JComboBox<String> cbTerm) {
        this.cbTerm = cbTerm;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getCbSize() {
        return cbSize;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCbSize(JComboBox<String> cbSize) {
        this.cbSize = cbSize;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getCbFrameRate() {
        return cbFrameRate;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCbFrameRate(JComboBox<String> cbFrameRate) {
        this.cbFrameRate = cbFrameRate;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getCbVideoCode() {
        return cbVideoCode;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCbVideoCode(JComboBox<String> cbVideoCode) {
        this.cbVideoCode = cbVideoCode;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JComboBox<String> getCbResolution() {
        return cbResolution;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setCbResolution(JComboBox<String> cbResolution) {
        this.cbResolution = cbResolution;
    }

    /**
     * Method get of Dates Enables.
     *
     * @return boolean.
     */
    public boolean isFechasEnabled() {
        return isFechasEnabled;
    }

    /**
     * Method get of Access Enabled.
     *
     * @return boolean.
     */
    public boolean isAccessEnabled() {
        return isAccessEnabled;
    }

    /**
     * Method get of Creation Enabled.
     *
     * @return boolean.
     */
    public boolean isCreationEnabled() {
        return isCreationEnabled;
    }

    /**
     * Method get of Termination Enabled.
     *
     * @return boolean.
     */
    public boolean isTermEnabled() {
        return isTermEnabled;
    }

    /**
     * Method get of Size Enabled.
     *
     * @return boolean.
     */
    public boolean isSizeEnabled() {
        return isSizeEnabled;
    }

    /**
     * Method get of Attributes Enabled.
     *
     * @return boolean.
     */
    public boolean isAttributesEnabled() {
        return isAttributesEnabled;
    }

    /**
     * Method get of Duplicates Enabled.
     *
     * @return boolean.
     */
    public boolean isDuplicatesEnabled() {
        return isDuplicatesEnabled;
    }

}

