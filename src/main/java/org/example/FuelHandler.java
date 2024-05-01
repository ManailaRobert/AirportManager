package org.example;

import java.text.MessageFormat;

public class FuelHandler extends Crew{

    public FuelHandler(){
        super();
        Price = 150;
        Type = "Fuel Handler";
    }


    public String GetType (){
        return Type;
    }
    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})",Type,Name);
    }
}
