// 
  // Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

import org.bukkit.plugin.Plugin;
import org.bukkit.Sound;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import org.bukkit.Bukkit;
import de.SkyWars.main.Main;
import de.SkyWars.files.Config;

public class Game
{
    public static int gameShed;
    public static int gameTimer;
    
    static {
        Game.gameTimer = Config.getTimer("game") + 1;
    }
    
    public static void startGame() {
        Main.Status = StatusManager.Game;
        Game.gameShed = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (Game.gameTimer != 0) {
                    --Game.gameTimer;
                }
                if (Game.gameTimer == 60 || Game.gameTimer == 30 || Game.gameTimer == 20 || Game.gameTimer == 10 || (Game.gameTimer <= 5 && Game.gameTimer >= 1)) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_ingame.replaceAll("%TIME%", new StringBuilder().append(Game.gameTimer).toString()));
                    PlayerMessages.sendAllSound(Sound.NOTE_SNARE_DRUM);
                }
                if (Game.gameTimer == 0) {
                    PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.counter_ingameend);
                    PlayerMessages.sendAllSound(Sound.LEVEL_UP);
                    Restart.startRestart();
                    Game.stopGame();
                }
            }
        }, 0L, 20L);
    }
    
    public static void stopGame() {
        Bukkit.getScheduler().cancelTask(Game.gameShed);
    }
}
