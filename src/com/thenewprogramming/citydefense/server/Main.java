package com.thenewprogramming.citydefense.server;

public class Main {
    
    private static ConsoleHandler ConsoleHandlerObject;
    private static GameLoopHandler GameLoopObject;
    
    private static Thread ConsoleHandlerThread;
    private static Thread GameLoopThread;
    private static Thread RemoteRequestListenerThread;
    private static Thread RemoteRequestHandlerThread;
    
    
    public static void main(String[] args) {
        startServer();
    }
    private static void startServer(){
        ConsoleHandlerObject = new ConsoleHandler();
        ConsoleHandlerThread = new Thread(ConsoleHandlerObject);
        ConsoleHandlerThread.start();
        
        GameLoopObject = new GameLoopHandler();
        GameLoopThread = new Thread(GameLoopObject);
        GameLoopThread.start();
        
        /*GameloopThread = new Thread(new GameLoopHandler());
        GameloopThread.start();*/ //Comment until further notice
        
    }
    
    public static void StopServer(){
        GameLoopObject.Stop();
        ConsoleHandlerObject.stop();
    }
    
}
