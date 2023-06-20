// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.main;


import org.bukkit.plugin.PluginManager;
import de.SkyWars.listener.PlayerTeleport;
import de.SkyWars.listener.Soup;
import de.SkyWars.listener.SpiderMan;
import de.SkyWars.listener.PlayerMove;
import de.SkyWars.listener.PlayerQuit;
import de.SkyWars.listener.PlayerLogin;
import de.SkyWars.listener.PlayerFood;
import de.SkyWars.listener.PlayerInteract;
import de.SkyWars.listener.InventoryClick;
import de.SkyWars.listener.PlayerJoin;
import de.SkyWars.listener.PlayerKick;
import de.SkyWars.listener.PlayerDeath;
import de.SkyWars.listener.PlayerChat;
import de.SkyWars.listener.EntityDamage;
import de.SkyWars.listener.BlockPlace;
import de.SkyWars.listener.ArrowExplode;
import de.SkyWars.listener.BlockBreak;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

import de.SkyWars.listener.DropItem;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.SkyWars.command.Commands;
import de.SkyWars.gamestatus.Lobby;
import de.SkyWars.utils.MOTD;
import de.SkyWars.worldreset.LoadRandomMap;
import de.SkyWars.chests.ChestLevel;
import de.SkyWars.chests.ChestFile;
import de.SkyWars.mysql.MySQLStats;
import de.SkyWars.rezepte.RecipeLoader;
import de.SkyWars.mysql.MySQLFIle;
import de.SkyWars.worldreset.WRFile;
import de.SkyWars.utils.Messages;
import de.SkyWars.files.Config;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.mysql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;
import de.SkyWars.weapons.WeaponHandler;

public class Main extends JavaPlugin
{
	
	public static boolean starten = false; 
    public static Main plugin;
    public static MySQL mysql;
    public static StatusManager Status;
    
    static {
        Main.Status = StatusManager.Lobby;
    }
    
    public static Main getplugin() {
        return Main.plugin;
    }
    
    public void onEnable() {
        Main.plugin = this;
        Config.setDefaultConfig();
        Messages.setDefaultMessage();
        Messages.setMessages();
        WRFile.WorldReset();
        WRFile.createWorldResetFolder();
        WRFile.loadAllMaps();
        MySQLFIle.setDefaultMySQL();
        MySQLFIle.loadMySQLSettings();
        if (MySQLFIle.sql.getBoolean("MySQL")) {
            MySQLFIle.ConnectMySQL();
            MySQLStats.topPlayer();
        }
        ChestFile.setDefaultConfig();
        ChestLevel.setItems();
        new RecipeLoader().registerRezepte();
        LoadRandomMap.setRandomMap();
        MOTD.motdSetter();
        this.registerCommands();
        System.out.println("{Commands} wurden erfolgreich geladen!");
        this.registerListener();
        System.out.println("{Listener} wurden erfolgreich geladen!");
        Lobby.startLobby();
        System.out.println("[SkyWars] wurde erfolgreich geladen!");
        weatherClear();
        
    }
    
    public void onDisable() {
        WRFile.WorldReset();
    }
    
    private void registerCommands() {
        getplugin().getCommand("skywars").setExecutor((CommandExecutor)new Commands());
        getplugin().getCommand("start").setExecutor((CommandExecutor)new Commands());
        getplugin().getCommand("forcemap").setExecutor((CommandExecutor)new Commands());
        getplugin().getCommand("stats").setExecutor((CommandExecutor)new Commands());
        getplugin().getCommand("rank").setExecutor((CommandExecutor)new Commands());

        
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
    
    private void registerListener() {
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new DropItem(), (Plugin)this);
        pm.registerEvents((Listener)new BlockBreak(), (Plugin)this);
        pm.registerEvents((Listener)new BlockPlace(), (Plugin)this);
        pm.registerEvents((Listener)new EntityDamage(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerChat(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerDeath(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerJoin(), (Plugin)this);
        pm.registerEvents((Listener)new InventoryClick(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerInteract(this), (Plugin)this);
        pm.registerEvents((Listener)new ChestLevel(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerFood(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerLogin(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerQuit(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerMove(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerTeleport(), (Plugin)this);
        pm.registerEvents((Listener)new Soup(), (Plugin)this);
        pm.registerEvents((Listener)new WeaponHandler(this), (Plugin)this);
        pm.registerEvents((Listener)new PlayerKick(), (Plugin)this);
        pm.registerEvents((Listener)new ArrowExplode(this), (Plugin)this);
        pm.registerEvents((Listener)new SpiderMan(this), (Plugin)this);
    }
    @SuppressWarnings("deprecation")
	
    public void weatherClear() {
		final String command = "weather clear";
		int time = 30;
		time *= 20;
		Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "difficulty easy");
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask((Plugin) this, new Runnable() {
			public void run() {
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), command);
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "time set day");
			}
		}, 20L, time);

	}

   
}
