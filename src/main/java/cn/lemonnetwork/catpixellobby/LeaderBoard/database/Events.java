package cn.lemonnetwork.catpixellobby.LeaderBoard.database;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    UUID uuid = player.getUniqueId();
    CatPixelLobby.getInstance().getData().savePlayerData(uuid, player.getName(), "ALL", "LIFETIME", "TOP", "ALL", "CENTER");
    CatPixelLobby.getInstance().getHologramManager().createHolograms(player);
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    CatPixelLobby.getInstance().getHologramManager().removeHolgrams(player);
  }
}
