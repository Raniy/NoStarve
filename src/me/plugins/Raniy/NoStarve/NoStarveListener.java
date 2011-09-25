package me.plugins.Raniy.NoStarve;

//First run at a Player Listener
import java.util.logging.Logger;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
@SuppressWarnings("unused")


public class NoStarveListener extends EntityListener{
	Logger log=Logger.getLogger("Minecraft");

 
	public NoStarveListener(NoStarve instance) {
		final NoStarve UITplugin;
		UITplugin = instance;
	}

	public void onEntityDamage(EntityDamageEvent event){
		Entity TheEntity = event.getEntity();
		DamageCause TheCause = event.getCause();
		// If TheEntity involved in this Event is a Player
		if (TheEntity instanceof Player){
			Player ThePlayer=(Player)TheEntity;
			// If the source of the damage is hunger
			if((TheCause.equals(DamageCause.STARVATION))){
				// If ThePlayer has permission or is a Op
				if (ThePlayer.hasPermission("NoStarve.NoStarve") || (ThePlayer.isOp())){
				 event.setCancelled(true);
				}
			}
		}
	}
	
		
	/* Legacy method
	 * Kept for no good reason.
	 * public void onFoodLevelChange(FoodLevelChangeEvent event){
	 
		
		Entity TheEntity = event.getEntity();
		// If TheEntity involved in this Event is a Player
		if (TheEntity instanceof Player){
			Player ThePlayer=(Player)TheEntity;
			// If ThePlayer has permission or is a Op
			if (ThePlayer.hasPermission("NoStarve.NoStarve") || (ThePlayer.isOp()) )
			{
				// If the new food level would be lower then the old one.
				if (event.getFoodLevel() <= ThePlayer.getFoodLevel()){
					//Make sure their food is full.
					//ThePlayer.setFoodLevel(20);
					//...and cancel the event
					event.setCancelled(true);
				}
			}
		}	
	}
	*/
	
	
}

