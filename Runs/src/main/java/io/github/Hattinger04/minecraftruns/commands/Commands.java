package io.github.Hattinger04.minecraftruns.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.Hattinger04.minecraftruns.MessageTemplate;
import io.github.Hattinger04.minecraftruns.MinecraftRuns;
import io.github.Hattinger04.minecraftruns.game.GameHelp;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor{

	
	private MinecraftRuns plugin; 
	private GameHelp help; 
	
	public Commands(MinecraftRuns plugin) {
		this.plugin = plugin; 
		help = new GameHelp(plugin); 
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("help")) {
				MessageTemplate.sendMessageToPlayer("Du brauchst Hilfe?", player, ChatColor.YELLOW);
			} else if (cmd.getName().equalsIgnoreCase("gamerun")) {
				if (args.length == 0) {
					if(MinecraftRuns.getGame() != null) {
						MessageTemplate.sendMessageToPlayer(String.format("Derzeitiger Spielmodus: %s", MinecraftRuns.getGame().getName()), player);
					} else {
						MessageTemplate.sendMessageToPlayer("Kein Spielmodus ausgewählt.", player);
					}
				} else if (args.length == 1) {
					if(MinecraftRuns.getGame() != null) {
						MinecraftRuns.getGame().unregisterEvent();
					} else {
						if(plugin.registerEvent(help.getGameFromString(args[0]))) {		// not tested
							MessageTemplate.sendMessageToPlayer(String.format("Spielmodus wurde erfolgreich zu %s gewechselt.", args[0]), player);
						} else {
							MessageTemplate.sendMessageToPlayer("Spielmodus wurde nicht gewechselt!", player, ChatColor.RED);
						}
					}
				}
			}
		}
		return false;
	}

}
