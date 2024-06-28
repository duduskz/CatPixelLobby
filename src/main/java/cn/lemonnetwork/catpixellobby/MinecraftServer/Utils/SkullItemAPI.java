package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullItemAPI {
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
