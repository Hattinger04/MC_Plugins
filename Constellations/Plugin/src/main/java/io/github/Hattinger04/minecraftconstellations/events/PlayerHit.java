/**
 * @author Simon Greiderer
 */
package io.github.Hattinger04.minecraftconstellations.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import io.github.Hattinger04.minecraftconstellations.MessageTemplate;
import io.github.Hattinger04.minecraftconstellations.constellations.Constellations;
import io.github.Hattinger04.minecraftconstellations.time.FightingSchedule;

public class PlayerHit implements Listener {
	@EventHandler
	public void onPlayerAttacked(EntityDamageByEntityEvent event) {
		if(event.getEntity().getType() != EntityType.PLAYER) 
			return; 
		if(event.getDamager().getType() != EntityType.PLAYER) 
			return; 
		
		Player whoWasHit = (Player) event.getEntity(); 
		Player whoHit = (Player) event.getDamager();
		if(Constellations.getColorFromPlayer(whoWasHit) == Constellations.getColorFromPlayer(whoHit)) {
			event.setDamage(0);
		} else if(!FightingSchedule.isFightingEnabled()) {
			event.setCancelled(true);
			MessageTemplate.sendMessageToPlayer("Du darfst nicht hitten!", whoHit);
		}
	}
}
