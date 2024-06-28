package cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class AchievementList implements Listener {
  @EventHandler
  public void Join(PlayerMoveEvent playerMoveEvent) {
    Player player = playerMoveEvent.getPlayer();
    if (playerMoveEvent.getFrom().getBlock().getType() == Material.PORTAL) {
      player.setVelocity(player.getEyeLocation().getDirection().multiply(2));
      String name = "为什么我不能进入传送门？";
      String lore = "在CatPixel大厅中进入一个传送门";
      Achievement.Unlock(player, name, lore, "JoinHellPortal", Integer.valueOf(5));
    } 
  }
  
  @EventHandler
  public void JoinServerAchievement(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    Achievement.Unlock(player, "猫像素大家庭！", "第一次加入CatPixelNetwork服务器！", "JoinServers", 
        
        Integer.valueOf(5));
    Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.instance, () -> Achievement.Unlock(player, "全新大陆！", "体验新版本的大厅地图", "NewWorld", Integer.valueOf(10)), 40L);
    Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.instance, () -> Achievement.Unlock(player, "新变化！？", "加入并体验新5.0版本的服务器！", "NewServerVersion", Integer.valueOf(10)), 60L);
  }
  
  @EventHandler
  public void ChatForFirstTime(PlayerChatEvent event) {
    Player player = event.getPlayer();
    String name = "让世界听到你的声音！";
    String lore = "第一次在服务器上说话！";
    Achievement.Unlock(player, name, lore, "SpeakingForTheFirstTime", Integer.valueOf(10));
  }
}
