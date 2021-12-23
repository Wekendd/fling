package com.wekend.fling.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FlingCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("fling")) {
            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "I'm sorry, but you are not an official flinger, so you are not qualified to use this command.");
                return true;
            }
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "[Fling] Incorrect arguments: /fling <player>");
                return true;
            } // if player types only "/fling"
            if (args.length > 1) {
                sender.sendMessage(ChatColor.RED + "[Fling] Incorrect arguments: /fling <player>");
                return true;
            } // if player types multiple arguments, such as "/fling Wekend _TheLeif"
            else {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "[Fling] Player not found.");
                    return true;
                } // If target is not online/is not a real player
                double randX = -2 + Math.random() * (2 - -2);
                double randZ = -2 + Math.random() * (2 - -2);
                assert target != null;
                target.setVelocity(new Vector(randX,1.5,randZ));
                sender.sendMessage(ChatColor.GREEN + "You have successfully flung " + target.getName() + ".");
                target.sendMessage(ChatColor.GREEN + "You have been flunged by " + sender.getName() + ".");

            } // Everything else
        }
        return true;
    }
}
