package org.example;

import java.util.ArrayList;
import java.util.List;

public class CrewList {

    public List<Pilot> PilotList;
    public List<FlightAtendent> FlightAtendentList;
    public List<BagageHandler> BagageHandlerList;
    public List<FuelHandler> FuelHandlerList;
    private List<Crew> CrewList;
    public CrewList(){
        PilotList = new ArrayList<>();
        FlightAtendentList = new ArrayList<>();
        BagageHandlerList = new ArrayList<>();
        FuelHandlerList = new ArrayList<>();
        CrewList = new ArrayList<>();
    }

    public void add(Crew crew){
        if(crew instanceof Pilot){PilotList.add((Pilot)crew);
        }else if (crew instanceof FlightAtendent) {FlightAtendentList.add((FlightAtendent) crew);
        }else if (crew instanceof BagageHandler) {BagageHandlerList.add((BagageHandler) crew);
        }else if (crew instanceof FuelHandler) {FuelHandlerList.add((FuelHandler) crew);
        }
        CrewList.add(crew);
    }

    public List<Crew> GetAvailableFlightCrew(){
        List<Crew> crewList = new ArrayList<>();

        for(Crew crew:CrewList){
            if((crew instanceof Pilot || crew instanceof FlightAtendent)&& crew.IsAvailable()){
                crewList.add(crew);
            }
        }
        return crewList;
    }

    public List<BagageHandler> GetAvailableBagageHandler(){
        List<BagageHandler> crewList = new ArrayList<>();

        for(Crew crew:CrewList){
            if(crew instanceof BagageHandler && crew.IsAvailable()){
                crewList.add((BagageHandler) crew);
            }
        }

        return crewList;
    }

    public int GetNrOfAvailableCrew(){
        return GetNrOfAvailableBagageHandlers()+GetNrOfAvailableFuelHandlers()+GetNrOfAvailablePilots()+GetNrOfAvailableFlightAtendents();
    }
    public int GetNrOfUnavailableCrew(){
        return CrewList.size()-GetNrOfAvailableCrew();
    }

    public List<Crew> GetAvailableCrewList(){
        List<Crew> AvailableCrewList = new ArrayList<>();
        for(Crew crew:CrewList)
            if(crew.IsAvailable())
                AvailableCrewList.add(crew);
        return AvailableCrewList;
    }
    public List<Crew> GetUnAvailableCrewList(){
        List<Crew> UnAvailableCrewList = new ArrayList<>();
        for(Crew crew:CrewList)
            if(!crew.IsAvailable())
                UnAvailableCrewList.add(crew);
        return UnAvailableCrewList;
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
