// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.chests;

import java.util.List;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;

public class ChestFile
{
    public static File file;
    public static FileConfiguration ChestFile;
    
    static {
        de.SkyWars.chests.ChestFile.file = new File("plugins/SkyWars", "Chest.yml");
        de.SkyWars.chests.ChestFile.ChestFile = (FileConfiguration)YamlConfiguration.loadConfiguration(de.SkyWars.chests.ChestFile.file);
    }

    
    public static void setDefaultConfig() {
        if (!de.SkyWars.chests.ChestFile.file.exists()) {
            de.SkyWars.chests.ChestFile.ChestFile.options().copyDefaults(true);
            de.SkyWars.chests.ChestFile.ChestFile.addDefault("MaxItemsInChest", (Object)10);
            de.SkyWars.chests.ChestFile.ChestFile.addDefault("MaxItemsInChest2", (Object)7);

            final List<String> values = (List<String>)de.SkyWars.chests.ChestFile.ChestFile.getStringList("items");
            values.add("268:0, 1, 10");
            values.add("272:0, 1, 5");
            values.add("267:0, 1, 4");
            values.add("257:0, 1, 4");
            values.add("258:0, 1, 4");
            values.add("298:0, 1, 5");
            values.add("1:0, 32, 10");
            values.add("3:0, 32, 10"); 
            values.add("5:0, 32, 10");
            values.add("5:5, 32, 12");
            values.add("306:0, 1, 4");
            values.add("307:0, 1, 4");
            values.add("264:0, 1, 4");
            values.add("264:0, 2, 2");
            values.add("264:0, 8, 1");
            values.add("311:0, 1, 5");
            values.add("322:0, 1, 1");
            values.add("314:0, 1, 5");
            values.add("301:0, 1, 6");
            values.add("309:0, 1, 3");
            values.add("300:0, 1, 1");
            values.add("368:0, 1, 4");
            values.add("30:0, 6, 1");
            values.add("302:0, 1, 7");
            values.add("304:0, 1, 7");
            values.add("265:0, 4, 7");
            values.add("265:0, 6, 3");
            values.add("318:0, 4, 10");
            values.add("318:0, 6, 7");
            values.add("412:0, 5, 10");
            values.add("412:0, 6, 7");
            values.add("412:0, 8, 6");
            values.add("320:0, 5, 10");
            values.add("320:0, 6, 7");
            values.add("320:0, 8, 6");
            values.add("326:0, 1, 8");
            values.add("306:0, 1, 9");
            values.add("307:0, 1, 7");
            values.add("308:0, 1, 7");
            values.add("309:0, 1, 8");
            values.add("98:0, 32, 8"); 
            values.add("335:0, 1, 1"); 
            final List<String> values2 = (List<String>)de.SkyWars.chests.ChestFile.ChestFile.getStringList("items2");
            values2.add("5:0, 32, 7");
            values2.add("5:0, 16, 10");
            values2.add("5:0, 12, 12");
            values2.add("278:0, 1, 6"); 
            values2.add("279:0, 1, 6"); 
            values2.add("264:0, 4, 4");
            values2.add("264:0, 2, 5");
            values2.add("264:0, 1, 7");
            values2.add("276:0, 1, 4");
            values2.add("322:0, 2, 2");
            values2.add("264:0, 1, 4");
            values2.add("326:0, 1, 4");
            values.add("306:0, 1, 7");
            values.add("307:0, 1, 6");
            values.add("308:0, 1, 6");
            values.add("309:0, 1, 7");
            values2.add("310:0, 1, 3");
            values2.add("311:0, 1, 3");
            values2.add("312:0, 1, 3");
            values2.add("313:0, 1, 3");
            values.add("320:0, 5, 10");
            values.add("368:0, 1, 6");
            values.add("412:0, 5, 10");
            values2.add("373:0, 3, 1");
            values2.add("373:0, 2, 2");
            values2.add("373:0, 1, 3");
            values2.add("344:0, 1, 7");
            values2.add("344:0, 3, 3");
            values2.add("344:0, 5, 1");
            values2.add("332:0, 1, 7");
            values2.add("332:0, 3, 3");
            values2.add("332:0, 5, 1");
            values2.add("320:0, 12, 4");
            values2.add("332:0, 6, 7");
            values2.add("332:0, 3, 10");
            de.SkyWars.chests.ChestFile.ChestFile.set("items", (Object)values);
            de.SkyWars.chests.ChestFile.ChestFile.set("items2", (Object)values2);

            try {
                de.SkyWars.chests.ChestFile.ChestFile.save(de.SkyWars.chests.ChestFile.file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
