package org.example;

import java.text.MessageFormat;

public class FlightAtendent extends Crew{

    public FlightAtendent(){
        super();
        Price = 250;
        Type = "Flight Atendent";
    }


    public String GetType (){
        return Type;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} (Flight Atendent)",Name);
    }
}
