package cn.lemonnetwork.catpixellobby.Database;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Player;

public class MySQL {
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
  
  public static int getPlayerAchevement(Player player) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_achievement WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO player_achievement (uuid, Achievements, AchievementPoints) VALUES ('" + player.getName() + "', 'NO', 0)";
        statement.executeUpdate(sql);
        rs.close();
        return 0;
      } 
      return rs.getInt("AchievementPoints");
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
      return 1;
    } 
  }
  
  public static void addPlayerAchevement(Player player, int achievement) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_achievement WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO player_achievement (uuid, Achievements, AchievementPoints) VALUES ('" + player.getName() + "', 'NO', " + achievement + ")";
      } else {
        sql = "UPDATE player_achievement SET AchievementPoints = " + rs.getInt("AchievementPoints") + achievement + " WHERE uuid = '" + player.getName() + "';";
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static void UpdataLobbySettings(Player player, String Settings, String newData) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_lobbySettings WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO player_lobbySettings (player_name, + " + Settings + ") VALUES ('" + player.getName() + "', '" + newData + "');";
      } else {
        sql = "UPDATE player_lobbySettings SET " + Settings + " = '" + newData + "' WHERE player_name = '" + player.getName() + "';";
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static String QueryLobbySettings(Player player, String Settings) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_lobbySettings WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next())
        return rs.getString(Settings); 
      rs.close();
      statement.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static String FoundPlayerAchievementRewardState(Player player, String rewards) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_achievementsrewards WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next())
        return rs.getString(rewards); 
      rs.close();
      statement.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static Integer FoundPlayerAchievementReward(Player player) {
    int countOfTwos = 0;
    try {
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_achievementsrewards WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next())
        return Integer.valueOf(0); 
      List<Integer> integers = Arrays.asList(new Integer[] { Integer.valueOf(rs.getInt("Rewards_one")), 
            Integer.valueOf(rs.getInt("Rewards_two")), 
            Integer.valueOf(rs.getInt("Rewards_three")), 
            Integer.valueOf(rs.getInt("Rewards_four")), 
            Integer.valueOf(rs.getInt("Rewards_five")), 
            Integer.valueOf(rs.getInt("Rewards_six")), 
            Integer.valueOf(rs.getInt("Rewards_seven")) });
      for (Integer i : integers) {
        player.sendMessage("i");
        if (i.intValue() == 2)
          countOfTwos++; 
      } 
      rs.close();
      statement.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return Integer.valueOf(countOfTwos);
  }
  
  public static void setPlayerAchievementRewardState(Player player, String Reward, int NewState) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM player_achievementsrewards WHERE uuid = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next()) {
        sql = "UPDATE player_achievementsrewards SET " + Reward + " = '" + NewState + "' WHERE uuid = '" + player.getName() + "';";
        statement.execute(sql);
      } else {
        sql = "INSERT INTO player_achievementsrewards (uuid, + " + Reward + ") VALUES ('" + player.getName() + "', '" + Reward + "');";
        statement.executeUpdate(sql);
      } 
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static void setShopNormDiscount() {
    try {
      Connection connection = CatPixelLobby.dataSource.getConnection();
      try {
        Statement statement = connection.createStatement();
        try {
          String checkSql = "SELECT discount FROM lobby_shop WHERE discount NOT IN ('true', 'false') OR discount IS NULL";
          ResultSet rs = statement.executeQuery(checkSql);
          if (rs.next()) {
            String updateSql = "UPDATE lobby_shop SET discount = 'false' WHERE discount NOT IN ('true', 'false') OR discount IS NULL";
            statement.executeUpdate(updateSql);
            System.out.println("Updated invalid or null discount values to false in lobby_shop table");
          } else {
            System.out.println("All discount values in lobby_shop table are either true or false.");
          } 
          rs.close();
          if (statement != null)
            statement.close(); 
        } catch (Throwable throwable) {
          if (statement != null)
            try {
              statement.close();
            } catch (Throwable throwable1) {
              throwable.addSuppressed(throwable1);
            }  
          throw throwable;
        } 
        if (connection != null)
          connection.close(); 
      } catch (Throwable throwable) {
        if (connection != null)
          try {
            connection.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static void setShopDiscount(String NewDiscount) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT discount FROM lobby_shop";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next()) {
        sql = "UPDATE lobby_shop SET discount = '" + NewDiscount + "';";
        statement.executeUpdate(sql);
      } else {
        sql = "INSERT INTO lobby_shop (discount) VALUES ('" + NewDiscount + "');";
        statement.executeUpdate(sql);
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static String getLobbyShopDiscount() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT discount FROM lobby_shop";
      ResultSet rs = statement.executeQuery(sql);
      if (rs.next())
        return rs.getString("discount"); 
      rs.close();
      statement.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static void addFireworksAvailable(Player player, int Available) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_showfireworks WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_showfireworks (player_name, Available) VALUES ('" + player.getName() + "', " + Available + ")";
      } else {
        sql = "UPDATE lobby_showfireworks SET Available = " + rs.getInt("Available") + Available + " WHERE player_name = '" + player.getName() + "';";
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static int getFireworksAvailable(Player player) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_showfireworks WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_showfireworks (player_name, Available) VALUES ('" + player.getName() + "', 0)";
        statement.executeUpdate(sql);
        rs.close();
        return 0;
      } 
      return rs.getInt("Available");
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
      return 1;
    } 
  }
  
  public static String getFireworksAvailableString(Player player) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_showfireworks WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_showfireworks (player_name, Available) VALUES ('" + player.getName() + "', 0)";
        statement.executeUpdate(sql);
        rs.close();
      } 
      return rs.getString("Available");
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public static void addRewardNumber(Player player, int RewardNumber) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_reward WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_reward (player_name, Rewards_lockNumber) VALUES ('" + player.getName() + "', " + RewardNumber + ")";
      } else {
        sql = "UPDATE lobby_reward SET Rewards_lockNumber = " + rs.getInt("Rewards_lockNumber") + RewardNumber + " WHERE player_name = '" + player.getName() + "';";
      } 
      statement.executeUpdate(sql);
      rs.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static void removeRewardNumber(Player player, int RewardNumber) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_reward WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_reward (player_name, Rewards_lockNumber) VALUES ('" + player.getName() + "', " + -RewardNumber + ")";
      } else {
        int currentRewardNumber = rs.getInt("Rewards_lockNumber");
        int newRewardNumber = Math.max(currentRewardNumber - RewardNumber, 0);
        sql = "UPDATE lobby_reward SET Rewards_lockNumber = " + newRewardNumber + " WHERE player_name = '" + player.getName() + "';";
      } 
      statement.executeUpdate(sql);
      rs.close();
      statement.close();
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static int getRewardNumber(Player player) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = connect().createStatement();
      String sql = "SELECT * FROM lobby_reward WHERE player_name = '" + player.getName() + "'";
      ResultSet rs = statement.executeQuery(sql);
      if (!rs.next()) {
        sql = "INSERT INTO lobby_reward (player_name, Rewards_lockNumber) VALUES ('" + player.getName() + "', 0)";
        statement.executeUpdate(sql);
        rs.close();
        return 0;
      } 
      return rs.getInt("Rewards_lockNumber");
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
      return 1;
    } 
  }
}
