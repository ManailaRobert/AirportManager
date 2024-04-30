package org.example;

public class FlightAtendent extends Crew{
    private String Type ;
    public FlightAtendent(){
        super();
        Type = "FlightAtendent";
    }


    public String GetType (){
        return Type;
    }

    @Override
    public String toString() {
        return Name + " (Flight Atendent)";
    }
}
