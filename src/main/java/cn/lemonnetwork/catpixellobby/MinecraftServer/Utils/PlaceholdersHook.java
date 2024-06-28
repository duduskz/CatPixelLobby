package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceholdersHook extends PlaceholderExpansion {
  public String onPlaceholderRequest(Player player, String params) {
    String result = null;
    if (params.equalsIgnoreCase("AchievementPoints"))
      result = String.format("%,d", new Object[] { Integer.valueOf(MySQL.getPlayerAchevement(player)) }); 
    if (params.equalsIgnoreCase("rewards"))
      result = String.format("%,d", new Object[] { Integer.valueOf(MySQL.getRewardNumber(player)) }); 
    return result;
  }

  public String getIdentifier() {
    return "catpixellobby";
  }

  public String getAuthor() {
    return "DaMao_OVO";
  }

  public String getVersion() {
    return "3.0";
  }
}
