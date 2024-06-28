package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLightning;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TitleUtils {
  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
    sendTitle(player, fadeIn, stay, fadeOut, message, null);
  }
  
  public static void sendSubtitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
    sendTitle(player, fadeIn, stay, fadeOut, null, message);
  }
  
  public static void sendFullTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
    sendTitle(player, fadeIn, stay, fadeOut, title, subtitle);
  }
  
  public static void sendPacket(Player player, Object packet) {
    try {
      Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
      Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
      playerConnection.getClass()
        .getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static Class<?> getNMSClass(String name) {
    String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
      return Class.forName("net.minecraft.server." + version + "." + name);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } 
  }

  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
    try {
      if (title != null) {
        Object e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
        Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");
        Constructor subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
        Object titlePacket = subtitleConstructor.newInstance(e, chatTitle, fadeIn, stay, fadeOut);
        sendPacket(player, titlePacket);
        e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
        chatTitle = getNMSClass(
                "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");
        subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"));
        titlePacket = subtitleConstructor.newInstance(e, chatTitle);
        sendPacket(player, titlePacket);
      }
      if (subtitle != null) {
        Object e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
        Object chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + title + "\"}");
        Constructor subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
        Object subtitlePacket = subtitleConstructor.newInstance(e, chatSubtitle, fadeIn, stay, fadeOut);
        sendPacket(player, subtitlePacket);
        e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
        chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + subtitle + "\"}");
        subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
        subtitlePacket = subtitleConstructor.newInstance(e, chatSubtitle, fadeIn, stay, fadeOut);
        sendPacket(player, subtitlePacket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void clearTitle(Player player) {
    sendTitle(player, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "");
  }
  

  
  public static void playFakeLightning(Player sender, boolean silent) {
    WorldServer worldServer = ((CraftWorld)sender.getLocation().getWorld()).getHandle();
    PacketPlayOutSpawnEntityWeather packetPlayOutSpawnEntityWeather = new PacketPlayOutSpawnEntityWeather((Entity)new EntityLightning((World)worldServer, sender.getLocation().getX(), sender.getLocation().getY(), sender.getLocation().getZ()));
    (((CraftPlayer)sender).getHandle()).playerConnection.sendPacket((Packet)packetPlayOutSpawnEntityWeather);
    if (!silent)
      sender.getLocation().getWorld().playSound(sender.getLocation(), Sound.AMBIENCE_THUNDER, 100.0F, 0.0F); 
  }
  
  public static void playFakeLightning(Player sender) {
    playFakeLightning(sender, true);
  }
}
