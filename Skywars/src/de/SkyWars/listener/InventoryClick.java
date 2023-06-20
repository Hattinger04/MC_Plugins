// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.inventory.ItemStack;
import java.util.List;
import de.SkyWars.utils.PlayerScoreboard;
import net.LikeAnOnwer.CoinAPI.mysql.CoinAPI;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.playerdata.Teams;
import java.util.ArrayList;

import de.SkyWars.utils.PlayerInventorys;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.playerdata.PlayerKits;
import de.SkyWars.mysql.MySQLKits;
import de.SkyWars.playerdata.Kits;
import org.bukkit.event.inventory.InventoryType;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class InventoryClick implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(final InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			final Player p = (Player) e.getWhoClicked();
			if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
				if (e.getSlotType().equals((Object) InventoryType.SlotType.OUTSIDE)) {
					return;
				}
				if (e.getInventory().getName().equalsIgnoreCase("§aTop 5")) {
					e.setCancelled(true);
				}
				if (e.getInventory().getName().equalsIgnoreCase("§aKit Kaufen") && e.getCurrentItem() != null
						&& e.getCurrentItem().hasItemMeta()) {
					final String s = e.getCurrentItem().getItemMeta().getDisplayName();
					if (s.equalsIgnoreCase(Kits.Tank.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Tank.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Tank);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Tank.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Tank.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Starter.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Starter.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Starter);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Starter.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Starter.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Assasine.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Assasine.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Assasine);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Assasine.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Assasine.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Enderman.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Enderman.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Enderman);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Enderman.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Enderman.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Miner.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Miner.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Miner);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Miner.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Miner.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Gandalf.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Gandalf.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Gandalf);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Gandalf.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Gandalf.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Mlg.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Mlg.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Mlg);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Mlg.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Mlg.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Spongebob.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Spongebob.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Spongebob);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Spongebob.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Spongebob.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Gumpi.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Gumpi.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Gumpi);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Gumpi.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Gumpi.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.SuppenMeister.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SuppenMeister.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SuppenMeister);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.SuppenMeister.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.SuppenMeister.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.AntiTimolianer.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.AntiTimolianer.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.AntiTimolianer);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.AntiTimolianer.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.AntiTimolianer.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.BedwarsSpieler.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.BedwarsSpieler.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.BedwarsSpieler);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.BedwarsSpieler.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.BedwarsSpieler.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Astronaut.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Astronaut.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Astronaut);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Astronaut.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Astronaut.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.PiùAmore.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.PiùAmore.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.PiùAmore);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.PiùAmore.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.PiùAmore.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.SchlechterSenser.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SchlechterSenser.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SchlechterSenser);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.SchlechterSenser.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.SchlechterSenser.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Link.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Link.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Link);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Link.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Link.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.SpiderMan.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SpiderMan.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SpiderMan);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.SpiderMan.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.SpiderMan.getName()));
						}
					}
					if (s.equalsIgnoreCase(Kits.Berzerker.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Berzerker.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Berzerker);
							p.closeInventory();
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_choose.replaceAll("%KIT%", Kits.Berzerker.getName()));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix)
									+ Messages.kit_error.replaceAll("%KIT%", Kits.Berzerker.getName()));
						}
					}
					if (s.equalsIgnoreCase("§cZurück zur Auswahl")) {
						PlayerInventorys.ChooseKit(p);
					}

					if (s.startsWith("§7Kit Kaufen")) {
						List<String> lore = new ArrayList<String>();
						final ItemStack item = e.getCurrentItem();
						final ItemMeta im = item.getItemMeta();
						lore = (List<String>) im.getLore();
						final String[] id = lore.get(0).split(":");
						final String[] preis = lore.get(1).split(":");
						final Integer preisInt = Integer.parseInt(preis[1]);
						try {
							if (CoinAPI.hasEnoughCoins(p.getName(), preisInt)) {
								CoinAPI.setCoins(p.getName(), CoinAPI.getCoins(p.getName()) - preisInt);
								MySQLKits.addKit(p.getUniqueId().toString(), "K" + id[1]);
								p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.kit_buy_succ);
								PlayerInventorys.ChooseKit(p);
							} else {
								p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.kit_buy_error);
							}
						} catch (Exception e1) {
							p.sendMessage(
									"Es scheint etwas nicht funktioniert zu haben, versuche es erneut oder wende dich an den YouTube Kanal: §7Sbahnfoara");
							e1.printStackTrace();
						}
					}
					e.setCancelled(true);
				}
				if (e.getInventory().getName().equalsIgnoreCase("§aWähle dein Kit") && e.getCurrentItem() != null
						&& e.getCurrentItem().hasItemMeta()) {
					final String s = e.getCurrentItem().getItemMeta().getDisplayName();
					if (s.equalsIgnoreCase(Kits.Tank.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Tank.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Tank);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Tank);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Spongebob.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Spongebob.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Spongebob);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Spongebob);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Mlg.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Mlg.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Mlg);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Mlg);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Gumpi.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Gumpi.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Gumpi);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Gumpi);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Assasine.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Assasine.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Assasine);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Assasine);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Enderman.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Enderman.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Enderman);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Enderman);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Starter.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Starter.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Starter);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Starter);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Gandalf.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Gandalf.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Gandalf);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Gandalf);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Miner.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Miner.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Miner);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Miner);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.SuppenMeister.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SuppenMeister.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SuppenMeister);
						}
						PlayerInventorys.openBuyInventory(p, Kits.SuppenMeister);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.AntiTimolianer.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.AntiTimolianer.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.AntiTimolianer);
						}
						PlayerInventorys.openBuyInventory(p, Kits.AntiTimolianer);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.BedwarsSpieler.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.BedwarsSpieler.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.BedwarsSpieler);
						}
						PlayerInventorys.openBuyInventory(p, Kits.BedwarsSpieler);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Astronaut.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Astronaut.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Astronaut);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Astronaut);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.PiùAmore.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.PiùAmore.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.PiùAmore);
						}
						PlayerInventorys.openBuyInventory(p, Kits.PiùAmore);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.SchlechterSenser.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SchlechterSenser.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SchlechterSenser);
						}
						PlayerInventorys.openBuyInventory(p, Kits.SchlechterSenser);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Link.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Link.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Link);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Link);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.SpiderMan.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.SpiderMan.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.SpiderMan);
						}
						PlayerInventorys.openBuyInventory(p, Kits.SpiderMan);
						e.setCancelled(true);
					}
					if (s.equalsIgnoreCase(Kits.Berzerker.getName())) {
						if (MySQLKits.getKit(p.getUniqueId().toString(), "K" + Kits.Berzerker.getID())) {
							PlayerKits.PlayerKit.put(p, Kits.Berzerker);
						}
						PlayerInventorys.openBuyInventory(p, Kits.Berzerker);
						e.setCancelled(true);
					}
				}
				if (e.getInventory().getName().equalsIgnoreCase("§aWähle dein Team") && e.getCurrentItem() != null
						&& e.getCurrentItem().hasItemMeta()) {
					final String s = e.getCurrentItem().getItemMeta().getDisplayName();
					
					if (s.equalsIgnoreCase("§aGrün")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)13);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
				        PlayerTeams.addTeam(p, Teams.Grün);
						PlayerScoreboard.setTeams(p);
						p.closeInventory();
						
					}
					if (s.equalsIgnoreCase("§1Blau")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)11);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Blau);
						PlayerScoreboard.setTeams(p);

						p.closeInventory();
					}
					if (s.equalsIgnoreCase("§cRot")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)14);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        

						PlayerTeams.addTeam(p, Teams.Rot);
						PlayerScoreboard.setTeams(p);

						p.closeInventory();
					}
					if (s.equalsIgnoreCase("§eGelb")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)4);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Gelb);
						PlayerScoreboard.setTeams(p);

						p.closeInventory();
					}
					if (s.equalsIgnoreCase("§0Schwarz")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)15);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Schwarz);
						PlayerScoreboard.setTeams(p);
						p.closeInventory();
					}
					if (s.equalsIgnoreCase("§fWeiß")) {
						
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)0);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Weiß);
						PlayerScoreboard.setTeams(p);
						p.closeInventory();
						
					}
					if (s.equalsIgnoreCase("§3Türkis")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)9);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Türkis);
						PlayerScoreboard.setTeams(p);
						p.closeInventory();
						
					}
					if (s.equalsIgnoreCase("§5Lila")) {
						final ItemStack item = new ItemStack(Material.WOOL, 1, (short)10);
						final ItemMeta itemMeta = item.getItemMeta();
				        itemMeta.setDisplayName("§aWähle dein Team");
				        item.setItemMeta(itemMeta); 
				        p.getInventory().setItem(0, item);
				        
						PlayerTeams.addTeam(p, Teams.Lila);
						PlayerScoreboard.setTeams(p);
						p.closeInventory();
					}
				}
				e.setCancelled(true);
			} else if (PlayerTeams.Spectator.contains(p)) {
				e.setCancelled(true);
			}
		}
	}
}
