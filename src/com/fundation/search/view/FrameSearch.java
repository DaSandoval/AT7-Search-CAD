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
import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetFile;

import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;


/**
 * This class FrameSearch can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class FrameSearch extends JFrame {

    /**
     * Declaration of the panels.
     */
    private Controller controller;
    private boolean isAdvancedEnabled;
    private boolean isDataBaseEnabled;
    private JCheckBox chAdvanced;
    private JCheckBox chDataBase;
    private AdvancedPanelSearch pnAdvanced;
    private PanelSearch pnSearch;
    private JScrollPane scLocation;
    private JTable tbLocation;
    private JTabbedPane tpPanel;
    private DefaultTableModel tmLocation;
    private PanelDataBase tpDataBase;




    public FrameSearch() {
        initComponents();
        settings();
    }

    /**
     * Method Components.
     */
    private void initComponents() {
        isAdvancedEnabled = false;
        isDataBaseEnabled = false;
        tpPanel = new JTabbedPane();
        chAdvanced = new JCheckBox();
        chDataBase = new JCheckBox();
        pnSearch = new PanelSearch();
        tpPanel.addTab("Basic", pnSearch);
        pnAdvanced = new AdvancedPanelSearch();
        tpPanel.addTab("Advanced", pnAdvanced);
        scLocation = new JScrollPane();
        tbLocation = new JTable();
        tpDataBase = new PanelDataBase();
        tpPanel.addTab("Data Base", tpDataBase);
        tmLocation = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
                if (column == 0) {
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };
    }

    /**
     * Method position of the windows.
     */
    public void settings() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setMinimumSize(new Dimension(1120, 560)); //frame
        this.setMaximumSize(new Dimension(1120, 560));//frame
        this.setSize(new Dimension(1020, 560));//frame
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setTitle("File Finder");
        this.setResizable(false);
        tpPanel.setEnabledAt(1, false);
        tpPanel.setEnabledAt(2, false);

        chAdvanced.setText("Enable Advanced Options");
        chAdvanced.setBounds(12, 235, 200, 23); //cambio de posion check que habilita
        chAdvanced.setFont(new Font("Serif", Font.PLAIN, 14));
        chAdvanced.setForeground(Color.decode("#010a0c"));
        chAdvanced.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent evt) {
                chAdvancedStateChanged(evt);
            }
        });

        chDataBase.setText("Enable Data Base Options");
        chDataBase.setBounds(250, 235, 200, 23); //cambio de posion check que habilita
        chDataBase.setFont(new Font("Serif", Font.PLAIN, 14));
        chDataBase.setForeground(Color.decode("#010a0c"));
        chDataBase.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAdvancedStateChangedDataBase(evt);
            }
        });
        getContentPane().add(chAdvanced);
        getContentPane().add(chDataBase);
        tmLocation.addColumn("Icon");
        tmLocation.addColumn("Name");
        tmLocation.addColumn("Extent");
        tmLocation.addColumn("Size");
        tmLocation.addColumn("Path");
        tmLocation.addColumn("Hidden");
        tmLocation.addColumn("Owner");
        tmLocation.addColumn("Read Online");
        tmLocation.addColumn("Date Creation");
        tmLocation.addColumn("Date Access");
        tmLocation.addColumn("Dare Modification ");
        tmLocation.addColumn("Multimedia");
        tbLocation.setModel(tmLocation);
        scLocation.setViewportView(tbLocation);
        getContentPane().add(scLocation);
        scLocation.setBounds(10, 260, 1095, 240); //table
        getContentPane().add(tpPanel);
        tpPanel.setBounds(10, 10, 1095, 220);
    }

    /**
     * Method of Table date.
     *
     * @param img  value of the imagen.
     * @param files class AssetFile.
     */
    public void addRowTable(ImageIcon img, Asset files) {
        tmLocation.addRow(
                new Object[]{
                        img,
                        files.getFileName(),files.getExtent(),
                        String.valueOf(files.getSize()),
                        files.getPath(),
                        files.getHidden(),
                        files.getOwner(),
                        files.isRealOnline(),
                        files.getDateCreacion().toString(),
                        files.getDateAccess().toString(),
                        files.getDateModi().toString(),files.isMultimedia()
                });
        updateRowHeights();
    }

    /**
     * Method of de location.
     */
    private void updateRowHeights() {
        try {
            for (int row = 0; row < tbLocation.getRowCount(); row++) {
                int rowHeight = tbLocation.getRowHeight();
                for (int column = 0; column < tbLocation.getColumnCount(); column++) {
                    Component comp = tbLocation.prepareRenderer(tbLocation.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                tbLocation.setRowHeight(row, rowHeight);
            }
        } catch (ClassCastException e) {
            System.out.println("Error de Altura de Fila");
        }
    }

    /**
     * Method of option Advance.
     *
     * @param evt data of the value.
     */
    private void chAdvancedStateChanged(ChangeEvent evt) {
        if (this.isAdvancedEnabled != chAdvanced.isSelected()) {
            this.isAdvancedEnabled = chAdvanced.isSelected();
            tpPanel.setEnabledAt(1, chAdvanced.isSelected());
            if (chAdvanced.isSelected() == false) {
                tpPanel.setSelectedIndex(0);
            }
        }
    }

    /**
     * Method of option Data Base.
     *
     * @param evt data of the value.
     */
    private void chAdvancedStateChangedDataBase(ChangeEvent evt) {
        if (this.isDataBaseEnabled != chDataBase.isSelected()){
            this.isDataBaseEnabled = chDataBase.isSelected();
            tpPanel.setEnabledAt(2, chDataBase.isSelected());
            if (chDataBase.isSelected() == false) {
                tpPanel.setSelectedIndex(0);
            }
        }
    }

    public void cleanTable() {
        if (tmLocation.getRowCount() > 0) {
            for (int i = tmLocation.getRowCount() - 1; i > -1; i--) {
                tmLocation.removeRow(i);
            }
        }
    }

    /**
     * Method of the get.
     *
     * @return value true.
     */
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Method of the get.
     *
     * @return value true.
     */
    public boolean getAdvancedEnabled() {
        return isAdvancedEnabled;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setAdvancedEnabled(boolean advancedEnabled) {
        isAdvancedEnabled = advancedEnabled;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public JCheckBox getChAdvanced() {
        return chAdvanced;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setChAdvanced(JCheckBox chAdvanced) {
        this.chAdvanced = chAdvanced;
    }

    /**
     * Method of the get.
     *
     * @return value .
     */
    public AdvancedPanelSearch getPnAdvanced() {
        return pnAdvanced;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setPnAdvanced(AdvancedPanelSearch pnAdvanced) {
        this.pnAdvanced = pnAdvanced;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public PanelSearch getPnSearch() {
        return pnSearch;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setPnSearch(PanelSearch pnSearch) {
        this.pnSearch = pnSearch;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public JScrollPane getScLocation() {
        return scLocation;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setScLocation(JScrollPane scLocation) {
        this.scLocation = scLocation;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public JTable getTbLocation() {
        return tbLocation;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setTbLocation(JTable tbLocation) {
        this.tbLocation = tbLocation;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public JTabbedPane getTpPanel() {
        return tpPanel;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setTpPanel(JTabbedPane tpPanel) {
        this.tpPanel = tpPanel;
    }

    /**
     * Method of the get.
     *
     * @return value.
     */
    public DefaultTableModel getTmLocation() {
        return tmLocation;
    }

    /**
     * Method of the set.
     *
     * @return value.
     */
    public void setTmLocation(DefaultTableModel tmLocation) {
        this.tmLocation = tmLocation;
    }

    public boolean isAdvancedEnabled() {
        return isAdvancedEnabled;
    }

    public boolean isDataBaseEnabled() {
        return isDataBaseEnabled;
    }

    public void setDataBaseEnabled(boolean dataBaseEnabled) {
        isDataBaseEnabled = dataBaseEnabled;
    }

    public JCheckBox getChDataBase() {
        return chDataBase;
    }

    public void setChDataBase(JCheckBox chDataBase) {
        this.chDataBase = chDataBase;
    }

    public PanelDataBase getTpDataBase() {
        return tpDataBase;
    }

    public void setTpDataBase(PanelDataBase tpDataBase) {
        this.tpDataBase = tpDataBase;
    }
}
