package cn.lemonnetwork.catpixellobby.MinecraftServer.menu.ShopMenu;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import java.util.ArrayList;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
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
import org.bukkit.inventory.meta.ItemMeta;

public class ShopMenu implements CommandExecutor, Listener {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    Inventory inventory = Bukkit.createInventory(null, 54, "CatPixel商城");
    inventory.setItem(10, VIPItem(player));
    inventory.setItem(12, VIP_PLUSItem(player));
    inventory.setItem(14, MVPItem(player));
    inventory.setItem(16, MVP_PLUSItem(player));
    player.openInventory(inventory);
    return false;
  }
  
  private ItemStack VIPItem(Player player) {
    ItemStack vipitem = new ItemStack(Material.EMERALD);
    ItemMeta vipmeta = vipitem.getItemMeta();
    ArrayList<String> lore = new ArrayList<>();
    String name = "null";
    name = "§aVIP §6§l永久";
    lore.add("§f");
    lore.add("§f需要花费: §e10点券(10元人民币)");
    lore.add("§f你现在的点券数量是： §b" + watchPoints(player) + "§b点券");
    lore.add("§f");
    lore.add("§f会员时长: §6§l永久");
    lore.add("§f");
    lore.add("§e§l左击购买这个商品！");
    lore.add("§e§l右键查看此商品的权益！");
    vipmeta.setLore(lore);
    vipmeta.setDisplayName(name);
    vipitem.setItemMeta(vipmeta);
    return vipitem;
  }
  
  private void VIPItemClickEvent(Player player) {
    try {
      if (player.hasPermission("catpixelrank.vip")) {
        player.sendMessage("§c你已经购买了这个会员等级，或者你已经拥有了比这个等级更高的等级。购买订单已取消！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else if (!haveEnoughPoints(player, 10)) {
        player.sendMessage("§c你没有足够的点券，购买订单已取消！");
        player.sendMessage("§c你可以输入§b/b§c指令查看充值系统帮助！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else {
        player.sendMessage("§a你购买了VIP会员，有效期至: §e永久！");
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set vip");
        removePoints(player, 10);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        String name = "商品？";
        String lore = "在CatPixel服务器中购买一个商品";
        Achievement.Unlock(player, name, lore, "BuyCatPixelShop", Integer.valueOf(10));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private ItemStack VIP_PLUSItem(Player player) {
    ItemStack vipitem = new ItemStack(Material.EMERALD);
    ItemMeta vipmeta = vipitem.getItemMeta();
    ArrayList<String> lore = new ArrayList<>();
    String name = "null";
    name = "§aVIP§c+ §6§l永久";
    lore.add("§f");
    lore.add("§f需要花费: §e20点券(20元人民币)");
    lore.add("§f你现在的点券数量是： §b" + watchPoints(player) + "§b点券");
    lore.add("§f");
    lore.add("§f会员时长: §6§l永久");
    lore.add("§f");
    lore.add("§e§l左击购买这个商品！");
    lore.add("§e§l右键查看此商品的权益！");
    vipmeta.setLore(lore);
    vipmeta.setDisplayName(name);
    vipitem.setItemMeta(vipmeta);
    return vipitem;
  }
  
  private void VIP_PLUSItemClickEvent(Player player) {
    try {
      if (player.hasPermission("catpixelrank.vip_plus")) {
        player.sendMessage("§c你已经购买了这个会员等级，或者你已经拥有了比这个等级更高的等级。购买订单已取消！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else if (!haveEnoughPoints(player, 20)) {
        player.sendMessage("§c你没有足够的点券，购买订单已取消！");
        player.sendMessage("§c你可以输入§b/b§c指令查看充值系统帮助！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else {
        player.sendMessage("§a你购买了VIP§c+§a会员，有效期至: §e永久！");
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set vip_plus");
        removePoints(player, 20);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        String name = "商品？";
        String lore = "在CatPixel服务器中购买一个商品";
        Achievement.Unlock(player, name, lore, "BuyCatPixelShop", Integer.valueOf(10));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private ItemStack MVPItem(Player player) {
    ItemStack vipitem = new ItemStack(Material.DIAMOND);
    ItemMeta vipmeta = vipitem.getItemMeta();
    ArrayList<String> lore = new ArrayList<>();
    String name = "null";
    name = "§bMVP §6§l永久";
    lore.add("§f");
    lore.add("§f需要花费: §e30点券(30元人民币)");
    lore.add("§f你现在的点券数量是： §b" + watchPoints(player) + "§b点券");
    lore.add("§f");
    lore.add("§f会员时长: §6§l永久");
    lore.add("§f");
    lore.add("§e§l左击购买这个商品！");
    lore.add("§e§l右键查看此商品的权益！");
    vipmeta.setLore(lore);
    vipmeta.setDisplayName(name);
    vipitem.setItemMeta(vipmeta);
    return vipitem;
  }
  
  private void MVPItemClickEvent(Player player) {
    try {
      if (player.hasPermission("catpixelrank.mvp")) {
        player.sendMessage("§c你已经购买了这个会员等级，或者你已经拥有了比这个等级更高的等级。购买订单已取消！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else if (!haveEnoughPoints(player, 30)) {
        player.sendMessage("§c你没有足够的点券，购买订单已取消！");
        player.sendMessage("§c你可以输入§b/b§c指令查看充值系统帮助！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else {
        player.sendMessage("§a你购买了§bMVP§a会员，有效期至: §e永久！");
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set mvp");
        removePoints(player, 30);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        String name = "商品？";
        String lore = "在CatPixel服务器中购买一个商品";
        Achievement.Unlock(player, name, lore, "BuyCatPixelShop", Integer.valueOf(10));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private ItemStack MVP_PLUSItem(Player player) {
    ItemStack vipitem = new ItemStack(Material.DIAMOND);
    ItemMeta vipmeta = vipitem.getItemMeta();
    ArrayList<String> lore = new ArrayList<>();
    String name = "null";
    name = "§bMVP§c+ §6§l永久";
    lore.add("§f");
    lore.add("§f需要花费: §e38点券(38元人民币)");
    lore.add("§f你现在的点券数量是： §b" + watchPoints(player) + "§b点券");
    lore.add("§f");
    lore.add("§f会员时长: §6§l永久");
    lore.add("§f");
    lore.add("§e§l左击购买这个商品！");
    lore.add("§e§l右键查看此商品的权益！");
    vipmeta.setLore(lore);
    vipmeta.setDisplayName(name);
    vipitem.setItemMeta(vipmeta);
    return vipitem;
  }
  
  private void MVP_PLUSItemClickEvent(Player player) {
    try {
      if (player.hasPermission("catpixelrank.mvp_plus")) {
        player.sendMessage("§c你已经购买了这个会员等级，或者你已经拥有了比这个等级更高的等级。购买订单已取消！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else if (!haveEnoughPoints(player, 38)) {
        player.sendMessage("§c你没有足够的点券，购买订单已取消！");
        player.sendMessage("§c你可以输入§b/b§c指令查看充值系统帮助！");
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
      } else {
        player.sendMessage("§a你购买了§bMVP§c+§a会员，有效期至: §e永久！");
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set mvp_plus");
        removePoints(player, 38);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        String name = "商品？";
        String lore = "在CatPixel服务器中购买一个商品";
        Achievement.Unlock(player, name, lore, "BuyCatPixelShop", Integer.valueOf(10));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  @EventHandler
  public void click(InventoryClickEvent event) {
    try {
      Player player = (Player)event.getWhoClicked();
      if (event.getInventory().getTitle().equalsIgnoreCase("CatPixel商城")) {
        event.setCancelled(true);
        if (event.getSlot() == 10)
          if (event.getClick().isLeftClick()) {
            VIPItemClickEvent(player);
          } else if (event.getClick().isRightClick()) {
            player.sendMessage("§aVIP会员权限解锁项目：");
            player.sendMessage("");
            player.sendMessage("§f1. §e在大厅可以使用 §b/fw §e| §b/firework§e 指令发射烟花");
            player.sendMessage("§f2. §e可以在大厅使用 §b/fly §e指令进行飞行");
            player.sendMessage("§f3. §e拥有 §a[VIP] §e的称号前缀");
            player.sendMessage("§f4. §e可以领取VIP专属每月礼包");
            player.sendMessage("§f5. §e加入大厅获得 §a[VIP]" + player.getDisplayName() + "§6加入了服务器！ §e的消息通知");
            player.sendMessage("§f6. §e部分商品价格可以享受优惠");
            player.sendMessage("§f7. §e天坑乱斗 稀有物品 获取概率增加 §a0.4%");
            player.sendMessage("§f8. §e天坑乱斗 命中范围 概率增加到 §a0.4%");
            player.sendMessage("§f9. §e天坑乱斗 神话掉率 概率增加到 §a0.4%");
            player.sendMessage("");
            player.sendMessage("§f还有更多请等服务器开发者更新！");
          }  
        if (event.getSlot() == 12)
          if (event.getClick().isLeftClick()) {
            VIP_PLUSItemClickEvent(player);
          } else if (event.getClick().isRightClick()) {
            player.sendMessage("§aVIP§c+§a会员权限解锁项目：");
            player.sendMessage("");
            player.sendMessage("§f1. §e在大厅可以使用 §b/fw §e| §b/firework§e 指令发射烟花");
            player.sendMessage("§f2. §e可以在大厅使用 §b/fly §e指令进行飞行");
            player.sendMessage("§f3. §e拥有 §a[VIP§c+§a] §e的称号前缀");
            player.sendMessage("§f4. §e可以领取VIP+§e专属每月礼包");
            player.sendMessage("§f5. §e加入大厅获得 §a[VIP§c+§a]" + player.getDisplayName() + "§6加入了服务器！ §e的消息通知");
            player.sendMessage("§f6. §e部分商品价格可以享受优惠");
            player.sendMessage("§f7. §e拥有小游戏内测资格");
            player.sendMessage("§f8. §e支持加入满人的游戏大厅");
            player.sendMessage("§f9. §e天坑乱斗 稀有物品 获取概率增加 §a0.4%");
            player.sendMessage("§f10. §e天坑乱斗 命中范围 概率增加到 §a0.4%");
            player.sendMessage("§f11. §e天坑乱斗 神话掉率 概率增加到 §a0.4%");
            player.sendMessage("");
            player.sendMessage("§f还有更多请等服务器开发者更新！");
            player.sendMessage("");
          }  
        if (event.getSlot() == 14)
          if (event.getClick().isLeftClick()) {
            MVPItemClickEvent(player);
          } else if (event.getClick().isRightClick()) {
            player.sendMessage("§bMVP§a会员权限解锁项目：");
            player.sendMessage("");
            player.sendMessage("§f1. §e在大厅可以使用 §b/fw §e| §b/firework§e 指令发射烟花");
            player.sendMessage("§f2. §e可以在大厅使用 §b/fly §e指令进行飞行");
            player.sendMessage("§f3. §e拥有 §b[MVP] §e的称号前缀");
            player.sendMessage("§f4. §e可以领取MVP专属每月礼包");
            player.sendMessage("§f5. §e加入大厅获得 §b> §a> §c> §b[MVP]" + player.getDisplayName() + "§6加入了服务器！ §c< §a< §b< §e的消息通知");
            player.sendMessage("§f6. §e部分商品价格可以享受优惠");
            player.sendMessage("§f7. §e拥有小游戏内测资格");
            player.sendMessage("§f8. §e支持加入满人的游戏大厅");
            player.sendMessage("§f9. §e天坑乱斗自动解锁会员权益");
            player.sendMessage("§f10. §e天坑乱斗 稀有物品 获取概率增加 §b§l0.8%");
            player.sendMessage("§f11. §e天坑乱斗 命中范围 概率增加到 §b§l0.8%");
            player.sendMessage("§f12. §e天坑乱斗 神话掉率 概率增加到 §b§l0.8%");
            player.sendMessage("");
            player.sendMessage("§f还有更多请等服务器开发者更新！");
            player.sendMessage("");
          }  
        if (event.getSlot() == 16)
          if (event.getClick().isLeftClick()) {
            MVP_PLUSItemClickEvent(player);
          } else if (event.getClick().isRightClick()) {
            player.sendMessage("§bMVP§c+§a会员权限解锁项目：");
            player.sendMessage("");
            player.sendMessage("§f1. §e在大厅可以使用 §b/fw §e| §b/firework§e 指令发射烟花");
            player.sendMessage("§f2. §e可以在大厅使用 §b/fly §e指令进行飞行");
            player.sendMessage("§f3. §e拥有 §b[MVP§c+§b] §e的称号前缀");
            player.sendMessage("§f4. §e可以领取MVP+专属每月礼包");
            player.sendMessage("§f5. §e加入大厅获得 §b> §a> §c> §b[MVP§c+§b]" + player.getDisplayName() + "§6加入了服务器！ §c< §a< §b< §e的消息通知");
            player.sendMessage("§f6. §e部分商品价格可以享受优惠");
            player.sendMessage("§f7. §e拥有小游戏内测资格");
            player.sendMessage("§f8. §e支持加入满人的游戏大厅");
            player.sendMessage("§f9. §e天坑乱斗自动解锁会员权益");
            player.sendMessage("§f10. §e部分小游戏任务支持自动解锁");
            player.sendMessage("§f11. §e起床战争支持无限次数地图选择");
            player.sendMessage("§f12. §e天坑乱斗 稀有物品 获取概率增加 §b§l0.8%");
            player.sendMessage("§f13. §e天坑乱斗 命中范围 概率增加到 §b§l0.8%");
            player.sendMessage("§f14. §e天坑乱斗 神话掉率 概率增加到 §b§l0.8%");
            player.sendMessage("");
            player.sendMessage("§f还有更多请等服务器开发者更新！");
            player.sendMessage("");
          }  
        player.closeInventory();
      } 
    } catch (NullPointerException nullPointerException) {}
  }
  
  private boolean haveEnoughPoints(Player player, int amount) {
    PlayerPointsAPI api = ((PlayerPoints)Bukkit.getPluginManager().getPlugin("PlayerPoints")).getAPI();
    return (api.look(player.getUniqueId()) >= amount);
  }
  
  private boolean removePoints(Player player, int amount) {
    PlayerPointsAPI api = ((PlayerPoints)Bukkit.getPluginManager().getPlugin("PlayerPoints")).getAPI();
    return api.take(player.getUniqueId(), amount);
  }
  
  private int watchPoints(Player player) {
    PlayerPointsAPI api = ((PlayerPoints)Bukkit.getPluginManager().getPlugin("PlayerPoints")).getAPI();
    return api.look(player.getUniqueId());
  }
}
