package cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class NewPlayerHelpCommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) {
      commandSender.sendMessage("§c指令只能是玩家才能使用！");
      return true;
    } 
    final Player player = (Player)commandSender;
    player.setAllowFlight(true);
    player.setFlying(true);
    player.setFlySpeed(-1.0F);
    player.performCommand("playerhelpvanish");
    (new BukkitRunnable() {
        public void run() {
          if (player.isFlying()) {
            player.setAllowFlight(true);
            player.setFlying(true);
          } else {
            player.setAllowFlight(true);
            player.setFlying(true);
          } 
          player.teleport(new Location(player.getWorld(), 0.54D, 92.218D, -32.351D, -179.0F, 1.0F));
          player.performCommand("dontmove");
          player.sendMessage("");
          player.sendMessage("§e跳跃到传送门中");
          player.sendMessage("§b或者右键点击游戏菜单来开始游戏！");
          player.sendMessage("");
          player.sendTitle("§e跳跃到传送门中", "§b或者右键点击游戏菜单来开始游戏！");
          player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F, 1.0F);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 0L);
    (new BukkitRunnable() {
        public void run() {
          Achievement.Unlock(player, "我是一名新手！", "在CatPixel大厅中使用新人指导NPC", "NewPlayerNPC", Integer.valueOf(10));
          player.performCommand("dontmove");
          player.teleport(new Location(player.getWorld(), 0.543D, 85.114D, -24.345D, 179.0F, 11.0F));
          player.performCommand("dontmove");
          player.sendMessage("");
          player.sendMessage("§e你也可以");
          player.sendMessage("§b右键点击传送门附近的任意一个NPC！");
          player.sendMessage("");
          player.sendTitle("§e你也可以", "§b右键点击传送门附近的任意一个NPC！");
          player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F, 1.0F);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 90L);
    (new BukkitRunnable() {
        public void run() {
          player.performCommand("dontmove");
          player.teleport(new Location(player.getWorld(), 13.038D, 84.134D, -11.442D, -92.0F, 3.0F));
          player.performCommand("dontmove");
          player.sendMessage("");
          player.sendMessage("§e请查看你的神秘箱");
          player.sendMessage("§b这里有玩具和更多内容！");
          player.sendMessage("");
          player.sendTitle("§e请查看你的神秘箱", "§b这里有玩具和更多内容！");
          player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F, 1.0F);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 180L);
    (new BukkitRunnable() {
        public void run() {
          player.performCommand("dontmove");
          player.teleport(new Location(player.getWorld(), 2.074D, 110.75043D, 0.045D, -179.0F, 2.0F));
          player.performCommand("dontmove");
          player.sendMessage("");
          player.sendMessage("§e访问我们的社交媒体！");
          player.sendMessage("§6官方抖音账号发布更多§b新闻，讨论以及内容");
          player.sendMessage("");
          player.sendTitle("§e访问我们的社交媒体！", "§6官方抖音账号发布更多§b新闻，讨论以及内容");
          player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0F, 1.0F);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 270L);
    (new BukkitRunnable() {
        public void run() {
          player.performCommand("dontmove");
          player.teleport(new Location(player.getWorld(), 0.503D, 90.029D, 0.52D, -179.0F, 2.0F));
          player.performCommand("dontmove");
          player.performCommand("playerhelpvanish");
          player.sendMessage("");
          player.sendMessage("§e就是这样！");
          player.sendMessage("§b祝你在CatPixel NetWork上玩得开心！");
          player.sendMessage("");
          player.sendTitle("§e就是这样！", "§b祝你在CatPixel NetWork上玩得开心！");
          player.playSound(player.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 360L);
    (new BukkitRunnable() {
        public void run() {
          player.performCommand("dontmove");
          player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          player.setFlySpeed(0.1F);
          player.setAllowFlight(false);
          player.setFlying(false);
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 390L);
    return false;
  }
}
