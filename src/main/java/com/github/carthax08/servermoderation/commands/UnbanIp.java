package com.github.carthax08.servermoderation.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanIp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("You must provide and IP!");
            return false;
        }else if(Bukkit.getBanList(BanList.Type.IP).isBanned(args[0])){
            Bukkit.getBanList(BanList.Type.IP).pardon(args[0]);
            sender.sendMessage("Targer successfully Unbanned");
            return true;
        }else{
            sender.sendMessage("IP is not banned!");
            return false;
        }

    }
}
