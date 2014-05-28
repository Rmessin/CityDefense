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
public class BuildingLumberjack extends BuildingRecourseProducer{
    
    
    public BuildingLumberjack(int city, int location, int level){
        super(city, location, "Wood", LandscapeForest.class);
        Name = "Lumberjack";
        this.level = level;
        secondsFromLastProduction = 0;
        BaseProduction = 10;
    }
    
}
