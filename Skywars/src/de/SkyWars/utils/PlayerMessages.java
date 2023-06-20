// 
// Decompiled by Procyon v0.5.36
// 

package de.SkyWars.utils;

import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.Sound;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class PlayerMessages
{
    public static String prefix;
    
    static {
        PlayerMessages.prefix = Messages.prefix;
    }
    
    public static void sendAllPlayers(final String message) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(message);
        }
    }
    
    public static void sendAllSound(final Sound sound) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.playSound(all.getLocation(), sound, 1.0f, 1.0f);
        }
    }
    
    public static void sendAllTitel(final int fadeIn, final int stay, final int fadeOut, final String title, final String subtitle) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            sendPlayerTitle(all, fadeIn, stay, fadeOut, title, subtitle);
        }
    }
    
    public static void sendPlayerTitle(final Player player, final int fadeIn, final int stay, final int fadeOut, final String title, final String subtitle) {
        final PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        final PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, (IChatBaseComponent)null, fadeIn, stay, fadeOut);
        connection.sendPacket((Packet)packetPlayOutTimes);
        final IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        final PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
        connection.sendPacket((Packet)packetPlayOutSubTitle);
        final IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        final PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
        connection.sendPacket((Packet)packetPlayOutTitle);
    }
}
