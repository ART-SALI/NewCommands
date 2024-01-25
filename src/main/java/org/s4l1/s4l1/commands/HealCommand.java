package org.s4l1.s4l1.commands;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static java.lang.Double.*;

public class HealCommand  implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,
                             @NotNull Command command,
                             @NotNull String s,
                             @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length != 1) {
                player.sendMessage(ChatColor.DARK_RED + "Command must have at least and only one argument");
            } else if(strings[0].equalsIgnoreCase("full")){
                player.setHealth(20D);
            } else {
                try {
                    double healedHP = parseDouble(strings[0]);
                    if (player.getHealth() + healedHP > 20) player.setHealth(20D);
                    else player.setHealth(player.getHealth() + healedHP);
                } catch(NumberFormatException ex) {
                    player.sendMessage(ChatColor.DARK_RED + "You need to write full to full heal or write number of heatpoints to heal");
                }

            }
        } else {
            commandSender.sendMessage(ChatColor.DARK_RED + "Command must be written by player");
        }

        return false;
    }
}
