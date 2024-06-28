package cn.lemonnetwork.catpixellobby.LeaderBoard.category;

public enum ViewCategory {
  TOP("前十名", 1),
  AROUND("与你水平相似的玩家", 2);
  
  private final String DisplayName;
  
  private final int id;
  
  ViewCategory(String DisplayName, int id) {
    this.DisplayName = DisplayName;
    this.id = id;
  }
  
  public String getDisplayName() {
    return this.DisplayName;
  }
  
  public int getID() {
    return this.id;
  }
  
  public static ViewCategory getById(int id) {
    for (ViewCategory category : values()) {
      if (category.getID() == id)
        return category; 
    } 
    return null;
  }
  
  public static int getMinId() {
    int minId = Integer.MAX_VALUE;
    for (ViewCategory category : values()) {
      if (category.getID() < minId)
        minId = category.getID(); 
    } 
    return minId;
  }
  
  public static int getMaxId() {
    int maxId = Integer.MIN_VALUE;
    for (ViewCategory category : values()) {
      if (category.getID() > maxId)
        maxId = category.getID(); 
    } 
    return maxId;
  }
}
