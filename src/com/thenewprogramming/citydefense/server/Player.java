package com.thenewprogramming.citydefense.server;

public class Player {
    private int id;
    private String Name;
    
    public Player(int id, String name){
        this.id = id;
        Name = name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return Name;
    }
    
}
