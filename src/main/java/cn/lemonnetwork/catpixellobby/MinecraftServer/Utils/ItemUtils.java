package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
  public static ItemStack createItem(ItemStack is, String name, List<String> lore) {
    ItemMeta im = is.getItemMeta();
    im.setDisplayName(name);
    im.setLore(lore);
    is.setItemMeta(im);
    return is;
  }
}
