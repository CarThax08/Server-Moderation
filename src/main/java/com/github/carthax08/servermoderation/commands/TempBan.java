package com.github.carthax08.servermoderation.commands;

import com.github.carthax08.servermoderation.utils.BanPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class TempBan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("You must specify a player, duration, (s,m,h,d), and a reason.");
            return false;
        }else if(args.length == 1){
            sender.sendMessage("You must provide a duration, (s,m,h,d), reason");
            return false;
        }
        else if(args.length == 2){
            sender.sendMessage("You must provide a (s,m,h,d) and reason");
            return false;
        }else if(args.length == 3){
            sender.sendMessage("You must provide a reason");
            return false;
        } else {
            String message = "";
            for(int i = 3; i < args.length; i++){
                message = message + args[i] + " ";
            }
            if(args[2].equalsIgnoreCase("s")) {
                BanPlayer.banPlayer(message, args[0], sender.getName(), Integer.parseInt(args[1]) * 1000);
                sender.sendMessage("Player successfully banned.");
                return true;
            }
            if(args[2].equalsIgnoreCase("min")){
                BanPlayer.banPlayer(message, args[0], sender.getName(), Integer.parseInt(args[1]) * 60 * 1000);
                sender.sendMessage("Player successfully banned.");
                return true;
            }
            if(args[2].equalsIgnoreCase("h")){
                BanPlayer.banPlayer(message, args[0], sender.getName(), Integer.parseInt(args[1]) * 60 * 60 * 1000);
                sender.sendMessage("Player successfully banned.");
                return true;
            }
            if(args[2].equalsIgnoreCase("d")){
                BanPlayer.banPlayer(message, args[0], sender.getName(), Integer.parseInt(args[1]) * 24 * 60 * 60 * 1000);
                sender.sendMessage("Player successfully banned.");
                return true;
            }
        }



        return false;
    }
}
