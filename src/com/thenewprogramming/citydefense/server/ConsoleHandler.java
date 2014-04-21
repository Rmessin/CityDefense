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
        /*String command;
        try{
            command = cmdline.substring(0, cmdline.indexOf(" "));
        }
        catch(StringIndexOutOfBoundsException e){
            String[] returnvalue = new String[1];
            returnvalue[0] = cmdline;
            return returnvalue;
        }
        String argsline = cmdline.substring(cmdline.indexOf(" ")+1);
        ArrayList<String> args = new ArrayList<>();
        
        ArrayList<Integer> indexesOfSpaces = new ArrayList<>();
        indexesOfSpaces.add(new Integer(-1));
        for(int i = 0; i < argsline.length(); i++){
            if(argsline.substring(i, i+1).equals(" ")){
                indexesOfSpaces.add(new Integer(i));
                System.out.println(i);
            }
        }
        
        for(int i = 0; i < indexesOfSpaces.size(); i++){
            
            try{
                args.add(argsline.substring(indexesOfSpaces.get(i) +1, indexesOfSpaces.get(i+1)));
                System.out.println(args.get(i));
            }
            catch(IndexOutOfBoundsException e){
                args.add(argsline.substring(indexesOfSpaces.get(i)+1));
            }
        }
        
        
        
        ArrayList<String> returnvalue = new ArrayList<>();
        returnvalue.add(command);
        returnvalue.addAll(args);
        return returnvalue.toArray(new String[returnvalue.size()]);*/
        return cmdline.split(" ");
    }
    
    
    private static void HandleCommand(String[] slicedCommand) {
        String cmd = slicedCommand[0];
        
        if(cmd.equalsIgnoreCase("")){return;}
        
        if(cmd.equalsIgnoreCase("help")) ShowHelp(slicedCommand);
        else if(cmd.equalsIgnoreCase("exit")) Exit(slicedCommand);
        else if(cmd.equalsIgnoreCase("village")) Village(slicedCommand);
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
    }
    
    private static void Village(String[] cmdline){
        if (cmdline[1].equalsIgnoreCase("list")||cmdline[1].equalsIgnoreCase("show")){
            VillageList(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("add")){
            VillageAdd(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("remove")){
            VillageRemove(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("upgrade")){
            VillageUpgrade(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("downgrade")){
            VillageDowngrade(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("addtroops")){
            VillageAddTroops(cmdline);
        }
        else if(cmdline[1].equalsIgnoreCase("removetroops")){
            VillageRemoveTroops(cmdline);
        }
        else{
            ShowHelp(cmdline);
        }
    }
    
    private static void VillageList(String[] cmdline){
        
    }
    
    private static void VillageAdd(String[] cmdline){
        
    }
    
    private static void VillageRemove(String[] cmdline){
        
    }
    
    private static void VillageUpgrade(String[] cmdline){
        
    }
    
    private static void VillageDowngrade(String[] cmdline){
        
    }
    
    private static void VillageAddTroops(String[] cmdline){
        
    }
    
    private static void VillageRemoveTroops(String[] cmdline){
        
    }
    
}
