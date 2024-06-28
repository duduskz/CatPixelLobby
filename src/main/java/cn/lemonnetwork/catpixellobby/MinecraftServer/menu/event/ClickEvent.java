package cn.lemonnetwork.catpixellobby.MinecraftServer.menu.event;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickEvent implements Listener {
  @EventHandler
  public void onClickGamesMenuItem(InventoryClickEvent event) {
    try {
      Player player = (Player)event.getWhoClicked();
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a主大厅")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("LOBBY_1");
          player.sendMessage("§a正在连接至 主大厅");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a空岛战争")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("SW_LOBBY_1");
          player.sendMessage("§a正在连接至 空岛战争");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a街机游戏")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("ArcadeLobby#1");
          player.sendMessage("§a正在连接至 街机游戏");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a起床战争 §e§l更新！")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("BEDWARS_LOBBY_1");
          player.sendMessage("§a正在连接至 起床战争");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a超级战墙")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("MEGAWALLS_LOBBY_1");
          player.sendMessage("§a正在连接至 超级战墙");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a掘战游戏")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("TNTGAMES_LOBBY_1");
          player.sendMessage("§a正在连接至 掘战游戏");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a建筑大师")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("BUILD_LOBBY_1");
          player.sendMessage("§a正在连接至 建筑大师");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a迷你战墙")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("ARCADE_LOBBY_1");
          player.sendMessage("§a正在连接至 迷你战墙 -> 街机游戏大厅");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a极限生存冠军")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("UHC_LOBBY_1");
          player.sendMessage("§a正在连接至 极限生存冠军");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a闪电饥饿游戏")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("HungerGames_LOBBY_1");
          player.sendMessage("§a正在连接至 闪电饥饿游戏");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a警匪大战")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("CSGO_LOBBY_1");
          player.sendMessage("§a正在连接至 警匪大战");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a密室杀手 §e§l更新！")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("MurderMysteryLobby#1");
          player.sendMessage("§a正在连接至 密室杀手");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a决斗游戏")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("DUEL_LOBBY_1");
          player.sendMessage("§a正在连接至 决斗游戏");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a战争领主")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("WARLORD_LOBBY_1");
          player.sendMessage("§a正在连接至 战争领主");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
      if (event.getClickedInventory().getTitle().contains("游戏菜单")) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a天坑乱斗")) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF("THEPIT#1");
          player.sendMessage("§a正在连接至 天坑乱斗");
          player.sendPluginMessage((Plugin)JavaPlugin.getPlugin(CatPixelLobby.class), "BungeeCord", out.toByteArray());
        } 
      } 
    } catch (NullPointerException nullPointerException) {}
  }
}
