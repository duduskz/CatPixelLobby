package cn.lemonnetwork.catpixellobby.MinecraftServer.TheDelivery;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtil;
import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import com.yapzhenyie.GadgetsMenu.utils.mysteryboxes.MysteryBoxType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Menu implements CommandExecutor, Listener {
  //TheDelivery 下的代码均为赵泽民大神侵犯 LemonNetwork 著作权对 LemonDeliveryMan进行反编译操作。人不犯我，我不犯人~！
  //LemonDeliveryMan 在 Github 上属于GPL 3.0 开源协议项目，赵泽民大神无视开源协议进行copy操作并填写作者为DaMao_OVO
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    Inventory inventory = Bukkit.createInventory(null, 54, "礼包使者");
    inventory.setItem(20, NormalItem(player));
    inventory.setItem(21, VIPItem(player));
    inventory.setItem(22, VIPplusItem(player));
    inventory.setItem(23, MVPItem(player));
    inventory.setItem(24, MVPplusItem(player));
    inventory.setItem(30, NewPlayerItem(player));
    inventory.setItem(31, getDayItem(player));
    inventory.setItem(32, CodeItem(player));
    player.openInventory(inventory);
    return false;
  }
  
  private ItemStack CodeItem(Player player) {
    ArrayList<String> lore = new ArrayList<>();
    String disname = "null";
    disname = "§a使用兑换码";
    lore.add("§7使用§e/chinaredeem(兑换码)§7来兑换！");
    Material material = Material.SIGN;
    return ItemUtil.CreateItem(material, disname, lore);
  }
  
  private ItemStack NewPlayerItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      rs.next();
      if (rs.getString("NewPlayer").equalsIgnoreCase("false")) {
        disname = "§a欢迎礼包";
        lore.add("§7欢迎来到CatPixel！");
        lore.add("§7领取一些免费的金币、");
        lore.add("§7经验及神秘宝箱，来帮");
        lore.add("§7助你入门。");
        lore.add("");
        lore.add("§e点击此处领取！");
        material = Material.ENCHANTMENT_TABLE;
        lore.add("");
      } else {
        disname = "§a欢迎礼包";
        lore.add("§7欢迎来到CatPixel！");
        lore.add("§7领取一些免费的金币、");
        lore.add("§7经验及神秘宝箱，来帮");
        lore.add("§7助你入门。");
        lore.add("");
        lore.add("§c你已经领取了这个礼包！");
        material = Material.ENCHANTMENT_TABLE;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack MVPplusItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      Calendar calendar = Calendar.getInstance();
      int currentMonth = calendar.get(2) + 1;
      rs.next();
      if (rs.getString("MVPplus").equalsIgnoreCase("false")) {
        if (player.hasPermission("catpixel.reward.mvp+")) {
          disname = "§a神秘箱礼包";
        } else {
          disname = "§c神秘箱礼包";
        } 
        lore.add("§7拥有会员等级的玩家每30天可领取§b5§7个神秘箱奖励！");
        lore.add("");
        lore.add("§7需要会员等级§bMVP§c+");
        lore.add("");
        if (player.hasPermission("catpixel.reward.mvp+")) {
          lore.add("§e点击领取");
        } else {
          lore.add("§c点击领取");
        } 
        material = Material.ENDER_CHEST;
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(2, 1);
        nextMonth.set(5, 1);
        nextMonth.set(11, 0);
        nextMonth.set(12, 0);
        nextMonth.set(13, 0);
        nextMonth.set(14, 0);
        long remainingTime = nextMonth.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long days = remainingSeconds / 86400L;
        long hours = remainingSeconds % 86400L / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c神秘箱礼包";
        lore.add("§7你已经领取了这个礼包，请下次再来！");
        lore.add("");
        lore.add("§7下次礼包送达：  " + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = Material.ENDER_CHEST;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack VIPplusItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      Calendar calendar = Calendar.getInstance();
      int currentMonth = calendar.get(2) + 1;
      rs.next();
      if (rs.getString("VIPplus").equalsIgnoreCase("false")) {
        if (player.hasPermission("catpixel.reward.vip+")) {
          disname = "§a神秘箱礼包";
        } else {
          disname = "§c神秘箱礼包";
        } 
        lore.add("§7拥有会员等级的玩家每30天可领取§b5§7个神秘箱奖励！");
        lore.add("");
        lore.add("§7需要会员等级§aVIP§c+");
        lore.add("");
        if (player.hasPermission("catpixel.reward.vip+")) {
          lore.add("§e点击领取");
        } else {
          lore.add("§c点击领取");
        } 
        material = Material.ENDER_CHEST;
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(2, 1);
        nextMonth.set(5, 1);
        nextMonth.set(11, 0);
        nextMonth.set(12, 0);
        nextMonth.set(13, 0);
        nextMonth.set(14, 0);
        long remainingTime = nextMonth.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long days = remainingSeconds / 86400L;
        long hours = remainingSeconds % 86400L / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c神秘箱礼包";
        lore.add("§7你已经领取了这个礼包，请下次再来！");
        lore.add("");
        lore.add("§7下次礼包送达：  " + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = Material.ENDER_CHEST;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack VIPItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      Calendar calendar = Calendar.getInstance();
      int currentMonth = calendar.get(2) + 1;
      rs.next();
      if (rs.getString("VIP").equalsIgnoreCase("false")) {
        if (player.hasPermission("catpixel.reward.vip")) {
          disname = "§a神秘箱礼包";
        } else {
          disname = "§c神秘箱礼包";
        } 
        lore.add("§7拥有会员等级的玩家每30天可领取§b5§7个神秘箱奖励！");
        lore.add("");
        lore.add("§7需要会员等级§aVIP");
        lore.add("");
        if (player.hasPermission("catpixel.reward.vip")) {
          lore.add("§e点击领取");
        } else {
          lore.add("§c点击领取");
        } 
        material = Material.ENDER_CHEST;
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(2, 1);
        nextMonth.set(5, 1);
        nextMonth.set(11, 0);
        nextMonth.set(12, 0);
        nextMonth.set(13, 0);
        nextMonth.set(14, 0);
        long remainingTime = nextMonth.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long days = remainingSeconds / 86400L;
        long hours = remainingSeconds % 86400L / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c神秘箱礼包";
        lore.add("§7你已经领取了这个礼包，请下次再来！");
        lore.add("");
        lore.add("§7下次礼包送达：  " + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = Material.ENDER_CHEST;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack MVPItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      Calendar calendar = Calendar.getInstance();
      int currentMonth = calendar.get(2) + 1;
      rs.next();
      if (rs.getString("MVP").equalsIgnoreCase("false")) {
        if (player.hasPermission("catpixel.reward.mvp")) {
          disname = "§a神秘箱礼包";
        } else {
          disname = "§c神秘箱礼包";
        } 
        lore.add("§7拥有会员等级的玩家每30天可领取§b5§7个神秘箱奖励！");
        lore.add("");
        lore.add("§7需要会员等级§bMVP");
        lore.add("");
        if (player.hasPermission("catpixel.reward.mvp")) {
          lore.add("§e点击领取");
        } else {
          lore.add("§c点击领取");
        } 
        material = Material.ENDER_CHEST;
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(2, 1);
        nextMonth.set(5, 1);
        nextMonth.set(11, 0);
        nextMonth.set(12, 0);
        nextMonth.set(13, 0);
        nextMonth.set(14, 0);
        long remainingTime = nextMonth.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long days = remainingSeconds / 86400L;
        long hours = remainingSeconds % 86400L / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c神秘箱礼包";
        lore.add("§7你已经领取了这个礼包，请下次再来！");
        lore.add("");
        lore.add("§7下次礼包送达：  " + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = Material.ENDER_CHEST;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack NormalItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "null";
      Calendar calendar = Calendar.getInstance();
      int currentMonth = calendar.get(2) + 1;
      int month = calendar.get(2) + 1;
      String chineseMonth = null;
      switch (month) {
        case 1:
          chineseMonth = "一月";
          break;
        case 2:
          chineseMonth = "二月";
          break;
        case 3:
          chineseMonth = "三月";
          break;
        case 4:
          chineseMonth = "四月";
          break;
        case 5:
          chineseMonth = "五月";
          break;
        case 6:
          chineseMonth = "六月";
          break;
        case 7:
          chineseMonth = "七月";
          break;
        case 8:
          chineseMonth = "八月";
          break;
        case 9:
          chineseMonth = "九月";
          break;
        case 10:
          chineseMonth = "十月";
          break;
        case 11:
          chineseMonth = "十一月";
          break;
        case 12:
          chineseMonth = "十二月";
          break;
        default:
          chineseMonth = "";
          break;
      } 
      rs.next();
      if (rs.getString("Normal").equalsIgnoreCase("false")) {
        disname = "§a神秘箱礼包";
        lore.add("§7你在" + chineseMonth + "的每月免费一星神秘箱已经送达！");
        lore.add("");
        lore.add("§e点击领取");
        material = (new ItemStack(Material.ENDER_CHEST, 1)).getType();
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar nextMonth = Calendar.getInstance();
        nextMonth.add(2, 1);
        nextMonth.set(5, 1);
        nextMonth.set(11, 0);
        nextMonth.set(12, 0);
        nextMonth.set(13, 0);
        nextMonth.set(14, 0);
        long remainingTime = nextMonth.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long days = remainingSeconds / 86400L;
        long hours = remainingSeconds % 86400L / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c神秘箱礼包";
        lore.add("§7你已经领取了这个礼包，请下次再来！");
        lore.add("");
        lore.add("§7下次礼包送达：  " + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = (new ItemStack(Material.ENDER_CHEST, 1)).getType();
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private ItemStack getDayItem(Player player) {
    try {
      Material material;
      Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      ArrayList<String> lore = new ArrayList<>();
      String disname = "Null";
      rs.next();
      if (rs.getString("Day").equalsIgnoreCase("false")) {
        disname = "§a每日奖励";
        lore.add("§72000点免费CatPixel经验和3000个免费的街机硬币！");
        lore.add("");
        lore.add("§e点击领取！");
        material = Material.STORAGE_MINECART;
        lore.add("");
      } else {
        Calendar now = Calendar.getInstance();
        Calendar tomorrowStart = Calendar.getInstance();
        tomorrowStart.add(6, 1);
        tomorrowStart.set(11, 0);
        tomorrowStart.set(12, 0);
        tomorrowStart.set(13, 0);
        tomorrowStart.set(14, 0);
        long remainingTime = tomorrowStart.getTimeInMillis() - now.getTimeInMillis();
        long remainingSeconds = remainingTime / 1000L;
        long hours = remainingSeconds / 3600L;
        long minutes = remainingSeconds % 3600L / 60L;
        long seconds = remainingSeconds % 60L;
        disname = "§c每日奖励";
        lore.add("§7今天你已经领取了这个奖励！");
        lore.add("");
        lore.add("§7请在" + hours + "小时" + minutes + "分钟" + seconds + "秒后领取！");
        lore.add("");
        lore.add("§c下次在来吧 :)");
        material = Material.MINECART;
      } 
      return ItemUtil.CreateItem(material, disname, lore);
    } catch (SQLException exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private void CodeSet(Player player) {
    player.sendMessage("§c对接网易数据库失败，请联系管理员后重试！");
    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
    player.closeInventory();
  }
  
  private void NewPlayerReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (rs.getString("NewPlayer").equalsIgnoreCase("false")) {
        player.performCommand("thedeliverys");
        player.sendMessage("§a你获得了免费的§35,000CatPixel大厅经验§a和§61,000街机硬币§a以及§b5个一星神秘箱");
        AlonsoLevelsAPI.addExperience(player.getUniqueId(), 5000);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
        statement.executeUpdate("UPDATE player_reward SET NewPlayer = 'true' WHERE uuid = '" + player.getName().toString() + "'");
        player.getOpenInventory().setItem(30, NewPlayerItem(player));
      } else {
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
        player.sendMessage("§c你已经领取了这个奖励！");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void NormalReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (rs.getString("Normal").equalsIgnoreCase("false")) {
        player.sendMessage("§a你获得了1个一星神秘箱！");
        player.performCommand("thedeliverys");
        PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
        playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_1, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 1);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
        statement.executeUpdate("UPDATE player_reward SET Normal = 'true' WHERE uuid = '" + player.getName().toString() + "'");
        player.getOpenInventory().setItem(20, NormalItem(player));
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c你已经领取了这个奖励，下次再来吧！");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void dayReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (rs.getString("Day").equalsIgnoreCase("false")) {
        player.sendMessage("§a你获得了免费的§32,000CatPixel大厅经验§a和§63,000街机硬币");
        AlonsoLevelsAPI.addExperience(player.getUniqueId(), 2000);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
        statement.executeUpdate("UPDATE player_reward SET Day = 'true' WHERE uuid = '" + player.getName().toString() + "'");
        player.getOpenInventory().setItem(31, getDayItem(player));
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c今天你已经领取了这个奖励，稍后在来领取吧！");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void VIPReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (player.hasPermission("catpixel.reward.vip")) {
        if (rs.getString("VIP").equalsIgnoreCase("false")) {
          player.sendMessage("§a你获得了5个两星神秘箱！");
          player.performCommand("thedeliverys");
          PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
          playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_2, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
          player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
          statement.executeUpdate("UPDATE player_reward SET VIP = 'true' WHERE uuid = '" + player.getName().toString() + "'");
          player.getOpenInventory().setItem(21, VIPItem(player));
        } else {
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          player.sendMessage("§c你已经领取了这个奖励，下次再来吧！");
          player.closeInventory();
        } 
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c你的会员等级不足，无法领取此奖励！");
        player.sendMessage("§c请在§bCatPixel商城页面§c购买会员等级");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void VIPplusReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (player.hasPermission("catpixel.reward.vip+")) {
        if (rs.getString("VIPplus").equalsIgnoreCase("false")) {
          player.sendMessage("§a你获得了5个三星神秘箱！");
          player.performCommand("thedeliverys");
          PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
          playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_3, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
          player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
          statement.executeUpdate("UPDATE player_reward SET VIPplus = 'true' WHERE uuid = '" + player.getName().toString() + "'");
          player.getOpenInventory().setItem(22, VIPplusItem(player));
        } else {
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          player.sendMessage("§c你已经领取了这个奖励，下次再来吧！");
          player.closeInventory();
        } 
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c你的会员等级不足，无法领取此奖励！");
        player.sendMessage("§c请在§b器CatPixel商城页面§c购买会员等级");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void MVPReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (player.hasPermission("catpixel.reward.mvp")) {
        if (rs.getString("MVP").equalsIgnoreCase("false")) {
          player.sendMessage("§a你获得了5个四星神秘箱！");
          player.performCommand("thedeliverys");
          PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
          playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_5, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
          player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
          statement.executeUpdate("UPDATE player_reward SET MVP = 'true' WHERE uuid = '" + player.getName().toString() + "'");
          player.getOpenInventory().setItem(23, MVPItem(player));
        } else {
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          player.sendMessage("§c你已经领取了这个奖励，下次再来吧！");
          player.closeInventory();
        } 
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c你的会员等级不足，无法领取此奖励！");
        player.sendMessage("§c请在§bCatPixel商城页面§c购买会员等级");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  private void MVPplusReward(Player player) {
    try {
      ResultSet rs = CatPixelLobby.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM player_reward WHERE uuid = '" + player.getName().toString() + "'");
      rs.next();
      if (player.hasPermission("catpixel.reward.mvp+")) {
        if (rs.getString("MVPplus").equalsIgnoreCase("false")) {
          player.sendMessage("§a你获得了5个五星神秘箱！");
          player.performCommand("thedeliverys");
          PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
          playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_5, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
          player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
          Statement statement = CatPixelLobby.dataSource.getConnection().createStatement();
          statement.executeUpdate("UPDATE player_reward SET MVPplus = 'true' WHERE uuid = '" + player.getName().toString() + "'");
          player.getOpenInventory().setItem(24, MVPplusItem(player));
        } else {
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          player.sendMessage("§c你已经领取了这个奖励，下次再来吧！");
          player.closeInventory();
        } 
      } else {
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        player.sendMessage("§c你的会员等级不足，无法领取此奖励！");
        player.sendMessage("§c请在§bCatPixel商城页面§c购买会员等级");
        player.closeInventory();
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  @EventHandler
  public void click(InventoryClickEvent event) {
    try {
      Player player = (Player)event.getWhoClicked();
      if (event.getInventory().getTitle().equalsIgnoreCase("礼包使者")) {
        event.setCancelled(true);
        if (event.getSlot() == 32)
          CodeSet(player); 
        if (event.getSlot() == 30)
          NewPlayerReward(player); 
        if (event.getSlot() == 31)
          dayReward(player); 
        if (event.getSlot() == 20)
          NormalReward(player); 
        if (event.getSlot() == 21)
          VIPReward(player); 
        if (event.getSlot() == 22)
          VIPplusReward(player); 
        if (event.getSlot() == 23)
          MVPReward(player); 
        if (event.getSlot() == 24)
          MVPplusReward(player); 
      } 
    } catch (NullPointerException nullPointerException) {}
  }
}
