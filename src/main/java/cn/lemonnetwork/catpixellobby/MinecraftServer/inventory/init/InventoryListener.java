package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.init;

import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {
  @EventHandler
  public void onClick(InventoryClickEvent e) {
    if (e.getInventory() == null || e.getCurrentItem() == null || e.getClickedInventory() == null || !e.getClickedInventory().equals(e.getInventory()))
      return; 
    if (InventoryAbs.clickableMap.isEmpty())
      return; 
    if (InventoryAbs.clickableMap.get(e.getInventory()) == null)
      return; 
    e.setCancelled(true);
    for (InventoryAbs.Item clickableItem : InventoryAbs.clickableMap.get(e.getInventory())) {
      if (!e.getCurrentItem().equals(clickableItem.getItemStack()))
        continue; 
      clickableItem.onClick(e);
    } 
  }
}
