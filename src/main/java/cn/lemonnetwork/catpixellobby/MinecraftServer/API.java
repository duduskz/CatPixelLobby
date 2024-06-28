package cn.lemonnetwork.catpixellobby.MinecraftServer;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class API {
  public static int onlinePlayer() {
    Player[] players = (Player[])Bukkit.getServer().getOnlinePlayers().toArray((Object[])new Player[0]);
    return players.length;
  }
  
  public static String getLevel(Player player) {
    String level = "%alonsolevels_level%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getNextUPLevel(Player player) {
    String level = "%alonsolevels_experience_to_level_up%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getAchevementPoints(Player player) {
    String level = "%CatPixelLobby_AchievementPoints%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getMysteryDust(Player player) {
    String level = "%gadgetsmenu_mystery_dust%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getCompletedAchevement(Player player) {
    String level = "0";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getPlayerPoints(Player player) {
    String level = "%playerpoints_points%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getLevelProgressBar(Player player) {
    String level = "%alonsolevels_progress_bar%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level;
  }
  
  public static String getLevelProgressPercent(Player player) {
    String level = "%alonsolevels_progress_percent_format%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level;
  }
  
  public static String getPlayerLuckPermsGroup(Player player) {
    String level = "%luckperms_groups%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level;
  }
  
  public static String getBungeeOnline(Player player) {
    String level = "%bungee_total%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
  
  public static String getMiaoCoins(Player player) {
    String level = "%xconomy_balance_value%";
    level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
    return level.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,");
  }
}
