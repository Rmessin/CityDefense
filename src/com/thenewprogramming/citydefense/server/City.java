package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

public class City {
    
    private int id;
    
    private int OwnerId;
    
    private String Name;
    private ArrayList<Unit> Units;
    private ArrayList<CityTile> CityTiles;
    
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
    
    //de eerste letter is de x-waarde, de tweede letter is de y-waarde
    
    
    private CityTile AA;
    private CityTile AB;
    private CityTile AC;
    private CityTile AD;
    private CityTile AE;
    private CityTile AF;
    private CityTile AG;

    private CityTile BA;
    private CityTile BB;
    private CityTile BC;
    private CityTile BD;
    private CityTile BE;
    private CityTile BF;
    private CityTile BG;
    
    private CityTile CA;
    private CityTile CB;
    private CityTile CC;
    private CityTile CD;
    private CityTile CE;
    private CityTile CF;
    private CityTile CG;
    
    private CityTile DA;
    private CityTile DB;
    private CityTile DC;
    private CityTile DD;
    private CityTile DE;
    private CityTile DF;
    private CityTile DG;
    
    private CityTile EA;
    private CityTile EB;
    private CityTile EC;
    private CityTile ED;
    private CityTile EE;
    private CityTile EF;
    private CityTile EG;
    
    private CityTile FA;
    private CityTile FB;
    private CityTile FC;
    private CityTile FD;
    private CityTile FE;
    private CityTile FF;
    private CityTile FG;
    
    private CityTile GA;
    private CityTile GB;
    private CityTile GC;
    private CityTile GD;
    private CityTile GE;
    private CityTile GF;
    private CityTile GG;
    
    
    public City(int xCordinate, int yCordinate){
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
    }
    
    public void update(){
        for(int i = 0; i < CityTiles.size(); i++){
            if(CityTiles.get(i).getClass().getSuperclass() == Building.class){
                ((Building)CityTiles.get(i)).update();
            }
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
}
