package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Title {
  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subTitle) {
    ProtocolManager pm = ProtocolLibrary.getProtocolManager();
    if (title != null) {
      title = ChatColor.translateAlternateColorCodes('&', title);
      title = title.replaceAll("%player%", player.getName());
      PacketContainer packet = pm.createPacket(PacketType.Play.Server.TITLE);
      packet.getTitleActions().write(0, EnumWrappers.TitleAction.TITLE);
      packet.getChatComponents().write(0, WrappedChatComponent.fromText(title));
      packet.getIntegers().write(0, fadeIn);
      packet.getIntegers().write(1, stay);
      packet.getIntegers().write(2, fadeOut);
      pm.sendServerPacket(player, packet, false);
    } 
    if (subTitle != null) {
      subTitle = ChatColor.translateAlternateColorCodes('&', subTitle);
      subTitle = subTitle.replaceAll("%player%", player.getName());
      PacketContainer packet = pm.createPacket(PacketType.Play.Server.TITLE);
      packet.getTitleActions().write(0, EnumWrappers.TitleAction.SUBTITLE);
      packet.getChatComponents().write(0, WrappedChatComponent.fromText(subTitle));
      packet.getIntegers().write(0, fadeIn);
      packet.getIntegers().write(1, stay);
      packet.getIntegers().write(2, fadeOut);
      pm.sendServerPacket(player, packet, false);
    } 
  }
}
