package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {
  @EventHandler
  public void Click(InventoryClickEvent event) {
    event.setCancelled(true);
  }
}
