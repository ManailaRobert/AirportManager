package org.example;

import java.util.ArrayList;
import java.util.List;

public class CrewList {

    public List<Pilot> PilotList;
    public List<FlightAtendent> FlightAtendentList;
    public List<BagageHandler> BagageHandlerList;
    public List<FuelHandler> FuelHandlerList;
    public CrewList(){
        PilotList = new ArrayList<>();
        FlightAtendentList = new ArrayList<>();
        BagageHandlerList = new ArrayList<>();
        FuelHandlerList = new ArrayList<>();
    }

    public void add(Crew crew){
        if(crew instanceof Pilot){PilotList.add((Pilot)crew);
        }else if (crew instanceof FlightAtendent) {FlightAtendentList.add((FlightAtendent) crew);
        }else if (crew instanceof BagageHandler) {BagageHandlerList.add((BagageHandler) crew);
        }else if (crew instanceof FuelHandler) {FuelHandlerList.add((FuelHandler) crew);
        }
    }

    public int GetNrOfAvailablePilots(){
        int result = 0;
        for(Pilot pilot:PilotList)
            if(pilot.IsAvailable())
                result++;
        return result;
    }
    public int GetNrOfAvailableFlightAtendents(){
        int result = 0;
        for(FlightAtendent pilot:FlightAtendentList)
            if(pilot.IsAvailable())
                result++;
        return result;
    }
    public int GetNrOfAvailableBagageHandlers(){
        int result = 0;
        for(BagageHandler pilot:BagageHandlerList)
            if(pilot.IsAvailable())
                result++;
        return result;
    }
    public int GetNrOfAvailableFuelHandlers(){
        int result = 0;
        for(FuelHandler pilot:FuelHandlerList)
            if(pilot.IsAvailable())
                result++;
        return result;
    }
}
