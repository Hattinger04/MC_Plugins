// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.chests;

import java.util.List;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import java.util.Random;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.DyeColor;
import org.bukkit.material.Dye;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.Location;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class ChestLevel implements Listener {
	public static ArrayList<Location> sgchest;
	public static ArrayList<String> itemList1;
	public static ArrayList<String> itemList2;

	static {
		ChestLevel.sgchest = new ArrayList<Location>();
		ChestLevel.itemList1 = new ArrayList<String>();
		ChestLevel.itemList2 = new ArrayList<String>();

	}

	public static ItemStack itemBuild(final int ID, final int amount, final short subID) {
		final ItemStack item = new ItemStack(ID, amount, subID);
		final ItemMeta itemM = item.getItemMeta();
		item.setItemMeta(itemM);
		return item;
	}

	public static ItemStack itemBuild(final int ID, final int amount, final short subID, final Enchantment ent,
			final int level) {
		final ItemStack item = new ItemStack(ID, amount, subID);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack itemBuild(final int ID, final int amount, final short subID, final Enchantment ent, final int level,
			final Enchantment ent2, final int level2) {
		final ItemStack item = new ItemStack(ID, amount, subID);
		final ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(ent, level, true);
		itemM.addEnchant(ent2, level2, true);
		item.setItemMeta(itemM);
		return item;
	}

	@EventHandler
	public void onInventoryOpen(final InventoryOpenEvent e) {
		if (e.getInventory() instanceof EnchantingInventory) {
			final EnchantingInventory inv = (EnchantingInventory) e.getInventory();
			final Dye d = new Dye();
			d.setColor(DyeColor.BLUE);
			final ItemStack i = d.toItemStack();
			i.setAmount(64);
			inv.setItem(1, i);
		}
	}

	@EventHandler
	public void onInventoryClose(final InventoryCloseEvent e) {
		if (e.getInventory() instanceof EnchantingInventory) {
			final EnchantingInventory inv = (EnchantingInventory) e.getInventory();
			final Dye d = new Dye();
			d.setColor(DyeColor.BLUE);
			final ItemStack i = d.toItemStack();
			i.setAmount(0);
			inv.setItem(1, i);
		}
	}

	@EventHandler
	public void onInventoryClick(final InventoryClickEvent e) {
		if (e.getInventory() instanceof EnchantingInventory) {
			final Dye d = new Dye();
			d.setColor(DyeColor.BLUE);
			final ItemStack i = d.toItemStack();
			if (e.getCurrentItem() == i) {
				e.setCancelled(true);
			}
		}
	}

	public static void setItems() {
		for (final String all : ChestFile.ChestFile.getStringList("items")) {
			ChestLevel.itemList1.add(all);
		}
		for (final String all : ChestFile.ChestFile.getStringList("items2")) {
			ChestLevel.itemList2.add(all);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInteract2(final PlayerInteractEvent e) {
		if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter
				|| Main.Status == StatusManager.Restart) {
			e.setCancelled(true);
			return;
		}
		final Player p = e.getPlayer();
		if (PlayerTeams.Spectator.contains(p)) {
			e.setCancelled(true);
			return;
		}
		/*
		 * Chest --> Base || TrappedChest --> Mitte
		 */
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
				final Chest c = (Chest) e.getClickedBlock().getState();
				final Inventory inv = c.getInventory();
				if (!ChestLevel.sgchest.contains(e.getClickedBlock().getLocation())) {
					int l = ChestFile.ChestFile.getInt("MaxItemsInChest2");
					final ArrayList<String> list = new ArrayList<String>();
					for (final String alls : ChestLevel.itemList2) {
						list.add(alls);
					}
					final List<ItemStack> items = new ArrayList<ItemStack>();
					final String remove = "";
					for (final String all : list) {
						int ID = 0;
						int subID = 0;
						int amount = 0;
						int chance = 0;
						if (all.contains(":")) {
							final String[] array = all.split(":");
							ID = Integer.valueOf(array[0]);
							String a = array[1];
							a = a.substring(0, 1);
							subID = Integer.valueOf(a);
						}
						final String[] array = all.split(", ");
						amount = Integer.valueOf(array[1]);
						chance = Integer.valueOf(array[2]);
						for (int i = 0; i < chance; ++i) {
							// Heal Pot
							if (ID == 373) {
								ItemStack potion = new ItemStack(Material.POTION, amount, (short) subID);
								Potion pot = new Potion(1);
								pot.setType(PotionType.INSTANT_HEAL);
								pot.setSplash(true);
								pot.apply(potion);
								items.add(potion);
								
								// Eisen - Mittelteile
							} else if(ID == 307 || ID == 308) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_ENVIRONMENTAL, 2));
								// Eisen - Helm
							} else if(ID == 306) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_PROJECTILE, 3));
								// Dia - Axt
							} else if(ID == 279) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DAMAGE_ALL, 1)); 
								// Dia _ Pickaxe
							} else if(ID == 278) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DIG_SPEED, 2));
								// Eisen - Schuhe
							} else if(ID == 309) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_FALL, 2, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
								// Dia - Sword
							} else if (ID == 276) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DAMAGE_ALL, 1));
								// Dia Rüstung
							} else if (ID == 310 || ID == 311 || ID == 312 || ID == 313) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
							} else {
								items.add(new ItemStack(ID, amount, (short) subID));
							}
							list.remove(remove);
						}
					}
					while (l != 0) {
						--l;
						final Random r2 = new Random();
						final Random r3 = new Random();
						final int n2 = r2.nextInt(26);
						final int n3 = r3.nextInt(items.size());
						inv.setItem(n2, (ItemStack) items.get(n3));
						final ItemStack ims = items.get(n3);
						for (int j = 0; j != 10; ++j) {
							if (items.contains(ims)) {
								items.remove(ims);
							}
						}
					}
					ChestLevel.sgchest.add(e.getClickedBlock().getLocation());
				}
			}
			if (e.getClickedBlock().getType() == Material.CHEST) {
				final Chest c = (Chest) e.getClickedBlock().getState();
				final Inventory inv = c.getInventory();
				if (!ChestLevel.sgchest.contains(e.getClickedBlock().getLocation())) {
					int l = ChestFile.ChestFile.getInt("MaxItemsInChest");
					final ArrayList<String> list = new ArrayList<String>();
					for (final String alls : ChestLevel.itemList1) {
						list.add(alls);
					}
					final List<ItemStack> items = new ArrayList<ItemStack>();
					final String remove = "";

					for (final String all : list) {
						int ID = 0;
						int subID = 0;
						int amount = 0;
						int chance = 0;
						if (all.contains(":")) {
							final String[] array = all.split(":");
							ID = Integer.valueOf(array[0]);
							String a = array[1];
							a = a.substring(0, 1);
							subID = Integer.valueOf(a);
						}
						final String[] array = all.split(", ");
						amount = Integer.valueOf(array[1]);
						chance = Integer.valueOf(array[2]);
						for (int i = 0; i < chance; ++i) {
							if (ID == 272) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DAMAGE_ALL, 1));
							} else if (ID == 267){ 
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DURABILITY, 1));	
							} else if (ID == 306 || ID == 307) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_ENVIRONMENTAL, 1));
							} else if (ID == 268 || ID == 258) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.DAMAGE_ALL, 2));
							} else if (ID == 301 || ID == 309) {
								items.add(itemBuild(ID, amount, (short) subID, Enchantment.PROTECTION_FALL, 2));
							} else {
								items.add(new ItemStack(ID, amount, (short) subID));

							}
							list.remove(remove);
						}
					}

					while (l != 0) {
						--l;
						final Random r2 = new Random();
						final Random r3 = new Random();
						final int n2 = r2.nextInt(26);
						final int n3 = r3.nextInt(items.size());
						inv.setItem(n2, (ItemStack) items.get(n3));
						final ItemStack ims = items.get(n3);
						for (int j = 0; j != 10; ++j) {
							if (items.contains(ims)) {
								items.remove(ims);
							}
						}
					}
					ChestLevel.sgchest.add(e.getClickedBlock().getLocation());
				}
			}
		}
	}
}