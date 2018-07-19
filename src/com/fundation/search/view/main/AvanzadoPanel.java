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
package com.fundation.search.view.main;

import javax.swing.*;
import javax.swing.event.*;
import com.fundation.search.controller.Controller;


/**
 * This class AvanzadoPanel can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class AvanzadoPanel extends JPanel {

    private JCheckBox chFechas;
    private JComboBox<String> cbFecha1Ano;
    private JComboBox<String> cbFecha1Dia;
    private JComboBox<String> cbFecha1Mes;
    private JComboBox<String> cbFecha2Ano;
    private JComboBox<String> cbFecha2Dia;
    private JComboBox<String> cbFecha2Mes;

    private JCheckBox chPlazo;
    private JTextField txPlazo;
    private JComboBox<String> cbPlazo;

    private JCheckBox chTamano;
    private JComboBox<String> cbTamano;
    private JTextField txTamano;

    private JCheckBox chAtributos;
    private JCheckBox chAtModificado;
    private JCheckBox chAtOculto;
    private JCheckBox chAtCarpeta;
    private JCheckBox chAtEncriptado;
    private JCheckBox chAtLectura;
    private JCheckBox chAtSistema;
    private JCheckBox chAtComprimido;

    private JCheckBox chDuplicados;
    private JCheckBox chDupContenido;
    private JCheckBox chDupNombre;
    private JCheckBox chDupTamano;

    private boolean isFechasEnabled;
    private boolean isPlazoEnabled;
    private boolean isTamanoEnabled;
    private boolean isAtributosEnabled;
    private boolean isDuplicadosEnabled;
    private Controller controller;

    public AvanzadoPanel() {
        initComponents();
        settings();
        controller = new Controller();
    }

    public AvanzadoPanel(Controller cn) {
        initComponents();
        settings();
        controller = cn;
    }

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

        chPlazo.setText("De no mas de:");
        chPlazo.setBounds(8, 69, 120, 23);
        this.add(chPlazo);

        txPlazo.setEnabled(false);
        txPlazo.setBounds(137, 70, 79, 20);
        this.add(txPlazo);

        cbPlazo.setModel(new DefaultComboBoxModel<>(new String[]{"Dias"}));
        cbPlazo.setEnabled(false);
        cbPlazo.setBounds(222, 70, 100, 20);
        this.add(cbPlazo);

        chTamano.setText("Size:");
        chTamano.setBounds(8, 100, 123, 23);
        this.add(chTamano);

        txTamano.setEnabled(false);
        txTamano.setBounds(137, 101, 79, 20);
        this.add(txTamano);

        cbTamano.setModel(new DefaultComboBoxModel<>(new String[]{"Kbytes"}));
        cbTamano.setEnabled(false);
        cbTamano.setBounds(222, 101, 100, 20);
        this.add(cbTamano);

        chAtributos.setText("Multimedia:");
        this.add(chAtributos);
        chAtributos.setBounds(350, 12, 150, 23);

        chAtModificado.setText("ASF");
        chAtModificado.setEnabled(false);
        chAtModificado.setBounds(350, 38, 90, 23);
        this.add(chAtModificado);

        chAtOculto.setText("AVI");
        chAtOculto.setEnabled(false);
        chAtOculto.setBounds(440, 38, 70, 23);
        this.add(chAtOculto);

        chAtCarpeta.setText("DIVX");
        chAtCarpeta.setEnabled(false);
        chAtCarpeta.setBounds(510, 38, 90, 23);
        this.add(chAtCarpeta);

        chAtEncriptado.setText("FLV");
        chAtEncriptado.setEnabled(false);
        this.add(chAtEncriptado);
        chAtEncriptado.setBounds(350, 69, 90, 23);

        chAtLectura.setText("MPEG");
        chAtLectura.setEnabled(false);
        this.add(chAtLectura);
        chAtLectura.setBounds(440, 69, 70, 23);

        chAtSistema.setText("WMV");
        chAtSistema.setEnabled(false);
        this.add(chAtSistema);
        chAtSistema.setBounds(510, 69, 90, 23);

        chAtComprimido.setText("MP3");
        chAtComprimido.setEnabled(false);
        this.add(chAtComprimido);
        chAtComprimido.setBounds(350, 100, 150, 23);

        chDuplicados.setText("Buscador Duplicados:");
        chDuplicados.setBounds(600, 12, 150, 23);
        this.add(chDuplicados);

        chDupNombre.setText("Nombre Igual");
        chDupNombre.setEnabled(false);
        chDupNombre.setBounds(600, 38, 150, 23);
        this.add(chDupNombre);

        chDupTamano.setText("Tamano Igual");
        chDupTamano.setEnabled(false);
        chDupTamano.setBounds(600, 69, 150, 23);
        this.add(chDupTamano);

        chDupContenido.setText("Contenido Igual");
        chDupContenido.setEnabled(false);
        chDupContenido.setBounds(600, 100, 130, 23);
        this.add(chDupContenido);

        chFechas.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chFechasStateChanged(evt);
            }
        });

        chPlazo.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chPlazoStateChanged(evt);
            }
        });

        chTamano.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chTamanoStateChanged(evt);
            }
        });

        chAtributos.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAtributosStateChanged(evt);
            }
        });

        chDuplicados.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chDuplicadosStateChanged(evt);
            }
        });
    }

    public void initComponents() {
        chFechas = new JCheckBox();
        cbFecha1Dia = new JComboBox<>();
        cbFecha1Mes = new JComboBox<>();
        cbFecha1Ano = new JComboBox<>();
        cbFecha2Ano = new JComboBox<>();
        cbFecha2Mes = new JComboBox<>();
        cbFecha2Dia = new JComboBox<>();
        chPlazo = new JCheckBox();
        txPlazo = new JTextField();
        cbPlazo = new JComboBox<>();
        chTamano = new JCheckBox();
        txTamano = new JTextField();
        cbTamano = new JComboBox<>();
        chAtributos = new JCheckBox();
        chAtModificado = new JCheckBox();
        chAtOculto = new JCheckBox();
        chAtCarpeta = new JCheckBox();
        chAtEncriptado = new JCheckBox();
        chAtLectura = new JCheckBox();
        chAtSistema = new JCheckBox();
        chAtComprimido = new JCheckBox();
        chDuplicados = new JCheckBox();
        chDupNombre = new JCheckBox();
        chDupTamano = new JCheckBox();
        chDupContenido = new JCheckBox();

        this.isFechasEnabled = false;
        this.isPlazoEnabled = false;
        this.isTamanoEnabled = false;
        this.isAtributosEnabled = false;
        this.isDuplicadosEnabled = false;
    }

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

    private void chPlazoStateChanged(ChangeEvent evt) {
        if (this.isPlazoEnabled != chPlazo.isSelected()) {
            this.isPlazoEnabled = chPlazo.isSelected();
            txPlazo.setEnabled(isPlazoEnabled);
            cbPlazo.setEnabled(isPlazoEnabled);
        }
    }

    private void chTamanoStateChanged(ChangeEvent evt) {
        if (this.isTamanoEnabled != chTamano.isSelected()) {
            this.isTamanoEnabled = chTamano.isSelected();
            txTamano.setEnabled(isTamanoEnabled);
            cbTamano.setEnabled(isTamanoEnabled);
        }
    }

    private void chAtributosStateChanged(ChangeEvent evt) {
        if (this.isAtributosEnabled != chAtributos.isSelected()) {
            this.isAtributosEnabled = chAtributos.isSelected();
            chAtModificado.setEnabled(isAtributosEnabled);
            chAtOculto.setEnabled(isAtributosEnabled);
            chAtCarpeta.setEnabled(isAtributosEnabled);
            chAtEncriptado.setEnabled(isAtributosEnabled);
            chAtLectura.setEnabled(isAtributosEnabled);
            chAtSistema.setEnabled(isAtributosEnabled);
            chAtComprimido.setEnabled(isAtributosEnabled);
        }
    }

    private void chDuplicadosStateChanged(ChangeEvent evt) {
        if (this.isDuplicadosEnabled != chDuplicados.isSelected()) {
            this.isDuplicadosEnabled = chDuplicados.isSelected();
            chDupNombre.setEnabled(isDuplicadosEnabled);
            chDupTamano.setEnabled(isDuplicadosEnabled);
            chDupContenido.setEnabled(isDuplicadosEnabled);
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

    public boolean isTamano() {
        return chTamano.isSelected();
    }

    public String getTamano() {
        return txTamano.getText();
    }

    public String getTamanoEscala() {
        return cbTamano.getSelectedItem().toString();
    }

    public boolean isPlazo() {
        return chPlazo.isSelected();
    }

    public String getPlazo() {
        return txPlazo.getText();
    }

    public String getPlazoEscala() {
        return cbPlazo.getSelectedItem().toString();
    }

    public boolean isAtributos() {
        return chAtributos.isSelected();
    }

    public boolean isAtModificado() {
        return chAtModificado.isSelected();
    }

    public boolean isAtOculto() {
        return chAtOculto.isSelected();
    }

    public boolean isAtCarpeta() {
        return chAtCarpeta.isSelected();
    }

    public boolean isAtEncriptado() {
        return chAtEncriptado.isSelected();
    }

    public boolean isAtLectura() {
        return chAtLectura.isSelected();
    }

    public boolean isAtSistema() {
        return chAtSistema.isSelected();
    }

    public boolean isAtComprimido() {
        return chAtComprimido.isSelected();
    }

    public boolean isDuplicados() {
        return chDuplicados.isSelected();
    }

    public boolean isDupNombre() {
        return chDupNombre.isSelected();
    }

    public boolean isDupTamano() {
        return chDupTamano.isSelected();
    }

    public boolean isDupContenido() {
        return chDupContenido.isSelected();
    }
}
