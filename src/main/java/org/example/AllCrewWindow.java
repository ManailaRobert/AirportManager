package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class AllCrewWindow extends JFrame {


    JPanel TopUI = new JPanel(new GridLayout(1,4));
    JLabel Label_Pilots = new JLabel("Pilots: 000/100");
    JLabel Label_FlightAtendents = new JLabel("Flight Atendents: 000/100");
    JLabel Label_FuelHandlers = new JLabel("Fuel Handlers: 000/100");
    JLabel Label_BagageHandlers = new JLabel("Bagage Handlers: 000/100");

    JPanel Center = new JPanel();
    JPanel Top = new JPanel();
    JPanel AvailableCrewPanel = new JPanel();
    JLabel Label_AvailableCrew = new JLabel("Available crew:");
    JTable AvailableCrewTabel = new JTable() ;
    JScrollPane AvailableCrewScroll = new JScrollPane();

    JPanel Bottom = new JPanel();
    JPanel DispatchedCrewPanel = new JPanel();
    JLabel Label_DispatchedCrew = new JLabel("Dispatched crew:");
    JTable DispatchedCrewTable = new JTable();
    JScrollPane DispatchedCrewScroll = new JScrollPane();

    Game Game;
    AirportManagerGame MainWindow;
    public  AllCrewWindow(Game game,AirportManagerGame mainWindow){
        super("CrewWindow");
        Game = game;
        MainWindow = mainWindow;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(900,700);
        setResizable(false);
        BorderLayout layout = new BorderLayout(7,7);
        setLayout(layout);


        decorateUI();
        addUI();
        addConstraints();

        UpdateTopUI();

        setVisible(true);
    }
    public void UpdateTopUI(){
        Label_Pilots.setText(MessageFormat.format("Pilots: {0}/{1}",Game.CrewList.GetNrOfAvailablePilots(),Game.CrewList.PilotList.size()));
        Label_FlightAtendents.setText(MessageFormat.format("Flight Atendents: {0}/{1}",Game.CrewList.GetNrOfAvailableFlightAtendents(),Game.CrewList.FlightAtendentList.size()));
        Label_FuelHandlers.setText(MessageFormat.format("Fuel Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableFuelHandlers(),Game.CrewList.FuelHandlerList.size()));
        Label_BagageHandlers.setText(MessageFormat.format("Bagage Handlers: {0}/{1}",Game.CrewList.GetNrOfAvailableBagageHandlers(),Game.CrewList.BagageHandlerList.size()));
    }
    private void  addConstraints(){
        AvailableCrewTabel.setEnabled(false);
        AvailableCrewTabel.setAutoResizeMode(5);
        AvailableCrewTabel.getTableHeader().setResizingAllowed(false);
        AvailableCrewTabel.getTableHeader().setReorderingAllowed(false);

        DispatchedCrewTable.setEnabled(false);
        DispatchedCrewTable.setAutoResizeMode(5);
        DispatchedCrewTable.getTableHeader().setResizingAllowed(false);
        DispatchedCrewTable.getTableHeader().setReorderingAllowed(false);
    }
    private void decorateUI() {
        Font f = new Font("Times New Roman",Font.BOLD,14);

        TopUI.setBackground(Color.BLUE);
        Label_Pilots.setFont(f);
        Label_Pilots.setForeground(Color.WHITE);

        Label_FlightAtendents.setFont(f);
        Label_FlightAtendents.setForeground(Color.WHITE);

        Label_BagageHandlers.setFont(f);
        Label_BagageHandlers.setForeground(Color.WHITE);

        Label_FuelHandlers.setFont(f);
        Label_FuelHandlers.setForeground(Color.WHITE);

        Label_AvailableCrew.setFont(f);
        AvailableCrewScroll.setPreferredSize(new Dimension(500,280));
        AvailableCrewTabel.setFont(f);
        AvailableCrewTabel.setBackground(Color.LIGHT_GRAY);

        Label_DispatchedCrew.setFont(f);
        DispatchedCrewScroll.setPreferredSize(new Dimension(500,280));
        DispatchedCrewTable.setFont(f);
        DispatchedCrewTable.setBackground(Color.LIGHT_GRAY);

    }
    private void addUI() {


        TopUI.add(Label_Pilots);
        TopUI.add(Label_FlightAtendents);
        TopUI.add(Label_BagageHandlers);
        TopUI.add(Label_FuelHandlers);


        Top.setLayout(new BoxLayout(Top,BoxLayout.Y_AXIS));
        Top.add(Label_AvailableCrew);
        AvailableCrewTabel = new JTable(new AvailableCrewTableModel(Game.CrewList));
        AvailableCrewScroll.setViewportView(AvailableCrewTabel);
        AvailableCrewPanel.add(AvailableCrewScroll);
        Top.add(AvailableCrewPanel);


        Bottom.setLayout(new BoxLayout(Bottom,BoxLayout.Y_AXIS));

        Bottom.add(Label_DispatchedCrew);
        DispatchedCrewTable = new JTable(new UnAvailableCrewTableModel(Game.CrewList));
        DispatchedCrewScroll.setViewportView(DispatchedCrewTable);
        DispatchedCrewPanel.add(DispatchedCrewScroll);
        Bottom.add(DispatchedCrewPanel);

        Center.setLayout(new BoxLayout(Center,BoxLayout.Y_AXIS));
        Center.add(Top);
        Center.add(Bottom);
        add(TopUI,BorderLayout.NORTH);
        add(Center,BorderLayout.CENTER);
    }
}
