package com.github.carthax08.servermoderation.utils;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;

public class BanPlayer {

    private static boolean success = false;


    public static void banPlayer(String reason, String playerToBan, String personWhoBanned, int time){
        try{
            Bukkit.getBanList(BanList.Type.NAME).addBan(playerToBan, reason, new Date(System.currentTimeMillis() + time), personWhoBanned);
            Bukkit.getPlayer(playerToBan).kickPlayer("YOU HAVE BEEN BANNED /n REASON: " + reason);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }
    public static void banPlayer(String reason, String playerToBan, String personWhoBanned){
        try{
            Bukkit.getBanList(BanList.Type.NAME).addBan(playerToBan, reason, null, personWhoBanned);
            Bukkit.getPlayer(playerToBan).kickPlayer("YOU HAVE BEEN BANNED /n REASON: " + reason);
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }


}
