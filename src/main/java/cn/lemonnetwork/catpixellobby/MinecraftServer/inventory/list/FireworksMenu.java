package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.MinecraftServer.ShowFireworks.ShowFireworks;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FireworksMenu extends InventoryAbs {
  private Player player;
  
  CommandSender consoleSender = (CommandSender)Bukkit.getServer().getConsoleSender();
  
  public FireworksMenu(Player p) {
    super(p, 5, "烟花管理员");
    this.player = p;
  }
  
  public void setup() {
    ItemStack startFireworks = new ItemStack(159, 1, (short)5);
    ItemStack noFireworks = new ItemStack(159, 1, (short)14);
    ItemUtils.createItem(startFireworks, "§a烟花表演", Arrays.asList(new String[] { "§7在服务器大厅展示一场烟花秀", "§7给所有玩家观赏！", "§7", "§f 花费:", "§f §b-1张烟花票", "", "§f 当前可用的烟花票： §d" + 
            
            MySQL.getFireworksAvailableString(this.player), "", "§e§l点击消费并发射！" }));
    ItemUtils.createItem(noFireworks, "§c烟花表演", Arrays.asList(new String[] { "§7在服务器大厅展示一场烟花秀", "§7给所有玩家观赏！", "§7", "§f 花费:", "§f §b-1张烟花票 §c(票数不足)", "", "§f 当前可用的烟花票： §d" + 
            
            MySQL.getFireworksAvailableString(this.player), "", "§c你没有可用的烟花票！" }));
    if (MySQL.getFireworksAvailable(this.player) >= 1) {
      setItem(22, (InventoryAbs.Item)new InventoryAbs.ItemAbs(startFireworks) {
            public void onClick(InventoryClickEvent e) {
              e.getWhoClicked().sendMessage("§e你花费了一张烟花票，现在烟花秀将在10秒后开始！");
              ShowFireworks.start();
              FireworksMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.NOTE_PLING, 1.0F, 2.0F);
              FireworksMenu.this.player.closeInventory();
            }
          });
    } else if (MySQL.getFireworksAvailable(this.player) == 0) {
      setItem(22, (InventoryAbs.Item)new InventoryAbs.ItemAbs(noFireworks) {
            public void onClick(InventoryClickEvent e) {
              e.getWhoClicked().sendMessage("§c你没有可用的烟花票，请购买一张吧~！");
              FireworksMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              FireworksMenu.this.player.closeInventory();
            }
          });
    } 
  }
}
