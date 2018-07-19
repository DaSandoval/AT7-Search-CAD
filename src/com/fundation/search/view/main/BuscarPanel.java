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
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import com.fundation.search.controller.Controller;

/**
 * This class BuscarPanel can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class BuscarPanel extends JPanel {

    private JButton btBuscar;
    private JButton btSelect;
    private JLabel lbBuscar;
    private JLabel lbUbicacion;
    private JTextField txBuscar;
    private JTextField txUbicacion;
    private JTextField txBuscarTexto;
    private JCheckBox chBuscarTexto;
    private JCheckBox chASCII;
    private JCheckBox chCompleta;
    private JCheckBox chUTF;
    private JCheckBox chUnicode;
    private JCheckBox chRegex;
    private JCheckBox chHexa;
    private JCheckBox chMYmi;
    private JCheckBox chNoExiste;
    private Controller controller;
    private boolean isBuscarTxEnabled;

    public BuscarPanel() {
        initComponents();
        settings();
        controller = new Controller();
    }

    public BuscarPanel(Controller cn) {
        initComponents();
        settings();
        controller = cn;
    }

    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        txBuscar.setBounds(90, 13, 210, 20);
        this.add(txBuscar);

        lbBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbBuscar.setText("Path:");
        lbBuscar.setBounds(12, 16, 53, 14);
        this.add(lbBuscar);

        lbUbicacion.setHorizontalAlignment(SwingConstants.RIGHT);
        lbUbicacion.setText("Search in:");
        lbUbicacion.setBounds(12, 42, 70, 14);
        this.add(lbUbicacion);

        txUbicacion.setEditable(false);
        txUbicacion.setBackground(new Color(255, 255, 255));
        txUbicacion.setText("C:\\");
        txUbicacion.setBounds(90, 39, 210, 20);
        this.add(txUbicacion);

        chBuscarTexto.setText("Search Extend");
        chBuscarTexto.setBounds(310, 12, 130, 23);
        this.add(chBuscarTexto);

        txBuscarTexto.setEnabled(false);
        txBuscarTexto.setBackground(new Color(255, 255, 255));
        txBuscarTexto.setText("");
        txBuscarTexto.setBounds(440, 12, 210, 20);
        this.add(txBuscarTexto);

        chCompleta.setText("Pdf");
        chCompleta.setEnabled(false);
        chCompleta.setBounds(310, 38, 130, 23);
        this.add(chCompleta);

        chMYmi.setText("Doc");
        chMYmi.setEnabled(false);
        chMYmi.setBounds(440, 38, 130, 23);
        this.add(chMYmi);

        chUTF.setText("Exe");
        chUTF.setEnabled(false);
        chUTF.setBounds(570, 38, 130, 23);
        this.add(chUTF);

        chASCII.setText("Bmp");
        chASCII.setEnabled(false);
        chASCII.setBounds(310, 65, 130, 23);
        this.add(chASCII);

        chRegex.setText("Gif");
        chRegex.setEnabled(false);
        chRegex.setBounds(440, 65, 130, 23);
        this.add(chRegex);

        chNoExiste.setText("Log");
        chNoExiste.setEnabled(false);
        chNoExiste.setBounds(570, 65, 130, 23);
        this.add(chNoExiste);

        chUnicode.setText("Ppt");
        chUnicode.setEnabled(false);
        chUnicode.setBounds(310, 92, 130, 23);
        this.add(chUnicode);

        chHexa.setText("Rar");
        chHexa.setEnabled(false);
        chHexa.setBounds(440, 92, 130, 23);
        this.add(chHexa);

        btBuscar.setText("Search");
        btBuscar.setBounds(90, 65, 80, 48);
        this.add(btBuscar);

        btSelect.setText("Selecc File");
        btSelect.setBounds(180, 65, 120, 48);
        this.add(btSelect);

        chBuscarTexto.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chBuscarTextoStateChanged(evt);
            }
        });

        btSelect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btSelectMouseClicked(evt);
            }
        });

        btBuscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btBuscarMouseClicked(evt);
            }
        });
    }

    public void initComponents() {

        txBuscar = new JTextField();
        lbBuscar = new JLabel();
        lbUbicacion = new JLabel();
        txUbicacion = new JTextField();
        chBuscarTexto = new JCheckBox();
        txBuscarTexto = new JTextField();
        chCompleta = new JCheckBox();
        chMYmi = new JCheckBox();
        chUTF = new JCheckBox();
        chASCII = new JCheckBox();
        chRegex = new JCheckBox();
        chNoExiste = new JCheckBox();
        chUnicode = new JCheckBox();
        chHexa = new JCheckBox();
        btBuscar = new JButton();
        btSelect = new JButton();
        this.isBuscarTxEnabled = false;
    }

    private void chBuscarTextoStateChanged(ChangeEvent evt) {
        if (this.isBuscarTxEnabled != chBuscarTexto.isSelected()) {
            this.isBuscarTxEnabled = chBuscarTexto.isSelected();
            txBuscarTexto.setEnabled(isBuscarTxEnabled);
            chCompleta.setEnabled(isBuscarTxEnabled);
            chMYmi.setEnabled(isBuscarTxEnabled);
            chASCII.setEnabled(isBuscarTxEnabled);
            chNoExiste.setEnabled(isBuscarTxEnabled);
            chUnicode.setEnabled(isBuscarTxEnabled);
            chHexa.setEnabled(isBuscarTxEnabled);
            chRegex.setEnabled(isBuscarTxEnabled);
            chUTF.setEnabled(isBuscarTxEnabled);
        }
    }

    private void btSelectMouseClicked(MouseEvent evt) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            txUbicacion.setText(selectedFile.getAbsolutePath());
        }
    }

    private void btBuscarMouseClicked(MouseEvent evt) {
        controller.buscarArchivos(this.getBuscar(),
                this.getUbicacion(),
                this.isBuscarTexto(),
                this.isPCompleta(),
                this.isASCII(),
                this.isUTF(),
                this.isUnicode(),
                this.isRegex(),
                this.isHexa(),
                this.isMYmi(),
                this.isNoExiste());
    }

    public String getBuscar() {
        return txBuscar.getText();
    }

    public String getUbicacion() {
        return txUbicacion.getText();
    }

    public String getBuscarTexto() {
        return txBuscarTexto.getText();
    }

    public boolean isBuscarTexto() {
        return chBuscarTexto.isSelected();
    }

    public boolean isPCompleta() {
        return chCompleta.isSelected();
    }

    public boolean isASCII() {
        return chASCII.isSelected();
    }

    public boolean isUTF() {
        return chUTF.isSelected();
    }

    public boolean isUnicode() {
        return chUnicode.isSelected();
    }

    public boolean isRegex() {
        return chRegex.isSelected();
    }

    public boolean isHexa() {
        return chHexa.isSelected();
    }

    public boolean isMYmi() {
        return chMYmi.isSelected();
    }

    public boolean isNoExiste() {
        return chNoExiste.isSelected();
    }
}
