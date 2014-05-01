/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thenewprogramming.citydefense.server;

import java.io.Console;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reijer
 */
public class ConsoleHandler implements Runnable{
    
    private static boolean exit = false;
    
    public static void main(String[] args){
        Start();
    }
    
    public static void Start(){
         ListenToCommands();
    }
    
    private static void ListenToCommands() {
        if (System.console() != null) {
            Scanner s = new Scanner(System.in);
            System.out.print("> ");
            while(s.hasNext() && !exit){
                String cmdline = s.nextLine();
                String[] slicedCommandLine = SliceInput(cmdline);
                HandleCommand(slicedCommandLine);
                if(exit){return;}
                if(!slicedCommandLine[0].equalsIgnoreCase("")){//voorkom heel veel > als je eerst een paar keer op enter drukt...
                    System.out.print("> ");
                }
            }
        }
    }

    
    
    
    @Override
    public void run() {
        Start();
    }
    
    private static String[] SliceInput(String cmdline){
        return cmdline.split(" ");
    }
    
    
    private static void HandleCommand(String[] slicedCommand) {
        String cmd = slicedCommand[0];
        
        if(cmd.equalsIgnoreCase("")){return;}
        
        if(cmd.equalsIgnoreCase("help")){ ShowHelp(slicedCommand);}
        else if(cmd.equalsIgnoreCase("exit")){ Exit(slicedCommand);}
        else if(cmd.equalsIgnoreCase("city")){ City(slicedCommand);}
        else if(cmd.equalsIgnoreCase("test")){ Test(slicedCommand);}
        else if(cmd.equalsIgnoreCase("player")){ Player(slicedCommand);}
        else{
            System.out.println("ERROR: Command not found.");
            ShowHelp(slicedCommand);
        }
        
    }
    
    private static void Test(String[] slicedCommand) {
        System.out.println(java.util.Arrays.toString(slicedCommand));
    }
    
    private static void Exit(String[] slicedCommand) {
        exit = true;
    }
    
    private static void ShowHelp(String[] slicedCommand) {
        //TODO add help texts for specific commands
        System.out.println("I am the help text.");
        
        if(slicedCommand[0].equalsIgnoreCase("City") || slicedCommand[1].equalsIgnoreCase("City")){
            
        }
        else if(slicedCommand[0].equalsIgnoreCase("Exit") || slicedCommand[1].equalsIgnoreCase("Exit")){
            
        }
        else if(slicedCommand[0].equalsIgnoreCase("Test") || slicedCommand[1].equalsIgnoreCase("Test")){
            
        }
    }
    
    private static void City(String[] slicedCommand){
        if (slicedCommand[1].equalsIgnoreCase("list")||slicedCommand[1].equalsIgnoreCase("show")){
            CityList(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("create")){
            CityCreate(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("remove")){
            CityRemove(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("upgrade")){
            CityUpgrade(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("downgrade")){
            CityDowngrade(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("addtroops")){
            CityAddTroops(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("removetroops")){
            CityRemoveTroops(slicedCommand);
        }
        else{
            ShowHelp(slicedCommand);
        }
    }
    
    private static void CityList(String[] slicedCommand){
        System.out.println(Server.getCities());
    }
    
    private static void CityCreate(String[] slicedCommand){
        if(slicedCommand.length < 6){
            ShowHelp(slicedCommand);
            return;
        }
        if(slicedCommand.length == 6){
            int i = Server.createCity(slicedCommand[2], slicedCommand[3], Integer.parseInt(slicedCommand[4]), Integer.parseInt(slicedCommand[5]));
            if(i==-1){
                System.out.println("Error: Player not found.");
                return;
            }
            if(i==-2){
                System.out.println("Error: Another City is present at that location.");
                return;
            }
            System.out.println("City created successfully!");
            System.out.println("ID: " + i);
            
        }
        
    }
    
    private static void CityRemove(String[] slicedCommand){
        
    }
    
    private static void CityUpgrade(String[] slicedCommand){
        
    }
    
    private static void CityDowngrade(String[] slicedCommand){
        
    }
    
    private static void CityAddTroops(String[] slicedCommand){
        
    }
    
    private static void CityRemoveTroops(String[] slicedCommand){
        
    }
    
    private static void Player(String[] slicedCommand) {
        if (slicedCommand[1].equalsIgnoreCase("list")||slicedCommand[1].equalsIgnoreCase("show")){
            PlayerList(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("create")){
            PlayerCreate(slicedCommand);
        }
        else if(slicedCommand[1].equalsIgnoreCase("remove")){
            PlayerRemove(slicedCommand);
        }
    }
    
    private static void PlayerList(String[] slicedCommand){
        System.out.println(Server.getCities());
    }
    
    private static void PlayerCreate(String[] slicedCommand){
        if(slicedCommand.length < 3){
            ShowHelp(slicedCommand);
            return;
        }
        if(slicedCommand.length == 3){
            int i = Server.createPlayer(slicedCommand[2]);
            if(i==-1){
                System.out.println("Error: That name is already in use.");
                return;
            }
            if(i==-2){
                System.out.println("Error: Please enter a valid name.");
                return;
            }
            System.out.println("Player created successfully!");
            System.out.println("ID: " + i);
            
        }
        
    }
    
    private static void PlayerRemove(String[] slicedCommand){
        
    }
}
