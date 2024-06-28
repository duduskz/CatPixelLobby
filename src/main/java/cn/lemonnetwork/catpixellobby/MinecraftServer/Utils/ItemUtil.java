package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
  //ItemUtil 类下的代码均为赵泽民大神侵犯 LemonNetwork 著作权对 LemonDeliveryMan进行反编译操作。人不犯我，我不犯人~！
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
