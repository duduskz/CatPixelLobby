package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ChangeMVPPrefixColor extends InventoryAbs {
  private Player player;
  
  CommandSender consoleSender = (CommandSender)Bukkit.getServer().getConsoleSender();
  
  private String needMVP = "§c需要§bMVP§c";
  
  private String clickChange = "§e点击更换！";
  
  private String goldPrefix = "";
  
  public ChangeMVPPrefixColor(Player p) {
    super(p, 5, "Rank颜色");
    this.player = p;
  }
  
  public void setup() {
    final String playerName = this.player.getName();
    ItemStack back = new ItemStack(Material.ARROW, 1);
    ItemStack reset = new ItemStack(95, 1, (short)14);
    ItemStack GoldColor = new ItemStack(351, 1, (short)14);
    ItemUtils.createItem(back, "§a返回", Arrays.asList(new String[] { "§7返回到个人档案菜单", "", "§e点击返回！" }));
    if (this.player.hasPermission("catpixel.rank.mvp+")) {
      ItemUtils.createItem(reset, "§c重置我的称号颜色", Arrays.asList(new String[] { "§7更换到§bMVP§c+§7的默认颜色。", "", this.clickChange }));
    } else {
      ItemUtils.createItem(reset, "§c重置我的称号颜色", Arrays.asList(new String[] { "§bMVP§c+§7的默认颜色。", "", this.needMVP }));
    } 
    if (this.player.hasPermission("catpixel.rank.mvp+")) {
      ItemUtils.createItem(GoldColor, "§6金锭 Rank颜色", Arrays.asList(new String[] { "§7在§bMVP§c+§7处改变“+”的颜色", "§7为金锭，将它改变为§bMVP§6+", "", this.clickChange }));
    } else {
      ItemUtils.createItem(GoldColor, "§6金锭 Rank颜色", Arrays.asList(new String[] { "§7在§bMVP§c+§7处改变“+”的颜色", "§7为金锭，将它改变为§bMVP§6+", "", this.needMVP }));
    } 
    setItem(39, (InventoryAbs.Item)new InventoryAbs.ItemAbs(back) {
          public void onClick(InventoryClickEvent e) {
            (new ProfileMenu(ChangeMVPPrefixColor.this.player)).open();
          }
        });
    setItem(41, (InventoryAbs.Item)new InventoryAbs.ItemAbs(reset) {
          public void onClick(InventoryClickEvent e) {
            if (ChangeMVPPrefixColor.this.player.hasPermission("catpixel.rank.mvp+")) {
              ChangeMVPPrefixColor.this.player.sendMessage("§a你已经将称号恢复直初始状态！");
              Bukkit.getServer().dispatchCommand(ChangeMVPPrefixColor.this.consoleSender, "lp user " + playerName + " meta removeprefix 500");
              ChangeMVPPrefixColor.this.player.playSound(ChangeMVPPrefixColor.this.player.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
            } else {
              ChangeMVPPrefixColor.this.player.sendMessage("§c你没有§bMVP§c+，请购买后再试吧！");
              ChangeMVPPrefixColor.this.player.playSound(ChangeMVPPrefixColor.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            } 
          }
        });
    setItem(10, (InventoryAbs.Item)new InventoryAbs.ItemAbs(GoldColor) {
          public void onClick(InventoryClickEvent e) {
            if (ChangeMVPPrefixColor.this.player.hasPermission("catpixel.rank.mvp+")) {
              ChangeMVPPrefixColor.this.player.sendMessage("§a你已经将称号等级颜色设置成 §6金锭");
              Bukkit.getServer().dispatchCommand(ChangeMVPPrefixColor.this.consoleSender, "lp user " + playerName + " meta setprefix 500 §b[MVP§6+§b] ");
              ChangeMVPPrefixColor.this.player.playSound(ChangeMVPPrefixColor.this.player.getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
            } else {
              ChangeMVPPrefixColor.this.player.sendMessage("§c你没有§bMVP§c+，请购买后再试吧！");
              ChangeMVPPrefixColor.this.player.playSound(ChangeMVPPrefixColor.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            } 
          }
        });
  }
}
