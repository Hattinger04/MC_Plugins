package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;;

public class Soup implements Listener {

	@EventHandler
	public void onInterac(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getInventory().getItemInHand().getType() == Material.MUSHROOM_SOUP) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
				double i = p.getHealth();
				p.getInventory().getItemInHand().setType(Material.BOWL); 
				if (i < p.getMaxHealth()) {
					p.getInventory().getItemInHand().setType(Material.BOWL); 
					if (i > 13) {
						p.setHealth(p.getMaxHealth());
						p.getInventory().getItemInHand().setType(Material.BOWL); 
						
					} else {
						p.setHealth(i + 7);
						p.getInventory().getItemInHand().setType(Material.BOWL); 
					}
				}
			}

		}
	}
}
