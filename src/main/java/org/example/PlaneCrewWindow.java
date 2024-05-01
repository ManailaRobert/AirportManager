package org.example;

import javax.swing.*;
import java.awt.*;

public class PlaneCrewWindow extends JFrame{

    //left
    JPanel Left = new JPanel();
    // Available Crew
    JLabel CrewText =new JLabel("Available Crew");
    JPanel ListCrewPanel = new JPanel();
    JList LB_Crew = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});


    //right
    JPanel Right = new JPanel();

    //Pilot
    JPanel PilotPanel = new JPanel();
    JButton BTN_RemovePilot = new JButton("-");
    JLabel PilotText = new JLabel("Pilot: ");
    JLabel Label_Pilot = new JLabel("Pilot 1");

    //Flight Atendents
    JPanel  FlightAtendentsArea = new JPanel();
    JButton BTN_RemoveFlightAtendent = new JButton("Remove Flight Atendent");

    JPanel FlightAtendentsPanel = new JPanel();
    JLabel FlightAtendentsText = new JLabel("Flight Atendents 0/3");
    JPanel FlightAtendentsListPanel = new JPanel();
    JList   LB_FlightAtendents = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});


    //Buttons
    JPanel ButtonsPanel = new JPanel();
    JButton BTN_Assign = new JButton("Assign");
    JButton BTN_Save = new JButton("Save");

    Plane CurentPlane;
    Game Game;
    AirportManagerGame MainWindow;
    public  PlaneCrewWindow(Plane plane,Game game,AirportManagerGame mainWindow){
        super("CrewWindow");
        CurentPlane = plane;
        Game= game;
        MainWindow = mainWindow;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(700,350);
        setResizable(false);
        GridLayout layout = new GridLayout(1,2);
        setLayout(layout);

        decorateUI();
        addUI();

        setVisible(true);
    }

    private void decorateUI() {
        Font f = new Font("Times New Roman",Font.BOLD,14);

        CrewText.setFont(f);
        LB_Crew.setFont(f);

        PilotText.setFont(f);
        Label_Pilot.setFont(f);

        FlightAtendentsText.setFont(f);
        LB_FlightAtendents.setFont(f);

        //buttons
        BTN_RemovePilot.setFont(f);
        BTN_RemovePilot.setFocusPainted(false);
        BTN_RemovePilot.setBackground(Color.LIGHT_GRAY);
        BTN_RemovePilot.setForeground(Color.black);

        BTN_RemoveFlightAtendent.setFont(f);
        BTN_RemoveFlightAtendent.setFocusPainted(false);
        BTN_RemoveFlightAtendent.setBackground(Color.LIGHT_GRAY);
        BTN_RemoveFlightAtendent.setForeground(Color.black);

        BTN_Assign.setFont(f);
        BTN_Assign.setFocusPainted(false);
        BTN_Assign.setBackground(Color.LIGHT_GRAY);
        BTN_Assign.setForeground(Color.black);

        BTN_Save.setFont(f);
        BTN_Save.setFocusPainted(false);
        BTN_Save.setBackground(Color.LIGHT_GRAY);
        BTN_Save.setForeground(Color.black);

        FlightAtendentsPanel.setPreferredSize(new Dimension(200,200));

    }
    private void addUI() {

        //left
        Left.setLayout(new BoxLayout(Left,BoxLayout.Y_AXIS));
        Left.add(CrewText);
        ListCrewPanel.setLayout(new BoxLayout(ListCrewPanel,BoxLayout.Y_AXIS));
        ListCrewPanel.add(new JScrollPane(LB_Crew));
        Left.add(ListCrewPanel);


        //Pilot area

        PilotPanel.add(BTN_RemovePilot);
        PilotPanel.add(PilotText);
        PilotPanel.add(Label_Pilot);
        // Flight Atendents area

        FlightAtendentsPanel.setLayout(new BoxLayout(FlightAtendentsPanel,BoxLayout.Y_AXIS));
        FlightAtendentsPanel.add(FlightAtendentsText);

        FlightAtendentsListPanel.setLayout(new BoxLayout(FlightAtendentsListPanel,BoxLayout.Y_AXIS));
        FlightAtendentsListPanel.add(new JScrollPane(LB_FlightAtendents));
        FlightAtendentsPanel.add(FlightAtendentsListPanel);

        FlightAtendentsPanel.add(BTN_RemoveFlightAtendent);
        FlightAtendentsArea.add(FlightAtendentsPanel);

        //buttons panel

        ButtonsPanel.add(BTN_Assign);
        ButtonsPanel.add(BTN_Save);

        //right
        Right.setLayout(new BoxLayout(Right,BoxLayout.Y_AXIS));
        Right.add(PilotPanel);
        Right.add(FlightAtendentsArea);
        Right.add(ButtonsPanel);


        add(Left);
        add(Right);
    }


}
