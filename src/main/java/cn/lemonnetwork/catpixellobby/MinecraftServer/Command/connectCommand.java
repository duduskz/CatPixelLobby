package cn.lemonnetwork.catpixellobby.MinecraftServer.Command;

import cn.lemonnetwork.catpixellobby.MinecraftServer.BungeeCord.ConnectServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class connectCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
    Player player = (Player)sender;
    if (args.length == 0) {
      sender.sendMessage("");
      sender.sendMessage("§c使用帮助: /connect <server.");
      sender.sendMessage("");
      return true;
    } 
    if (args[0].equalsIgnoreCase("BEDWARS")) {
      ConnectServer.FindServer(player, "BW_LOBBY");
      return true;
    } 
    if (args[0].equalsIgnoreCase("THEPIT")) {
      ConnectServer.FindServer(player, "THEPIT");
      return true;
    } 
    if (args[0].equalsIgnoreCase("MEGAWALSS")) {
      ConnectServer.FindServer(player, "MW_LOBBY");
      return true;
    } 
    if (args[0].equalsIgnoreCase("DUEL")) {
      ConnectServer.FindServer(player, "DUEL");
      return true;
    } 
    if (args[0].equalsIgnoreCase("SKYPVP")) {
      ConnectServer.FindServer(player, "SKYPVP");
      return true;
    } 
    if (args[0].equalsIgnoreCase("ArcadeLobby")) {
      ConnectServer.FindServer(player, "ArcadeLobby");
      return true;
    } 
    if (args[0].equalsIgnoreCase("UHC")) {
      ConnectServer.FindServer(player, "UHC_LOBBY");
      return true;
    } 
    if (args[0].equalsIgnoreCase("MurderMystery")) {
      ConnectServer.FindServer(player, "MM_LOBBY");
      return true;
    } 
    if (args[0].equalsIgnoreCase("BuildBattleLobby")) {
      ConnectServer.FindServer(player, "BuildBattleLobby");
      return true;
    } 
    sender.sendMessage("§c子服有误，请检查配置文件中是否添加！");
    return true;
  }
}
