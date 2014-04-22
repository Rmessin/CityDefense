/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Reijer
 */
public class GameLoopHandler implements Runnable{
    
    private boolean stop;
    
    private ArrayList<City> Cities;
    private ArrayList<Player> Players;
    
    @Override
    public void run(){
        Start();
    }
    
    private void Start(){
        Cities = Server.getCities();
        Players = Server.getPlayers();
        
        Timer t = new Timer(1000, new ActionListener(){
          public void actionPerformed(ActionEvent e){
              update();
          }
       });
    }
    
    public void update(){
        for(int i = 0; i < Cities.size(); i++){
            Cities.get(i).update();
        }
    }
    
}
