package com.github.carthax08.servermoderation;

import com.github.carthax08.servermoderation.commands.*;
import com.github.carthax08.servermoderation.events.PlayerJoinEventHandeler;
import com.github.carthax08.servermoderation.events.PlayerLeaveEventHandeler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    String version = "2.0-alpha";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Server Moderation] Plugin version " + version + " is loading");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("tempban").setExecutor(new TempBan());
        getCommand("ban").setExecutor(new Ban());
        getCommand("unban").setExecutor(new Unban());
        getCommand("unbanip").setExecutor(new UnbanIp());
        getCommand("banip").setExecutor(new BanIp(this));
        getServer().getPluginManager().registerEvents(new PlayerJoinEventHandeler(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveEventHandeler(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
