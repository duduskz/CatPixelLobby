package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class AssembleBoardEntry {
  private final AssembleBoard board;
  
  private String text;
  
  private String identifier;
  
  private Team team;
  
  private final int position;
  
  public AssembleBoardEntry(AssembleBoard board, String text, int position) {
    this.board = board;
    this.text = text;
    this.position = position;
    this.identifier = this.board.getUniqueIdentifier(position);
    setup();
  }
  
  public void setup() {
    Scoreboard scoreboard = this.board.getScoreboard();
    if (scoreboard == null)
      return; 
    String teamName = this.identifier;
    if (teamName.length() > 16)
      teamName = teamName.substring(0, 16); 
    Team team = scoreboard.getTeam(teamName);
    if (team == null)
      team = scoreboard.registerNewTeam(teamName); 
    if (team.getEntries() == null || team.getEntries().isEmpty() || !team.getEntries().contains(this.identifier))
      team.addEntry(this.identifier); 
    if (!this.board.getEntries().contains(this))
      this.board.getEntries().add(this); 
    this.team = team;
  }
  
  public void send(int position) {
    if (this.text.length() > 16) {
      String suffix, prefix = this.text.substring(0, 16);
      if (prefix.charAt(15) == '§') {
        prefix = prefix.substring(0, 15);
        suffix = this.text.substring(15);
      } else if (prefix.charAt(14) == '§') {
        prefix = prefix.substring(0, 14);
        suffix = this.text.substring(14);
      } else if (ChatColor.getLastColors(prefix).equalsIgnoreCase(ChatColor.getLastColors(this.identifier))) {
        suffix = this.text.substring(16);
      } else {
        suffix = ChatColor.getLastColors(prefix) + ChatColor.getLastColors(prefix);
      } 
      if (suffix.length() > 16)
        suffix = suffix.substring(0, 16); 
      this.team.setPrefix(prefix);
      this.team.setSuffix(suffix);
    } else {
      this.team.setPrefix(this.text);
      this.team.setSuffix("");
    } 
    Score score = this.board.getObjective().getScore(this.identifier);
    score.setScore(position);
  }
  
  public void remove() {
    this.board.getIdentifiers().remove(this.identifier);
    this.board.getScoreboard().resetScores(this.identifier);
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
}
