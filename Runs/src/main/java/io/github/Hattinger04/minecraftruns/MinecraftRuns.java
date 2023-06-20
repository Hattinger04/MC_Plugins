/**
 * @author Hattinger04
 */
package io.github.Hattinger04.minecraftruns;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.Hattinger04.minecraftruns.commands.Commands;
import io.github.Hattinger04.minecraftruns.game.Game;


public class MinecraftRuns extends JavaPlugin {
	public static MinecraftRuns plugin;
	private static Game game; 
	final PluginManager pm = Bukkit.getPluginManager();

	public static MinecraftRuns getplugin() {
		return MinecraftRuns.plugin;
	}

	@Override
	public void onEnable() {
		getLogger().info("Plugin is now enabled!");
//		MySQLFIle.setDefaultMySQL();
//        MySQLFIle.loadMySQLSettings();
//        if (MySQLFIle.sql.getBoolean("MySQL")) {
//            MySQLFIle.ConnectMySQL();
//        }
//		getLogger().info("Connection to database has been successful!");
		this.registerCommands();
		getLogger().info("Commands are successfully implemented!");
		this.registerEvents();
		getLogger().info("Events are successfully implemented!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Plugin is now disabled!");
	}

	private void registerCommands() {
		this.getCommand("help").setExecutor(new Commands(this));
		this.getCommand("gamerun").setExecutor(new Commands(this));

	}

	public boolean registerEvent(Listener event) {
		if(event != null) {
			pm.registerEvents(event, (Plugin) this);
			MinecraftRuns.game = (Game) event; 
			return true; 
		} 
		return false; 
	}
	
	public boolean unregisterEvent(Listener event) {
		if(event != null) {
			HandlerList.unregisterAll(event); // Not tested
			MinecraftRuns.game = null; 
			return true; 
		} 
		return false; 
	}
	
	public static Game getGame() {
		return game;
	}
	
	private void registerEvents() {

	}

	
}
