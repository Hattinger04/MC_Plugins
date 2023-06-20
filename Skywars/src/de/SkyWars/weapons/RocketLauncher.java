package de.SkyWars.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;

import de.SkyWars.main.Main;
import de.SkyWars.rezepte.RecipeLoader;

public class RocketLauncher extends Weapon{

	public RocketLauncher(Main plugin, Material material, Material munition, long reloadTime, double damage) {
		super(plugin, material, munition, reloadTime, damage);
	}


	@Override
	public void shootEffects(Player player) {
		Fireball ball = player.launchProjectile(Fireball.class); 
		ball.setYield(3f);
	}

}
