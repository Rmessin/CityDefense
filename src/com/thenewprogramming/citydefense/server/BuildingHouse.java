package com.thenewprogramming.citydefense.server;

//TODO Make tax-income be a thing...

public class BuildingHouse extends Building {

    
    public BuildingHouse(int city, int location){
        super(city, location);
    }
    
    @Override
    public void onBuild(){
        Server.GetCityById(City).IncreasePopulation(10);
    }
    
    @Override
    public void onDestroy(){
        Server.GetCityById(City).DecreasePopulation(10);
    }
    
    @Override
    public void onUpgrade(){
        level++;
    }
    
    @Override
    public void onDowngrade(){
        level--;
    }
    
}
