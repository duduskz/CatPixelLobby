package cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class onMoveCommand implements CommandExecutor {
  public void startLoopback(Player player) {
    this.playerLocations.put(player, player.getLocation());
    this.task = Bukkit.getServer().getScheduler().runTaskTimer((Plugin)CatPixelLobby.getInstance(), () -> {
          Location currentLocation = player.getLocation();
          Location previousLocation = this.playerLocations.get(player);
          if (currentLocation.distance(previousLocation) > 0.1D) {
            player.teleport(previousLocation);
            player.setAllowFlight(true);
            player.setFlying(true);
            player.setFlySpeed(0.0F);
          } 
          this.playerLocations.put(player, player.getLocation());
        },0L, 1L);
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (this.task != null) {
        stopLoopback();
      } else {
        startLoopback(player);
      } 
    } else {
      sender.sendMessage("" + ChatColor.DARK_GRAY + "Only players can use this command.");
    } 
    return true;
  }
  
  private final Map<Player, Location> playerLocations = new HashMap<>();
  
  private BukkitTask task;
  
  public void stopLoopback() {
    if (this.task != null) {
      this.task.cancel();
      this.task = null;
      this.playerLocations.clear();
    } 
  }
}
