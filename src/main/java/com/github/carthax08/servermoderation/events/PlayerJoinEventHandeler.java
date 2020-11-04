package com.github.carthax08.servermoderation.events;

import com.github.carthax08.servermoderation.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventHandeler implements Listener {

    Main main;

    public PlayerJoinEventHandeler(Main plugin){
        main = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(main.getConfig().getBoolean("settings.sendMessageOnJoin")){
            event.getPlayer().sendMessage("This server uses ServerModeration by CarThax08. /n If you are the owner of this server and want to get rid of this message go to the config.");
        }
    }
}
