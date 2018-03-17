package com.theraven;

import org.bukkit.Bukkit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testSocket extends Thread {

    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;

    Socket s;
    ServerSocket ss;
    InputStreamReader isr;
    BufferedReader br;
    String message;

    public void run(){
        testJoin();

    }

    public void testJoin(){
        System.out.println("Befor try");
        try {
            ss = new ServerSocket(9999);
            System.out.println("2");
            while (true){
                s =ss.accept();
                isr = new InputStreamReader(s.getInputStream());
                br = new BufferedReader(isr);
                message = br.readLine();

                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), message);


                System.out.println(message);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
