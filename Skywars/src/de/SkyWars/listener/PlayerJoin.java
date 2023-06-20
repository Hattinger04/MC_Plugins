// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;

import java.util.ArrayList;
import java.util.Iterator;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.plugin.Plugin;
import de.SkyWars.utils.PlayerInventorys;
import de.SkyWars.spawns.Methodes;
import org.bukkit.entity.Player;
import de.SkyWars.gamestatus.Counter;
import de.SkyWars.gamestatus.Lobby;
import org.bukkit.Bukkit;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerScoreboard;
import de.SkyWars.gamestatus.StatusManager;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import de.SkyWars.main.Main;
import de.SkyWars.mysql.MySQL;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.files.Config;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class PlayerJoin implements Listener
{
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        p.setHealth(p.getMaxHealth());
        p.setFoodLevel(20);
        p.removePotionEffect(PotionEffectType.JUMP);

        if (Main.Status == StatusManager.Lobby || Main.Status == StatusManager.Counter) {
            PlayerScoreboard.setBoard(p);
        	int wert = Config.getPlayerInTeam() * Config.getTeams(); 
            e.setJoinMessage(Messages.prefix + "§a>>§3 "+ p.getDisplayName() +"§f hat das Spiel §abetreten§f. (§3"+ Bukkit.getOnlinePlayers().size() +" §f/§3 "+ wert + "§f)");
            if (Main.Status == StatusManager.Lobby && Bukkit.getOnlinePlayers().size() == Config.getPlayerToStart()) {
                Lobby.stopLobby();
                Counter.startCounter();
            }
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getplugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                	MySQLStats.addCoins(p.getUniqueId().toString(), 5000);
                    p.teleport(Methodes.getLobby());
                    PlayerInventorys.LobbyItems(p);
                    ArrayList<PotionEffect> potions = new ArrayList<PotionEffect>(); 
                   	potions.addAll(p.getActivePotionEffects());
                   	for(PotionEffect effect : potions) {
                   		p.removePotionEffect(effect.getType());
                   	}
                }
            }, 10L);
        }
        else {
            e.setJoinMessage((String)null);
            PlayerScoreboard.ingameBoard(p);
            PlayerTeams.addSpectator(p);
            PlayerInventorys.clearPlayerInv(p);
            PlayerInventorys.SpectatorItems(p);
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getplugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.teleport(Methodes.getSpectator());
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(p);
                    }
                }
            }, 10L);
        }
    }
}
