// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.entity.Player;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

public class EntityDamage implements Listener
{
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {
        if (Main.Status == StatusManager.Game) {
            if (e.getEntity() instanceof Player && PlayerTeams.Spectator.contains(e.getEntity())) {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player damager = (Player)e.getDamager();
            if (PlayerTeams.Spectator.contains(damager)) {
                e.setCancelled(true);
            }
        }
    }
}
