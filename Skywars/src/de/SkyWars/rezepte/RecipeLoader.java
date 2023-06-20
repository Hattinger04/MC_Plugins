package de.SkyWars.rezepte;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {

	ItemStack fireball, firework; 
	public void registerRezepte() {
		
		fireball = new ItemStack(Material.FIREBALL); 
		ShapelessRecipe rlMunitionRezept = new ShapelessRecipe(fireball); 
	
		rlMunitionRezept.addIngredient(Material.IRON_INGOT); 
		rlMunitionRezept.addIngredient(Material.STRING);
		rlMunitionRezept.addIngredient(Material.STRING);
		rlMunitionRezept.addIngredient(Material.STRING);

		Bukkit.addRecipe(rlMunitionRezept); 
	
		////////////////////////////////////////////////
		
		firework = new ItemStack(Material.FIREWORK); 
		ShapedRecipe fireWorkRezept = new ShapedRecipe(firework); 
		
		fireWorkRezept.shape("AIA", "IFI", "AIA"); 
		fireWorkRezept.setIngredient('I', Material.IRON_INGOT); 
		fireWorkRezept.setIngredient('F', Material.FLINT);
		
		Bukkit.addRecipe(fireWorkRezept); 
	}
}
