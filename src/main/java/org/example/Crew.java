package org.example;

import java.util.Random;

public class Crew {


    protected String Name;
    private boolean Available;

    public boolean IsAvailable(){
        return Available;
    }
    public void Availability(boolean availability){
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

        int i = random.nextInt(30);
        int j = random.nextInt(30);

        Name = firstNames[i] + " "+ lastNames[j];
        Available = true;
    }

}
