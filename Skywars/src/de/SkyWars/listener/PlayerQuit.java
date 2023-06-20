// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import de.SkyWars.gamestatus.Restart;
import de.SkyWars.gamestatus.Pregame;
import de.SkyWars.gamestatus.Game;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.Lobby;
import de.SkyWars.gamestatus.Counter;
import de.SkyWars.files.Config;
import org.bukkit.Bukkit;
import de.SkyWars.utils.Messages;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;

public class PlayerQuit implements Listener {

	
	@EventHandler
	public void onQuit(final PlayerQuitEvent e) {
	
		final Player p = e.getPlayer();
		if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
			int wert = Config.getPlayerInTeam() * Config.getTeams();
			e.setQuitMessage(Messages.prefix + "§c<<§3 " + p.getDisplayName() + "§f hat das Spiel §cverlassen§f. (§3"
					+ (Bukkit.getOnlinePlayers().size() - 1) + " §f/§3 " + wert + "§f)");

			if (Main.Status == StatusManager.Counter && Bukkit.getOnlinePlayers().size() - 1 < Config.getPlayerToStart() && !Main.starten) {
				Counter.stopCounter();
				Lobby.startLobby();
			}
		}
		PlayerTeams.removeSpecTeam(p);
		PlayerTeams.removeTeam(p);
		if (Main.Status == StatusManager.Pregame || Main.Status == StatusManager.Game) {	
			if (!PlayerTeams.Spectator.contains(p)) {
				MySQLStats.addDeaths(p.getUniqueId().toString(), 1);
			}
			if (PlayerTeams.checkWinnerTeam() != null && PlayerTeams.gameEnd) {
				Game.stopGame();
				Pregame.stopPreGame();
				Restart.startRestart();
			}
		}
		if(Main.Status == StatusManager.Restart) {
			e.setQuitMessage(Messages.prefix + "§c<<§3 " + p.getDisplayName() + "§f hat das Spiel §cverlassen§f.");
		}
	}
	
	@EventHandler
	public void onCommandEvent(PlayerCommandPreprocessEvent event) {
		if(event.getMessage().equals("/start")) {
			Main.starten = true; 
		}
	}
}
