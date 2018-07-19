package com.fundation.search.view.main;

import com.fundation.search.controller.Controller;
import com.fundation.search.view.util.Constantes;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
public class FilesIU extends JFrame {

    private Controller controller;
    private boolean isAvanzadoEnabled;
    private JCheckBox chAvanzado;
    private AvanzadoPanel pnAvanzado;
    private BuscarPanel pnBuscar;
    private JScrollPane scUbicacion;
    private JTable tbUbicacion;
    private JTabbedPane tpPanel;
    private DefaultTableModel tmUbicacion;

    public FilesIU() {
        initComponents();
        settings();
    }

    private void initComponents() {
        isAvanzadoEnabled = false;
        controller = new Controller();
        tpPanel = new JTabbedPane();
        chAvanzado = new JCheckBox();
        pnBuscar = new BuscarPanel(controller);
        tpPanel.addTab("Basic", pnBuscar);
        pnAvanzado = new AvanzadoPanel(controller);
        tpPanel.addTab("Adcanced", pnAvanzado);
        scUbicacion = new JScrollPane();
        tbUbicacion = new JTable();
        tmUbicacion = new DefaultTableModel() {
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
        chAvanzado.setText("Enable Advanced Options");
        chAvanzado.setBounds(12, 185, 200, 23);
        chAvanzado.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chAvanzadoStateChanged(evt);
            }
        });
        getContentPane().add(chAvanzado);
        tmUbicacion.addColumn("Icon");
        tmUbicacion.addColumn("Name");
        tmUbicacion.addColumn("Zize");
        tbUbicacion.setModel(tmUbicacion);
        scUbicacion.setViewportView(tbUbicacion);
        getContentPane().add(scUbicacion);
        scUbicacion.setBounds(10, 210, 770, 240);
        getFilesInDirectory();
        getContentPane().add(tpPanel);
        tpPanel.setBounds(10, 10, 770, 170);
    }

    private void getFilesInDirectory() {
        addRowTable(new ImageIcon(Constantes.getFolderIcon()), "Carpeta", "--");
        addRowTable(new ImageIcon(Constantes.getFileIcon()), "Archivo", "10 KBytes");
    }

    public void addRowTable(ImageIcon img, String nombre, String tam) {
        tmUbicacion.addRow(
                new Object[]{
                    img,
                    nombre,
                    tam
                });
        updateRowHeights();
    }

    private void updateRowHeights() {
        try {
            for (int row = 0; row < tbUbicacion.getRowCount(); row++) {
                int rowHeight = tbUbicacion.getRowHeight();
                for (int column = 0; column < tbUbicacion.getColumnCount(); column++) {
                    Component comp = tbUbicacion.prepareRenderer(tbUbicacion.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                tbUbicacion.setRowHeight(row, rowHeight);
            }
        } catch (ClassCastException e) {
            System.out.println("Error de Altura de Fila");
        }
    }

    private void chAvanzadoStateChanged(ChangeEvent evt) {
        if (this.isAvanzadoEnabled != chAvanzado.isSelected()) {
            this.isAvanzadoEnabled = chAvanzado.isSelected();
            tpPanel.setEnabledAt(1, chAvanzado.isSelected());
            if (chAvanzado.isSelected() == false) {
                tpPanel.setSelectedIndex(0);
            }
        }
    }

}
