// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.SkullType;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import de.SkyWars.playerdata.PlayerTeams;
import org.bukkit.Material;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class PlayerTeleport implements Listener
{
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) && (Main.Status == StatusManager.Pregame || Main.Status == StatusManager.Game) && e.getMaterial() == Material.COMPASS && PlayerTeams.Spectator.contains(p)) {
            final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Teleportieren");
            for (final Player all : Bukkit.getOnlinePlayers()) {
                if (!PlayerTeams.Spectator.contains(all)) {
                    inv.addItem(new ItemStack[] { skull(all) });
                }
            }
            p.openInventory(inv);
        }
    }
    
    public static ItemStack skull(final Player name) {
        final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        final SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name.getName());
        meta.setDisplayName(name.getDisplayName());
        skull.setItemMeta((ItemMeta)meta);
        return skull;
    }
    
    public static void giveTeleporter(final Player name) {
        final ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        final SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name.getName());
        meta.setDisplayName("§aTeleporter §7§o<Rechtsklick>");
        skull.setItemMeta((ItemMeta)meta);
        name.getInventory().setItem(0, skull);
        final ItemStack Hub = new ItemStack(Material.SLIME_BALL);
        final ItemMeta HubMeta = Hub.getItemMeta();
        HubMeta.setDisplayName("§cZurück zur Lobby §7§o<Rechtsklick>");
        Hub.setItemMeta(HubMeta);
        name.getInventory().setItem(8, Hub);
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("Teleportieren") && e.getSlot() == e.getRawSlot() && e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
            final ItemStack im = e.getCurrentItem();
            final SkullMeta meta = (SkullMeta)im.getItemMeta();
            final String owner = meta.getOwner();
            final Player player_ = Bukkit.getPlayerExact(owner);
            if (player_ != null) {
                p.teleport(player_.getLocation());
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}
