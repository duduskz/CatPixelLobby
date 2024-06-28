package cn.lemonnetwork.catpixellobby.TheDelivery;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class LobbyTheDelivery implements CommandExecutor {
  CatPixelLobby plugin = CatPixelLobby.getInstance();
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player player = (Player)sender;
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100.0F, 1.0F), 10L);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100.0F, 1.0F), 15L);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100.0F, 1.0F), 20L);
    List<Item> items = new ArrayList<>();
    Item item = player.getWorld().dropItem(new Location(player.getWorld(), -8.539D, 86.15D, -17.0D), new ItemStack(Material.DIAMOND));
    item.setMetadata("TheDeliveryCommand", (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, Boolean.valueOf(true)));
    item.setPickupDelay(2147483647);
    items.add(item);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> {
          Item item1 = player.getWorld().dropItem(new Location(player.getWorld(), -8.539D, 86.15D, -17.497D), new ItemStack(Material.EMERALD));
          item1.setMetadata("TheDeliveryCommand", (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, Boolean.valueOf(true)));
          item1.setPickupDelay(2147483647);
          items.add(item1);
        },10L);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> {
          Item item1 = player.getWorld().dropItem(new Location(player.getWorld(), -8.539D, 86.15D, -17.497D), new ItemStack(Material.DIAMOND));
          item1.setMetadata("TheDeliveryCommand", (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, Boolean.valueOf(true)));
          item1.setPickupDelay(2147483647);
          items.add(item1);
        },15L);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> {
          Item item1 = player.getWorld().dropItem(new Location(player.getWorld(), -8.539D, 86.15D, -17.497D), new ItemStack(Material.DIAMOND));
          item1.setMetadata("TheDeliveryCommand", (MetadataValue)new FixedMetadataValue((Plugin)this.plugin, Boolean.valueOf(true)));
          item1.setPickupDelay(2147483647);
          items.add(item1);
        },20L);
    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, () -> {
          Iterator<Item> var1 = items.iterator();
          while (var1.hasNext()) {
            Item var1x = var1.next();
            var1x.remove();
          } 
        },200L);
    return false;
  }
}
