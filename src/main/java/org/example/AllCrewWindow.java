package org.example;

import javax.swing.*;
import java.awt.*;

public class AllCrewWindow extends JFrame {

    JPanel AvailableCrewPanel = new JPanel();
    JLabel Label_AvailableCrew = new JLabel("Available crew:");
    JTable AvailableCrewTabel = new JTable();

    JPanel DispatchedCrewPanel = new JPanel();
    JLabel Label_DispatchedCrew = new JLabel("Dispatched crew:");
    JTable DispatchedCrewTable = new JTable();


    public  AllCrewWindow(){
        super("CrewWindow");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(900,500);
        setResizable(false);
        GridLayout layout = new GridLayout(2,1);
        setLayout(layout);

        decorateUI();
        addUI();

        setVisible(true);
    }

    private void decorateUI() {
        Font f = new Font("Times New Roman",Font.BOLD,14);

        Label_AvailableCrew.setFont(f);
        AvailableCrewTabel.setFont(f);
        AvailableCrewTabel.setBackground(Color.LIGHT_GRAY);

        Label_DispatchedCrew.setFont(f);
        DispatchedCrewTable.setFont(f);
        DispatchedCrewTable.setBackground(Color.LIGHT_GRAY);
    }

    private void addUI() {


    }
}
