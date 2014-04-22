package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

public class CityTile {
    protected String Discription;
    protected String Name;
    protected int City;
    protected int Location;
    
    
    public void update(){
        
    }
    
    public CityTile(int city, int location){
        this.City = city;
        this.Location = location;
    }
    
    public int getLocation(){
        return Location;
    }
    
    protected ArrayList<CityTile> GetSurroundingCityTiles(){
        ArrayList<CityTile> ReturnValue = new ArrayList<CityTile>();
        int[] SurroundingTileNumbersRelative = {-8, -7, -6, -1, 1, 6, 7, 8};
        
        for(int i = 0; i < 8; i++){
            ReturnValue.add(Server.GetCityById(City).getCityTileByLocation(Location+SurroundingTileNumbersRelative[i]));
        }
        
        return ReturnValue;
        
        
    }
    
}
