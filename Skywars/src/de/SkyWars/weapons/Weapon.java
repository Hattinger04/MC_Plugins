package de.SkyWars.weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.SkyWars.main.Main;
import de.SkyWars.rezepte.RecipeLoader;

public abstract class Weapon {

	private Main plugin;
	private Material material;
	private Material munition;
	private long reloadTime;
	private double damage;
	RecipeLoader rezepte = new RecipeLoader(); 

	private ArrayList<String> shotWeapon;

	public Weapon(Main plugin, Material material, Material munition, long reloadTime, double damage) {
		this.plugin = plugin;
		this.material = material;
		this.munition = munition;
		this.reloadTime = reloadTime;
		this.damage = damage;

		shotWeapon = new ArrayList<String>();
	}

	public void shoot(Player player) {
		if (player.getInventory().contains(munition)) {
			if (!shotWeapon.contains(player.getName())) {
				shotWeapon.add(player.getName());
				shootEffects(player);
				player.getInventory().removeItem(new ItemStack(munition, 1));
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					@Override
					public void run() {
						shotWeapon.remove(player.getName());
					}
				}, reloadTime);

			} else {
				player.sendMessage("§cDie Waffe läd gerade nach...");
				return; 	
			}
		} else {
			player.sendMessage("§cDu hast keine Munition mehr!!");
			return; 
		}
	}

	public abstract void shootEffects(Player player);

	public Material getMaterial() {
		return material;
	}

	public double getDamage() {
		return damage;
	}
}
