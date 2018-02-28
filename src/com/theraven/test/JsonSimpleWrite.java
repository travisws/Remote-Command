package com.theraven.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by TheRaven on 2/26/18.
 */
public class JsonSimpleWrite extends Thread {

    public void run(){
        JSONObject obj = new JSONObject();
        obj.put("ip", "192.168.1.4");
        obj.put("age", new Integer(100));

        /*JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);*/

        try (FileWriter file = new FileWriter("/home/TheRaven/test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);


    }
}
