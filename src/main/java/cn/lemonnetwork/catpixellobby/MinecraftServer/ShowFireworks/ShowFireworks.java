package cn.lemonnetwork.catpixellobby.MinecraftServer.ShowFireworks;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.TitleUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ShowFireworks {
  //该类代码由 LemonNetwork 重制，赵泽民可写不来这么高级的代码，还是套的BukkitRunnable，蚌埠住了
  public static void start() {
    Plugin plugin = CatPixelLobby.getInstance();
    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
      scheduleTitles(onlinePlayer, plugin);
    }
  }

  private static void scheduleTitles(Player player, Plugin plugin) {
    TitleInfo[] titles = {
            new TitleInfo(20, "§f烟  花  秀", "", 0, 25, 0),
            new TitleInfo(25, "§f烟 花 秀", "", 0, 25, 0),
            new TitleInfo(30, "§f烟花秀", "", 0, 25, 0),
            new TitleInfo(35, "§f烟 花 秀", "", 0, 25, 0),
            new TitleInfo(40, "§f烟  花  秀", "", 0, 25, 0),
            new TitleInfo(45, "§f烟 花 秀", "", 0, 25, 0),
            new TitleInfo(50, "§f烟花秀", "", 0, 25, 0),
            new TitleInfo(55, "§f烟 花 秀", "", 0, 25, 0),
            new TitleInfo(60, "§f烟  花  秀", "", 0, 25, 0),
            new TitleInfo(65, "§f烟 花 秀", "", 0, 25, 0),
            new TitleInfo(68, "§f烟 花 秀", "§a发", 0, 25, 0),
            new TitleInfo(70, "§f烟 花 秀", "§c发射", 0, 25, 0),
            new TitleInfo(72, "§f烟 花 秀", "§d发射倒", 0, 25, 0),
            new TitleInfo(74, "§f烟 花 秀", "§1发射倒计", 0, 25, 0),
            new TitleInfo(76, "§f烟 花 秀", "§2发射倒计时", 0, 25, 0),
            new TitleInfo(78, "§f烟 花 秀", "§3发射倒计时", 0, 25, 0),
            new TitleInfo(80, "§f烟 花 秀", "§c发射倒计时", 0, 25, 0),
            new TitleInfo(82, "§f烟 花 秀", "§d发射倒计时", 0, 25, 0),
            new TitleInfo(84, "§f烟 花 秀", "§b发射倒计时: ", 0, 25, 0),
            new TitleInfo(86, "§f", "§b ", 0, 25, 0),
            new TitleInfo(90, "§f烟 花 秀", "§b发射倒计时: ", 0, 25, 0),
            new TitleInfo(94, "§f", "§b ", 0, 25, 0),
            new TitleInfo(98, "§f烟 花 秀", "§b发射倒计时: ", 0, 25, 0),
            new TitleInfo(102, "§f", "§b ", 0, 25, 0),
            new TitleInfo(104, "§f烟 花 秀", "§b发射倒计时: ", 0, 40, 20)
    };

    for (TitleInfo titleInfo : titles) {
      Bukkit.getScheduler().runTaskLater(plugin, () ->
              TitleUtils.sendFullTitle(player, titleInfo.fadeIn, titleInfo.stay, titleInfo.fadeOut, titleInfo.title, titleInfo.subtitle), titleInfo.time
      );
    }
  }

  private static class TitleInfo {
    int time;
    String title;
    String subtitle;
    int fadeIn;
    int stay;
    int fadeOut;

    TitleInfo(int time, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
      this.time = time;
      this.title = title;
      this.subtitle = subtitle;
      this.fadeIn = fadeIn;
      this.stay = stay;
      this.fadeOut = fadeOut;
    }
  }
}
