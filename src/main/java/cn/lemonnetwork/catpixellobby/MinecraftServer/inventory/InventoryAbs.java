package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryAbs {
  Player player;
  
  Inventory inventory;
  
  ArrayList<Item> clickableItems;
  
  public static final HashMap<Inventory, ArrayList<Item>> clickableMap = new HashMap<>();
  
  public InventoryAbs(Player p, int rows, String name) {
    this.player = p;
    this.inventory = Bukkit.createInventory(null, rows * 9, "§8" + name);
    this.clickableItems = new ArrayList<>();
  }
  
  public abstract void setup();
  
  public void open() {
    setup();
    this.player.openInventory(this.inventory);
  }
  
  public void setItem(int index, Item clickableItem) {
    this.clickableItems.add(clickableItem);
    clickableMap.put(this.inventory, this.clickableItems);
    this.inventory.setItem(index, clickableItem.getItemStack());
  }
  
  public void addItem(Item... items) {
    for (int i = 0; i <= items.length; i++) {
      Item clickableItem = items[i];
      this.clickableItems.add(clickableItem);
      clickableMap.put(this.inventory, this.clickableItems);
      this.inventory.addItem(new ItemStack[] { clickableItem.getItemStack() });
    } 
  }
  
  public static interface Item {
    ItemStack getItemStack();
    
    void onClick(InventoryClickEvent param1InventoryClickEvent);
  }
  
  public static class NoneItem implements Item {
    private final ItemStack itemStack;
    
    public NoneItem(ItemStack itemStack) {
      this.itemStack = itemStack;
    }
    
    public void onClick(InventoryClickEvent e) {}
    
    public ItemStack getItemStack() {
      return this.itemStack;
    }
  }
  
  public static abstract class ItemAbs implements Item {
    private final ItemStack itemStack;
    
    public ItemAbs(ItemStack itemStack) {
      this.itemStack = itemStack;
    }
    
    public ItemStack getItemStack() {
      return this.itemStack;
    }
  }
}
