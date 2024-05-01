package org.example;

public class FlightAtendent extends Crew{
    private String Type ;
    public FlightAtendent(){
        super();
        super.Price = 250;
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
