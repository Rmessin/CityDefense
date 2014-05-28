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
    Timer t = null;
    
    @Override
    public void run(){
        Start();
    }
    
    private void Start(){
        
        t = new Timer(1000, new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              update();
          }
        });
        t.start();
    }
    
    public void update(){
        if(stop){
            t.stop();
        }
        for(int i = 0; i < Server.getCities().size(); i++){
            Server.getCities().get(i).update();
        }
    }
    
    public void Stop(){
        stop = true;
    }
    
}
