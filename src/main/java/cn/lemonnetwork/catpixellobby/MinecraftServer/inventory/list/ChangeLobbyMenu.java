package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ChangeLobbyMenu extends InventoryAbs {
  private Player player;
  
  public ChangeLobbyMenu(Player p) {
    super(p, 2, "切换大厅");
    this.player = p;
  }
  
  public void setup() {
    ItemStack Lobby_1 = new ItemStack(159, 1, (short)14);
    ItemStack Lobby_2 = new ItemStack(173, 1);
    ItemStack Lobby_3 = new ItemStack(173, 1);
    ItemStack Lobby_4 = new ItemStack(173, 1);
    ItemStack Lobby_5 = new ItemStack(173, 1);
    ItemUtils.createItem(Lobby_1, "§a一号大厅", Arrays.asList(new String[] { "§b• §f服务器信息", " §7状态： §a在线", " §7房间在线玩家: " + 
            
            API.onlinePlayer() + "人", "", "§c你正处于此房间！" }));
    setItem(0, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Lobby_1) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c你已经在这个房间上了喵~");
            ChangeLobbyMenu.this.player.playSound(ChangeLobbyMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            ChangeLobbyMenu.this.player.closeInventory();
          }
        });
    ItemUtils.createItem(Lobby_2, "§a二号大厅", Arrays.asList(new String[] { "§b• §f服务器信息", " §7状态： §c离线", " §7房间在线玩家: 0人", "", "§e• §f详细信息", " §e工程文件未完善，等", " §e待开发人员进行更新！", "", "§c房间处于离线或维护状态" }));
    setItem(1, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Lobby_2) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此房间处于离线或维护状态，给您带来不便！");
            ChangeLobbyMenu.this.player.playSound(ChangeLobbyMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            ChangeLobbyMenu.this.player.closeInventory();
          }
        });
    ItemUtils.createItem(Lobby_3, "§a三号大厅", Arrays.asList(new String[] { "§b• §f服务器信息", " §7状态： §c离线", " §7房间在线玩家: 0人", "", "§e• §f详细信息", " §e工程文件未完善，等", " §e待开发人员进行更新！", "", "§c房间处于离线或维护状态" }));
    setItem(2, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Lobby_3) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此房间处于离线或维护状态，给您带来不便！");
            ChangeLobbyMenu.this.player.playSound(ChangeLobbyMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            ChangeLobbyMenu.this.player.closeInventory();
          }
        });
    ItemUtils.createItem(Lobby_4, "§a四号大厅", Arrays.asList(new String[] { "§b• §f服务器信息", " §7状态： §c离线", " §7房间在线玩家: 0人", "", "§e• §f详细信息", " §e工程文件未完善，等", " §e待开发人员进行更新！", "", "§c房间处于离线或维护状态" }));
    setItem(3, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Lobby_4) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此房间处于离线或维护状态，给您带来不便！");
            ChangeLobbyMenu.this.player.playSound(ChangeLobbyMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            ChangeLobbyMenu.this.player.closeInventory();
          }
        });
    ItemUtils.createItem(Lobby_5, "§a五号大厅", Arrays.asList(new String[] { "§b• §f服务器信息", " §7状态： §c离线", " §7房间在线玩家: 0人", "", "§e• §f详细信息", " §e工程文件未完善，等", " §e待开发人员进行更新！", "", "§c房间处于离线或维护状态" }));
    setItem(4, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Lobby_5) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此房间处于离线或维护状态，给您带来不便！");
            ChangeLobbyMenu.this.player.playSound(ChangeLobbyMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            ChangeLobbyMenu.this.player.closeInventory();
          }
        });
  }
}
