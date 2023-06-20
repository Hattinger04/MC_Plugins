package de.SkyWars.weapons;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.SkyWars.main.Main;
import de.SkyWars.rezepte.RecipeLoader;

public class WeaponHandler implements Listener{
 
	private ArrayList<Weapon> weapons; 
	RecipeLoader rezepte = new RecipeLoader(); 
	
	public WeaponHandler(Main plugin) {
		weapons = new ArrayList<Weapon>(); 
		rezepte.registerRezepte();
		weapons.add(new RocketLauncher(plugin, Material.BLAZE_ROD, Material.FIREBALL , 20*5, 7)); 
	}
	
	@EventHandler
	public void handleWeaponShot(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			Weapon weapon = checkWeaponMaterial(e.getItem().getType()); 
			if(weapon != null) {
				weapon.shoot(e.getPlayer());
			}
		}
	}
	
	@EventHandler
	private void handleWeaponDamage(EntityDamageByEntityEvent e) {
		if(!((e.getDamager()) instanceof Projectile)) return; 
		
		Projectile projectile = (Projectile) e.getDamager(); 
		if(!((projectile.getShooter()) instanceof Player)) return; 
		
		Player player = (Player) projectile.getShooter(); 
		
		Weapon weapon = checkWeaponMaterial(player.getItemInHand().getType()); 
		if(weapon != null) {
			e.setDamage(weapon.getDamage());
		}
	}
	private Weapon checkWeaponMaterial(Material material) {
		for(Weapon current : weapons) {
			if(current.getMaterial() == material) {
				return current; 
			}
		}
		return null; 
	}
}
 