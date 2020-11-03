package com.github.carthax08.servermoderation;

import com.github.carthax08.servermoderation.commands.TempBan;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    String version = "0.1-alpha";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Server Moderation] Plugin version " + version + " is loading");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("tempban").setExecutor(new TempBan());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
