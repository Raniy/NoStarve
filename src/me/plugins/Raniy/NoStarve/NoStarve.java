package me.plugins.Raniy.NoStarve;

import java.util.logging.Logger;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

@SuppressWarnings("unused")
public class NoStarve extends JavaPlugin {
	Logger log=Logger.getLogger("Minecraft");
	Configuration MyConfig;
	
		
    public void onDisable() {
        // TODO: Place any custom disable code here.
        log.info("NoStarve unloaded.");
        
    }

    public void onEnable() {
    	
    	// Get the listener
    	final NoStarveListener NSListener=new NoStarveListener(this);
    	// Get PluginManager
    	PluginManager pm=this.getServer().getPluginManager();
    	
    	// Register the events we want to track.
    	pm.registerEvent(Event.Type.ENTITY_DAMAGE, NSListener, Priority.Normal, this);
    	
    	// Tell the console we activated.
    	log.info("NoStarve activated. Lucky people... ");
    }
}
