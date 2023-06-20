// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.worldreset;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.InvalidConfigurationException;
import java.io.IOException;
import de.SkyWars.utils.PlayerMessages;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.configuration.file.YamlConfiguration;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class WRFile
{
    public static File file;
    public static FileConfiguration configFile;
    public static List<String> loadWorlds;
    
    static {
        WRFile.file = new File("plugins/SkyWars", "WorldReset.yml");
        WRFile.configFile = (FileConfiguration)YamlConfiguration.loadConfiguration(WRFile.file);
        WRFile.loadWorlds = new ArrayList<String>();
    }
    
    public static void createWorldResetFolder() {
        final File dir = new File("plugins/SkyWars/WorldReset");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
    
    public static void addWorldToFile(final Player p, final String world) {
        if (WRFile.configFile.contains("Maps")) {
            final List<String> Worlds = (List<String>)WRFile.configFile.getStringList("Maps");
            if (Worlds.contains(world)) {
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cDiese Map wurde bereits eingefügt");
            }
            else {
                final File worldFile = new File(world);
                if (worldFile.exists()) {
                    Worlds.add(world);
                    p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§aMap wurde hinzugefügt");
                    createResetFile(world);
                }
                else {
                    p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cMap konnte nicht gefunden werden");
                }
            }
            WRFile.configFile.set("Maps", (Object)Worlds);
            try {
                WRFile.configFile.save(WRFile.file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            final List<String> Worlds = new ArrayList<String>();
            Worlds.add(world);
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§aMap wurde hinzugef\u00fcgt");
            WRFile.configFile.set("Maps", (Object)Worlds);
            try {
                WRFile.configFile.save(WRFile.file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            createResetFile(world);
        }
    }
    
    public static void removeWorldToFile(final Player p, final String world) {
        if (WRFile.configFile.contains("Maps")) {
            final List<String> Worlds = (List<String>)WRFile.configFile.getStringList("Maps");
            if (Worlds.contains(world)) {
                Worlds.remove(world);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§aMap wurde gelöscht");
            }
            else {
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cMap nicht gefunden");
            }
            WRFile.configFile.set("Maps", (Object)Worlds);
            try {
                WRFile.configFile.save(WRFile.file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cMap nicht gefunden");
        }
    }
    
    public static void addToArrayList() {
        if (WRFile.file.exists()) {
            try {
                WRFile.configFile.load(WRFile.file);
            }
            catch (IOException | InvalidConfigurationException ex2) {
                final Exception ex = new Exception();
                final Exception e = ex;
                e.printStackTrace();
            }
            WRFile.loadWorlds = (List<String>)WRFile.configFile.getStringList("Maps");
        }
    }
    
    public static void loadAllMaps() {
        WRFile.loadWorlds.clear();
        addToArrayList();
        if (WRFile.file.exists()) {
            for (final String worlds : WRFile.loadWorlds) {
                Bukkit.createWorld(new WorldCreator(worlds));
            }
        }
    }
    
    public static void unloadAllMaps() {
        WRFile.loadWorlds.clear();
        addToArrayList();
        if (WRFile.file.exists()) {
            for (final String worlds : WRFile.loadWorlds) {
                Bukkit.unloadWorld(worlds, false);
            }
        }
    }
    
    public static void WorldReset() {
        unloadAllMaps();
        for (final String worlds : WRFile.loadWorlds) {
            resetFile(worlds);
        }
    }
    
    public static void resetFile(final String File) {
        final File srcDir = new File("plugins/SkyWars/WorldReset/" + File);
        final File destDir = new File(File);
        try {
            copyFolder(srcDir, destDir);
            System.out.println("Erfolgreich");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Abgekackt");
        }
    }
    
    public static void createResetFile(final String File) {
        final File destDir = new File("plugins/SkyWars/WorldReset/" + File);
        final File srcDir = new File(File);
        try {
            copyFolder(srcDir, destDir);
            System.out.println("Erfolgreich");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Abgekackt");
        }
    }
    
    public static void copyFolder(final File src, final File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from " + src + "  to " + dest);
            }
            final String[] files = src.list();
            String[] array;
            for (int length2 = (array = files).length, i = 0; i < length2; ++i) {
                final String file = array[i];
                final File srcFile = new File(src, file);
                final File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        }
        else {
            final InputStream in = new FileInputStream(src);
            final OutputStream out = new FileOutputStream(dest);
            final byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }
}
