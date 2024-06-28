package cn.lemonnetwork.catpixellobby.MinecraftServer.Command.adminCommand;

import cn.lemonnetwork.catpixellobby.Database.MySQL;
import java.util.Objects;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class blockcommand implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    if (player.hasPermission("catpixellobby.admin.block")) {
      if (((String)Objects.<String>requireNonNull(MySQL.QueryLobbySettings(player, "editmode"))).equalsIgnoreCase("false")) {
        player.sendMessage("§a你现在可以随意在任意大厅中破坏和放置方块了！");
        MySQL.UpdataLobbySettings(player, "editmode", "true");
        player.setGameMode(GameMode.CREATIVE);
      } else if (((String)Objects.<String>requireNonNull(MySQL.QueryLobbySettings(player, "editmode"))).equalsIgnoreCase("true")) {
        player.sendMessage("§c你现在不能随意在任意大厅中破坏和放置方块了！");
        MySQL.UpdataLobbySettings(player, "editmode", "false");
        player.setGameMode(GameMode.ADVENTURE);
      } else {
        player.sendMessage("§c你没有权限可以这样做！");
        return true;
      } 
      return false;
    } 
    return false;
  }
}
