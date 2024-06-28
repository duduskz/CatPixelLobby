package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.FireworksMenu;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.TheDeliveryMenu;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CatPixelLobbyCommand implements CommandExecutor {
  public boolean isPlayerExists(String name) {
    return (Bukkit.getPlayerExact(name) != null);
  }
  
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    Player player = (Player)sender;
    if (args.length == 0) {
      sender.sendMessage("§c使用指令： /CatPixelLobby <parameter>");
      return true;
    } 
    if (args[0].equalsIgnoreCase("TheDelivery")) {
      (new TheDeliveryMenu(player)).open();
      return true;
    } 
    if (args[0].equalsIgnoreCase("FireworksMenu")) {
      (new FireworksMenu(player)).open();
      return true;
    } 
    if (args[0].equalsIgnoreCase("spigot")) {
      player.sendMessage("§fThis server is running CraftBukkit version CatPixelCore (MC: 1.8.8) (Implementing API version 1.8.8-R0.1-SNAPSHOT)");
      player.sendMessage("§9本服务器运行的是基于dSpigot开源服务端核心源码二次开发的CatPixelCore核心。二次开发工作由CatPixelStudio团队完成。");
    } 
    return false;
  }
}
