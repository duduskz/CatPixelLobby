package cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import java.sql.ResultSet;
import java.sql.Statement;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Achievement {
  //Achievement 类下的代码均为赵泽民大神侵犯 LemonNetwork 著作权对 LemonAchievement进行反编译操作。人不犯我，我不犯人~！
  public static void Unlock(Player player, String str1, String message, String id, Integer point) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = MySQL.connect().createStatement();
      String sql = "SELECT * FROM player_achievement WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next()) {
        if (!rs.getString("Achievements").contains(id)) {
          if (rs.getString("Achievements").equalsIgnoreCase("NO")) {
            sql = "UPDATE player_achievement SET Achievements = '" + id + "' WHERE uuid = '" + player.getName() + "';";
          } else {
            sql = "UPDATE player_achievement SET Achievements = '" + rs.getString("Achievements") + "," + id + "' WHERE uuid = '" + player.getName() + "';";
          } 
          statement.executeUpdate(sql);
          MySQL.addPlayerAchevement(player, point.intValue());
          String message11 = "§a>>     §b解锁成就： §6";
          TextComponent tc = new TextComponent("§e§ks" + message11);
          TextComponent tc1 = new TextComponent(str1);
          tc1.setColor(ChatColor.GOLD);
          String lore = "§a" + str1 + "\n\n§f" + message + "\n\n§7奖励:\n§8+§e" + point + "§e成就点数\n ";
          tc1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(lore)).create()));
          tc1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/achievements"));
          TextComponent tc2 = new TextComponent("     §a<<§e§ks");
          tc.addExtra((BaseComponent)tc1);
          tc.addExtra((BaseComponent)tc2);
          player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0F, 24.0F);
          player.spigot().sendMessage((BaseComponent)tc);
        } 
        rs.close();
      } else {
        sql = "INSERT INTO player_achievement (uuid, Achievements, AchievementPoints) VALUES ('" + player.getName() + "', '" + id + "', 0)";
        statement.executeUpdate(sql);
        MySQL.addPlayerAchevement(player, point.intValue());
        String message11 = "§a>>     §b解锁成就： §6";
        TextComponent tc = new TextComponent("§e§ks" + message11);
        TextComponent tc1 = new TextComponent(str1);
        tc1.setColor(ChatColor.GOLD);
        String lore = "§a" + str1 + "\n\n§f" + message + "\n\n§7奖励:\n§8+§e" + point + "§e成就点数\n ";
        tc1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(lore)).create()));
        tc1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/achievements"));
        TextComponent tc2 = new TextComponent("     §a<<§e§ks");
        tc.addExtra((BaseComponent)tc1);
        tc.addExtra((BaseComponent)tc2);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0F, 24.0F);
        player.spigot().sendMessage((BaseComponent)tc);
      } 
    } catch (ClassNotFoundException|java.sql.SQLException e) {
      e.printStackTrace();
    } 
  }
}
