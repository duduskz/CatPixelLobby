package cn.lemonnetwork.catpixellobby.LeaderBoard.database;

import cn.lemonnetwork.catpixellobby.LeaderBoard.category.AlignmentCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ModeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.TimeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ViewCategory;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class CacheData {
  public static HashMap<Player, ModeCategory> MODE = new HashMap<>();
  
  public static HashMap<Player, TimeCategory> TIME = new HashMap<>();
  
  public static HashMap<Player, ViewCategory> VIEW = new HashMap<>();
  
  public static HashMap<Player, AlignmentCategory> ALIGNMENT = new HashMap<>();
  
  public static HashMap<Player, Hologram> KILLMAP = new HashMap<>();
  
  public static HashMap<Player, Hologram> WINMAP = new HashMap<>();
  
  public static HashMap<Player, Hologram> LEVELMAP = new HashMap<>();
  
  public static HashMap<Player, Hologram> TOGGLEMAP = new HashMap<>();
  
  public static HashMap<Player, Boolean> ISDISCARD = new HashMap<>();
}
