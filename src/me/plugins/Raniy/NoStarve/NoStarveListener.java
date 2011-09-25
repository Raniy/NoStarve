package me.plugins.Raniy.NoStarve;

//First run at a Player Listener
import java.util.logging.Logger;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
@SuppressWarnings("unused")


public class NoStarveListener extends EntityListener{
	Logger log=Logger.getLogger("Minecraft");

 
	public NoStarveListener(NoStarve instance) {
		final NoStarve UITplugin;
		UITplugin = instance;
	}
	public void onFoodLevelChange(FoodLevelChangeEvent event){
		
		Entity TheEntity = event.getEntity();
		// If TheEntity involved in this Event is a Player
		if (TheEntity instanceof Player){
			Player ThePlayer=(Player)TheEntity;
			// If ThePlayer has permission or is a Op
			if (ThePlayer.hasPermission("NoStarve.NoStarve") || (ThePlayer.isOp()) )
			{
				// If the new food level would be lower then the old one.
				if (event.getFoodLevel() <= ThePlayer.getFoodLevel()){
				
					//Make sure their food is full. and cancel the event
					//ThePlayer.setFoodLevel(20);
					event.setCancelled(true);
				}
			}
		}	
	}
	
}

