package cn.lemonnetwork.catpixellobby;

import cn.lemonnetwork.catpixellobby.Database.DataBase;
import cn.lemonnetwork.catpixellobby.Java.RegisterPluginEventListener;
import cn.lemonnetwork.catpixellobby.LeaderBoard.HologramsManager;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.Events;
import cn.lemonnetwork.catpixellobby.LeaderBoard.database.MongoDB;
import cn.lemonnetwork.catpixellobby.LeaderBoard.gui.Menu;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CatPixelLobby extends JavaPlugin {

  //CatPixelLobby Crack 赵泽民反编译大神出品 LemonNetwork 破解
  //请！注！意！
  //此插件属于CatPixelLobby反编译项目，如侵权，LemonNetwork不负任何法律责任
  //该插件的 DeliveryMan 及 Achievement 代码均为作者赵泽民非法侵犯我工作室著作权代码
  //LemonDeliveryMan 在 duduskz 资源库下属于 GPL3.0 开源协议项目
  //LeaderBoard代码为 StarryCountry-Development 作品
  //使用或利用时请考虑版权问题！
  //本项目同样为 GPL3.0 协议
  //请遵守开源社区精神，我们应该反对赵泽民这种老鼠屎！
  //可笑的是，赵泽民大神的大量写代码习惯全部来源于LemonNetwork，例如 MySQL 连接 去看Config就知道了、类名大写这种低级错误

  private HologramsManager hologramManager;
  
  public static String serverType;
  
  public static CatPixelLobby instance;
  
  private DataBase dataBase;
  
  private MongoDB database;
  
  public static HikariDataSource dataSource;
  
  public static CatPixelLobby getInstance() {
    return instance;
  }
  
  public DataBase getDataBase() {
    return this.dataBase;
  }
  
  private static final HashMap<Player, Integer> downs = new HashMap<>();
  
  public void onEnable() {
    instance = this;
    serverType = getInstance().getConfig().getString("ServerSettings.ServerType");
    RegisterPluginEventListener.regMySQL();
    RegisterPluginEventListener.regBukkitPluginManagerEvent();
    RegisterPluginEventListener.regBukkitPluginCommandEvent();

    Bukkit.getConsoleSender().sendMessage("CatPixelLobby Crack 赵泽民反编译大神出品 LemonNetwork 破解");
    Bukkit.getConsoleSender().sendMessage("请！注！意！");
    Bukkit.getConsoleSender().sendMessage("此插件属于CatPixelLobby反编译项目，如侵权，LemonNetwork不负任何法律责任");
    Bukkit.getConsoleSender().sendMessage("该插件的 DeliveryMan 及 Achievement 代码均为作者赵泽民非法侵犯我工作室著作权代码");
    Bukkit.getConsoleSender().sendMessage("LemonDeliveryMan 在 duduskz 资源库下属于 GPL3.0 开源协议项目");
    Bukkit.getConsoleSender().sendMessage("LeaderBoard代码为 StarryCountry-Development 作品");
    Bukkit.getConsoleSender().sendMessage("使用或利用时请考虑版权问题！");
    Bukkit.getConsoleSender().sendMessage("本项目同样为 GPL3.0 协议");
    Bukkit.getConsoleSender().sendMessage("请遵守开源社区精神，我们应该反对赵泽民这种老鼠屎！");
    Bukkit.getConsoleSender().sendMessage("可笑的是，赵泽民大神的大量写代码习惯全部来源于LemonNetwork，例如 MySQL 连接 去看Config就知道了、类名大写这种低级错误");

    if (serverType.equalsIgnoreCase("BW_LOBBY")) {
      this.database = new MongoDB();
      this.hologramManager = new HologramsManager();
      Bukkit.getPluginManager().registerEvents((Listener)new Events(), (Plugin)this);
      Bukkit.getPluginManager().registerEvents((Listener)new Menu(), (Plugin)this);
    } 
  }
  
  public void onDisable() {}
  
  public HologramsManager getHologramManager() {
    return this.hologramManager;
  }
  
  public MongoDB getData() {
    return this.database;
  }
}
