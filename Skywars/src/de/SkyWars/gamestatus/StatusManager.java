// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.gamestatus;

public enum StatusManager
{
    Lobby("Lobby", 0), 
    Counter("Counter", 1), 
    Pregame("Pregame", 2), 
    Game("Game", 3), 
    Restart("Restart", 4);
    
    private StatusManager(final String name, final int ordinal) {
    }
}
