package org.example;

import javax.swing.*;
import java.awt.*;

public class ShopWindow extends JFrame {


    JPanel topUI  = new JPanel();
    JLabel Label_Money = new JLabel("Money");

    //planes side
    JPanel planesPanel = new JPanel();
    JPanel listPlanesPanel = new JPanel();
    JLabel Label_Planes = new JLabel("Planes");
    JList LB_Planes = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});
    JPanel BuyPlanesPanel = new JPanel();
    JTextField TB_PlaneQTY = new JTextField();
    JButton BTN_BuyPlanes = new JButton("Buy");

    //crew side
    JPanel crewPanel = new JPanel();
    JPanel listCrewPanel = new JPanel();
    JLabel Label_Crew = new JLabel("Crew");
    JList LB_Crew =new JList(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});
    JPanel BuyCrewPanel = new JPanel();
    JTextField TB_CrewQTY = new JTextField();
    JButton BTN_BuyCrew = new JButton("Buy");

    // details side
    JPanel detailsPanel = new JPanel();
    JPanel listDetailsPanel = new JPanel();
    JLabel Label_Details = new JLabel("Details");
    JList LB_Details = new JList<>(new String[]{" Item 1"," Item 2"," Item 3"," Item 4"});






    public  ShopWindow(){
        super("Shop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(900,500);
        BorderLayout layout = new BorderLayout(7,7);
        setLayout(layout);

        decorateUI();
        addUI();

        setVisible(true);
    }

    private  void decorateUI(){
        Font f = new Font("Times New Roman",Font.BOLD,14);


        planesPanel.setPreferredSize(new Dimension(290,450));
        detailsPanel.setPreferredSize(new Dimension(290,450));
        crewPanel.setPreferredSize(new Dimension(290,450));

    }

    private void addUI(){

        topUI.add(Label_Money);
        add(topUI,BorderLayout.NORTH);

        //planes panel
        planesPanel.setLayout(new BoxLayout(planesPanel,BoxLayout.Y_AXIS));
        planesPanel.add(Label_Planes);
        listPlanesPanel.add(LB_Planes);
        planesPanel.add(listPlanesPanel);
        BuyPlanesPanel.setLayout(new GridLayout(1,2));
        BuyPlanesPanel.add(TB_PlaneQTY);
        BuyPlanesPanel.add(BTN_BuyPlanes);
        planesPanel.add(BuyPlanesPanel);


        //details panel

        detailsPanel.setLayout(new GridLayout(3,1));

        detailsPanel.add(Label_Details);
        listDetailsPanel.add(LB_Details);
        detailsPanel.add(listDetailsPanel);

        //crew panel
        crewPanel.setLayout(new BoxLayout(crewPanel,BoxLayout.Y_AXIS));
        crewPanel.add(Label_Crew);
        listCrewPanel.add(LB_Crew);
        crewPanel.add(listCrewPanel);
        BuyCrewPanel.setLayout(new GridLayout(1,2));
        BuyCrewPanel.add(TB_CrewQTY);
        BuyCrewPanel.add(BTN_BuyCrew);
        crewPanel.add(BuyCrewPanel);


        add (planesPanel,BorderLayout.WEST);
        add(detailsPanel,BorderLayout.CENTER);
        add (crewPanel, BorderLayout.EAST);


    }

}
