package com.github.carthax08.servermoderation;

import com.github.carthax08.servermoderation.commands.Ban;
import com.github.carthax08.servermoderation.commands.TempBan;
import com.github.carthax08.servermoderation.commands.Unban;
import com.github.carthax08.servermoderation.commands.UnbanIp;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    String version = "1.0-alpha";

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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
