// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.playerdata;

import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.files.Config;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import net.LikeAnOnwer.CoinAPI.mysql.CoinAPI;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerTeams
{
    public static ArrayList<Player> Rot;
    public static ArrayList<Player> Blau;
    public static ArrayList<Player> Gelb;
    public static ArrayList<Player> Gr\u00fcn;
    public static ArrayList<Player> Schwarz;
    public static ArrayList<Player> Lila;
    public static ArrayList<Player> Wei\u00df;
    public static ArrayList<Player> T\u00fcrkis;
    public static ArrayList<Player> SpecRot;
    public static ArrayList<Player> SpecBlau;
    public static ArrayList<Player> SpecGelb;
    public static ArrayList<Player> SpecGr\u00fcn;
    public static ArrayList<Player> SpecSchwarz;
    public static ArrayList<Player> SpecLila;
    public static ArrayList<Player> SpecWei\u00df;
    public static ArrayList<Player> SpecT\u00fcrkis;
    public static ArrayList<Player> Spectator;
    public static boolean gameEnd;
    
    static {
        PlayerTeams.Rot = new ArrayList<Player>();
        PlayerTeams.Blau = new ArrayList<Player>();
        PlayerTeams.Gelb = new ArrayList<Player>();
        PlayerTeams.Gr\u00fcn = new ArrayList<Player>();
        PlayerTeams.Schwarz = new ArrayList<Player>();
        PlayerTeams.Lila = new ArrayList<Player>();
        PlayerTeams.Wei\u00df = new ArrayList<Player>();
        PlayerTeams.T\u00fcrkis = new ArrayList<Player>();
        PlayerTeams.SpecRot = new ArrayList<Player>();
        PlayerTeams.SpecBlau = new ArrayList<Player>();
        PlayerTeams.SpecGelb = new ArrayList<Player>();
        PlayerTeams.SpecGr\u00fcn = new ArrayList<Player>();
        PlayerTeams.SpecSchwarz = new ArrayList<Player>();
        PlayerTeams.SpecLila = new ArrayList<Player>();
        PlayerTeams.SpecWei\u00df = new ArrayList<Player>();
        PlayerTeams.SpecT\u00fcrkis = new ArrayList<Player>();
        PlayerTeams.Spectator = new ArrayList<Player>();
        PlayerTeams.gameEnd = false;
    }
    
    public static void noTeam(final Player p) {
        if (!PlayerTeams.Rot.contains(p) && !PlayerTeams.Blau.contains(p) && !PlayerTeams.Gelb.contains(p) && !PlayerTeams.Gr\u00fcn.contains(p) && !PlayerTeams.Lila.contains(p) && !PlayerTeams.Wei\u00df.contains(p) && !PlayerTeams.Schwarz.contains(p) && !PlayerTeams.T\u00fcrkis.contains(p)) {
            if (!checkTeamFull(Teams.Blau)) {
                addTeam(p, Teams.Blau);
                return;
            }
            if (!checkTeamFull(Teams.Rot)) {
                addTeam(p, Teams.Rot);
                return;
            }
            if (!checkTeamFull(Teams.Gelb)) {
                addTeam(p, Teams.Gelb);
                return;
            }
            if (!checkTeamFull(Teams.Gr\u00fcn)) {
                addTeam(p, Teams.Gr\u00fcn);
                return;
            }
            if (!checkTeamFull(Teams.Wei\u00df)) {
                addTeam(p, Teams.Wei\u00df);
                return;
            }
            if (!checkTeamFull(Teams.Schwarz)) {
                addTeam(p, Teams.Schwarz);
                return;
            }
            if (!checkTeamFull(Teams.Lila)) {
                addTeam(p, Teams.Lila);
                return;
            }
            if (!checkTeamFull(Teams.T\u00fcrkis)) {
                addTeam(p, Teams.T\u00fcrkis);
            }
        }
    }
    
    public static void removeTeam(final Player p) {
        if (PlayerTeams.Rot.contains(p)) {
            PlayerTeams.Rot.remove(p);
        }
        if (PlayerTeams.Blau.contains(p)) {
            PlayerTeams.Blau.remove(p);
        }
        if (PlayerTeams.Gelb.contains(p)) {
            PlayerTeams.Gelb.remove(p);
        }
        if (PlayerTeams.Gr\u00fcn.contains(p)) {
            PlayerTeams.Gr\u00fcn.remove(p);
        }
        if (PlayerTeams.Schwarz.contains(p)) {
            PlayerTeams.Schwarz.remove(p);
        }
        if (PlayerTeams.Lila.contains(p)) {
            PlayerTeams.Lila.remove(p);
        }
        if (PlayerTeams.Wei\u00df.contains(p)) {
            PlayerTeams.Wei\u00df.remove(p);
        }
        if (PlayerTeams.T\u00fcrkis.contains(p)) {
            PlayerTeams.T\u00fcrkis.remove(p);
        }
    }
    
    public static void removeSpecTeam(final Player p) {
        if (PlayerTeams.SpecRot.contains(p)) {
            PlayerTeams.SpecRot.remove(p);
        }
        if (PlayerTeams.SpecBlau.contains(p)) {
            PlayerTeams.SpecBlau.remove(p);
        }
        if (PlayerTeams.SpecGelb.contains(p)) {
            PlayerTeams.SpecGelb.remove(p);
        }
        if (PlayerTeams.SpecGr\u00fcn.contains(p)) {
            PlayerTeams.SpecGr\u00fcn.remove(p);
        }
        if (PlayerTeams.SpecSchwarz.contains(p)) {
            PlayerTeams.SpecSchwarz.remove(p);
        }
        if (PlayerTeams.SpecLila.contains(p)) {
            PlayerTeams.SpecLila.remove(p);
        }
        if (PlayerTeams.SpecWei\u00df.contains(p)) {
            PlayerTeams.SpecWei\u00df.remove(p);
        }
        if (PlayerTeams.SpecT\u00fcrkis.contains(p)) {
            PlayerTeams.SpecT\u00fcrkis.remove(p);
        }
    }
    
    public static void addTeam(final Player p, final Teams t) {
        if (checkTeamFull(t)) {
            p.sendMessage(String.valueOf(PlayerMessages.prefix) + "§cTeam ist bereits voll");
        }
        else {
            removeTeam(p);
            removeSpecTeam(p);
            if (t.equals(Teams.Blau)) {
                PlayerTeams.Blau.add(p);
                PlayerTeams.SpecBlau.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Blau.getName()));
            }
            if (t.equals(Teams.Gelb)) {
                PlayerTeams.Gelb.add(p);
                PlayerTeams.SpecGelb.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Gelb.getName()));
            }
            if (t.equals(Teams.Gr\u00fcn)) {
                PlayerTeams.Gr\u00fcn.add(p);
                PlayerTeams.SpecGr\u00fcn.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Gr\u00fcn.getName()));
            }
            if (t.equals(Teams.Rot)) {
                PlayerTeams.Rot.add(p);
                PlayerTeams.SpecRot.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Rot.getName()));
            }
            if (t.equals(Teams.Lila)) {
                PlayerTeams.Lila.add(p);
                PlayerTeams.SpecLila.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Lila.getName()));
            }
            if (t.equals(Teams.T\u00fcrkis)) {
                PlayerTeams.T\u00fcrkis.add(p);
                PlayerTeams.SpecT\u00fcrkis.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.T\u00fcrkis.getName()));
            }
            if (t.equals(Teams.Wei\u00df)) {
                PlayerTeams.Wei\u00df.add(p);
                PlayerTeams.SpecWei\u00df.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Wei\u00df.getName()));
            }
            if (t.equals(Teams.Schwarz)) {
                PlayerTeams.Schwarz.add(p);
                PlayerTeams.SpecSchwarz.add(p);
                p.sendMessage(String.valueOf(PlayerMessages.prefix) + Messages.team_choose.replaceAll("%TEAM%", Teams.Schwarz.getName()));
            }
        }
    }
    
    public static void addSpectator(final Player p) {
        PlayerTeams.Spectator.add(p);
    }
    
    @SuppressWarnings("deprecation")
	public static String checkWinnerTeam() {
        if (Config.getTeams() == 2) {
            if (PlayerTeams.Blau.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecRot) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Rot.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Rot.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Rot.getName());
            }
            if (PlayerTeams.Rot.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecBlau) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Blau.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Blau.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Blau.getName());
            }
        }
        if (Config.getTeams() == 4) {
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecGr\u00fcn) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Gr\u00fcn.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Rot.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Gr\u00fcn.getName());
            }
            if (PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecBlau) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Blau.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Blau.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Blau.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Gelb.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecRot) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Rot.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Rot.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Rot.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecGelb) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Gelb.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Gelb.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Gelb.getName());
            }
        }
        if (Config.getTeams() == 8) {
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecGr\u00fcn) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Gr\u00fcn.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Rot.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Gr\u00fcn.getName());
            }
            if (PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecBlau) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Blau.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Blau.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Blau.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecRot) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Rot.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Rot.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Rot.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecGelb) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Gelb.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Gelb.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Gelb.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecSchwarz) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Schwarz.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Schwarz.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Schwarz.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecLila) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Lila.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Lila.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Lila.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0 && PlayerTeams.T\u00fcrkis.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecWei\u00df) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.Wei\u00df.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.Wei\u00df.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.Wei\u00df.getName());
            }
            if (PlayerTeams.Blau.size() == 0 && PlayerTeams.Rot.size() == 0 && PlayerTeams.Gelb.size() == 0 && PlayerTeams.Schwarz.size() == 0 && PlayerTeams.Lila.size() == 0 && PlayerTeams.Wei\u00df.size() == 0 && PlayerTeams.Gr\u00fcn.size() == 0) {
                PlayerTeams.gameEnd = true;
                for (final Player all : PlayerTeams.SpecT\u00fcrkis) {
                    MySQLStats.addWins(all.getUniqueId().toString(), 1);
                    CoinAPI.addCoins(all.getName(), 200);
                }
                PlayerMessages.sendAllTitel(5, 100, 5, Messages.win_titel1.replaceAll("%TEAM%", Teams.T\u00fcrkis.getName()), Messages.win_titel2.replaceAll("%TEAM%", Teams.T\u00fcrkis.getName()));
                return String.valueOf(PlayerMessages.prefix) + Messages.win_message.replaceAll("%TEAM%", Teams.T\u00fcrkis.getName());
            }
        }
        return null;
    }
    
    public static boolean checkTeamFull(final Teams t) {
        final int maxTeamPlayer = Config.getPlayerInTeam();
        return (t.equals(Teams.Blau) && PlayerTeams.Blau.size() == maxTeamPlayer) || (t.equals(Teams.Gelb) && PlayerTeams.Gelb.size() == maxTeamPlayer) || (t.equals(Teams.Gr\u00fcn) && PlayerTeams.Gr\u00fcn.size() == maxTeamPlayer) || (t.equals(Teams.Rot) && PlayerTeams.Rot.size() == maxTeamPlayer) || (t.equals(Teams.Lila) && PlayerTeams.Lila.size() == maxTeamPlayer) || (t.equals(Teams.T\u00fcrkis) && PlayerTeams.T\u00fcrkis.size() == maxTeamPlayer) || (t.equals(Teams.Wei\u00df) && PlayerTeams.Wei\u00df.size() == maxTeamPlayer) || (t.equals(Teams.Schwarz) && PlayerTeams.Schwarz.size() == maxTeamPlayer);
    }
}
