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
public class Unit {
    
    protected int Health;
    protected static int MaxHealth;
    protected static String Name;
    
    /**
     * Choices are:
     * "Infantry"
     * "Archery"
     * "Cavalry"
     * "Siege Equipment"
     */
    protected static String UnitType;
    
    protected int DamageMelee;
    
    protected int DefenseInfantry;
    protected int DefenseArchery;
    protected int DefenseCavalary;
    
    public void initUnit(){
        
    }
    
}
