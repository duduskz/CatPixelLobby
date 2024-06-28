package cn.lemonnetwork.catpixellobby.LeaderBoard;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.AlignmentCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ModeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.TimeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ViewCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.CacheData;
import cn.lemonnetwork.catpixellobby.LeaderBoard.gui.Menu;
import cn.lemonnetwork.catpixellobby.LeaderBoard.utils.ColorUtil;
import cn.lemonnetwork.catpixellobby.LeaderBoard.utils.RankUtil;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.handler.TouchHandler;
import com.gmail.filoghost.holographicdisplays.api.line.TextLine;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HologramsManager {
  // LeaderBoard 下的所有源代码 均来自于 StarryCountry-Development 作品，在使用时请考虑版权情况！
  public void createHolograms(Player player) {
    UUID uuid = player.getUniqueId();
    String KillworldName = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("Holograms.world");
    double Killx = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.kill.x");
    double Killy = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.kill.y");
    double Killz = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.kill.z");
    World Killworld = Bukkit.getWorld(KillworldName);
    Location Killlocation = new Location(Killworld, Killx, Killy, Killz);
    Hologram Killhologram = HologramsAPI.createHologram((Plugin)CatPixelLobby.getInstance(), Killlocation);
    Killhologram.getVisibilityManager().setVisibleByDefault(false);
    Killhologram.getVisibilityManager().showTo(player);
    updateKills(player, Killhologram, CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode"), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time"));
    CacheData.KILLMAP.put(player, Killhologram);
    String WinworldName = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("Holograms.world");
    double Winx = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.win.x");
    double Winy = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.win.y");
    double Winz = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.win.z");
    World Winworld = Bukkit.getWorld(WinworldName);
    Location Winlocation = new Location(Winworld, Winx, Winy, Winz);
    Hologram Winhologram = HologramsAPI.createHologram((Plugin)CatPixelLobby.getInstance(), Winlocation);
    Winhologram.getVisibilityManager().setVisibleByDefault(false);
    Winhologram.getVisibilityManager().showTo(player);
    updateWins(player, Winhologram, CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode"), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time"));
    CacheData.WINMAP.put(player, Winhologram);
    String LevelworldName = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("Holograms.world");
    double Levelx = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.level.x");
    double Levely = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.level.y");
    double Levelz = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.level.z");
    World Levelworld = Bukkit.getWorld(LevelworldName);
    Location Levellocation = new Location(Levelworld, Levelx, Levely, Levelz);
    Hologram Levelhologram = HologramsAPI.createHologram((Plugin)CatPixelLobby.getInstance(), Levellocation);
    Levelhologram.getVisibilityManager().setVisibleByDefault(false);
    Levelhologram.getVisibilityManager().showTo(player);
    updateLevels(player, Levelhologram);
    CacheData.LEVELMAP.put(player, Levelhologram);
    String ToggleworldName = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getString("Holograms.world");
    double Togglex = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.toggle.x");
    double Toggley = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.toggle.y");
    double Togglez = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getDouble("Holograms.location.toggle.z");
    World Toggleworld = Bukkit.getWorld(ToggleworldName);
    Location Togglelocation = new Location(Toggleworld, Togglex, Toggley, Togglez);
    Hologram Togglehologram = HologramsAPI.createHologram((Plugin)CatPixelLobby.getInstance(), Togglelocation);
    Togglehologram.getVisibilityManager().setVisibleByDefault(false);
    Togglehologram.getVisibilityManager().showTo(player);
    updateToggle(player, Togglehologram);
    CacheData.TOGGLEMAP.put(player, Togglehologram);
  }
  
  public void removeHolgrams(Player player) {
    ((Hologram)CacheData.KILLMAP.get(player)).delete();
    CacheData.KILLMAP.remove(player);
    ((Hologram)CacheData.WINMAP.get(player)).delete();
    CacheData.WINMAP.remove(player);
    ((Hologram)CacheData.LEVELMAP.get(player)).delete();
    CacheData.LEVELMAP.remove(player);
    ((Hologram)CacheData.TOGGLEMAP.get(player)).delete();
    CacheData.TOGGLEMAP.remove(player);
  }
  
  public void updateHolograms(Player player) {
    UUID uuid = player.getUniqueId();
    updateKills(player, (Hologram)CacheData.KILLMAP.get(player), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode"), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time"));
    updateWins(player, (Hologram)CacheData.WINMAP.get(player), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode"), CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time"));
    updateLevels(player, (Hologram)CacheData.LEVELMAP.get(player));
    updateToggle(player, (Hologram)CacheData.TOGGLEMAP.get(player));
  }
  
  public void updateKills(Player player, Hologram hologram, String mode, String time) {
    UUID uuid = player.getUniqueId();
    hologram.clearLines();
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&b&l&n" + TimeCategory.valueOf(time).getDisplayName() + " 击杀数")));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7" + ModeCategory.valueOf(mode).getDisplayName())));
    hologram.appendTextLine("");
    String ModePlaceHolder = ModeCategory.valueOf(mode).getPlaceHolderKill();
    String TimePlaceHolder = TimeCategory.valueOf(time).getPlaceHolder();
    if (AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")) == AlignmentCategory.CENTER) {
      if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
        for (int i = 1; i <= 10; i++)
          onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_color%%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_name% &8- &e%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_value%"))); 
        onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_" + ModePlaceHolder + "_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name% &8- &e%ajlb_value_" + ModePlaceHolder + "_alltime%")));
      } else {
        hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
      } 
    } else if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
      for (int i = 1; i <= 10; i++) {
        String output = padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_color%%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_name% %interval% &7'\" &e%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_value%")));
        onClick(hologram, output);
      } 
      onClick(hologram, padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_" + ModePlaceHolder + "_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name%&f %interval% &7'\" &e%ajlb_value_" + ModePlaceHolder + "_alltime%"))));
    } else {
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
    } 
    hologram.appendTextLine("");
    updateTime(player, hologram, time);
  }
  
  public void updateWins(Player player, Hologram hologram, String mode, String time) {
    UUID uuid = player.getUniqueId();
    hologram.clearLines();
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&b&l&n" + TimeCategory.valueOf(time).getDisplayName() + " 胜场数")));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7" + ModeCategory.valueOf(mode).getDisplayName())));
    hologram.appendTextLine("");
    String ModePlaceHolder = ModeCategory.valueOf(mode).getPlaceHolderWin();
    String TimePlaceHolder = TimeCategory.valueOf(time).getPlaceHolder();
    if (AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")) == AlignmentCategory.CENTER) {
      if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
        for (int i = 1; i <= 10; i++)
          onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_color%%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_name% &8- &e%ajlb_lb_" + ModePlaceHolder + "_" + i + "_" + TimePlaceHolder + "_value%"))); 
        onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_" + ModePlaceHolder + "_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name% &8- &e%ajlb_value_" + ModePlaceHolder + "_alltime%")));
      } else {
        hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
      } 
    } else if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
      for (int i = 1; i <= 10; i++) {
        String output = padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_color%%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_name% %interval% &7'\" &e%ajlb_lb_" + ModePlaceHolder + "_" + i + "_alltime_value%")));
        onClick(hologram, output);
      } 
      onClick(hologram, padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_" + ModePlaceHolder + "_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name%&f %interval% &7'\" &e%ajlb_value_" + ModePlaceHolder + "_alltime%"))));
    } else {
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
    } 
    hologram.appendTextLine("");
    updateTime(player, hologram, time);
  }
  
  public void updateLevels(Player player, Hologram hologram) {
    UUID uuid = player.getUniqueId();
    hologram.clearLines();
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&b&l&n起床战争等级")));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7所有模式")));
    hologram.appendTextLine("");
    if (AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")) == AlignmentCategory.CENTER) {
      if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
        for (int i = 1; i <= 10; i++)
          onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_color%%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_name% &8- &e%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_value%"))); 
        onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_bw1058_player_level_raw_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name%&f &8- &e%ajlb_value_bw1058_player_level_raw_alltime%")));
      } else {
        hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
      } 
    } else if (ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")) == ViewCategory.TOP) {
      for (int i = 1; i <= 10; i++) {
        String output = padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e" + i + ". §7%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_color%%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_name% %interval% &7'\" &e%ajlb_lb_bw1058_player_level_raw_" + i + "_alltime_value%")));
        onClick(hologram, output);
      } 
      onClick(hologram, padStringToLength(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&e%ajlb_position_bw1058_player_level_raw_alltime%. " + RankUtil.getPlayerRankColor(uuid) + "&n%player_name%&f %interval% &7'\" &e%ajlb_value_bw1058_player_level_raw_alltime%"))));
    } else {
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&c此类别暂未推出")));
    } 
    hologram.appendTextLine("");
    updateTime(player, hologram, String.valueOf(TimeCategory.LIFETIME));
  }
  
  public void updateToggle(Player player, Hologram hologram) {
    UUID uuid = player.getUniqueId();
    hologram.clearLines();
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&b&l&n排行榜设置")));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
    onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7模式: &a" + ModeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode")).getDisplayName())));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
    onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7时间: &a" + TimeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time")).getDisplayName())));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
    onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7视图: &a" + ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")).getDisplayName())));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
    onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7玩家: &a全部")));
    hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
    onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&6点击更改设置！")));
  }
  
  public void updateTime(Player player, Hologram hologram, String time) {
    Calendar calendar = Calendar.getInstance();
    int currentDayOfWeek = calendar.get(7);
    int currentDayOfMonth = calendar.get(5);
    int maximumDayOfWeek = calendar.getActualMaximum(7);
    int maximumDayOfMonth = calendar.getActualMaximum(5);
    int WeeklyResetDayBeforeNow = maximumDayOfWeek - currentDayOfWeek;
    int MonthlyResetDayBeforeNow = maximumDayOfMonth - currentDayOfMonth;
    int hours = calendar.get(10);
    int minutes = calendar.get(12);
    if (Objects.equals(TimeCategory.valueOf(time), TimeCategory.LIFETIME)) {
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7永不重置")));
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&6点击更改设置！")));
    } else if (Objects.equals(TimeCategory.valueOf(time), TimeCategory.MONTHLY)) {
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7" + MonthlyResetDayBeforeNow + " 天后重置")));
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&6点击更改设置！")));
    } else if (Objects.equals(TimeCategory.valueOf(time), TimeCategory.WEEKLY)) {
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&7" + WeeklyResetDayBeforeNow + " 天后重置")));
      hologram.appendTextLine(PlaceholderAPI.setPlaceholders(player, ColorUtil.color("")));
      onClick(hologram, PlaceholderAPI.setPlaceholders(player, ColorUtil.color("&6点击更改设置！")));
    } 
  }
  
  private TextLine onClick(Hologram hologram, String text) {
    TextLine textLine = hologram.appendTextLine(text);
    textLine.setTouchHandler(new TouchHandler() {
          public void onTouch(Player player) {
            (new Menu()).openMenu(player);
          }
        });
    return textLine;
  }

  public static String padStringToLength(String inputString) {
    int currentLength = calculateLength(inputString);
    int targetLength = ((CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class)).getConfig().getInt("Holograms.targetLength");
    int intervalCount = targetLength - currentLength;
    if (intervalCount <= 0) {
      return inputString;
    } else {
      String padding = " ".repeat(intervalCount);
      String outputString = inputString.replace("%interval%", padding);
      return outputString;
    }
  }
  
  public static int calculateLength(String inputString) {
    boolean skipNextChar = false;
    int length = 0;
    for (int i = 0; i < inputString.length(); i++) {
      char c = inputString.charAt(i);
      if (skipNextChar) {
        skipNextChar = false;
      } else if (c == '§') {
        skipNextChar = true;
      } else {
        length++;
      } 
    } 
    return length;
  }
}
