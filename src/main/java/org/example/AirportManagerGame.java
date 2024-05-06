package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AirportManagerGame extends JFrame {

    //JPanel LeftPanel = new JPanel(new GridLayout(2,1));
    JPanel CenterPanel = new JPanel(new GridBagLayout());
    JPanel LB_AwaitingPlanesPanel = new JPanel();
    JLabel Label_AwaitingPlanes = new JLabel("Awaiting planes:");
    JList LB_AwaitingPlanes = new JList<>();

    JPanel LB_DetailsPanel = new JPanel();
    JLabel Label_PlaneDetails = new JLabel("Plane details:");
    JTextArea  TB_PlaneDetails = new JTextArea("Plane details");

    //top UI
    JPanel topUI = new JPanel();
    JPanel ResourcesPanel = new JPanel(new GridLayout(1,8));
    JPanel ButtonsPanel = new JPanel();
    JLabel Label_Money = new JLabel("Money: 999999999");
    JLabel Label_AwaitingPasagers = new JLabel("Awaiting Pasagers: 999999999");
    JLabel Label_Pilots = new JLabel("Pilots: 000/100");
    JLabel Label_Planes = new JLabel("Planes: 000/100");
    JLabel Label_FlightAtendents = new JLabel("Flight Atendents: 000/100");
    JLabel Label_FuelHandlers = new JLabel("Fuel Handlers: 000/100");
    JLabel Label_BagageHandlers = new JLabel("Bagage Handlers: 000/100");
    JButton BTN_ShowAllCrew = new JButton("Crew");
    JButton BTN_ShowShop = new JButton("Shop");
    JLabel Label_Trips= new JLabel("Trips: 343");

    // to lanes buttons
    JPanel ToLanesPanel = new JPanel();
    JLabel Label_ToLanesDetails = new JLabel("Select a lane.");
    JButton BTN_ToLane1 = new JButton("Dock to lane 1");
    JButton BTN_ToLane2 = new JButton("Dock to lane 2");
    JButton BTN_ToLane3 = new JButton("Dock to lane 3");

    // Idle planes
    JPanel IdlePlanesPanel = new JPanel(new GridLayout(2,1));
    JLabel Label_IdlePlanes = new JLabel("Idle planes");
    JList  LB_IdlePlanes = new JList<>();

    //sent planes
    JPanel SentPlanesPanel = new JPanel(new GridLayout(2,1));
    JLabel Label_SentPlanes = new JLabel("Enroute planes");
    JList  LB_SentPlanes = new JList<>();

    //lane 1
    JPanel Lane1Space = new JPanel(new GridLayout(3,1));
    JPanel Lane1 = new JPanel(new BorderLayout());
    JPanel Lane1Center = new JPanel();
    JLabel Label_Lane1 = new JLabel("Lane 1");
    JComboBox Lane1Distance = new JComboBox();
    JPanel Lane1DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane1DistanceLabel = new JLabel("Distance:");
    JPanel Lane1Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane1PlaneName= new JLabel("------");
    JButton BTN_Lane1Crew  = new JButton("Crew");
    JPanel Lane1Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane1Fuel = new JLabel("Fuel: 0%");
    JLabel Label_Lane1Passagers = new JLabel("Passagers: 0/0");
    JLabel Label_Lane1Status = new JLabel("  Status: ---");

    //lane 2
    JPanel Lane2Space = new JPanel(new GridLayout(3,1));
    JPanel Lane2 = new JPanel(new BorderLayout());
    JPanel Lane2Center = new JPanel();
    JLabel Label_Lane2 = new JLabel("Lane 2");
    JComboBox Lane2Distance = new JComboBox();
    JPanel Lane2DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane2DistanceLabel = new JLabel("Distance:");
    JPanel Lane2Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane2PlaneName= new JLabel("------");
    JButton BTN_Lane2Crew = new JButton("Crew");
    JPanel Lane2Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane2Fuel = new JLabel("Fuel: 0%");
    JLabel Label_Lane2Passagers = new JLabel("Passagers: 0/0");
    JLabel Label_Lane2Status = new JLabel("  Status: ---");

    //lane 3
    JPanel Lane3Space = new JPanel(new GridLayout(3,1));
    JPanel Lane3 = new JPanel(new BorderLayout());
    JPanel Lane3Center = new JPanel();
    JLabel Label_Lane3 = new JLabel("Lane 3");
    JComboBox Lane3Distance = new JComboBox();
    JPanel Lane3DistancePanel = new JPanel(new FlowLayout());
    JLabel Label_Lane3DistanceLabel = new JLabel("Distance:");
    JPanel Lane3Top = new JPanel(new GridLayout(1,2));
    JLabel Label_Lane3PlaneName= new JLabel("------");
    JButton BTN_Lane3Crew = new JButton("Crew");
    JPanel Lane3Bottom = new JPanel(new GridLayout(1,3));
    JLabel Label_Lane3Fuel = new JLabel("Fuel: 0%");
    JLabel Label_Lane3Passagers = new JLabel("Passagers: 0/0");
    JLabel Label_Lane3Status = new JLabel("  Status: ---");

    //lane 1 buttons
    JPanel Lane1Buttons = new JPanel(new GridLayout(5,1));
    JPanel Lane1LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1RevenuePanel = new JPanel(new GridLayout(1,2));
    JPanel Lane1DepartPanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane1Load = new JButton("Load Bagages");
    JButton BTN_Lane1Board = new JButton("Board Passagers");
    JButton BTN_Lane1Refuel = new JButton("Refuel");
    JLabel Label_Lane1Revenue = new JLabel("Revenue: ---");
    //lane 1 Requirements
    JLabel Lane1BagageH = new JLabel("Bagage Handlers: ---");
    JLabel Lane1FuelH = new JLabel("Fuel Handlers: ---");
    JLabel Lane1RefuelPrice = new JLabel("Refuel Price: ---");
    JButton BTN_Lane1Depart = new JButton("Depart");
    JLabel Label_Lane1Error = new JLabel();
    JLabel Label_Lane1DepartTime = new JLabel("Time: ---");

    //lane 2 buttons
    JPanel Lane2Buttons = new JPanel(new GridLayout(5,1));
    JPanel Lane2LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2RevenuePanel = new JPanel(new GridLayout(1,2));
    JPanel Lane2DepartPanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane2Load = new JButton("Load Bagages");
    JButton BTN_Lane2Board = new JButton("Board Passagers");
    JButton BTN_Lane2Refuel = new JButton("Refuel");
    JLabel Label_Lane2Revenue = new JLabel("Revenue: ---");
    //lane 2 Requirements
    JLabel Lane2BagageH = new JLabel("Bagage Handlers: ---");
    JLabel Lane2FuelH = new JLabel("Fuel Handlers: ---");
    JLabel Lane2RefuelPrice = new JLabel("Refuel Price: ---");
    JButton BTN_Lane2Depart = new JButton("Depart");
    JLabel Label_Lane2Error = new JLabel();
    JLabel Label_Lane2DepartTime = new JLabel("Time: ---");

    //lane 3 buttons
    JPanel Lane3Buttons = new JPanel(new GridLayout(5,1));
    JPanel Lane3LoadPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3BoardPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3RefuelPanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3RevenuePanel = new JPanel(new GridLayout(1,2));
    JPanel Lane3DepartPanel = new JPanel(new GridLayout(1,2));
    JButton BTN_Lane3Load = new JButton("Load Bagages");
    JButton BTN_Lane3Board = new JButton("Board Passagers");
    JButton BTN_Lane3Refuel = new JButton("Refuel");
    JLabel Label_Lane3Revenue = new JLabel("Revenue: ---");
    //lane 3 Requirements
    JLabel Lane3BagageH = new JLabel("Bagage Handlers: ---");
    JLabel Lane3FuelH = new JLabel("Fuel Handlers: ---");
    JLabel Lane3RefuelPrice = new JLabel("Refuel Price: ---");
    JButton BTN_Lane3Depart = new JButton("Depart");
    JLabel Label_Lane3Error = new JLabel();
    JLabel Label_Lane3DepartTime = new JLabel("Time: ---");

    public AirportManagerGame(){
        super("Airport Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1650,700);
        setResizable(false);
        BorderLayout mainGBY = new BorderLayout(7,7);
        setLayout(mainGBY);
        addConstraints();
        decorateUI();
        addUI();
        addEvents();
        InitializeGame();
        setVisible(true);
    }
    Game Game;
    private PlaneList PlaneList;
    private Plane Lane1Plane;
    private Plane Lane2Plane;
    private Plane Lane3Plane;

    private CrewList CrewList;

    private  void InitializeGame(){

//        Label_Lane1Error.setText("Error");
//        Label_Lane2Error.setText("Error");
//        Label_Lane3Error.setText("Error");

        Game = new Game();
        Lane1Plane = null;
        Lane2Plane = null;
        Lane3Plane = null;
        CrewList = Game.CrewList;
        PlaneList = Game.PlaneList;


        LB_IdlePlanes.setModel(PlaneList.IdlePlanesListModel);
        LB_SentPlanes.setModel(PlaneList.SentPlanesListModel);
        LB_AwaitingPlanes.setModel(PlaneList.AwaitingPlanesListModel);


        Timer timer1  = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            for(int i = 0 ; i< PlaneList.SentPlanesListModel.size();i++){
                TimedItem item = PlaneList.SentPlanesListModel.getElementAt(i);
                item.decreaseTimer();
                if(item.getTime()<=0){
                    Plane plane = item.getPlane();
                    PlaneList.SentPlanesListModel.removeElement(item);
                    PlaneList.AwaitingPlanesListModel.addElement(plane);
                    plane.setStatus("Awaiting to dock");
                    plane.UseFuel();
                }
                LB_SentPlanes.repaint();
            }
            }
        });
        timer1.start();

        Timer timer2  = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.AwaitingPassagers+=1000;
                UpdateTopUI();
            }
        });
        timer2.start();
        //dummy data
        for(int i = 1; i <=10;i++){
            Random random =new Random();
            Plane plane = new Plane(random.nextInt(1,6),"Idle");
            PlaneList.IdlePlanesListModel.addElement(plane);
            PlaneList.AllPlanes.add(plane);
        }

        for(int i = 1; i <=10;i++){
            Pilot pilot = new Pilot();
            CrewList.add(pilot);
        }
        for(int i = 1; i <=16;i++){
            FlightAtendent flightAtendent = new FlightAtendent();
            CrewList.add(flightAtendent);
        }
        for(int i = 1; i <=10;i++){
            BagageHandler bagageHandler = new BagageHandler();
            CrewList.add(bagageHandler);
        }
        for(int i = 1; i <=10;i++){
            FuelHandler fuelHandler = new FuelHandler();
            CrewList.add(fuelHandler);
        }


        initLaneButtons(1,false);
        initLaneButtons(2,false);
        initLaneButtons(3,false);
        BTN_Lane1Depart.setEnabled(false);
        BTN_Lane2Depart.setEnabled(false);
        BTN_Lane3Depart.setEnabled(false);

        UpdateTopUI();

    }

    public void UpdateTopUI(){
        Label_Money.setText(MessageFormat.format("Money: {0}$",Game.getMoney()));
        Label_AwaitingPasagers.setText(MessageFormat.format("Awaiting passagers: {0}",Game.AwaitingPassagers));
        Label_Pilots.setText(MessageFormat.format("Pilots: {0}/{1}",Game.CrewList.GetNrOfAvailablePilots(),Game.CrewList.PilotList.size()));
        Label_Planes.setText(MessageFormat.format("Planes: {0}/{1}",Game.PlaneList.GetNrOfAvailablePlanes(),Game.PlaneList.GetSize()));
        Label_FlightAtendents.setText(MessageFormat.format("Flight Atendents: {0}/{1}",Game.CrewList.GetNrOfAvailableFlightAtendents(),Game.CrewList.FlightAtendentList.size()));
        Label_FuelHandlers.setText(MessageFormat.format("Fuel Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableFuelHandlers(),Game.CrewList.FuelHandlerList.size()));
        Label_BagageHandlers.setText(MessageFormat.format("Bagage Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableBagageHandlers(),Game.CrewList.BagageHandlerList.size()));
        Label_AwaitingPlanes.setText("("+PlaneList.AwaitingPlanesListModel.getSize()+") Awaiting to dock planes:");
        Label_IdlePlanes.setText("("+PlaneList.IdlePlanesListModel.getSize()+") Idle planes: ");
        Label_Trips.setText(MessageFormat.format("Trips: {0}",Game.Trips));
    }
    public void UpdateLaneUI(int lane){
        switch (lane){
            case 1:
                Label_Lane1Passagers.setText(MessageFormat.format("Passagers: {0}/{1}",Lane1Plane.GetCurentPassagers(),Lane1Plane.GetMaxPassagers()));
                if(Lane1Plane.IsFueled()) Label_Lane1Fuel.setText("Fuel: 100%");
                else Label_Lane1Fuel.setText("Fuel: 0%");
                if(Lane1Plane.GetCurentPassagers()==0)
                    Label_Lane1Revenue.setText("Revenue: ---");
                break;
            case 2:
                Label_Lane2Passagers.setText(MessageFormat.format("Passagers: {0}/{1}",Lane2Plane.GetCurentPassagers(),Lane2Plane.GetMaxPassagers()));
                if(Lane2Plane.IsFueled()) Label_Lane2Fuel.setText("Fuel: 100%");
                else Label_Lane2Fuel.setText("Fuel: 0%");
                if(Lane2Plane.GetCurentPassagers()==0)
                    Label_Lane2Revenue.setText("Revenue: ---");
                break;
            case 3:
                Label_Lane3Passagers.setText(MessageFormat.format("Passagers: {0}/{1}",Lane3Plane.GetCurentPassagers(),Lane3Plane.GetMaxPassagers()));
                if(Lane3Plane.IsFueled()) Label_Lane3Fuel.setText("Fuel: 100%");
                else Label_Lane3Fuel.setText("Fuel: 0%");
                if(Lane3Plane.GetCurentPassagers()==0)
                    Label_Lane3Revenue.setText("Revenue: ---");
                break;
        }
    }
    private void initLaneButtons(int lane,boolean boolValue){
        switch (lane){
            case 1:
                BTN_Lane1Crew.setEnabled(boolValue);
                BTN_Lane1Board.setEnabled(boolValue);
                BTN_Lane1Load.setEnabled(boolValue);
                BTN_Lane1Refuel.setEnabled(boolValue);

                Lane1Distance.setEnabled(boolValue);
                break;
            case 2:
                BTN_Lane2Crew.setEnabled(boolValue);
                BTN_Lane2Board.setEnabled(boolValue);
                BTN_Lane2Load.setEnabled(boolValue);
                BTN_Lane2Refuel.setEnabled(boolValue);
                Lane2Distance.setEnabled(boolValue);
                break;
            case 3:
                BTN_Lane3Crew.setEnabled(boolValue);
                BTN_Lane3Board.setEnabled(boolValue);
                BTN_Lane3Load.setEnabled(boolValue);
                BTN_Lane3Refuel.setEnabled(boolValue);
                Lane3Distance.setEnabled(boolValue);
                break;
        }
    }
    public   void verifyDepart(int lane, Plane plane){
        if(plane.IsEligibleToFly())
            switch (lane){
                case 1:
                    Label_Lane1Status.setText("Status: Ready to fly");
                    plane.setStatus("Ready to fly");
                    BTN_Lane1Depart.setEnabled(true);
                    break;
                case 2:
                    Label_Lane2Status.setText("Status: Ready to fly");
                    plane.setStatus("Ready to fly");
                    BTN_Lane2Depart.setEnabled(true);
                    break;
                case 3:
                    Label_Lane3Status.setText("Status: Ready to fly");
                    plane.setStatus("Ready to fly");
                    BTN_Lane3Depart.setEnabled(true);
                    break;
            }
    }
    private void DisplayLane(Plane plane,int lane){
        if(plane !=null){
            switch (lane){
                case 1:
                    Label_Lane1PlaneName.setText(plane.toString());
                    Label_Lane1Passagers.setText("Passagers: "+plane.GetCurentPassagers()+"/"+ plane.GetMaxPassagers());
                    Label_Lane1Fuel.setText("Fuel: "+(plane.IsFueled()?"100%":"0%"));
                    Lane1FuelH.setText("Fuel Handlers: "+ plane.GetNeededFuelhandlers());
                    Lane1BagageH.setText("Bagage Handlers: "+ plane.GetNeededBagagehandlers());
                    Lane1RefuelPrice.setText("Refuel price: " + plane.GetRefuelPrice() + " $");
                    Lane1Distance.setSelectedIndex(plane.getDistance()-1);
                    Label_Lane1Revenue.setText(MessageFormat.format("Revenue: {0}$",RevenueCalculator(Lane1Plane) ));
                    Label_Lane1Status.setText("Status: Not Ready");


                    int departTime1 = (Lane1Distance.getSelectedIndex()+1)*5;
                    Label_Lane1DepartTime.setText("Time: "+departTime1+" Hr (Sec)");

                    break;
                case 2:
                    Label_Lane2PlaneName.setText(plane.toString());
                    Label_Lane2Passagers.setText("Passagers: "+plane.GetCurentPassagers()+"/"+ plane.GetMaxPassagers());
                    Label_Lane2Fuel.setText("Fuel: "+(plane.IsFueled()?"100%":"0%"));
                    Lane2FuelH.setText("Fuel Handlers: "+ plane.GetNeededFuelhandlers());
                    Lane2BagageH.setText("Bagage Handlers: "+ plane.GetNeededBagagehandlers());
                    Lane2RefuelPrice.setText("Refuel price: " + plane.GetRefuelPrice() + " $");
                    Lane2Distance.setSelectedIndex(plane.getDistance()-1);
                    Label_Lane2Revenue.setText(MessageFormat.format("Revenue: {0}$",RevenueCalculator(Lane2Plane) ));
                    Label_Lane2Status.setText("Status: Not Ready");


                    int departTime2 = (Lane2Distance.getSelectedIndex()+1)*5;
                    Label_Lane2DepartTime.setText("Time: "+departTime2+" Hr (Sec)");
                    break;
                case 3:
                    Label_Lane3PlaneName.setText(plane.toString());
                    Label_Lane3Passagers.setText("Passagers: "+plane.GetCurentPassagers()+"/"+ plane.GetMaxPassagers());
                    Label_Lane3Fuel.setText("Fuel: "+(plane.IsFueled()?"100%":"0%"));
                    Lane3FuelH.setText("Fuel Handlers: "+ plane.GetNeededFuelhandlers());
                    Lane3BagageH.setText("Bagage Handlers: "+ plane.GetNeededBagagehandlers());
                    Lane3RefuelPrice.setText("Refuel price: " + plane.GetRefuelPrice() + " $");
                    Lane3Distance.setSelectedIndex(plane.getDistance()-1);
                    Label_Lane3Revenue.setText(MessageFormat.format("Revenue: {0}$",RevenueCalculator(Lane3Plane) ));
                    Label_Lane3Status.setText("Status: Not Ready");


                    int departTime3 = (Lane3Distance.getSelectedIndex()+1)*5;
                    Label_Lane3DepartTime.setText("Time: "+departTime3+" Hr (Sec)");
                    break;
            }
        }else {
            switch (lane){
                case 1:
                    Label_Lane1PlaneName.setText("------");
                    Label_Lane1Passagers.setText("Passagers: 0/0");
                    Label_Lane1Fuel.setText("Fuel: 0%");
                    Lane1FuelH.setText("Fuel Handlers: ---");
                    Lane1BagageH.setText("Bagage Handlers: ---");
                    Lane1RefuelPrice.setText("Refuel price: ---");
                    Label_Lane1Revenue.setText("Revenue: --- $");
                    Label_Lane1DepartTime.setText("Time: ---");
                    Label_Lane1Status.setText("Status: ---");
                    break;
                case 2:
                    Label_Lane2PlaneName.setText("------");
                    Label_Lane2Passagers.setText("Passagers: 0/0");
                    Label_Lane2Fuel.setText("Fuel: 0%");
                    Lane2FuelH.setText("Fuel Handlers: ---");
                    Lane2BagageH.setText("Bagage Handlers: ---");
                    Lane2RefuelPrice.setText("Refuel price: ---");
                    Label_Lane2Revenue.setText("Revenue: --- $");
                    Label_Lane2DepartTime.setText("Time: ---");
                    Label_Lane2Status.setText("Status: ---");
                    break;
                case 3:
                    Label_Lane3PlaneName.setText("------");
                    Label_Lane3Passagers.setText("Passagers: 0/0");
                    Label_Lane3Fuel.setText("Fuel: 0%");
                    Lane3FuelH.setText("Fuel Handlers: ---");
                    Lane3BagageH.setText("Bagage Handlers: ---");
                    Lane3RefuelPrice.setText("Refuel price: ---");
                    Label_Lane3Revenue.setText("Revenue: --- $");
                    Label_Lane3DepartTime.setText("Time: ---");
                    Label_Lane3Status.setText("Status: ---");
                    break;
            }
        }
    }
    boolean updatingSelection = false;

    private int RevenueCalculator (Plane plane){
        return plane.GetCurentPassagers() * Game.getPassagerValue() * plane.getDistance() * Game.getDistanceValue();
    }
    private void addEvents(){
        BTN_ShowShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShopWindow(Game,AirportManagerGame.this);
            }
        });
        BTN_ShowAllCrew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllCrewWindow(Game,AirportManagerGame.this);
            }
        });
        BTN_Lane1Crew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlaneCrewWindow(Lane1Plane,Game,AirportManagerGame.this,1);
            }
        });
        BTN_Lane2Crew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlaneCrewWindow(Lane2Plane,Game,AirportManagerGame.this,2);
            }
        });
        BTN_Lane3Crew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlaneCrewWindow(Lane3Plane,Game,AirportManagerGame.this,3);
            }
        });

        //to lanes btns
        BTN_ToLane1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TB_PlaneDetails.setText("");
                if( Lane1Plane == null){
                    //docking
                    if(LB_AwaitingPlanes.getSelectedValue() != null)
                    {
                        Lane1Plane = (Plane) LB_AwaitingPlanes.getSelectedValue();
                        PlaneList.AwaitingPlanesListModel.removeElement(Lane1Plane);

                    } else if (LB_IdlePlanes.getSelectedValue()!=null) {
                        Lane1Plane = (Plane) LB_IdlePlanes.getSelectedValue();
                        PlaneList.IdlePlanesListModel.removeElement(Lane1Plane);
                    }
                    if (Lane1Plane!=null){
                        Lane1Plane.SetAvailability(false);
                        Lane1Plane.setStatus("Docked to lane 1");
                        BTN_ToLane1.setText("UnDock lane 1");
                        DisplayLane(Lane1Plane, 1);
                        UpdateTopUI();
                        initLaneButtons(1, true);
                        UpdateLaneUI(1);
                        if (Lane1Plane.IsFueled()) BTN_Lane1Refuel.setEnabled(false);

                        if(Lane1Plane.IsLoadedWithBagages()) BTN_Lane1Load.setText("Unload Bagages");
                        else BTN_Lane1Load.setText("Load Bagages");

                        if(Lane1Plane.GetCurentPassagers()!=0) BTN_Lane1Board.setText("Unload Passagers");
                        else BTN_Lane1Board.setText("Load Passagers");

                        if(Lane1Plane.IsUndockable()) {
                            BTN_ToLane1.setEnabled(false);
                            Lane1Distance.setEnabled(false);
                        }
                        else {
                            BTN_ToLane1.setEnabled(true);
                            Lane1Distance.setEnabled(true);
                        }
                    }
                }
                else {
                    //undocking
                        PlaneList.IdlePlanesListModel.addElement(Lane1Plane);
                        Lane1Plane.SetAvailability(true);
                        Lane1Plane.setStatus("Idle");
                        Label_Lane1Error.setText("");

                        Lane1Plane.UnLoadBagages();
                        Lane1Plane.clearBagageHandlers();
                        Game.AwaitingPassagers += Lane1Plane.GetCurentPassagers();
                        Lane1Plane.UnBoardPassagers();
                        Lane1Plane.clearFuelHandlers();

                        Lane1Plane = null;

                        DisplayLane(Lane1Plane, 1);
                        BTN_Lane1Depart.setEnabled(false);
                        BTN_ToLane1.setText("Dock to lane 1");
                        UpdateTopUI();
                        initLaneButtons(1, false);

                }
            }
        });
        BTN_ToLane2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TB_PlaneDetails.setText("");
                if( Lane2Plane == null){
                    //docking
                    if(LB_AwaitingPlanes.getSelectedValue() != null)
                    {
                        Lane2Plane = (Plane) LB_AwaitingPlanes.getSelectedValue();
                        PlaneList.AwaitingPlanesListModel.removeElement(Lane2Plane);
                    } else if (LB_IdlePlanes.getSelectedValue()!=null) {
                        Lane2Plane = (Plane) LB_IdlePlanes.getSelectedValue();
                        PlaneList.IdlePlanesListModel.removeElement(Lane2Plane);

                    }
                    if (Lane2Plane!=null){
                        Lane2Plane.SetAvailability(false);
                        Lane2Plane.setStatus("Docked to lane 2");
                        BTN_ToLane2.setText("UnDock lane 2");
                        DisplayLane(Lane2Plane, 2);
                        UpdateTopUI();
                        initLaneButtons(2, true);
                        if (Lane2Plane.IsFueled()) BTN_Lane2Refuel.setEnabled(false);

                        if(Lane2Plane.IsLoadedWithBagages()) BTN_Lane2Load.setText("Unload Bagages");
                        else BTN_Lane2Load.setText("Load Bagages");

                        if(Lane2Plane.GetCurentPassagers()!=0) BTN_Lane2Board.setText("Unload Passagers");
                        else BTN_Lane2Board.setText("Load Passagers");

                        if(Lane2Plane.IsUndockable()) {
                            BTN_ToLane2.setEnabled(false);
                            Lane2Distance.setEnabled(false);
                        }
                        else {
                            BTN_ToLane2.setEnabled(true);
                            Lane2Distance.setEnabled(true);
                        }
                    }
                }
                else {
                    //undocking

                        PlaneList.IdlePlanesListModel.addElement(Lane2Plane);
                        Lane2Plane.SetAvailability(true);
                        Lane2Plane.setStatus("Idle");
                        Label_Lane2Error.setText("");

                        Lane2Plane.UnLoadBagages();
                        Lane2Plane.clearBagageHandlers();
                        Game.AwaitingPassagers += Lane2Plane.GetCurentPassagers();
                        Lane2Plane.UnBoardPassagers();
                        Lane2Plane.clearFuelHandlers();

                        Lane2Plane = null;


                        DisplayLane(Lane2Plane, 2);
                        BTN_Lane2Depart.setEnabled(false);
                        BTN_ToLane2.setText("Dock to lane 2");
                        UpdateTopUI();
                        initLaneButtons(2, false);
                }
            }
        });
        BTN_ToLane3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TB_PlaneDetails.setText("");
                if( Lane3Plane == null){
                    //docking
                    if(LB_AwaitingPlanes.getSelectedValue() != null)
                    {
                        Lane3Plane = (Plane) LB_AwaitingPlanes.getSelectedValue();
                        PlaneList.AwaitingPlanesListModel.removeElement(Lane3Plane);
                    } else if (LB_IdlePlanes.getSelectedValue()!=null) {
                        Lane3Plane = (Plane) LB_IdlePlanes.getSelectedValue();
                        PlaneList.IdlePlanesListModel.removeElement(Lane3Plane);

                    }
                    if (Lane3Plane!=null){
                        Lane3Plane.SetAvailability(false);
                        Lane3Plane.setStatus("Docked to lane 3");
                        BTN_ToLane3.setText("UnDock lane 3");
                        DisplayLane(Lane3Plane, 3);
                        UpdateTopUI();
                        initLaneButtons(3, true);
                        if (Lane3Plane.IsFueled()) BTN_Lane3Refuel.setEnabled(false);

                        if(Lane3Plane.IsLoadedWithBagages()) BTN_Lane3Load.setText("Unload Bagages");
                        else BTN_Lane3Load.setText("Load Bagages");

                        if(Lane3Plane.GetCurentPassagers()!=0) BTN_Lane3Board.setText("Unload Passagers");
                        else BTN_Lane3Board.setText("Load Passagers");

                        if(Lane3Plane.IsUndockable()) {
                            BTN_ToLane3.setEnabled(false);
                            Lane3Distance.setEnabled(false);
                        }
                        else {
                            BTN_ToLane3.setEnabled(true);
                            Lane3Distance.setEnabled(true);
                        }
                    }
                }
                else {
                        //undocking
                        PlaneList.IdlePlanesListModel.addElement(Lane3Plane);
                        Lane3Plane.SetAvailability(true);
                        Lane3Plane.setStatus("Idle");
                        Label_Lane3Error.setText("");

                        Lane3Plane.UnLoadBagages();
                        Lane3Plane.clearBagageHandlers();
                        Game.AwaitingPassagers += Lane3Plane.GetCurentPassagers();
                        Lane3Plane.UnBoardPassagers();
                        Lane3Plane.clearFuelHandlers();

                        Lane3Plane = null;

                        DisplayLane(Lane3Plane, 3);
                        BTN_Lane3Depart.setEnabled(false);
                        BTN_ToLane3.setText("Dock to lane 3");
                        UpdateTopUI();
                        initLaneButtons(3, false);

                }
            }
        });

        Lane1Distance.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int time = (Lane1Distance.getSelectedIndex()+1) * 5;
                Lane1Plane.setDistance(Lane1Distance.getSelectedIndex()+1);
                Label_Lane1DepartTime.setText(MessageFormat.format("Time: {0} Hr (Sec)",time));
                Label_Lane1Revenue.setText(MessageFormat.format("Revenue: {0}$",RevenueCalculator(Lane1Plane) ));

            }
        });
        Lane2Distance.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int time = (Lane2Distance.getSelectedIndex()+1) * 5;
                Lane2Plane.setDistance(Lane2Distance.getSelectedIndex()+1);
                Label_Lane2DepartTime.setText(MessageFormat.format("Time: {0} Hr (Sec)",time));
                Label_Lane2Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane2Plane)));

            }
        });
        Lane3Distance.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int time = (Lane3Distance.getSelectedIndex()+1) * 5;
                Lane3Plane.setDistance(Lane3Distance.getSelectedIndex()+1);
                Label_Lane3DepartTime.setText(MessageFormat.format("Time: {0} Hr (Sec)",time));
                Label_Lane3Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane3Plane)));

            }
        });

        // btn lanes ----------------------------------------------------------------> work in progress ->depart
        BTN_Lane1Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane1Plane.isReturning()){
                    //load
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane1Plane.GetNeededBagagehandlers()){
                        Lane1Plane.addBagageHandlers(CrewList);
                        BTN_Lane1Load.setEnabled(false);
                        UpdateTopUI();

                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Loading: ",5);
                        Lane1BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane1BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane1Plane.LoadBagages();
                                    Lane1Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    verifyDepart(1,Lane1Plane);
                                    Lane1BagageH.setText("Loaded");
                                    BTN_ToLane1.setEnabled(false);

                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane1Error.setText("");
                    }else Label_Lane1Error.setText("Not Enough Bagage Handlers");
                }
                else {
                    //unload
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane1Plane.GetNeededBagagehandlers()){
                        Lane1Plane.addBagageHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane1Load.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Unloading: ",5);
                        Lane1BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane1BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane1Plane.UnLoadBagages();
                                    Lane1Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    BTN_Lane1Load.setText("Load Bagages");
                                    Lane1BagageH.setText(MessageFormat.format("Bagage Handlers: {0}",Lane1Plane.GetNeededBagagehandlers()));

                                    if(Lane1Plane.GetCurentPassagers() == 0) {
                                        Lane1Distance.setEnabled(true);
                                        BTN_ToLane1.setEnabled(true);
                                        Lane1Plane.setReturning(false);
                                    }
                                    BTN_Lane1Load.setEnabled(true);
                                    verifyDepart(1,Lane1Plane);
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane1Error.setText("");
                    }else Label_Lane1Error.setText("Not Enough Bagage Handlers");
                }
            }
        });
        BTN_Lane1Board.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane1Plane.isReturning()){
                    //board
                    if (Game.AwaitingPassagers > 0) {
                        BTN_Lane1Board.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Boarding: ",5);
                        Lane1FuelH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane1FuelH.setText(item.toString());
                                if(item.getTime()<=0){

                                    if (Game.AwaitingPassagers >= Lane1Plane.GetMaxPassagers()) {
                                        Lane1Plane.BoardPassagers(Lane1Plane.GetMaxPassagers());
                                        Game.AwaitingPassagers -= Lane1Plane.GetMaxPassagers();
                                        BTN_Lane1Board.setEnabled(false);
                                    } else {
                                        Lane1Plane.BoardPassagers(Game.AwaitingPassagers);
                                        Game.AwaitingPassagers = 0;
                                    }

                                    Label_Lane1Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane1Plane)));
                                    UpdateLaneUI(1);
                                    UpdateTopUI();
                                    BTN_ToLane1.setEnabled(false);
                                    verifyDepart(1,Lane1Plane);
                                    Lane1FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane1Plane.GetNeededFuelhandlers()));
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane1Error.setText("");
                    } else Label_Lane1Error.setText("Not enough passagers");
                }else{
                    //unboard

                    BTN_Lane1Board.setEnabled(false);
                    final Timer []timer = new Timer[1];
                    TimedItem item = new TimedItem("Unboarding: ",5);
                    Lane1FuelH.setText(item.toString());
                    timer[0]  = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            item.decreaseTimer();
                            Lane1FuelH.setText(item.toString());
                            if(item.getTime()<=0){
                                Lane1FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane1Plane.GetNeededFuelhandlers()));
                                Game.addMoney(RevenueCalculator(Lane1Plane));
                                Lane1Plane.UnBoardPassagers();
                                Label_Lane1Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane1Plane)));
                                BTN_Lane1Board.setText("Load Passagers");
                                Game.Trips+=1;

                                UpdateTopUI();
                                UpdateLaneUI(1);
                                if(Lane1Plane.IsLoadedWithBagages() == false) {
                                    Lane1Distance.setEnabled(true);
                                    BTN_ToLane1.setEnabled(true);
                                    Lane1Plane.setReturning(false);
                                }
                                BTN_Lane1Board.setEnabled(true);
                                verifyDepart(1,Lane1Plane);
                                timer[0].stop();
                            }
                        }
                    });

                    timer[0].start();
                }
            }
        });
        BTN_Lane1Refuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.CrewList.GetNrOfAvailableFuelHandlers() >=Lane1Plane.GetNeededFuelhandlers()){
                    if(Game.getMoney() >= Lane1Plane.GetRefuelPrice()){
                        //timer start
                        Game.removeMoney(Lane1Plane.GetRefuelPrice());
                        Lane1Plane.addFuelHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane1Refuel.setEnabled(false);

                        //timer
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Refueling: ",5);
                        Lane1RefuelPrice.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane1RefuelPrice.setText(item.toString());
                                if(item.getTime()<=0){

                                    Lane1Plane.FuelUp();
                                    Lane1Plane.clearFuelHandlers();
                                    UpdateLaneUI(1);
                                    UpdateTopUI();
                                    verifyDepart(1,Lane1Plane);
                                    Lane1RefuelPrice.setText("Fueled Up");

                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane1Error.setText("");
                    }else Label_Lane1Error.setText("Not enough money");
                }else Label_Lane1Error.setText("Not enough fuel handlers");
            }
        });
        BTN_Lane1Depart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lane1Plane.setStatus("Travelling");
                Lane1Plane.setDistance(Lane1Distance.getSelectedIndex()+1);
                System.out.println(Lane1Plane.getDistance());
                Lane1Plane.setReturning(true);
                PlaneList.SentPlanesListModel.addElement(new TimedItem(Lane1Plane,Lane1Plane.getDistance()*5));
                DisplayLane(null,1);
                BTN_Lane1Depart.setEnabled(false);
                initLaneButtons(1,false);
                BTN_ToLane1.setEnabled(true);
                BTN_ToLane1.setText("Dock to lane 1");
                Lane1Plane = null;
            }
        });

        BTN_Lane2Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane2Plane.isReturning()){
                    //load
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane2Plane.GetNeededBagagehandlers()){
                        Lane2Plane.addBagageHandlers(CrewList);
                        BTN_Lane2Load.setEnabled(false);
                        UpdateTopUI();

                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Loading: ",5);
                        Lane2BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane2BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane2Plane.LoadBagages();
                                    Lane2Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    verifyDepart(2,Lane2Plane);
                                    Lane2BagageH.setText("Loaded");
                                    BTN_ToLane2.setEnabled(false);

                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane2Error.setText("");
                    }else Label_Lane2Error.setText("Not Enough Bagage Handlers");
                }
                else {
                    //unload
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane2Plane.GetNeededBagagehandlers()){
                        Lane2Plane.addBagageHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane2Load.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Unloading: ",5);
                        Lane2BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane2BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane2Plane.UnLoadBagages();
                                    Lane2Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    BTN_Lane2Load.setText("Load Bagages");
                                    Lane2BagageH.setText(MessageFormat.format("Bagage Handlers: {0}",Lane2Plane.GetNeededBagagehandlers()));

                                    if(Lane2Plane.GetCurentPassagers() == 0) {
                                        Lane2Distance.setEnabled(true);
                                        BTN_ToLane2.setEnabled(true);
                                        Lane2Plane.setReturning(false);
                                    }
                                    BTN_Lane2Load.setEnabled(true);
                                    verifyDepart(2,Lane2Plane);
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane2Error.setText("");
                    }else Label_Lane2Error.setText("Not Enough Bagage Handlers");
                }
            }
        });
        BTN_Lane2Board.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane2Plane.isReturning()){
                    //board
                    if (Game.AwaitingPassagers > 0) {
                        BTN_Lane2Board.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Boarding: ",5);
                        Lane2FuelH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane2FuelH.setText(item.toString());
                                if(item.getTime()<=0){

                                    if (Game.AwaitingPassagers >= Lane2Plane.GetMaxPassagers()) {
                                        Lane2Plane.BoardPassagers(Lane2Plane.GetMaxPassagers());
                                        Game.AwaitingPassagers -= Lane2Plane.GetMaxPassagers();
                                        BTN_Lane2Board.setEnabled(false);
                                    } else {
                                        Lane2Plane.BoardPassagers(Game.AwaitingPassagers);
                                        Game.AwaitingPassagers = 0;
                                    }

                                    Label_Lane2Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane2Plane)));
                                    UpdateLaneUI(2);
                                    UpdateTopUI();
                                    BTN_ToLane2.setEnabled(false);
                                    verifyDepart(2,Lane2Plane);
                                    Lane2FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane2Plane.GetNeededFuelhandlers()));
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane2Error.setText("");
                    } else Label_Lane2Error.setText("Not enough passagers");
                    //timer
                }else{
                    //unboard

                    BTN_Lane2Board.setEnabled(false);
                    final Timer []timer = new Timer[1];
                    TimedItem item = new TimedItem("Unboarding: ",5);
                    Lane2FuelH.setText(item.toString());
                    timer[0]  = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            item.decreaseTimer();
                            Lane2FuelH.setText(item.toString());
                            if(item.getTime()<=0){
                                Lane2FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane2Plane.GetNeededFuelhandlers()));
                                Game.addMoney(RevenueCalculator(Lane2Plane));
                                Lane2Plane.UnBoardPassagers();
                                Label_Lane2Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane2Plane)));
                                BTN_Lane2Board.setText("Load Passagers");
                                Game.Trips+=1;

                                UpdateTopUI();
                                UpdateLaneUI(2);
                                if(Lane2Plane.IsLoadedWithBagages() == false) {
                                    Lane2Distance.setEnabled(true);
                                    BTN_ToLane2.setEnabled(true);
                                    Lane2Plane.setReturning(false);
                                }
                                BTN_Lane2Board.setEnabled(true);
                                verifyDepart(2,Lane2Plane);
                                timer[0].stop();
                            }
                        }
                    });

                    timer[0].start();
                }
            }
        });
        BTN_Lane2Refuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.CrewList.GetNrOfAvailableFuelHandlers() >=Lane2Plane.GetNeededFuelhandlers()){
                    if(Game.getMoney() >= Lane2Plane.GetRefuelPrice()){
                        //timer start
                        Game.removeMoney(Lane2Plane.GetRefuelPrice());
                        Lane2Plane.addFuelHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane2Refuel.setEnabled(false);

                        //timer
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Refueling: ",5);
                        Lane2RefuelPrice.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane2RefuelPrice.setText(item.toString());
                                if(item.getTime()<=0){

                                    Lane2Plane.FuelUp();
                                    Lane2Plane.clearFuelHandlers();
                                    UpdateLaneUI(2);
                                    UpdateTopUI();
                                    verifyDepart(2,Lane2Plane);
                                    Lane2RefuelPrice.setText("Fueled Up");

                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane2Error.setText("");
                    }else Label_Lane2Error.setText("Not enough money");
                }else Label_Lane2Error.setText("Not enough fuel handlers");
            }
        });
        BTN_Lane2Depart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lane2Plane.setStatus("Travelling");
                Lane2Plane.setDistance(Lane2Distance.getSelectedIndex()+1);
                Lane2Plane.setReturning(true);
                PlaneList.SentPlanesListModel.addElement(new TimedItem(Lane2Plane,Lane2Plane.getDistance()*5));
                DisplayLane(null,2);
                BTN_Lane2Depart.setEnabled(false);
                initLaneButtons(2,false);
                BTN_ToLane2.setEnabled(true);
                BTN_ToLane2.setText("Dock to lane 2");
                Lane2Plane = null;
            }
        });

        BTN_Lane3Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane3Plane.isReturning()){
                    //load
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane3Plane.GetNeededBagagehandlers()){
                        Lane3Plane.addBagageHandlers(CrewList);
                        BTN_Lane3Load.setEnabled(false);
                        UpdateTopUI();

                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Loading: ",5);
                        Lane3BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane3BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane3Plane.LoadBagages();
                                    Lane3Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    verifyDepart(3,Lane3Plane);
                                    Lane3BagageH.setText("Loaded");
                                    BTN_ToLane3.setEnabled(false);

                                    timer[0].stop();
                                }
                            }
                        });

                        timer[0].start();
                        Label_Lane3Error.setText("");
                    }else Label_Lane3Error.setText("Not Enough Bagage Handlers");
                }
                else {
                    //unload
                    if(CrewList.GetNrOfAvailableBagageHandlers()>= Lane3Plane.GetNeededBagagehandlers()){
                        Lane3Plane.addBagageHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane3Load.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Unloading: ",5);
                        Lane3BagageH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane3BagageH.setText(item.toString());
                                if(item.getTime()<=0){
                                    Lane3Plane.UnLoadBagages();
                                    Lane3Plane.clearBagageHandlers();
                                    UpdateTopUI();
                                    BTN_Lane3Load.setText("Load Bagages");
                                    Lane3BagageH.setText(MessageFormat.format("Bagage Handlers: {0}",Lane3Plane.GetNeededBagagehandlers()));

                                    if(Lane3Plane.GetCurentPassagers() == 0) {
                                        Lane3Distance.setEnabled(true);
                                        BTN_ToLane3.setEnabled(true);
                                        Lane3Plane.setReturning(false);
                                    }
                                    BTN_Lane3Load.setEnabled(true);
                                    verifyDepart(3,Lane3Plane);
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane3Error.setText("");
                    }else Label_Lane3Error.setText("Not Enough Bagage Handlers");
                }
            }
        });
        BTN_Lane3Board.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Lane3Plane.isReturning()){
                    //board
                    if (Game.AwaitingPassagers > 0) {
                        BTN_Lane3Board.setEnabled(false);
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Boarding: ",5);
                        Lane3FuelH.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane3FuelH.setText(item.toString());
                                if(item.getTime()<=0){

                                    if (Game.AwaitingPassagers >= Lane3Plane.GetMaxPassagers()) {
                                        Lane3Plane.BoardPassagers(Lane3Plane.GetMaxPassagers());
                                        Game.AwaitingPassagers -= Lane3Plane.GetMaxPassagers();
                                        BTN_Lane3Board.setEnabled(false);
                                    } else {
                                        Lane3Plane.BoardPassagers(Game.AwaitingPassagers);
                                        Game.AwaitingPassagers = 0;
                                    }

                                    Label_Lane3Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane3Plane)));
                                    UpdateLaneUI(3);
                                    UpdateTopUI();
                                    BTN_ToLane3.setEnabled(false);
                                    verifyDepart(3,Lane3Plane);
                                    Lane3FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane3Plane.GetNeededFuelhandlers()));
                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane3Error.setText("");
                    } else Label_Lane3Error.setText("Not enough passagers");
                    //timer
                }else{
                    //unboard

                    BTN_Lane3Board.setEnabled(false);
                    final Timer []timer = new Timer[1];
                    TimedItem item = new TimedItem("Unboarding: ",5);
                    Lane3FuelH.setText(item.toString());
                    timer[0]  = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            item.decreaseTimer();
                            Lane3FuelH.setText(item.toString());
                            if(item.getTime()<=0){
                                Lane3FuelH.setText(MessageFormat.format("Fuel Handlers: {0}",Lane3Plane.GetNeededFuelhandlers()));
                                Game.addMoney(RevenueCalculator(Lane3Plane));
                                Lane3Plane.UnBoardPassagers();
                                Label_Lane3Revenue.setText(MessageFormat.format("Revenue: {0}$", RevenueCalculator(Lane3Plane)));
                                BTN_Lane3Board.setText("Load Passagers");
                                Game.Trips+=1;

                                UpdateTopUI();
                                UpdateLaneUI(3);
                                if(Lane3Plane.IsLoadedWithBagages() == false) {
                                    Lane3Distance.setEnabled(true);
                                    BTN_ToLane3.setEnabled(true);
                                    Lane3Plane.setReturning(false);
                                }
                                BTN_Lane3Board.setEnabled(true);
                                verifyDepart(3,Lane3Plane);
                                timer[0].stop();
                            }
                        }
                    });

                    timer[0].start();
                }
            }
        });
        BTN_Lane3Refuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.CrewList.GetNrOfAvailableFuelHandlers() >=Lane3Plane.GetNeededFuelhandlers()){
                    if(Game.getMoney() >= Lane3Plane.GetRefuelPrice()){
                        //timer start
                        Game.removeMoney(Lane3Plane.GetRefuelPrice());
                        Lane3Plane.addFuelHandlers(CrewList);
                        UpdateTopUI();
                        BTN_Lane3Refuel.setEnabled(false);

                        //timer
                        final Timer []timer = new Timer[1];
                        TimedItem item = new TimedItem("Refueling: ",5);
                        Lane3RefuelPrice.setText(item.toString());
                        timer[0]  = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                item.decreaseTimer();
                                Lane3RefuelPrice.setText(item.toString());
                                if(item.getTime()<=0){

                                    Lane3Plane.FuelUp();
                                    Lane3Plane.clearFuelHandlers();
                                    UpdateLaneUI(3);
                                    UpdateTopUI();
                                    verifyDepart(3,Lane3Plane);
                                    Lane3RefuelPrice.setText("Fueled Up");

                                    timer[0].stop();
                                }
                            }
                        });
                        timer[0].start();
                        Label_Lane3Error.setText("");
                    }else Label_Lane3Error.setText("Not enough money");
                }else Label_Lane3Error.setText("Not enough fuel handlers");
            }
        });
        BTN_Lane3Depart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lane3Plane.setStatus("Travelling");
                Lane3Plane.setDistance(Lane3Distance.getSelectedIndex()+1);
                Lane3Plane.setReturning(true);
                PlaneList.SentPlanesListModel.addElement(new TimedItem(Lane3Plane,Lane3Plane.getDistance()*5));
                DisplayLane(null,3);
                BTN_Lane3Depart.setEnabled(false);
                initLaneButtons(3,false);
                BTN_ToLane3.setEnabled(true);
                BTN_ToLane3.setText("Dock to lane 3");
                Lane3Plane = null;
            }
        });


        // LB
        LB_AwaitingPlanes.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting() && !updatingSelection)
            {
                updatingSelection = true;
                LB_IdlePlanes.clearSelection();//fires list selection event
                updatingSelection = false;

                Plane plane  = (Plane) LB_AwaitingPlanes.getSelectedValue();
                if(plane!=null){
                    String planeDetails= MessageFormat.format(
                            "{0}\nPilot: {1} \nFlight attendants:{2}/{3}\nPassagers: {4}/{5}\nNeeded Bagage Handlers: {6}\nNeeded Fuel Handlers: {7}\nRefuel price: {8}$\nDistance traveled: {9} km\nTotal Revenue: {10}$",
                            plane.GetID(),
                            plane.GetPilot() != null? plane.GetPilot().getName():"None",
                            plane.GetFlightAtendentList().size(),
                            plane.GetMaxFlightAtendents(),
                            plane.GetCurentPassagers(),
                            plane.GetMaxPassagers(),
                            plane.GetNeededBagagehandlers(),
                            plane.GetNeededFuelhandlers(),
                            plane.GetRefuelPrice(),
                            10000+plane.getDistance()*1000,
                            RevenueCalculator(plane)
                    );
                    TB_PlaneDetails.setText(planeDetails);
                }
            }
        }
    });
        LB_IdlePlanes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting() && !updatingSelection)
                {
                    updatingSelection = true;
                    LB_AwaitingPlanes.clearSelection();//fires list selection event
                    updatingSelection = false;

                    Plane plane  = (Plane) LB_IdlePlanes.getSelectedValue();
                    if(plane!=null){
                        String planeDetails = MessageFormat.format(
                                "{0}\nPilot: {1} \nFlight attendants:{2}/{3}\nPassagers: {4}/{5}\nNeeded Bagage Handlers: {6}\nNeeded Fuel Handlers: {7}\nRefuel price: {8}$\nRefueled: {9}",
                                plane.GetID(),
                                plane.GetPilot() != null ? plane.GetPilot().getName() : "None",
                                plane.GetFlightAtendentList().size(),
                                plane.GetMaxFlightAtendents(),
                                plane.GetCurentPassagers(),
                                plane.GetMaxPassagers(),
                                plane.GetNeededBagagehandlers(),
                                plane.GetNeededFuelhandlers(),
                                plane.GetRefuelPrice(),
                                plane.IsFueled() ? "Yes" : "No"
                        );
                        TB_PlaneDetails.setText(planeDetails);
                    }
                }
            }
        });

    }


    private void addConstraints(){
        TB_PlaneDetails.setEditable(false);
        TB_PlaneDetails.setCaret(new DefaultCaret(){@Override public void paint(Graphics g){}}); //
        LB_SentPlanes.setSelectionModel(new DefaultListSelectionModel(){@Override public void setSelectionInterval(int index0,int index1){}});
    }

    private void decorateUI(){
        Font f = new Font("Times New Roman",Font.BOLD,14);

        //Awaiting planes
        Label_AwaitingPlanes.setFont(f);
        LB_AwaitingPlanes.setFont(f);
        LB_AwaitingPlanes.setBackground(Color.LIGHT_GRAY);
        LB_AwaitingPlanesPanel.setPreferredSize(new Dimension(300,350));

        // Details
        Label_PlaneDetails.setFont(f);
        TB_PlaneDetails.setFont(f);
        TB_PlaneDetails.setBackground(Color.LIGHT_GRAY);

        //Top UI
        ResourcesPanel.setBackground(Color.BLUE);
        ButtonsPanel.setBackground(Color.BLUE);
        //Money
        Label_Money.setFont(f);
        Label_Money.setForeground(Color.WHITE);
        //Planes
        Label_Planes.setFont(f);
        Label_Planes.setForeground(Color.WHITE);
        //Pilots
        Label_Pilots.setFont(f);
        Label_Pilots.setForeground(Color.WHITE);
        //Flight Atendents
        Label_FlightAtendents.setFont(f);
        Label_FlightAtendents.setForeground(Color.WHITE);
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
        BTN_ShowAllCrew.setPreferredSize(new Dimension(200,20));
        //Shop
        BTN_ShowShop.setFont(f);
        BTN_ShowShop.setFocusPainted(false);
        BTN_ShowShop.setForeground(Color.WHITE);
        BTN_ShowShop.setBackground(Color.BLUE);
        BTN_ShowShop.setPreferredSize(new Dimension(200,20));
        //Total Trips
        Label_Trips.setFont(f);
        Label_Trips.setForeground(Color.WHITE);
        //BTN To Lanes
        Label_ToLanesDetails.setFont(f);
        Label_ToLanesDetails.setBorder(new EmptyBorder(0,0,0,0));
        Label_ToLanesDetails.setAlignmentX(Component.CENTER_ALIGNMENT);

        ToLanesPanel.setPreferredSize(new Dimension(200,100));


        BTN_ToLane1.setFont(f);
        BTN_ToLane1.setFocusPainted(false);
        BTN_ToLane1.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane1.setForeground(Color.black);
        BTN_ToLane1.setPreferredSize(new Dimension(100,15));
        BTN_ToLane1.setAlignmentX(Component.CENTER_ALIGNMENT);

        BTN_ToLane2.setFont(f);
        BTN_ToLane2.setFocusPainted(false);
        BTN_ToLane2.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane2.setForeground(Color.black);
        BTN_ToLane2.setPreferredSize(new Dimension(100,15));
        BTN_ToLane2.setAlignmentX(Component.CENTER_ALIGNMENT);

        BTN_ToLane3.setFont(f);
        BTN_ToLane3.setFocusPainted(false);
        BTN_ToLane3.setBackground(Color.LIGHT_GRAY);
        BTN_ToLane3.setForeground(Color.black);
        BTN_ToLane3.setPreferredSize(new Dimension(100,15));
        BTN_ToLane3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Idle planes
        Label_IdlePlanes.setFont(f);
        LB_IdlePlanes.setBackground(Color.LIGHT_GRAY);
        LB_IdlePlanes.setFont(f);
        Label_IdlePlanes.setBorder(new EmptyBorder(0,0,0,0));
        IdlePlanesPanel.setBorder(new EmptyBorder(0,0,0,0));
        IdlePlanesPanel.setPreferredSize(new Dimension(300,175));


        // sent planes
        Label_SentPlanes.setFont(f);
        LB_SentPlanes.setBackground(Color.LIGHT_GRAY);
        LB_SentPlanes.setFont(f);
        Label_SentPlanes.setBorder(new EmptyBorder(0,0,0,0));
        SentPlanesPanel.setBorder(new EmptyBorder(0,0,0,0));
        SentPlanesPanel.setPreferredSize(new Dimension(300,175));


        //Lane 1

        Lane1Top.setBackground(Color.LIGHT_GRAY);
        Lane1Center.setBackground(Color.LIGHT_GRAY);
        Lane1Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane1Crew .setPreferredSize(new Dimension(10,10));
        BTN_Lane1Crew.setFocusPainted(false);
        Lane1Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane1DistanceLabel.setFont(f);

        //lane 2

        Lane2Top.setBackground(Color.LIGHT_GRAY);
        Lane2Center.setBackground(Color.LIGHT_GRAY);
        Lane2Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane2Crew.setPreferredSize(new Dimension(10,10));
        BTN_Lane2Crew.setFocusPainted(false);
        Lane2Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane2DistanceLabel.setFont(f);

        //lane 3
        Lane3Top.setBackground(Color.LIGHT_GRAY);
        Lane3Center.setBackground(Color.LIGHT_GRAY);
        Lane3Bottom.setBackground(Color.LIGHT_GRAY);

        BTN_Lane3Crew.setPreferredSize(new Dimension(10,10));
        BTN_Lane3Crew.setFocusPainted(false);
        Lane3Distance.setPreferredSize(new Dimension(200,30));
        Label_Lane3DistanceLabel.setFont(f);

        //Lane 1 buttons + Requirements

        BTN_Lane1Load.setFont(f);
        BTN_Lane1Board.setFont(f);
        BTN_Lane1Refuel.setFont(f);

        BTN_Lane1Load.setFocusPainted(false);
        BTN_Lane1Board.setFocusPainted(false);
        BTN_Lane1Refuel.setFocusPainted(false);
        BTN_Lane1Depart.setFocusPainted(false);

        Label_Lane1Revenue.setFont(f);
        Lane1BagageH.setFont(f);
        Lane1FuelH.setFont(f);
        Lane1RefuelPrice.setFont(f);
        Label_Lane1DepartTime.setFont(f);

        Label_Lane1Error.setFont(f);
        Label_Lane1Error.setForeground(Color.RED);

        //Lane 2 Buttons + Requirements
        BTN_Lane2Depart.setAlignmentX(Component.CENTER_ALIGNMENT);

        BTN_Lane2Load.setFont(f);
        BTN_Lane2Board.setFont(f);
        BTN_Lane2Refuel.setFont(f);
        BTN_Lane2Depart.setFont(f);

        BTN_Lane2Load.setFocusPainted(false);
        BTN_Lane2Board.setFocusPainted(false);
        BTN_Lane2Refuel.setFocusPainted(false);
        BTN_Lane2Depart.setFocusPainted(false);

        Label_Lane2Revenue.setFont(f);
        Lane2BagageH.setFont(f);
        Lane2FuelH.setFont(f);
        Lane2RefuelPrice.setFont(f);
        Label_Lane2DepartTime.setFont(f);

        Label_Lane2Error.setFont(f);
        Label_Lane2Error.setForeground(Color.RED);


        //Lane 3 buttons + Requirements

        BTN_Lane3Load.setFont(f);
        BTN_Lane3Board.setFont(f);
        BTN_Lane3Refuel.setFont(f);

        BTN_Lane3Load.setFocusPainted(false);
        BTN_Lane3Board.setFocusPainted(false);
        BTN_Lane3Refuel.setFocusPainted(false);
        BTN_Lane3Depart.setFocusPainted(false);

        Label_Lane3Revenue.setFont(f);
        Lane3BagageH.setFont(f);
        Lane3FuelH.setFont(f);
        Lane3RefuelPrice.setFont(f);
        Label_Lane3DepartTime.setFont(f);

        Label_Lane3Error.setFont(f);
        Label_Lane3Error.setForeground(Color.RED);

//        LB_AwaitingPlanesPanel.setBackground(Color.PINK);
//        LB_DetailsPanel.setBackground(Color.PINK);
//        ToLanesPanel.setBackground(Color.PINK);
//        IdlePlanesPanel.setBackground(Color.PINK);
//        SentPlanesPanel.setBackground(Color.PINK);
//        Lane1Space.setBackground(Color.PINK);
//        Lane2Space.setBackground(Color.PINK);
//        Lane3Space.setBackground(Color.PINK);
//        Lane1Buttons.setBackground(Color.PINK);
//        Lane2Buttons.setBackground(Color.PINK);
//        Lane3Buttons.setBackground(Color.PINK);
    }
    private void addUI(){

        //Top UI
        ResourcesPanel.add(Label_Money);
        ResourcesPanel.add(Label_AwaitingPasagers);
        ResourcesPanel.add(Label_Planes);
        ResourcesPanel.add(Label_Pilots);
        ResourcesPanel.add(Label_FlightAtendents);
        ResourcesPanel.add(Label_BagageHandlers);
        ResourcesPanel.add(Label_FuelHandlers);
        ResourcesPanel.add(Label_Trips);

        ButtonsPanel.add(BTN_ShowShop);
        ButtonsPanel.add(BTN_ShowAllCrew);

        topUI.setLayout(new BoxLayout(topUI,BoxLayout.Y_AXIS));
        topUI.add(ResourcesPanel);
        topUI.add(ButtonsPanel);

        add(topUI,BorderLayout.NORTH);

        GridBagConstraints position = new GridBagConstraints();
        position.fill = GridBagConstraints.BOTH;
        position.insets = new Insets(15,15,15,15);
        // -------------- Center Panel -------------

        //LB Awaiting Planes
        LB_AwaitingPlanesPanel.setLayout(new BoxLayout(LB_AwaitingPlanesPanel,BoxLayout.Y_AXIS));
        LB_AwaitingPlanesPanel.add(Label_AwaitingPlanes);
        LB_AwaitingPlanesPanel.add(new JScrollPane(LB_AwaitingPlanes));
        position.gridx = 0;position.gridy = 0; position.gridheight = 2;
        CenterPanel.add(LB_AwaitingPlanesPanel,position);

        //Label Details
        LB_DetailsPanel.setLayout(new BoxLayout(LB_DetailsPanel,BoxLayout.Y_AXIS));
        LB_DetailsPanel.add(Label_PlaneDetails);
        LB_DetailsPanel.add(new JScrollPane(TB_PlaneDetails));
        position.gridx = 0;position.gridy = 2;position.gridheight = 1;
        CenterPanel.add(LB_DetailsPanel,position);

        //To lane Buttons
        ToLanesPanel.setLayout(new BoxLayout(ToLanesPanel,BoxLayout.Y_AXIS));
        ToLanesPanel.add(Label_ToLanesDetails);
        ToLanesPanel.add(Box.createRigidArea(new Dimension(0,10)));
        ToLanesPanel.add(BTN_ToLane1);
        ToLanesPanel.add(Box.createRigidArea(new Dimension(0,10)));
        ToLanesPanel.add(BTN_ToLane2);
        ToLanesPanel.add(Box.createRigidArea(new Dimension(0,10)));
        ToLanesPanel.add(BTN_ToLane3);
        position.gridx =1; position.gridy =0; position.fill = GridBagConstraints.CENTER;
        CenterPanel.add(ToLanesPanel,position);

        //Idle planes
        IdlePlanesPanel.setLayout(new BoxLayout(IdlePlanesPanel,BoxLayout.Y_AXIS));
        IdlePlanesPanel.add(Label_IdlePlanes);
        IdlePlanesPanel.add(new JScrollPane(LB_IdlePlanes));
        position.gridx =1; position.gridy =1;
        CenterPanel.add(IdlePlanesPanel,position);

        //Sent planes
        SentPlanesPanel.setLayout(new BoxLayout(SentPlanesPanel,BoxLayout.Y_AXIS));
        SentPlanesPanel.add(Label_SentPlanes);
        SentPlanesPanel.add(new JScrollPane(LB_SentPlanes));
        position.gridx = 1; position.gridy=2;
        CenterPanel.add(SentPlanesPanel,position);


        //lane 1
        Lane1Top.add(Label_Lane1);
        Lane1Top.add(BTN_Lane1Crew );
        Lane1.add(Lane1Top,BorderLayout.NORTH);
        Lane1Center.add(Label_Lane1PlaneName);
        Lane1.add(Lane1Center,BorderLayout.CENTER);
        Lane1Bottom.add(Label_Lane1Fuel);
        Lane1Bottom.add(Label_Lane1Passagers);
        Lane1Bottom.add(Label_Lane1Status);
        Lane1.add(Lane1Bottom,BorderLayout.SOUTH);


        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane1Distance.addItem(value);
        }
        Lane1DistancePanel.add(Label_Lane1DistanceLabel);
        Lane1DistancePanel.add(Lane1Distance);

        Lane1Space.setLayout(new BoxLayout(Lane1Space,BoxLayout.Y_AXIS));
        Lane1Space.add(Lane1);
        Lane1Space.add(Lane1DistancePanel);

        position.gridx = 2; position.gridy = 0;
        CenterPanel.add(Lane1Space,position);

        //lane 2
        Lane2Top.add(Label_Lane2 );
        Lane2Top.add(BTN_Lane2Crew);
        Lane2.add(Lane2Top,BorderLayout.NORTH);
        Lane2Center.add(Label_Lane2PlaneName);
        Lane2.add(Lane2Center,BorderLayout.CENTER);
        Lane2Bottom.add(Label_Lane2Fuel);
        Lane2Bottom.add(Label_Lane2Passagers);
        Lane2Bottom.add(Label_Lane2Status);
        Lane2.add(Lane2Bottom,BorderLayout.SOUTH);


        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane2Distance.addItem(value);
        }
        Lane2DistancePanel.add(Label_Lane2DistanceLabel);
        Lane2DistancePanel.add(Lane2Distance);

        Lane2Space.setLayout(new BoxLayout(Lane2Space,BoxLayout.Y_AXIS));
        Lane2Space.add(Lane2);
        Lane2Space.add(Lane2DistancePanel);

        position.gridx = 2; position.gridy = 1;
        CenterPanel.add(Lane2Space,position);

        //lane 3
        Lane3Top.add(Label_Lane3);
        Lane3Top.add(BTN_Lane3Crew);
        Lane3.add(Lane3Top,BorderLayout.NORTH);
        Lane3Center.add(Label_Lane3PlaneName);
        Lane3.add(Lane3Center,BorderLayout.CENTER);
        Lane3Bottom.add(Label_Lane3Fuel);
        Lane3Bottom.add(Label_Lane3Passagers);
        Lane3Bottom.add(Label_Lane3Status);
        Lane3.add(Lane3Bottom,BorderLayout.SOUTH);

        Lane3Space.add(Lane3);
        for(int i = 1 ;i<=10; i++)
        {
            int intValue = (10000+i*1000);
            String value = MessageFormat.format("{0} km", intValue);
            Lane3Distance.addItem(value);
        }
        Lane3DistancePanel.add(Label_Lane3DistanceLabel);
        Lane3DistancePanel.add(Lane3Distance);

        Lane3Space.setLayout(new BoxLayout(Lane3Space,BoxLayout.Y_AXIS));
        Lane3Space.add(Lane3);
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
        Lane1RefuelPanel.add(Lane1RefuelPrice);
        Lane1Buttons.add(Lane1RefuelPanel);

        Lane1RevenuePanel.add(Label_Lane1Revenue);
        Lane1RevenuePanel.add(Label_Lane1DepartTime);
        Lane1Buttons.add(Lane1RevenuePanel);
        Lane1Buttons.add(BTN_Lane1Depart);

        Lane1DepartPanel.add(BTN_Lane1Depart);
        Lane1DepartPanel.add(Label_Lane1Error);
        Lane1Buttons.add(Lane1DepartPanel);

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
        Lane2RefuelPanel.add(Lane2RefuelPrice);
        Lane2Buttons.add(Lane2RefuelPanel);

        Lane2RevenuePanel.add(Label_Lane2Revenue);
        Lane2RevenuePanel.add(Label_Lane2DepartTime);
        Lane2Buttons.add(Lane2RevenuePanel);

        Lane2DepartPanel.add(BTN_Lane2Depart);
        Lane2DepartPanel.add(Label_Lane2Error);
        Lane2Buttons.add(Lane2DepartPanel);

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
        Lane3RefuelPanel.add(Lane3RefuelPrice);
        Lane3Buttons.add(Lane3RefuelPanel);

        Lane3RevenuePanel.add(Label_Lane3Revenue);
        Lane3RevenuePanel.add(Label_Lane3DepartTime);
        Lane3Buttons.add(Lane3RevenuePanel);

        Lane3DepartPanel.add(BTN_Lane3Depart);
        Lane3DepartPanel.add(Label_Lane3Error);
        Lane3Buttons.add(Lane3DepartPanel);

        position.gridx = 3; position.gridy = 2;
        CenterPanel.add(Lane3Buttons,position);

        add(CenterPanel,BorderLayout.CENTER);
    }
}
