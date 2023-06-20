// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;

public class DropItem implements Listener
{
    @EventHandler
    public void onItemDrop(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (Main.Status == StatusManager.Game || Main.Status == StatusManager.Pregame) {
            if (PlayerTeams.Spectator.contains(p)) {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onItemPickup(final PlayerPickupItemEvent e) {
        final Player p = e.getPlayer();
        if (Main.Status == StatusManager.Game || Main.Status == StatusManager.Pregame) {
            if (PlayerTeams.Spectator.contains(p)) {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }
    }
}
