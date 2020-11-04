package com.github.carthax08.servermoderation.commands;

import com.github.carthax08.servermoderation.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanIp implements CommandExecutor {

    Main main;
    public BanIp(Main plugin){
        main = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if(args.length == 0){
           sender.sendMessage("You must provide a player or an IP as well as a reason!");
           return false;
       }else if(args.length == 1){
           sender.sendMessage("You must provide a reason!");
           return false;
       }else{
           for(OfflinePlayer player : Bukkit.getOfflinePlayers()){
               if(args[0].equalsIgnoreCase(player.getName())){
                   String message = "";
                   for(int i = 1;i<args.length;i++){
                       message = message + args[i] + " ";
                   }
                   Bukkit.getBanList(BanList.Type.IP).addBan(main.getConfig().getString("ips." + args[0] + "ip"), message, null, sender.getName());
                   sender.sendMessage("Success!");
                   return true;
               }
           }
           for(Player player : Bukkit.getOnlinePlayers()){
               if(player.getName().equalsIgnoreCase(args[0])){
                   String message = "";
                   for(int i = 1;i < args.length; i++){
                       message = message + args[i] + " ";
                   }
                   Bukkit.getBanList(BanList.Type.IP).addBan(player.getAddress().getHostName(), message, null, sender.getName());
                   sender.sendMessage("Success!");
                   return true;
               }
           }
           String message = "";
           for(int i = 1;i < args.length; i++){
               message = message + args[i] + " ";
           }
           Bukkit.getBanList(BanList.Type.IP).addBan(args[0], message, null, sender.getName());
           sender.sendMessage("Success!");
           return true;
       }

    }
}
