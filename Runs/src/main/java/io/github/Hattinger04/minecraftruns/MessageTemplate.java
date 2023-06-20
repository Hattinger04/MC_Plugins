package io.github.Hattinger04.minecraftruns;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MessageTemplate {

	public static void sendMessageToPlayer(String message, Player player, ChatColor color) {
		player.sendMessage(color + message + ChatColor.RESET);
	}
	
	public static void sendMessageToPlayer(String message, Player player) {
		sendMessageToPlayer(message, player, ChatColor.RESET);
	}
		
	public static void sendMessageToAllPlayer(String message, ChatColor color) {
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			player.sendMessage(color + message + ChatColor.RESET);
		}
	}
	
	public static void sendMessageToAllPlayer(String message) {
		sendMessageToAllPlayer(message, ChatColor.RESET);
	}
}
