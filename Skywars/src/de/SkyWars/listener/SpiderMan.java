package de.SkyWars.listener;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.SkyWars.main.Main;
import de.SkyWars.mysql.MySQLKits;

public class SpiderMan implements Listener {

	public SpiderMan(Main plugin) {
		this.plugin = plugin;
		shotWeapon = new ArrayList<String>(); 
	}

	private ArrayList<String> shotWeapon;
	public Main plugin;
	private int i = 0;

	public static Logger logger = Logger.getLogger("minecraft");

	public int shootpower = 1;

	@SuppressWarnings("deprecation")

	@EventHandler
	public void shootWebs(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		FallingBlock fb;
		if (p.getItemInHand().getType() == Material.AIR && p.isSneaking() && event.getAction() == Action.LEFT_CLICK_AIR
				&& MySQLKits.getLastKit(p.getUniqueId().toString()) == 17) {
			if (!shotWeapon.contains(p.getName())) {
				fb = p.getWorld().spawnFallingBlock(p.getEyeLocation(), Material.WEB, (byte) 0);
				fb.setDropItem(false);
				fb.setVelocity(p.getLocation().getDirection().multiply(shootpower - 0.5D));
				i++; 
				if (i == 5) {
					shotWeapon.add(p.getName());
					i = 0; 
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						@Override
						public void run() {
							shotWeapon.remove(p.getName());
						}
					}, 80L);
				}
 
			} else if(shotWeapon.contains(p.getName())) {			
				p.sendMessage("§cDu musst noch ein wenig Geduld haben...");

			}
	

		}
	}
}
