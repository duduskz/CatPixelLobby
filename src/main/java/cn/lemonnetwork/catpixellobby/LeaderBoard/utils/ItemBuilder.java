package cn.lemonnetwork.catpixellobby.LeaderBoard.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

public class ItemBuilder {
  private ItemStack is;
  
  public ItemBuilder(Material mat) {
    this.is = new ItemStack(mat);
  }
  
  public ItemBuilder(ItemStack is) {
    this.is = is;
  }
  
  public ItemBuilder material(Material mat) {
    this.is = new ItemStack(mat);
    return this;
  }
  
  public ItemBuilder amount(int amount) {
    this.is.setAmount(amount);
    return this;
  }
  
  public ItemBuilder name(String name) {
    ItemMeta meta = this.is.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder setLetherColor(Color color) {
    LeatherArmorMeta im = (LeatherArmorMeta)this.is.getItemMeta();
    im.setColor(color);
    this.is.setItemMeta((ItemMeta)im);
    return this;
  }
  
  public ItemBuilder setSkullOwner(String owner) {
    SkullMeta im = (SkullMeta)this.is.getItemMeta();
    im.setOwner(owner);
    this.is.setItemMeta((ItemMeta)im);
    return this;
  }
  
  public ItemBuilder setNewSkullOwner(Player player) {
    ItemMeta meta = this.is.getItemMeta();
    try {
      Field f = meta.getClass().getDeclaredField("profile");
      f.setAccessible(true);
      f.set(meta, player.getClass().getDeclaredMethod("getProfile", new Class[0]).invoke(player, new Object[0]));
    } catch (ReflectiveOperationException e) {
      Bukkit.getConsoleSender().sendMessage("Unexpected error ocurred profile on skull");
    } 
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder lore(String name) {
    ItemMeta meta = this.is.getItemMeta();
    List<String> lore = meta.getLore();
    if (lore == null)
      lore = new ArrayList<>(); 
    lore.add(ChatColor.translateAlternateColorCodes('&', name));
    meta.setLore(lore);
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder lore(String... lore) {
    List<String> toSet = new ArrayList<>();
    ItemMeta meta = this.is.getItemMeta();
    for (String string : lore)
      toSet.add(ChatColor.translateAlternateColorCodes('&', string)); 
    meta.setLore(toSet);
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder enchant(Enchantment enchantment, int i) {
    this.is.addUnsafeEnchantment(enchantment, i);
    return this;
  }
  
  public ItemBuilder lore(List<String> lore) {
    List<String> toSet = new ArrayList<>();
    ItemMeta meta = this.is.getItemMeta();
    for (String string : lore)
      toSet.add(ChatColor.translateAlternateColorCodes('&', string)); 
    meta.setLore(toSet);
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder durability(int durability) {
    this.is.setDurability((short)durability);
    return this;
  }
  
  public ItemBuilder enchantment(Enchantment enchantment, int level) {
    this.is.addUnsafeEnchantment(enchantment, level);
    return this;
  }
  
  public ItemBuilder enchantment(Enchantment enchantment) {
    this.is.addUnsafeEnchantment(enchantment, 1);
    return this;
  }
  
  public ItemBuilder shiny() {
    return enchant(Enchantment.LURE, 1).flags(ItemFlag.values());
  }
  
  public ItemBuilder flags(ItemFlag... flags) {
    ItemMeta itemMeta = this.is.getItemMeta();
    itemMeta.addItemFlags(flags);
    this.is.setItemMeta(itemMeta);
    return this;
  }
  
  public ItemBuilder type(Material material) {
    this.is.setType(material);
    return this;
  }
  
  public ItemBuilder clearLore() {
    ItemMeta meta = this.is.getItemMeta();
    meta.setLore(new ArrayList());
    this.is.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder clearEnchantments() {
    for (Enchantment e : this.is.getEnchantments().keySet())
      this.is.removeEnchantment(e); 
    return this;
  }
  
  public ItemBuilder addPotionEffect(PotionEffect effect, boolean b) {
    if (this.is.getItemMeta() instanceof PotionMeta) {
      PotionMeta meta = (PotionMeta)this.is.getItemMeta();
      meta.addCustomEffect(effect, b);
      this.is.setItemMeta((ItemMeta)meta);
    } 
    return this;
  }
  
  public ItemStack build() {
    return this.is;
  }
}
