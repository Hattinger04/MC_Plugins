// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.command;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import de.SkyWars.spawns.Methodes;
import de.SkyWars.gamestatus.Counter;
import de.SkyWars.mysql.UUIDFetcher;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.worldreset.LoadRandomMap;
import de.SkyWars.worldreset.WRFile;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Commands implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("forcemap")) {
				if (p.hasPermission("skywars.forcemap")) {
					if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
						if (args.length == 0) {
							p.sendMessage("§eWähle einer dieser Maps:");
							for (final String s : WRFile.loadWorlds) {
								p.sendMessage("§7- §e" + s);
							}
						}
						if (args.length == 1) {
							if (WRFile.loadWorlds.contains(args[0])) {
								LoadRandomMap.map = args[0];
								p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§aDie Map wurde geändert zu: §e"
										+ args[0]);
							} else {
								p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cDiese Map gibt es nicht");
							}
						}
					}
				} else {
					p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.command_noperm);
				}
			}
			if (cmd.getName().equalsIgnoreCase("stats")) {
				if (args.length == 0) {
					p.sendMessage("§e");
					p.sendMessage("§eDeine Stats");
					p.sendMessage("§7Gewonnen: §e" + MySQLStats.getWins(p.getUniqueId().toString()));
					p.sendMessage("§7Gespielt: §e" + MySQLStats.getPlay(p.getUniqueId().toString()));
					p.sendMessage("§7Kills: §e" + MySQLStats.getKills(p.getUniqueId().toString()));
					p.sendMessage("§7Tode: §e" + MySQLStats.getDeaths(p.getUniqueId().toString()));
					p.sendMessage("§7WinsRanking: §e" + MySQLStats.getUserRanking(p.getUniqueId().toString()));

					double divident = MySQLStats.getDeaths(p.getUniqueId().toString());
					if (divident == 0) {
						divident = 1;
					}
					double kd = MySQLStats.getKills(p.getUniqueId().toString()) / divident;
					p.sendMessage("§7KD: §e" + String.format("%,.2f", kd));
					p.sendMessage("§e");
				}
				if (args.length == 1) {
					final UUID uuid = UUIDFetcher.getUUID(args[0]);
					if (uuid != null) {
						final String uuidS = uuid.toString();
						p.sendMessage("§e");
						p.sendMessage("§eStats von §e" + args[0]);
						p.sendMessage("§7Gewonnen: §e" + MySQLStats.getWins(uuidS));
						p.sendMessage("§7Gespielt: §e" + MySQLStats.getPlay(uuidS));
						p.sendMessage("§7Kills: §e" + MySQLStats.getKills(uuidS));
						p.sendMessage("§7Tode: §e" + MySQLStats.getDeaths(uuidS));
						p.sendMessage("§7WinsRanking: §e" + MySQLStats.getUserRanking(uuidS));

						double divident = MySQLStats.getDeaths(uuidS);
						if (divident == 0) {
							divident = 1;
						}
						double kd = MySQLStats.getKills(uuidS) / divident;
						p.sendMessage("§7KD: §e" + String.format("%,.2f", kd));
						p.sendMessage("§e");
					} else {
						p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cSpieler exestiert nicht");
					}
				}
			}
			if (cmd.getName().equalsIgnoreCase("start")) {
				if (p.hasPermission("skywars.start")) {
					if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
						if (Main.Status == StatusManager.Counter) {
							if (Counter.counterTimer > 5) {
								Counter.counterTimer = 6;
								p.sendMessage(Messages.prefix + Messages.command_start2);
							}
						} else if (Counter.counterTimer > 5) {
							p.sendMessage(Messages.prefix + Messages.command_start);
							Counter.counterTimer = 6;
							Counter.startCounter();
						}
					}
				} else {
					p.sendMessage(Messages.command_noperm);
				}
			}
			if (cmd.getName().equalsIgnoreCase("skywars")) {
				if (p.hasPermission("skywars.setup")) {
					if (args.length == 0) {
						p.sendMessage("§e/§cskywars setlobby");
						p.sendMessage("§e/§cskywars setspectator");
						p.sendMessage("§e/§cskywars setspawn <Farbe>");
						p.sendMessage("§e/§cskywars addworld <WeltName>)");
						p.sendMessage("§e/§cskywars removeworld <WeltName>)");
						p.sendMessage("§e/§cskywars tpw <WeltName>");
						p.sendMessage("§e/§cstart");
						p.sendMessage("§e/§cstats <Spieler>");
						p.sendMessage("§e/§cforcemap <Map>");
					}
					if (args[0].equalsIgnoreCase("setlobby")) {
						Methodes.setLobby(p);
						p.sendMessage(String.valueOf(PlayerMessages.prefix) + "set Lobby spawn");
					}
					if (args[0].equalsIgnoreCase("setspectator")) {
						Methodes.setSpectator(p);
						p.sendMessage(String.valueOf(PlayerMessages.prefix) + "set Spectator spawn");
					}
				}
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("setspawn")) {
						Methodes.setPlayerSpawn(p, args[1]);
					}
					if (args[0].equalsIgnoreCase("addworld")) {
						WRFile.addWorldToFile(p, args[1]);
					}
					if (args[0].equalsIgnoreCase("removeworld")) {
						WRFile.removeWorldToFile(p, args[1]);
					}
					if (args[0].equalsIgnoreCase("tpw")) {
						if (WRFile.loadWorlds.contains(args[1])) {
							p.teleport(new Location(Bukkit.getWorld(args[1]), 0.0, 0.0, 0.0));
						} else {
							p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cDiese Map gibt es nicht");
						}
					}
				}
			}

			if (cmd.getName().equalsIgnoreCase("rank")) {

				double divident = MySQLStats.getDeaths(p.getUniqueId().toString());
				if (divident == 0) {
					divident = 1;
				}
				double wert = (MySQLStats.getWins(p.getUniqueId().toString())) * 2.5
						* (MySQLStats.getKills(p.getUniqueId().toString()) / divident);
				if (args.length == 0) {
					p.sendMessage("§7Du hast zurzeit§6 " + String.format("%,.2f", wert) + " §7Punkte.");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("info")) {
						p.sendMessage("§e");
						p.sendMessage("§eRanks:");
						p.sendMessage("§7 > 1250: §0Chaos");
						p.sendMessage("§7 > 900: §6Gott");
						p.sendMessage("§7 > 650: §1Titan");
						p.sendMessage("§7 > 400: §5Gigant");
						p.sendMessage("§7 > 250: §aHeld");
						p.sendMessage("§7 > 150: §2Riese");
						p.sendMessage("§7 < 150: §cMortal");
						p.sendMessage("§e");
					}
				}
			}

		}
		return false;
	}
}
