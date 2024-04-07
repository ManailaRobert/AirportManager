package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AirportManagerGame extends JFrame {

    JPanel LeftPanel = new JPanel(new GridLayout(2,1));
    JPanel CenterPanel = new JPanel(new GridBagLayout());
    JPanel LB_AwaitingPlanesPanel = new JPanel();
    JList LB_AwaitingPlanes = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    JPanel LB_DetailsPanel = new JPanel();
    JList  LB_Details = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    JPanel topUI = new JPanel(new GridLayout(1,7));
    JLabel Label_Money = new JLabel("Money: ");
    JLabel Label_AwaitingPasagers = new JLabel("Awaiting Pasagers");
    JLabel Label_FuelHandlers = new JLabel("Fuel Handlers: 0/10");
    JLabel Label_BagageHandlers = new JLabel("Bagage Handlers: 0/10");
    JButton BTN_ShowAllCrew = new JButton("Crew");
    JButton BTN_ShowShop = new JButton("Shop");
    JLabel Label_Trips= new JLabel("Trips: 343");

    JPanel BTN_ToLanesPanel = new JPanel(new GridLayout(3,1));
    JButton BTN_ToLane1 = new JButton("To lane 1");
    JButton BTN_ToLane2 = new JButton("To lane 2");
    JButton BTN_ToLane3 = new JButton("To lane 3");

    JPanel LB_AvailablePLanesPanel = new JPanel();
    JList  LB_AvailablePLanes = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});
    JPanel LB_SentPlanesPanel = new JPanel();
    JList  LB_SentPLanes = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    JPanel Lane1Space = new JPanel(new GridLayout(2,1));
    JPanel Lane1 = new JPanel(new BorderLayout());

    JTextField Lane1Distance = new JTextField();
    JPanel Lane1Center = new JPanel(new GridLayout(1,2));
    JLabel Lane1PlaneName= new JLabel("Plane 1");
    JButton Lane1Crew = new JButton("Crew");

    JPanel Lane1Bottom = new JPanel(new GridLayout(1,3));
    JLabel Lane1Fuel = new JLabel("Fuel: 100%");
    JLabel Lane1Passagers = new JLabel("Passagers: 34/100");
    JLabel Lane1Status = new JLabel("Status: Bording");



    public AirportManagerGame(){
        super("Airport Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        BorderLayout mainGBY = new BorderLayout(7,7);
        setLayout(mainGBY);

        addConstraints();
        decorateUI();
        addUI();
        setVisible(true);
    }



    private void addConstraints(){
    LB_Details.setEnabled(false);
    }

    private void decorateUI(){
        Font f = new Font("Times New Roman",Font.BOLD,14);
        //Awaiting planes
        LB_AwaitingPlanes.setBackground(Color.LIGHT_GRAY);
        LB_AwaitingPlanes.setPreferredSize(new Dimension(200,250));
        // Details
        LB_Details.setBackground(Color.LIGHT_GRAY);
        LB_Details.setPreferredSize(new Dimension(200,250));
        //Top UI
        topUI.setBackground(Color.BLUE);
        //Money
        Label_Money.setFont(f);
        Label_Money.setForeground(Color.WHITE);
        //Awaiting Passagers
        Label_AwaitingPasagers.setFont(f);
        Label_AwaitingPasagers.setForeground(Color.WHITE);
        // Fuel Handlers
        Label_FuelHandlers.setFont(f);
        Label_FuelHandlers.setForeground(Color.WHITE);
        //Bagage Handlers
        Label_BagageHandlers.setFont(f);
        Label_BagageHandlers.setForeground(Color.WHITE);
        //All Crew
        BTN_ShowAllCrew.setFont(f);
        BTN_ShowAllCrew.setForeground(Color.WHITE);
        BTN_ShowAllCrew.setBackground(Color.BLUE);
        //Shop
        BTN_ShowShop.setFont(f);
        BTN_ShowShop.setForeground(Color.WHITE);
        BTN_ShowShop.setBackground(Color.BLUE);
        //Total Trips
        Label_Trips.setFont(f);
        Label_Trips.setForeground(Color.WHITE);
        //BTN To Lanes
        BTN_ToLane1.setFont(f);

        BTN_ToLane1.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane1.setForeground(Color.black);
        BTN_ToLane1.setPreferredSize(new Dimension(100,20));

        BTN_ToLane2.setFont(f);
        BTN_ToLane2.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane2.setForeground(Color.black);
        BTN_ToLane2.setPreferredSize(new Dimension(100,20));

        BTN_ToLane3.setFont(f);
        BTN_ToLane3.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane3.setForeground(Color.black);
        BTN_ToLane3.setPreferredSize(new Dimension(100,20));

        // available planes
        LB_AvailablePLanes.setBackground(Color.LIGHT_GRAY);
        LB_AvailablePLanes.setPreferredSize(new Dimension(200,125));

        // sent planes
        LB_SentPLanes.setBackground(Color.LIGHT_GRAY);
        LB_SentPLanes.setPreferredSize(new Dimension(200,125));

        //Lane 1
        Lane1.setBackground(Color.LIGHT_GRAY);
    }
    private void addUI(){

        //Top UI
        topUI.add(Label_Money);
        topUI.add(Label_AwaitingPasagers);
        topUI.add(Label_FuelHandlers);
        topUI.add(Label_BagageHandlers);
        topUI.add(BTN_ShowAllCrew);
        topUI.add(BTN_ShowShop);
        topUI.add(Label_Trips);
        add(topUI,BorderLayout.NORTH);

        //-------------- Left panel --------------
        //LB Awaiting Planes
        LB_AwaitingPlanesPanel.add(new JScrollPane(LB_AwaitingPlanes));
        LeftPanel.add(LB_AwaitingPlanesPanel);
        //Label Details
        LB_DetailsPanel.add(new JScrollPane(LB_Details));
        LeftPanel.add(LB_DetailsPanel);
        add(LeftPanel,BorderLayout.WEST);

        // -------------- Center Panel -------------
        GridBagConstraints position = new GridBagConstraints();
        position.insets = new Insets(15,15,15,15);
        CenterPanel.setLayout(new GridBagLayout());
        //To lane Buttons
        BTN_ToLanesPanel.add(BTN_ToLane1);
        BTN_ToLanesPanel.add(BTN_ToLane2);
        BTN_ToLanesPanel.add(BTN_ToLane3);
        position.gridx =0; position.gridy =0;
        CenterPanel.add(BTN_ToLanesPanel,position);

        //available planes
        LB_AvailablePLanesPanel.add(new JScrollPane(LB_AvailablePLanes));
        position.gridx =0; position.gridy =1;
        CenterPanel.add(LB_AvailablePLanesPanel,position);

        //Sent planes
        LB_SentPlanesPanel.add( new JScrollPane(LB_SentPLanes));
        position.gridx = 0; position.gridy=2;
        CenterPanel.add(LB_SentPlanesPanel,position);


        //lane 1

        Lane1Center.add(Lane1PlaneName);
        Lane1Center.add(Lane1Crew);
        Lane1.add(Lane1Center,BorderLayout.CENTER);
        Lane1Bottom.add(Lane1Fuel);
        Lane1Bottom.add(Lane1Passagers);
        Lane1Bottom.add(Lane1Status);
        Lane1.add(Lane1Bottom,BorderLayout.SOUTH);

        Lane1Space.add(Lane1,BorderLayout.CENTER);
        Lane1Space.add(Lane1Distance,BorderLayout.SOUTH);

        position.gridx = 1; position.gridy = 0;
        CenterPanel.add(Lane1Space,position);
        add(CenterPanel,BorderLayout.CENTER);
    }
}
