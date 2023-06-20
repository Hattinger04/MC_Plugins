// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

import org.bukkit.plugin.Plugin;
import org.bukkit.Sound;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.utils.PlayerScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.SkyWars.main.Main;
import de.SkyWars.files.Config;

public class Pregame
{
    public static int preGameShed;
    public static int preGameTimer;
    
    static {
        Pregame.preGameTimer = Config.getTimer("pregame") + 1;
    }
    
    public static void startPreGame() {
        Main.Status = StatusManager.Pregame;
        for (final Player all : Bukkit.getOnlinePlayers()) {
            PlayerScoreboard.ingameBoard(all);
            all.setLevel(1);
        }
        Pregame.preGameShed = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (Pregame.preGameTimer != 0) {
                    --Pregame.preGameTimer;
                }
                if (Pregame.preGameTimer == 60 || Pregame.preGameTimer == 30 || Pregame.preGameTimer == 20 || Pregame.preGameTimer == 10 || (Pregame.preGameTimer <= 5 && Pregame.preGameTimer >= 1)) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_pregame.replaceAll("%TIME%", new StringBuilder().append(Pregame.preGameTimer).toString()));
                    PlayerMessages.sendAllSound(Sound.NOTE_SNARE_DRUM);
                }
                if (Pregame.preGameTimer == 0) {
                    PlayerMessages.sendAllSound(Sound.LEVEL_UP);
                    PlayerMessages.sendAllTitel(5, 20, 5, Messages.counter_pregameendT1, Messages.counter_pregameendT2);
                    Game.startGame();
                    Pregame.stopPreGame();
                }
            }
        }, 0L, 20L);
    }
    
    public static void stopPreGame() {
        Bukkit.getScheduler().cancelTask(Pregame.preGameShed);
    }
}
