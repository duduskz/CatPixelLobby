package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events.AssembleBoardCreateEvent;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Assemble {
  private JavaPlugin plugin;
  
  private AssembleAdapter adapter;
  
  private AssembleThread thread;
  
  private AssembleListener listeners;
  
  private AssembleStyle assembleStyle = AssembleStyle.MODERN;
  
  private Map<UUID, AssembleBoard> boards;
  
  private long ticks = 2L;
  
  private boolean hook = false, debugMode = true;
  
  public Assemble(JavaPlugin plugin, AssembleAdapter adapter) {
    if (plugin == null)
      throw new RuntimeException("Assemble can not be instantiated without a plugin instance!"); 
    this.plugin = plugin;
    this.adapter = adapter;
    this.boards = new ConcurrentHashMap<>();
    setup();
  }
  
  public void setup() {
    this.listeners = new AssembleListener(this);
    this.plugin.getServer().getPluginManager().registerEvents(this.listeners, (Plugin)this.plugin);
    if (this.thread != null) {
      this.thread.stop();
      this.thread = null;
    } 
    for (Player player : Bukkit.getOnlinePlayers()) {
      AssembleBoardCreateEvent createEvent = new AssembleBoardCreateEvent(player);
      Bukkit.getPluginManager().callEvent((Event)createEvent);
      if (createEvent.isCancelled())
        return; 
      getBoards().putIfAbsent(player.getUniqueId(), new AssembleBoard(player, this));
    } 
    this.thread = new AssembleThread(this);
  }
  
  public void cleanup() {
    if (this.thread != null) {
      this.thread.stop();
      this.thread = null;
    } 
    if (this.listeners != null) {
      HandlerList.unregisterAll(this.listeners);
      this.listeners = null;
    } 
    for (UUID uuid : getBoards().keySet()) {
      Player player = Bukkit.getPlayer(uuid);
      if (player == null || !player.isOnline())
        continue; 
      getBoards().remove(uuid);
      player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    } 
  }
  
  public JavaPlugin getPlugin() {
    return this.plugin;
  }
  
  public AssembleAdapter getAdapter() {
    return this.adapter;
  }
  
  public AssembleThread getThread() {
    return this.thread;
  }
  
  public AssembleListener getListeners() {
    return this.listeners;
  }
  
  public AssembleStyle getAssembleStyle() {
    return this.assembleStyle;
  }
  
  public Map<UUID, AssembleBoard> getBoards() {
    return this.boards;
  }
  
  public long getTicks() {
    return this.ticks;
  }
  
  public boolean isHook() {
    return this.hook;
  }
  
  public boolean isDebugMode() {
    return this.debugMode;
  }
  
  public void setPlugin(JavaPlugin plugin) {
    this.plugin = plugin;
  }
  
  public void setAdapter(AssembleAdapter adapter) {
    this.adapter = adapter;
  }
  
  public void setThread(AssembleThread thread) {
    this.thread = thread;
  }
  
  public void setListeners(AssembleListener listeners) {
    this.listeners = listeners;
  }
  
  public void setAssembleStyle(AssembleStyle assembleStyle) {
    this.assembleStyle = assembleStyle;
  }
  
  public void setBoards(Map<UUID, AssembleBoard> boards) {
    this.boards = boards;
  }
  
  public void setTicks(long ticks) {
    this.ticks = ticks;
  }
  
  public void setHook(boolean hook) {
    this.hook = hook;
  }
  
  public void setDebugMode(boolean debugMode) {
    this.debugMode = debugMode;
  }
}
