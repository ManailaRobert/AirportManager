package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;

public class PlaneCrewWindow extends JFrame{


    JLabel Label_Plane =new JLabel("Plane name");
    JPanel Top = new JPanel();
    JPanel Center = new JPanel();
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
    JLabel Label_Pilot = new JLabel("----");

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


    Plane CurentPlane;

    Game Game;
    AirportManagerGame MainWindow;
    DefaultListModel<Crew> AvailableCrewModel = new DefaultListModel<>();
    DefaultListModel<Crew> FlightAtendentsModel = new DefaultListModel<>();
    public  PlaneCrewWindow(Plane plane,Game game,AirportManagerGame mainWindow,int lane){
        super("CrewWindow");
        CurentPlane = plane;
        Game= game;
        MainWindow = mainWindow;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(700,350);
        setResizable(false);
        BorderLayout layout = new BorderLayout(5,2);
        setLayout(layout);

        decorateUI();
        addUI();
        addEvents();
        loadUI();
        LB_Crew.setModel(AvailableCrewModel);
        LB_FlightAtendents.setModel(FlightAtendentsModel);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainWindow.verifyDepart(lane,CurentPlane);
            }
        });
    }
    private void loadUI(){
        loadCrewList();
        loadPlaneData();
        MainWindow.UpdateTopUI();
    }
    private void  loadPlaneData(){
        Label_Plane.setText(CurentPlane.toString());
        if(CurentPlane.GetPilot() != null){
            Label_Pilot.setText(CurentPlane.GetPilot().getName());
        }else Label_Pilot.setText("----");

        FlightAtendentsModel.clear();
        if(CurentPlane.GetFlightAtendentList().size()!=0)
        {
            for(FlightAtendent flightAtendent:CurentPlane.GetFlightAtendentList())
                FlightAtendentsModel.addElement(flightAtendent);
        }
        FlightAtendentsText.setText(MessageFormat.format("Flight Atendents: {0}/{1}",CurentPlane.GetFlightAtendentList().size(),CurentPlane.GetMaxFlightAtendents()));
    }
    private void loadCrewList(){
        AvailableCrewModel.clear();
        for(Crew crew:Game.CrewList.GetAvailableFlightCrew())
            AvailableCrewModel.addElement(crew);
    }
    private void assignCrew(){
        if(LB_Crew.getSelectedValue()!=null){
            Crew crew = (Crew) LB_Crew.getSelectedValue();
            if(crew instanceof Pilot)
            {
                if(CurentPlane.GetPilot() != null)
                    CurentPlane.GetPilot().setAssignedPlane(null);
                CurentPlane.SetPilot((Pilot) crew);
                crew.setAssignedPlane(CurentPlane);
                loadUI();
            }else if(CurentPlane.GetFlightAtendentList().size()<CurentPlane.GetMaxFlightAtendents())
            {
                CurentPlane.GetFlightAtendentList().add((FlightAtendent) crew);
                crew.setAssignedPlane(CurentPlane);
                loadUI();
            }

        }
    }
    private void addEvents(){
        LB_Crew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()== 2)
                    assignCrew();
            }
        });

        LB_FlightAtendents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()== 2)
                {
                    if(LB_FlightAtendents.getSelectedValue()!=null){
                        FlightAtendent flightAtendent = (FlightAtendent) LB_FlightAtendents.getSelectedValue();
                        flightAtendent.setAssignedPlane(null);
                        CurentPlane.GetFlightAtendentList().remove(flightAtendent);
                        loadUI();
                    }
                }
            }
        });
        BTN_Assign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignCrew();
            }
        });
        BTN_RemovePilot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CurentPlane.GetPilot()!=null){
                    CurentPlane.RemovePilot();
                    loadUI();
                }
            }
        });

        BTN_RemoveFlightAtendent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LB_FlightAtendents.getSelectedValue()!=null){
                    FlightAtendent flightAtendent = (FlightAtendent) LB_FlightAtendents.getSelectedValue();
                    flightAtendent.setAssignedPlane(null);
                    CurentPlane.GetFlightAtendentList().remove(flightAtendent);
                    loadUI();
                }
            }
        });

    }
    private void decorateUI() {
        Font f = new Font("Times New Roman",Font.BOLD,14);

        Label_Plane.setFont(f);
        Label_Plane.setHorizontalAlignment(SwingConstants.CENTER);
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

        //right
        Right.setLayout(new BoxLayout(Right,BoxLayout.Y_AXIS));
        Right.add(PilotPanel);
        Right.add(FlightAtendentsArea);
        Right.add(ButtonsPanel);


        Center.setLayout(new GridLayout(1,2));
        Center.add(Left);
        Center.add(Right);

        add(Label_Plane,BorderLayout.NORTH);
        add(Center,BorderLayout.CENTER);
    }


}
