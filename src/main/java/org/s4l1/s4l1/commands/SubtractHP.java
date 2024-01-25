package org.s4l1.s4l1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static java.lang.Double.parseDouble;

public class SubtractHP implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length != 1) {
                player.sendMessage(ChatColor.DARK_RED + "Command must have at least and only one argument");
            } else
                try {
                    if(strings[0].contains("-")) throw new NumberFormatException();
                    double subtractedHP = parseDouble(strings[0]);
                    if(subtractedHP > player.getHealthScale()) throw new NumberFormatException();
                    player.setHealthScale(player.getHealthScale() - subtractedHP);
                    player.setMaxHealth(player.getHealthScale());
                    player.setHealth(player.getHealthScale());
                } catch(NumberFormatException ex) {
                    player.sendMessage(ChatColor.DARK_RED + "You need to write positive number of healthpoints you want to subtract and this number must be lower than your healthpoint");
                }

        } else {
            commandSender.sendMessage(ChatColor.DARK_RED + "Command must be written by player");
        }

        return false;
    }
}
