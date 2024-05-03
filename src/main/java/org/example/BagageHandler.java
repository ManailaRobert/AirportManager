package org.example;

import java.text.MessageFormat;

public class BagageHandler extends Crew{

    public  BagageHandler(){
        super();
        Price = 100;
        Type = "Bagage Handler";
    }


    public String GetType (){
        return Type;
    }
    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})",Name,Type);
    }
}
