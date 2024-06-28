package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.adminCommand.KaboomCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.SendAllPlayerMessageAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VipJoinMessage implements Listener {
  @EventHandler
  public void VIPJoinMessage(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (player.hasPermission("catpixellobby.rank.vip"))
      SendAllPlayerMessageAPI.SendMessageAllPlayer(KaboomCommand.getPrefix(player) + KaboomCommand.getPrefix(player) + "§6加入了服务器！"); 
  }
  
  @EventHandler
  public void MVP_PLUS_JoinMessage(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (player.hasPermission("catpixellobby.rank.mvp"))
      SendAllPlayerMessageAPI.SendMessageAllPlayer("§b> §a> §c> " + KaboomCommand.getPrefix(player) + player.getDisplayName() + "§6加入了服务器！ §c< §a< §b<"); 
  }
}
