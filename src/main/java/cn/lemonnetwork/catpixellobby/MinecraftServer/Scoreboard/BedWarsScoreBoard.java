package cn.lemonnetwork.catpixellobby.MinecraftServer.Scoreboard;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.AssembleAdapter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class BedWarsScoreBoard implements AssembleAdapter {
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
  
  private final DecimalFormat numformatInt = new DecimalFormat("0");
  
  private final DecimalFormat numFormat = new DecimalFormat("0.0");
  
  private final DecimalFormat numFormatTwo = new DecimalFormat("0.00");
  
  private final DecimalFormat df = new DecimalFormat(",###,###,###,###");
  
  private final List<String> animationTitle = Arrays.asList(new String[] { "&e&l起床战争" });
  
  private long lastAnimationTime = 0L;
  
  private int animationTick = 0;
  
  public String getTitle(Player player) {
    String text = this.animationTitle.get(this.animationTick);
    if (System.currentTimeMillis() - this.lastAnimationTime >= 125L) {
      this.animationTick++;
      if (this.animationTick + 1 >= this.animationTitle.size())
        this.animationTick = 0; 
      this.lastAnimationTime = System.currentTimeMillis();
    } 
    return text;
  }
  
  public List<String> getLines(Player player) {
    String BW_LEVEL = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_player_level%");
    String BW_formatted = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_player_xp_formatted%");
    String BW_rerq_formatted = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_player_rerq_xp_formatted%");
    String BW_progress = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_player_progress%");
    String BW_kills = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_stats_kills%");
    String BW_wins = PlaceholderAPI.setPlaceholders(player.getPlayer(), "%bw1058_stats_wins%");
    List<String> list = new ArrayList<>();
    list.add("");
    list.add("&f等级： " + BW_LEVEL);
    list.add("");
    list.add("&f进度:&b" + BW_formatted + "&8/&a" + BW_rerq_formatted + "&a        ");
    list.add(" " + BW_progress);
    list.add("");
    list.add("&f喵星币: §6" + API.getMiaoCoins(player));
    list.add("");
    list.add("&f总击杀数： &a" + BW_kills);
    list.add("&f总胜利场次： &a" + BW_wins);
    list.add("");
    list.add("§emc.catpixel.top");
    return list;
  }
}
