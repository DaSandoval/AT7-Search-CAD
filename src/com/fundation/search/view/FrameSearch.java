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


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;


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

    private Controller controller;
    private boolean isAdvancedEnabled;
    private JCheckBox chAdvanced;
    private AdvancedPanelSearch pnAdvanced;
    private PanelSearch pnSearch;
    private JScrollPane scLocation;
    private JTable tbLocation;
    private JTabbedPane tpPanel;
    private DefaultTableModel tmLocation;

    public FrameSearch() {
        initComponents();
        settings();
    }

    /**
     * Method Components.
     */
    private void initComponents() {
        isAdvancedEnabled = false;
        controller = new Controller();
        tpPanel = new JTabbedPane();
        chAdvanced = new JCheckBox();
        pnSearch = new PanelSearch(controller);
        tpPanel.addTab("Basic", pnSearch);
        pnAdvanced = new AdvancedPanelSearch(controller);
        tpPanel.addTab("Adcanced", pnAdvanced);
        scLocation = new JScrollPane();
        tbLocation = new JTable();
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
     * method position of the windows.
     */
    public void settings() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setMinimumSize(new Dimension(820, 530));
        this.setMaximumSize(new Dimension(820, 530));
        this.setSize(new Dimension(820, 530));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setTitle("File Finder");
        this.setResizable(false);
        tpPanel.setEnabledAt(1, false);
        chAdvanced.setText("Enable Advanced Options");
        chAdvanced.setBounds(12, 185, 200, 23);
        chAdvanced.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAdvancedStateChanged(evt);
            }
        });
        getContentPane().add(chAdvanced);
        tmLocation.addColumn("Icon");
        tmLocation.addColumn("Name");
        tmLocation.addColumn("Zize");
        tbLocation.setModel(tmLocation);
        scLocation.setViewportView(tbLocation);
        getContentPane().add(scLocation);
        scLocation.setBounds(10, 210, 770, 240);
        getFilesInDirectory();
        getContentPane().add(tpPanel);
        tpPanel.setBounds(10, 10, 770, 170);
    }

    /**
     * Method for get the folder.
     */
    private void getFilesInDirectory() {
        addRowTable(new ImageIcon(Constantes.getFolderIcon()), "Folder", "--");
        addRowTable(new ImageIcon(Constantes.getFileIcon()), "Files", "10 KBytes");
    }

    /**
     * Method of Table date.
     *
     * @param img  value of the imagen.
     * @param name value of the name.
     * @param size value of the size.
     */
    public void addRowTable(ImageIcon img, String name, String size) {
        tmLocation.addRow(
                new Object[]{
                        img,
                        name,
                        size
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
}
