package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events.AssembleBoardCreateEvent;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events.AssembleBoardDestroyEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AssembleListener implements Listener {
  private final Assemble assemble;
  
  public AssembleListener(Assemble assemble) {
    this.assemble = assemble;
  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    AssembleBoardCreateEvent createEvent = new AssembleBoardCreateEvent(event.getPlayer());
    Bukkit.getPluginManager().callEvent((Event)createEvent);
    if (createEvent.isCancelled())
      return; 
    getAssemble().getBoards().put(event.getPlayer().getUniqueId(), new AssembleBoard(event.getPlayer(), getAssemble()));
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    AssembleBoardDestroyEvent destroyEvent = new AssembleBoardDestroyEvent(event.getPlayer());
    Bukkit.getPluginManager().callEvent((Event)destroyEvent);
    if (destroyEvent.isCancelled())
      return; 
    getAssemble().getBoards().remove(event.getPlayer().getUniqueId());
    event.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
  }
  
  public Assemble getAssemble() {
    return this.assemble;
  }
}
