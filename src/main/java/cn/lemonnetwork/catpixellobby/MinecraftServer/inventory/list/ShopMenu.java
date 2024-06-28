package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list;

import cn.lemonnetwork.catpixellobby.MinecraftServer.API;
import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.ItemUtils;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.InventoryAbs;
import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ShopMenu extends InventoryAbs {
  private Player player;
  
  public ShopMenu(Player p) {
    super(p, 6, "猫咪商店");
    this.player = p;
  }
  
  public void setup() {
    String playerName = this.player.getName();
    ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    SkullMeta skullMeta = (SkullMeta)playerHead.getItemMeta();
    skullMeta.setOwner(playerName);
    playerHead.setItemMeta((ItemMeta)skullMeta);
    ItemUtils.createItem(playerHead, "§a个人档案", Arrays.asList(new String[] { "§7查看自己在CatPixel上面的个人资料和信息及更多内容！", "", "§e点击切换！" }));
    setItem(1, (InventoryAbs.Item)new InventoryAbs.ItemAbs(playerHead) {
          public void onClick(InventoryClickEvent e) {
            Player player1 = (Player)e.getWhoClicked();
            (new ProfileMenu(player1)).open();
            ShopMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    ItemStack games = new ItemStack(Material.COMPASS, 1);
    ItemUtils.createItem(games, "§a游戏菜单", Arrays.asList(new String[] { "§7想在这个服务器上游玩游戏吗？", "§7你只需要点击这个菜单就可以和你的小伙伴们", "§7一起愉快的玩耍了！", "", "§e点击切换！" }));
    setItem(0, (InventoryAbs.Item)new InventoryAbs.ItemAbs(games) {
          public void onClick(InventoryClickEvent e) {
            Player whoClicked = (Player)e.getWhoClicked();
            (new GameMenu(whoClicked)).open();
            ShopMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.CLICK, 1.0F, 1.0F);
          }
        });
    ItemStack shopMenu = new ItemStack(Material.EMERALD, 1);
    ItemUtils.createItem(shopMenu, "§a猫咪商店", Arrays.asList(new String[] { "§7在这里查看CatPixel Network商店！", "§7", "§7你的CatPixel点券数量: §6" + 
            
            API.getPlayerPoints(this.player), "", "§e点击切换！" }));
    setItem(2, (InventoryAbs.Item)new InventoryAbs.ItemAbs(shopMenu) {
          public void onClick(InventoryClickEvent e) {
            Player whoClicked = (Player)e.getWhoClicked();
            (new GameMenu(whoClicked)).open();
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().sendMessage("§c你选择的已经是 猫咪商店 了！");
            ShopMenu.this.player.playSound(e.getWhoClicked().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          }
        });
    ItemStack blueglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
    ItemStack blackglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
    ItemUtils.createItem(blueglass, "§a已选择！", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
    ItemUtils.createItem(blackglass, "§c未选择！ (点击上方更换)", Arrays.asList(new String[] { "§7§l⇡ 选择状态", "§7§l⇣ 界面" }));
    setItem(9, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(10, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(11, (InventoryAbs.Item)new InventoryAbs.NoneItem(blueglass));
    setItem(12, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(13, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(14, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(15, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(16, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
    setItem(17, (InventoryAbs.Item)new InventoryAbs.NoneItem(blackglass));
  }
}
