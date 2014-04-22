/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;

/**
 *
 * @author Reijer
 */
public class WebclientHandler implements Runnable{
    
    private static boolean exit = false;
    
    public static void main(String[] args){
        (new WebclientHandler()).run();
    }
    
    @Override
    public void run(){
        try{
            ListenForData();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void ListenForData() throws IOException{
        ServerSocket serverSocket = new ServerSocket(6789);
        
        while(!exit){
            Socket connectionSocket = serverSocket.accept();
            BufferedReader incomingReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outgoingStream = new DataOutputStream(connectionSocket.getOutputStream());
            String webclientRequestLine = incomingReader.readLine();
            System.out.println("Got request: " + webclientRequestLine);
            System.out.println("now handling request....");
            HandleRequest(webclientRequestLine, outgoingStream);
            connectionSocket.close();
        }
        
    }
    
    private String loadPage(String[] query) {
        if (query.length < 3) return "Protocol mismatch";
        switch (query[2]) {
            case "overview": Resources(Integer.parseInt(query[0]));
                             break;
        }
    }
    
    private void HandleRequest(String webclientRequestLine, DataOutputStream outgoingStream) throws IOException{
        String[] query = webclientRequestLine.split(" ");
        switch (query[1]) {
            case "get": outgoingStream.writeBytes(loadPage(query));
                        break;
            default: outgoingStream.writeBytes("Protocol mismatch");
                     break;
        }
    }
}

class Resources {
    private int coins;
    private int stone;
    private int iron;
    private int wood;
    private int food;
    
    Resources(int cityId) {
        new Resources(Server.GetCityById(cityId));
    }
    
    Resources(City city) {
        coins = city.getCoinSupply();
        stone = city.getSronSupply();
        iron = city.getIronSuplly();
        wood = city.getWoodSupply();
        food = city.getFoodSupply();
    }
}