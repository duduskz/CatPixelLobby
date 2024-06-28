package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import java.util.Objects;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerEvent implements Listener {
  @EventHandler
  public void onBreak(BlockBreakEvent event) {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void onPlace(BlockPlaceEvent event) {
    if (((String)Objects.<String>requireNonNull(MySQL.QueryLobbySettings(event.getPlayer(), "editmode"))).equalsIgnoreCase("true")) {
      event.setCancelled(false);
    } else if (((String)Objects.<String>requireNonNull(MySQL.QueryLobbySettings(event.getPlayer(), "editmode"))).equalsIgnoreCase("false")) {
      event.setCancelled(true);
    } 
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent e) {
    Player player = e.getPlayer();
    if (player.getLocation().getY() <= -80.0D)
      player.performCommand("spawn"); 
  }
}
