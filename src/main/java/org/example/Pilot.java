package org.example;

import java.text.MessageFormat;
import java.util.logging.Level;

public class Pilot extends Crew{


    public Pilot(){
        super();
        super.Price = 1000;
        Type ="Pilot";
    }

    public String GetType (){
        return Type;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})",Name,Type);
    }
}
