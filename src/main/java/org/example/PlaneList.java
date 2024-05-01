package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneList {
    public DefaultListModel<Plane> AwaitingPlanesListModel;
    public DefaultListModel<Plane> IdlePlanesListModel;
    public DefaultListModel<Plane> SentPlanesListModel;
    public List<Plane> AllPlanes;


    public  PlaneList(){
        AwaitingPlanesListModel= new DefaultListModel<>();
        IdlePlanesListModel = new DefaultListModel<>();
        SentPlanesListModel = new DefaultListModel<>();
        AllPlanes  = new ArrayList<>();
    }
    public void add(Plane plane){
        AllPlanes.add(plane);
        IdlePlanesListModel.addElement(plane);
    }
    public int GetSize(){
        return AllPlanes.size();
    }

    public int GetNrOfAvailablePlanes(){
        int result = 0;
        for(Plane plane:AllPlanes)
            if(plane.IsAvailable())
                result++;
        return result;
    }


}
