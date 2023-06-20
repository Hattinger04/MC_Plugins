// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import de.SkyWars.files.Config;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.Listener;

public class PlayerLogin implements Listener
{
    @EventHandler
    public void onSpecJoin(final PlayerLoginEvent e) {
        if ((Main.Status == StatusManager.Pregame || Main.Status == StatusManager.Game) && Config.allowSpectator()) {
            e.allow();
        }
    }
}
