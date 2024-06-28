package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import org.bukkit.ChatColor;

public class ColorAPI {
  public static String tMC(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }
}
