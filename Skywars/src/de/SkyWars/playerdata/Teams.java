// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.playerdata;

import de.SkyWars.utils.Messages;

public enum Teams
{
    Rot("Rot", 0, Messages.team_name_red), 
    Gelb("Gelb", 1, Messages.team_name_yellow), 
    Gr\u00fcn("Gr\u00fcn", 2, Messages.team_name_green), 
    Blau("Blau", 3, Messages.team_name_blue), 
    Schwarz("Schwarz", 4, Messages.team_name_black), 
    Wei\u00df("Wei\u00df", 5, Messages.team_name_white), 
    T\u00fcrkis("T\u00fcrkis", 6, Messages.team_name_cyan), 
    Lila("Lila", 7, Messages.team_name_purple);
    
    String name;
    
    private Teams(final String name2, final int ordinal, final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
