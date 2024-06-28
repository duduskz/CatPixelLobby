package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ColorUtil {
  public static String color(String s) {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
  
  public static List<String> color(List<String> lines) {
    lines.replaceAll(ColorUtil::color);
    return lines;
  }
  
  public static void sendMessage(Player player, String message) {
    player.sendMessage(color(message));
  }
  
  public void sendMessage(Player player, List<String> messages) {
    messages.forEach(message -> sendMessage(player, message));
  }
  
  public void sendMessage(List<Player> players, List<String> messages) {
    players.forEach(player -> sendMessage(player, messages));
  }
}
