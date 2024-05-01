package org.example;

import javax.swing.*;
import java.awt.*;

public class AllCrewWindow extends JFrame {

    JPanel Top = new JPanel();
    JPanel AvailableCrewPanel = new JPanel();
    JLabel Label_AvailableCrew = new JLabel("Available crew:");
    JTable AvailableCrewTabel = new JTable(10,5);

    JPanel Bottom = new JPanel();
    JPanel DispatchedCrewPanel = new JPanel();
    JLabel Label_DispatchedCrew = new JLabel("Dispatched crew:");
    JTable DispatchedCrewTable = new JTable(10,5);

    Game Game;
    AirportManagerGame MainWindow;
    public  AllCrewWindow(Game game,AirportManagerGame mainWindow){
        super("CrewWindow");
        Game = game;
        MainWindow = mainWindow;
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
        AvailableCrewTabel.setEnabled(false);
        AvailableCrewTabel.setAutoResizeMode(5);
        AvailableCrewTabel.getTableHeader().setResizingAllowed(false);
        AvailableCrewTabel.getTableHeader().setReorderingAllowed(false);

        Label_DispatchedCrew.setFont(f);
        DispatchedCrewTable.setFont(f);
        DispatchedCrewTable.setBackground(Color.LIGHT_GRAY);
        DispatchedCrewTable.setEnabled(false);
        DispatchedCrewTable.setAutoResizeMode(5);
        DispatchedCrewTable.getTableHeader().setResizingAllowed(false);
        DispatchedCrewTable.getTableHeader().setReorderingAllowed(false);
    }

    private void addUI() {


        Top.setLayout(new BoxLayout(Top,BoxLayout.Y_AXIS));

        Top.add(Label_AvailableCrew);
        AvailableCrewPanel.add(new JScrollPane(AvailableCrewTabel));
        Top.add(AvailableCrewPanel);


        Bottom.setLayout(new BoxLayout(Bottom,BoxLayout.Y_AXIS));

        Bottom.add(Label_DispatchedCrew);
        DispatchedCrewPanel.add(new JScrollPane(DispatchedCrewTable));
        Bottom.add(DispatchedCrewPanel);

        add(Top);
        add(Bottom);
    }
}
