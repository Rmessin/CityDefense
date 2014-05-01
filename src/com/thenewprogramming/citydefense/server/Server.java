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
    private static int nextCityId = 0;
    private static int nextPlayerId;
    private static ArrayList<City> Cities = new ArrayList<City>();
    private static ArrayList<Player> Players = new ArrayList<Player>();
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
    
    public static City GetCityByName(String cityName){
        
        for(int i=0; i < Cities.size(); i++){
            if(Cities.get(i).getName().equalsIgnoreCase(cityName)){
                return Cities.get(i);
            }
        }
        return null;
    }
    
    public static City GetCityByLocation(int x, int y){
        int[] location = new int[]{x, y};
        for(int i=0; i < Cities.size(); i++){
            if(Cities.get(i).getLocation()==location){
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
    
    public static Player GetPlayerByName(String playerName){
        
        for(int i=0; i < Players.size(); i++){
            if(Players.get(i).getName().equalsIgnoreCase(playerName)){
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
    
    public static ArrayList<City> getCities(){
        return Cities;
    }
    
    public static ArrayList<Player> getPlayers(){
        return Players;
    }
    
    
    /**
     * 
     * @param player
     * @param name
     * @param locationx
     * @param locationy
     * @return the id of the newly created city, -1 if the player doesn't exist, -2 if there is a city at that location already.
     */
    static int createCity(String player, String name, int locationx, int locationy) {
        Player Player = GetPlayerByName(player);
        if(Player == null){
            return -1;//-1 is the error value als de player niet bestaat...
        }
        int PlayerId = GetPlayerByName(player).getId();
        
        if(GetCityByLocation(locationx, locationy)!=null){
            return -2;//-2 is de error value als er al een city staat op die locatie...
        }
        
        City createdCity = new City(nextCityId, PlayerId, name, locationy, locationy);
        Cities.add(createdCity);
        nextCityId++;
        return createdCity.getId();
    }
    
    /**
     * 
     * @param name
     * @return the id of the newly created player, -1 if a player with that name already exists, -2 if the name is not valid. 
     */
    static int createPlayer(String name){
        for(int i=0; i < Players.size(); i++){
            if(Players.get(i).getName().equalsIgnoreCase(name)){
                return -1;
            }
        }
        if(name.equalsIgnoreCase("")){
            return -2;
        }
        
        Player createdPlayer = new Player(nextPlayerId, name);
        nextPlayerId++;
        Players.add(createdPlayer);
        return createdPlayer.getId();
    }
    
}
