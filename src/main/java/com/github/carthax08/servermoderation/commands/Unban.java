package com.github.carthax08.servermoderation.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Unban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("You need to provide a player!");
            return false;
        }else if(Bukkit.getBanList(BanList.Type.NAME).isBanned(args[0])){
            Bukkit.getBanList(BanList.Type.NAME).pardon(args[0]);
            return true;
        }else{
            sender.sendMessage("Player is not banned!");
            return false;
        }
    }
}
