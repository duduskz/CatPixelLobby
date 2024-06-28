package cn.lemonnetwork.catpixellobby.MinecraftServer.menu.PlayerSubject;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinData implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    try {
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_subject WHERE player_name = '" + player.getName().toString() + "'");
      if (!rs.next())
        statement.executeUpdate("INSERT INTO player_subject (player_name, Subject) VALUES ('" + player
            .getName().toString() + "' , 'catpixel')"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  @EventHandler
  public void onSetSubject(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
  }
}
