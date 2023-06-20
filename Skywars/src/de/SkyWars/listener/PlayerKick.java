package de.SkyWars.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerKickEvent;

import de.SkyWars.files.Config;
import de.SkyWars.gamestatus.Counter;
import de.SkyWars.gamestatus.Lobby;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import de.SkyWars.utils.Messages;

public class PlayerKick implements Listener {
	

	
	@EventHandler
	public void onKick(PlayerKickEvent e) {
		Player p = e.getPlayer(); 
		if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
			int wert = Config.getPlayerInTeam() * Config.getTeams();
			e.setLeaveMessage(Messages.prefix + "§c<<§3 " + p.getDisplayName() + "§f hat das Spiel §cverlassen§f. (§3"
					+ (Bukkit.getOnlinePlayers().size() - 1) + " §f/§3 " + wert + "§f)");

			if (Main.Status == StatusManager.Counter
					&& Bukkit.getOnlinePlayers().size() - 1 < Config.getPlayerToStart() && !Main.starten) {
				Counter.stopCounter();
				Lobby.startLobby();
			}
		}
		
		int wert = Config.getPlayerInTeam() * Config.getTeams(); 
    
		e.setLeaveMessage(Messages.prefix + "§c<<§3 "+ p.getDisplayName() +"§f hat das Spiel §cverlassen§f. (§3"+ Bukkit.getOnlinePlayers().size() +" §f/§3 "+ wert + "§f)");
	if (e.getReason().equalsIgnoreCase("Flying is not enabled on this server") && e.getPlayer().hasPermission("fly.allow"))
		e.setCancelled(true);
	}
	@EventHandler
	public void onCommandEvent(PlayerCommandPreprocessEvent event) { 
		if(event.getMessage().equals("/start")) {
			Main.starten = true; 
		}
	}
}
