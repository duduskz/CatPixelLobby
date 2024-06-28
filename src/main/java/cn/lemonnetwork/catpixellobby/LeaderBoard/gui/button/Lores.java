package cn.lemonnetwork.catpixellobby.LeaderBoard.gui.button;

import cn.lemonnetwork.catpixellobby.LeaderBoard.category.AlignmentCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ModeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.TimeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ViewCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.CacheData;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;

public class Lores {
  static String notSelected = "  &7";
  
  static String Selected = "&a▶ &7";
  
  public static List<String> Mode(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    ModeCategory category = (ModeCategory)CacheData.MODE.get(player);
    for (int i = ModeCategory.getMinId(); i <= ModeCategory.getMaxId(); i++)
      lores.add((category == ModeCategory.getById(i)) ? (Selected + Selected) : (notSelected + notSelected)); 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步 ");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存 ");
    lores.add("&8因此不会实时更新 ");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    lores.add(" ");
    return lores;
  }
  
  public static List<String> Time(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    TimeCategory category = (TimeCategory)CacheData.TIME.get(player);
    for (int i = TimeCategory.getMinId(); i <= TimeCategory.getMaxId(); i++)
      lores.add((category == TimeCategory.getById(i)) ? (Selected + Selected) : (notSelected + notSelected)); 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步 ");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存 ");
    lores.add("&8因此不会实时更新 ");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    lores.add(" ");
    return lores;
  }
  
  public static List<String> View(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    ViewCategory category = (ViewCategory)CacheData.VIEW.get(player);
    for (int i = ViewCategory.getMinId(); i <= ViewCategory.getMaxId(); i++)
      lores.add((category == ViewCategory.getById(i)) ? (Selected + Selected) : (notSelected + notSelected)); 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步 ");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存 ");
    lores.add("&8因此不会实时更新 ");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    lores.add(" ");
    return lores;
  }
  
  public static List<String> PlayerType(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    lores.add(Selected + "&7全部");
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步 ");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存 ");
    lores.add("&8因此不会实时更新 ");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    lores.add(" ");
    return lores;
  }
  
  public static List<String> Alignment(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    AlignmentCategory category = (AlignmentCategory)CacheData.ALIGNMENT.get(player);
    for (int i = AlignmentCategory.getMinId(); i <= AlignmentCategory.getMaxId(); i++)
      lores.add((category == AlignmentCategory.getById(i)) ? (Selected + Selected) : (notSelected + notSelected)); 
    lores.add(" ");
    lores.add("&c  侧边对齐方式在使用 ");
    lores.add("&c  原版字体时显示效果最佳 ");
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步 ");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存 ");
    lores.add("&8因此不会实时更新 ");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    lores.add(" ");
    return lores;
  }
}
