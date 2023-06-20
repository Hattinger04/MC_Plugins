// 
 // Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import de.SkyWars.playerdata.Kits;
import de.SkyWars.playerdata.PlayerKits;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

import org.bukkit.inventory.ItemStack;
import org.bukkit.SkullType;
import org.bukkit.Sound;

import de.SkyWars.mysql.MySQLKits;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerInventorys;
import net.LikeAnOnwer.CoinAPI.mysql.CoinAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class PlayerInteract implements Listener {
	private Main plugin;

	public PlayerInteract(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@EventHandler
	public void onInteract(final PlayerInteractEvent e) {

		final Player p = e.getPlayer();
		if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK
					|| e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (p.getInventory().getItemInHand() != null) {
					if (p.getInventory().getItemInHand().getType() == Material.WOOL) {
						PlayerInventorys.ChooseTeam(p);
					}
					if (p.getInventory().getItemInHand().getType() == Material.EMERALD) {
						final Inventory inv = MySQLStats.playerTop;
						p.openInventory(MySQLStats.playerTop);
					} else if (p.getInventory().getItemInHand().getType() == Material.CHEST) {
						PlayerInventorys.ChooseKit(p);
					}
					e.setCancelled(true);
				} else {
					e.setCancelled(true);
				}
				if(e.getClickedBlock().getType() == Material.LEVER) {
					e.setCancelled(false);
				}
			}
		} else if (PlayerTeams.Spectator.contains(p)
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK)) {
			e.setCancelled(true);
		}
		List<Entity> entities;
		if (Main.Status == StatusManager.Game) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
					if (MySQLKits.getLastKit(p.getUniqueId().toString()) == 3) {
						if (!p.isSneaking()) {
							if (PlayerKits.PlayerKit.get(p) == Kits.Enderman) {
								e.setCancelled(true);
								Player result = null;
								double lastDistance = Double.MAX_VALUE;
								for (Player p2 : p.getWorld().getPlayers()) {
									if (p == p2) {
										continue;
									}
									if(PlayerTeams.Spectator.contains(p2)) {
										continue; 
									}
									double distance = p.getLocation().distance(p2.getLocation());
									if (distance < lastDistance) {
										lastDistance = distance;
										result = p2;
									}
								}
								if (result != null) {
									p.sendMessage(Messages.prefix + "§cDu teleportierst dich nun in 3 Sekunden zu §c§7"
											+ result.getName());
									result.sendMessage(Messages.prefix + "§7" + p.getDisplayName() + "§7§c teleportiert sich nun zu dir.");
									Location location = result.getLocation(); 
									Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										@Override
										public void run() {
											p.teleport(location);
											p.getInventory().removeItem(new ItemStack(Material.ENDER_PEARL, 1));
										}
									},60L);
									
								} else {
									p.sendMessage(Messages.prefix + "§cEs wurde kein Spieler gefunden, zu dem du dich teleportieren kannst!");
								}

							} else {
								e.setCancelled(true);
								p.sendMessage(Messages.prefix + "§cDu kannst dich nicht teleportieren..");

							}
						}
					} else {
						e.setCancelled(false);
					}

				}
			}
		}
		if (Main.Status != StatusManager.Game) {
			if (PlayerKits.PlayerKit.get(p) == Kits.Enderman) {
				if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
					if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
						if (MySQLKits.getLastKit(p.getUniqueId().toString()) == 3) {
							if (!p.isSneaking()) {
								e.setCancelled(true);
								p.sendMessage(Messages.prefix + "§cDu kannst noch keine Enderpearl benutzen!");
							} else {
								e.setCancelled(false);
							}

					} else {
						e.setCancelled(false);
					}
					}
					
				}
			}

		}

		////////////////////////////////////////////

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (p.getItemInHand().getType() == Material.FIREWORK) {
				p.setVelocity(new Vector(0, 50, 0));
				p.getInventory().removeItem(new ItemStack(Material.FIREWORK, 1));
				p.playSound(p.getLocation(), Sound.EXPLODE, 3, 2);

				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					@Override
					public void run() {
						final int lastKit = MySQLKits.getLastKit(p.getUniqueId().toString());
						if (lastKit != 13) {
							if (p.getHealth() < 6) {
								p.setHealth(0);
							} else {
								p.setHealth(p.getHealth() - 5);
							}
							p.sendMessage(Messages.prefix + "Du bist kein Vogel, raus aus der Luft!");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 3, 2);

						} else if (lastKit == 13 && p.getInventory().getHelmet() == null) {
							if (p.getHealth() < 6) {
								p.setHealth(0);
							} else {
								p.setHealth(p.getHealth() - 5);
							}
							p.sendMessage(Messages.prefix + "Du musst einen Helm tragen!");
							p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 3, 2);
						}
					}
				}, 20 * 3);

			}
		}

	}

}