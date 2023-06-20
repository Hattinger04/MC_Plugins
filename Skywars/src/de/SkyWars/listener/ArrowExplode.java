package de.SkyWars.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.SkyWars.main.Main;
import de.SkyWars.mysql.MySQLKits;

public class ArrowExplode implements Listener {
	
	private Main plugin; 
	public ArrowExplode(Main plugin) {
		this.plugin = plugin; 
	}
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {	
		if(e.getEntity() instanceof Arrow) {
			if(e.getEntity().getShooter() instanceof Player) {
				Player shooter = (Player) e.getEntity().getShooter(); 
				
				if(MySQLKits.getLastKit(shooter.getUniqueId().toString()) == 16) {
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						
						@Override
						public void run() {
							e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2, true); 
							e.getEntity().remove();
						}
					}, 20*3); 	
				}
			}
		}
	}
}
