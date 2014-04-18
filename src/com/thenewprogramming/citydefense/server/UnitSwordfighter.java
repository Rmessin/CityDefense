/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

import static com.thenewprogramming.citydefense.server.Unit.UnitType;

/**
 *
 * @author Reijer
 */
public class UnitSwordfighter extends Unit{
    
    @Override
    public void initUnit(){
        UnitType = "Infantry";
        Name = "Sword Fighter";
        
        MaxHealth = 70;
        
    }
}
