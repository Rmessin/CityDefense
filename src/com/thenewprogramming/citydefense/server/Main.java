package com.thenewprogramming.citydefense.server;

public class Main {
    
    private static Thread ConsoleHandlerThread;
    private static Thread GameLoopThread;
    private static Thread RemoteRequestListenerThread;
    private static Thread RemoteRequestHandlerThread;
    
    
    public static void main(String[] args) {
        startServer();
    }
    private static void startServer(){
        ConsoleHandlerThread = new Thread(new ConsoleHandler());
        ConsoleHandlerThread.start();
        
        GameLoopThread = new Thread(new GameLoopHandler());
        GameLoopThread.start();
        
        /*GameloopThread = new Thread(new GameLoopHandler());
        GameloopThread.start();*/ //Comment until further notice
        
    }
    
}
