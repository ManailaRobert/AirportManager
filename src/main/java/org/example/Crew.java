package org.example;

import java.util.Random;

public class Crew {


    protected String Name;
    private boolean Available;
    protected String Type ;
    protected int Price;

    private Plane AssignedPlane;
    public boolean IsAvailable(){
        return Available;
    }
    public void SetAvailability(boolean availability){
        Available = availability;
    }
    public Crew(){

        String[] firstNames = {
                "Emma", "Noah", "Olivia", "Liam", "Ava", "William", "Sophia", "Mason", "Isabella", "James",
                "Mia", "Benjamin", "Charlotte", "Jacob", "Abigail", "Michael", "Emily", "Elijah", "Harper", "Ethan",
                "Amelia", "Alexander", "Evelyn", "Daniel", "Elizabeth", "Matthew", "Sofia", "Henry", "Avery"
        };

        String[] lastNames = {
                "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez",
                "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin",
                "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis"
        };

        Random random = new Random();

        int i = random.nextInt(firstNames.length);
        int j = random.nextInt(lastNames.length);

        Name = firstNames[i] + " "+ lastNames[j];
        Available = true;
        AssignedPlane = null;
    }

    public int getPrice() {
        return Price;
    }

    public Plane getAssignedPlane() {
        return AssignedPlane;
    }

    public void setAssignedPlane(Plane assignedPlane) {
        AssignedPlane = assignedPlane;
    }
    public String getName(){
        return Name;
    }
}
