package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import java.util.Objects;
import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LuckPerms {
  public static String getPrefix(Player p) {
    String prefix = ((User)Objects.<User>requireNonNull(LuckPermsProvider.get().getUserManager().getUser(p.getUniqueId()))).getCachedData().getMetaData().getPrefix();
    return (prefix == null) ? "" : ChatColor.translateAlternateColorCodes('&', prefix);
  }
  
  public static String getPlayerGroupName(Player player) {
    String group = "%luckperms_groups%";
    group = PlaceholderAPI.setPlaceholders(player.getPlayer(), group);
    return group;
  }
}
