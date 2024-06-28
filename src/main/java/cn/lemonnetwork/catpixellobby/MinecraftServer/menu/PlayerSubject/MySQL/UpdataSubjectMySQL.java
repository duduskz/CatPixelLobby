package cn.lemonnetwork.catpixellobby.MinecraftServer.menu.PlayerSubject.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.entity.Player;

public class UpdataSubjectMySQL {
  public static String ip = "127.0.0.1";
  
  public static String port = "3306";
  
  public static String user = "hypixellobby";
  
  public static String password = "hypixellobby";
  
  public static String database = "hypixellobby";
  
  public static Connection conn;
  
  public static Connection connect() {
    if (conn == null)
      try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?autoReconnect=true", user, password);
      } catch (SQLException|ClassNotFoundException sQLException) {} 
    return conn;
  }
  
  public static String getPlayerSubject(Player player) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_subject WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next())
        return rs.getString("Subject"); 
      rs.close();
      statement.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static void setPlayerSubject(Player player, String NewSubject) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_subject WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next()) {
        sql = "UPDATE player_subject SET Subject = '" + NewSubject + "' WHERE player_name = '" + player.getName() + "';";
        statement.executeUpdate(sql);
      } else {
        sql = "INSERT INTO player_subject (player_name, Subject) VALUES ('" + player.getName() + "', '" + NewSubject + "');";
        statement.executeUpdate(sql);
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
}
