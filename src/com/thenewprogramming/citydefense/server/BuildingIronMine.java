/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

/**
 *
 * @author Reijer
 */
public class BuildingIronMine extends BuildingRecourseProducer{
    
    public BuildingIronMine(int city, int location, int level){
        super(city, location, "Iron", LandscapeIron.class);
        Name = "Iron Mine";
        this.level = level;
        secondsFromLastProduction = 0;
        BaseProduction = 10;
    }
    
}
