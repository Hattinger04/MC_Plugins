// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

import org.bukkit.plugin.Plugin;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;

import org.bukkit.Sound;

import de.SkyWars.utils.PlayerInventorys;
import de.SkyWars.spawns.Methodes;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.SkyWars.main.Main;
import de.SkyWars.files.Config;

public class Restart
{
    public static int restartShed;
    public static int restartTimer;
    
    static {
        Restart.restartTimer = Config.getTimer("restart") + 1;
    }
    
    public static void startRestart() {
        Main.Status = StatusManager.Restart;
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.setFlying(false);
            all.setAllowFlight(false);
            all.teleport(Methodes.getLobby());
            for (final Player all2 : Bukkit.getOnlinePlayers()) {
                all.showPlayer(all2);
            }
            PlayerInventorys.clearPlayerInv(all);
        }
        PlayerMessages.sendAllSound(Sound.LEVEL_UP);
        Restart.restartShed = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (Restart.restartTimer != 0) {
                    --Restart.restartTimer;
                }
                if (Restart.restartTimer == 60 || Restart.restartTimer == 30 || Restart.restartTimer == 15 || Restart.restartTimer == 10 || (Restart.restartTimer <= 5 && Restart.restartTimer > 1)) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_restart.replaceAll("%TIME%", new StringBuilder().append(Restart.restartTimer).toString()));
                    PlayerMessages.sendAllSound(Sound.NOTE_SNARE_DRUM);
                }
                if (Restart.restartTimer == 1) {
                	PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_restart.replaceAll("%TIME%", new StringBuilder().append(Restart.restartTimer).toString()));
                    PlayerMessages.sendAllSound(Sound.NOTE_SNARE_DRUM);
                	for(final Player all : Bukkit.getOnlinePlayers()) {
                		all.kickPlayer("§cDu wirst nun von §6Fisicraft §cvom Server GETRETEN!");
                	}
                }
                if (Restart.restartTimer == 0) {
                	Bukkit.spigot().restart();
                }
            }
        }, 0L, 20L);
    }
}
