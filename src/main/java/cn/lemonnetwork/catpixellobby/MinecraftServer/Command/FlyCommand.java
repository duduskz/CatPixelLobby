package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player p = (Player)commandSender;
    if (!commandSender.hasPermission("catpixel.fly")) {
      commandSender.sendMessage("§c你不可以这样做！");
      return true;
    } 
    if (p.getAllowFlight()) {
      p.setAllowFlight(false);
      p.sendMessage("§c你关闭了飞行！");
      Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set catpixel.autofly false");
      return true;
    } 
    if (!p.getAllowFlight()) {
      p.setAllowFlight(true);
      p.sendMessage("§a你开启了飞行");
      Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set catpixel.autofly true");
    } 
    return false;
  }
}
