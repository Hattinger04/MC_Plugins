// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.util.Vector;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class PlayerMove implements Listener
{
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (PlayerTeams.Spectator.contains(p)) {
            for (final Entity ent : p.getNearbyEntities(3.0, 3.0, 3.0)) {
                if (ent instanceof Player) {
                    final Player target = (Player)ent;
                    if (PlayerTeams.Spectator.contains(target)) {
                        continue;
                    }
                    final double ax = p.getLocation().getX();
                    final double ay = p.getLocation().getY();
                    final double az = p.getLocation().getZ();
                    final double bx = target.getLocation().getX();
                    final double by = target.getLocation().getY();
                    final double bz = target.getLocation().getZ();
                    final double x = ax - bx;
                    final double y = ay - by;
                    final double z = az - bz;
                    final Vector v = new Vector(x, y, z).normalize().multiply(1.0).setY(0.3);
                    p.setVelocity(v);
                }
            }
        }
    }
}
