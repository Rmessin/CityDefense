package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

public class Building extends CityTile{
    
    
    protected int level;
    
    protected int maxLevel;
    protected int[][] CostToLevel = new int[5][maxLevel+1];/*Stone, Iron, Population, Wood and Time*/
    protected ArrayList<Integer> PointsPerUpgrade;
    protected boolean IsUpgrading;
    protected int ticksUntilEndOfProduction; //Een tick is een game update, dit is waarschijnlijk gelijk aan het aantal seconden.
    
    public Building(int city, int location){
        super(city, location);
    }
    
    public void update(){
        if(IsUpgrading){
            int PopulationWorkingOnBuild = Server.GetCityById(City).getPopulation() - Server.GetCityById(City).getEmployedPopulation() + CostToLevel[2][level];
            if(ticksUntilEndOfProduction == 0){
                this.onUpgrade();
            }
            else if(PopulationWorkingOnBuild <= 25){
                ticksUntilEndOfProduction = ticksUntilEndOfProduction - PopulationWorkingOnBuild;
            }
            else if(PopulationWorkingOnBuild > 25){
                ticksUntilEndOfProduction = ticksUntilEndOfProduction - 25;
            }
        }
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
        
    }
    
    /**
     * Meant to be overridden, called when building has finished upgrading.
     */
    public void onUpgrade(){
        level++;
        Server.GetCityById(City).increasePoints(PointsPerUpgrade.get(level));
        IsUpgrading = false;
        ticksUntilEndOfProduction = 0;
    }
    
    /**
     * Meant to be overridden, called when building has finished downgrading.
     */
    public void onDowngrade(){
        Server.GetCityById(City).increasePoints(PointsPerUpgrade.get(level));
        level--;
    }
    
    public int[] getCostToNextLevel(){
        return CostToLevel[level];
    }
    
    public void startUpgrade(){
        IsUpgrading = true;
        ticksUntilEndOfProduction = CostToLevel[4][level];
    }
}
