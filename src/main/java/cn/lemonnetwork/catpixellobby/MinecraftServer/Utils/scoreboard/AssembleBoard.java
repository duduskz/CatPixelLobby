package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard.events.AssembleBoardCreatedEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class AssembleBoard {
  private final Assemble assemble;
  
  private final List<AssembleBoardEntry> entries = new ArrayList<>();
  
  private final List<String> identifiers = new ArrayList<>();
  
  private final UUID uuid;
  
  public AssembleBoard(Player player, Assemble assemble) {
    this.uuid = player.getUniqueId();
    this.assemble = assemble;
    setup(player);
  }
  
  public Scoreboard getScoreboard() {
    Player player = Bukkit.getPlayer(getUuid());
    if (this.assemble.isHook() || player.getScoreboard() != Bukkit.getScoreboardManager().getMainScoreboard())
      return player.getScoreboard(); 
    return Bukkit.getScoreboardManager().getNewScoreboard();
  }
  
  public Objective getObjective() {
    Scoreboard scoreboard = getScoreboard();
    if (scoreboard.getObjective("Assemble") == null) {
      Objective objective = scoreboard.registerNewObjective("Assemble", "dummy");
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      objective.setDisplayName(getAssemble().getAdapter().getTitle(Bukkit.getPlayer(getUuid())));
      return objective;
    } 
    return scoreboard.getObjective("Assemble");
  }
  
  private void setup(Player player) {
    Scoreboard scoreboard = getScoreboard();
    player.setScoreboard(scoreboard);
    getObjective();
    AssembleBoardCreatedEvent createdEvent = new AssembleBoardCreatedEvent(this);
    Bukkit.getPluginManager().callEvent((Event)createdEvent);
  }
  
  public AssembleBoardEntry getEntryAtPosition(int pos) {
    return (pos >= this.entries.size()) ? null : this.entries.get(pos);
  }
  
  public String getUniqueIdentifier(int position) {
    String identifier = getRandomChatColor(position) + getRandomChatColor(position);
    while (this.identifiers.contains(identifier))
      identifier = identifier + identifier + getRandomChatColor(position); 
    if (identifier.length() > 16)
      return getUniqueIdentifier(position); 
    this.identifiers.add(identifier);
    return identifier;
  }
  
  private static String getRandomChatColor(int position) {
    return ChatColor.values()[position].toString();
  }
  
  public Assemble getAssemble() {
    return this.assemble;
  }
  
  public List<AssembleBoardEntry> getEntries() {
    return this.entries;
  }
  
  public List<String> getIdentifiers() {
    return this.identifiers;
  }
  
  public UUID getUuid() {
    return this.uuid;
  }
}
