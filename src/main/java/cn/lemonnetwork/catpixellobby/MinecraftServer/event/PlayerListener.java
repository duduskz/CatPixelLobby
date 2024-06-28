package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.Java.JoinServerTitle;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.VanishCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.VanishUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.spawn.map;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

public class PlayerListener implements Listener {
  static String serverType;
  
  CommandSender consoleSender = (CommandSender)Bukkit.getServer().getConsoleSender();
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    event.setJoinMessage(null);
    Player player = event.getPlayer();
    for (PotionEffect effect : player.getActivePotionEffects())
      player.removePotionEffect(effect.getType()); 
    map.teleportSpawn(player);
    if (VanishUtils.isVanished(player))
      VanishUtils.players.add(player); 
    Bukkit.getOnlinePlayers().forEach(online -> {
          if (VanishUtils.isVanished(player)) {
            online.hidePlayer(player);
            VanishCommand.sendVanishActionbar(player);
          } 
          if (VanishUtils.isVanished(online))
            player.hidePlayer(online); 
        });
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    for (PotionEffect effect : player.getActivePotionEffects())
      player.removePotionEffect(effect.getType()); 
    if (VanishUtils.players.contains(player))
      VanishUtils.players.remove(player); 
    event.setQuitMessage(null);
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent event) {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event) {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void ServerType(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    serverType = CatPixelLobby.getInstance().getConfig().getString("ServerSettings.ServerType");
    if (serverType.equalsIgnoreCase("NULL")) {
      player.sendMessage("");
      player.sendMessage("§c发生了一个错误，请将此截图发送给管理员！");
      player.sendMessage("§c错误类型： NO_SERVER_TYPE");
      player.sendMessage("§c解决方案： §b设置此服务器类型");
      player.sendMessage("");
      player.sendTitle("§c§l发生错误", "§e此大厅没有设置房间类型！");
    } else if (serverType.equalsIgnoreCase("LOBBY")) {
      JoinServerTitle.setLobbyTitle(player);
      player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F, 1.0F);
    } else if (serverType.equalsIgnoreCase("BW_LOBBY")) {
      JoinServerTitle.setBedWarsLobbyTitle(player);
    } 
  }
  
  @EventHandler
  public void RewardsNumberAdd(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (!player.hasPermission("rewards.number.newplayer")) {
      MySQL.addRewardNumber(player, 1);
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set rewards.number.newplayer false");
    } 
    if (!player.hasPermission("rewards.number.day")) {
      MySQL.addRewardNumber(player, 1);
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set rewards.number.day false");
    } 
    if (!player.hasPermission("rewards.number.month")) {
      MySQL.addRewardNumber(player, 1);
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set rewards.number.month false");
    } 
    if (!player.hasPermission("rewards.number.year")) {
      MySQL.addRewardNumber(player, 1);
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set rewards.number.year false");
    } else {
      MySQL.addRewardNumber(player, 0);
    } 
  }
}
