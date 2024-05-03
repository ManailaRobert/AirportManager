package org.example;

import java.util.*;

public class Plane {
   private  String id;
    private int Level;
    private int Price;
   private Pilot pilot;
   private List<FlightAtendent> FlightAtendents;
   private List<BagageHandler> BagageHandlers;
   private List<FuelHandler> FuelHandlers;
   private int MaxPassagers;
   private int CurentPassagers;
   private int CurentFuel;
   public int MaxFlightAtendents;
   private boolean BagagesLoaded;

   private int distance;
   private int NeededBagageHandlers;
    private int NeededFuelHandlers;

    private int RefuelPrice;

    private String Status;
    private boolean Available;
    public boolean IsAvailable(){
        return Available;
    }
    public void SetAvailability(boolean availability){
        Available = availability;
    }
    public String getStatus() {
        return Status;
    }

    public String GetID(){
        return "#" + id;
    }
    public void setStatus(String status) {
        Status = status;
    }
public boolean IsUndockable()
{
    if(CurentPassagers > 0 || IsLoadedWithBagages() )
        return true;
    return false;
}
   public boolean IsEligibleToFly(){
        if(pilot == null)
            return false;
        if (FlightAtendents.size()!=MaxFlightAtendents)
            return false;
        if(!IsFueled())
            return false;
        if(!IsLoadedWithBagages())
            return false;
        if(CurentPassagers == 0)
            return false;
        return true;
    }

    public int getPrice() {
        return Price;
    }

    //fuel
   public boolean IsFueled(){
       return  CurentFuel == 100;
    }
   public void FuelUp(){
        CurentFuel = 100;
    }
    public int GetNeededFuelhandlers(){
        return NeededFuelHandlers;
    }
    public void clearFuelHandlers() {
        for(FuelHandler fuelHandler:FuelHandlers)
            fuelHandler.SetAvailability(true);
        FuelHandlers.clear();
    }
    public void addFuelHandlers(CrewList crewList) {
        int nr = 0;
        for(FuelHandler fuelHandler:crewList.FuelHandlerList){
            if(fuelHandler.IsAvailable()) {
                fuelHandler.SetAvailability(false);
                FuelHandlers.add(fuelHandler);
                nr++;
                if(nr == NeededFuelHandlers) break;
            }
        }
    }
    public  int GetRefuelPrice(){
        return  RefuelPrice;
    }

   //bagages
   public  boolean IsLoadedWithBagages(){
        return  BagagesLoaded;
    }
   public  void LoadBagages(){
        BagagesLoaded = true;
    }
    public  void UnLoadBagages(){
        BagagesLoaded = false;
    }
    public int GetNeededBagagehandlers(){
       return NeededBagageHandlers;
    }
    public void clearBagageHandlers() {
        for(BagageHandler bagageHandlers:BagageHandlers)
            bagageHandlers.SetAvailability(true);
        BagageHandlers.clear();
    }
    public void addBagageHandlers(CrewList crewList) {
        int nr = 0;
        for(BagageHandler bagageHandler:crewList.BagageHandlerList){
            if(bagageHandler.IsAvailable()) {
                bagageHandler.SetAvailability(false);
                BagageHandlers.add(bagageHandler);
                nr++;
                if(nr == NeededBagageHandlers) break;
            }
        }
    }


   //pilot
    public Pilot GetPilot(){
       return pilot;
    }
    public void SetPilot(Pilot Pilot){
       pilot=Pilot;
    }
    public  void RemovePilot(){
        pilot.setAssignedPlane(null);
        pilot = null;
    }
   //flight atendents
    public List<FlightAtendent> GetFlightAtendentList(){
       return FlightAtendents;
    }
    public void AddFlightAtendents(FlightAtendent FlightAtendent){
       if(FlightAtendents.size() < MaxFlightAtendents)
        FlightAtendents.add(FlightAtendent);
    }
    public  int GetMaxFlightAtendents(){
       return MaxFlightAtendents;
    }

    public int GetNumberOfFlightAtendents (){
       return FlightAtendents.size();
    }

    //passagers
    public int GetCurentPassagers(){
       return CurentPassagers;
    }
    public void BoardPassagers (int NrPassagers){
       if(CurentPassagers+NrPassagers <= MaxPassagers)
           CurentPassagers+=NrPassagers;
    }
    public void UnBoardPassagers (){
            CurentPassagers=0;
    }
    public int GetMaxPassagers(){
       return MaxPassagers;
    }

   public  Plane(int level,String status){
       Random random = new Random();
       String[] prefix = {"FX","RX","ZX","NX","KX","LX","PX","OX","BX","GX","TX","EX","IX","SX","WX","CX","JX","HX"};
       Available = true;
       pilot = null;
       FlightAtendents = new ArrayList<>();
       BagageHandlers = new ArrayList<>();
       FuelHandlers = new ArrayList<>();
       Status = status;
       BagagesLoaded =false;
       distance = 1;
       switch (level){
           case 1:
               Level = level;
               MaxPassagers = 50;
               CurentPassagers = 0;
               CurentFuel = 0;
               MaxFlightAtendents = 2;
               NeededBagageHandlers = 4;
               NeededFuelHandlers = 3;
               RefuelPrice = 250;
               Price = 5000;

               CurentPassagers = 10;
               BagagesLoaded =true;


               id = prefix[random.nextInt(prefix.length)]+"1"+random.nextInt(99) ;
               break;
           case 2:
               Level = level;

               MaxPassagers = 100;
               CurentPassagers = 0;
               CurentFuel = 0;
               MaxFlightAtendents = 3;
               NeededBagageHandlers = 6;
               NeededFuelHandlers = 4;
               RefuelPrice = 500;
               Price = 10000;

               id = prefix[random.nextInt(prefix.length)]+"2"+random.nextInt(10,99) ;
               break;
           case 3:
               Level = level;
               MaxPassagers = 150;
               CurentPassagers = 0;
               CurentFuel = 0;
               MaxFlightAtendents = 4;
               NeededBagageHandlers = 8;
               NeededFuelHandlers = 5;
               RefuelPrice = 750;
               Price = 15000;

               id = prefix[random.nextInt(prefix.length)]+"3"+random.nextInt(10,99) ;
               break;
           case 4:
               Level = level;
               MaxPassagers = 200;
               CurentPassagers = 0;
               CurentFuel = 0;
               MaxFlightAtendents = 5;
               NeededBagageHandlers = 10;
               NeededFuelHandlers = 6;
               RefuelPrice = 1000;
               Price = 20000;

               id = prefix[random.nextInt(prefix.length)]+"4"+random.nextInt(10,99) ;
               break;
           case 5:
               Level = level;
               MaxPassagers = 250;
               CurentPassagers = 0;
               CurentFuel = 0;
               MaxFlightAtendents = 6;
               NeededBagageHandlers = 12;
               NeededFuelHandlers = 7;
               RefuelPrice = 1250;
               Price = 25000;

               id = prefix[random.nextInt(prefix.length)]+"5"+random.nextInt(10,99) ;
               break;
           default:
               Level = level;
               MaxPassagers = 350;
               CurentPassagers = 0;
               CurentFuel = 0;
               NeededBagageHandlers = 15;
               NeededFuelHandlers = 10;
               RefuelPrice = 1850;
               Price = 45000;

               id = "ZZX"+"9"+random.nextInt(10,99) ;
               break;
       }
   }

    @Override
    public String toString() {
        return "#"+id + " Plane - LVL "+ Level;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
