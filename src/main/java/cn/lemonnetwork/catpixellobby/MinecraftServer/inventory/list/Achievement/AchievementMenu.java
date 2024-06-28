package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.Achievement;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import com.yapzhenyie.GadgetsMenu.utils.mysteryboxes.MysteryBoxType;
import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AchievementMenu extends InventoryAbs {
  private Player player;
  
  public AchievementMenu(Player p) {
    super(p, 6, "成就点数奖励系统");
    this.player = p;
  }
  
  public void setup() {
    if (MySQL.FoundPlayerAchievementRewardState(this.player, "Rewards_one").equalsIgnoreCase("2")) {
      ItemStack gold = new ItemStack(Material.GOLD_NUGGET, 1);
      ItemUtils.createItem(gold, "§a§l普通 §a成就奖励", Arrays.asList(new String[] { "§8新手", "§7要求点数: §e20", "§7", "§7奖励：", "§8+§35,000§7点CatPixel经验", "§8+§b10§7个大厅神秘宝箱", "", "§e点击领取！" }));
      setItem(27, (InventoryAbs.Item)new InventoryAbs.ItemAbs(gold) {
            public void onClick(InventoryClickEvent e) {
              AchievementMenu.this.player.playSound(AchievementMenu.this.player.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
              AchievementMenu.this.player.sendMessage("§a你成功的领取了这个奖励！");
              AchievementMenu.this.player.sendMessage("§8 +§35,000点CatPixel经验");
              AchievementMenu.this.player.sendMessage("§8 +§b10个大厅神秘宝箱");
              AchievementMenu.this.player.closeInventory();
              AlonsoLevelsAPI.addExperience(AchievementMenu.this.player.getUniqueId(), 5000);
              PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(AchievementMenu.this.player);
              playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_1, Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 10);
              MySQL.setPlayerAchievementRewardState(AchievementMenu.this.player, "Rewards_one", 3);
            }
          });
    } else if (MySQL.FoundPlayerAchievementRewardState(this.player, "Rewards_one").equalsIgnoreCase("1")) {
      ItemStack coal = new ItemStack(Material.COAL, 1);
      ItemUtils.createItem(coal, "§a§l普通 §a成就奖励", Arrays.asList(new String[] { "§8新手", "§7要求点数: §e20", "§7", "§7奖励：", "§8+§35,000§7点CatPixel经验", "§8+§b10§7个大厅神秘宝箱", "", "§c你还没有达到领取的条件！" }));
      setItem(27, (InventoryAbs.Item)new InventoryAbs.ItemAbs(coal) {
            public void onClick(InventoryClickEvent e) {
              AchievementMenu.this.player.playSound(AchievementMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              AchievementMenu.this.player.sendMessage("§c你还没有达到领取的要求！");
              AchievementMenu.this.player.closeInventory();
            }
          });
    } else if (MySQL.FoundPlayerAchievementRewardState(this.player, "Rewards_one").equalsIgnoreCase("3")) {
      ItemStack gold = new ItemStack(Material.GOLD_NUGGET, 1);
      ItemUtils.createItem(gold, "§a§l普通 §a成就奖励", Arrays.asList(new String[] { "§8新手", "§7要求点数: §e20", "§7", "§7奖励：", "§8+§35,000§7点CatPixel经验", "§8+§b10§7个大厅神秘宝箱", "", "§c你已经领取过了！" }));
      setItem(27, (InventoryAbs.Item)new InventoryAbs.ItemAbs(gold) {
            public void onClick(InventoryClickEvent e) {
              AchievementMenu.this.player.playSound(AchievementMenu.this.player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
              AchievementMenu.this.player.sendMessage("§c你已经领取过这个奖励了！");
              AchievementMenu.this.player.closeInventory();
            }
          });
    } 
  }
}
