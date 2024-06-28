package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import java.util.List;
import org.bukkit.entity.Player;

public interface AssembleAdapter {
  String getTitle(Player paramPlayer);
  
  List<String> getLines(Player paramPlayer);
}
