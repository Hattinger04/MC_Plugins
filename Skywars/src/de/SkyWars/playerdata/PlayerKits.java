// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.playerdata;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


import de.SkyWars.mysql.MySQLKits;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerKits {
	public static HashMap<Player, Kits> PlayerKit;

	static {
		PlayerKits.PlayerKit = new HashMap<Player, Kits>();
	}

	public static void effectClear(final Player p) {
		ArrayList<PotionEffect> potions = new ArrayList<PotionEffect>(); 
       	potions.addAll(p.getActivePotionEffects());
       	for(PotionEffect effect : potions) {
       		p.removePotionEffect(effect.getType());
       	}
	}

	@SuppressWarnings("deprecation")
	public static void setKit(final Player p) {
		if (!PlayerKits.PlayerKit.containsKey(p)) {
			final int lastKit = MySQLKits.getLastKit(p.getUniqueId().toString());
			if (lastKit == 1) {
				PlayerKits.PlayerKit.put(p, Kits.Starter);
			}
			else if (lastKit == 2) {
				PlayerKits.PlayerKit.put(p, Kits.Assasine);
			}
			else if (lastKit == 3) {
				PlayerKits.PlayerKit.put(p, Kits.Enderman);
			}
			else if (lastKit == 4) {
				PlayerKits.PlayerKit.put(p, Kits.Miner);
			}
			else if (lastKit == 5) {
				PlayerKits.PlayerKit.put(p, Kits.Tank);
			}
			else if (lastKit == 6) {
				PlayerKits.PlayerKit.put(p, Kits.Gandalf);
			}
			else if (lastKit == 7) {
				PlayerKits.PlayerKit.put(p, Kits.Spongebob);
			}
			else if (lastKit == 8) {
				PlayerKits.PlayerKit.put(p, Kits.Mlg);
			}
			else if (lastKit == 9) {
				PlayerKits.PlayerKit.put(p, Kits.Gumpi);
			}
			else if (lastKit == 10) {
				PlayerKits.PlayerKit.put(p, Kits.SuppenMeister);
			}
			else if (lastKit == 11) {
				PlayerKits.PlayerKit.put(p, Kits.AntiTimolianer);
			}
			else if (lastKit == 12) {
				PlayerKits.PlayerKit.put(p, Kits.BedwarsSpieler);
			}
			else if (lastKit == 13) {
				PlayerKits.PlayerKit.put(p, Kits.Astronaut);
			}
			else if (lastKit == 14) {
				PlayerKits.PlayerKit.put(p, Kits.PiùAmore);
			}
			else if (lastKit == 15) {
				PlayerKits.PlayerKit.put(p, Kits.SchlechterSenser);
			}
			else if (lastKit == 16) {
				PlayerKits.PlayerKit.put(p, Kits.Link);
			}
			else if(lastKit == 17) {
				PlayerKits.PlayerKit.put(p, Kits.SpiderMan); 
			}
			else if(lastKit == 18) {
				PlayerKits.PlayerKit.put(p, Kits.Berzerker); 
			}
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Tank) {
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			@SuppressWarnings("deprecation")
			final Potion potion = new Potion(PotionType.FIRE_RESISTANCE, 1, false);
			final ItemStack potionstack = potion.toItemStack(1);
			p.getInventory().setItem(0, potionstack);
			p.getInventory().setHelmet(itemBuild(Material.IRON_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setChestplate(itemBuild(Material.IRON_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setLeggings(itemBuild(Material.IRON_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setBoots(itemBuild(Material.IRON_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Tank.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Starter) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.IRON_SWORD, 1));
			p.getInventory().setChestplate(itemBuild(Material.IRON_CHESTPLATE, 1));
			p.getInventory().setItem(1, itemBuild(Material.IRON_PICKAXE, 1));
			p.getInventory().setItem(2, itemBuild(Material.IRON_AXE, 1));
			p.getInventory().setItem(3, itemBuild(Material.FLINT_AND_STEEL, 1));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Starter.getID());
		}

		if (PlayerKits.PlayerKit.get(p) == Kits.Gandalf) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
			p.getInventory().setItem(0, itemBuild(Material.ENCHANTMENT_TABLE, 1));
			p.getInventory().setItem(1, itemBuild(Material.EXP_BOTTLE, 32));
			p.getInventory().setItem(2, itemBuild(Material.BOOKSHELF, 15));

			/////////////////////////
			ItemStack potion = new ItemStack(Material.POTION);
			Potion pot = new Potion(1);
			pot.setType(PotionType.STRENGTH);
			pot.setLevel(2);
			pot.setSplash(false);
			pot.apply(potion);
			/////////////////////////

			p.getInventory().setItem(4, potion); 

			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Gandalf.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Miner) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.DIAMOND_PICKAXE, 1, Enchantment.DIG_SPEED, 10));
			p.getInventory().setItem(1, itemBuild(Material.BRICK, 64));
			p.getInventory().setItem(2, itemBuild(Material.BRICK, 64));
			p.getInventory().setItem(3, itemBuild(Material.BRICK, 64));
			p.getInventory().setHelmet(itemBuild(Material.GOLD_HELMET, 1));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Miner.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Assasine) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setBoots(itemBuild(Material.DIAMOND_BOOTS, 1, Enchantment.PROTECTION_FALL, 10));
			p.getInventory().setItem(0, itemBuild(Material.DIAMOND_SWORD, 1, Enchantment.DAMAGE_ALL, 2));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Assasine.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Enderman) {
			effectClear(p);
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0, itemBuild(Material.ENDER_PEARL, 1, Enchantment.WATER_WORKER, 1));
			p.getInventory().setItem(1, itemBuild(Material.ENDER_STONE, 32));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Enderman.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Spongebob) {
			effectClear(p);
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0, itemBuild(Material.SPONGE, 64));
			final ItemStack lLegg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			final LeatherArmorMeta lLeggM = (LeatherArmorMeta) lLegg.getItemMeta();
			lLeggM.setColor(Color.fromRGB(139, 69, 19));
			lLegg.setItemMeta((ItemMeta) lLeggM);
			final ItemStack lChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			final LeatherArmorMeta lChestM = (LeatherArmorMeta) lChest.getItemMeta();
			lChestM.setColor(Color.YELLOW);
			lChest.setItemMeta((ItemMeta) lChestM);
			p.getInventory().setChestplate(lChest);
			p.getInventory().setLeggings(lLegg);
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Spongebob.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Mlg) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.TNT, 16));
			p.getInventory().setItem(1, itemBuild(Material.REDSTONE_TORCH_ON, 8));
			p.getInventory().setItem(2, itemBuild(Material.WATER_BUCKET, 1));
			p.getInventory().setItem(3, itemBuild(Material.LAVA_BUCKET, 1));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Mlg.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Gumpi) {
			p.setMaxHealth(20);
			effectClear(p);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0, itemBuild(Material.BLAZE_ROD, 1));
			p.getInventory().setItem(1, itemBuild(Material.TNT, 16));
			p.getInventory().setItem(2, itemBuild(Material.WOOD_PLATE, 2));
			p.getInventory().setItem(3, itemBuild(Material.FIREBALL, 5));
			p.getInventory().setItem(4, itemBuild(Material.FLINT_AND_STEEL, 1));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Gumpi.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.SuppenMeister) {
			p.setMaxHealth(20);
			effectClear(p);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0, itemBuild(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 1));
			p.getInventory().setItem(1, itemBuild(Material.BOWL, 32));
			p.getInventory().setItem(2, itemBuild(Material.RED_MUSHROOM, 32));
			p.getInventory().setItem(3, itemBuild(Material.BROWN_MUSHROOM, 32));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.SuppenMeister.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.AntiTimolianer) {
			p.chat("/gh ichBinUnvermeidbar69 12");
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.WOOD_SWORD, 1, Enchantment.DAMAGE_ALL, 3));
			p.getInventory().setItem(1, itemBuild(Material.GOLDEN_APPLE, 1));
			p.setMaxHealth(18);
			p.setHealth(p.getMaxHealth());
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.AntiTimolianer.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.BedwarsSpieler) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.STICK, 1, Enchantment.KNOCKBACK, 1));
			p.getInventory().setItem(1, itemBuild(Material.WOOD_PICKAXE, 1, Enchantment.DIG_SPEED, 2));
			p.getInventory().setItem(2, itemBuild(Material.SANDSTONE, 64));
			p.getInventory().setHelmet(itemBuild(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			p.getInventory().setChestplate(
					itemBuild(Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			p.getInventory()
					.setLeggings(itemBuild(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
			p.getInventory().setBoots(itemBuild(Material.GOLD_BOOTS, 1, Enchantment.PROTECTION_FALL, 5));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.BedwarsSpieler.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Astronaut) {
			p.setMaxHealth(20);
			effectClear(p);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setHelmet(itemBuild(Material.GLASS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 8));
			p.getInventory().setItem(0, itemBuild(Material.FIREWORK, 3));
			p.getInventory().setItem(8, itemBuild(Material.WATER_BUCKET, 1));
			p.getInventory().setBoots(itemBuild(Material.GOLD_BOOTS, 1, Enchantment.PROTECTION_FALL, 5));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Astronaut.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.PiùAmore) {
			effectClear(p);
			p.setMaxHealth(30);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0, itemBuild(Material.STONE_SWORD, 1));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.PiùAmore.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.SchlechterSenser) {
			effectClear(p); 
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			p.getInventory().setItem(0,
					itemBuild(Material.IRON_HOE, 1, Enchantment.KNOCKBACK, 2, Enchantment.DAMAGE_ALL, 5));
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 1));

			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.SchlechterSenser.getID());
		}
		if (PlayerKits.PlayerKit.get(p) == Kits.Link) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 1,
					Enchantment.DURABILITY, 10, "Mastersword"));
			p.getInventory().setItem(3, itemBuild(Material.BOW, 1, Enchantment.ARROW_DAMAGE, 1));
			p.getInventory().setItem(5, itemBuild(Material.GOLDEN_APPLE, 1));
			p.getInventory().setItem(8, itemBuild(Material.ARROW, 6));
			p.getInventory()
					.setChestplate(itemBuild(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 4));
			p.getInventory()
					.setLeggings(itemBuild(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 4));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.Link.getID());
		}
		
		if (PlayerKits.PlayerKit.get(p) == Kits.SpiderMan) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)); 
			p.getInventory().setHelmet(itemBuild(Material.LEATHER_HELMET, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setChestplate(itemBuild(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setLeggings(itemBuild(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			p.getInventory().setBoots(itemBuild(Material.LEATHER_BOOTS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
			MySQLKits.setLastKit(p.getUniqueId().toString(), Kits.SpiderMan.getID());			
		}
		
		if (PlayerKits.PlayerKit.get(p) == Kits.Berzerker) {
			p.setMaxHealth(20);
			p.setHealth(p.getMaxHealth());
			effectClear(p);
			p.getInventory().setItem(0, itemBuild(Material.WOOD_AXE, 1, Enchantment.DAMAGE_ALL, 3, "Haudrau"));
			p.getInventory().setChestplate(itemBuild(Material.LEATHER_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 4));
			p.getInventory().setLeggings(itemBuild(Material.LEATHER_LEGGINGS, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 4));
		}
	}

	public static ItemStack itemBuild(final Material m, final int size) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final Material m, final int size, final String name) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(name);
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final Material m, final int size, final Enchantment ent, final int level) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final Material m, final int size, final Enchantment ent, final int level,
			final String name) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		itemM.setDisplayName(name);
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final Material m, final int size, final Enchantment ent, final int level,
			final Enchantment ent2, final int level2) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		itemM.addEnchant(ent2, level2, true);
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final Material m, final int size, final Enchantment ent, final int level,
			final Enchantment ent2, final int level2, final String name) {
		final ItemStack item = new ItemStack(m, size);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		itemM.addEnchant(ent2, level2, true);
		itemM.setDisplayName(name);
		item.setItemMeta(itemM);
		return item;
	}
}
