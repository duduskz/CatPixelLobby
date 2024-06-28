package cn.lemonnetwork.catpixellobby.MinecraftServer.Utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class sendActionbarAPI {
  public static void sendActionbar(Player p, String msg) {
    PacketPlayOutChat chat = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + msg + "\"}"), (byte)2);
    (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)chat);
  }
}
