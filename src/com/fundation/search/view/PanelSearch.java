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


import com.fundation.search.controller.Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;


/**
 * This class PanelSearch can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class PanelSearch extends JPanel {

    private JButton btSearch;
    private JButton btSelect;
    private JLabel lbSearch;
    private JLabel lbLocation;
    private JTextField txSearch;
    private JTextField txLocation;
    private JTextField txSearchText;
    private JCheckBox chSearchText;
    private JCheckBox chASCII;
    private JCheckBox chComplete;
    private JCheckBox chUTF;
    private JCheckBox chUnicode;
    private JCheckBox chRegex;
    private JCheckBox chHexa;
    private JCheckBox chMYmi;
    private JCheckBox chNoExists;
    private Controller controller;
    private boolean isSearchTxEnabled;

    /**
     * Method for the builder
     */
    public PanelSearch() {
        initComponents();
        settings();
        controller = new Controller();
    }

    /**
     * Method of the builder.
     *
     * @param cn
     */
    public PanelSearch(Controller cn) {
        initComponents();
        settings();
        controller = cn;
    }

    /**
     * Method of the option.
     */
    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        txSearch.setBounds(90, 13, 210, 20);
        this.add(txSearch);

        lbSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        lbSearch.setText("Search:");
        lbSearch.setBounds(12, 16, 53, 14);
        this.add(lbSearch);

        lbLocation.setHorizontalAlignment(SwingConstants.RIGHT);
        lbLocation.setText("Search in:");
        lbLocation.setBounds(12, 42, 70, 14);
        this.add(lbLocation);

        txLocation.setEditable(false);
        txLocation.setBackground(new Color(255, 255, 255));
        txLocation.setText("C:\\");
        txLocation.setBounds(90, 39, 210, 20);
        this.add(txLocation);

        chSearchText.setText("Search Extend");
        chSearchText.setBounds(310, 12, 130, 23);
        this.add(chSearchText);

        txSearchText.setEnabled(false);
        txSearchText.setBackground(new Color(255, 255, 255));
        txSearchText.setText("");
        txSearchText.setBounds(440, 12, 210, 20);
        this.add(txSearchText);

        chComplete.setText("Pdf");
        chComplete.setEnabled(false);
        chComplete.setBounds(310, 38, 130, 23);
        this.add(chComplete);

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

        chNoExists.setText("Log");
        chNoExists.setEnabled(false);
        chNoExists.setBounds(570, 65, 130, 23);
        this.add(chNoExists);

        chUnicode.setText("Ppt");
        chUnicode.setEnabled(false);
        chUnicode.setBounds(310, 92, 130, 23);
        this.add(chUnicode);

        chHexa.setText("Rar");
        chHexa.setEnabled(false);
        chHexa.setBounds(440, 92, 130, 23);
        this.add(chHexa);

        btSearch.setText("Search");
        btSearch.setBounds(90, 65, 80, 48);
        this.add(btSearch);

        btSelect.setText("Selecc File");
        btSelect.setBounds(180, 65, 120, 48);
        this.add(btSelect);

        chSearchText.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chSearchTextStateChanged(evt);
            }
        });

        btSelect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btSelectMouseClicked(evt);
            }
        });
    }

    /**
     * Method of components
     */
    public void initComponents() {

        txSearch = new JTextField();
        lbSearch = new JLabel();
        lbLocation = new JLabel();
        txLocation = new JTextField();
        chSearchText = new JCheckBox();
        txSearchText = new JTextField();
        chComplete = new JCheckBox();
        chMYmi = new JCheckBox();
        chUTF = new JCheckBox();
        chASCII = new JCheckBox();
        chRegex = new JCheckBox();
        chNoExists = new JCheckBox();
        chUnicode = new JCheckBox();
        chHexa = new JCheckBox();
        btSearch = new JButton();
        btSelect = new JButton();
        this.isSearchTxEnabled = false;
    }

    private void chSearchTextStateChanged(ChangeEvent evt) {
        if (this.isSearchTxEnabled != chSearchText.isSelected()) {
            this.isSearchTxEnabled = chSearchText.isSelected();
            txSearchText.setEnabled(isSearchTxEnabled);
            chComplete.setEnabled(isSearchTxEnabled);
            chMYmi.setEnabled(isSearchTxEnabled);
            chASCII.setEnabled(isSearchTxEnabled);
            chNoExists.setEnabled(isSearchTxEnabled);
            chUnicode.setEnabled(isSearchTxEnabled);
            chHexa.setEnabled(isSearchTxEnabled);
            chRegex.setEnabled(isSearchTxEnabled);
            chUTF.setEnabled(isSearchTxEnabled);
        }
    }

    private void btSelectMouseClicked(MouseEvent evt) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            txLocation.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JButton getBtSearch() {
        return btSearch;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setBtSearch(JButton btSearch) {
        this.btSearch = btSearch;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JButton getBtSelect() {
        return btSelect;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setBtSelect(JButton btSelect) {
        this.btSelect = btSelect;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JLabel getLbSearch() {
        return lbSearch;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setLbSearch(JLabel lbSearch) {
        this.lbSearch = lbSearch;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JLabel getLbLocation() {
        return lbLocation;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setLbLocation(JLabel lbLocation) {
        this.lbLocation = lbLocation;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxSearch() {
        return txSearch;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxSearch(JTextField txSearch) {
        this.txSearch = txSearch;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxLocation() {
        return txLocation;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxLocation(JTextField txLocation) {
        this.txLocation = txLocation;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxSearchText() {
        return txSearchText;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxSearchText(JTextField txSearchText) {
        this.txSearchText = txSearchText;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChSearchText() {
        return chSearchText;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChSearchText(JCheckBox chSearchText) {
        this.chSearchText = chSearchText;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChASCII() {
        return chASCII;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChASCII(JCheckBox chASCII) {
        this.chASCII = chASCII;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChComplete() {
        return chComplete;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChComplete(JCheckBox chComplete) {
        this.chComplete = chComplete;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChUTF() {
        return chUTF;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChUTF(JCheckBox chUTF) {
        this.chUTF = chUTF;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChUnicode() {
        return chUnicode;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChUnicode(JCheckBox chUnicode) {
        this.chUnicode = chUnicode;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChRegex() {
        return chRegex;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChRegex(JCheckBox chRegex) {
        this.chRegex = chRegex;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChHexa() {
        return chHexa;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChHexa(JCheckBox chHexa) {
        this.chHexa = chHexa;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChMYmi() {
        return chMYmi;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChMYmi(JCheckBox chMYmi) {
        this.chMYmi = chMYmi;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChNoExists() {
        return chNoExists;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChNoExists(JCheckBox chNoExists) {
        this.chNoExists = chNoExists;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public boolean getSearchTxEnabled() {
        return isSearchTxEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setSearchTxEnabled(boolean searchTxEnabled) {
        isSearchTxEnabled = searchTxEnabled;
    }
}
