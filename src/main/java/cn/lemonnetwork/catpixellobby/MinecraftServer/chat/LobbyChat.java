package cn.lemonnetwork.catpixellobby.MinecraftServer.chat;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LobbyChat implements Listener {
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
    event.setCancelled(true);
    String pre = "%luckperms_prefix%";
    pre = PlaceholderAPI.setPlaceholders(event.getPlayer(), pre);
    TextComponent tc = new TextComponent("§7");
    TextComponent tc1 = new TextComponent(pre + pre);
    tc1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(pre + pre + "\n §b| §f玩家大厅等级数据: §3" + event
            
            .getPlayer().getName() + "\n  §a➥  §7进度:  " + 
            
            API.getLevel(event.getPlayer()) + "  §a" + 
            API.getLevelProgressBar(event.getPlayer()) + "  \n       §7玩家下一级还需要经验: §a" + API.getLevelProgressPercent(event.getPlayer()) + "\n\n §e| §f其他数据：\n  §6➥  §f成就点数：§e " + 
            API.getNextUPLevel(event.getPlayer()) + "\n  §b➥  §f神秘之尘：§a " + 
            
            API.getAchevementPoints(event.getPlayer()) + "\n  §2➥  §f公会名称：§a §c开发中...\n\n §e✧ §e§l点击添加为好友！"))
          
          .create()));
    tc1.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/f " + event.getPlayer().getName()));
    if (event.getPlayer().hasPermission("catpixel.vipchat")) {
      TextComponent tc2 = new TextComponent("§f: " + event.getMessage());
      tc.addExtra((BaseComponent)tc1);
      tc.addExtra((BaseComponent)tc2);
    } else {
      TextComponent tc2 = new TextComponent("§7: " + event.getMessage());
      tc.addExtra((BaseComponent)tc1);
      tc.addExtra((BaseComponent)tc2);
    } 
    for (Player player : Bukkit.getOnlinePlayers())
      player.spigot().sendMessage((BaseComponent)tc); 
  }
}
