package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.AssembleBoard;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AssembleBoardCreatedEvent extends Event {
  public static HandlerList handlerList = new HandlerList();
  
  private boolean cancelled = false;
  
  private final AssembleBoard board;
  
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
  
  public AssembleBoardCreatedEvent(AssembleBoard board) {
    this.board = board;
  }
  
  public static HandlerList getHandlerList() {
    return handlerList;
  }
  
  public HandlerList getHandlers() {
    return handlerList;
  }
  
  public boolean isCancelled() {
    return this.cancelled;
  }
  
  public AssembleBoard getBoard() {
    return this.board;
  }
}
