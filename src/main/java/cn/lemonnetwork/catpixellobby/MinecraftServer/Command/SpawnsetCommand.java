package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.MinecraftServer.spawn.map;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnsetCommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    if (!commandSender.hasPermission("catpixellobby.admin")) {
      commandSender.sendMessage("§c你不可以这样做！");
      return true;
    } 
    map.setSpawn(player);
    return true;
  }
}
