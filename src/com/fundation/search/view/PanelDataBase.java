package com.fundation.search.view;

import com.fundation.search.view.util.Constantes;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    private JButton btSeve;
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

        btSeve.setText("Save");
        btSeve.setBounds(300, 120, 95, 40);
        this.btSeve.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.add(btSeve);

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
    }
    public void initComponents() {

        lbDataBase = new JLabel();
        lbName = new JLabel();
        txBdata = new JTextField();
        btSeve = new JButton();
        btLoad = new JButton();
        tbBaseDate = new JTable();
        tmBaseD = new DefaultTableModel();
        scTableScroll = new JScrollPane();
        lbImageJalaDb = new JLabel();
    }
}
