// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import de.SkyWars.spawns.Methodes;
import de.SkyWars.gamestatus.StatusManager;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.EventHandler;
import de.SkyWars.utils.PlayerScoreboard;
import net.LikeAnOnwer.CoinAPI.mysql.CoinAPI;
import de.SkyWars.gamestatus.Restart;
import de.SkyWars.gamestatus.Pregame;
import de.SkyWars.gamestatus.Game;
import de.SkyWars.playerdata.Kits;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.Sound;

import de.SkyWars.mysql.MySQLKits;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.utils.Messages;
import de.SkyWars.utils.PlayerMessages;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.entity.Player;
import de.SkyWars.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;

public class PlayerDeath implements Listener {
	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		final Player p = e.getEntity().getPlayer();
		Bukkit.getScheduler().runTaskLater((Plugin) Main.getplugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				p.spigot().respawn();
			}
		}, 10L);
		e.setDeathMessage((String) null);
		if (e.getEntity().getKiller() instanceof Player) {
			
			final Player killer = e.getEntity().getKiller();
			PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix) + Messages.p_deathbyplayer
					.replaceAll("%PLAYER%", p.getDisplayName()).replaceAll("%KILLER%", killer.getDisplayName()));
			CoinAPI.addCoins(killer.getName(), 100);
			MySQLStats.addKills(killer.getUniqueId().toString(), 1);
		
			if(MySQLKits.getLastKit(killer.getUniqueId().toString()) == 14) {
				killer.setMaxHealth(p.getMaxHealth() + 2);
			}
			else if(MySQLKits.getLastKit(killer.getUniqueId().toString()) == 18) {
				killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 1)); 
			}
			
			killer.sendMessage(Messages.prefix + "§7+ §e100 §7Coins : + §e1 §7Kill");
			killer.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			
		} 
		 else {
			PlayerMessages.sendAllPlayers(String.valueOf(PlayerMessages.prefix)
					+ Messages.p_death.replaceAll("%PLAYER%", p.getDisplayName()));
		}
		PlayerTeams.removeTeam(p);
		if (PlayerTeams.checkWinnerTeam() != null && PlayerTeams.gameEnd) {
			Game.stopGame();
			Pregame.stopPreGame();
			Restart.startRestart();
		}
		for (final Player all : Bukkit.getOnlinePlayers()) {
			PlayerScoreboard.ingameBoard(all);
		}
		MySQLStats.addDeaths(p.getUniqueId().toString(), 1);
	}

	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		PlayerTeams.addSpectator(p);
		if (Main.Status == StatusManager.Restart) {
			Bukkit.getScheduler().runTaskLater((Plugin) Main.getplugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.teleport(Methodes.getLobby());
				}
			}, 10L);
		} else {
			Bukkit.getScheduler().runTaskLater((Plugin) Main.getplugin(), (Runnable) new Runnable() {
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
