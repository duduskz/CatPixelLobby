package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AssembleBoardCreateEvent extends Event implements Cancellable {
  public static HandlerList handlerList = new HandlerList();
  
  private Player player;
  
  private boolean cancelled = false;
  
  public AssembleBoardCreateEvent(Player player) {
    this.player = player;
  }
  
  public static HandlerList getHandlerList() {
    return handlerList;
  }
  
  public HandlerList getHandlers() {
    return handlerList;
  }
  
  public Player getPlayer() {
    return this.player;
  }
  
  public boolean isCancelled() {
    return this.cancelled;
  }
  
  public void setPlayer(Player player) {
    this.player = player;
  }
  
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}
