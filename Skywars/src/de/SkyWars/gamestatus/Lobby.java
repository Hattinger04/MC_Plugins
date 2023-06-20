// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

import org.bukkit.plugin.Plugin;
import de.SkyWars.files.Config;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.SkyWars.main.Main;

public class Lobby
{
    public static int lobbyShed;
    
    public static void startLobby() {
        Counter.counterTimer = 61;
        for(Player current : Bukkit.getOnlinePlayers()) {
			current.setLevel(61);
		}
        Lobby.lobbyShed = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
        	
            @Override
            public void run() {
                if (Main.Status == StatusManager.Lobby) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_lobby);
                }
            }
        }, 0L, (long)(20 * Config.getTimer("lobby")));
    }
    
    public static void stopLobby() {
        Bukkit.getScheduler().cancelTask(Lobby.lobbyShed);
    }
}
