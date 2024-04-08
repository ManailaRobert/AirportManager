package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.MessageFormat;

public class AirportManagerGame extends JFrame {

    //JPanel LeftPanel = new JPanel(new GridLayout(2,1));
    JPanel CenterPanel = new JPanel(new GridBagLayout());
    JPanel LB_AwaitingPlanesPanel = new JPanel();
    JList LB_AwaitingPlanes = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    JPanel LB_DetailsPanel = new JPanel();
    JList  LB_Details = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    //top UI
    JPanel topUI = new JPanel(new GridLayout(1,7));
    JLabel Label_Money = new JLabel("Money: ");
    JLabel Label_AwaitingPasagers = new JLabel("Awaiting Pasagers");
    JLabel Label_FuelHandlers = new JLabel("Fuel Handlers: 0/10");
    JLabel Label_BagageHandlers = new JLabel("Bagage Handlers: 0/10");
    JButton BTN_ShowAllCrew = new JButton("Crew");
    JButton BTN_ShowShop = new JButton("Shop");
    JLabel Label_Trips= new JLabel("Trips: 343");

    // to lanes buttons
    JPanel BTN_ToLanesPanel = new JPanel(new GridLayout(4,1));
    JLabel Label_ToLanesDetails = new JLabel("Select a lane.");
    JButton BTN_ToLane1 = new JButton("To lane 1");
    JButton BTN_ToLane2 = new JButton("To lane 2");
    JButton BTN_ToLane3 = new JButton("To lane 3");

    // available planes
    JPanel AvailablePlanesPanel = new JPanel(new GridLayout(2,1));
    JLabel Label_AvailablePlanes = new JLabel("Available planes");
    JList  LB_AvailablePLanes = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    //sent planes
    JPanel SentPlanesPanel = new JPanel(new GridLayout(2,1));
    JLabel Label_SentPlanes = new JLabel("Enroute planes");
    JScrollPane SentPlanesScroll= new JScrollPane(); //-----------------------------------------------------------------------------------------> Scroll pane
    JList  LB_SentPLanes = new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});

    //lane 1
    JPanel Lane1Space = new JPanel(new GridLayout(3,1));
    JPanel Lane1 = new JPanel(new BorderLayout());
    JPanel Lane1Center = new JPanel();
    JLabel Label_Lane1 = new JLabel("Lane 1");
    JComboBox Lane1Distance = new JComboBox();
    JPanel Lane1DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane1DistanceLabel = new JLabel("Distance:");
    JPanel Lane1Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane1PlaneName= new JLabel("Plane 1");
    JButton BTN_Lane1Crew  = new JButton("Crew");
    JPanel Lane1Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane1Fuel = new JLabel("Fuel: 100%");
    JLabel Label_Lane1Passagers = new JLabel("Passagers: 34/100");
    JLabel Label_Lane1Status = new JLabel("  Status: Bording");

    //lane 2
    JPanel Lane2Space = new JPanel(new GridLayout(3,1));
    JPanel Lane2 = new JPanel(new BorderLayout());
    JPanel Lane2Center = new JPanel();
    JLabel Label_Lane2 = new JLabel("Lane 2");
    JComboBox Lane2Distance = new JComboBox();
    JPanel Lane2DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane2DistanceLabel = new JLabel("Distance:");
    JPanel Lane2Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane2PlaneName= new JLabel("Plane 2");
    JButton BTN_Lane2Crew = new JButton("Crew");
    JPanel Lane2Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane2Fuel = new JLabel("Fuel: 100%");
    JLabel Label_Lane2Passagers = new JLabel("Passagers: 34/100");
    JLabel Label_Lane2Status = new JLabel("  Status: Bording");

    //lane 3
    JPanel Lane3Space = new JPanel(new GridLayout(3,1));
    JPanel Lane3 = new JPanel(new BorderLayout());
    JPanel Lane3Center = new JPanel();
    JLabel Label_Lane3 = new JLabel("Lane 3");
    JComboBox Lane3Distance = new JComboBox();
    JPanel Lane3DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane3DistanceLabel = new JLabel("Distance:");
    JPanel Lane3Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane3PlaneName= new JLabel("Plane 3");
    JButton BTN_Lane3Crew = new JButton("Crew");
    JPanel Lane3Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane3Fuel = new JLabel("Fuel: 100%");
    JLabel Label_Lane3Passagers = new JLabel("Passagers: 34/100");
    JLabel Label_Lane3Status = new JLabel("  Status: Bording");

    //lane 1 buttons
    JPanel EmptyPanel = new JPanel();
    JPanel Lane1Buttons = new JPanel(new GridLayout(4,1));
    JPanel Lane1LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1RevenuePanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane1Load = new JButton("Load Bagages");
    JButton BTN_Lane1Board = new JButton("Board Passagers");
    JButton BTN_Lane1Refuel = new JButton("Refuel");
    JLabel Lane1Revenue = new JLabel("Revenue: ");
    //lane 1 Requirements
    JLabel Lane1BagageH = new JLabel("BagageHandlers: ");
    JLabel Lane1FuelH = new JLabel("FuelHandlers: ");
    JLabel Lane1RefuelPrice = new JLabel("Refuel Price:");

    //lane 2 buttons
    JPanel Lane2Buttons = new JPanel(new GridLayout(4,1));
    JPanel Lane2LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2RevenuePanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane2Load = new JButton("Load Bagages");
    JButton BTN_Lane2Board = new JButton("Board Passagers");
    JButton BTN_Lane2Refuel = new JButton("Refuel");
    JLabel Lane2Revenue = new JLabel("Revenue: ");
    //lane 2 Requirements
    JLabel Lane2BagageH = new JLabel("BagageHandlers: ");
    JLabel Lane2FuelH = new JLabel("FuelHandlers: ");
    JLabel Lane2RefuelPrice = new JLabel("Refuel Price:");

    //lane 3 buttons
    JPanel Lane3Buttons = new JPanel(new GridLayout(4,1));
    JPanel Lane3LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3RevenuePanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane3Load = new JButton("Load Bagages");
    JButton BTN_Lane3Board = new JButton("Board Passagers");
    JButton BTN_Lane3Refuel = new JButton("Refuel");
    JLabel Lane3Revenue = new JLabel("Revenue: ");
    //lane 3 Requirements
    JLabel Lane3BagageH = new JLabel("BagageHandlers: ");
    JLabel Lane3FuelH = new JLabel("FuelHandlers: ");
    JLabel Lane3RefuelPrice = new JLabel("Refuel Price:");


    public AirportManagerGame(){
        super("Airport Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,700);
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
        LB_AwaitingPlanes.setPreferredSize(new Dimension(300,350));
        LB_AwaitingPlanesPanel.setPreferredSize(new Dimension(300,350));
        LB_AwaitingPlanesPanel.setBackground(Color.PINK);
        // Details
        LB_Details.setBackground(Color.LIGHT_GRAY);
        LB_Details.setPreferredSize(new Dimension(300,250));
        LB_DetailsPanel.setBackground(Color.PINK);
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
        BTN_ShowAllCrew.setFocusPainted(false);
        BTN_ShowAllCrew.setFont(f);
        BTN_ShowAllCrew.setForeground(Color.WHITE);
        BTN_ShowAllCrew.setBackground(Color.BLUE);
        //Shop
        BTN_ShowShop.setFont(f);
        BTN_ShowShop.setFocusPainted(false);
        BTN_ShowShop.setForeground(Color.WHITE);
        BTN_ShowShop.setBackground(Color.BLUE);
        //Total Trips
        Label_Trips.setFont(f);
        Label_Trips.setForeground(Color.WHITE);
        //BTN To Lanes
        Label_ToLanesDetails.setFont(f);
        Label_ToLanesDetails.setBorder(new EmptyBorder(0,0,0,0));
        BTN_ToLanesPanel.setPreferredSize(new Dimension(200,100));
        BTN_ToLanesPanel.setBackground(Color.PINK);

        BTN_ToLane1.setFont(f);
        BTN_ToLane1.setFocusPainted(false);
        BTN_ToLane1.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane1.setForeground(Color.black);
        BTN_ToLane1.setPreferredSize(new Dimension(100,20));

        BTN_ToLane2.setFont(f);
        BTN_ToLane2.setFocusPainted(false);
        BTN_ToLane2.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane2.setForeground(Color.black);
        BTN_ToLane2.setPreferredSize(new Dimension(100,20));

        BTN_ToLane3.setFont(f);
        BTN_ToLane3.setFocusPainted(false);
        BTN_ToLane3.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane3.setForeground(Color.black);
        BTN_ToLane3.setPreferredSize(new Dimension(100,20));

        // available planes
        Label_AvailablePlanes.setFont(f);
        LB_AvailablePLanes.setBackground(Color.LIGHT_GRAY);
        LB_AvailablePLanes.setFont(f);
        Label_AvailablePlanes.setBorder(new EmptyBorder(0,0,0,0));
        AvailablePlanesPanel.setBorder(new EmptyBorder(0,0,0,0));
        AvailablePlanesPanel.setPreferredSize(new Dimension(300,175));
        AvailablePlanesPanel.setBackground(Color.PINK);

        // sent planes
        Label_SentPlanes.setFont(f);
        LB_SentPLanes.setBackground(Color.LIGHT_GRAY);
        LB_SentPLanes.setFont(f);
        Label_SentPlanes.setBorder(new EmptyBorder(0,0,0,0));
        SentPlanesPanel.setBorder(new EmptyBorder(0,0,0,0));
        SentPlanesPanel.setPreferredSize(new Dimension(300,175));
        SentPlanesPanel.setBackground(Color.PINK);

        //Lane 1
        Lane1Space.setBackground(Color.PINK);
        Lane1Top.setBackground(Color.LIGHT_GRAY);
        Lane1Center.setBackground(Color.LIGHT_GRAY);
        Lane1Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane1Crew .setPreferredSize(new Dimension(10,10));
        BTN_Lane1Crew.setFocusPainted(false);
        Lane1Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane1DistanceLabel.setFont(f);

        //lane 2
        Lane2Space.setBackground(Color.PINK);
        Lane2Top.setBackground(Color.LIGHT_GRAY);
        Lane2Center.setBackground(Color.LIGHT_GRAY);
        Lane2Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane2Crew.setPreferredSize(new Dimension(10,10));
        BTN_Lane2Crew.setFocusPainted(false);
        Lane2Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane2DistanceLabel.setFont(f);

        //lane 3
        Lane3Space.setBackground(Color.PINK);
        Lane3Top.setBackground(Color.LIGHT_GRAY);
        Lane3Center.setBackground(Color.LIGHT_GRAY);
        Lane3Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane3Crew.setPreferredSize(new Dimension(10,10));
        BTN_Lane3Crew.setFocusPainted(false);
        Lane3Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane3DistanceLabel.setFont(f);

        //Lane 1 buttons + Requirements
        Lane1Buttons.setBackground(Color.PINK);
        BTN_Lane1Load.setFont(f);
        BTN_Lane1Board.setFont(f);
        BTN_Lane1Refuel.setFont(f);

        BTN_Lane1Load.setFocusPainted(false);
        BTN_Lane1Board.setFocusPainted(false);
        BTN_Lane1Refuel.setFocusPainted(false);
        Lane1Revenue.setFont(f);

        Lane1BagageH.setFont(f);
        Lane1FuelH.setFont(f);
        Lane1RefuelPrice.setFont(f);

        //Lane 2 Buttons + Requirements
        Lane2Buttons.setBackground(Color.PINK);
        BTN_Lane2Load.setFont(f);
        BTN_Lane2Board.setFont(f);
        BTN_Lane2Refuel.setFont(f);

        BTN_Lane2Load.setFocusPainted(false);
        BTN_Lane2Board.setFocusPainted(false);
        BTN_Lane2Refuel.setFocusPainted(false);

        Lane2Revenue.setFont(f);
        Lane2BagageH.setFont(f);
        Lane2FuelH.setFont(f);
        Lane2RefuelPrice.setFont(f);

        //Lane 3 buttons + Requirements
        Lane3Buttons.setBackground(Color.PINK);
        BTN_Lane3Load.setFont(f);
        BTN_Lane3Board.setFont(f);
        BTN_Lane3Refuel.setFont(f);

        BTN_Lane3Load.setFocusPainted(false);
        BTN_Lane3Board.setFocusPainted(false);
        BTN_Lane3Refuel.setFocusPainted(false);

        Lane3Revenue.setFont(f);
        Lane3BagageH.setFont(f);
        Lane3FuelH.setFont(f);
        Lane3RefuelPrice.setFont(f);

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

        GridBagConstraints position = new GridBagConstraints();
        position.fill = GridBagConstraints.BOTH;
        position.insets = new Insets(15,15,15,15);
        // -------------- Center Panel -------------

        //LB Awaiting Planes
        LB_AwaitingPlanesPanel.add(new JScrollPane(LB_AwaitingPlanes));
        position.gridx = 0;position.gridy = 0; position.gridheight = 2;
        CenterPanel.add(LB_AwaitingPlanesPanel,position);

        //Label Details
        position.gridx = 0;position.gridy = 2;position.gridheight = 1;
        LB_DetailsPanel.add(new JScrollPane(LB_Details));
        CenterPanel.add(LB_DetailsPanel,position);

        //To lane Buttons
        BTN_ToLanesPanel.add(Label_ToLanesDetails);
        BTN_ToLanesPanel.add(BTN_ToLane1);
        BTN_ToLanesPanel.add(BTN_ToLane2);
        BTN_ToLanesPanel.add(BTN_ToLane3);
        position.gridx =1; position.gridy =0;
        CenterPanel.add(BTN_ToLanesPanel,position);

        //available planes
        AvailablePlanesPanel.add(Label_AvailablePlanes);
        AvailablePlanesPanel.add(new JScrollPane(LB_AvailablePLanes));
        position.gridx =1; position.gridy =1;
        CenterPanel.add(AvailablePlanesPanel,position);

        //Sent planes
        SentPlanesPanel.add(Label_SentPlanes);
        SentPlanesScroll.setViewportView(LB_SentPLanes);
        SentPlanesPanel.add(SentPlanesScroll);
        position.gridx = 1; position.gridy=2;
        CenterPanel.add(SentPlanesPanel,position);


        //lane 1
        Lane1Top.add(Label_Lane1PlaneName);
        Lane1Top.add(BTN_Lane1Crew );
        Lane1.add(Lane1Top,BorderLayout.NORTH);
        Lane1Center.add(Label_Lane1);
        Lane1.add(Lane1Center,BorderLayout.CENTER);
        Lane1Bottom.add(Label_Lane1Fuel);
        Lane1Bottom.add(Label_Lane1Passagers);
        Lane1Bottom.add(Label_Lane1Status);
        Lane1.add(Lane1Bottom,BorderLayout.SOUTH);

        Lane1Space.add(EmptyPanel);
        Lane1Space.add(Lane1);
        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane1Distance.addItem(value);
        }
        Lane1DistancePanel.add(Label_Lane1DistanceLabel);
        Lane1DistancePanel.add(Lane1Distance);
        Lane1Space.add(Lane1DistancePanel);

        position.gridx = 2; position.gridy = 0;
        CenterPanel.add(Lane1Space,position);

        //lane 2
        Lane2Top.add(Label_Lane2PlaneName);
        Lane2Top.add(BTN_Lane2Crew);
        Lane2.add(Lane2Top,BorderLayout.NORTH);
        Lane2Center.add(Label_Lane2);
        Lane2.add(Lane2Center,BorderLayout.CENTER);
        Lane2Bottom.add(Label_Lane2Fuel);
        Lane2Bottom.add(Label_Lane2Passagers);
        Lane2Bottom.add(Label_Lane2Status);
        Lane2.add(Lane2Bottom,BorderLayout.SOUTH);

        Lane2Space.add(EmptyPanel);
        Lane2Space.add(Lane2);
        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane2Distance.addItem(value);
        }
        Lane2DistancePanel.add(Label_Lane2DistanceLabel);
        Lane2DistancePanel.add(Lane2Distance);
        Lane2Space.add(Lane2DistancePanel,BorderLayout.SOUTH);

        position.gridx = 2; position.gridy = 1;
        CenterPanel.add(Lane2Space,position);

        //lane 3
        Lane3Top.add(Label_Lane3PlaneName);
        Lane3Top.add(BTN_Lane3Crew);
        Lane3.add(Lane3Top,BorderLayout.NORTH);
        Lane3Center.add(Label_Lane3);
        Lane3.add(Lane3Center,BorderLayout.CENTER);
        Lane3Bottom.add(Label_Lane3Fuel);
        Lane3Bottom.add(Label_Lane3Passagers);
        Lane3Bottom.add(Label_Lane3Status);
        Lane3.add(Lane3Bottom,BorderLayout.SOUTH);

        Lane3Space.add(EmptyPanel);
        Lane3Space.add(Lane3);
        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane3Distance.addItem(value);
        }
        Lane3DistancePanel.add(Label_Lane3DistanceLabel);
        Lane3DistancePanel.add(Lane3Distance);
        Lane3Space.add(Lane3DistancePanel);

        position.gridx = 2; position.gridy = 2;
        CenterPanel.add(Lane3Space,position);


        //lane 1 buttons + Requirements
        Lane1LoadPanel.add(BTN_Lane1Load);
        Lane1LoadPanel.add(Lane1BagageH);
        Lane1Buttons.add(Lane1LoadPanel);

        Lane1BoardPanel.add(BTN_Lane1Board);
        Lane1BoardPanel.add(Lane1FuelH);
        Lane1Buttons.add(Lane1BoardPanel);

        Lane1RefuelPanel.add(BTN_Lane1Refuel);
        Lane1RefuelPanel.add(EmptyPanel);
        Lane1Buttons.add(Lane1RefuelPanel);

        Lane1RevenuePanel.add(Lane1Revenue);
        Lane1RevenuePanel.add(Lane1RefuelPrice);
        Lane1Buttons.add(Lane1RevenuePanel);

        position.gridx = 3; position.gridy = 0;
        CenterPanel.add(Lane1Buttons,position);

        //lane 2 buttons + Requirements
        Lane2LoadPanel.add(BTN_Lane2Load);
        Lane2LoadPanel.add(Lane2BagageH);
        Lane2Buttons.add(Lane2LoadPanel);

        Lane2BoardPanel.add(BTN_Lane2Board);
        Lane2BoardPanel.add(Lane2FuelH);
        Lane2Buttons.add(Lane2BoardPanel);

        Lane2RefuelPanel.add(BTN_Lane2Refuel);
        Lane2RefuelPanel.add(EmptyPanel);
        Lane2Buttons.add(Lane2RefuelPanel);

        Lane2RevenuePanel.add(Lane2Revenue);
        Lane2RevenuePanel.add(Lane2RefuelPrice);
        Lane2Buttons.add(Lane2RevenuePanel);


        position.gridx = 3; position.gridy = 1;
        CenterPanel.add(Lane2Buttons,position);


        //lane 3 buttons + Requirements
        Lane3LoadPanel.add(BTN_Lane3Load);
        Lane3LoadPanel.add(Lane3BagageH);
        Lane3Buttons.add(Lane3LoadPanel);

        Lane3BoardPanel.add(BTN_Lane3Board);
        Lane3BoardPanel.add(Lane3FuelH);
        Lane3Buttons.add(Lane3BoardPanel);

        Lane3RefuelPanel.add(BTN_Lane3Refuel);
        Lane3RefuelPanel.add(EmptyPanel);
        Lane3Buttons.add(Lane3RefuelPanel);

        Lane3RevenuePanel.add(Lane3Revenue);
        Lane3RevenuePanel.add(Lane3RefuelPrice);
        Lane3Buttons.add(Lane3RevenuePanel);


        position.gridx = 3; position.gridy = 2;
        CenterPanel.add(Lane3Buttons,position);

        add(CenterPanel,BorderLayout.CENTER);
    }
}
