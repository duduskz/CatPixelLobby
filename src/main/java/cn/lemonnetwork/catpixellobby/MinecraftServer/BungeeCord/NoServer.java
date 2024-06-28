package cn.lemonnetwork.catpixellobby.MinecraftServer.BungeeCord;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class NoServer {
  public static void NoFoundServer(Player player) {
    player.sendTitle("§c传送失败", "§b抱歉，目前没有可用的房间！");
    player.sendMessage("§c目前没有可用的房间，请联系管理员房间是否正常运行中！");
    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
  }
}
