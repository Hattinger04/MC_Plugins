// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.utils;

import de.SkyWars.files.Config;
import de.SkyWars.playerdata.PlayerTeams;
import java.util.ArrayList;
import de.SkyWars.mysql.MySQLKits;
import java.util.List;
import org.bukkit.inventory.Inventory;
import de.SkyWars.playerdata.Kits;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

public class PlayerInventorys
{
	
	final static ItemStack item = new ItemStack(Material.WOOL);
    
	public static void clearPlayerInv(final Player p) {
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
    }
    
    public static void LobbyItems(final Player p) {
        clearPlayerInv(p);
       
        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§aWähle dein Team");
        item.setItemMeta(itemMeta);
        final ItemStack item2 = new ItemStack(Material.CHEST);
        final ItemMeta itemMeta2 = item2.getItemMeta();
        itemMeta2.setDisplayName("§aWähle dein Kit");
        item2.setItemMeta(itemMeta2);
        final ItemStack item3 = new ItemStack(Material.EMERALD);
        final ItemMeta itemMeta3 = item3.getItemMeta();
        itemMeta3.setDisplayName("§eTop 5");
        item3.setItemMeta(itemMeta3);
        p.getInventory().setItem(0, item);
        p.getInventory().setItem(1, item2);
        p.getInventory().setItem(8, item3);
    }
    
    public static void SpectatorItems(final Player p) {
        clearPlayerInv(p);
        final ItemStack item = new ItemStack(Material.COMPASS);
        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§aTeleporter");
        item.setItemMeta(itemMeta);
        p.getInventory().setItem(4, item);
    }
    
    public static void ChooseKit(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9*2, "§aWähle dein Kit");
        inv.setItem(0, itemBuilder(Kits.Starter));
        inv.setItem(1, itemBuilder(Kits.Tank));
        inv.setItem(2, itemBuilder(Kits.Assasine));
        inv.setItem(3, itemBuilder(Kits.Miner));
        inv.setItem(4, itemBuilder(Kits.Enderman));
        inv.setItem(5, itemBuilder(Kits.Gandalf));
        inv.setItem(6, itemBuilder(Kits.Spongebob));
        inv.setItem(7, itemBuilder(Kits.Gumpi));
        inv.setItem(8, itemBuilder(Kits.Mlg));
        inv.setItem(9, itemBuilder(Kits.SuppenMeister));
        inv.setItem(10, itemBuilder(Kits.AntiTimolianer));
        inv.setItem(11, itemBuilder(Kits.BedwarsSpieler));
        inv.setItem(12, itemBuilder(Kits.Astronaut));
        inv.setItem(13, itemBuilder(Kits.PiùAmore));
        inv.setItem(14, itemBuilder(Kits.SchlechterSenser));
        inv.setItem(15, itemBuilder(Kits.Link));
        inv.setItem(16, itemBuilder(Kits.SpiderMan));
        inv.setItem(17, itemBuilder(Kits.Berzerker));
        p.openInventory(inv);
    }
    
    public static ItemStack itemBuilder(final Kits k) {
        final ItemStack item = new ItemStack(k.getMaterial());
        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore((List<String>)k.getLore());
        itemMeta.setDisplayName(k.getName());
        item.setItemMeta(itemMeta);
        return item;
    }

    public static void openBuyInventory(final Player p, final Kits kit) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§aKit Kaufen");
        inv.setItem(0, itemBuilder(kit));
        final ItemStack item = new ItemStack(Material.WOOD_DOOR);
        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§cZurück zur Auswahl");
        item.setItemMeta(itemMeta);
        if (!MySQLKits.getKit(p.getUniqueId().toString(), "K" + kit.getID())) {
            final ItemStack item2 = new ItemStack(Material.EMERALD);
            final ItemMeta itemMeta2 = item.getItemMeta();
            itemMeta2.setDisplayName("§7Kit Kaufen für §e" + kit.getPreis() + " §7Coins");
            final ArrayList<String> lore = new ArrayList<String>();
            lore.add("ID:" + kit.getID());
            lore.add("Preis:" + kit.getPreis());
            itemMeta2.setLore((List<String>)lore);
            item2.setItemMeta(itemMeta2);
            inv.setItem(4, new ItemStack(item2));
        }
        inv.setItem(8, new ItemStack(item));
        p.openInventory(inv);
    }
    
    public static void ChooseTeam(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§aWähle dein Team");
        final List<String> Rot = new ArrayList<String>();
        final List<String> Gelb = new ArrayList<String>();
        final List<String> Grün = new ArrayList<String>();
        final List<String> Blau = new ArrayList<String>();
        final List<String> Lila = new ArrayList<String>();
        final List<String> Weiß = new ArrayList<String>();
        final List<String> Schwarz = new ArrayList<String>();
        final List<String> Türkis = new ArrayList<String>();
        final ItemStack item = new ItemStack(Material.WOOL, 1, (short)13);

        
        for (final Player all : PlayerTeams.Rot) {
            Rot.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Gelb) {
            Gelb.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Grün) {
        	Grün.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Blau) {
        	Blau.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Lila) {
        	Lila.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Weiß) {
        	Weiß.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Schwarz) {
        	Schwarz.add("§7- " + all.getName());
        }
        for (final Player all : PlayerTeams.Türkis) {
        	Türkis.add("§7- " + all.getName());
        }
        final ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore((List<String>)Grün);
        itemMeta.setDisplayName("§aGrün");
        item.setItemMeta(itemMeta);
        final ItemStack item2 = new ItemStack(Material.WOOL, 1, (short)11);
        final ItemMeta itemMeta2 = item2.getItemMeta();
        itemMeta2.setLore((List<String>)Blau);
        itemMeta2.setDisplayName("§1Blau");
        item2.setItemMeta(itemMeta2);
        final ItemStack item3 = new ItemStack(Material.WOOL, 1, (short)4);
        final ItemMeta itemMeta3 = item3.getItemMeta();
        itemMeta3.setLore((List<String>)Gelb);
        itemMeta3.setDisplayName("§eGelb");
        item3.setItemMeta(itemMeta3);
        final ItemStack item4 = new ItemStack(Material.WOOL, 1, (short)14);
        final ItemMeta itemMeta4 = item4.getItemMeta();
        itemMeta4.setLore((List<String>)Rot);
        itemMeta4.setDisplayName("§cRot");
        item4.setItemMeta(itemMeta4);
        final ItemStack item5 = new ItemStack(Material.WOOL, 1, (short)9);
        final ItemMeta itemMeta5 = item5.getItemMeta();
        itemMeta5.setLore((List<String>)T\u00fcrkis);
        itemMeta5.setDisplayName("§3Türkis");
        item5.setItemMeta(itemMeta5);
        final ItemStack item6 = new ItemStack(Material.WOOL, 1, (short)10);
        final ItemMeta itemMeta6 = item6.getItemMeta();
        itemMeta6.setLore((List<String>)Lila);
        itemMeta6.setDisplayName("§5Lila");
        item6.setItemMeta(itemMeta6);
        final ItemStack item7 = new ItemStack(Material.WOOL, 1, (short)0);
        final ItemMeta itemMeta7 = item7.getItemMeta();
        itemMeta7.setLore((List<String>)Wei\u00df);
        itemMeta7.setDisplayName("§fWeiß");
        item7.setItemMeta(itemMeta7);
        final ItemStack item8 = new ItemStack(Material.WOOL, 1, (short)15);
        final ItemMeta itemMeta8 = item8.getItemMeta();
        itemMeta8.setLore((List<String>)Schwarz);
        itemMeta8.setDisplayName("§0Schwarz");
        item8.setItemMeta(itemMeta8);
        
        if (Config.getTeams() == 2) {
            inv.setItem(3, item2);
            inv.setItem(5, item4);
        }
        if (Config.getTeams() == 4) {
            inv.setItem(2, item);
            inv.setItem(3, item2);
            inv.setItem(5, item3);
            inv.setItem(6, item4);
        }
        if (Config.getTeams() == 8) {
            inv.setItem(0, item);
            inv.setItem(1, item2);
            inv.setItem(2, item3);
            inv.setItem(3, item4);
            inv.setItem(5, item5);
            inv.setItem(6, item6);
            inv.setItem(7, item7);
            inv.setItem(8, item8);
        }
        p.openInventory(inv);
    }
}
