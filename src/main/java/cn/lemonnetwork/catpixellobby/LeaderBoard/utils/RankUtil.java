package cn.lemonnetwork.catpixellobby.LeaderBoard.utils;

import java.util.UUID;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RankUtil {
  public static String getPlayerRank(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    return user.getCachedData().getMetaData().getPrefix();
  }
  
  public static String getPlayerRank(UUID uuid) {
    User user = LuckPermsProvider.get().getUserManager().getUser(uuid);
    return user.getCachedData().getMetaData().getPrefix();
  }
  
  public static String getPlayerSuffix(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    return user.getCachedData().getMetaData().getSuffix();
  }
  
  public static String getPlayerSuffix(UUID uuid) {
    User user = LuckPermsProvider.get().getUserManager().getUser(uuid);
    return user.getCachedData().getMetaData().getSuffix();
  }
  
  public static String getPlayerRankColor(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    return user.getCachedData().getMetaData().getPrefix().substring(0, 2);
  }
  
  public static String getPlayerRankColor(UUID uuid) {
    User user = LuckPermsProvider.get().getUserManager().getUser(uuid);
    return user.getCachedData().getMetaData().getPrefix().substring(0, 2);
  }
  
  public static String getPlayerName(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    return name;
  }
  
  public static String getPlayerColoredName(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    String prefix = user.getCachedData().getMetaData().getPrefix();
    if (prefix != null && 
      "&7".equalsIgnoreCase(prefix))
      return prefix + prefix; 
    return prefix + " " + prefix;
  }
  
  public static String getPlayerColoredName(UUID uuid) {
    User user = LuckPermsProvider.get().getUserManager().getUser(uuid);
    String prefix = user.getCachedData().getMetaData().getPrefix();
    if (prefix != null && 
      "&7".equalsIgnoreCase(prefix))
      return prefix + prefix; 
    return prefix + " " + prefix;
  }
  
  public static String getPlayerRealColoredName(String name) {
    User user = LuckPermsProvider.get().getUserManager().getUser(Bukkit.getPlayer(name).getUniqueId());
    return user.getCachedData().getMetaData().getPrefix() + " " + user.getCachedData().getMetaData().getPrefix();
  }
  
  public static String getPlayerRealColoredName(UUID uuid) {
    User user = LuckPermsProvider.get().getUserManager().getUser(uuid);
    return user.getCachedData().getMetaData().getPrefix() + " " + user.getCachedData().getMetaData().getPrefix();
  }
  
  public static boolean isPlayerNicked(UUID uuid) {
    return getPlayerRealColoredName(uuid).equalsIgnoreCase(getPlayerColoredName(uuid));
  }
  
  public static boolean isPlayerNicked(String name) {
    return getPlayerRealColoredName(name).equalsIgnoreCase(getPlayerColoredName(name));
  }
  
  public static boolean isPlayerNicked(Player player) {
    return isPlayerNicked(player.getUniqueId());
  }
}
