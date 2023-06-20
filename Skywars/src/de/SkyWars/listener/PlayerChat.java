// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;

import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import de.SkyWars.utils.PlayerScoreboard;

import org.bukkit.entity.Player;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.Listener;

@SuppressWarnings("deprecation")
public class PlayerChat implements Listener
{
    @EventHandler
    public void onChat(final PlayerChatEvent e) {
        e.setCancelled(true);
        final Player p = e.getPlayer();
        if (Main.Status == StatusManager.Game || Main.Status == StatusManager.Pregame) {
            if (PlayerTeams.Spectator.contains(p)) {
                for (final Player all : PlayerTeams.Spectator) {
                    all.sendMessage(Messages.prefix + " " + p.getDisplayName() + "§7: " + e.getMessage());
                }
                return;
            }
            if (e.getMessage().startsWith("@all")) {
                PlayerMessages.sendAllPlayers("§7@all: " + p.getDisplayName() + "§7: " + e.getMessage().replaceAll("@all", ""));
            }
            else {
                if (PlayerTeams.Rot.contains(p)) {
                    for (final Player all : PlayerTeams.Rot) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Blau.contains(p)) {
                    for (final Player all : PlayerTeams.Blau) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Gelb.contains(p)) {
                    for (final Player all : PlayerTeams.Gelb) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Grün.contains(p)) {
                    for (final Player all : PlayerTeams.Grün) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Weiß.contains(p)) {
                    for (final Player all : PlayerTeams.Weiß) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " + p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Schwarz.contains(p)) {
                    for (final Player all : PlayerTeams.Schwarz) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Lila.contains(p)) {
                    for (final Player all : PlayerTeams.Lila) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
                if (PlayerTeams.Türkis.contains(p)) {
                    for (final Player all : PlayerTeams.Türkis) {
                        all.sendMessage(String.valueOf(Messages.prefix +  " " +p.getDisplayName()) + "§7: " + e.getMessage());
                    }
                }
            }
        }
        else {
            PlayerMessages.sendAllPlayers(String.valueOf(Messages.prefix +  " " + p.getDisplayName()) + "§7: " + e.getMessage());
        }
    }
}
