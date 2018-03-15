package com.theraven;

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

                System.out.println(message);

                System.out.println("last");

            }
        }catch (IOException e){
            e.printStackTrace();
        }
     /*   //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket

            if (message.equals("Hello")){
                oos.writeObject("worked from the if side");
            }
            oos.writeObject("Hi Client "+message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();*/
    }

}
