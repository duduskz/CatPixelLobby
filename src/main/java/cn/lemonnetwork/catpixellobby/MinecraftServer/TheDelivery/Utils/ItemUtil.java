package cn.lemonnetwork.catpixellobby.MinecraftServer.TheDelivery.Utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
  public static ItemStack CreateItem(Material type, String disname, ArrayList<String> lore) {
    ItemStack item = new ItemStack(type);
    ItemMeta im = item.getItemMeta();
    im.setDisplayName(disname.replace("&", "§"));
    im.setLore(lore);
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_PLACED_ON });
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
    item.setItemMeta(im);
    return item;
  }
}
