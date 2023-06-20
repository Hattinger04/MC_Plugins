// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.playerdata;

import java.util.ArrayList;
import java.util.List;
import de.SkyWars.utils.Messages;
import org.bukkit.Material;

public enum Kits
{
    Starter("Starter", 0, Messages.kit_1_name, Messages.kit_1_lore, 1, Material.IRON_SWORD, 0), 
    Assasine("Assasine", 1, Messages.kit_2_name, Messages.kit_2_lore, 2, Material.DIAMOND_BOOTS, 35000), 
    Enderman("Enderman", 2, Messages.kit_3_name, Messages.kit_3_lore, 3, Material.ENDER_PEARL, 20000), 
    Miner("Miner", 3, Messages.kit_4_name, Messages.kit_4_lore, 4, Material.DIAMOND_PICKAXE, 15000), 
    Tank("Tank", 4, Messages.kit_5_name, Messages.kit_5_lore, 5, Material.IRON_CHESTPLATE, 30000), 
    Spongebob("Spongebob", 5, Messages.kit_6_name, Messages.kit_6_lore, 7, Material.SPONGE, 8000), 
    Mlg("Mlg", 6, Messages.kit_7_name, Messages.kit_7_lore, 8, Material.TNT, 3500), 
    Gumpi("Gumpi", 7, Messages.kit_8_name, Messages.kit_8_lore, 9, Material.BLAZE_ROD, 40000), 
    Gandalf("Gandalf", 8, Messages.kit_9_name, Messages.kit_9_lore, 6, Material.ENCHANTMENT_TABLE, 32500),
    SuppenMeister("SuppenMeister", 9, Messages.kit_10_name, Messages.kit_10_lore, 10, Material.MUSHROOM_SOUP, 50000),
	AntiTimolianer("AnitTimolianer", 10 , Messages.kit_11_name, Messages.kit_11_lore, 11, Material.FISHING_ROD, 25000),
	BedwarsSpieler("BedwarsSpieler", 11, Messages.kit_12_name, Messages.kit_12_lore, 12, Material.STICK, 30000), 
	Astronaut("Astronaut", 12, Messages.kit_13_name, Messages.kit_13_lore, 13, Material.FIREWORK, 40000), 
	PiùAmore("PiuAmore", 13, Messages.kit_14_name, Messages.kit_14_lore, 14, Material.APPLE, 5000),
	SchlechterSenser("SchlechterSenser",14 , Messages.kit_15_name, Messages.kit_15_lore, 15, Material.IRON_HOE, 10000),
	Link("Link", 15, Messages.kit_16_name, Messages.kit_16_lore, 16, Material.BOW, 35000), 
	SpiderMan("Spiderman", 16, Messages.kit_17_name, Messages.kit_17_lore, 17, Material.WEB, 20000),
	Berzerker("Berzerker", 17, Messages.kit_18_name, Messages.kit_18_lore, 18, Material.WOOD_AXE, 25000); 

	
    String name;
    String lore;
    int Id;
    Material m;
    int Preis;
    
    private Kits(final String name2, final int ordinal, final String name, final String lore, final int Id, final Material m, final int Preis) {
        this.name = name;
        this.lore = lore;
        this.Id = Id;
        this.m = m;
        this.Preis = Preis;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<String> getLore() {
        final List<String> array = new ArrayList<String>();
        final String[] lores = this.lore.toString().split("-");
        String[] array2;
        for (int length = (array2 = lores).length, i = 0; i < length; ++i) {
            final String l = array2[i];
            array.add(l);
        }
        return array;
    }
    
    public Integer getID() {
        return this.Id;
    }
    
    public Material getMaterial() {
        return this.m;
    }
    
    public Integer getPreis() {
        return this.Preis;
    }
}
