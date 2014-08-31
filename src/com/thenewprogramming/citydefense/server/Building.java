package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

public class Building extends CityTile{
    
    
    protected int level;
    
    protected int maxLevel;
    protected int[][] CostToLevel = new int[maxLevel][5];/*Wood, Stone, Iron, Population & Time*/
    protected ArrayList<Integer> PointsPerUpgrade;
    protected boolean IsUpgrading;
    protected int remainingUpgradeTime = 0;
    protected int unemployedPopulationWorkingOnUpgrade;
    
    public Building(int city, int location){
        super(city, location);
    }
    
    public Building(int city, int location, int level){
        super(city, location);
        this.level = level;
    }
    
    @Override
    public void update(){
        if(IsUpgrading){
            continueUpgrade();
        }
    }
    
    /**
     * Gives an array of ints that indicate the cost for this building to be upgraded to the next level
     * 
     * @return The array containing the ints, in order of: Wood, Stone, Iron, Population & Time 
     */
    public int[] getCostToNextLevel(){
        return CostToLevel[level];
    }
    
    public void startUpgrade(){
        IsUpgrading = true;
        int standardUpgradeLength = CostToLevel[level][4];
        
        //Check for unemployed population to help upgrade
        if(Server.GetCityById(City).getPopulation() - Server.GetCityById(City).getEmployedPopulation() <= 10){
            unemployedPopulationWorkingOnUpgrade = Server.GetCityById(City).getPopulation() - Server.GetCityById(City).getEmployedPopulation();
        }
        else if(Server.GetCityById(City).getPopulation() - Server.GetCityById(City).getEmployedPopulation() > 10){
            unemployedPopulationWorkingOnUpgrade = 10;
        }
        else{
            unemployedPopulationWorkingOnUpgrade = 0;
        }
        Server.GetCityById(City).IncreaseEmployedPopulation(unemployedPopulationWorkingOnUpgrade);
        
        //Calculate the time it will take for the upgrade to finish
        double timeSaved = unemployedPopulationWorkingOnUpgrade * 0.05 * standardUpgradeLength;
        double newUpgradeLength = standardUpgradeLength - timeSaved;
        remainingUpgradeTime = (int) Math.round(newUpgradeLength);
        
        
    }
    protected void continueUpgrade(){
        remainingUpgradeTime--;
        if(remainingUpgradeTime == 0){
            this.onUpgradeFinished();
        }
    }
    protected void onUpgradeFinished(){
        IsUpgrading = false;
        remainingUpgradeTime = 0;
        Server.GetCityById(City).DecreaseEmployedPopulation(unemployedPopulationWorkingOnUpgrade);
        
        Server.GetCityById(City).IncreaseEmployedPopulation(CostToLevel[level][3]);
        Server.GetCityById(City).increasePoints(PointsPerUpgrade.get(level));
        level++;
        
        
    }
    public int getRemaingingUpgradeTime(){
        return remainingUpgradeTime;
    }
}
