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
    public void onUpgradeFinished(){
        level++;
        Server.GetCityById(City).increasePoints(PointsPerUpgrade.get(level));
        IsUpgrading = false;
        ticksUntilEndOfConstruction = 0;
        Server.GetCityById(City).IncreaseEmployedPopulation(CostToLevel[2][level]);
        
    }
    
}
