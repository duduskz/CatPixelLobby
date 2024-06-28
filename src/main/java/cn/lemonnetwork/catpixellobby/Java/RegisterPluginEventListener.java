package cn.lemonnetwork.catpixellobby.Java;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.AchievementList;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.CatPixelLobbyCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.FlyCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp.NewPlayerHelpCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp.onMoveCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.Playerhelp.onVanishCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.SpawnCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.SpawnsetCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.SummerRewardsCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.VanishCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.adminCommand.KaboomCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.adminCommand.blockcommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.connectCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.setServerType;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Command.setShopDiscountCommand;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Scoreboard.BedWarsScoreBoard;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Scoreboard.LobbyScoreBoard;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.PlaceholdersHook;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.Assemble;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.AssembleAdapter;
import cn.lemonnetwork.catpixellobby.MinecraftServer.chat.BedWarsLobbyChat;
import cn.lemonnetwork.catpixellobby.MinecraftServer.chat.LobbyChat;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.ClickEvent;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.NoWeather;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.PlayerEvent;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.PlayerJoinRewardsMessage;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.PlayerListener;
import cn.lemonnetwork.catpixellobby.MinecraftServer.event.VipJoinMessage;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.init.InventoryListener;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.item.LobbyItems;
import cn.lemonnetwork.catpixellobby.MinecraftServer.menu.ShopMenu.ShopMenu;
import cn.lemonnetwork.catpixellobby.TheDelivery.BedWarsLobbyTheDelivery;
import cn.lemonnetwork.catpixellobby.TheDelivery.LobbyTheDelivery;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class RegisterPluginEventListener {
  public static String serverType;
  
  static CatPixelLobby plugin = (CatPixelLobby)CatPixelLobby.getPlugin(CatPixelLobby.class);
  
  public static void regBukkitPluginManagerEvent() {
    serverType = plugin.getConfig().getString("ServerSettings.ServerType");
    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel((Plugin)plugin, "BungeeCord");
    plugin.getConfig().options().copyDefaults(true);
    plugin.saveConfig();
    if (serverType.equalsIgnoreCase("LOBBY")) {
      loadLobbyScoreBoard();
      Bukkit.getPluginManager().registerEvents((Listener)new LobbyChat(), (Plugin)plugin);
    } else if (serverType.equalsIgnoreCase("BW_LOBBY")) {
      loadBedWarsLobbyScoreBoard();
      Bukkit.getPluginManager().registerEvents((Listener)new BedWarsLobbyChat(), (Plugin)plugin);
    } 
    Bukkit.getPluginManager().registerEvents((Listener)new ClickEvent(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoinRewardsMessage(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new NoWeather(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new PlayerEvent(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new VipJoinMessage(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new LobbyItems(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new ShopMenu(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new InventoryListener(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new AchievementList(), (Plugin)plugin);
    Bukkit.getPluginManager().registerEvents((Listener)new setShopDiscountCommand(), (Plugin)plugin);
    MySQL.setShopNormDiscount();
    (new PlaceholdersHook()).canRegister();
    (new PlaceholdersHook()).register();
    Bukkit.getConsoleSender().sendMessage("§a[CatPixelLobby] §a插件事件注册完成！");
  }
  
  public static void regBukkitPluginCommandEvent() {
    plugin.getCommand("SummerRewards").setExecutor((CommandExecutor)new SummerRewardsCommand());
    plugin.getCommand("dontmove").setExecutor((CommandExecutor)new onMoveCommand());
    plugin.getCommand("playerhelpvanish").setExecutor((CommandExecutor)new onVanishCommand());
    plugin.getCommand("playerhelp").setExecutor((CommandExecutor)new NewPlayerHelpCommand());
    if (serverType.equalsIgnoreCase("LOBBY")) {
      plugin.getCommand("thedeliverys").setExecutor((CommandExecutor)new LobbyTheDelivery());
    } else if (serverType.equalsIgnoreCase("BW_LOBBY")) {
      plugin.getCommand("thedeliverys").setExecutor((CommandExecutor)new BedWarsLobbyTheDelivery());
    } 
    plugin.getCommand("spawn").setExecutor((CommandExecutor)new SpawnCommand());
    plugin.getCommand("setspawn").setExecutor((CommandExecutor)new SpawnsetCommand());
    plugin.getCommand("fly").setExecutor((CommandExecutor)new FlyCommand());
    plugin.getCommand("飞行").setExecutor((CommandExecutor)new FlyCommand());
    plugin.getCommand("vanish").setExecutor((CommandExecutor)new VanishCommand());
    plugin.getCommand("隐身").setExecutor((CommandExecutor)new VanishCommand());
    plugin.getCommand("connect").setExecutor((CommandExecutor)new connectCommand());
    plugin.getCommand("kaboom").setExecutor((CommandExecutor)new KaboomCommand());
    plugin.getCommand("LobbyEdit").setExecutor((CommandExecutor)new blockcommand());
    plugin.getCommand("setShopDiscountCommand").setExecutor((CommandExecutor)new setShopDiscountCommand());
    plugin.getCommand("setServerType").setExecutor((CommandExecutor)new setServerType());
    plugin.getCommand("CatPixelLobby").setExecutor((CommandExecutor)new CatPixelLobbyCommand());
  }
  
  public static void regMySQL() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Statement statement = MySQL.connect().createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS player_achievement (uuid TEXT(200), Achievements TEXT(200), AchievementPoints INT(200));";
      statement.executeUpdate(sql);
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    } 
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:mysql://" + CatPixelLobby.getInstance().getConfig().getString("MySQL.url") + ":" + CatPixelLobby.getInstance().getConfig().getString("MySQL.port") + "/" + CatPixelLobby.getInstance().getConfig().getString("MySQL.db"));
    config.setUsername(CatPixelLobby.getInstance().getConfig().getString("MySQL.username"));
    config.setPassword(CatPixelLobby.getInstance().getConfig().getString("MySQL.password"));
    config.setMaximumPoolSize(900000);
    config.setMinimumIdle(10);
    config.setMaxLifetime(1800000L);
    config.setConnectionTimeout(50000L);
    CatPixelLobby.dataSource = new HikariDataSource(config);
    createTable("player_reward", "uuid TEXT(200),Day TEXT(200), Normal TEXT(200), VIP TEXT(200), VIPplus TEXT(200), MVP TEXT(200), MVPplus TEXT(200), NewPlayer TEXT(200)");
    createTable("player_achievementsrewards", "uuid TEXT(200),Rewards_one TEXT(200), Rewards_two TEXT(200), Rewards_three TEXT(200), Rewards_four TEXT(200), Rewards_five TEXT(200), Rewards_six TEXT(200), Rewards_seven TEXT(200)");
    createTable("player_achievements", "player TEXT(200),FirstJoinHypixel TEXT(200)");
    createTable("lobby_shop", "discount TEXT");
    createTable("player_vanishes", "name TEXT");
    createTable("player_subject", "player_name TEXT, Subject TEXT");
    createTable("player_lobbySettings", "player_name TEXT, editmode TEXT");
    createTable("lobby_reward", "player_name TEXT, Rewards_lockNumber TEXT, State TEXT");
    createTable("lobby_ShowFireworks", "player_name TEXT, Available TEXT");
  }
  
  static void createTable(String table, String key) {
    try {
      Connection conn = CatPixelLobby.dataSource.getConnection();
      PreparedStatement pre = conn.prepareStatement(String.format("CREATE TABLE IF NOT EXISTS %s(%s);", new Object[] { table, key }));
      pre.executeUpdate();
      pre.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public static void loadLobbyScoreBoard() {
    Assemble assemble = new Assemble((JavaPlugin)plugin, (AssembleAdapter)new LobbyScoreBoard());
    assemble.setTicks(4L);
  }
  
  public static void loadBedWarsLobbyScoreBoard() {
    Assemble assemble = new Assemble((JavaPlugin)plugin, (AssembleAdapter)new BedWarsScoreBoard());
    assemble.setTicks(4L);
  }
}
