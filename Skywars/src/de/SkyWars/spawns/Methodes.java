// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.spawns;

import de.SkyWars.playerdata.PlayerTeams;
import java.util.Iterator;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.worldreset.LoadRandomMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class Methodes
{
    public static File file;
    public static FileConfiguration spawnFile;
    
    static {
        Methodes.file = new File("plugins/SkyWars", "Spawn.yml");
        Methodes.spawnFile = (FileConfiguration)YamlConfiguration.loadConfiguration(Methodes.file);
    }
    
    public static void setLobby(final Player p) {
        final double x = p.getLocation().getX();
        final double y = p.getLocation().getY();
        final double z = p.getLocation().getZ();
        final double yaw = p.getLocation().getYaw();
        final double pitch = p.getLocation().getPitch();
        final String world = p.getLocation().getWorld().getName();
        Methodes.spawnFile.set("Lobby.x", (Object)x);
        Methodes.spawnFile.set("Lobby.y", (Object)y);
        Methodes.spawnFile.set("Lobby.z", (Object)z);
        Methodes.spawnFile.set("Lobby.yaw", (Object)yaw);
        Methodes.spawnFile.set("Lobby.pitch", (Object)pitch);
        Methodes.spawnFile.set("Lobby.world", (String)world);
        try {
            Methodes.spawnFile.save(Methodes.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Location getLobby() {
        final double x = Methodes.spawnFile.getDouble("Lobby.x");
        final double y = Methodes.spawnFile.getDouble("Lobby.y");
        final double z = Methodes.spawnFile.getDouble("Lobby.z");
        final float yaw = (float)Methodes.spawnFile.getDouble("Lobby.yaw");
        final float pitch = (float)Methodes.spawnFile.getDouble("Lobby.pitch");
        final String world = Methodes.spawnFile.getString("Lobby.world");
        final Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setPitch(pitch);
        loc.setYaw(yaw);
        return loc;
    }
    
    public static void setSpectator(final Player p) {
        final double x = p.getLocation().getX();
        final double y = p.getLocation().getY();
        final double z = p.getLocation().getZ();
        final double yaw = p.getLocation().getYaw();
        final double pitch = p.getLocation().getPitch();
        final String world = p.getLocation().getWorld().getName();
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.x", (Object)x);
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.y", (Object)y);
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.z", (Object)z);
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.yaw", (Object)yaw);
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.pitch", (Object)pitch);
        Methodes.spawnFile.set(String.valueOf(world) + ".spectator.world", (String)world);
        try {
            Methodes.spawnFile.save(Methodes.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Location getSpectator() {
        final String world = LoadRandomMap.map;
        final double x = Methodes.spawnFile.getDouble(String.valueOf(world) + ".spectator.x");
        final double y = Methodes.spawnFile.getDouble(String.valueOf(world) + ".spectator.y");
        final double z = Methodes.spawnFile.getDouble(String.valueOf(world) + ".spectator.z");
        final float yaw = (float)Methodes.spawnFile.getDouble(String.valueOf(world) + ".spectator.yaw");
        final float pitch = (float)Methodes.spawnFile.getDouble(String.valueOf(world) + ".spectator.pitch");
        final Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setPitch(pitch);
        loc.setYaw(yaw);
        return loc;
    }
    
    public static void setPlayerSpawn(final Player p, final String team) {
        final double x = p.getLocation().getX();
        final double y = p.getLocation().getY();
        final double z = p.getLocation().getZ();
        final double yaw = p.getLocation().getYaw();
        final double pitch = p.getLocation().getPitch();
        final String world = p.getLocation().getWorld().getName();
        if (team.equals("Rot")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Gelb")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Gr\u00fcn")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Blau")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (Object)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Schwarz")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Wei\u00df")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("Lila")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else if (team.equals("T\u00fcrkis")) {
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".x", (Object)x);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".y", (Object)y);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".z", (Object)z);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".yaw", (Object)yaw);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".pitch", (Object)pitch);
            Methodes.spawnFile.set(String.valueOf(world) + "." + team + ".world", (String)world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "Team " + team + " wurde gesetzt");
        }
        else { 
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cBenutze einer dieser Teams: Rot, Gelb, Grün, Blau, Lila, Türkis, Weiß, Schwarz");
        }
        try {
            Methodes.spawnFile.save(Methodes.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendAllPlayer() {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            sendPlayerToSpawn(all);
        }
    }
    
    public static void sendPlayerToSpawn(final Player p) {
        if (PlayerTeams.Blau.contains(p)) {
            p.teleport(teleport("Blau"));
        }
        if (PlayerTeams.Rot.contains(p)) {
            p.teleport(teleport("Rot"));
        }
        if (PlayerTeams.Gelb.contains(p)) {
            p.teleport(teleport("Gelb"));
        }
        if (PlayerTeams.Grün.contains(p)) {
            p.teleport(teleport("Grün"));
        }
        if (PlayerTeams.Schwarz.contains(p)) {
            p.teleport(teleport("Schwarz"));
        }
        if (PlayerTeams.Weiß.contains(p)) {
            p.teleport(teleport("Weiß"));
        }
        if (PlayerTeams.Lila.contains(p)) {
            p.teleport(teleport("Lila"));
        }
        if (PlayerTeams.Türkis.contains(p)) {
            p.teleport(teleport("Türkis"));
        }
    }
    
    public static Location teleport(final String team) {
        final String world = LoadRandomMap.map;
        final double x = Methodes.spawnFile.getDouble(String.valueOf(world) + "." + team + ".x");
        final double y = Methodes.spawnFile.getDouble(String.valueOf(world) + "." + team + ".y");
        final double z = Methodes.spawnFile.getDouble(String.valueOf(world) + "." + team + ".z");
        final float yaw = (float)Methodes.spawnFile.getDouble(String.valueOf(world) + "." + team + ".yaw");
        final float pitch = (float)Methodes.spawnFile.getDouble(String.valueOf(world) + "." + team + ".pitch");
        final Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setPitch(pitch);
        loc.setYaw(yaw);
        return loc;
    }
}
