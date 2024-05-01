package org.example;

import java.util.logging.Level;

public class Pilot extends Crew{


    public Pilot(){
        super();
        super.Price = 1000;
        Type ="Pilot";
    }

    private String Type ;
    public String GetType (){
        return Type;
    }

    @Override
    public String toString() {
        return Name + " (Pilot)";
    }
}
