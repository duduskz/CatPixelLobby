package cn.lemonnetwork.catpixellobby.MinecraftServer.TheDelivery.Database;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinDate implements Listener {
  @EventHandler
  public void join(PlayerJoinEvent event) {
    try {
      Player player = event.getPlayer();
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      if (!rs.next())
        statement.executeUpdate("INSERT INTO player_reward (uuid, Day, Normal, VIP, VIPplus, MVP, MVPplus , NewPlayer) VALUES ('" + event.getPlayer().getName().toString() + "','false', 'false', 'false', 'false', 'false', 'false', 'false')"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
