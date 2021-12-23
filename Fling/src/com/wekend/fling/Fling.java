package com.wekend.fling;

import com.wekend.fling.commands.FlingCommands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Fling extends JavaPlugin {

    @Override
    public void onEnable() {
        FlingCommands commands = new FlingCommands();
        getCommand("fling").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Fling] Plugin enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Fling] Plugin disabled");
    }

}
