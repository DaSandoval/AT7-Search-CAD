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

    private JCheckBox chFechas;
    private JComboBox<String> cbFecha1Ano;
    private JComboBox<String> cbFecha1Dia;
    private JComboBox<String> cbFecha1Mes;
    private JComboBox<String> cbFecha2Ano;
    private JComboBox<String> cbFecha2Dia;
    private JComboBox<String> cbFecha2Mes;

    private JCheckBox chTerm;
    private JTextField txTerm;
    private JComboBox<String> cbTerm;

    private JCheckBox chsSize;
    private JComboBox<String> cbSize;
    private JTextField txSize;

    private JCheckBox chAttributes;
    private JCheckBox chAtModify;
    private JCheckBox chAtHidden;
    private JCheckBox chAtFolder;
    private JCheckBox chAtEncriptado;
    private JCheckBox chAtReading;
    private JCheckBox chAtSistema;
    private JCheckBox chAtComprimido;

    private JCheckBox chDuplicates;
    private JCheckBox chDupContent;
    private JCheckBox chDupName;
    private JCheckBox chDupSize;

    private boolean isFechasEnabled;
    private boolean isTermEnabled;
    private boolean isSizeEnabled;
    private boolean isAttributesEnabled;
    private boolean isDuplicatesEnabled;
    private Controller controller;

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
        controller = cn;
    }

    /**
     * Method of the option position.
     */
    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        chFechas.setText("Date range");
        chFechas.setBounds(8, 12, 125, 23);
        this.add(chFechas);

        cbFecha1Dia.setModel(new DefaultComboBoxModel<>(new String[]{"01"}));
        cbFecha1Dia.setEnabled(false);
        cbFecha1Dia.setBounds(280, 13, 56, 20);
        this.add(cbFecha1Dia);

        cbFecha1Mes.setModel(new DefaultComboBoxModel<>(new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
        cbFecha1Mes.setEnabled(false);
        cbFecha1Mes.setBounds(195, 13, 79, 20);
        this.add(cbFecha1Mes);

        cbFecha1Ano.setModel(new DefaultComboBoxModel<>(new String[]{"2018"}));
        cbFecha1Ano.setEnabled(false);
        cbFecha1Ano.setBounds(133, 13, 56, 20);
        this.add(cbFecha1Ano);

        cbFecha2Ano.setModel(new DefaultComboBoxModel<>(new String[]{"2018"}));
        cbFecha2Ano.setEnabled(false);
        cbFecha2Ano.setBounds(133, 39, 56, 20);
        this.add(cbFecha2Ano);

        cbFecha2Mes.setModel(new DefaultComboBoxModel<>(new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
        cbFecha2Mes.setEnabled(false);
        cbFecha2Mes.setBounds(195, 39, 79, 20);
        this.add(cbFecha2Mes);

        cbFecha2Dia.setModel(new DefaultComboBoxModel<>(new String[]{"01"}));
        cbFecha2Dia.setEnabled(false);
        cbFecha2Dia.setBounds(280, 39, 56, 20);
        this.add(cbFecha2Dia);

        chTerm.setText("De no mas de:");
        chTerm.setBounds(8, 69, 120, 23);
        this.add(chTerm);

        txTerm.setEnabled(false);
        txTerm.setBounds(137, 70, 79, 20);
        this.add(txTerm);

        cbTerm.setModel(new DefaultComboBoxModel<>(new String[]{"Dias"}));
        cbTerm.setEnabled(false);
        cbTerm.setBounds(222, 70, 100, 20);
        this.add(cbTerm);

        chsSize.setText("Size:");
        chsSize.setBounds(8, 100, 123, 23);
        this.add(chsSize);

        txSize.setEnabled(false);
        txSize.setBounds(137, 101, 79, 20);
        this.add(txSize);

        cbSize.setModel(new DefaultComboBoxModel<>(new String[]{"Kbytes"}));
        cbSize.setEnabled(false);
        cbSize.setBounds(222, 101, 100, 20);
        this.add(cbSize);

        chAttributes.setText("Multimedia:");
        this.add(chAttributes);
        chAttributes.setBounds(350, 12, 150, 23);

        chAtModify.setText("ASF");
        chAtModify.setEnabled(false);
        chAtModify.setBounds(350, 38, 90, 23);
        this.add(chAtModify);

        chAtHidden.setText("AVI");
        chAtHidden.setEnabled(false);
        chAtHidden.setBounds(440, 38, 70, 23);
        this.add(chAtHidden);

        chAtFolder.setText("DIVX");
        chAtFolder.setEnabled(false);
        chAtFolder.setBounds(510, 38, 90, 23);
        this.add(chAtFolder);

        chAtEncriptado.setText("FLV");
        chAtEncriptado.setEnabled(false);
        this.add(chAtEncriptado);
        chAtEncriptado.setBounds(350, 69, 90, 23);

        chAtReading.setText("MPEG");
        chAtReading.setEnabled(false);
        this.add(chAtReading);
        chAtReading.setBounds(440, 69, 70, 23);

        chAtSistema.setText("WMV");
        chAtSistema.setEnabled(false);
        this.add(chAtSistema);
        chAtSistema.setBounds(510, 69, 90, 23);

        chAtComprimido.setText("MP3");
        chAtComprimido.setEnabled(false);
        this.add(chAtComprimido);
        chAtComprimido.setBounds(350, 100, 150, 23);

        chDuplicates.setText("Buscador Duplicados:");
        chDuplicates.setBounds(600, 12, 150, 23);
        this.add(chDuplicates);

        chDupName.setText("Nombre Igual");
        chDupName.setEnabled(false);
        chDupName.setBounds(600, 38, 150, 23);
        this.add(chDupName);

        chDupSize.setText("Tamano Igual");
        chDupSize.setEnabled(false);
        chDupSize.setBounds(600, 69, 150, 23);
        this.add(chDupSize);

        chDupContent.setText("Contenido Igual");
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
        cbFecha1Dia = new JComboBox<>();
        cbFecha1Mes = new JComboBox<>();
        cbFecha1Ano = new JComboBox<>();
        cbFecha2Ano = new JComboBox<>();
        cbFecha2Mes = new JComboBox<>();
        cbFecha2Dia = new JComboBox<>();
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
        chDuplicates = new JCheckBox();
        chDupName = new JCheckBox();
        chDupSize = new JCheckBox();
        chDupContent = new JCheckBox();

        this.isFechasEnabled = false;
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
            cbFecha1Ano.setEnabled(isFechasEnabled);
            cbFecha1Mes.setEnabled(isFechasEnabled);
            cbFecha1Dia.setEnabled(isFechasEnabled);
            cbFecha2Ano.setEnabled(isFechasEnabled);
            cbFecha2Mes.setEnabled(isFechasEnabled);
            cbFecha2Dia.setEnabled(isFechasEnabled);
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

    public String getFecha1() {
        StringBuilder sb = new StringBuilder();
        sb.append(cbFecha1Ano.getSelectedItem().toString())
                .append("-")
                .append(cbFecha1Mes.getSelectedItem().toString())
                .append("-")
                .append(cbFecha1Dia.getSelectedItem().toString());
        return sb.toString();
    }

    public String getFecha2() {
        StringBuilder sb = new StringBuilder();
        sb.append(cbFecha2Ano.getSelectedItem().toString())
                .append("-")
                .append(cbFecha2Mes.getSelectedItem().toString())
                .append("-")
                .append(cbFecha2Dia.getSelectedItem().toString());
        return sb.toString();
    }

}

