package com.theraven.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by TheRaven on 2/26/18.
 */
public class JsonSimpleWrite extends Thread {

    public void run(){

        File directory = new File(".");

        JSONObject obj = new JSONObject();
        obj.put("ip", "192.168.1.4");
        obj.put("age", new Integer(100));
        obj.put("if", "true");

        /*JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);*/

        try (FileWriter file = new FileWriter(""+ directory.getCanonicalPath() + File.separator + "/plugins/test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);


    }
}
