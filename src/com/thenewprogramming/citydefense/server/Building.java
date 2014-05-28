package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

public class Building extends CityTile{
    
    
    protected int level;
    
    protected int maxLevel;
    protected int[][] CostToLevel = new int[5][maxLevel];/*Stone, Iron, Population, Wood and Time*/
    protected ArrayList<Integer> PointsPerUpgrade;
    protected boolean IsUpgrading;
    protected int ticksUntilEndOfConstruction; //Een tick is een game update, dit is waarschijnlijk gelijk aan het aantal seconden.
    
    public Building(int city, int location){
        super(city, location);
    }
    
    public Building(int city, int location, int level){
        super(city, location);
        this.level = level;
    }
    
    @Override
    public void update(){
        continueUpgrade();
    }
    
    /**
     * Meant to be overridden, called when building has finished construction.
     */
    public void onBuild(){
        level = 1;
    }
    
    /**
     * Meant to be overridden, called when building has finished destruction.
     */
    public void onDestroy(){
        level = 0;
    }
    
    /**
     * Meant to be overridden, called when building has finished upgrading.
     */
    public void onUpgradeFinished(){
        level++;
        Server.GetCityById(City).increasePoints(PointsPerUpgrade.get(level));
        IsUpgrading = false;
        ticksUntilEndOfConstruction = 0;
        Server.GetCityById(City).IncreaseEmployedPopulation(CostToLevel[2][level]);
        
    }
    
    public int[] getCostToNextLevel(){
        return CostToLevel[level];
    }
    
    public void startUpgrade(){
        IsUpgrading = true;
        ticksUntilEndOfConstruction = CostToLevel[4][level];
    }
    
    protected void continueUpgrade(){
        if(IsUpgrading){
            int PopulationWorkingOnBuild = Server.GetCityById(City).getPopulation() - Server.GetCityById(City).getEmployedPopulation() + CostToLevel[2][level];
            if(ticksUntilEndOfConstruction == 0){
                this.onUpgradeFinished();
            }
            else if(PopulationWorkingOnBuild <= 25){
                ticksUntilEndOfConstruction = ticksUntilEndOfConstruction - PopulationWorkingOnBuild;
            }
            else if(PopulationWorkingOnBuild > 25){
                ticksUntilEndOfConstruction = ticksUntilEndOfConstruction - 25;
            }
        }
    }
}
