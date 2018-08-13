package com.fundation.search.view;

import com.fundation.search.model.Asset;
import com.fundation.search.view.util.Constantes;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
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

    /**
     * method of advanced of search constructs.
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

        lbImageJalaDb.setBounds(0, 0, 150, 45);
        lbImageJalaDb.setIcon(new ImageIcon(Constantes.getSearchImageJala()));
        this.add(lbImageJalaDb);

        //lbDataBase.setHorizontalAlignment(SwingConstants.RIGHT);
        lbDataBase.setHorizontalAlignment(SwingConstants.CENTER);
        lbDataBase.setText("DATA BASE");
        lbDataBase.setFont(new Font("Serif", Font.PLAIN, 20));
        lbDataBase.setBounds(260, 15, 203, 24);
        lbDataBase.setForeground(Color.decode("#074692"));
        this.add(lbDataBase);

        //lbName.setHorizontalAlignment(SwingConstants.RIGHT);
        lbName.setText("Name :");
        lbName.setBounds(210, 80, 100, 30);
        lbName.setFont(new Font("Serif", Font.PLAIN, 16));
        lbName.setForeground(Color.decode("#010a0c"));
        this.add(lbName);

        txBdata.setBounds(300, 80, 210, 30);
        this.add(txBdata);

        btSave.setText("Save");
        btSave.setBounds(300, 120, 95, 40);
        this.btSave.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btSave);

        btLoad.setText("Load");
        btLoad.setBounds(410, 120, 95, 40);
        this.btLoad.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btLoad);

        tmBaseD.addColumn("#");
        tmBaseD.addColumn("Name");
        tbBaseDate.setModel(tmBaseD);
        scTableScroll.setViewportView(tbBaseDate);
        scTableScroll.setBounds(610, 25, 465, 150); //table
        this.add(scTableScroll);


        /*btLoad.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buttonEventClicked(evt);
            }
        });*/
    }

    private void buttonEventClicked (MouseEvent evt) {
        System.out.println("CLICK");
        if (!tbBaseDate.getSelectionModel().isSelectionEmpty()) {
            String aux = tbBaseDate.getModel().getValueAt(tbBaseDate.getSelectedRow(),0).toString();
            String aux1 = tbBaseDate.getModel().getValueAt(tbBaseDate.getSelectedRow(),1).toString();
            System.out.println("CLICK==>>"+ aux);
            System.out.println("CLICK==>>"+ aux1);

        }
    }
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
    }

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
            System.out.println("Error de Altura de Fila");
        }
    }

    public void addRowTableDb(Integer key,String nameO) {
        tmBaseD.addRow(
                new Object[]{
                    key,nameO
                });
        updateRowHeights();
    }

    public JLabel getLbDataBase() {
        return lbDataBase;
    }

    public void setLbDataBase(JLabel lbDataBase) {
        this.lbDataBase = lbDataBase;
    }

    public JLabel getLbName() {
        return lbName;
    }

    public void setLbName(JLabel lbName) {
        this.lbName = lbName;
    }

    public JLabel getLbImageJalaDb() {
        return lbImageJalaDb;
    }

    public void setLbImageJalaDb(JLabel lbImageJalaDb) {
        this.lbImageJalaDb = lbImageJalaDb;
    }

    public JTextField getTxBdata() {
        return txBdata;
    }

    public void setTxBdata(JTextField txBdata) {
        this.txBdata = txBdata;
    }

    public JButton getBtSave() {
        return btSave;
    }

    public void setBtSave(JButton btSave) {
        this.btSave = btSave;
    }

    public JButton getBtLoad() {
        return btLoad;
    }

    public void setBtLoad(JButton btLoad) {
        this.btLoad = btLoad;
    }

    public JTable getTbBaseDate() {
        return tbBaseDate;
    }

    public void setTbBaseDate(JTable tbBaseDate) {
        this.tbBaseDate = tbBaseDate;
    }

    public DefaultTableModel getTmBaseD() {
        return tmBaseD;
    }

    public void setTmBaseD(DefaultTableModel tmBaseD) {
        this.tmBaseD = tmBaseD;
    }

    public JScrollPane getScTableScroll() {
        return scTableScroll;
    }

    public void setScTableScroll(JScrollPane scTableScroll) {
        this.scTableScroll = scTableScroll;
    }


}
