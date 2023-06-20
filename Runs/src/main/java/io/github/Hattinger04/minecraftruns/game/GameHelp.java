/**
 * @author Hattinger04
 * 
 * Import names from file maybe?
 */
package io.github.Hattinger04.minecraftruns.game;


import org.bukkit.event.Listener;

import io.github.Hattinger04.minecraftruns.MinecraftRuns;

public class GameHelp {

	private final MinecraftRuns plugin; 
	
	public GameHelp(MinecraftRuns plugin) {
		this.plugin = plugin; 
	}
	
	public Listener getGameFromString(String name) {
		Listener listener = null;
		switch (name) {
		case "sharedHeartsNR":
			listener = new GameSharedHeartsNR(plugin, "sharedHeartsNR"); 
			break;
		case "sharedHeartsR":
			listener = new GameSharedHeartsR(plugin, "sharedHeartsR"); 
			break;
		default: 
			break; 
		}
		return listener; 
	}
}
