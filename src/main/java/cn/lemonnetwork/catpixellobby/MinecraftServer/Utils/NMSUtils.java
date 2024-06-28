package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NMSUtils {
  private static Class<?> chatSerializer;
  
  private static Class<?> enumTitleAction;
  
  private static Class<?> packetPlayOutTitle;
  
  private static Class<?> packetPlayOutChat;
  
  private static String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
  
  static {
    chatSerializer = (version.indexOf("v1_8_R1") != -1) ? getNMSClass("ChatSerializer") : getNMSClass("IChatBaseComponent$ChatSerializer");
    enumTitleAction = (version.indexOf("v1_8_R1") != -1) ? getNMSClass("EnumTitleAction") : getNMSClass("PacketPlayOutTitle$EnumTitleAction");
    packetPlayOutTitle = getNMSClass("PacketPlayOutTitle");
    packetPlayOutChat = getNMSClass("PacketPlayOutChat");
  }
  
  public static Class<?> getPacketPlayOutTitleClass() {
    return packetPlayOutTitle;
  }
  
  public static Class<?> getPacketPlayOutChatClass() {
    return packetPlayOutChat;
  }
  
  public static Class<?> getEnumTitleActionClass() {
    return enumTitleAction;
  }
  
  public static Class<?> getChatSerializerClass() {
    return chatSerializer;
  }
  
  public static String getVersion() {
    return version;
  }
  
  public static Class<?> getOBCClass(String className) {
    try {
      return Class.forName("org.bukkit.craftbukkit." + getVersion() + "." + className);
    } catch (ClassNotFoundException var2) {
      var2.printStackTrace();
      return null;
    } 
  }
  
  public static Object getNMSItem(ItemStack is) {
    try {
      return getOBCClass("inventory.CraftItemStack").getMethod("asNMSCopy", new Class[] { ItemStack.class }).invoke(is, new Object[] { is });
    } catch (Exception var2) {
      System.out.println("错误: " + var2.getMessage());
      return null;
    } 
  }
  
  public static Class<?> getNMSClass(String className) {
    try {
      return Class.forName("net.minecraft.server." + version + "." + className);
    } catch (Exception var2) {
      System.out.println("错误: " + var2.getMessage());
      return null;
    } 
  }
  
  public static void sendPacket(Player player, Object packet) {
    Object entityPlayer = getNMSPlayer(player);
    try {
      Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
      playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
    } catch (Exception var4) {
      System.out.println("错误: " + var4.getMessage());
    } 
  }
  
  public static Object getNMSPlayer(Player player) {
    try {
      Object entityPlayer = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
      return entityPlayer;
    } catch (Exception var2) {
      System.out.println("错误: " + var2.getMessage());
      return player;
    } 
  }
}
