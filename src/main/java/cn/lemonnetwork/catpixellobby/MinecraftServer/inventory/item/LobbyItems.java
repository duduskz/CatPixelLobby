package cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.item;

import cn.lemonnetwork.catpixellobby.CatPixelLobby;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.ChangeLobbyMenu;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.GameMenu;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.ProfileMenu;
import cn.lemonnetwork.catpixellobby.MinecraftServer.inventory.list.ShopMenu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class LobbyItems implements Listener {
  boolean hidden = false;
  
  HashMap<Player, BukkitTask> hiddenCoolDown = new HashMap<>();
  
  @EventHandler
  public void joinServerGiveItems(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    giveItem(player);
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (e.getItem() != null && (e
      .getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e
      .getItem().getType() == Material.INK_SACK)
      hidden(p); 
  }
  
  void giveItem(Player player) {
    ItemStack ink = new ItemStack(Material.INK_SACK, 1, (short)(byte)(!this.hidden ? 10 : 8));
    ItemStack SKULL = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    ItemStack COMPASS = new ItemStack(Material.COMPASS, 1);
    ItemStack EMERALD = new ItemStack(Material.EMERALD, 1);
    ItemStack LOBBY = new ItemStack(Material.NETHER_STAR, 1);
    ItemMeta Inkmeta = ink.getItemMeta();
    ItemMeta COMPASS_META = COMPASS.getItemMeta();
    ItemMeta EMERALD_META = EMERALD.getItemMeta();
    ItemMeta LOBBY_META = LOBBY.getItemMeta();
    SkullMeta SKULLMETA = (SkullMeta)SKULL.getItemMeta();
    SKULLMETA.setOwner(player.getName());
    Inkmeta.setDisplayName((!this.hidden ? "§f玩家： §a可见" : "§f玩家： §c隐藏") + " §7(右键点击)");
    LOBBY_META.setDisplayName("§a切换大厅§7(右键点击)");
    LOBBY_META.setLore(Arrays.asList(new String[] { "§7右击查看服务器所有大厅列表" }));
    EMERALD_META.setDisplayName("§a猫咪商城§7(右键点击)");
    EMERALD_META.setLore(Arrays.asList(new String[] { "§7右键查看CatPixel商城" }));
    SKULLMETA.setDisplayName("§a个人档案§7(右键点击)");
    SKULLMETA.setLore(Arrays.asList(new String[] { "§7查看自己在CatPixel上面的个人资料和信息及更多内容！" }));
    COMPASS_META.setDisplayName("§a游戏菜单§7(右键点击)");
    COMPASS_META.setLore(Arrays.asList(new String[] { "§7想在这个服务器上游玩游戏吗？", "§7你只需要点击这个菜单就可以和你的小伙伴们", "§7一起愉快的玩耍了！", "" }));
    COMPASS.setItemMeta(COMPASS_META);
    SKULL.setItemMeta((ItemMeta)SKULLMETA);
    EMERALD.setItemMeta(EMERALD_META);
    LOBBY.setItemMeta(LOBBY_META);
    ink.setItemMeta(Inkmeta);
    player.getInventory().setItem(0, COMPASS);
    player.getInventory().setItem(1, SKULL);
    player.getInventory().setItem(2, EMERALD);
    player.getInventory().setItem(8, LOBBY);
    player.getInventory().setItem(7, ink);
  }
  
  void hidden(Player p) {
    if (this.hiddenCoolDown.containsKey(p)) {
      p.sendMessage("§c连续使用时间间隔为§e3§c秒");
    } else {
      if (!this.hidden) {
        for (Player online : Bukkit.getOnlinePlayers()) {
          p.hidePlayer(online);
        }
        p.sendMessage("§c你关闭了玩家显示！");
        this.hidden = true;
      } else {
        for (Player online : Bukkit.getOnlinePlayers()) {
          p.showPlayer(online);
        }
        p.sendMessage("§a你开启了玩家显示！");
        this.hidden = false;
      }
      giveItem(p);
      BukkitTask result = Bukkit.getScheduler().runTaskLater((Plugin)CatPixelLobby.getInstance(), () -> {
            BukkitTask task = this.hiddenCoolDown.remove(p);
          },60L);
      this.hiddenCoolDown.put(p, result);
    } 
  }
  
  @EventHandler
  public void onClick(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    try {
      if (event.getPlayer().getItemInHand() != null) {
        if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a个人档案§7(右键点击)"))
          (new ProfileMenu(event.getPlayer())).open(); 
        if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("游戏菜单"))
          (new GameMenu(event.getPlayer())).open(); 
        if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("猫咪商城"))
          (new ShopMenu(event.getPlayer())).open(); 
        if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("切换大厅"))
          (new ChangeLobbyMenu(event.getPlayer())).open(); 
      } 
    } catch (NullPointerException nullPointerException) {}
  }
}
