package com.theraven.test;

import org.bukkit.Bukkit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by TheRaven on 2/26/18.
 */
public class jsonReader extends Thread {
    public String test;
    public void run(){

        System.out.println("Thread his started");

        JSONParser parser = new JSONParser();
        File directory = new File(".");

        try {

            Object obj = parser.parse(new FileReader(""+ directory.getCanonicalPath() + File.separator + "/plugins/test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);

            /*String name = (String) jsonObject.get("name");
            System.out.println(name);*/

          //  long age = (Long) jsonObject.get("age");
            //System.out.println(age);

            String ip = (String) jsonObject.get("ip");

            String but = (String) jsonObject.get("if");
            String tset = but;


            Bukkit.getServer().broadcastMessage(ip );

            // loop array
            /*&JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
