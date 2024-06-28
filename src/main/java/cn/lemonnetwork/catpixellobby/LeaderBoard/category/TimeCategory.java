package cn.lemonnetwork.catpixellobby.LeaderBoard.category;

public enum TimeCategory {
  WEEKLY("每周", 1, "weekly"),
  MONTHLY("每月", 2, "monthly"),
  LIFETIME("生涯", 3, "alltime");
  
  private final String DisplayName;
  
  private final int id;
  
  private final String PlaceHolder;
  
  TimeCategory(String DisplayName, int id, String PlaceHolder) {
    this.DisplayName = DisplayName;
    this.id = id;
    this.PlaceHolder = PlaceHolder;
  }
  
  public String getDisplayName() {
    return this.DisplayName;
  }
  
  public int getID() {
    return this.id;
  }
  
  public String getPlaceHolder() {
    return this.PlaceHolder;
  }
  
  public static TimeCategory getById(int id) {
    for (TimeCategory category : values()) {
      if (category.getID() == id)
        return category; 
    } 
    return null;
  }
  
  public static int getMinId() {
    int minId = Integer.MAX_VALUE;
    for (TimeCategory category : values()) {
      if (category.getID() < minId)
        minId = category.getID(); 
    } 
    return minId;
  }
  
  public static int getMaxId() {
    int maxId = Integer.MIN_VALUE;
    for (TimeCategory category : values()) {
      if (category.getID() > maxId)
        maxId = category.getID(); 
    } 
    return maxId;
  }
}
