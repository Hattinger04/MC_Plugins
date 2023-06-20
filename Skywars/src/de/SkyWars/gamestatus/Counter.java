// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

import org.bukkit.plugin.Plugin;
import de.SkyWars.spawns.Methodes;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.utils.PlayerScoreboard;
import de.dytanic.cloudnet.ext.bridge.bukkit.BukkitCloudNetHelper;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.playerdata.PlayerKits;
import de.SkyWars.utils.PlayerInventorys;
import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.Sound;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import org.bukkit.Bukkit;
import de.SkyWars.main.Main;
import de.SkyWars.files.Config;

public class Counter
{
    public static int counterShed;
    public static int counterTimer;
    
    static {
        Counter.counterTimer = Config.getTimer("counter") + 1;
    }
    
    public static void startCounter() {
        Main.Status = StatusManager.Counter;
        Lobby.stopLobby();
        Counter.counterShed = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
            	for(Player current : Bukkit.getOnlinePlayers()) {
					current.setLevel(Counter.counterTimer);
				}

                if (Counter.counterTimer == 60 || Counter.counterTimer == 30 || Counter.counterTimer == 20 || Counter.counterTimer == 10 || (Counter.counterTimer <= 5 && Counter.counterTimer >= 1)) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_count.replaceAll("%TIME%", new StringBuilder().append(Counter.counterTimer).toString()));
                    PlayerMessages.sendAllSound(Sound.NOTE_SNARE_DRUM);
                }
                if (Counter.counterTimer == 0) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_countend);
                    PlayerMessages.sendAllSound(Sound.LEVEL_UP);
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        PlayerInventorys.clearPlayerInv(all);
                        PlayerKits.setKit(all);
                        PlayerTeams.noTeam(all);
                        PlayerScoreboard.setTeams(all);
                        MySQLStats.addPlay(all.getUniqueId().toString(), 1);
                        all.setLevel(1);
                    }
                    BukkitCloudNetHelper.changeToIngame(); 
                    Methodes.sendAllPlayer();
                    Pregame.startPreGame();
                    Counter.stopCounter();
                }
            	if (Counter.counterTimer != 0) {
                    --Counter.counterTimer;
                }
            }
        }, 0L, 20L);
    }
    
    public static void stopCounter() {
        Bukkit.getScheduler().cancelTask(Counter.counterShed);
    }
}
