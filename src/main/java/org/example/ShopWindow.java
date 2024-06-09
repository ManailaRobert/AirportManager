package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.MessageFormat;

public class ShopWindow extends JFrame {

//top UI
    JPanel topUI  = new JPanel();
    JPanel top = new JPanel(new GridLayout(1,6));
    JPanel bottom = new JPanel();
    JLabel Label_Error = new JLabel();
    JLabel Label_Money = new JLabel("Money: 999 999 999");
    JLabel Label_Pilots = new JLabel("Pilots: 000/100");
    JLabel Label_Planes = new JLabel("Planes: 000/100");
    JLabel Label_FlightAtendents = new JLabel("Flight Atendents: 000/100");
    JLabel Label_FuelHandlers = new JLabel("Fuel Handlers: 000/100");
    JLabel Label_BagageHandlers = new JLabel("Bagage Handlers: 000/100");
    

    //planes side
    JPanel planesPanel = new JPanel();
    JPanel listPlanesPanel = new JPanel();
    JLabel Label_PlanesText = new JLabel("Planes");
    JPanel planesLabelPanel = new JPanel();
    JList LB_Planes = new JList<>(new String[]{"Plane LVL 1","Plane LVL 2","Plane LVL 3","Plane LVL 4","Plane LVL 5"});
    JPanel BuyPlanesPanel = new JPanel();
    JComboBox CB_PlaneQTY = new JComboBox();
    JButton BTN_BuyPlanes = new JButton("Buy");
    JLabel Label_TotalPricePlanes = new JLabel("Total price:");

    //crew side
    JPanel crewPanel = new JPanel();
    JPanel listCrewPanel = new JPanel();
    JLabel Label_Crew = new JLabel("Crew");
    JPanel crewLabelPanel = new JPanel();
    JList LB_Crew =new JList(new String[]{"Pilot (1000$)","Flight Atendent (250$)","Bagage Handler (100$)","Fuel Handler (150$)"});
    JPanel BuyCrewPanel = new JPanel();
    JComboBox CB_CrewQTY = new JComboBox();
    JButton BTN_BuyCrew = new JButton("Buy");
    JLabel Label_TotalPriceCrew = new JLabel("Total price:");

    // details side
    JPanel middlePanel = new JPanel();
    JPanel detailsPanel = new JPanel();
    JPanel listDetailsPanel = new JPanel();
    JLabel Label_Details = new JLabel("Details");
    JTextArea TB_Details = new JTextArea("Plane/Crew Details");


    private void addConstraints(){
        TB_Details.setEditable(false);
        TB_Details.setCaret(new DefaultCaret(){@Override public void paint(Graphics g){}});
    }

    private CrewList CrewList;
    private PlaneList PlaneList;
    private  Game Game;
    AirportManagerGame MainWindow;
    public  ShopWindow(Game game,AirportManagerGame mainWindow){
        super("Shop");
        MainWindow = mainWindow;
        Game= game;
        CrewList = game.CrewList;
        PlaneList = game.PlaneList;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(1200,500);
        setResizable(false);
        BorderLayout layout = new BorderLayout(7,7);
        setLayout(layout);

        addConstraints();
        decorateUI();
        addUI();
        addEvents();

        //Default selection for Planes
        Plane plane = new Plane(1,"");
        String planeDetails = "Plane LVL " +1+
                "\nMax Passagers: " +plane.GetMaxPassagers()+
                "\nMax Flight Atendents: " + plane.GetMaxFlightAtendents()+
                "\nMax Bagage Handlers: " + plane.GetNeededBagagehandlers()+
                "\nMax Fuel Handlers: " + plane.GetNeededFuelhandlers()+
                "\nRefuel price: " +plane.GetRefuelPrice()+"$"+
                "\nPrice: " + plane.getPrice()+"$";
        TB_Details.setText(planeDetails);
        Label_TotalPricePlanes.setText(MessageFormat.format("Total price: {0}$",1*plane.getPrice()));

        //Default selection for crew
        Pilot pilot = new Pilot();
        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",1*pilot.getPrice()));


        Timer timer2  = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTopUI();
            }
        });
        timer2.start();

        UpdateTopUI();
        setVisible(true);
    }

    public void UpdateTopUI(){
        Label_Money.setText(MessageFormat.format("Money: {0}$",Game.getMoney()));
        Label_Pilots.setText(MessageFormat.format("Pilots: {0}/{1}",Game.CrewList.GetNrOfAvailablePilots(),Game.CrewList.PilotList.size()));
        Label_Planes.setText(MessageFormat.format("Planes: {0}/{1}",Game.PlaneList.GetNrOfAvailablePlanes(),Game.PlaneList.GetSize()));
        Label_FlightAtendents.setText(MessageFormat.format("Flight Atendents: {0}/{1}",Game.CrewList.GetNrOfAvailableFlightAtendents(),Game.CrewList.FlightAtendentList.size()));
        Label_FuelHandlers.setText(MessageFormat.format("Fuel Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableFuelHandlers(),Game.CrewList.FuelHandlerList.size()));
        Label_BagageHandlers.setText(MessageFormat.format("Bagage Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableBagageHandlers(),Game.CrewList.BagageHandlerList.size()));
    }

    private void addEvents() {

        LB_Planes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int level = LB_Planes.getSelectedIndex()+1;
                Plane plane = new Plane(level,"");
                String planeDetails = "Plane LVL " +level+
                        "\nMax Passagers: " +plane.GetMaxPassagers()+
                        "\nMax Flight Atendents: " + plane.GetMaxFlightAtendents()+
                        "\nMax Bagage Handlers: " + plane.GetNeededBagagehandlers()+
                        "\nMax Fuel Handlers: " + plane.GetNeededFuelhandlers()+
                        "\nRefuel price: " +plane.GetRefuelPrice()+"$"+
                        "\nPrice: " + plane.getPrice()+"$";
                TB_Details.setText(planeDetails);
                int QTY = CB_PlaneQTY.getSelectedIndex()+1;
                Label_TotalPricePlanes.setText(MessageFormat.format("Total price: {0}$",QTY*plane.getPrice()));
            }
        });
        CB_PlaneQTY.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int QTY = CB_PlaneQTY.getSelectedIndex()+1;
                int level = LB_Planes.getSelectedIndex()+1;
                Plane plane = new Plane(level,"");
                Label_TotalPricePlanes.setText(MessageFormat.format("Total price: {0}$",QTY*plane.getPrice()));
            }
        });
        BTN_BuyPlanes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int QTY = CB_PlaneQTY.getSelectedIndex()+1;
                int level = LB_Planes.getSelectedIndex()+1;
                Plane plane = new Plane(level,"");
                int price = QTY*plane.getPrice();
                if(Game.getMoney() >= price){
                    for(int i = 1;i<=QTY;i++)
                    {
                        Plane newPlane = new Plane(level,"");
                        Game.PlaneList.add(newPlane);
                    }
                    Game.removeMoney(price);
                    UpdateTopUI();
                    Label_Error.setForeground(Color.GREEN);
                    Label_Error.setText("Purchase successfull");
                    MainWindow.UpdateTopUI();
                }else{
                    Label_Error.setForeground(Color.RED);
                    Label_Error.setText("Not enough Money");
                }
            }
        });

        LB_Crew.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int QTY = CB_CrewQTY.getSelectedIndex()+1;
                int type = LB_Crew.getSelectedIndex()+1;
                switch (type){
                    case 1:
                        Pilot pilot = new Pilot();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*pilot.getPrice()));
                        break;
                    case 2:
                        FlightAtendent flightAtendent =new FlightAtendent();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*flightAtendent.getPrice()));
                        break;
                    case 3:
                        BagageHandler bagageHandler = new BagageHandler();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*bagageHandler.getPrice()));
                        break;
                    case 4:
                        FuelHandler fuelHandler = new FuelHandler();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*fuelHandler.getPrice()));
                        break;
                }
            }
        });
        CB_CrewQTY.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int QTY = CB_CrewQTY.getSelectedIndex()+1;
                int type = LB_Crew.getSelectedIndex()+1;
                switch (type){
                    case 1:
                        Pilot pilot = new Pilot();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*pilot.getPrice()));
                        break;
                    case 2:
                        FlightAtendent flightAtendent =new FlightAtendent();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*flightAtendent.getPrice()));
                        break;
                    case 3:
                        BagageHandler bagageHandler = new BagageHandler();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*bagageHandler.getPrice()));
                        break;
                    case 4:
                        FuelHandler fuelHandler = new FuelHandler();
                        Label_TotalPriceCrew.setText(MessageFormat.format("Total price: {0}$",QTY*fuelHandler.getPrice()));
                        break;
                }
            }
        });
        BTN_BuyCrew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int type = LB_Crew.getSelectedIndex()+1;
                int QTY = CB_CrewQTY.getSelectedIndex()+1;
                int price;
                switch (type){
                    case 1:
                        Pilot pilot = new Pilot();
                        price = QTY * pilot.getPrice();
                        if(Game.getMoney() >= price)
                        {
                            Game.removeMoney(price);
                            for(int i = 1;i<=QTY;i++)
                                Game.CrewList.add(new Pilot());
                            Label_Error.setForeground(Color.GREEN);
                            Label_Error.setText("Purchase successfull");
                            UpdateTopUI();
                        }else {
                            Label_Error.setForeground(Color.RED);
                            Label_Error.setText("Not enough Money");
                        }
                        break;
                    case 2:
                        FlightAtendent flightAtendent =new FlightAtendent();
                        price = QTY * flightAtendent.getPrice();
                        if(Game.getMoney() >= price)
                        {
                            Game.removeMoney(price);
                            for(int i = 1;i<=QTY;i++)
                                Game.CrewList.add(new FlightAtendent());
                            Label_Error.setForeground(Color.GREEN);
                            Label_Error.setText("Purchase successfull");
                            UpdateTopUI();
                        }else {
                            Label_Error.setForeground(Color.RED);
                            Label_Error.setText("Not enough Money");
                        }
                        break;
                    case 3:
                        BagageHandler bagageHandler = new BagageHandler();
                        price = QTY * bagageHandler.getPrice();
                        if(Game.getMoney() >= price)
                        {
                            Game.removeMoney(price);
                            for(int i = 1;i<=QTY;i++)
                                Game.CrewList.add(new BagageHandler());
                            Label_Error.setForeground(Color.GREEN);
                            Label_Error.setText("Purchase successfull");
                            UpdateTopUI();
                        }else {
                            Label_Error.setForeground(Color.RED);
                            Label_Error.setText("Not enough Money");
                        }
                        break;
                    case 4:
                        FuelHandler fuelHandler = new FuelHandler();
                        price = QTY * fuelHandler.getPrice();
                        if(Game.getMoney() >= price)
                        {
                            Game.removeMoney(price);
                            for(int i = 1;i<=QTY;i++)
                                Game.CrewList.add(new FuelHandler());
                            Label_Error.setForeground(Color.GREEN);
                            Label_Error.setText("Purchase successfull");
                            UpdateTopUI();
                        }else {
                            Label_Error.setForeground(Color.RED);
                            Label_Error.setText("Not enough Money");
                        }
                        break;

                }
                MainWindow.UpdateTopUI();
            }
        });
    }

    private  void decorateUI(){
        Font f = new Font("Times New Roman",Font.BOLD,14);

        //top UI
        top.setBackground(Color.BLUE);
        bottom.setBackground(Color.BLUE);

        Label_Money.setForeground(Color.WHITE);
        Label_Money.setFont(f);
        Label_Planes.setForeground(Color.WHITE);
        Label_Planes.setFont(f);
        Label_Pilots.setForeground(Color.WHITE);
        Label_Pilots.setFont(f);
        Label_FlightAtendents.setForeground(Color.WHITE);
        Label_FlightAtendents.setFont(f);
        Label_BagageHandlers.setForeground(Color.WHITE);
        Label_BagageHandlers.setFont(f);
        Label_FuelHandlers.setForeground(Color.WHITE);
        Label_FuelHandlers.setFont(f);

        Label_Error.setFont(f);
        Label_Error.setForeground(Color.RED);

        // planes side
        listPlanesPanel.setPreferredSize(new Dimension(290,400));
        planesLabelPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        BTN_BuyCrew.setFocusPainted(false);
        BTN_BuyCrew.setBackground(Color.LIGHT_GRAY);
        BTN_BuyCrew.setForeground(Color.black);
        Label_TotalPricePlanes.setFont(f);
        Label_TotalPricePlanes.setAlignmentX(Component.RIGHT_ALIGNMENT);

        //middle part
        Label_Details.setVerticalAlignment(SwingConstants.BOTTOM);
        TB_Details.setFont(f);

        //crew side
        listCrewPanel.setPreferredSize(new Dimension(290,450));
        crewLabelPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        BTN_BuyPlanes.setFocusPainted(false);
        BTN_BuyPlanes.setBackground(Color.LIGHT_GRAY);
        BTN_BuyPlanes.setForeground(Color.black);
        Label_TotalPriceCrew.setFont(f);
        Label_TotalPriceCrew.setAlignmentX(Component.RIGHT_ALIGNMENT);
    }

    private void addUI(){

        topUI.setLayout(new BoxLayout(topUI,BoxLayout.Y_AXIS));
        top.add(Label_Money);
        top.add(Label_Planes);
        top.add(Label_Pilots);
        top.add(Label_FlightAtendents);
        top.add(Label_BagageHandlers);
        top.add(Label_FuelHandlers);


        bottom.add(Label_Error);
        topUI.add(top);
        topUI.add(bottom);

        add(topUI,BorderLayout.NORTH);

        //planes panel
        planesPanel.setLayout(new BoxLayout(planesPanel,BoxLayout.Y_AXIS));
        planesLabelPanel.add(Label_PlanesText);
        planesPanel.add(planesLabelPanel);
        listPlanesPanel.setLayout(new BoxLayout(listPlanesPanel,BoxLayout.Y_AXIS));
        listPlanesPanel.add(new JScrollPane(LB_Planes));
        LB_Planes.setSelectedIndex(0);
        planesPanel.add(listPlanesPanel);
        BuyPlanesPanel.setLayout(new GridLayout(1,3));
        BuyPlanesPanel.add(new JLabel("Buy QTY:"));
        BuyPlanesPanel.add(CB_PlaneQTY);
        BuyPlanesPanel.add(BTN_BuyPlanes);
        planesPanel.add(BuyPlanesPanel);
        planesPanel.add(Label_TotalPricePlanes);

        for(int i=1;i<=10;i++)
            CB_PlaneQTY.addItem(i);

        //details panel

        middlePanel.setLayout(new GridLayout(1,3));
        detailsPanel.setLayout(new GridLayout(3,1));

        detailsPanel.add(Label_Details);
        listDetailsPanel.setLayout(new BoxLayout(listDetailsPanel,BoxLayout.Y_AXIS));
        listDetailsPanel.add(new JScrollPane(TB_Details));
        detailsPanel.add(listDetailsPanel);

        middlePanel.add(new JPanel());
        middlePanel.add(detailsPanel);
        middlePanel.add(new JPanel());

        //crew panel
        crewPanel.setLayout(new BoxLayout(crewPanel,BoxLayout.Y_AXIS));
        crewLabelPanel.add(Label_Crew);
        crewPanel.add(crewLabelPanel);
        listCrewPanel.setLayout(new BoxLayout(listCrewPanel,BoxLayout.Y_AXIS));
        listCrewPanel.add(new JScrollPane(LB_Crew));
        LB_Crew.setSelectedIndex(0);
        crewPanel.add(listCrewPanel);
        BuyCrewPanel.setLayout(new GridLayout(1,3));
        BuyCrewPanel.add(new JLabel("Buy QTY:"));
        BuyCrewPanel.add(CB_CrewQTY);
        BuyCrewPanel.add(BTN_BuyCrew);
        crewPanel.add(BuyCrewPanel);
        crewPanel.add(Label_TotalPriceCrew);

        for(int i=1;i<=10;i++)
            CB_CrewQTY.addItem(i);


        add (planesPanel,BorderLayout.WEST);
        add(middlePanel,BorderLayout.CENTER);
        add (crewPanel, BorderLayout.EAST);


    }

}
