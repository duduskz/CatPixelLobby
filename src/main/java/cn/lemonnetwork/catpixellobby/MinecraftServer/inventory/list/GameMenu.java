package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.BungeeCord.ConnectServer;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GameMenu extends InventoryAbs {
  static HashMap<Player, BukkitTask> task = new HashMap<>();
  
  private Player player;
  
  public GameMenu(Player p) {
    super(p, 6, "游戏菜单 (1/1)页");
    this.player = p;
  }
  
  public void setup() {
    task.remove(this.player);
    BukkitTask refresh = (new BukkitRunnable() {
        final List<String> list = Arrays.asList(new String[] { "§e➢ 点击游玩！", "§e   点击游玩！" });
        
        int i = 0;
        
        public void run() {
          if (this.i == this.list.size())
            this.i = 0; 
          String cross = this.list.get(this.i);
          String playerName = GameMenu.this.player.getName();
          ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
          ItemStack noGame = new ItemStack(160, 1, (short)14);
          ItemUtils.createItem(noGame, "§c哦，不！", Arrays.asList(new String[] { "§7这里的路以后再来探索吧！", "", "§b更多小游戏正在开发中，感谢您的理解！ :D", "" }));
          SkullMeta playerHeadMeta = (SkullMeta)playerHead.getItemMeta();
          playerHeadMeta.setOwner(playerName);
          playerHead.setItemMeta((ItemMeta)playerHeadMeta);
          PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, 200, 255);
          ItemStack games = new ItemStack(Material.COMPASS, 1);
          ItemUtils.createItem(games, "§a游戏菜单", Arrays.asList(new String[] { "§7想在这个服务器上游玩游戏吗？", "§7你只需要点击这个菜单就可以和你的小伙伴们", "§7一起愉快的玩耍了！", "", "§e点击切换！" }));
          GameMenu.this.setItem(0, (InventoryAbs.Item)new InventoryAbs.ItemAbs(games) {
                public void onClick(InventoryClickEvent e) {
                  e.getWhoClicked().closeInventory();
                  e.getWhoClicked().sendMessage("§c你选择的已经是 游戏菜单 了！");
                  GameMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
              });
          ItemUtils.createItem(playerHead, "§a个人档案", Arrays.asList(new String[] { "§7查看自己在CatPixel上面的个人资料和信息及更多内容！", "", "§e点击切换！" }));
          GameMenu.this.setItem(1, (InventoryAbs.Item)new InventoryAbs.ItemAbs(playerHead) {
                public void onClick(InventoryClickEvent e) {
                  Player whoClicked = (Player)e.getWhoClicked();
                  (new ProfileMenu(whoClicked)).open();
                  GameMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
                }
              });
          ItemStack shopMenu = new ItemStack(Material.EMERALD, 1);
          ItemUtils.createItem(shopMenu, "§a猫咪商店", Arrays.asList(new String[] { "§7在这里查看CatPixel Network商店！", "§7", "§7你的CatPixel点券数量: §6" + API.getPlayerPoints(player), "", "§e点击切换！" }));
          GameMenu.this.setItem(2, (InventoryAbs.Item)new InventoryAbs.ItemAbs(shopMenu) {
                public void onClick(InventoryClickEvent e) {
                  Player whoClicked = (Player)e.getWhoClicked();
                  (new ShopMenu(whoClicked)).open();
                  GameMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
                }
              });
          ItemStack blueglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
          ItemStack blackglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
          ItemUtils.createItem(blueglass, "§a已选择！", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
          ItemUtils.createItem(blackglass, "§c未选择！ (点击上方更换)", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
          GameMenu.this.setItem(9, (InventoryAbs.Item)new InventoryAbs.NoneItem(blueglass));
          GameMenu.this.setItem(10, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(11, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(12, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(13, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(14, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(15, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(16, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          GameMenu.this.setItem(17, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
          ItemStack bedwars = new ItemStack(Material.BED, 1);
          ItemUtils.createItem(bedwars, "§b起床战争", Arrays.asList(new String[] { 
                  "§8团队战斗生存类", "§7", "§e• §f玩法介绍：", " §7与队友一起保护你们的床，并摧毁敌人的床以取胜！", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_BedWars%") + "§7人正在游玩中！", "", 
                  cross + " " }));
          GameMenu.this.setItem(20, (InventoryAbs.Item)new InventoryAbs.ItemAbs(bedwars) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "BW_LOBBY");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack SkyWars = new ItemStack(Material.EYE_OF_ENDER, 1);
          ItemUtils.createItem(SkyWars, "§b空岛战争", Arrays.asList(new String[] { 
                  "§8战斗生存类", "§7", "§e• §f玩法介绍：", " §7主要有死亡使者、战魂之井以及§c疯狂模式§7！", " §7单人或组队作战。", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_SkyWars%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(24, (InventoryAbs.Item)new InventoryAbs.ItemAbs(SkyWars) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "SW_LOBBY");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack Thepit = new ItemStack(Material.DIRT, 1);
          ItemUtils.createItem(Thepit, "§b天坑乱斗 §c§l(神话更新！)", Arrays.asList(new String[] { 
                  "§8战斗生存类", "§7", "§e• §f玩法介绍：", " §7跳进天坑与超过50名玩家实施对决", " §7CatPixel服务器中节奏最快的PVP游戏。", "§7", "§e• §f硬币倍率：", " §6➠ x6.0倍硬币奖励", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_ThePit%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(31, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Thepit) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "THEPIT");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack MegaWalls = new ItemStack(Material.SOUL_SAND, 1);
          ItemUtils.createItem(MegaWalls, "§b超级战墙", Arrays.asList(new String[] { 
                  "§8团队战斗生存类", "§7", "§e• §f玩法介绍：", " §7大型百人作战游戏，多种职业可选。", " §7击败敌方凋零，阻止敌人重生。", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_MegaWalls%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(28, (InventoryAbs.Item)new InventoryAbs.ItemAbs(MegaWalls) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "MW_LOBBY");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE, 1);
          ItemUtils.createItem(UHC, "§b极限冠军生存", Arrays.asList(new String[] { 
                  "§8团队战斗生存类", "§7", "§e• §f玩法介绍：", " §7大型百人作战游戏，多种职业可选。", " §7击败敌方凋零，阻止敌人重生。", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_UHC%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(29, (InventoryAbs.Item)new InventoryAbs.ItemAbs(UHC) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "UHC_LOBBY");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack MurderMystery = new ItemStack(Material.BOW, 1);
          ItemUtils.createItem(MurderMystery, "§b密室杀手", Arrays.asList(new String[] { 
                  "§8团队生存类", "§7", "§e• §f玩法介绍：", " §7一名杀手、侦探和一群无辜的平民", " §7你能在这紧张的社会中存活吗？", " §7一局关于背叛和谋杀的游戏？", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", 
                  "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_MurderMystery%") + "§7人正在游玩中！", "", cross + " " }));
          GameMenu.this.setItem(30, (InventoryAbs.Item)new InventoryAbs.ItemAbs(MurderMystery) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "MM_LOBBY");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack SkyPVP = new ItemStack(Material.EGG, 1);
          ItemUtils.createItem(SkyPVP, "§bSKY-PVP", Arrays.asList(new String[] { 
                  "§8战斗生存类", "§7", "§e• §f玩法介绍：", " §7主流程为开启地图内的幸运方块", " §7获得装备、道具等，与其他玩家进行战斗", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_SkyPVP%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(32, (InventoryAbs.Item)new InventoryAbs.ItemAbs(SkyPVP) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "SKYPVP");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack DUEL = new ItemStack(Material.FISHING_ROD, 1);
          ItemUtils.createItem(DUEL, "§b竞技场", Arrays.asList(new String[] { 
                  "§8休闲类", "§7", "§e• §f玩法介绍：", " §7快节奏的1v1、2v2、4v4和锦标赛决斗游戏！", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_Duel%") + "§7人正在游玩中！", "", 
                  cross + " " }));
          GameMenu.this.setItem(33, (InventoryAbs.Item)new InventoryAbs.ItemAbs(DUEL) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "DUEL");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack Arcade = new ItemStack(Material.SLIME_BALL, 1);
          ItemUtils.createItem(Arcade, "§b街机游戏", Arrays.asList(new String[] { 
                  "§8战斗类", "§7", "§e• §f玩法介绍：", " §7集成超多超级有趣的小游戏，", " §7和朋友一同开玩吧！", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_Arcade%") + "§7人正在游玩中！", 
                  "", cross + " " }));
          GameMenu.this.setItem(34, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Arcade) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "ArcadeLobby");
                  GameMenu.this.player.closeInventory();
                }
              });
          ItemStack BuildBattle = new ItemStack(58, 1);
          ItemUtils.createItem(BuildBattle, "§b建筑大师", Arrays.asList(new String[] { 
                  "§8战斗类", "§7", "§e• §f玩法介绍：", " §7在5分钟之内根据给定主题建造一个建筑！", " §7用“传奇屎诗” 到 “传奇”的不同程度对建", " §7成的建筑进行投票，获得票数最多的玩家赢得最终胜利！", "§7", "§e• §f硬币倍率：", " §c➠ 暂未激活任何倍增器 :(", "", 
                  "§b " + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%CatPixelTools_BuildBattle%") + "§7人正在游玩中！", "", cross + " " }));
          GameMenu.this.setItem(36, (InventoryAbs.Item)new InventoryAbs.ItemAbs(BuildBattle) {
                public void onClick(InventoryClickEvent e) {
                  ConnectServer.FindServer(GameMenu.this.player, "BuildBattleLobby");
                  GameMenu.this.player.closeInventory();
                }
              });
          GameMenu.this.setItem(37, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(38, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(39, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(40, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(41, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(42, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(43, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          GameMenu.this.setItem(44, (InventoryAbs.Item)new InventoryAbs.NoneItem(noGame));
          this.i++;
        }
      }).runTaskTimer((Plugin)CatPixelLobby.getInstance(), 0L, 20L);
  }
}
