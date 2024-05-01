package org.example;

public class Game {

    public int Money;
    public CrewList CrewList;
    public PlaneList PlaneList;

    public  Game(){
        Money = 99999;
        CrewList = new CrewList();
        PlaneList = new PlaneList();
    }
}
