package com.thenewprogramming.citydefense.server;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class City {
    
    private int id;
    
    private int OwnerId;
    
    private String Name;
    private ArrayList<Unit> Units = new ArrayList<Unit>();
    private ArrayList<CityTile> CityTiles = new ArrayList<CityTile>();
    
    private int StoragePerRecourse;
    
    private int CoinSupply;
    private int StoneSupply;
    private int IronSupply;
    private int WoodSupply;
    private int FoodSupply;
    
    private int EmployedPopulation;
    private int Population;
    
    private int points;
    
    int xCordinate;
    int yCordinate;
    
    
    public City(int id, int ownerid, String name, int xCordinate, int yCordinate){
        this.id = id;
        OwnerId = ownerid;
        Name = name;
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
    }
    
    public void update(){
        for(int i = 0; i < CityTiles.size(); i++){
            /*if(CityTiles.get(i).getClass().getSuperclass() == Building.class){
                ((Building)CityTiles.get(i)).update();
            }*/
            
            CityTiles.get(i).update();
        }
        
    }
    
    public void addToSupply(String Recource, int amount){
        switch(Recource){
            case "Coin":
                CoinSupply = CoinSupply + amount;
                if(CoinSupply > StoragePerRecourse){
                    CoinSupply = StoragePerRecourse;
                }
            
            case "Wood":
                WoodSupply = WoodSupply + amount;
                if(WoodSupply > StoragePerRecourse){
                    WoodSupply = StoragePerRecourse;
                }
            
            case "Stone":
                StoneSupply = StoneSupply + amount;
                if(StoneSupply > StoragePerRecourse){
                    StoneSupply = StoragePerRecourse;
                }
            
            case "Iron":
                IronSupply = IronSupply + amount;
                if(IronSupply > StoragePerRecourse){
                    IronSupply = StoragePerRecourse;
                }
            
            case "Food":
                FoodSupply = FoodSupply + amount;
                if(FoodSupply > StoragePerRecourse){
                    FoodSupply = StoragePerRecourse;
                }
            
        }
    }
    
    public int getPopulation(){
        return Population;
    }
    
    public void IncreasePopulation(int howMany){
        Population = Population + howMany;
    }
    
    public void DecreasePopulation(int howMany) {
        Population = Population - howMany;
    }
    
    public int getEmployedPopulation(){
        return EmployedPopulation;
    }
    
    public void IncreaseEmployedPopulation(int howMany){
        EmployedPopulation = EmployedPopulation + howMany;
    }
    
    public void DecreaseEmployedPopulation(int howMany){
        EmployedPopulation = EmployedPopulation - howMany;
    }
    
    public int getId(){
        return id;
    }
    
    public int getOwnerId(){
        return OwnerId;
    }

    public void increasePoints(int howMany) {
        points = points + howMany;
    }
    
    public CityTile getCityTileByLocation(int location){
        for(int i = 0; i < CityTiles.size(); i++){
            if(CityTiles.get(i).getLocation() == location){
                return CityTiles.get(i);
            }
        }
        return null;
    }
    
    public String getName() {
        return Name;
    }

    public int getStoragePerRecourse() {
        return StoragePerRecourse;
    }

    public int getCoinSupply() {
        return CoinSupply;
    }

    public int getStoneSupply() {
        return StoneSupply;
    }

    public int getIronSupply() {
        return IronSupply;
    }

    public int getWoodSupply() {
        return WoodSupply;
    }

    public int getFoodSupply() {
        return FoodSupply;
    }
    
    public int[] getLocation(){
        return new int[]{xCordinate, yCordinate};
    }
    
    /*public void createBuilding(int location, Class BuildingType, int level){
        Building createdBuilding;
        try{
            createdBuilding = (Building) BuildingType.getConstructors()[0].newInstance(new Object[]{this.id, location, level});
        }
        catch(SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            System.out.println("Error when creating building!");
            e.printStackTrace();
            return;
        }
        CityTiles.add(createdBuilding);
    }*/
    
    public int getAmountOfBuildings(){
        int returnvalue = 0;
        for(int i = 0; i < CityTiles.size(); i++){
            if(CityTiles.get(i).getClass().getSuperclass() == Building.class || CityTiles.get(i).getClass().getSuperclass().getSuperclass() == Building.class){
                returnvalue++;
            }
        }
        return returnvalue;
    }
    
    public void buildNewBuilding(int Location, String BuildingType){
        Building newBuilding;
        if(CityTiles.get(Location).getClass() != CityTileEmpty.class){
            System.out.println("Something went wrong, method buildNewBuilding(location, BuildingType) was called with a location containing a building.");
            System.out.println("ID: " + id + ", Name: " + Name + ", OwnerId: " + OwnerId);
        }
        if(BuildingType.equalsIgnoreCase("Lumberjack")){
            newBuilding = new BuildingLumberjack(this.id, Location, 0);
        }
        else{
            return;
        }
        CityTiles.set(Location, newBuilding);
    }
    
    public void upgradeBuilding(int BuildingLocation){
        Building b;
        b = (Building) CityTiles.get(BuildingLocation);
        
        this.addToSupply("Wood", -b.getCostToNextLevel()[0]);
        this.addToSupply("Stone", -b.getCostToNextLevel()[1]);
        this.addToSupply("Iron", -b.getCostToNextLevel()[2]);
        
        b.startUpgrade();
    }
}
