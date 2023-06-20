// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.utils;

import org.bukkit.scoreboard.Team;
import java.util.Iterator;
import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import de.SkyWars.files.Config;
import de.SkyWars.mysql.MySQL;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.playerdata.PlayerTeams;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import de.SkyWars.worldreset.LoadRandomMap;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Scoreboard;
import org.bukkit.entity.Player;

public class PlayerScoreboard
{
    public static void setBoard(final Player p) {
        final Scoreboard sb = new Scoreboard();
        final ScoreboardObjective obj = sb.registerObjective("asdf", IScoreboardCriteria.b);
        obj.setDisplayName(Messages.sb_head);
        final PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        final PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        final ScoreboardScore a = new ScoreboardScore(sb, obj, "§a");
        final ScoreboardScore a2 = new ScoreboardScore(sb, obj, "§aMap");
        final ScoreboardScore a3 = new ScoreboardScore(sb, obj, "§e" + LoadRandomMap.map);
        a.setScore(2);
        a2.setScore(1);
        a3.setScore(0);
        final PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        final PacketPlayOutScoreboardScore pa = new PacketPlayOutScoreboardScore(a);
        final PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        final PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        sendPacket(p, (Packet)removePacket);
        sendPacket(p, (Packet)createPacket);
        sendPacket(p, (Packet)display);
        sendPacket(p, (Packet)pa);
        sendPacket(p, (Packet)pa2);
        sendPacket(p, (Packet)pa3);
        setTeams(p);
        setDisplayName(p);
    }
    
    public static void setPlayerListName(final Player p) {
    	p.setPlayerListName(p.getDisplayName() + statsRangliste(p));
    }
    
    public static String statsRangliste(final Player p) {
 
    	double divident = MySQLStats.getDeaths(p.getUniqueId().toString()); 
    	if(divident == 0) {
    		divident = 1; 
    	}
    	double wert = (MySQLStats.getWins(p.getUniqueId().toString())) * 2.5 * (MySQLStats.getKills(p.getUniqueId().toString()) / divident);
    	
    	if(wert > 1750) {
    		return "§7 [§0Chaos§7]"; 
    	}
    	else if(wert > 1300) {
    		return "§7 [§6Gott§7]"; 
    	}
    	else if(wert > 1000) {
    		return "§7 [§1Titan§7]"; 
    	} 
    	else if(wert > 750) {
    		return "§7 [§5Gigant§7]"; 
    	}
    	else if(wert > 450) {
    		return "§7 [§aHeld§7]"; 
    	}
    	else if(wert >= 150) {
    		return "§7 [§2Riese§7]"; 
    	} 
    	else if(wert < 150) {
    		return "§7 [§cMortal§7]";  
    	}
    	return null; 
    }
    public static void ingameBoard(final Player p) {
        final Scoreboard sb = new Scoreboard();
        final ScoreboardObjective obj = sb.registerObjective("asdf", IScoreboardCriteria.b);
        setPlayerListName(p);
        obj.setDisplayName(Messages.sb_head);
        final PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        final PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        final ScoreboardScore a = new ScoreboardScore(sb, obj, Messages.sb_red.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Rot.size()).toString()));
        final ScoreboardScore a2 = new ScoreboardScore(sb, obj, Messages.sb_blue.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Blau.size()).toString()));
        final ScoreboardScore a3 = new ScoreboardScore(sb, obj, Messages.sb_yellow.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Gelb.size()).toString()));
        final ScoreboardScore a4 = new ScoreboardScore(sb, obj, Messages.sb_green.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Grün.size()).toString()));
        final ScoreboardScore a5 = new ScoreboardScore(sb, obj, Messages.sb_cyan.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Türkis.size()).toString()));
        final ScoreboardScore a6 = new ScoreboardScore(sb, obj, Messages.sb_purple.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Lila.size()).toString()));
        final ScoreboardScore a7 = new ScoreboardScore(sb, obj, Messages.sb_white.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Weiß.size()).toString()));
        final ScoreboardScore a8 = new ScoreboardScore(sb, obj, Messages.sb_black.replaceAll("%COUNT%", new StringBuilder().append(PlayerTeams.Schwarz.size()).toString()));
        final PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa = null;
        PacketPlayOutScoreboardScore pa2 = null;
        PacketPlayOutScoreboardScore pa3 = null;
        PacketPlayOutScoreboardScore pa4 = null;
        PacketPlayOutScoreboardScore pa5 = null;
        PacketPlayOutScoreboardScore pa6 = null;
        PacketPlayOutScoreboardScore pa7 = null;
        PacketPlayOutScoreboardScore pa8 = null;
        if (Config.getTeams() == 2) {
            a.setScore(7);
            a2.setScore(6);
            pa = new PacketPlayOutScoreboardScore(a);
            pa2 = new PacketPlayOutScoreboardScore(a2);
        }
        if (Config.getTeams() == 4) {
            a.setScore(7);
            a2.setScore(6);
            pa = new PacketPlayOutScoreboardScore(a);
            pa2 = new PacketPlayOutScoreboardScore(a2);
            a3.setScore(5);
            a4.setScore(4);
            pa3 = new PacketPlayOutScoreboardScore(a3);
            pa4 = new PacketPlayOutScoreboardScore(a4);
        }
        if (Config.getTeams() == 8) {
            a.setScore(7);
            a2.setScore(6);
            pa = new PacketPlayOutScoreboardScore(a);
            pa2 = new PacketPlayOutScoreboardScore(a2);
            a3.setScore(5);
            a4.setScore(4);
            pa3 = new PacketPlayOutScoreboardScore(a3);
            pa4 = new PacketPlayOutScoreboardScore(a4);
            a5.setScore(3);
            a6.setScore(2);
            a7.setScore(1);
            a8.setScore(0);
            pa5 = new PacketPlayOutScoreboardScore(a5);
            pa6 = new PacketPlayOutScoreboardScore(a6);
            pa7 = new PacketPlayOutScoreboardScore(a7);
            pa8 = new PacketPlayOutScoreboardScore(a8);
        }
        sendPacket(p, (Packet)removePacket);
        sendPacket(p, (Packet)createPacket);
        sendPacket(p, (Packet)display);
        if (pa != null) {
            sendPacket(p, (Packet)pa);
        }
        if (pa2 != null) {
            sendPacket(p, (Packet)pa2);
        }
        if (pa3 != null) {
            sendPacket(p, (Packet)pa3);
        }
        if (pa4 != null) {
            sendPacket(p, (Packet)pa4);
        }
        if (pa5 != null) {
            sendPacket(p, (Packet)pa5);
        }
        if (pa6 != null) {
            sendPacket(p, (Packet)pa6);
        }
        if (pa7 != null) {
            sendPacket(p, (Packet)pa7);
        }
        if (pa8 != null) {
            sendPacket(p, (Packet)pa8);
        }
        setTeams(p);
        setDisplayName(p);
    }
    
    private static void sendPacket(final Player p, final Packet packet) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
    
    public static void registerTeams(final Player p) {
        final org.bukkit.scoreboard.Scoreboard b = p.getScoreboard();
        if (b.getTeam("001") == null) {
            b.registerNewTeam("001");
        }
        if (b.getTeam("002") == null) {
            b.registerNewTeam("002");
        }
        if (b.getTeam("003") == null) {
            b.registerNewTeam("003");
        }
        if (b.getTeam("004") == null) {
            b.registerNewTeam("004");
        }
        if (b.getTeam("005") == null) {
            b.registerNewTeam("005");
        }
        if (b.getTeam("006") == null) {
            b.registerNewTeam("006");
        }
        if (b.getTeam("007") == null) {
            b.registerNewTeam("007");
        }
        if (b.getTeam("008") == null) {
            b.registerNewTeam("008");
        }
        if (b.getTeam("009") == null) {
            b.registerNewTeam("009");
        }
        p.setScoreboard(b);
    }
    
    public static void setTeams(final Player p) {
        final org.bukkit.scoreboard.Scoreboard b = p.getScoreboard();
        for (final Player all : Bukkit.getOnlinePlayers()) {
            registerTeams(all);
            if (PlayerTeams.Blau.contains(all)) {
                final Team team1 = b.getTeam("001");
                team1.setPrefix("§1");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.Grün.contains(all)) {
                final Team team1 = b.getTeam("002");
                team1.setPrefix("§a");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.Rot.contains(all)) {
                final Team team1 = b.getTeam("003");
                team1.setPrefix("§c");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.Gelb.contains(all)) {
                final Team team1 = b.getTeam("004");
                team1.setPrefix("§e");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.Wei\u00df.contains(all)) {
                final Team team1 = b.getTeam("005");
                team1.setPrefix("§f");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.Schwarz.contains(all)) {
                final Team team1 = b.getTeam("006");
                team1.setPrefix("§0");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);

            }
            else if (PlayerTeams.Lila.contains(all)) {
                final Team team1 = b.getTeam("007");
                team1.setPrefix("§5");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            else if (PlayerTeams.T\u00fcrkis.contains(all)) {
                final Team team1 = b.getTeam("008");
                team1.setPrefix("§3");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            } else {
                final Team team1 = b.getTeam("009");
                team1.setPrefix("§7");
                team1.setAllowFriendlyFire(false);
                team1.addPlayer((OfflinePlayer)all);
            }
            all.setScoreboard(b);
            setDisplayName(p);
        }
    }
    
    public static void setDisplayName(final Player p) {
        if (PlayerTeams.Blau.contains(p)) {
            p.setDisplayName("§1" + p.getName());
        }
        else if (PlayerTeams.Grün.contains(p)) {
            p.setDisplayName("§a" + p.getName());
        }
        else if (PlayerTeams.Rot.contains(p)) {
            p.setDisplayName("§c" + p.getName());
        }
        else if (PlayerTeams.Gelb.contains(p)) {
            p.setDisplayName("§e" + p.getName());
        }
        else if (PlayerTeams.Weiß.contains(p)) {
            p.setDisplayName("§f" + p.getName());
        }
        else if (PlayerTeams.Schwarz.contains(p)) {
            p.setDisplayName("§0" + p.getName());
        }
        else if (PlayerTeams.Lila.contains(p)) {
            p.setDisplayName("§5" + p.getName());
        }
        else if (PlayerTeams.Türkis.contains(p)) {
            p.setDisplayName("§3" + p.getName());
        }
        else {
            p.setDisplayName("§7" + p.getName());
        }
    	setPlayerListName(p);

    }
}
