// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.utils;

import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class Messages
{
    public static File file;
    public static FileConfiguration messageFile;
    public static String prefix;
    public static String p_join;
    public static String p_leave;
    public static String p_death;
    public static String p_deathbyplayer;
    public static String sb_head;
    public static String sb_red;
    public static String sb_blue;
    public static String sb_yellow;
    public static String sb_green;
    public static String sb_black;
    public static String sb_white;
    public static String sb_purple;
    public static String sb_cyan;
    public static String team_choose;
    public static String team_name_red;
    public static String team_name_blue;
    public static String team_name_yellow;
    public static String team_name_green;
    public static String team_name_black;
    public static String team_name_white;
    public static String team_name_purple;
    public static String team_name_cyan;
    public static String counter_lobby;
    public static String counter_count;
    public static String counter_pregame;
    public static String counter_ingame;
    public static String counter_restart;
    public static String counter_countend;
    public static String counter_pregameend;
    public static String counter_pregameendT1;
    public static String counter_pregameendT2;
    public static String counter_ingameend;
    public static String command_noperm;
    public static String command_start;
    public static String command_start2;
    public static String win_message;
    public static String win_titel1;
    public static String win_titel2;
    public static String kit_1_name;
    public static String kit_2_name;
    public static String kit_3_name;
    public static String kit_4_name;
    public static String kit_5_name;
    public static String kit_6_name;
    public static String kit_7_name;
    public static String kit_8_name;
    public static String kit_9_name;
    public static String kit_10_name;
    public static String kit_11_name;
    public static String kit_12_name;
    public static String kit_13_name;
    public static String kit_14_name;
    public static String kit_15_name;
    public static String kit_16_name;
    public static String kit_17_name;
    public static String kit_18_name;
    public static String kit_1_lore;
    public static String kit_2_lore;
    public static String kit_3_lore;
    public static String kit_4_lore;
    public static String kit_5_lore;
    public static String kit_6_lore;
    public static String kit_7_lore;
    public static String kit_8_lore;
    public static String kit_9_lore;
    public static String kit_10_lore;
    public static String kit_11_lore;
    public static String kit_12_lore;
    public static String kit_13_lore;
    public static String kit_14_lore;
    public static String kit_15_lore;
    public static String kit_16_lore;
    public static String kit_17_lore;
    public static String kit_18_lore;
    public static String kit_choose;
    public static String kit_error;
    public static String kit_buy_succ;
    public static String kit_buy_error;
    
    static {
        Messages.file = new File("plugins/SkyWars", "message.yml");
        Messages.messageFile = (FileConfiguration)YamlConfiguration.loadConfiguration(Messages.file);
    }
    
    public static void setDefaultMessage() {
        Messages.messageFile.addDefault("prefix", (String)"&7[&6Skywars&7] ");
        Messages.messageFile.addDefault("player.join", (String)"&a» &7%PLAYER% &7hat das Spiel betreten");
        Messages.messageFile.addDefault("player.leave", (String)"&c« &7%PLAYER% &7hat das Spiel verlassen");
        Messages.messageFile.addDefault("player.death", (String)"%PLAYER% &7ist gestorben");
        Messages.messageFile.addDefault("player.deathbyplayer", (String)"%PLAYER% &7wurde von %KILLER% &7getötet");
        Messages.messageFile.addDefault("scoreboard.head", (String)"&7[&6Skywars&7]");
        Messages.messageFile.addDefault("scoreboard.red", (String)"&e%COUNT% &7: Team &cRot");
        Messages.messageFile.addDefault("scoreboard.blue", (String)"&e%COUNT% &7: Team &1Blau");
        Messages.messageFile.addDefault("scoreboard.yellow", (String)"&e%COUNT% &7: Team &eGelb");
        Messages.messageFile.addDefault("scoreboard.green", (String)"&e%COUNT% &7: Team &aGrün");
        Messages.messageFile.addDefault("scoreboard.black", (String)"&e%COUNT% &7: Team &0Schwarz");
        Messages.messageFile.addDefault("scoreboard.white", (String)"&e%COUNT% &7: Team &fWeiß");
        Messages.messageFile.addDefault("scoreboard.purple", (String)"&e%COUNT% &7: Team &5Lila");
        Messages.messageFile.addDefault("scoreboard.cyan", (String)"&e%COUNT% &7: Team &3Türkis");
        Messages.messageFile.addDefault("team.choose", (String)"&7Du bist nun in Team %TEAM%");
        Messages.messageFile.addDefault("team.name.red", (String)"&cRot");
        Messages.messageFile.addDefault("team.name.blue", (String)"&1Blau");
        Messages.messageFile.addDefault("team.name.yellow", (String)"&eGelb");
        Messages.messageFile.addDefault("team.name.green", (String)"&aGrün");
        Messages.messageFile.addDefault("team.name.black", (String)"&0Schwarz");
        Messages.messageFile.addDefault("team.name.white", (String)"&fWeiß");
        Messages.messageFile.addDefault("team.name.purple", (String)"&5Lila");
        Messages.messageFile.addDefault("team.name.cyan", (String)"&3Türkis");
        Messages.messageFile.addDefault("counter.lobby", (String)"&cEs wird auf weitere Spieler gewartet");
        Messages.messageFile.addDefault("counter.count", (String)"Das Spiel startet in &e%TIME% &7Sekunde(n)");
        Messages.messageFile.addDefault("counter.pregame", (String)"Schutzzeit endet in &e%TIME% &7Sekunde(n)");
        Messages.messageFile.addDefault("counter.ingame", (String)"Spiel endet in &e%TIME% &7Sekunde(n)");
        Messages.messageFile.addDefault("counter.restart", (String)"Server startet in &e%TIME% &7Sekunde(n) neu");
        Messages.messageFile.addDefault("counter.countend", (String)"&7Spieler werden Teleportiert...");
        Messages.messageFile.addDefault("counter.pregameend", (String)"&7Die Schutzzeit ist vorbei");
        Messages.messageFile.addDefault("counter.pregameend.titel1", (String)"&7Die &eSchutzzeit &7ist");
        Messages.messageFile.addDefault("counter.pregameend.titel2", (String)"&cvorbei");
        Messages.messageFile.addDefault("counter.ingameend", (String)"&7Spiel ist vorbei!");
        Messages.messageFile.addDefault("command.noperms", (String)"&cDu hast keine Permissions");
        Messages.messageFile.addDefault("command.start", (String)"&aDu hast das Spiel gestartet");
        Messages.messageFile.addDefault("command.start2", (String)"&aDu hast die Zeit verkürzt");
        Messages.messageFile.addDefault("win.message", (String)"&7Team %TEAM% &7hat das Spiel gewonnen");
        Messages.messageFile.addDefault("win.titel1", (String)"&7Team %TEAM%");
        Messages.messageFile.addDefault("win.titel2", (String)"&7hat gewonnen");
        Messages.messageFile.addDefault("kit.1.name", (String)"&aStarter");
        Messages.messageFile.addDefault("kit.2.name", (String)"&aAssasine");
        Messages.messageFile.addDefault("kit.3.name", (String)"&aEnderman");
        Messages.messageFile.addDefault("kit.4.name", (String)"&aMiner");
        Messages.messageFile.addDefault("kit.5.name", (String)"&aTank");
        Messages.messageFile.addDefault("kit.6.name", (String)"&aSpongebob");
        Messages.messageFile.addDefault("kit.7.name", (String)"&aMLG");
        Messages.messageFile.addDefault("kit.8.name", (String)"&aFlammenwerfer");
        Messages.messageFile.addDefault("kit.9.name", (String)"&aGandalf");
        Messages.messageFile.addDefault("kit.10.name", (String)"&aSuppenMeister");
        Messages.messageFile.addDefault("kit.11.name", (String)"&aAntiTimolianer");
        Messages.messageFile.addDefault("kit.12.name", (String)"&aBedwarsSpieler");
        Messages.messageFile.addDefault("kit.13.name", (String)"&aAstronaut");
        Messages.messageFile.addDefault("kit.14.name", (String)"&aPiuAmore");
        Messages.messageFile.addDefault("kit.15.name", (String)"&aSchlechterSenser");
        Messages.messageFile.addDefault("kit.16.name", (String)"&aLink");
        Messages.messageFile.addDefault("kit.17.name", (String)"&aSpiderman");
        Messages.messageFile.addDefault("kit.18.name", (String)"&aBerzerker");
        Messages.messageFile.addDefault("kit.1.lore", (String)"&7Das Kit &aStarter &7startet-&7mit ein wenig Eisenequibment.");
        Messages.messageFile.addDefault("kit.2.lore", (String)"&7Das Kit &aAssasine &7bekommt-&7Diaschuhe mit Federfall Level 10-&7und einem Diaschwert mit Schärfe Level 2.");
        Messages.messageFile.addDefault("kit.3.lore", (String)"&7Das Kit &aEnderman &7beginnt-&7mit einer Enderperle");
        Messages.messageFile.addDefault("kit.4.lore", (String)"&7Das Kit &aMiner &7beginnt-&7mit einer SEHR guten Diamantspitzhacke.");
        Messages.messageFile.addDefault("kit.5.lore", (String)"&7Das Kit &aTank &7bekommt-&7eine Komplette Eisenrüstung mit-&7Schutz 2. Noch dazu eine-&7Feuerresistenz Tank");
        Messages.messageFile.addDefault("kit.6.lore", (String)"&7Das Kit &aSpongebob &7bekommt-&764 Schwämme, eine Braune Lederhose und-&7gelbe Lederbrustplatte und dazu einen-&7Jumpeffeckt Level 2");
        Messages.messageFile.addDefault("kit.7.lore", (String)"&7Das Kit &aMLG &7bekommt-&716 TNT, 8 Redstonefackeln,-&7einen Wassereimer und einen Lavaeimer");
        Messages.messageFile.addDefault("kit.8.lore", (String)"&7Mit dem Kit &aFlammenwerfer &7bekommst du-&7zu Beginn einen Raktenwerfer, ein Feuerzeug, Munition und TNT.");
        Messages.messageFile.addDefault("kit.9.lore", (String)"&7Dieses Kit bekommt beim Start-&7einen Zaubertisch und 32 XP Flaschen");
        Messages.messageFile.addDefault("kit.10.lore", (String)"&7Dieses Kit besitzt beim Start-&7 sehr viel Heal im Sinne von Suppen :^)");
        Messages.messageFile.addDefault("kit.11.lore", (String)"&7Dieses Kit wird wohl kaum ein 1v1 Schwitzer wählen...");
        Messages.messageFile.addDefault("kit.12.lore", (String)"&7Dieses Kit ist wohl nur für eingefleischte Bedwars Spieler und besitzt Vor- und Nachteile.");
        Messages.messageFile.addDefault("kit.13.lore", (String)"&7Ich heb ab, nichts hält mich am Boden...");
        Messages.messageFile.addDefault("kit.14.lore", (String)"&7Piu amore ist italienisch für &aMehr Liebe&a und gibt dir viele Herzen <3");
        Messages.messageFile.addDefault("kit.15.lore", (String)"&7Der Sensenmann ist nicht so gut wie auf Gomme, ihm ist wohl etwas &7&aschlecht&a&7 geworden.");
        Messages.messageFile.addDefault("kit.16.lore", (String)"&7Link will nun auch mit seinen &7&aBomben&a&7 in Skywars glänzen...&7");
        Messages.messageFile.addDefault("kit.17.lore", (String)"&7Spiderman besitzt eine einzigartige Fähigkeit, welche &aSpinneweben&a&7 betrifft.");
        Messages.messageFile.addDefault("kit.18.lore", (String)"&7Der Berzerker ist ein sehr starker Typ, der nach Kills von &aBlutdurst&a&7 durchdringt wird.");
        Messages.messageFile.addDefault("kit.choose", (String)"&7Du hast das Kit %KIT% &7ausgewählt");
        Messages.messageFile.addDefault("kit.error", (String)"&cDu besitzt das Kit %KIT% &cnicht");
        Messages.messageFile.addDefault("kit.buy.succ", (String)"&aDu hast dir das Kit gekauft, du musst es noch auswählen um damit zu Spielen");
        Messages.messageFile.addDefault("kit.buy.error", (String)"&cDu hast nicht genug Coins");
        Messages.messageFile.options().copyDefaults(true);
        try {
            Messages.messageFile.save(Messages.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getMessage(final String Pfad) {
        if (Messages.messageFile.contains(Pfad)) {
            return Messages.messageFile.getString(Pfad);
        }
        return null;
    }
    
    public static void setMessages() {
        Messages.prefix = getMessage("prefix").replaceAll("&", "§");
        Messages.p_join = getMessage("player.join").replaceAll("&", "§");
        Messages.p_leave = getMessage("player.leave").replaceAll("&", "§");
        Messages.p_death = getMessage("player.death").replaceAll("&", "§");
        Messages.p_deathbyplayer = getMessage("player.deathbyplayer").replaceAll("&", "§");
        Messages.sb_head = getMessage("scoreboard.head").replaceAll("&", "§");
        Messages.sb_red = getMessage("scoreboard.red").replaceAll("&", "§");
        Messages.sb_blue = getMessage("scoreboard.blue").replaceAll("&", "§");
        Messages.sb_yellow = getMessage("scoreboard.yellow").replaceAll("&", "§");
        Messages.sb_green = getMessage("scoreboard.green").replaceAll("&", "§");
        Messages.sb_black = getMessage("scoreboard.black").replaceAll("&", "§");
        Messages.sb_white = getMessage("scoreboard.white").replaceAll("&", "§");
        Messages.sb_purple = getMessage("scoreboard.purple").replaceAll("&", "§");
        Messages.sb_cyan = getMessage("scoreboard.cyan").replaceAll("&", "§");
        Messages.team_choose = getMessage("team.choose").replaceAll("&", "§");
        Messages.team_name_red = getMessage("team.name.red").replaceAll("&", "§");
        Messages.team_name_blue = getMessage("team.name.blue").replaceAll("&", "§");
        Messages.team_name_yellow = getMessage("team.name.yellow").replaceAll("&", "§");
        Messages.team_name_green = getMessage("team.name.green").replaceAll("&", "§");
        Messages.team_name_black = getMessage("team.name.black").replaceAll("&", "§");
        Messages.team_name_white = getMessage("team.name.white").replaceAll("&", "§");
        Messages.team_name_purple = getMessage("team.name.purple").replaceAll("&", "§");
        Messages.team_name_cyan = getMessage("team.name.cyan").replaceAll("&", "§");
        Messages.counter_lobby = getMessage("counter.lobby").replaceAll("&", "§");
        Messages.counter_count = getMessage("counter.count").replaceAll("&", "§");
        Messages.counter_pregame = getMessage("counter.pregame").replaceAll("&", "§");
        Messages.counter_ingame = getMessage("counter.ingame").replaceAll("&", "§");
        Messages.counter_restart = getMessage("counter.restart").replaceAll("&", "§");
        Messages.counter_countend = getMessage("counter.countend").replaceAll("&", "§");
        Messages.counter_ingameend = getMessage("counter.ingameend").replaceAll("&", "§");
        Messages.counter_pregameend = getMessage("counter.pregameend").replaceAll("&", "§");
        Messages.counter_pregameendT1 = getMessage("counter.pregameend.titel1").replaceAll("&", "§");
        Messages.counter_pregameendT2 = getMessage("counter.pregameend.titel2").replaceAll("&", "§");
        Messages.command_noperm = getMessage("command.noperms").replaceAll("&", "§");
        Messages.command_start = getMessage("command.start").replaceAll("&", "§");
        Messages.command_start2 = getMessage("command.start2").replaceAll("&", "§");
        Messages.win_message = getMessage("win.message").replaceAll("&", "§");
        Messages.win_titel1 = getMessage("win.titel1").replaceAll("&", "§");
        Messages.win_titel2 = getMessage("win.titel2").replaceAll("&", "§");
        Messages.kit_1_name = getMessage("kit.1.name").replaceAll("&", "§");
        Messages.kit_2_name = getMessage("kit.2.name").replaceAll("&", "§");
        Messages.kit_3_name = getMessage("kit.3.name").replaceAll("&", "§");
        Messages.kit_4_name = getMessage("kit.4.name").replaceAll("&", "§");
        Messages.kit_5_name = getMessage("kit.5.name").replaceAll("&", "§");
        Messages.kit_6_name = getMessage("kit.6.name").replaceAll("&", "§");
        Messages.kit_7_name = getMessage("kit.7.name").replaceAll("&", "§");
        Messages.kit_8_name = getMessage("kit.8.name").replaceAll("&", "§");
        Messages.kit_9_name = getMessage("kit.9.name").replaceAll("&", "§");
        Messages.kit_10_name = getMessage("kit.10.name").replaceAll("&", "§"); 
        Messages.kit_11_name = getMessage("kit.11.name").replaceAll("&", "§"); 
        Messages.kit_12_name = getMessage("kit.12.name").replaceAll("&", "§"); 
        Messages.kit_13_name = getMessage("kit.13.name").replaceAll("&", "§"); 
        Messages.kit_14_name = getMessage("kit.14.name").replaceAll("&", "§"); 
        Messages.kit_15_name = getMessage("kit.15.name").replaceAll("&", "§"); 
        Messages.kit_16_name = getMessage("kit.16.name").replaceAll("&", "§");
        Messages.kit_17_name = getMessage("kit.17.name").replaceAll("&", "§"); 
        Messages.kit_18_name = getMessage("kit.18.name").replaceAll("&", "§"); 
        Messages.kit_1_lore = getMessage("kit.1.lore").replaceAll("&", "§");
        Messages.kit_2_lore = getMessage("kit.2.lore").replaceAll("&", "§");
        Messages.kit_3_lore = getMessage("kit.3.lore").replaceAll("&", "§");
        Messages.kit_4_lore = getMessage("kit.4.lore").replaceAll("&", "§");
        Messages.kit_5_lore = getMessage("kit.5.lore").replaceAll("&", "§");
        Messages.kit_6_lore = getMessage("kit.6.lore").replaceAll("&", "§");
        Messages.kit_7_lore = getMessage("kit.7.lore").replaceAll("&", "§");
        Messages.kit_8_lore = getMessage("kit.8.lore").replaceAll("&", "§");
        Messages.kit_9_lore = getMessage("kit.9.lore").replaceAll("&", "§");
        Messages.kit_10_lore = getMessage("kit.10.lore").replaceAll("&", "§");
        Messages.kit_11_lore = getMessage("kit.11.lore").replaceAll("&", "§");
        Messages.kit_12_lore = getMessage("kit.12.lore").replaceAll("&", "§");
        Messages.kit_13_lore = getMessage("kit.13.lore").replaceAll("&", "§");
        Messages.kit_14_lore = getMessage("kit.14.lore").replaceAll("&", "§");
        Messages.kit_15_lore = getMessage("kit.15.lore").replaceAll("&", "§");
        Messages.kit_16_lore = getMessage("kit.16.lore").replaceAll("&", "§");
        Messages.kit_17_lore = getMessage("kit.17.lore").replaceAll("&", "§");
        Messages.kit_18_lore = getMessage("kit.18.lore").replaceAll("&", "§");
        Messages.kit_choose = getMessage("kit.choose").replaceAll("&", "§");
        Messages.kit_error = getMessage("kit.error").replaceAll("&", "§");
        Messages.kit_buy_succ = getMessage("kit.buy.succ").replaceAll("&", "§");
        Messages.kit_buy_error = getMessage("kit.buy.error").replaceAll("&", "§");
    }
}