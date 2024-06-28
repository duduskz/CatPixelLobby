package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Achievement.Achievement;
import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import com.yapzhenyie.GadgetsMenu.utils.mysteryboxes.MysteryBoxType;
import java.math.BigDecimal;
import me.yic.xconomy.api.XConomyAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SummerRewardsCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    if (sender.hasPermission("catpixellobby.admin")) {
      Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
      if (targetPlayer == null) {
        sender.sendMessage("§c没有找到这名玩家！");
        return true;
      } 
      giveRewardsToPlayer(targetPlayer);
    } else {
      sender.sendMessage("§cNot Permission");
      return true;
    } 
    return false;
  }
  
  private void giveRewardsToPlayer(Player player) {
    XConomyAPI xcapi = new XConomyAPI();
    PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(player);
    player.sendMessage("");
    player.sendMessage("§e活动奖励领取： 夏日探险箱");
    player.sendMessage("");
    player.sendMessage(" §d+ §6200喵星币");
    player.sendMessage(" §d+ §b10神秘宝箱§7[§e✫✫§7]");
    player.sendMessage(" §d+ §31,000 CatPixel NetWork经验");
    player.sendMessage("");
    Achievement.Unlock(player, "夏日探险！ (2024)", "解锁2024夏季探险活动", "unlockSummer2024", Integer.valueOf(15));
    xcapi.changePlayerBalance(player.getUniqueId(), player.getName(), BigDecimal.valueOf(200L), Boolean.valueOf(true));
    playerManager.giveMysteryBoxes(MysteryBoxType.NORMAL_MYSTERY_BOX_2, 
        Long.valueOf(System.currentTimeMillis() + 86400000L), true, null, 10);
    AlonsoLevelsAPI.addExperience(player.getUniqueId(), 1000);
  }
}
