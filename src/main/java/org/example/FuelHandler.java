package org.example;

public class FuelHandler extends Crew{
    private String Type ;
    public FuelHandler(){
        super();
        Type = "FuelHandler";
    }


    public String GetType (){
        return Type;
    }
    @Override
    public String toString() {
        return Name + " (Fuel Handler)";
    }
}
