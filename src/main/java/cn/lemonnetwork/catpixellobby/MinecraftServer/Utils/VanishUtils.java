package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;

public class VanishUtils {
  public static final List<Player> players = new ArrayList<>();
  
  public static boolean isVanished(Player player) {
    try {
      if (players.contains(player))
        return true; 
      Connection conn = null;
      try {
        conn = CatPixelLobby.dataSource.getConnection();
        return conn.prepareStatement(
            String.format("SELECT * FROM %s WHERE %s = '%s';", new Object[] { "player_vanishes", "name", player.getName() })).executeQuery().next();
      } catch (Exception e) {
        try {
          if (conn != null)
            conn.close(); 
        } catch (Exception exception) {}
      } finally {
        if (conn != null)
          conn.close(); 
      } 

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return false;
  }
  
  public static void setVanish(Player player) {
    if (players.contains(player))
      return; 
    Connection conn = null;
    PreparedStatement pre = null;
    try {
      conn = CatPixelLobby.dataSource.getConnection();
      pre = conn.prepareStatement(String.format("INSERT INTO %s (%s) VALUES ('%s');", new Object[] { "player_vanishes", "name", player
              .getName() }));
      pre.executeUpdate();
      pre.close();
      conn.close();
    } catch (Exception e) {
      try {
        if (pre != null)
          pre.close(); 
        if (conn != null)
          conn.close(); 
      } catch (Exception exception) {}
    } 
    players.add(player);
  }
  
  public static void remVanish(Player player) {
    if (!players.contains(player))
      return; 
    Connection conn = null;
    PreparedStatement pre = null;
    try {
      conn = CatPixelLobby.dataSource.getConnection();
      pre = conn.prepareStatement(String.format("DELETE FROM %s WHERE %s = '%s';", new Object[] { "player_vanishes", "name", player
              .getName() }));
      pre.executeUpdate();
      pre.close();
      conn.close();
    } catch (Exception e) {
      try {
        if (pre != null)
          pre.close(); 
        if (conn != null)
          conn.close(); 
      } catch (Exception exception) {}
    } 
    players.remove(player);
  }
}
