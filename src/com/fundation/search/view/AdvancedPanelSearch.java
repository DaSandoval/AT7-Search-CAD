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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;


import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


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
     * Declaration of Calendar.
     */
    private JCheckBox chFechas;
    private JDateChooser dateModificationIn;
    private JDateChooser dateModificationOut;
    /**
     * Declaration of TextField.
     */
    private JTextField txTerm;
    private JTextField txSize;
    /**
     * Declaration of the CheckBox.
     */
    private JCheckBox chFechaAcces;
    private JCheckBox chFechaCreation;
    private JCheckBox chTerm;
    private JCheckBox chsSize;
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
    private boolean isTermEnabled;
    private boolean isSizeEnabled;
    private boolean isAttributesEnabled;
    private boolean isDuplicatesEnabled;
    private boolean isAccessEnabled;
    private boolean isCreationEnabled;
    /**
     * Declaration about content of ComboBox.
     */
    private JComboBox<String> jcbSize;
    private JComboBox<String> jcbSizeDuration;
    private JComboBox<String> cbTerm;
    private JComboBox<String> cbSize;

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

        chFechas.setText("Modificaction Date:");
        chFechas.setBounds(8, 12, 135, 23);
        this.add(chFechas);

        dateModificationIn.getDate();
        dateModificationIn.setEnabled(false);
        dateModificationIn.setBounds(145, 13, 110, 20);
        this.add(dateModificationIn);

        dateModificationOut.getDate();
        dateModificationOut.setEnabled(false);
        dateModificationOut.setBounds(260, 13, 110, 20);
        this.add(dateModificationOut);

        chTerm.setText("Duration:");
        chTerm.setBounds(8, 69, 80, 23);
        this.add(chTerm);

        jcbSizeDuration.setEnabled(false);
        jcbSizeDuration.setBounds(90, 70, 50, 20);
        this.add(jcbSizeDuration);
        jcbSizeDuration.addItem("=");
        jcbSizeDuration.addItem(">");
        jcbSizeDuration.addItem("<");

        txTerm.setEnabled(false);
        txTerm.setBounds(150, 70, 50, 20);
        this.add(txTerm);

        cbTerm.setModel(new DefaultComboBoxModel<>(new String[]{"Hours", "Minutes", "Seconds"}));
        cbTerm.setEnabled(false);
        cbTerm.setBounds(205, 70, 70, 20);
        this.add(cbTerm);

        chsSize.setText("Size:");
        chsSize.setBounds(8, 100, 70, 23);
        this.add(chsSize);

        jcbSize.setEnabled(false);
        jcbSize.setBounds(90, 101, 50, 20);
        this.add(jcbSize);
        jcbSize.addItem("=");
        jcbSize.addItem(">");
        jcbSize.addItem("<");

        txSize.setEnabled(false);
        txSize.setBounds(150, 101, 50, 20);
        this.add(txSize);

        cbSize.setModel(new DefaultComboBoxModel<>(new String[]{"bytes", "Kbytes", "Mbytes"}));
        cbSize.setEnabled(false);
        cbSize.setBounds(205, 101, 70, 20);
        this.add(cbSize);

        chAttributes.setText("Multimedia:");
        this.add(chAttributes);
        chAttributes.setBounds(410, 12, 150, 23);

        chAtModify.setText("ASF");
        chAtModify.setEnabled(false);
        chAtModify.setBounds(380, 38, 60, 23);
        this.add(chAtModify);

        chAtHidden.setText("AVI");
        chAtHidden.setEnabled(false);
        chAtHidden.setBounds(440, 38, 60, 23);
        this.add(chAtHidden);

        chAtFolder.setText("DIVX");
        chAtFolder.setEnabled(false);
        chAtFolder.setBounds(510, 38, 60, 23);
        this.add(chAtFolder);

        chAtEncriptado.setText("FLV");
        chAtEncriptado.setEnabled(false);
        this.add(chAtEncriptado);
        chAtEncriptado.setBounds(380, 69, 60, 23);

        chAtReading.setText("MPEG");
        chAtReading.setEnabled(false);
        this.add(chAtReading);
        chAtReading.setBounds(440, 69, 60, 23);

        chAtSistema.setText("WMV");
        chAtSistema.setEnabled(false);
        this.add(chAtSistema);
        chAtSistema.setBounds(510, 69, 60, 23);

        chAtComprimido.setText("MP3");
        chAtComprimido.setEnabled(false);
        this.add(chAtComprimido);
        chAtComprimido.setBounds(380, 100, 60, 23);

        chAtVideo.setText("MP4");
        chAtVideo.setEnabled(false);
        this.add(chAtVideo);
        chAtVideo.setBounds(440, 100, 60, 23);

        chDuplicates.setText("Search Duplicates:");
        chDuplicates.setBounds(600, 12, 150, 23);
        this.add(chDuplicates);

        chDupName.setText("Equals Name");
        chDupName.setEnabled(false);
        chDupName.setBounds(600, 38, 150, 23);
        this.add(chDupName);

        chDupSize.setText("Equals Size");
        chDupSize.setEnabled(false);
        chDupSize.setBounds(600, 69, 150, 23);
        this.add(chDupSize);

        chDupContent.setText("Equals Content");
        chDupContent.setEnabled(false);
        chDupContent.setBounds(600, 100, 130, 23);
        this.add(chDupContent);

        chFechas.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chFechasStateChanged(evt);
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

        chDuplicates.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chDuplicadosStateChanged(evt);
            }
        });
    }

    /**
     * Method value components.
     */
    public void initComponents() {
        chFechas = new JCheckBox();
        dateModificationIn = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        dateModificationOut = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        chTerm = new JCheckBox();
        txTerm = new JTextField();
        cbTerm = new JComboBox<>();
        chsSize = new JCheckBox();
        txSize = new JTextField();
        cbSize = new JComboBox<>();
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

        this.isFechasEnabled = false;
        this.isTermEnabled = false;
        this.isSizeEnabled = false;
        this.isAttributesEnabled = false;
        this.isDuplicatesEnabled = false;
        this.isAccessEnabled = false;
        this.isCreationEnabled = false;
    }

    /**
     * Method of the event.
     *
     * @param evt value of the event.
     */
    private void chFechasStateChanged(ChangeEvent evt) {
        if (this.isFechasEnabled != chFechas.isSelected()) {
            this.isFechasEnabled = chFechas.isSelected();
            dateModificationIn.setEnabled(isFechasEnabled);
            dateModificationOut.setEnabled(isFechasEnabled);
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

    public boolean getFechas() {
        return chFechas.isSelected();
    }
    public boolean getAccess() {
        return chFechaAcces.isSelected();
    }
    public boolean getCreation() {
        return chFechaCreation.isSelected();
    }
}

