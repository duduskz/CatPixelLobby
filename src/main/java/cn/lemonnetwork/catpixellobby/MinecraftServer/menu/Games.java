package cn.lemonnetwork.catpixellobby.MinecraftServer.menu;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Games implements Listener {
  static HashMap<Player, BukkitTask> task = new HashMap<>();
  
  public static void open(final Player player) {
    final Inventory inventory = Bukkit.createInventory((InventoryHolder)player, 54, "§8游戏菜单");
    task.remove(player);
    BukkitTask refresh = (new BukkitRunnable() {
        final List<String> list = Arrays.asList(new String[] { "§a▸ 点击连接", "§a 点击连接" });
        
        int i = 0;
        
        public void run() {
          if (this.i == this.list.size())
            this.i = 0; 
          String cross = this.list.get(this.i);
          String level = "%alonsolevels_level%";
          String level_progress_bar = "%alonsolevels_progress_bar%";
          String level_progress_percent_format = "%alonsolevels_progress_percent_format%";
          String level_experience_to_levelup = "%alonsolevels_experience_to_level_up%";
          level = PlaceholderAPI.setPlaceholders(player.getPlayer(), level);
          level_progress_bar = PlaceholderAPI.setPlaceholders(player.getPlayer(), level_progress_bar);
          level_progress_percent_format = PlaceholderAPI.setPlaceholders(player.getPlayer(), level_progress_percent_format);
          level_experience_to_levelup = PlaceholderAPI.setPlaceholders(player.getPlayer(), level_experience_to_levelup);
          ItemStack SkyWars = new ItemStack(Material.EYE_OF_ENDER, 1);
          ItemStack MegaWalls = new ItemStack(Material.SOUL_SAND, 1);
          ItemStack BedWars = new ItemStack(Material.BED, 1);
          ItemStack Arcade = new ItemStack(Material.SLIME_BALL, 1);
          ItemStack TNTGames = new ItemStack(Material.TNT, 1);
          ItemStack CSGO = new ItemStack(Material.IRON_FENCE, 1);
          ItemStack LightningHungerGame = new ItemStack(Material.DIAMOND_SWORD, 1);
          ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE, 1);
          ItemStack MiniWalls = new ItemStack(Games.getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc0NzJkNjA4ODIxZjQ1YTg4MDUzNzZlYzBjNmZmY2I3ODExNzgyOWVhNWY5NjAwNDFjMmEwOWQxMGUwNGNiNCJ9fX0="));
          ItemStack Build = new ItemStack(58, 1);
          ItemStack Muder = new ItemStack(Material.BOW, 1);
          ItemStack Duel = new ItemStack(Material.FISHING_ROD, 1);
          ItemStack Warlord = new ItemStack(Material.STONE_AXE, 1);
          ItemStack HomeWorld = new ItemStack(431, 1);
          ItemStack Lobby = new ItemStack(47, 1);
          ItemStack Level = new ItemStack(379, 1);
          ItemStack ThePit = new ItemStack(Material.DIRT, 1);
          ItemMeta ThePitMeta = ThePit.getItemMeta();
          ItemMeta LevelMeta = Level.getItemMeta();
          ItemMeta LobbyMeta = Lobby.getItemMeta();
          ItemMeta DuelMeta = Duel.getItemMeta();
          ItemMeta BuildMeta = Build.getItemMeta();
          ItemMeta MegaWallsMeta = MegaWalls.getItemMeta();
          ItemMeta BedWarsMeta = BedWars.getItemMeta();
          ItemMeta ArcadeMeta = Arcade.getItemMeta();
          ItemMeta SkyWarsMeta = SkyWars.getItemMeta();
          ItemMeta TNTGamesMeta = TNTGames.getItemMeta();
          ItemMeta CSGOMeta = CSGO.getItemMeta();
          ItemMeta LightningHungerGameMeta = LightningHungerGame.getItemMeta();
          ItemMeta UHCMeta = UHC.getItemMeta();
          ItemMeta MiniWallsMeta = MiniWalls.getItemMeta();
          ItemMeta MuderMeta = Muder.getItemMeta();
          ItemMeta WarlordMeta = Warlord.getItemMeta();
          ItemMeta HomeWorldMeta = HomeWorld.getItemMeta();
          SkyWarsMeta.setDisplayName("§a空岛战争");
          SkyWarsMeta.setLore(Arrays.asList(new String[] { 
                  "§8生存", "", "§7CatPixel服务器空岛战争。", "§7主要有死亡使者、战魂之井以及§c疯狂模式§7！", "§7单人或组队作战。", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", 
                  "§70人游戏中！" }));
          String arcade_player = "%CatPixelLobby_player-counts-ArcadeLobby#1;ArcadeLobby#2;ArcadeLobby#3;PartyGames#1;PartyGames#2;PartyGames#3;Zombie#1;Zombie#2;Zombie#3%";
          arcade_player = PlaceholderAPI.setPlaceholders(player.getPlayer(), arcade_player);
          ArcadeMeta.setDisplayName("§a街机游戏");
          ArcadeMeta.setLore(Arrays.asList(new String[] { 
                  "§8休闲游戏", "", "§7超级有趣的小游戏，", "§7和朋友一同开玩吧！", "§f· §f僵尸", "§f· §fHide and Seek", "§f· §f人体打印机", "§f· §f行尸危机", "§f· §f农场躲猫猫", "§f· §f怪物竞技场", 
                  "§f· §fParty Games", "§f· §f我说你做", "§f· §f绘画大师", "§f· §f足球", "§f· §f迷你战墙", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", 
                  "§7" + arcade_player + "§7人游戏中！" }));
          String bw_player = "%CatPixelLobby_player-counts-BW_4V4V4V4#1;BW_4V4V4V4#2;BW_4V4V4V4#3;BW_4V4V4V4#4;BW_4V4V4V4#5;BW_4V4V4V4#6;BW_4V4V4V4#7;BW_4V4V4V4#8;BW_4V4V4V4#9;BW_4V4V4V4#10;BW_3V3V3V3#1;BW_3V3V3V3#2;BW_3V3V3V3#3;BW_3V3V3V3#4;BW_3V3V3V3#5;BW_3V3V3V3#6;BW_3V3V3V3#7;BW_3V3V3V3#8;BW_3V3V3V3#9;BW_3V3V3V3#10;BW_3V3V3V3#11;BW_SOLO#1;BW_SOLO#2;BW_SOLO#3;BW_SOLO#4;BW_SOLO#5;BW_SOLO#6;BW_SOLO#7;BW_SOLO#8;BW_SOLO#9;BW_SOLO#10;BW_SOLO#11;BW_Dream4V4#1;BW_Dream4V4#2;BW_Dream4V4#3;BW_Dream4V4#4;BW_Dream4V4#5;BW_DreamTeam#;BW_DreamTeam#2;BW_DreamTeam#3;BW_DreamTeam#4;BW_DreamTeam#5;BEDWARS_LOBBY_1%";
          bw_player = PlaceholderAPI.setPlaceholders(player.getPlayer(), bw_player);
          BedWarsMeta.setDisplayName("§a起床战争 §e§l更新！");
          BedWarsMeta.setLore(Arrays.asList(new String[] { "§8团队生存", "", "§7与队友一起保护你们的床，并摧毁敌人的床以取胜！", "", cross + "", "§7" + bw_player + "§7人游戏中！" }));
          String mw_player = "%CatPixelLobby_player-counts-MEGAWALLS_LOBBY_1;MEGAWALLS_Duel#1;MEGAWALLS_Duel#2;MEGAWALLS_Duel#3;MEGAWALLS_Duel#4;MEGAWALLS_Duel#5;MEGAWALLS_NORM#1;MEGAWALLS_NORM#2;MEGAWALLS_NORM#3;MEGAWALLS_NORM#4;MEGAWALLS_NORM#5%";
          mw_player = PlaceholderAPI.setPlaceholders(player.getPlayer(), mw_player);
          MegaWallsMeta.setDisplayName("§a超级战墙");
          MegaWallsMeta.setLore(Arrays.asList(new String[] { "§8团队生存", "", "§7大型百人作战游戏，多种职业可选。", "§7击败敌方凋零，阻止敌人重生。", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", "§7" + mw_player + "§7人游戏中！" }));
          TNTGamesMeta.setDisplayName("§a掘战游戏");
          TNTGamesMeta.setLore(Arrays.asList(new String[] { 
                  "§8休闲游戏", "", "§7有趣刺激的掘战游戏！", " §f· §f方块掘战", " §f· §fPVP方块掘战", " §f· §f射爆掘战", " §f· §f丢锅大战", " §f· §f法师掘战", "", "§7硬币倍率：§6+2.0倍", 
                  "§8➠ 尚未激活任何倍增器 :(", "", cross + "", "§70人游戏中！" }));
          CSGOMeta.setDisplayName("§a警匪大战");
          CSGOMeta.setLore(Arrays.asList(new String[] { "§8射击类", "", "§7灵感来自热门的FPS", "§7《反恐精英》的枪战游戏", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", "§70人游戏中！" }));
          LightningHungerGameMeta.setDisplayName("§a闪电饥饿游戏");
          LightningHungerGameMeta.setLore(Arrays.asList(new String[] { 
                  "§8生存", "", "§7多人混战生存游戏，", "§7多种职业可供挑选", "§7成为第一个找到", "§7闪电之星的玩家并赢取最终胜利吧！", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", 
                  cross + "", "§70人游戏中！" }));
          UHCMeta.setDisplayName("§a极限生存冠军");
          UHCMeta.setLore(Arrays.asList(new String[] { 
                  "§8极限生存", "", "§7一个111名玩家参与的团队", "§7生存游戏。随机生成的世界，", "§7原版PVP，自定义合成，", "§7独特的职业及专业等着你。", "", "§c警告！", "§c这是一场真正的极限挑战，", "§c不推荐新手玩家尝试。", 
                  "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", "§70人游戏中！" }));
          MiniWallsMeta.setDisplayName("§a迷你战墙");
          MiniWallsMeta.setLore(Arrays.asList(new String[] { 
                  "§8热门街机游戏", "", "§7在4v4v4v4快节奏的PvP街机游戏战斗吧！", "§7从三个职业中选择一个，", "§7并保护你的迷你凋零", "§7来得以持续复活。", "§7游戏时长不到5分钟！", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", 
                  "", cross + "", "§70人游戏中！" }));
          BuildMeta.setDisplayName("§a建筑大师");
          BuildMeta.setLore(Arrays.asList(new String[] { 
                  "§8休闲游戏", "", "§7在5分钟之内根据给定主题", "§7建造一个建筑！用“传奇屎诗”到", "§7“传奇”的不同程度评价", "§7对建成的建筑进行投票！", "§716个玩家中，获得票数最多的玩", "§7家赢得最终胜利！", "", cross + "", 
                  "§70人游戏中！" }));
          String Muder_player = "%CatPixelLobby_player-counts-MurderMystery_Default#1;MurderMystery_Default#2;MurderMystery_Default#3;MurderMystery_Default#4;MurderMystery_Default#5;MurderMystery_Double#1;MurderMystery_Double#2;MurderMystery_Double#3;MurderMystery_Double#4;MurderMystery_Double#5%";
          Muder_player = PlaceholderAPI.setPlaceholders(player.getPlayer(), Muder_player);
          MuderMeta.setDisplayName("§a密室杀手 §e§l更新！");
          MuderMeta.setLore(Arrays.asList(new String[] { "§8团队生存", "", "§7一名杀手，一名侦探。", "§7一群无辜的平民。", "§7你能在这紧张的社会中存活吗？", "§7一局关于背叛和谋杀的游戏？", "", cross + "", "§7" + Muder_player + "人游戏中！" }));
          DuelMeta.setDisplayName("§a决斗游戏");
          DuelMeta.setLore(Arrays.asList(new String[] { 
                  "§8竞技", "", "§7快节奏的1v1、2v2、4v4和锦标赛决斗游戏！", "§f· §f极限生存决斗", "§f· §f空岛战争决斗", "§f· §f超级战墙决斗", "§f· §f连击决斗", "§f· §f药水决斗", "§f· §f经典决斗", "§f· §f弓箭决斗", 
                  "§f· §f高手决斗", "§f· §f闪电饥饿游戏决斗", "§f· §f掘战游戏决斗", "§f· §f相扑决斗", "§f· §f战桥", "", cross + "", "§70人游戏中！" }));
          WarlordMeta.setDisplayName("§a战争领主");
          WarlordMeta.setLore(Arrays.asList(new String[] { 
                  "§8竞技", "", "§7在夺旗战或抢点战中扮演法师、战士、萨满或圣骑士。", "§7用你从未见过的自定义3D武器、职业装甲等装备，", "§7参与史诗般的PvP战斗！", "", "§7硬币倍率：§6+2.0倍", "§8➠ 尚未激活任何倍增器 :(", "", cross + "", 
                  "§70人游戏中！" }));
          String thepit_player = "%CatPixelLobby_player-counts-THEPIT#1%";
          thepit_player = PlaceholderAPI.setPlaceholders(player.getPlayer(), thepit_player);
          ThePitMeta.setDisplayName("§aCatPixel天坑乱斗");
          ThePitMeta.setLore(Arrays.asList(new String[] { 
                  "§8长期游戏", "", "§7跳进天坑与超过50名玩家实施对决", "§7CatPixel中节奏最快的PVP游戏。", "", "§c前方高能！", "§c你已进入极限区域，", "§c不推荐给新手游玩。", "", cross + "", 
                  "§7" + thepit_player + "人游戏中！" }));
          HomeWorldMeta.setDisplayName("§a家园");
          HomeWorldMeta.setLore(Arrays.asList(new String[] { "§8家园", "", "§7自定义搭建你的家园，约上好友，", "§7访问其他玩家的家园，更多乐趣等你发掘！", "", cross + "", "§70人游戏中！" }));
          LobbyMeta.setDisplayName("§a主大厅");
          LobbyMeta.setLore(Arrays.asList(new String[] { "§7返回主大厅" }));
          LevelMeta.setDisplayName("§aCatPixel等级");
          LevelMeta.setLore(Arrays.asList(new String[] { "§7参与游戏并完成任务", "§7可以得到§3CatPixel经验§7奖励.", "§7可用于升级以及体验", "§7新的增益效果与奖品！", "", "§3CatPixel等级§a" + level + " " + level_progress_bar + "§3 " + level_progress_percent_format + "§7       ", "", "§7距离下所需经验:§3" + level_experience_to_levelup.replaceAll("(\\d)(?=(\\d{3})+$)", "$1,"), "", "§e点击查看获得的奖励！" }));
          LobbyMeta.setDisplayName("§a主大厅");
          LobbyMeta.setLore(Arrays.asList(new String[] { "§7返回主大厅" }));
          ThePit.setItemMeta(ThePitMeta);
          Lobby.setItemMeta(LobbyMeta);
          SkyWars.setItemMeta(SkyWarsMeta);
          Arcade.setItemMeta(ArcadeMeta);
          BedWars.setItemMeta(BedWarsMeta);
          MegaWalls.setItemMeta(MegaWallsMeta);
          TNTGames.setItemMeta(TNTGamesMeta);
          CSGO.setItemMeta(CSGOMeta);
          LightningHungerGame.setItemMeta(LightningHungerGameMeta);
          UHC.setItemMeta(UHCMeta);
          MiniWalls.setItemMeta(MiniWallsMeta);
          Build.setItemMeta(BuildMeta);
          Muder.setItemMeta(MuderMeta);
          Duel.setItemMeta(DuelMeta);
          Warlord.setItemMeta(WarlordMeta);
          HomeWorld.setItemMeta(HomeWorldMeta);
          Level.setItemMeta(LevelMeta);
          inventory.setItem(10, Lobby);
          inventory.setItem(12, SkyWars);
          inventory.setItem(13, Arcade);
          inventory.setItem(14, BedWars);
          inventory.setItem(15, MegaWalls);
          inventory.setItem(16, TNTGames);
          inventory.setItem(33, ThePit);
          inventory.setItem(19, HomeWorld);
          inventory.setItem(21, Build);
          inventory.setItem(22, MiniWalls);
          inventory.setItem(23, UHC);
          inventory.setItem(24, LightningHungerGame);
          inventory.setItem(25, CSGO);
          inventory.setItem(28, Level);
          inventory.setItem(30, Muder);
          inventory.setItem(31, Duel);
          inventory.setItem(32, Warlord);
          this.i++;
        }
      }).runTaskTimer((Plugin)CatPixelLobby.getInstance(), 0L, 20L);
    task.put(player, refresh);
    player.openInventory(inventory);
  }
  
  public static ItemStack getCustomSkull(String base64) {
    ItemStack MiniWalls = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta skull = (SkullMeta)MiniWalls.getItemMeta();
    GameProfile profile = new GameProfile(UUID.randomUUID(), null);
    profile.getProperties().put("textures", new Property("textures", base64));
    try {
      Field profileField = skull.getClass().getDeclaredField("profile");
      profileField.setAccessible(true);
      profileField.set(skull, profile);
    } catch (NoSuchFieldException|IllegalAccessException e) {
      e.printStackTrace();
    } 
    MiniWalls.setItemMeta((ItemMeta)skull);
    return MiniWalls;
  }
}
