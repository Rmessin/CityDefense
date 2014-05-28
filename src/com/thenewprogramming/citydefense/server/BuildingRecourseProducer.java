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
public class BuildingRecourseProducer extends Building{
    
    protected int secondsFromLastProduction;
    protected int BaseProduction;
    protected int ExtraProduction;
    protected String RecourseToProduce;
    protected Class UseFullSurroundingTile;
    
    public BuildingRecourseProducer(int city, int location, String recourseToProduce, Class useFullSurroundingTile) {
        super(city, location);
        this.RecourseToProduce = recourseToProduce;
        this.UseFullSurroundingTile = useFullSurroundingTile;
    }
    
    @Override
    public void update(){
        continueUpgrade();
        CheckSurroundingTiles();
        ProduceGoods();
    }
    
    protected void CheckSurroundingTiles(){
        ArrayList<CityTile> SurroundingTiles = this.GetSurroundingCityTiles();
        int NumberOfUsefulSurroundings = 0;
        
        for(int i = 0; i < SurroundingTiles.size(); i++){
            if(SurroundingTiles.get(i).getClass() == UseFullSurroundingTile){
                NumberOfUsefulSurroundings++;
            }
        }
        try{
            ExtraProduction = (int) ((0.10 * NumberOfUsefulSurroundings) * BaseProduction);
        }
        catch(Exception e){
            
        }
        
    }
    
    protected void ProduceGoods() {
        BaseProduction = 10 * level;
        if(secondsFromLastProduction == 5){
            Server.GetCityById(City).addToSupply(RecourseToProduce, BaseProduction + ExtraProduction);
            secondsFromLastProduction = 0;
        }
        else{
            secondsFromLastProduction++;
        }
    }
    
}
