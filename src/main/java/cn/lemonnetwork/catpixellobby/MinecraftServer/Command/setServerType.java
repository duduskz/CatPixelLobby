package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class setServerType implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    Player player = (Player)sender;
    if (!sender.hasPermission("catpixellobby.admin.servertypecmd")) {
      sender.sendMessage("§c你没有权限！");
      return true;
    } 
    if (args.length == 0) {
      sender.sendMessage("");
      sender.sendMessage("§c使用指令： /setServerType <TYPE>");
      sender.sendMessage("§c服务器类型输入§bhelp获取帮助！");
      sender.sendMessage("");
      return true;
    } 
    if (args[0].equalsIgnoreCase("help")) {
      if (!sender.hasPermission("catpixellobby.admin.servertypecmd")) {
        sender.sendMessage("§c你没权限！");
        return true;
      } 
      sender.sendMessage("");
      sender.sendMessage("§6服务器TYPE列表: ");
      sender.sendMessage("");
      sender.sendMessage("§c未知 §bNULL");
      sender.sendMessage("§c主大厅 §bLOBBY");
      sender.sendMessage("§c起床战争大厅 §bBW_LOBBY");
      sender.sendMessage("§c空岛战争大厅 §bSW_LOBBY");
      sender.sendMessage("§c街机游戏大厅 §bAG_LOBBY");
      sender.sendMessage("§cUHC大厅 §bUHC_LOBBY");
      sender.sendMessage("§c建筑大师大厅 §bBB_LOBBY");
      sender.sendMessage("§c密室杀手大厅 §bMM_LOBBY");
      sender.sendMessage("§c超级战墙大厅 §bMW_LOBBY");
      sender.sendMessage("§c竞技场大厅 §bDL_LOBBY");
      sender.sendMessage("");
    } else if (args[0].equalsIgnoreCase("NULL")) {
      if (!sender.hasPermission("catpixellobby.admin.servertypecmd")) {
        sender.sendMessage("§c你没权限！");
        return true;
      } 
      CatPixelLobby.getInstance().getConfig().set("ServerSettings.ServerType", "NULL");
      CatPixelLobby.getInstance().saveConfig();
      sender.sendMessage("§a设置成功，服务器即将重启！");
      player.playSound(((Player)sender).getLocation(), Sound.VILLAGER_IDLE, 1.0F, 1.0F);
      for (Player player1 : Bukkit.getOnlinePlayers()) {
        player1.sendTitle("§e房间重启", "§b此房间类型已更换，即将在5秒后重启！");
        player1.sendMessage("§b管理员更改了此房间的TYPE，即将在5秒后重启此房间！");
        player1.playSound(player1.getLocation(), Sound.CAT_PURREOW, 1.0F, 1.0F);
      } 
      ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
      Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> Bukkit.getServer().dispatchCommand(consoleCommandSender, "restart"), 100L);
    } else if (args[0].equalsIgnoreCase("LOBBY")) {
      if (!sender.hasPermission("catpixellobby.admin.servertypecmd")) {
        sender.sendMessage("§c你没权限！");
        return true;
      } 
      CatPixelLobby.getInstance().getConfig().set("ServerSettings.ServerType", "LOBBY");
      CatPixelLobby.getInstance().saveConfig();
      sender.sendMessage("§a设置成功，服务器即将重启！");
      player.playSound(((Player)sender).getLocation(), Sound.VILLAGER_IDLE, 1.0F, 1.0F);
      for (Player player1 : Bukkit.getOnlinePlayers()) {
        player1.sendTitle("§e房间重启", "§b此房间类型已更换，即将在5秒后重启！");
        player1.sendMessage("§b管理员更改了此房间的TYPE，即将在5秒后重启此房间！");
        player1.playSound(player1.getLocation(), Sound.CAT_PURREOW, 1.0F, 1.0F);
      } 
      ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
      Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> Bukkit.getServer().dispatchCommand(consoleCommandSender, "restart"), 100L);
    } else if (args[0].equalsIgnoreCase("BW_LOBBY")) {
      if (!sender.hasPermission("catpixellobby.admin.servertypecmd")) {
        sender.sendMessage("§c你没权限！");
        return true;
      } 
      CatPixelLobby.getInstance().getConfig().set("ServerSettings.ServerType", "BW_LOBBY");
      CatPixelLobby.getInstance().saveConfig();
      sender.sendMessage("§a设置成功，服务器即将重启！");
      player.playSound(((Player)sender).getLocation(), Sound.VILLAGER_IDLE, 1.0F, 1.0F);
      for (Player player1 : Bukkit.getOnlinePlayers()) {
        player1.sendTitle("§e房间重启", "§b此房间类型已更换，即将在5秒后重启！");
        player1.sendMessage("§b管理员更改了此房间的TYPE，即将在5秒后重启此房间！");
        player1.playSound(player1.getLocation(), Sound.CAT_PURREOW, 1.0F, 1.0F);
      } 
      ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
      Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> Bukkit.getServer().dispatchCommand(consoleCommandSender, "restart"), 100L);
    } else {
      sender.sendMessage("");
      sender.sendMessage("§c未知的服务器类型！");
      sender.sendMessage("§c请输入§bhelp获取帮助！");
      sender.sendMessage("");
      return true;
    } 
    return false;
  }
}
