// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.listener;

import org.bukkit.event.EventHandler;
import java.util.List;
import java.util.Iterator;
import org.bukkit.entity.Player;
import java.util.Random;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import de.SkyWars.chests.ChestFile;
import de.SkyWars.chests.ChestLevel;
import org.bukkit.Material;
import de.SkyWars.playerdata.PlayerTeams;
import de.SkyWars.gamestatus.StatusManager;
import de.SkyWars.main.Main;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;

public class BlockBreak implements Listener
{
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (Main.Status == StatusManager.Game || Main.Status == StatusManager.Pregame) {
            if (PlayerTeams.Spectator.contains(p)) {
                e.setCancelled(true);
            }
            if (e.getBlock().getType() == Material.CHEST) {
                if (!ChestLevel.sgchest.contains(e.getBlock().getLocation())) {
                    int l = ChestFile.ChestFile.getInt("MaxItemsInChest");
                    final ArrayList<String> list = new ArrayList<String>();
                    for (final String alls : ChestLevel.itemList1) {
                        list.add(alls);
                    }
                    final List<ItemStack> items = new ArrayList<ItemStack>();
                    final String remove = "";
                    for (final String all : list) {
                        int ID = 0;
                        int subID = 0;
                        int amount = 0;
                        int chance = 0;
                        if (all.contains(":")) {
                            final String[] array = all.split(":");
                            ID = Integer.valueOf(array[0]);
                            String a = array[1];
                            a = a.substring(0, 1);
                            subID = Integer.valueOf(a);
                        }
                        final String[] array = all.split(", ");
                        amount = Integer.valueOf(array[1]);
                        chance = Integer.valueOf(array[2]);
                        for (int i = 0; i < chance; ++i) {
                            items.add(new ItemStack(ID, amount, (short)subID));
                            list.remove(remove);
                        }
                    }
                    while (l != 0) {
                        --l;
                        final Random r2 = new Random();
                        final Random r3 = new Random();
                        final int n2 = r2.nextInt(26);
                        final int n3 = r3.nextInt(items.size());
                        e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), (ItemStack)items.get(n3));
                        final ItemStack ims = items.get(n3);
                        for (int j = 0; j != 10; ++j) {
                            if (items.contains(ims)) {
                                items.remove(ims);
                            }
                        }
                    }
                }
            }
            else if (e.getBlock().getType() == Material.TRAPPED_CHEST && !ChestLevel.sgchest.contains(e.getBlock().getLocation())) {
                int l = ChestFile.ChestFile.getInt("MaxItemsInChest2");
                final ArrayList<String> list = new ArrayList<String>();
                for (final String alls : ChestLevel.itemList2) {
                    list.add(alls);
                }
                final List<ItemStack> items = new ArrayList<ItemStack>();
                final String remove = "";
                for (final String all : list) {
                    int ID = 0;
                    int subID = 0;
                    int amount = 0;
                    int chance = 0;
                    if (all.contains(":")) {
                        final String[] array = all.split(":");
                        ID = Integer.valueOf(array[0]);
                        String a = array[1];
                        a = a.substring(0, 1);
                        subID = Integer.valueOf(a);
                    }
                    final String[] array = all.split(", ");
                    amount = Integer.valueOf(array[1]);
                    chance = Integer.valueOf(array[2]);
                    for (int i = 0; i < chance; ++i) {
                        items.add(new ItemStack(ID, amount, (short)subID));
                        list.remove(remove);
                    }
                }
                while (l != 0) {
                    --l;
                    final Random r2 = new Random();
                    final Random r3 = new Random();
                    final int n2 = r2.nextInt(26);
                    final int n3 = r3.nextInt(items.size());
                    e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), (ItemStack)items.get(n3));
                    final ItemStack ims = items.get(n3);
                    for (int j = 0; j != 10; ++j) {
                        if (items.contains(ims)) {
                            items.remove(ims);
                        }
                    }
                }
            }
        }
        else {
            e.setCancelled(true);
        }
    }
}
