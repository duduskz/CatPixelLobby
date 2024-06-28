package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.VanishUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.sendActionbarAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class VanishCommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player))
      return true; 
    if (!commandSender.hasPermission("catpixel.vanish")) {
      commandSender.sendMessage("§c你不可以这样做！");
      return true;
    } 
    Player player = (Player)commandSender;
    if (VanishUtils.isVanished(player)) {
      player.sendMessage("§c隐身已关闭！");
      VanishUtils.remVanish(player);
      Bukkit.getOnlinePlayers().forEach(online -> online.showPlayer(player));
    } else {
      player.sendMessage("§a隐身已开启！");
      VanishUtils.setVanish(player);
      Bukkit.getOnlinePlayers().forEach(online -> online.hidePlayer(player));
      sendVanishActionbar(player);
    } 
    return true;
  }
  
  public static void sendVanishActionbar(final Player player) {
    (new BukkitRunnable() {
        public void run() {
          if (VanishUtils.isVanished(player))
            sendActionbarAPI.sendActionbar(player, "§f你目前§c隐身了"); 
        }
      }).runTaskTimer((Plugin)CatPixelLobby.getInstance(), 10L, 20L);
    (new BukkitRunnable() {
        public void run() {
          if (VanishUtils.isVanished(player))
            sendActionbarAPI.sendActionbar(player, "§f你目前§c隐身了"); 
        }
      }).runTaskTimer((Plugin)CatPixelLobby.getInstance(), 20L, 20L);
    (new BukkitRunnable() {
        public void run() {
          if (VanishUtils.isVanished(player))
            sendActionbarAPI.sendActionbar(player, "§f你目前§c隐身了"); 
        }
      }).runTaskTimer((Plugin)CatPixelLobby.getInstance(), 40L, 20L);
  }
}
