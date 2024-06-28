package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SendAllPlayerMessageAPI {
  public static void SendMessageAllPlayer(String message) {
    for (Player player1 : Bukkit.getOnlinePlayers())
      player1.sendMessage(ColorAPI.tMC(message)); 
  }
}
