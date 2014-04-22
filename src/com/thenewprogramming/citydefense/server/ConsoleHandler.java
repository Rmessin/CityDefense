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
        
        if(cmd.equalsIgnoreCase("help")) ShowHelp(slicedCommand);
        else if(cmd.equalsIgnoreCase("exit")) Exit(slicedCommand);
        else if(cmd.equalsIgnoreCase("city")) City(slicedCommand);
        else if(cmd.equalsIgnoreCase("test")) Test(slicedCommand);
        else{
            System.out.println("ERROR: Command not found.");
            ShowHelp(slicedCommand);
        }
        
    }
    
    private static void Test(String[] cmdline) {
        System.out.println(java.util.Arrays.toString(cmdline));
    }
    
    private static void Exit(String[] cmdline) {
        exit = true;
    }
    
    private static void ShowHelp(String[] cmdline) {
        //TODO add help texts for specific commands
        System.out.println("I am the help text.");
        
        if(cmdline[0].equalsIgnoreCase("City") || cmdline[1].equalsIgnoreCase("City")){
            
        }
        else if(cmdline[0].equalsIgnoreCase("Exit") || cmdline[1].equalsIgnoreCase("Exit")){
            
        }
        else if(cmdline[0].equalsIgnoreCase("Test") || cmdline[1].equalsIgnoreCase("Test")){
            
        }
    }
    
    private static void City(String[] cmdline){
        if (cmdline[1].equalsIgnoreCase("list")||cmdline[1].equalsIgnoreCase("show")){
            CityList(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("add")){
            CityAdd(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("remove")){
            CityRemove(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("upgrade")){
            CityUpgrade(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("downgrade")){
            CityDowngrade(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("addtroops")){
            CityAddTroops(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("removetroops")){
            CityRemoveTroops(cmdline);
        }
        else{
            ShowHelp(cmdline);
        }
    }
    
    private static void CityList(String[] cmdline){
        
    }
    
    private static void CityAdd(String[] cmdline){
        
    }
    
    private static void CityRemove(String[] cmdline){
        
    }
    
    private static void CityUpgrade(String[] cmdline){
        
    }
    
    private static void CityDowngrade(String[] cmdline){
        
    }
    
    private static void CityAddTroops(String[] cmdline){
        
    }
    
    private static void CityRemoveTroops(String[] cmdline){
        
    }
    
}
