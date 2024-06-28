package cn.lemonnetwork.catpixellobby.LeaderBoard.category;

public enum ModeCategory {
  ALL("所有模式", 1, "bw1058_stats_kills", "bw1058_stats_wins"),
  SOLO("单挑模式", 2, "pgstats_kills_solo", "pgstats_wins_solo"),
  DOUBLE("双人模式", 3, "pgstats_kills_double", "pgstats_wins_double"),
  THREE_THREE_THREE_THREE("3v3v3v3", 4, "pgstats_kills_3v3v3v3", "pgstats_wins_3v3v3v3"),
  TEAM("4v4v4v4", 5, "pgstats_kills_4v4v4v4", "pgstats_wins_4v4v4v4"),
  DREAM_TEAM("§6梦幻双人", 6, "pgstats_kills_dream_team", "pgstats_wins_dream_team"),
  DREAM_FOUR("§6梦幻4V4", 7, "pgstats_kills_dream_4v4v4v4", "pgstats_wins_dream_4v4v4v4");
  
  private final String DisplayName;
  
  private final int id;
  
  private final String PlaceHolderKill;
  
  private final String PlaceHolderWin;
  
  ModeCategory(String DisplayName, int id, String PlaceHolderKill, String PlaceHolderWin) {
    this.DisplayName = DisplayName;
    this.id = id;
    this.PlaceHolderKill = PlaceHolderKill;
    this.PlaceHolderWin = PlaceHolderWin;
  }
  
  public String getDisplayName() {
    return this.DisplayName;
  }
  
  public int getID() {
    return this.id;
  }
  
  public String getPlaceHolderKill() {
    return this.PlaceHolderKill;
  }
  
  public String getPlaceHolderWin() {
    return this.PlaceHolderWin;
  }
  
  public static ModeCategory getById(int id) {
    for (ModeCategory category : values()) {
      if (category.getID() == id)
        return category; 
    } 
    return null;
  }
  
  public static int getMinId() {
    int minId = Integer.MAX_VALUE;
    for (ModeCategory category : values()) {
      if (category.getID() < minId)
        minId = category.getID(); 
    } 
    return minId;
  }
  
  public static int getMaxId() {
    int maxId = Integer.MIN_VALUE;
    for (ModeCategory category : values()) {
      if (category.getID() > maxId)
        maxId = category.getID(); 
    } 
    return maxId;
  }
}
