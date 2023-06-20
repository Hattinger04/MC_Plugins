// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.mysql;

import java.sql.SQLException;
import java.sql.ResultSet;
import de.SkyWars.main.Main;

public class MySQLKits
{
    public static Integer getUserRanking(final String p) {
        boolean done = false;
        int n = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            try {
                ResultSet rs;
                for (rs = Main.mysql.query("SELECT UUID FROM SkyWarsKits ORDER BY WIN DESC;"); rs.next() && !done; done = true) {
                    ++n;
                    if (rs.getString(1).equalsIgnoreCase(p)) {}
                }
                rs.close();
            }
            catch (Exception err) {
                System.err.println("[] gSystem-Error-User-getUserRanking []");
                System.err.println(err);
                System.err.println("[] gSystem-Error-User-getUserRanking []");
            }
        }
        return n;
    }
    
    public static boolean playerExists(final String uuid) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            try {
                final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsKits WHERE UUID= '" + uuid + "'");
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
            Main.mysql.update("INSERT INTO SkyWarsKits(UUID, K1,K2,K3,K4,K5,K6,K7,K8,K9,K10,K11,K12,K13,K14,K15,K16,K17,K18,K19,K20,K21,K22,K23,K24,K25,K26,K27, LAST) VALUES ('" + uuid + "', '1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0', '1');");
        }
    }
    
    public static boolean getKit(final String uuid, final String id) {
        boolean has = false;
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(uuid)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsKits WHERE UUID= '" + uuid + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt(id)) == null) {}
                    i = rs.getInt(id);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(uuid);
                getKit(uuid, id);
            }
        }
        if (i != 0) {
            has = true;
        }
        return has;
    }
    
    public static void addKit(final String name, final String id) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsKits SET " + id + "= '" + 1 + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                addKit(name, id);
            }
        }
    }
    
    public static void setLastKit(final String name, final int kit) {
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                Main.mysql.update("UPDATE SkyWarsKits SET LAST= '" + kit + "' WHERE UUID= '" + name + "';");
            }
            else {
                createPlayer(name);
                setLastKit(name, kit);
            }
        }
    }
    
    public static int getLastKit(final String name) {
        Integer i = 0;
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            if (playerExists(name)) {
                try {
                    final ResultSet rs = Main.mysql.query("SELECT * FROM SkyWarsKits WHERE UUID= '" + name + "'");
                    if (!rs.next() || Integer.valueOf(rs.getInt("Last")) == null) {}
                    i = rs.getInt("Last");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                createPlayer(name);
                getLastKit(name);
            }
        }
        return i;
    }
}
