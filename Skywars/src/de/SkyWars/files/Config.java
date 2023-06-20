// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.files;

import org.bukkit.configuration.InvalidConfigurationException;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class Config
{
    public static File file;
    public static FileConfiguration configFile;
    
    static {
        Config.file = new File("plugins/SkyWars", "Config.yml");
        Config.configFile = (FileConfiguration)YamlConfiguration.loadConfiguration(Config.file);
    }
    
    public static void setDefaultConfig() {
        Config.configFile.addDefault("Teams", (Object)8);
        Config.configFile.addDefault("PlayerInTeam", (Object)2);
        Config.configFile.addDefault("PlayerToStart", (Object)4);
        Config.configFile.addDefault("Timer.lobby", (Object)60);
        Config.configFile.addDefault("Timer.counter", (Object)60);
        Config.configFile.addDefault("Timer.pregame", (Object)30);
        Config.configFile.addDefault("Timer.game", (Object)900);
        Config.configFile.addDefault("Timer.restart", (Object)15);
        Config.configFile.addDefault("Spectator.allow", (Object)true);
        Config.configFile.addDefault("Motd.lobby", (String)"&aLobby");
        Config.configFile.addDefault("Motd.counter", (String)"&6Counter");
        Config.configFile.addDefault("Motd.pregame", (String)"&cIngame");
        Config.configFile.addDefault("Motd.game", (String)"&cIngame");
        Config.configFile.addDefault("Motd.restart", (String)"&4Restart");
        Config.configFile.addDefault("update.message", (Object)true);
        Config.configFile.options().copyDefaults(true);
        try {
            Config.configFile.save(Config.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean updateMessage() {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex = new Exception();
            final Exception e = ex;
            e.printStackTrace();
        }
        return Config.configFile.getBoolean("update.message");
    }
    
    public static int getTeams() {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex = new Exception();
            final Exception e = ex;
            e.printStackTrace();
        }
        return Config.configFile.getInt("Teams");
    }
    
    public static int getPlayerInTeam() {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex;
            final Exception e = ex = new Exception();
            e.printStackTrace();
        }
        return Config.configFile.getInt("PlayerInTeam");
    }
    
    public static int getPlayerToStart() {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex;
            final Exception e = ex = new Exception();
            e.printStackTrace();
        }
        return Config.configFile.getInt("PlayerToStart");
    }
    
    public static int getTimer(final String timer) {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex;
            final Exception e = ex = new Exception();
            e.printStackTrace();
        }
        return Config.configFile.getInt("Timer." + timer);
    }
    
    public static boolean allowSpectator() {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex;
            final Exception e = ex = new Exception();
            e.printStackTrace();
        }
        return Config.configFile.getBoolean("Spectator.allow");
    }
    
    public static String getMotd(final String motd) {
        try {
            Config.configFile.load(Config.file);
        }
        catch (IOException | InvalidConfigurationException ex2) {
            final Exception ex;
            final Exception e = ex = new Exception();
            e.printStackTrace();
        }
        return Config.configFile.getString("Motd." + motd);
    }
}
