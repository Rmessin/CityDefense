/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

import java.util.ArrayList;

/**
 *
 * @author Reijer
 */
public class BuildingLumberjack extends Building{
    
    
    private int secondsFromLastProduction;
    private int BaseProduction;
    private int ExtraProduction;
    
    
    public BuildingLumberjack(int city, int location){
        super(city, location);
        Name = "Lumberjack";
        secondsFromLastProduction = 0;
        BaseProduction = 10;
    }
    
    @Override
    public void update(){
        CheckSurroundingTiles();
        ProduceGoods();
    }
    
    private void CheckSurroundingTiles(){
        ArrayList<CityTile> SurroundingTiles = this.GetSurroundingCityTiles();
        int NumberOfUsefulSurroundings = 0;
        
        for(int i = 0; i < SurroundingTiles.size(); i++){
            if(SurroundingTiles.get(i).getClass() == LandscapeForest.class){
                NumberOfUsefulSurroundings++;
            }
        }
        try{
            ExtraProduction = (int) ((0.10 * NumberOfUsefulSurroundings) * BaseProduction);
        }
        catch(Exception e){
            
        }
        
    }
    
    private void ProduceGoods() {
        BaseProduction = 10 * level;
        if(secondsFromLastProduction == 5){
            Server.GetCityById(City).addToSupply("Wood", BaseProduction + ExtraProduction);
            secondsFromLastProduction = 0;
        }
        else{
            secondsFromLastProduction++;
        }
    }
    
    @Override
    public void onUpgrade(){
        level++;
        //Server.GetCityById(City).IncreasePopulation(2);
    }
    
    @Override
    public void onDowngrade(){
        level--;
    }
    
}
