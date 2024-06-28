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

public class BedWarsLobbyChat implements Listener {
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event) {
    event.setCancelled(true);
    String pre = "%luckperms_prefix%";
    pre = PlaceholderAPI.setPlaceholders(event.getPlayer(), pre);
    TextComponent tc = new TextComponent("§7");
    TextComponent tc1 = new TextComponent(pre + pre);
    tc1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(pre + pre + "\n §b| §f玩家起床战争数据: §3\n  §a➥  §7等级进度:  <bw_formatted>§8/§a<bw_rerq_xp_formatted>\n          <bw_progress>\n       §7总击杀数： §a<bw_kills>\n       §7总胜利场次： §a<bw_wins>\n\n §e| §f其他数据：\n  §6➥  §f成就点数：§e " + event
            
            .getPlayer().getName() + "\n  §b➥  §f神秘之尘：§a " + 
            
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
