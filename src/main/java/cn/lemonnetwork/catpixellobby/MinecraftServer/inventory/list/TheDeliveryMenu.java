package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.SkullItemAPI;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import com.yapzhenyie.GadgetsMenu.utils.mysteryboxes.MysteryBoxType;
import java.util.Arrays;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class TheDeliveryMenu extends InventoryAbs {
  CommandSender consoleSender = (CommandSender)Bukkit.getServer().getConsoleSender();
  
  private Player player;
  
  public TheDeliveryMenu(Player p) {
    super(p, 6, "礼包使者");
    this.player = p;
  }
  
  public void setup() {
    ItemStack noEvent = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemUtils.createItem(noEvent, "§c暂时没有活动礼包哦！~", Arrays.asList(new String[] { "§7更多活动礼包详情", "§b请访问§6https://mc.catpixel.top§b官方论坛！" }));
    ItemStack C = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYwMDE2OWY3NjY5NzlkZmQ2OGNiNGQ0MzZlOGMxMTA1NGY1ZjE3N2MxM2RkMjY0NTllZTdiN2RiZDBkNjNmNSJ9fX0=");
    ItemStack A = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWQ5NzFhZjVmZGRmZTg5MDk4NzNmOTY1YmM2ODFlZDk0ZGU0YzIwMDU5MmM3OWY0Yzc1OGVhOWEyYjBmOWM1YiJ9fX0=");
    ItemStack T = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDYxYmNiMDM3N2FkY2JkMTY5NDVjYjc0ZWVmYmZjYTg4NDQ3MTAwYmQxMThkMjU1NjRlZTc3N2NmNTQxYjA5MiJ9fX0=");
    ItemStack P = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY4ZDZlMDViN2Q2YWVlNzRhMmJkM2EwYjFlNDgyZDY2OTA2MWQxMmI1ZWRhZjk4NTBmZDNmZGQ3YzY2YWNhMyJ9fX0=");
    ItemStack I = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThiNTZjMDFkOGZhZjhkY2U2Zjg2YzgyODFjMGJmZWQwMDVlMDlmYTRkODFjMjFkODQ2NWEzMzNhOWQ0NmYwMyJ9fX0=");
    ItemStack X = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmE0Y2FiYjY5Y2E4ZTUxNDY1YjkzYTQ2NDhkYWEzMWMzYzY0MzA2ZDlkYzM4YzczZWEyMmYyYjNkZTQ0YjUwOCJ9fX0=");
    ItemStack E = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGViZWU4ODhmMmI4ZjM3M2FhMjNjNWUwZWFiNDExY2UzZTExYTU5MmE4MWFmNDZiZDZkOGVlYjYzMTA0YWI1OSJ9fX0=");
    ItemStack L = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJlMzdhZTJlZWEwNGRlNTljNTllNjZkZThlOTYxMzA5NThhMTg4YTBjYzA0NzdlMmNiM2ZiNDNjMGMyZDkyOSJ9fX0=");
    ItemUtils.createItem(C, "§6§lC", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(A, "§6§lA", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(T, "§6§lT", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(P, "§6§lP", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(I, "§6§lI", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(X, "§6§lX", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(E, "§6§lE", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    ItemUtils.createItem(L, "§6§lL", Arrays.asList(new String[] { "§e§lCat§b§lPixel §8| §7全新一代小游戏服务器", "          §f欢迎您的到来！" }));
    setItem(0, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(1, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(2, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(3, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(4, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(5, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(6, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(7, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(8, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(9, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(18, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(27, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(36, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(45, (InventoryAbs.Item)new InventoryAbs.NoneItem(noEvent));
    setItem(46, (InventoryAbs.Item)new InventoryAbs.NoneItem(C));
    setItem(47, (InventoryAbs.Item)new InventoryAbs.NoneItem(A));
    setItem(48, (InventoryAbs.Item)new InventoryAbs.NoneItem(T));
    setItem(49, (InventoryAbs.Item)new InventoryAbs.NoneItem(P));
    setItem(50, (InventoryAbs.Item)new InventoryAbs.NoneItem(I));
    setItem(51, (InventoryAbs.Item)new InventoryAbs.NoneItem(X));
    setItem(52, (InventoryAbs.Item)new InventoryAbs.NoneItem(E));
    setItem(53, (InventoryAbs.Item)new InventoryAbs.NoneItem(L));
    String playerName = this.player.getName();
    ItemStack NewPlayerReward = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta NewPlayerRewardMeta = (SkullMeta)NewPlayerReward.getItemMeta();
    NewPlayerRewardMeta.setOwner(playerName);
    NewPlayerReward.setItemMeta((ItemMeta)NewPlayerRewardMeta);
    if (!this.player.hasPermission("reward.newplayer")) {
      ItemUtils.createItem(NewPlayerReward, "§a新手礼包", Arrays.asList(new String[] { "§7欢迎来到CatPixel！", "§7领取一些免费的神秘宝箱、", "§7经验及金币，来帮助你入门！", "", "§e• §f奖励§8:", "§3 +8,000经验", "§a +20神秘宝箱 (一星)", "", "§e点击领取！" }));
    } else {
      ItemUtils.createItem(NewPlayerReward, "§a新手礼包", Arrays.asList(new String[] { "§7欢迎来到CatPixel！", "§7领取一些免费的神秘宝箱、", "§7经验及金币，来帮助你入门！", "", "§e• §f奖励§8:", "§3 +8,000经验", "§a +20神秘宝箱 (一星)", "", "§c你已经领取过了哦喵~" }));
    } 
    setItem(13, (InventoryAbs.Item)new InventoryAbs.ItemAbs(NewPlayerReward) {
          public void onClick(InventoryClickEvent e) {
            if (!TheDeliveryMenu.this.player.hasPermission("reward.newplayer")) {
              TheDeliveryMenu.this.player.performCommand("thedeliverys");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(TheDeliveryMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_1, 
                  Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 20);
              AlonsoLevelsAPI.addExperience(TheDeliveryMenu.this.player.getUniqueId(), 8000);
              Bukkit.getServer().dispatchCommand(TheDeliveryMenu.this.consoleSender, "lp user " + TheDeliveryMenu.this.player.getName() + " permission set reward.newplayer true");
              MySQL.removeRewardNumber(TheDeliveryMenu.this.player, 1);
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.sendMessage("§a领取成功：新手礼包");
              TheDeliveryMenu.this.player.sendMessage(" §8+§3 8,000经验 ");
              TheDeliveryMenu.this.player.sendMessage(" §8+§a 20§7神秘宝箱 ");
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.closeInventory();
              Achievement.Unlock(TheDeliveryMenu.this.player, "见面礼！", "领取一份新人礼包奖励", "NewGiftPackage", Integer.valueOf(10));
            } else {
              TheDeliveryMenu.this.player.sendMessage("§c你已经领取了大猫为您准备的新手礼包，请探索服务器去吧喵~");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              TheDeliveryMenu.this.player.closeInventory();
              Achievement.Unlock(TheDeliveryMenu.this.player, "我不是小白了？", "尝试重新领取新手礼包", "NoNovice", Integer.valueOf(10));
            } 
          }
        });
    ItemStack dayReward = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmYzhhM2EwZWU0ZDA5NTFhMDI0YmY2MWRiZTkwYzVhMTBlYzAyNzBmZTFhYjNjNWZhYjE3MTBiOTczOTZhNyJ9fX0=");
    ItemStack dayRewards = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWViYzI1ZjNiZTFmNjJmMTMxYzYyY2E1YmQ4YTVjNDZmNjA4NmY2NTNkNGU4YWI4NTIwZjg3YjMwMDJmMDI4NCJ9fX0=");
    if (!this.player.hasPermission("reward.day")) {
      ItemUtils.createItem(dayReward, "§a每日礼包", Arrays.asList(new String[] { "§7你在今天的每日礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +200经验", "§a +5神秘宝箱 (一星)", "", "§e点击领取！" }));
    } else {
      ItemUtils.createItem(dayRewards, "§a每日礼包", Arrays.asList(new String[] { 
              "§7你在今天的每日礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +200经验", "§a +5神秘宝箱 (一星)", "", "§b• §f下次领取时间还剩：", "  §f" + 
              
              PlaceholderAPI.setPlaceholders(this.player.getPlayer(), "%luckperms_expiry_time_reward.day%"), "", 
              "§c你已经领取过了哦喵~" }));
    } 
    if (!this.player.hasPermission("reward.day")) {
      setItem(21, (InventoryAbs.Item)new InventoryAbs.ItemAbs(dayReward) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.performCommand("thedeliverys");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(TheDeliveryMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_1, 
                  Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
              AlonsoLevelsAPI.addExperience(TheDeliveryMenu.this.player.getUniqueId(), 200);
              Bukkit.getServer().dispatchCommand(TheDeliveryMenu.this.consoleSender, "lp user " + TheDeliveryMenu.this.player.getName() + " permission settemp reward.day true 1d");
              MySQL.removeRewardNumber(TheDeliveryMenu.this.player, 1);
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.sendMessage("§a领取成功：每日礼包");
              TheDeliveryMenu.this.player.sendMessage(" §8+§3 200经验 ");
              TheDeliveryMenu.this.player.sendMessage(" §8+§a 5§7神秘宝箱 ");
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } else {
      setItem(21, (InventoryAbs.Item)new InventoryAbs.ItemAbs(dayRewards) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.sendMessage("§c你已经领取了大猫为您准备的每日礼包，请探索服务器去吧喵~");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } 
    ItemStack monthReward = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmYzhhM2EwZWU0ZDA5NTFhMDI0YmY2MWRiZTkwYzVhMTBlYzAyNzBmZTFhYjNjNWZhYjE3MTBiOTczOTZhNyJ9fX0=");
    ItemStack monthRewards = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWViYzI1ZjNiZTFmNjJmMTMxYzYyY2E1YmQ4YTVjNDZmNjA4NmY2NTNkNGU4YWI4NTIwZjg3YjMwMDJmMDI4NCJ9fX0=");
    if (!this.player.hasPermission("reward.month")) {
      ItemUtils.createItem(monthReward, "§a每月礼包", Arrays.asList(new String[] { "§7你在今天的每月礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +1,000经验", "§a +5神秘宝箱 (三星)", "", "§e点击领取！" }));
    } else {
      ItemUtils.createItem(monthRewards, "§a每月礼包", Arrays.asList(new String[] { 
              "§7你在今天的每月礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +1,000经验", "§a +5神秘宝箱 (三星)", "", "§b• §f下次领取时间还剩：", "  §f" + 
              
              PlaceholderAPI.setPlaceholders(this.player.getPlayer(), "%luckperms_expiry_time_reward.month%"), "", 
              "§c你已经领取过了哦喵~" }));
    } 
    if (!this.player.hasPermission("reward.month")) {
      setItem(22, (InventoryAbs.Item)new InventoryAbs.ItemAbs(monthReward) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.performCommand("thedeliverys");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(TheDeliveryMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_3, 
                  Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 5);
              AlonsoLevelsAPI.addExperience(TheDeliveryMenu.this.player.getUniqueId(), 1000);
              Bukkit.getServer().dispatchCommand(TheDeliveryMenu.this.consoleSender, "lp user " + TheDeliveryMenu.this.player.getName() + " permission settemp reward.month true 30d");
              MySQL.removeRewardNumber(TheDeliveryMenu.this.player, 1);
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.sendMessage("§a领取成功：每月礼包");
              TheDeliveryMenu.this.player.sendMessage(" §8+§3 1,000经验 ");
              TheDeliveryMenu.this.player.sendMessage(" §8+§a 5§7神秘宝箱 ");
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } else {
      setItem(22, (InventoryAbs.Item)new InventoryAbs.ItemAbs(monthRewards) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.sendMessage("§c你已经领取了大猫为您准备的每月礼包，请探索服务器去吧喵~");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } 
    ItemStack yearReward = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmYzhhM2EwZWU0ZDA5NTFhMDI0YmY2MWRiZTkwYzVhMTBlYzAyNzBmZTFhYjNjNWZhYjE3MTBiOTczOTZhNyJ9fX0=");
    ItemStack yearRewards = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWViYzI1ZjNiZTFmNjJmMTMxYzYyY2E1YmQ4YTVjNDZmNjA4NmY2NTNkNGU4YWI4NTIwZjg3YjMwMDJmMDI4NCJ9fX0=");
    if (!this.player.hasPermission("reward.year")) {
      ItemUtils.createItem(yearReward, "§a每年礼包", Arrays.asList(new String[] { "§7你在今天的每年礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +5,000经验", "§a +30神秘宝箱 (四星)", "", "§e点击领取！" }));
    } else {
      ItemUtils.createItem(yearRewards, "§a每年礼包", Arrays.asList(new String[] { 
              "§7你在今天的每年礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +5,000经验", "§a +30神秘宝箱 (四星)", "", "§b• §f下次领取时间还剩：", "  §f 364天 null小时 null分钟 null秒", "", 
              "§c你已经领取过了哦喵~" }));
    } 
    if (!this.player.hasPermission("reward.year")) {
      setItem(23, (InventoryAbs.Item)new InventoryAbs.ItemAbs(yearReward) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.performCommand("thedeliverys");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(TheDeliveryMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_4, 
                  Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 30);
              AlonsoLevelsAPI.addExperience(TheDeliveryMenu.this.player.getUniqueId(), 5000);
              Bukkit.getServer().dispatchCommand(TheDeliveryMenu.this.consoleSender, "lp user " + TheDeliveryMenu.this.player.getName() + " permission settemp reward.year true 365d");
              MySQL.removeRewardNumber(TheDeliveryMenu.this.player, 1);
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.sendMessage("§a领取成功：每年礼包");
              TheDeliveryMenu.this.player.sendMessage(" §8+§3 5,000经验 ");
              TheDeliveryMenu.this.player.sendMessage(" §8+§a 30§7神秘宝箱 ");
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } else {
      setItem(23, (InventoryAbs.Item)new InventoryAbs.ItemAbs(yearRewards) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.sendMessage("§c你已经领取了大猫为您准备的每年礼包，请探索服务器去吧喵~");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } 
    ItemStack VIPmonthReward = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmYzhhM2EwZWU0ZDA5NTFhMDI0YmY2MWRiZTkwYzVhMTBlYzAyNzBmZTFhYjNjNWZhYjE3MTBiOTczOTZhNyJ9fX0=");
    ItemStack VIPmonthRewards = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWViYzI1ZjNiZTFmNjJmMTMxYzYyY2E1YmQ4YTVjNDZmNjA4NmY2NTNkNGU4YWI4NTIwZjg3YjMwMDJmMDI4NCJ9fX0=");
    ItemStack VIPmonthRewards_noPermission = SkullItemAPI.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJmYzhhM2EwZWU0ZDA5NTFhMDI0YmY2MWRiZTkwYzVhMTBlYzAyNzBmZTFhYjNjNWZhYjE3MTBiOTczOTZhNyJ9fX0=");
    if (!this.player.hasPermission("reward.rank.vip"))
      ItemUtils.createItem(VIPmonthReward, "§aVIP专属每月礼包", Arrays.asList(new String[] { "§7你在今天的VIP专属会员每月礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +8,000经验", "§a +10神秘宝箱 (二星)", "", "§c权益不足，无法领取！" })); 
    if (!this.player.hasPermission("reward.vip")) {
      ItemUtils.createItem(VIPmonthReward, "§aVIP专属每月礼包", Arrays.asList(new String[] { "§7你在今天的每年礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +8,000经验", "§a +10神秘宝箱 (二星)", "", "§e点击领取！" }));
    } else {
      ItemUtils.createItem(yearRewards, "§a每年礼包", Arrays.asList(new String[] { 
              "§7你在今天的每年礼包已经送达！", "§7快来领取吧！", "", "§e• §f奖励§8:", "§3 +5,000经验", "§a +30神秘宝箱 (四星)", "", "§b• §f下次领取时间还剩：", "  §f" + 
              
              PlaceholderAPI.setPlaceholders(this.player.getPlayer(), "%luckperms_expiry_time_reward.year%"), "", 
              "§c你已经领取过了哦喵~" }));
    } 
    if (!this.player.hasPermission("reward.year")) {
      setItem(23, (InventoryAbs.Item)new InventoryAbs.ItemAbs(yearReward) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.performCommand("thedeliverys");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(TheDeliveryMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_4, 
                  Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 30);
              AlonsoLevelsAPI.addExperience(TheDeliveryMenu.this.player.getUniqueId(), 5000);
              Bukkit.getServer().dispatchCommand(TheDeliveryMenu.this.consoleSender, "lp user " + TheDeliveryMenu.this.player.getName() + " permission settemp reward.year true 365d");
              MySQL.removeRewardNumber(TheDeliveryMenu.this.player, 1);
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.sendMessage("§a领取成功：每年礼包");
              TheDeliveryMenu.this.player.sendMessage(" §8+§3 5,000经验 ");
              TheDeliveryMenu.this.player.sendMessage(" §8+§a 30§7神秘宝箱 ");
              TheDeliveryMenu.this.player.sendMessage("");
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } else {
      setItem(23, (InventoryAbs.Item)new InventoryAbs.ItemAbs(yearRewards) {
            public void onClick(InventoryClickEvent e) {
              TheDeliveryMenu.this.player.sendMessage("§c你已经领取了大猫为您准备的每年礼包，请探索服务器去吧喵~");
              TheDeliveryMenu.this.player.playSound(TheDeliveryMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              TheDeliveryMenu.this.player.closeInventory();
            }
          });
    } 
  }
}
