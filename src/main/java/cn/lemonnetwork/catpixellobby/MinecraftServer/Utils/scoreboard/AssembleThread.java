package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class AssembleThread extends Thread {
  private final Assemble assemble;
  
  private final ConcurrentHashMap<UUID, AssembleBoard> boards;
  
  AssembleThread(Assemble assemble) {
    super("Scoreboard | Thread");
    this.assemble = assemble;
    this.boards = (ConcurrentHashMap<UUID, AssembleBoard>)assemble.getBoards();
    start();
  }
  
  public void run() {
    while (true) {
      try {
        while (true) {
          tick();
          Thread.sleep(this.assemble.getTicks() * 50L);
        } 
      } catch (InterruptedException e) {
        e.printStackTrace();
        break;
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }
  
  private void tick() {
    for (UUID uuid : this.boards.keySet()) {
      AssembleBoard board;
      Player player = Bukkit.getPlayer(uuid);
      if (player == null || !player.isOnline())
        continue; 
      synchronized (this.boards) {
        board = this.boards.get(uuid);
        if (board == null)
          continue; 
      } 
      Scoreboard scoreboard = board.getScoreboard();
      Objective objective = board.getObjective();
      if (scoreboard == null || objective == null)
        continue; 
      String title = ChatColor.translateAlternateColorCodes('&', this.assemble.getAdapter().getTitle(player));
      if (!objective.getDisplayName().equals(title))
        objective.setDisplayName(title); 
      List<String> newLines = this.assemble.getAdapter().getLines(player);
      if (newLines == null || newLines.isEmpty()) {
        board.getEntries().forEach(AssembleBoardEntry::remove);
        board.getEntries().clear();
      } else {
        if (newLines.size() > 20)
          newLines = newLines.subList(0, 20); 
        if (!this.assemble.getAssembleStyle().isDescending())
          Collections.reverse(newLines); 
        int cache = this.assemble.getAssembleStyle().getStartNumber();
        for (int i = 0; i < newLines.size(); i++) {
          AssembleBoardEntry entry = board.getEntryAtPosition(i);
          String line = ChatColor.translateAlternateColorCodes('&', newLines.get(i));
          if (entry == null)
            entry = new AssembleBoardEntry(board, line, i); 
          entry.setText(line);
          entry.setup();
          entry.send(this.assemble.getAssembleStyle().isDescending() ? cache-- : cache++);
        } 
      } 
      if (player.getScoreboard() != scoreboard && !this.assemble.isHook())
        player.setScoreboard(scoreboard); 
    } 
  }
}
