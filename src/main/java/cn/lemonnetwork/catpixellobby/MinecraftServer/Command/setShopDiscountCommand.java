package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class setShopDiscountCommand implements CommandExecutor, Listener {
  CommandSender consoleSender = (CommandSender)Bukkit.getServer().getConsoleSender();
  
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    if (!commandSender.hasPermission("catpixellobby.admin.shopdiscount")) {
      commandSender.sendMessage("§c你没有权限可以这样做！");
      return true;
    } 
    if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("false")) {
      MySQL.setShopDiscount("true");
      player.sendMessage("§bCatPixelLobby §f>> §a你启动了商店折扣模式，现在服务器的所有消费商店将已享受最低优惠的价格！");
      player.playSound(player.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
    } else if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("true")) {
      MySQL.setShopDiscount("false");
      player.sendMessage("§bCatPixelLobby §f>> §c你关闭了商店折扣模式，现在服务器的所有消费商店已经恢复到正常价格！");
      player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
    } 
    for (Player player1 : Bukkit.getOnlinePlayers()) {
      if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("true")) {
        player1.sendTitle("§a§ka§c§l折扣活动！ §a§ka", "§b服务器商店已经打折了！");
        player1.sendMessage("§c§l折扣！ §f商店折扣活动启动了，赶紧去消费吧！");
        player1.playSound(player1.getLocation(), Sound.ENDERDRAGON_DEATH, 1.0F, 1.0F);
        Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player1.getName() + " permission set catpixellobby.discount.false false");
        Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player1.getName() + " permission set catpixellobby.discount.true true");
        Achievement.Unlock(player1, "太廉价啦！", "享受服务器的最低优惠折扣！", "ShopDisCount", Integer.valueOf(10));
        Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> player1.playSound(player1.getLocation(), Sound.VILLAGER_IDLE, 1.0F, 1.0F), 200L);
        Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> player1.sendTitle("§b最低价格！", "§e商品全部降低到最低价格"), 200L);
        Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> player1.playSound(player1.getLocation(), Sound.VILLAGER_HAGGLE, 1.0F, 1.0F), 240L);
        Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> player1.sendTitle("§b购买指南", "§e前往大厅商店进行购买！"), 240L);
        continue;
      } 
      if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("false")) {
        player1.sendTitle("§e活动结束！", "§c折扣活动已经结束了，谢谢参与！");
        player1.sendMessage("");
        player1.sendMessage("§a服务器所有商品价格已恢复至正常状态！");
        player1.sendMessage("");
        Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player1.getName() + " permission set catpixellobby.discount.true false");
        Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player1.getName() + " permission set catpixellobby.discount.false true");
        player1.playSound(player1.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
      } 
    } 
    return false;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("false")) {
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set catpixellobby.discount.true false");
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set catpixellobby.discount.false true");
    } else if (MySQL.getLobbyShopDiscount().equalsIgnoreCase("true")) {
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set catpixellobby.discount.false false");
      Bukkit.getServer().dispatchCommand(this.consoleSender, "lp user " + player.getName() + " permission set catpixellobby.discount.true true");
    } 
  }
}
