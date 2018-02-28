package com.theraven; /**
 * Created by TheRaven on 2/17/18.
 */
import com.theraven.test.JsonSimpleWrite;
import com.theraven.test.jsonReader;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener  {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this,this);

        JsonSimpleWrite simpleWrite = new JsonSimpleWrite();
        simpleWrite.start();

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
        }
    }


}