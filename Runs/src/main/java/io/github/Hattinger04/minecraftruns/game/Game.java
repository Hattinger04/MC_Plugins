/**
 * @author Hattinger04
 */
package io.github.Hattinger04.minecraftruns.game;

import org.bukkit.event.Listener;

import io.github.Hattinger04.minecraftruns.MessageTemplate;
import io.github.Hattinger04.minecraftruns.MinecraftRuns;

public abstract class Game implements Listener {

	public String name;
	public final MinecraftRuns plugin;
	public final String changingGame = "Spielmodus wurde geändert: \nAktiver Spielmodus: " + name;
	public final String stoppingGame = "Spielmodus " + name + " wurde gestoppt!";

	public Game(MinecraftRuns plugin) {
		this.plugin = plugin;
		name = "";
	}

	public Game(MinecraftRuns plugin, String name) {
		this(plugin);
		this.name = name;
	}

	public void start() {
		MessageTemplate.sendMessageToAllPlayer(changingGame);
		registerEvent();
	}

	public void stop() {
		MessageTemplate.sendMessageToAllPlayer(stoppingGame);
		unregisterEvent();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void registerEvent() {
		plugin.registerEvent(this);
	}

	public void unregisterEvent() {
		plugin.unregisterEvent(this);
	}
}