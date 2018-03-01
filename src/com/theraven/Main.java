package com.theraven; /**
 * Created by TheRaven on 2/17/18.
 */
import com.google.gson.stream.JsonReader;
import com.theraven.test.JsonSimpleWrite;

import com.theraven.test.ifJson;
import com.theraven.test.jsonReader;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JavaPlugin implements Listener {

    public String ifjson;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);

        fileCreate();
    }

    @Override
    public void onDisable(){

    }

    @EventHandler(priority= EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();

        if(p.getInventory().getItemInMainHand().getType() == Material.BLAZE_POWDER){
            Fireball fire = p.getWorld().spawn(event.getPlayer().getLocation(), Fireball.class);
            fire.setShooter(p);
        }
        /*else if(p.getItemInHand() == Material.BLAZE_ROD){
            //Do whatever
        }*/
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            //event.getPlayer().sendMessage(ChatColor.AQUA + "You clicked a " + ChatColor.BOLD + event.getClickedBlock().getType().toString().toLowerCase().replace("_", ""));
            ifjson = "0";
            ifJson ifjson = new ifJson();
            ifjson.test();

        }

    }
    /*For later use for something
    @EventHandler
    public void onBreak(BlockPlaceEvent e){
        Player p = e.getPlayer();
        Location l = p.getLocation();

        l.getWorld().strikeLightning(l);

    }*/

    public void fileCreate(){
        File directory = new File(".");

        File f = null;
        try {
            f = new File(""+ directory.getCanonicalPath() + File.separator + "/plugins/test.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (f.exists()) {
            System.out.println("File existed");
            jsonReader jsonReader = new jsonReader();
            jsonReader.reader();

            String good = jsonReader.hello;

            System.out.println("Thread his started" +" " + good + "it worked");


        } else {
            System.out.println("File not found!");
            JsonSimpleWrite simpleWrite = new JsonSimpleWrite();
            simpleWrite.start();
        }

    }

}