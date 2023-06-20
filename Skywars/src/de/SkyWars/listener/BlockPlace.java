// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import de.SkyWars.chests.ChestLevel;
import org.bukkit.Material;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.Listener;

public class BlockPlace implements Listener
{
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (Main.Status == StatusManager.Game || Main.Status == StatusManager.Pregame) {
            if (PlayerTeams.Spectator.contains(p)) {
                e.setCancelled(true);
            }
            if (e.getBlock().getType() == Material.CHEST) {
                ChestLevel.sgchest.add(e.getBlock().getLocation());
            }
        }
        else {
            e.setCancelled(true);
        }
    }
}
