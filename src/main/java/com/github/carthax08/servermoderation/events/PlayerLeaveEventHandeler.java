package com.github.carthax08.servermoderation.events;

import com.github.carthax08.servermoderation.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveEventHandeler implements Listener {
    Main main;

    public PlayerLeaveEventHandeler(Main plugin){
        main = plugin;
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        main.getConfig().set("ips." + event.getPlayer().getName() + ".ip", event.getPlayer().getAddress().getHostName());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Player " + event.getPlayer().getName() + " has had their last know IP logged.");
    }


}
