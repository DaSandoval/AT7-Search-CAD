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
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.utils.SubstanceConstants;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 * This class PanelSearch can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class PanelSearch extends JPanel {
    /**
     * Definition of buttons.
     */
    private JButton btSearch;
    private JButton btSelect;
    /**
     * Definition of label.
     */
    private JLabel lbSearch;
    private JLabel lbLocation;
    /**
     * Definition of TextField.
     */
    private JTextField txSearch;
    private JTextField txLocation;
    private JTextField txtOwner;
    private JTextField txtContent;
    private JTextField txSearchText;
    /**
     * Definition of CheckBox
     */
    private JCheckBox chFileHidden;
    private JCheckBox chContent;
    private JCheckBox chOwner;
    private JCheckBox chFolder;
    private JCheckBox chReadOnly;
    private JCheckBox chKeySensitive;
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
    /**
     * Definition of exprecion Booleans
     */
    private boolean isSearchTxEnabled;
    private boolean isOwnerEnabled;
    private boolean isContentEnabled;

    /**
     * Definition of imagen
     */
    private JLabel lbImage;
    private JLabel lbTitle;
    private JLabel lbImageTxt;
    private JLabel lbImagePdf;
    private JLabel lbImageJala;

    /**
     * Method for the builder
     */
    public PanelSearch() {

        //icono = new ImageIcon(image.getImage().getScaledInstance(btSearch.getWidth(), btSearch.getHeight(),Image.SCALE_DEFAULT));
        initComponents();
        settings();
    }

    /**
     * Method of the option.
     */
    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        lbImageJala.setBounds(0, 0, 150, 45);
        lbImageJala.setIcon(new ImageIcon(Constantes.getSearchImageJala()));
        this.add(lbImageJala);

        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setText("SEARCH BASIC");
        lbTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        lbTitle.setBounds(130, 15, 203, 24);
        lbTitle.setForeground(Color.decode("#074692"));
        this.add(lbTitle);

        //lbSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        lbSearch.setText("Search:");
        lbSearch.setBounds(12, 50, 53, 25);
        lbSearch.setFont(new Font("Serif", Font.PLAIN, 16));
        lbSearch.setForeground(Color.decode("#010a0c"));
        this.add(lbSearch);

        txSearch.setBounds(90, 50, 290, 25);
        this.add(txSearch);

        lbLocation.setText("Search in:");
        lbLocation.setBounds(12, 80, 70, 25);
        lbLocation.setFont(new Font("Serif", Font.PLAIN, 16));
        lbLocation.setForeground(Color.decode("#010a0c"));
        this.add(lbLocation);

        txLocation.setEditable(false);
        txLocation.setBackground(new Color(255, 255, 255));
        txLocation.setText("");
        txLocation.setBounds(90, 80, 290, 25);
        this.add(txLocation);

        chFolder.setText("Folder");
        chFolder.setEnabled(true);
        chFolder.setBounds(12, 115, 70, 23);
        this.add(chFolder);

        chFileHidden.setText("File Hidden");
        chFileHidden.setEnabled(true);
        chFileHidden.setBounds(80, 115, 90, 23);
        this.add(chFileHidden);

        chKeySensitive.setText("Key Sensitive");
        chKeySensitive.setEnabled(true);
        chKeySensitive.setBounds(180, 115, 110, 23);
        this.add(chKeySensitive);

        chReadOnly.setText("Read Only");
        chReadOnly.setEnabled(true);
        chReadOnly.setBounds(300, 115, 100, 23);
        this.add(chReadOnly);

        btSearch.setText("Search");
        btSearch.setBounds(400, 50, 120, 25);
        this.btSearch.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        btSearch.setIcon(new ImageIcon(Constantes.getSearchButton()));
        this.add(btSearch);

        btSelect.setText("Select File");
        btSelect.setBounds(400, 80, 120, 25);
        this.btSelect.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btSelect);

        lbImage.setBounds(530, 5, 230, 100);
        lbImage.setIcon(new ImageIcon(Constantes.getSearch()));
        this.add(lbImage);

        chContent.setText("Content:");
        chContent.setEnabled(true);
        chContent.setBounds(530, 110, 82, 25);
        chContent.setFont(new Font("Serif", Font.PLAIN, 14));
        chContent.setForeground(Color.decode("#010a0c"));
        this.add(chContent);

        txtContent.setEnabled(false);
        txtContent.setBackground(new Color(255, 255, 255));
        txtContent.setText("");
        txtContent.setBounds(610, 110, 150, 25);
        this.add(txtContent);

        chOwner.setText("Owner:");
        chOwner.setEnabled(true);
        chOwner.setBounds(530, 150, 75, 25);
        chOwner.setFont(new Font("Serif", Font.PLAIN, 14));
        chOwner.setForeground(Color.decode("#010a0c"));
        this.add(chOwner);

        txtOwner.setEnabled(false);
        txtOwner.setBackground(new Color(255, 255, 255));
        txtOwner.setText("");
        txtOwner.setBounds(610, 150, 150, 25);
        this.add(txtOwner);

        chSearchText.setText("Search Ext");
        chSearchText.setBounds(800, 12, 120, 25);
        chSearchText.setFont(new Font("Serif", Font.PLAIN, 14));
        chSearchText.setForeground(Color.decode("#010a0c"));
        this.add(chSearchText);

        txSearchText.setEnabled(false);
        txSearchText.setBackground(new Color(255, 255, 255));
        txSearchText.setText("");
        txSearchText.setBounds(930, 12, 90, 25);
        this.add(txSearchText);

        chComplete.setText(".pdf");
        chComplete.setEnabled(false);
        chComplete.setBounds(800, 50, 60, 25);
        this.add(chComplete);

        chMYmi.setText(".doc");
        chMYmi.setEnabled(false);
        chMYmi.setBounds(880, 50, 60, 25);
        this.add(chMYmi);

        chUTF.setText(".exe");
        chUTF.setEnabled(false);
        chUTF.setBounds(960, 50, 60, 25);
        this.add(chUTF);

        chASCII.setText(".gif");
        chASCII.setEnabled(false);
        chASCII.setBounds(800, 80, 60, 25);
        this.add(chASCII);

        chRegex.setText(".ppt");
        chRegex.setEnabled(false);
        chRegex.setBounds(880, 80, 60, 25);
        this.add(chRegex);

        chNoExists.setText(".log");
        chNoExists.setEnabled(false);
        chNoExists.setBounds(960, 80, 60, 25);
        this.add(chNoExists);

        chUnicode.setText(".jpg");
        chUnicode.setEnabled(false);
        chUnicode.setBounds(800, 110, 60, 25);
        this.add(chUnicode);

        chHexa.setText(".rar");
        chHexa.setEnabled(false);
        chHexa.setBounds(880, 110, 60, 25);
        this.add(chHexa);

        lbImageTxt.setBounds(1030, 120, 50, 60);
        lbImageTxt.setIcon(new ImageIcon(Constantes.getSearchImageTxt()));
        this.add(lbImageTxt);

        lbImagePdf.setBounds(970, 130, 40, 50);
        lbImagePdf.setIcon(new ImageIcon(Constantes.getSearchImagePdf()));
        this.add(lbImagePdf);

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
        chOwner.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chOwnerMouseClicked(evt);
            }
        });
        chContent.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chContentMouseClicked(evt);
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
        txtOwner = new JTextField();
        txtContent = new JTextField();
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
        chFileHidden = new JCheckBox();
        chContent = new JCheckBox();
        chFolder = new JCheckBox();
        chOwner = new JCheckBox();
        chReadOnly = new JCheckBox();
        chKeySensitive = new JCheckBox();
        this.isSearchTxEnabled = false;
        this.isOwnerEnabled = false;
        this.isContentEnabled = false;

        lbImage = new JLabel();
        lbTitle = new JLabel();
        lbImageTxt = new JLabel();
        lbImagePdf = new JLabel();
        lbImageJala = new JLabel();
    }

    /**
     * Method for event.
     *
     * @return a void.
     */
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

    /**
     * Method for event.
     *
     * @return a void.
     */
    private void btSelectMouseClicked(MouseEvent evt) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        Action newFolder = jfc.getActionMap().get("New Folder");
        newFolder.setEnabled(false);
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            txLocation.setText(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Method for the event select checkbox.
     *
     * @param evt accion.
     */
    private void chOwnerMouseClicked(MouseEvent evt) {
        if (isOwnerEnabled != chOwner.isSelected()) {
            this.isOwnerEnabled = chOwner.isSelected();
            txtOwner.setEnabled(isOwnerEnabled);
        }
    }

    /**
     * Method for the event select checkbox.
     *
     * @param evt accion.
     */
    private void chContentMouseClicked(MouseEvent evt) {
        if (isContentEnabled != chContent.isSelected()) {
            this.isContentEnabled = chContent.isSelected();
            txtContent.setEnabled(isContentEnabled);
        }
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public JButton getBtSearch() {
        return btSearch;
    }

    /**
     * Method of the set value.
     *
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
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
     * @return a value change.
     */
    public void setSearchTxEnabled(boolean searchTxEnabled) {
        isSearchTxEnabled = searchTxEnabled;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public JCheckBox getChFileHidden() {
        return chFileHidden;
    }

    /**
     * Method of the set value.
     *
     * @return a value change.
     */
    public void setChFileHidden(JCheckBox chFileHidden) {
        this.chFileHidden = chFileHidden;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChContent() {
        return chContent;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChContent(JCheckBox chContent) {
        this.chContent = chContent;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChOwner() {
        return chOwner;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChOwner(JCheckBox chOwner) {
        this.chOwner = chOwner;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChFolder() {
        return chFolder;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChFolder(JCheckBox chFolder) {
        this.chFolder = chFolder;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChReadOnly() {
        return chReadOnly;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChReadOnly(JCheckBox chReadOnly) {
        this.chReadOnly = chReadOnly;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JCheckBox getChKeySensitive() {
        return chKeySensitive;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setChKeySensitive(JCheckBox chKeySensitive) {
        this.chKeySensitive = chKeySensitive;
    }

    public void getMessageInformation() {
        JOptionPane.showMessageDialog(null, "Seleccionar un path y colocar un nombre en file name", "Llenar los campos primero", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxtOwner() {
        return txtOwner;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxtOwner(JTextField txtOwner) {
        this.txtOwner = txtOwner;
    }

    /**
     * Method of the get value.
     *
     * @return a value.
     */
    public JTextField getTxtContent() {
        return txtContent;
    }

    /**
     * Method of the set value.
     *
     * @return a value.
     */
    public void setTxtContent(JTextField txtContent) {
        this.txtContent = txtContent;
    }

    /**
     * Method get option search text String.
     *
     * @return boolean.
     */
    public boolean isSearchTxEnabled() {
        return isSearchTxEnabled;
    }

    /**
     * Method get option Owner enabled.
     *
     * @return boolean.
     */
    public boolean isOwnerEnabled() {
        return isOwnerEnabled;
    }

    /**
     * Method set option Owner enabled.
     *
     * @param ownerEnabled boolean.
     */
    public void setOwnerEnabled(boolean ownerEnabled) {
        isOwnerEnabled = ownerEnabled;
    }

    /**
     * Method get option content enable.
     *
     * @return boolean.
     */
    public boolean isContentEnabled() {
        return isContentEnabled;
    }

    /**
     * Method set option Content Enable.
     *
     * @param contentEnabled boolean.
     */
    public void setContentEnabled(boolean contentEnabled) {
        isContentEnabled = contentEnabled;
    }

    /**
     * Method of extencion.
     *
     * @return list String.
     */
    public ArrayList<String> getExtencion() {
        ArrayList<String> result = new ArrayList<>();
        if (chSearchText.isSelected()) {
            if (!txSearchText.getText().equals("")) {
                result.add(txSearchText.getText());
            }
            if (chASCII.isSelected()) {
                result.add("gif");
            }
            if (chComplete.isSelected()) {
                result.add("pdf");
            }
            if (chMYmi.isSelected()) {
                result.add("doc");
            }
            if (chUTF.isSelected()) {
                result.add("exe");
            }
            if (chRegex.isSelected()) {
                result.add("ppt");
            }
            if (chNoExists.isSelected()) {
                result.add("log");
            }
            if (chUnicode.isSelected()) {
                result.add("jpg");
            }
            if (chHexa.isSelected()) {
                result.add("rar");
            }

        }
        for (String i : result) {
            System.out.println("extension vista" + i);
        }
        return result;
    }
}
