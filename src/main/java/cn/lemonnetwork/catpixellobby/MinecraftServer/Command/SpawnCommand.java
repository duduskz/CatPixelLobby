package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.MinecraftServer.spawn.map;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) {
      commandSender.sendMessage("§c控制台无法使用此指令！");
      return true;
    } 
    Player p = (Player)commandSender;
    if (strings.length == 0)
      map.teleportSpawn(p); 
    return true;
  }
}
