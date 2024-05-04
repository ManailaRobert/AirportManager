package org.example;

public class Game {

    private int Money;
    public CrewList CrewList;
    public PlaneList PlaneList;
    public int AwaitingPassagers;

    private int PassagerValue;

    private int DistanceValue;

    public  int Trips;
    public  Game(){
        Trips = 0;
        Money = 5000;
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

    public int getMoney() {
        return Money;
    }

    public void addMoney(int money) {
        Money  +=money;
    }

    public void removeMoney(int money) {
        Money -=money;
    }
}
