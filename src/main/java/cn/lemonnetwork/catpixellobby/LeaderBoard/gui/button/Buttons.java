package cn.lemonnetwork.catpixellobby.LeaderBoard.gui.button;

import cn.lemonnetwork.catpixellobby.LeaderBoard.category.AlignmentCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ModeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.TimeCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.category.ViewCategory;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.CacheData;
import cn.lemonnetwork.catpixellobby.LeaderBoard.utils.ColorUtil;
import cn.lemonnetwork.catpixellobby.LeaderBoard.utils.ItemBuilder;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Buttons {
  ItemMeta meta;
  
  ItemStack item;
  
  String notSelected = "   &7";
  
  String Selected = "&a➟ &7";
  
  public ItemStack Modes(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    if (CacheData.MODE.get(player) == ModeCategory.ALL) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.SOLO) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.DOUBLE) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.THREE_THREE_THREE_THREE) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.TEAM) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.DREAM_TEAM) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.MODE.get(player) == ModeCategory.DREAM_FOUR) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存，因此不会实时更新");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    this.item = (new ItemBuilder(Material.BED)).name(ColorUtil.color("&a模式")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack Time(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    if (CacheData.TIME.get(player) == TimeCategory.WEEKLY) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.TIME.get(player) == TimeCategory.MONTHLY) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.TIME.get(player) == TimeCategory.LIFETIME) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存，因此不会实时更新");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    this.item = (new ItemBuilder(Material.WATCH)).name(ColorUtil.color("&a时间")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack View(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    if (CacheData.VIEW.get(player) == ViewCategory.TOP) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.VIEW.get(player) == ViewCategory.AROUND) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存，因此不会实时更新");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    this.item = (new ItemBuilder(Material.LADDER)).name(ColorUtil.color("&a视图")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack PlayerType(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add(" ");
    lores.add("&a➟ &7全部");
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存，因此不会实时更新");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    this.item = (new ItemBuilder(Material.SKULL_ITEM)).name(ColorUtil.color("&a玩家")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack Alignment(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add("  ");
    if (CacheData.ALIGNMENT.get(player) == AlignmentCategory.CENTER) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    if (CacheData.ALIGNMENT.get(player) == AlignmentCategory.BLOCK) {
      lores.add(this.Selected + this.Selected);
    } else {
      lores.add(this.notSelected + this.notSelected);
    } 
    lores.add(" ");
    lores.add(" &c侧边对齐方式在使用原版");
    lores.add(" &cMinecraft字体时显示效果最佳");
    lores.add(" ");
    lores.add("&8此设置在所有大厅间同步");
    lores.add(" ");
    lores.add("&8排行榜的数据存在缓存，因此不会实时更新");
    lores.add(" ");
    lores.add("&e左键/右键点击更改！");
    this.item = (new ItemBuilder(Material.ITEM_FRAME)).name(ColorUtil.color("&a文本对齐方式")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack Confirm(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add("&e点击应用更改！");
    this.item = (new ItemBuilder(Material.STAINED_CLAY)).durability(13).name(ColorUtil.color("&a应用更改")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
  
  public ItemStack Cancel(Player player) {
    List<String> lores = new ArrayList<>();
    lores.add("&e关闭菜单并放弃更改！");
    this.item = (new ItemBuilder(Material.STAINED_CLAY)).durability(14).name(ColorUtil.color("&c放弃更改")).lore(lores).build();
    this.meta = this.item.getItemMeta();
    this.item.setItemMeta(this.meta);
    return this.item;
  }
}
