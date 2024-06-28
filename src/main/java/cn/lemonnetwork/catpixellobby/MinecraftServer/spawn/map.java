package cn.lemonnetwork.catpixellobby.MinecraftServer.spawn;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class map {
  public static void setSpawn(Player p) {
    Location loc = p.getLocation().add(0.0D, 2.0D, 0.0D).clone();
    CatPixelLobby.getInstance().getConfig().set("spawn", loc);
    CatPixelLobby.getInstance().saveConfig();
    p.sendMessage("§a出生点位置已成功设置！");
  }
  
  public static void teleportSpawn(Player p) {
    if (CatPixelLobby.getInstance().getConfig().get("spawn") == null) {
      p.sendMessage("");
      p.sendMessage("§c发生了一个错误，请将此截图发送给管理员！");
      p.sendMessage("§c错误类型： NO_PLAYER_LOCATION");
      p.sendMessage("§c解决方案： §b设置玩家出生点");
      p.sendMessage("");
    } else {
      Location spawn = (Location)CatPixelLobby.getInstance().getConfig().get("spawn");
      p.teleport(spawn);
    } 
  }
}
