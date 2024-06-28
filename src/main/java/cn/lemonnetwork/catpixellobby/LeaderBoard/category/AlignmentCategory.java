package cn.lemonnetwork.catpixellobby.LeaderBoard.category;

public enum AlignmentCategory {
  CENTER("中心对齐", 1),
  BLOCK("侧边对齐", 2);
  
  private final String DisplayName;
  
  private final int id;
  
  AlignmentCategory(String DisplayName, int id) {
    this.DisplayName = DisplayName;
    this.id = id;
  }
  
  public String getDisplayName() {
    return this.DisplayName;
  }
  
  public int getID() {
    return this.id;
  }
  
  public static AlignmentCategory getById(int id) {
    for (AlignmentCategory category : values()) {
      if (category.getID() == id)
        return category; 
    } 
    return null;
  }
  
  public static int getMinId() {
    int minId = Integer.MAX_VALUE;
    for (AlignmentCategory category : values()) {
      if (category.getID() < minId)
        minId = category.getID(); 
    } 
    return minId;
  }
  
  public static int getMaxId() {
    int maxId = Integer.MIN_VALUE;
    for (AlignmentCategory category : values()) {
      if (category.getID() > maxId)
        maxId = category.getID(); 
    } 
    return maxId;
  }
}
