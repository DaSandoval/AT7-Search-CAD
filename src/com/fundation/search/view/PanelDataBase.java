package com.fundation.search.view;

import com.fundation.search.view.util.Constantes;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This class Data Base.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class PanelDataBase extends JPanel {

    /**
     * Definition of label.
     */
    private JLabel lbDataBase;
    private JLabel lbName;
    private JLabel lbImageJalaDb;
    /**
     * Declaration of TextField.
     */
    private JTextField txBdata;
    /**
     * Definition of buttons.
     */
    private JButton btSave;
    private JButton btLoad;

    /**
     * Declaration of table
     */
    private JTable tbBaseDate;
    private DefaultTableModel tmBaseD;
    private JScrollPane scTableScroll;
    private JLabel lbImageDataBase;
    private JLabel lbtableSevend;
    private JLabel lbImageSevend;

    /**
     * Method of advanced of search constructs.
     */
    public PanelDataBase() {
        initComponents();
        settings();
    }

    /**
     * Method of the option position.
     */
    public void settings() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        lbImageJalaDb.setBounds(2, 0, 150, 45);
        lbImageJalaDb.setIcon(new ImageIcon(Constantes.getSearchImageJala()));
        this.add(lbImageJalaDb);

        lbImageDataBase.setBounds(5, 60, 250, 110);
        lbImageDataBase.setIcon(new ImageIcon(Constantes.getSearchDateBase()));
        this.add(lbImageDataBase);

        lbDataBase.setHorizontalAlignment(SwingConstants.CENTER);
        lbDataBase.setText("DATA BASE");
        lbDataBase.setFont(new Font("Serif", Font.PLAIN, 20));
        lbDataBase.setBounds(260, 15, 203, 24);
        lbDataBase.setForeground(Color.decode("#074692"));
        this.add(lbDataBase);

        lbName.setText("Name :");
        lbName.setBounds(210, 70, 50, 30);
        lbName.setFont(new Font("Serif", Font.PLAIN, 16));
        lbName.setForeground(Color.decode("#010a0c"));
        this.add(lbName);

        txBdata.setBounds(270, 70, 240, 30);
        this.add(txBdata);

        btSave.setText("Save");
        btSave.setBounds(290, 120, 100, 25);
        this.btSave.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btSave);

        btLoad.setText("Load");
        btLoad.setBounds(400, 120, 100, 25);
        this.btLoad.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btLoad);

        lbImageSevend.setBounds(550, 50, 100, 130);
        lbImageSevend.setIcon(new ImageIcon(Constantes.getSearchSevend()));
        this.add(lbImageSevend);

        lbtableSevend.setHorizontalAlignment(SwingConstants.CENTER);
        lbtableSevend.setText("Favorite Search Saved");
        lbtableSevend.setFont(new Font("Serif", Font.PLAIN, 14));
        lbtableSevend.setBounds(660, 1, 300, 25);
        lbtableSevend.setForeground(Color.decode("#0a2336"));
        this.add(lbtableSevend);

        tmBaseD.addColumn("#");
        tmBaseD.addColumn("Name");
        tbBaseDate.setModel(tmBaseD);
        //tbBaseDate.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scTableScroll.setViewportView(tbBaseDate);
        scTableScroll.setBounds(660, 25, 405, 150); //table
        this.add(scTableScroll);
    }

    /**
     * Method of the event Click of Data Base Button.
     *
     * @param evt mouse.
     */
    private void buttonEventClicked(MouseEvent evt) {
        if (!tbBaseDate.getSelectionModel().isSelectionEmpty()) {
            String aux = tbBaseDate.getModel().getValueAt(tbBaseDate.getSelectedRow(), 0).toString();
            String aux1 = tbBaseDate.getModel().getValueAt(tbBaseDate.getSelectedRow(), 1).toString();
        }
    }

    /**
     * Method that initialize events of the view.
     */
    public void initComponents() {

        lbDataBase = new JLabel();
        lbName = new JLabel();
        txBdata = new JTextField();
        btSave = new JButton();
        btLoad = new JButton();
        tbBaseDate = new JTable();
        tmBaseD = new DefaultTableModel();
        scTableScroll = new JScrollPane();
        lbImageJalaDb = new JLabel();
        lbImageDataBase = new JLabel();
        lbtableSevend = new JLabel();
        lbImageSevend = new JLabel();
    }

    /**
     * Method that prepare the table for the database by the GUI.
     */
    private void updateRowHeights() {
        try {
            for (int row = 0; row < tmBaseD.getRowCount(); row++) {
                int rowHeight = tmBaseD.getRowCount();
                for (int column = 0; column < tmBaseD.getColumnCount(); column++) {
                    Component comp = tbBaseDate.prepareRenderer(tbBaseDate.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                tbBaseDate.setRowHeight(row, rowHeight);
            }
        } catch (ClassCastException e) {
        }
    }

    /**
     * Method for insert of the table of GUI.
     *
     * @param key   DB using Map.
     * @param nameO String
     */
    public void addRowTableDb(Integer key, String nameO) {
        tmBaseD.addRow(
                new Object[]{
                        key, nameO
                });
        updateRowHeights();
    }

    public void cleanTable() {
        if (tmBaseD.getRowCount() > 0) {
            for (int i = tmBaseD.getRowCount() - 1; i > -1; i--) {
                tmBaseD.removeRow(i);
            }
        }
    }

    /**
     * Method get Text of entry.
     *
     * @return Text string.
     */
    public JTextField getTxBdata() {
        return txBdata;
    }

    /**
     * Method set Text Entry.
     *
     * @param txBdata String.
     */
    public void setTxBdata(JTextField txBdata) {
        this.txBdata = txBdata;
    }

    /**
     * Method get Save Button.
     *
     * @return
     */
    public JButton getBtSave() {
        return btSave;
    }

    /**
     * Method set Save Button.
     *
     * @param btSave event.
     */
    public void setBtSave(JButton btSave) {
        this.btSave = btSave;
    }

    /**
     * Method get Load Button.
     *
     * @return
     */
    public JButton getBtLoad() {
        return btLoad;
    }

    /**
     * Method set Load Button.
     *
     * @param btLoad event.
     */
    public void setBtLoad(JButton btLoad) {
        this.btLoad = btLoad;
    }

    /**
     * Method get Table data base.
     *
     * @return table.
     */
    public JTable getTbBaseDate() {
        return tbBaseDate;
    }

    /**
     * Method set Table of data base.
     *
     * @param tbBaseDate
     */
    public void setTbBaseDate(JTable tbBaseDate) {
        this.tbBaseDate = tbBaseDate;
    }
}
