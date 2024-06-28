package cn.lemonnetwork.catpixellobby.LeaderBoard.utils;

import java.util.List;
import org.bukkit.ChatColor;

public class ColorUtil {
  public static String color(String s) {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
  
  public static List<String> color(List<String> lines) {
    lines.replaceAll(ColorUtil::color);
    return lines;
  }
}
