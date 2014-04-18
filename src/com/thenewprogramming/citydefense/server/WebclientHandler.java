/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package com.thenewprogramming.citydefense.server;

import java.io.*;
import java.net.*;

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
	
	private void HandleRequest(String webclientRequestLine, DataOutputStream outgoingStream) throws IOException{
		if(webclientRequestLine.equalsIgnoreCase("1")){
			outgoingStream.writeBytes("2");
		}
		else if(webclientRequestLine.equalsIgnoreCase("2")){
			outgoingStream.writeBytes("3");
		}
	}
    
}
