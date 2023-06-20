/**
 * @author Hattinger04
 */
package io.github.Hattinger04.minecraftruns.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import io.github.Hattinger04.minecraftruns.MessageTemplate;
import io.github.Hattinger04.minecraftruns.MinecraftRuns;

public class GameSharedHeartsR extends Game implements Listener {

	public GameSharedHeartsR(MinecraftRuns plugin, String name) {
		super(plugin, name); 
	}
	
	@Override
	public void start() {
		super.start(); 
	}

	@Override
	public void stop() {
		super.stop();
	}
	
	public void addDamageToAllPlayer(Player player, double value) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p != player) {
				p.setHealth(p.getHealth() - value);
			}
		}
	}
	
	@EventHandler
	public void onDamageEvent(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Player)) 
			return; 
		Player player = (Player) event.getEntity(); 
		MessageTemplate.sendMessageToAllPlayer(String.format("Spieler %s hat %g Herzen Schaden bekommen!", player.getDisplayName(), event.getDamage() / 2));
		addDamageToAllPlayer(player, event.getDamage());
	}
}
