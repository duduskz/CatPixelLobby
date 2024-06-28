package cn.lemonnetwork.catpixellobby.MinecraftServer.Command.adminCommand;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import java.util.List;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class KaboomCommand implements CommandExecutor {
  private static List<Player> list;
  
  public static List<Player> getList() {
    return list;
  }
  
  public static String getPrefix(Player p) {
    String prefix = LuckPermsProvider.get().getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getPrefix();
    return (prefix == null) ? "" : ChatColor.translateAlternateColorCodes('&', prefix);
  }
  
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    if (!commandSender.hasPermission("catpixellobby.admin.kaboom")) {
      commandSender.sendMessage("§c你不可以这样做！");
      return true;
    } 
    for (Player OnlinePlayer : Bukkit.getOnlinePlayers()) {
      String playerName = player.getName();
      OnlinePlayer.setVelocity(new Vector(0, 20, 0));
      OnlinePlayer.sendTitle("§e§lKABOOM!", "§f发射者:" + getPrefix(player) + playerName);
      OnlinePlayer.sendMessage("§e§l轰隆！ §7你被炸飞了，发射者：" + getPrefix(player) + playerName);
      OnlinePlayer.getWorld().strikeLightningEffect(OnlinePlayer.getLocation());
      String name = "轰隆，我起飞了！";
      String lore = "在大厅中管理使用Kaboom功能将你击飞！";
      Achievement.Unlock(OnlinePlayer, name, lore, "Kaboom", Integer.valueOf(5));
    } 
    return false;
  }
}
