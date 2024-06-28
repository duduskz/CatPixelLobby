package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinRewardsMessage implements Listener {
  @EventHandler
  public void PlayerJoinLevelRewards(PlayerJoinEvent event) {
    final Player player = event.getPlayer();
    (new BukkitRunnable() {
        public void run() {
          if (!PlaceholderAPI.setPlaceholders(player, "%alonsolevels_available_normal_rewards%").equalsIgnoreCase("0")) {
            player.sendMessage("§a你有§b" + PlaceholderAPI.setPlaceholders(player, "%alonsolevels_available_normal_rewards%") + "§a个等级奖励尚未领取！");
            TextComponent textComponent = new TextComponent("§e点击查看！");
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§e点击查看§3Hypixel大厅等级§e菜单！")).create()));
            textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/alonsolevels rewards"));
            player.spigot().sendMessage((BaseComponent)textComponent);
          } 
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 21L);
  }
  
  @EventHandler
  public void PlayerJoinAchievementRewards(PlayerJoinEvent event) {
    final Player player = event.getPlayer();
    (new BukkitRunnable() {
        public void run() {
          String rewards1 = "%hypixellobby_AchievementPoints%";
          rewards1 = PlaceholderAPI.setPlaceholders(player.getPlayer(), rewards1);
          if (rewards1 != null && rewards1.equalsIgnoreCase(String.valueOf(20))) {
            player.sendMessage("§a你有§61§a个成就奖励尚未领取！");
            TextComponent textComponent = new TextComponent("§e点击查看！");
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§e点击查看§6Hypixel成就礼包§e菜单！")).create()));
            textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/achievements"));
            player.spigot().sendMessage((BaseComponent)textComponent);
          } else if (rewards1 != null && rewards1.equalsIgnoreCase("100")) {
            player.sendMessage("§aTest §b你现在的成就点数是100");
          } else {
            player.sendMessage("\n§a你没有任何成就礼品领取！\n");
          } 
        }
      }).runTaskLater((Plugin)CatPixelLobby.getInstance(), 21L);
  }
}
