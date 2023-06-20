// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.worldreset;

import java.util.Random;

public class LoadRandomMap
{
    public static String map;
    
    public static void setRandomMap() {
        WRFile.loadAllMaps();
        if (WRFile.loadWorlds.size() != 0) {
            final String rMap = LoadRandomMap.map = WRFile.loadWorlds.get(new Random().nextInt(WRFile.loadWorlds.size()));
        }
    }
}
