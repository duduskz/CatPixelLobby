package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.LuckPerms;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.SkullItemAPI;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ProfileMenu extends InventoryAbs {
  private Player player;
  
  public ProfileMenu(Player p) {
    super(p, 6, "个人档案");
    this.player = p;
  }
  
  public void setup() {
    String playerName = this.player.getName();
    String playerPrefixColor = ((String)Objects.<String>requireNonNull(((User)Objects.<User>requireNonNull(LuckPermsProvider.get().getUserManager().getUser(playerName))).getCachedData().getMetaData().getPrefix())).substring(0, 2);
    UUID playerUUID = this.player.getUniqueId();
    ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta skullMeta = (SkullMeta)playerHead.getItemMeta();
    skullMeta.setOwner(playerName);
    playerHead.setItemMeta((ItemMeta)skullMeta);
    ItemStack playerHead_info = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta playerHead_infometa = (SkullMeta)playerHead_info.getItemMeta();
    playerHead_infometa.setOwner(playerName);
    playerHead_info.setItemMeta((ItemMeta)playerHead_infometa);
    ItemUtils.createItem(playerHead, "§a个人档案", Arrays.asList(new String[] { "§7查看自己在CatPixel上面的个人资料和信息及更多内容！", "", "§e点击切换！" }));
    setItem(1, (InventoryAbs.Item)new InventoryAbs.ItemAbs(playerHead) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().sendMessage("§c你选择的已经是 个人档案 了！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    ItemStack games = new ItemStack(Material.COMPASS, 1);
    ItemUtils.createItem(games, "§a游戏菜单", Arrays.asList(new String[] { "§7想在这个服务器上游玩游戏吗？", "§7你只需要点击这个菜单就可以和你的小伙伴们", "§7一起愉快的玩耍了！", "", "§e点击切换！" }));
    setItem(0, (InventoryAbs.Item)new InventoryAbs.ItemAbs(games) {
          public void onClick(InventoryClickEvent e) {
            Player whoClicked = (Player)e.getWhoClicked();
            (new GameMenu(whoClicked)).open();
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    ItemStack shopMenu = new ItemStack(Material.EMERALD, 1);
    ItemUtils.createItem(shopMenu, "§a猫咪商店", Arrays.asList(new String[] { "§7在这里查看CatPixel Network商店！", "§7", "§7你的CatPixel点券数量: §6" + 
            
            API.getPlayerPoints(this.player), "", "§e点击切换！" }));
    setItem(2, (InventoryAbs.Item)new InventoryAbs.ItemAbs(shopMenu) {
          public void onClick(InventoryClickEvent e) {
            Player whoClicked = (Player)e.getWhoClicked();
            (new ShopMenu(whoClicked)).open();
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    ItemUtils.createItem(playerHead_info, "§a角色信息", Arrays.asList(new String[] { 
            "§7Rank: " + LuckPerms.getPlayerGroupName(this.player), "", "§7公会： §bLoading...", "§7CatPixel Network等级:§6" + 
            
            API.getLevel(this.player), "§7距离下级所需经验:§6" + 
            API.getNextUPLevel(this.player), "", "§7成就点数:§e" + 
            
            API.getAchevementPoints(this.player), "§7神秘之尘:§b" + 
            API.getMysteryDust(this.player), "§7CatPixel点券:§6 " + 
            API.getPlayerPoints(this.player), "", 
            "§e点击查看CatPixel官方社交媒体！" }));
    ItemStack friend = SkullItemAPI.getCustomSkull("eyJ0aW1lc3RhbXAiOjE0OTY0MzA4NjM5NjYsInByb2ZpbGVJZCI6IjkzYzdmMmUxMTg2MzQ5NzU4OGE2ZWI0YzUwYjRhZGZiIiwicHJvZmlsZU5hbWUiOiJUYWN0ZnVsIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lMDYzZWVkYjIxODQzNTRiZDQzYTE5ZGVmZmJhNTFiNTNkZDZiNzIyMmY4Mzg4Y2FhMjM5Y2FiY2RjZTg0In19fQ==");
    ItemStack party = SkullItemAPI.getCustomSkull("eyJ0aW1lc3RhbXAiOjE0OTY0MzA5NTY4MjMsInByb2ZpbGVJZCI6IjkzYzdmMmUxMTg2MzQ5NzU4OGE2ZWI0YzUwYjRhZGZiIiwicHJvZmlsZU5hbWUiOiJUYWN0ZnVsIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82Njc5NjNjYTFmZmRjMjRhMTBiMzk3ZmY4MTYxZDBkYTgyZDZhM2Y0Nzg4ZDVmNjdmMWE5ZjliZmJjMWViMSJ9fX0=");
    ItemStack guild = SkullItemAPI.getCustomSkull("eyJ0aW1lc3RhbXAiOjE0OTY0MzA5MjU0NDMsInByb2ZpbGVJZCI6IjkzYzdmMmUxMTg2MzQ5NzU4OGE2ZWI0YzUwYjRhZGZiIiwicHJvZmlsZU5hbWUiOiJUYWN0ZnVsIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mZThiNTlmOGNjZTUxMDgwOTQyN2MzODQzY2Y1NzVmYWU4ZmU2YThiN2QxNTYwZGQ0Njk1OGQxNDg1NjM4MTUifX19");
    ItemStack recent = SkullItemAPI.getCustomSkull("eyJ0aW1lc3RhbXAiOjE0OTY0MzA5ODc1NTMsInByb2ZpbGVJZCI6IjkzYzdmMmUxMTg2MzQ5NzU4OGE2ZWI0YzUwYjRhZGZiIiwicHJvZmlsZU5hbWUiOiJUYWN0ZnVsIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85OTkzYTM1NjgwOTUzMmQ2OTY4NDFhMzdhMDU0OWI4MWIxNTliNzlhN2IyOTE5Y2ZmNGU1YWJkZmVhODNkNjYifX19");
    ItemStack CatPixelLevel = new ItemStack(379);
    ItemStack Achevement = new ItemStack(Material.DIAMOND);
    ItemStack MVP_PLUS_Color = new ItemStack(351, 1, (short)0);
    ItemStack Store = new ItemStack(Material.GOLD_INGOT);
    ItemUtils.createItem(friend, "§a好友", Arrays.asList(new String[] { "§7浏览你CatPixel好友资料，并与你的在线好友进行互动！" }));
    ItemUtils.createItem(party, "§a组队", Arrays.asList(new String[] { "§7创建队伍和其他玩家一起游戏！" }));
    ItemUtils.createItem(guild, "§a公会", Arrays.asList(new String[] { "§7与其他CatPixel玩家一起创", "§7立公会，征服各种游戏模", "§7式，为CatPixel奖励一起努力。" }));
    ItemUtils.createItem(recent, "§a近期活跃玩家", Arrays.asList(new String[] { "§7查看最近和你一起游戏的玩家。" }));
    ItemUtils.createItem(CatPixelLevel, "§aCatPixel等级", Arrays.asList(new String[] { "§7参与游戏并完成任务", "§7可以得到§3CatPixel经验§7奖励.", "§7可用于升级以及体验", "§7新的增益效果与奖品！", "", "§3CatPixel等级§a" + 
            
            API.getLevel(this.player) + " " + API.getLevelProgressBar(this.player) + "§3 " + 
            API.getLevelProgressPercent(this.player) + "§7       ", "", "§7距离下所需经验:§3" + 
            
            API.getNextUPLevel(this.player), "", "§e点击查看获得的奖励！" }));
    ItemUtils.createItem(Achevement, "§a成就", Arrays.asList(new String[] { "§7查看你的成就解锁精度", "§7以及排名点数。", "", "§e点击查看你的成就！" }));
    ItemUtils.createItem(MVP_PLUS_Color, "§aMVP+等级颜色", Arrays.asList(new String[] { "§7拥有§bMVP§c+§7的玩家可以切换“+”的颜色。", "", "§e点击切换！" }));
    ItemUtils.createItem(Store, "§aCatPixel商城", Arrays.asList(new String[] { "§7从这里查看CatPixel商店！", "", "§7你的 CatPixel点券：§6" + 
            
            API.getPlayerPoints(this.player), "", "§e点击切换！" }));
    ItemStack blueglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
    ItemStack blackglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
    ItemStack glass_two = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
    ItemUtils.createItem(blueglass, "§a已选择！", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
    ItemUtils.createItem(blackglass, "§c未选择！ (点击上方更换)", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
    ItemUtils.createItem(glass, "§a更多设置", Arrays.asList(new String[] { "§7服务器更多内容设置", "", "§e点击这里查看 ⇨" }));
    ItemUtils.createItem(glass_two, "§a其他内容", Arrays.asList(new String[] { "§7你的资料中其他内容", "", "§e⇦ 点击这里查看 " }));
    setItem(9, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(10, (InventoryAbs.Item)new InventoryAbs.NoneItem(blueglass));
    setItem(11, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(12, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(13, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(14, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(15, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(16, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(17, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(25, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass));
    setItem(34, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass));
    setItem(43, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass));
    setItem(52, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass));
    setItem(19, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass_two));
    setItem(28, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass_two));
    setItem(37, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass_two));
    setItem(46, (InventoryAbs.Item)new InventoryAbs.NoneItem(glass_two));
    setItem(26, (InventoryAbs.Item)new InventoryAbs.ItemAbs(friend) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此功能正在开发中，给您带来不便！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    setItem(35, (InventoryAbs.Item)new InventoryAbs.ItemAbs(party) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此功能正在开发中，给您带来不便！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    setItem(44, (InventoryAbs.Item)new InventoryAbs.ItemAbs(guild) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此功能正在开发中，给您带来不便！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    setItem(53, (InventoryAbs.Item)new InventoryAbs.ItemAbs(recent) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此功能正在开发中，给您带来不便！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    setItem(31, (InventoryAbs.Item)new InventoryAbs.ItemAbs(playerHead_info) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("");
            e.getWhoClicked().sendMessage("§b§l哔哩哔哩：");
            e.getWhoClicked().sendMessage("§b https://space.bilibili.com/525000337?spm_id_from=333.1007.0.0");
            e.getWhoClicked().sendMessage("");
            e.getWhoClicked().sendMessage("§f§l抖音：");
            e.getWhoClicked().sendMessage("§9 https://www.douyin.com/user/MS4wLjABAAAA_04-wxqsOZBNy3s3axflGr6FABv_IxroyUL-thIJx9-vGQU31AJ_KzAVe8mUh1dB");
            e.getWhoClicked().sendMessage("");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
            e.getWhoClicked().closeInventory();
          }
        });
    setItem(18, (InventoryAbs.Item)new InventoryAbs.ItemAbs(CatPixelLevel) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().getServer().dispatchCommand((CommandSender)e.getWhoClicked(), "alonsolevel rewards");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    setItem(27, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Achevement) {
          public void onClick(InventoryClickEvent e) {
            e.getWhoClicked().sendMessage("§c此功能正在开发中，给您带来不便！");
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    setItem(36, (InventoryAbs.Item)new InventoryAbs.ItemAbs(MVP_PLUS_Color) {
          public void onClick(InventoryClickEvent e) {
            (new ChangeMVPPrefixColor(ProfileMenu.this.player)).open();
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    setItem(45, (InventoryAbs.Item)new InventoryAbs.ItemAbs(Store) {
          public void onClick(InventoryClickEvent e) {
            (new ShopMenu(ProfileMenu.this.player)).open();
            ProfileMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
  }
}
