package cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class onVanishCommand implements CommandExecutor {
  List<Player> vanished = new ArrayList<>();
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player))
      return true; 
    Player player = (Player)sender;
    if (this.vanished.contains(player)) {
      this.vanished.remove(player);
      for (Player target : Bukkit.getOnlinePlayers()) {
        target.showPlayer(player);
      }
      player.sendMessage("§a你已解除隐身！");
    } else {
      this.vanished.add(player);
      for (Player target : Bukkit.getOnlinePlayers()) {
        target.hidePlayer(player);
      }
      player.sendMessage("§c你已隐身！");
    }

    return false;
  }
}
