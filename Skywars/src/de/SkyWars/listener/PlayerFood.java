// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.entity.Player;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.Listener;

public class PlayerFood implements Listener
{
    @EventHandler
    public void onFoodLevel(final FoodLevelChangeEvent e) {
        if (Main.Status == StatusManager.Game) {
            if (e.getEntity() instanceof Player) {
                final Player p = (Player)e.getEntity();
                if (PlayerTeams.Spectator.contains(p)) {
                    e.setFoodLevel(20);
                }
            }
        }
        else {
            e.setFoodLevel(20);
        }
    }
}
