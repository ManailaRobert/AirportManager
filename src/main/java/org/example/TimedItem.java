package org.example;

public class TimedItem {

    private Plane Plane;
    private int Time;

    private String Text;
    public TimedItem(Plane plane,int time){
        Plane = plane;
        Time = time;
    }
    public TimedItem(String text,int time){
        Text = text;
        Time = time;
    }

    public void decreaseTimer(){
        Time--;
    }

    public org.example.Plane getPlane() {
        return Plane;
    }

    public int getTime() {
        return Time;
    }

    public String getText() {
        return Text;
    }

    @Override
    public String toString() {
        if(Plane!=null) return Plane.GetID()+"-"+Time+"s";
        else return Text + " "+Time+"s";
    }
}
