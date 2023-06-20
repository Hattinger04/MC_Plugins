// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.utils;

import org.bukkit.plugin.Plugin;
import de.SkyWars.files.Config;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.Bukkit;

public class MOTD
{
    public static void motdSetter() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getplugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (Main.Status == StatusManager.Lobby) {
                    ((CraftServer)Bukkit.getServer()).getServer().setMotd(Config.getMotd("lobby").replaceAll("&", "§"));
                }
                else if (Main.Status == StatusManager.Counter) {
                    ((CraftServer)Bukkit.getServer()).getServer().setMotd(Config.getMotd("counter").replaceAll("&", "§"));
                }
                else if (Main.Status == StatusManager.Pregame) {
                    ((CraftServer)Bukkit.getServer()).getServer().setMotd(Config.getMotd("pregame").replaceAll("&", "§"));
                }
                else if (Main.Status == StatusManager.Game) {
                    ((CraftServer)Bukkit.getServer()).getServer().setMotd(Config.getMotd("game").replaceAll("&", "§"));
                }
                else if (Main.Status == StatusManager.Restart) {
                    ((CraftServer)Bukkit.getServer()).getServer().setMotd(Config.getMotd("restart").replaceAll("&", "§"));
                }
            }
        }, 0L, 20L);
    }
}
