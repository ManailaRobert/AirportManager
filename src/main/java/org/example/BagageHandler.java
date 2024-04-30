package org.example;

public class BagageHandler extends Crew{

    private String Type ;
    public  BagageHandler(){
        super();
        Type = "BagageHandler";
    }


    public String GetType (){
        return Type;
    }
    @Override
    public String toString() {
        return Name + " (Bagage Handler)";
    }
}
