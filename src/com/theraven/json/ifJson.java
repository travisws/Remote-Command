package com.theraven.json;

import com.theraven.Main;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ifJson  {

    public void test(){

        Main main = new Main();


        File directory = new File(".");

        JSONObject obj = new JSONObject();
        obj.put("if", "" + main.ifjson);

        try (FileWriter file = new FileWriter(""+ directory.getCanonicalPath() + File.separator + "/plugins/test.json")) {

            file.write(obj.toJSONString());
            file.flush();



        } catch (IOException e) {
            e.printStackTrace();
        }

       // System.out.print(obj);
    }
}