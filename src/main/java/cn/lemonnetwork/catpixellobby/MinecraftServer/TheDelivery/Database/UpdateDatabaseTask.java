package cn.lemonnetwork.catpixellobby.MinecraftServer.TheDelivery.Database;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import org.bukkit.scheduler.BukkitRunnable;

public class UpdateDatabaseTask extends BukkitRunnable {
  public void run() {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(11);
    int minute = calendar.get(12);
    int dayOfMonth = calendar.get(5);
    if (hour == 0 && minute == 0)
      try {
        Connection connection = CatPixelLobby.dataSource.getConnection();
        try {
          Statement statement = connection.createStatement();
          try {
            String sql;
            if (dayOfMonth != 1) {
              sql = "UPDATE player_data SET Day = 'false'";
            } else {
              sql = "UPDATE player_data SET Normal = 'false', VIP = 'false', VIPplus = 'false', MVP = 'false', MVPplus = 'false'";
            } 
            statement.executeUpdate(sql);
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
}
