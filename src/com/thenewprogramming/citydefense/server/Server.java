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
public class Server {
    
    private static ArrayList<City> Cities;
    private static ArrayList<Player> Players;
    private static ArrayList<Building> BuildingTypes;
    
    
    public static void Init(){
        
        InitBuildingTypes();
        
        LoadCities();
        LoadPlayers();
    }
    
    
    /**
     * Gets the city with the specified id. Returns null if city is not found.
     * @param cityId
     * @return The City with the id specified
     */
    public static City GetCityById(int cityId){
        
        for(int i=0; i < Cities.size(); i++){
            if(Cities.get(i).getId() == cityId){
                return Cities.get(i);
            }
        }
        return null;
    }
    
    public static Player GetPlayerById(int playerId){
        
        for(int i=0; i < Players.size(); i++){
            if(Players.get(i).getId() == playerId){
                return Players.get(i);
            }
        }
        return null;
    }
    
    
    private static void InitBuildingTypes(){
        //TODO: Read all buildingfiles from directory and isert data into Building class.
        
        
        
    }

    private static void LoadCities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO: Read all CityData from file in directory and insert that data into Server class.
    }

    private static void LoadPlayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO: Read all PlayerData from file in directory and insert that data into Server class.
    }
    
    
    
    
}
