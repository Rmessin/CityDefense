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
public class UnitAxefighter extends Unit{
    
    @Override
    public void initUnit(){
        UnitType = "Infantry";
        Name = "Axe Fighter";
        
        MaxHealth = 70;
        
    }
    
}
