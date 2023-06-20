// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.mysql;

import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;
import org.bukkit.SkullType;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.sql.SQLException;
import java.sql.ResultSet;
import de.SkyWars.main.Main;
import org.bukkit.inventory.Inventory;
import java.util.HashMap;

public class MySQLStats
{
    static HashMap<Integer, String> rang;
    public static Inventory playerTop;
    
    static {
        MySQLStats.rang = new HashMap<Integer, String>();
    }
    
    public static Integer getUserRanking(String p) {
        boolean done = false;
        int n = 0;
        if (MySQLFIle.sql.getBoolean("MySQL"))
          try {
            ResultSet rs = Main.mysql.query("SELECT UUID FROM SkyWarsStats ORDER BY WIN DESC;");
            while (rs.next() && !done) {
              n++;
              if (rs.getString(1).equalsIgnoreCase(p))
                done = true; 
            } 
            rs.close();
          } catch (Exception err) {
            System.err.println("[] gSystem-Error-User-getUserRanking []");
            System.err.println(err);
            System.err.println("[] gSystem-Error-User-getUserRanking []");
          }  
        return Integer.valueOf(n);
      }
    
    public static void topPlayer() {
        final ResultSet rs = Main.mysql.query("SELECT UUID FROM SkyWarsStats ORDER BY WIN DESC LIMIT 5");
        int i = 0;
        try {
            while (rs.next()) {
                ++i;
                MySQLStats.rang.put(i, rs.getString("UUID"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§aTop 5");
        int item = 11;
        for (int in = 0; in < MySQLStats.rang.size(); ++in) {
            final int id = in + 1;
            final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
            final UUID uuid = UUID.fromString(MySQLStats.rang.get(id));
            final String name = UUIDFetcher.getName(uuid);
            if (playerExists(uuid.toString())) {
                final SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§aStats von§7: §e" + name);
                final ArrayList<String> lore = new ArrayList<String>();
                lore.add("§7Gewonnen: §e" + getWins(uuid.toString()));
                lore.add("§7Gespielt: §e" + getPlay(uuid.toString()));
                lore.add("§7Kills: §e" + getKills(uuid.toString()));
                lore.add("§7Tode: §e" + getDeaths(uuid.toString()));
                lore.add("§7WinsRanking: §e" + getUserRanking(uuid.toString()));
                meta.setLore((List)lore);
                skull.setItemMeta((ItemMeta)meta);
                inv.setItem(item, skull);
            }
            ++item;
        }
        MySQLStats.playerTop = inv;
    }
    
    public static boolean playerExists(final String uuid) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            try {
                final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + uuid + "'");
                return rs.next() && rs.getString("UUID") != null;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static void createPlayer(final String uuid) {
        if (MySQLFIle.sql.getBoolean("MySQL") && !playerExists(uuid)) {
            Main.mysql.update("INSERT INTO SkyWarsStats(UUID, KILLS, DEATHS, WIN, PLAY, COINS) VALUES ('" + uuid + "', '0', '0', '0', '0', '0');");
        }
    }
    
    public static Integer getKills(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("KILLS")) == null) {}
                    i = rs.getInt("KILLS");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getKills(name);
            }
        }
        return i;
    }
    
    public static void setKills(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsStats SET KILLS= '" + kills + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setKills(name, kills);
            }
        }
    }
    
    public static void addKills(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                setKills(name, getKills(name) + kills);
            }
            else {
                createPlayer(name);
                addKills(name, kills);
            }
        }
    }
    
    public static Integer getDeaths(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("DEATHS")) == null) {}
                    i = rs.getInt("DEATHS");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getDeaths(name);
            }
        }
        return i;
    }
    
    public static void setDeaths(final String name, final Integer deaths) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsStats SET DEATHS= '" + deaths + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setDeaths(name, deaths);
            }
        }
    }
    
    public static void addDeaths(final String name, final Integer deaths) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                setDeaths(name, getDeaths(name) + deaths);
            }
            else {
                createPlayer(name);
                addDeaths(name, deaths);
            }
        }
    }
    
    public static Integer getCoins(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("COINS")) == null) {}
                    i = rs.getInt("COINS");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getCoins(name);
            }
        }
        return i;
    }
    
    public static void setCoins(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsStats SET COINS= '" + kills + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setCoins(name, kills);
            }
        }
    }
    
    public static void addCoins(final String name, final Integer kills) {
        if (playerExists(name)) {
            setCoins(name, getCoins(name) + kills);
        }
        else {
            createPlayer(name);
            addCoins(name, kills);
        }
    }
    
    public static Integer getWins(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("WIN")) == null) {}
                    i = rs.getInt("WIN");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getWins(name);
            }
        }
        return i;
    }
    
    public static void setWins(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsStats SET WIN= '" + kills + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setWins(name, kills);
            }
        }
    }
    
    public static void addWins(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                setWins(name, getWins(name) + kills);
            }
            else {
                createPlayer(name);
                addWins(name, kills);
            }
        }
    }
    
    public static Integer getPlay(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsStats WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("PLAY")) == null) {}
                    i = rs.getInt("PLAY");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getPlay(name);
            }
        }
        return i;
    }
    
    public static void setPlay(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsStats SET PLAY= '" + kills + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setPlay(name, kills);
            }
        }
    }
    
    public static void addPlay(final String name, final Integer kills) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                setPlay(name, getPlay(name) + kills);
            }
            else {
                createPlayer(name);
                addPlay(name, kills);
            }
        }
    }
}
