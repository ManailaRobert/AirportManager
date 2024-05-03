package org.example;

public class Game {

    public int Money;
    public CrewList CrewList;
    public PlaneList PlaneList;
    public int AwaitingPassagers;

    private int PassagerValue;

    private int DistanceValue;

    public  Game(){
        Money = 99999;
        AwaitingPassagers = 400;
        CrewList = new CrewList();
        PlaneList = new PlaneList();
        PassagerValue = 10;
        DistanceValue = 2;
    }

    public int getPassagerValue() {
        return PassagerValue;
    }

    public int getDistanceValue() {
        return DistanceValue;
    }
}
