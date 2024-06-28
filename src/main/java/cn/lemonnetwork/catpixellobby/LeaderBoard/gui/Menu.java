package cn.lemonnetwork.catpixellobby.LeaderBoard.gui;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.AlignmentCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ModeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.TimeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ViewCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.CacheData;
import cn.lemonnetwork.catpixellobby.LeaderBoard.gui.button.Buttons;
import cn.lemonnetwork.catpixellobby.LeaderBoard.gui.button.Lores;
import cn.lemonnetwork.catpixellobby.LeaderBoard.utils.ColorUtil;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu implements Listener {
  private final HashMap<Player, Long> lastClickTimes = new HashMap<>();
  
  String title = ColorUtil.color("&8排行榜设置");
  
  private final Inventory inv = Bukkit.createInventory(null, 45, this.title);
  
  public void openMenu(Player player) {
    UUID uuid = player.getUniqueId();
    CacheData.MODE.put(player, ModeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode")));
    CacheData.TIME.put(player, TimeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time")));
    CacheData.VIEW.put(player, ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view")));
    CacheData.ALIGNMENT.put(player, AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")));
    CacheData.ISDISCARD.put(player, Boolean.valueOf(false));
    player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
    init(player);
  }
  
  public void init(Player player) {
    this.inv.setItem(11, (new Buttons()).Modes(player));
    this.inv.setItem(12, (new Buttons()).Time(player));
    this.inv.setItem(13, (new Buttons()).View(player));
    this.inv.setItem(14, (new Buttons()).PlayerType(player));
    this.inv.setItem(15, (new Buttons()).Alignment(player));
    this.inv.setItem(30, (new Buttons()).Confirm(player));
    this.inv.setItem(32, (new Buttons()).Cancel(player));
    player.openInventory(this.inv);
  }
  
  @EventHandler
  public void onClick(InventoryClickEvent e) {
    Player player = (Player)e.getWhoClicked();
    UUID uuid = player.getUniqueId();
    if (e.getCurrentItem() == null)
      return; 
    if (e.getCurrentItem().getItemMeta() == null)
      return; 
    if (e.getCurrentItem().getItemMeta().getDisplayName() == null)
      return; 
    if (!e.getInventory().getName().equals(this.title))
      return; 
    e.setCancelled(true);
    long currentTime = System.currentTimeMillis();
    if (this.lastClickTimes.containsKey(player)) {
      long lastClickTime = ((Long)this.lastClickTimes.get(player)).longValue();
      if (currentTime - lastClickTime < 150L)
        return; 
    } 
    this.lastClickTimes.put(player, Long.valueOf(currentTime));
    if (e.getSlot() == 11) {
      player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
      ModeCategory currentCategory = (ModeCategory)CacheData.MODE.get(player);
      if (e.isLeftClick()) {
        if (currentCategory.getID() == ModeCategory.getMaxId()) {
          CacheData.MODE.put(player, ModeCategory.getById(ModeCategory.getMinId()));
        } else {
          int newCategoryId = currentCategory.getID() + 1;
          ModeCategory updatedCategory = ModeCategory.getById(newCategoryId);
          CacheData.MODE.put(player, updatedCategory);
        } 
      } else if (e.isRightClick()) {
        if (currentCategory.getID() == ModeCategory.getMinId()) {
          CacheData.MODE.put(player, ModeCategory.getById(ModeCategory.getMaxId()));
        } else {
          int newCategoryId = currentCategory.getID() - 1;
          ModeCategory updatedCategory = ModeCategory.getById(newCategoryId);
          CacheData.MODE.put(player, updatedCategory);
        } 
      } 
      ItemStack currentItem = e.getCurrentItem();
      if (currentItem != null) {
        ItemMeta itemMeta = currentItem.getItemMeta();
        if (itemMeta != null) {
          itemMeta.setLore(ColorUtil.color(Lores.Mode(player)));
          currentItem.setItemMeta(itemMeta);
        } 
      } 
    } 
    if (e.getSlot() == 12) {
      player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
      TimeCategory category = (TimeCategory)CacheData.TIME.get(player);
      if (category == TimeCategory.WEEKLY) {
        CacheData.TIME.put(player, TimeCategory.MONTHLY);
      } else if (category == TimeCategory.MONTHLY) {
        CacheData.TIME.put(player, TimeCategory.LIFETIME);
      } else if (category == TimeCategory.LIFETIME) {
        CacheData.TIME.put(player, TimeCategory.WEEKLY);
      } 
      ItemStack currentItem = e.getCurrentItem();
      if (currentItem != null) {
        ItemMeta itemMeta = currentItem.getItemMeta();
        if (itemMeta != null) {
          itemMeta.setLore(ColorUtil.color(Lores.Time(player)));
          currentItem.setItemMeta(itemMeta);
        } 
      } 
    } 
    if (e.getSlot() == 13) {
      player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
      ViewCategory category = (ViewCategory)CacheData.VIEW.get(player);
      if (category == ViewCategory.TOP) {
        CacheData.VIEW.put(player, ViewCategory.AROUND);
      } else if (category == ViewCategory.AROUND) {
        CacheData.VIEW.put(player, ViewCategory.TOP);
      } 
      ItemStack currentItem = e.getCurrentItem();
      if (currentItem != null) {
        ItemMeta itemMeta = currentItem.getItemMeta();
        if (itemMeta != null) {
          itemMeta.setLore(ColorUtil.color(Lores.View(player)));
          currentItem.setItemMeta(itemMeta);
        } 
      } 
    } 
    if (e.getSlot() == 14) {
      player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
      ItemStack currentItem = e.getCurrentItem();
      if (currentItem != null) {
        ItemMeta itemMeta = currentItem.getItemMeta();
        if (itemMeta != null) {
          itemMeta.setLore(ColorUtil.color(Lores.PlayerType(player)));
          currentItem.setItemMeta(itemMeta);
        } 
      } 
    } 
    if (e.getSlot() == 15) {
      player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 2.0F);
      AlignmentCategory category = (AlignmentCategory)CacheData.ALIGNMENT.get(player);
      if (category == AlignmentCategory.CENTER) {
        CacheData.ALIGNMENT.put(player, AlignmentCategory.BLOCK);
      } else if (category == AlignmentCategory.BLOCK) {
        CacheData.ALIGNMENT.put(player, AlignmentCategory.CENTER);
      } 
      ItemStack currentItem = e.getCurrentItem();
      if (currentItem != null) {
        ItemMeta itemMeta = currentItem.getItemMeta();
        if (itemMeta != null) {
          itemMeta.setLore(ColorUtil.color(Lores.Alignment(player)));
          currentItem.setItemMeta(itemMeta);
        } 
      } 
    } 
    if (e.getSlot() == 30)
      if (CacheData.MODE.get(player) == ModeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode")) && CacheData.TIME.get(player) == TimeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time")) && CacheData.ALIGNMENT.get(player) == AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")) && CacheData.VIEW.get(player) == ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view"))) {
        player.sendMessage(ColorUtil.color("&a你的设置未更改！"));
        player.closeInventory();
      } else {
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        player.sendMessage(ColorUtil.color("&a已应用对排行榜设置的更改！"));
        CacheData.ISDISCARD.put(player, Boolean.valueOf(true));
        savePlayerData(player);
        CatPixelLobby.getInstance().getHologramManager().updateHolograms(player);
        player.closeInventory();
      }  
    if (e.getSlot() == 32) {
      player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
      player.sendMessage(ColorUtil.color("&c已放弃对排行榜设置的更改！"));
      CacheData.ISDISCARD.put(player, Boolean.valueOf(true));
      player.closeInventory();
    } 
  }
  
  @EventHandler
  public void onClose(InventoryCloseEvent event) {
    Player player = (Player)event.getPlayer();
    UUID uuid = player.getUniqueId();
    if (player.getInventory().getTitle().equalsIgnoreCase(this.title))
      return; 
    if (((Boolean)CacheData.ISDISCARD.get(player)).booleanValue())
      return; 
    if (CacheData.MODE.get(player) != ModeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "mode")) || CacheData.TIME.get(player) != TimeCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "time")) || CacheData.ALIGNMENT.get(player) != AlignmentCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "alignment")) || CacheData.VIEW.get(player) != ViewCategory.valueOf(CatPixelLobby.getInstance().getData().getPlayerData(uuid, "view"))) {
      player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      player.sendMessage(ColorUtil.color("&a已应用对排行榜设置的更改！"));
      savePlayerData(player);
      CatPixelLobby.getInstance().getHologramManager().updateHolograms(player);
    } 
  }
  
  public void savePlayerData(Player player) {
    UUID uuid = player.getUniqueId();
    CatPixelLobby.getInstance().getData().updatePlayerData(uuid, "mode", String.valueOf(CacheData.MODE.get(player)));
    CatPixelLobby.getInstance().getData().updatePlayerData(uuid, "time", String.valueOf(CacheData.TIME.get(player)));
    CatPixelLobby.getInstance().getData().updatePlayerData(uuid, "view", String.valueOf(CacheData.VIEW.get(player)));
    CatPixelLobby.getInstance().getData().updatePlayerData(uuid, "alignment", String.valueOf(CacheData.ALIGNMENT.get(player)));
  }
}
