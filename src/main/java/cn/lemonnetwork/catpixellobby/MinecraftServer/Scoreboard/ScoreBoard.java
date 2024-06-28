package cn.lemonnetwork.catpixellobby.MinecraftServer.Scoreboard;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.AssembleAdapter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Player;

public class ScoreBoard implements AssembleAdapter {
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
  
  private final DecimalFormat numformatInt = new DecimalFormat("0");
  
  private final DecimalFormat numFormat = new DecimalFormat("0.0");
  
  private final DecimalFormat numFormatTwo = new DecimalFormat("0.00");
  
  private final DecimalFormat df = new DecimalFormat(",###,###,###,###");
  
  private final List<String> animationTitle = Arrays.asList(new String[] { "&b&lCat&e&lPixel" });
  
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
    List<String> list = new ArrayList<>();
    list.add("");
    list.add("&f玩家： §7" + player.getName() + "    ");
    list.add("&f会员等级： " + API.getPlayerLuckPermsGroup(player));
    list.add("");
    list.add("&f等级: &b" + API.getLevel(player) + "✫");
    list.add("§f进度: &3" + API.getLevelProgressPercent(player));
    list.add("&f升级还需要经验:&b " + API.getNextUPLevel(player) + "  ");
    list.add("");
    list.add("&f点券: §d" + API.getPlayerPoints(player) + " §d❄");
    list.add("&f成就点数： §e" + API.getAchevementPoints(player) + " §e◈");
    list.add("&f神秘之尘: §b" + API.getMysteryDust(player) + " §b★");
    list.add("");
    list.add("&f在线玩家： §a" + API.getBungeeOnline(player));
    list.add("");
    list.add("§emc.catpixel.top");
    return list;
  }
}
