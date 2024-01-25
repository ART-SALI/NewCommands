package org.s4l1.s4l1.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static java.lang.Double.parseDouble;

public class TeleportOnHighestPosition implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length != 2) {
                player.sendMessage(ChatColor.DARK_RED +
                        "Command must have two arguments coordinate X and coordinate Z");
            } else {
                try {
                    double X = parseDouble(strings[0]);
                    double Z = parseDouble(strings[1]);
                    player.teleport(
                            new Location(
                                    player.getWorld(),
                                    X,
                                    player.getWorld().getHighestBlockYAt((int)X, (int)Z) + 1,
                                    Z)
                    );
                } catch(NumberFormatException ex) {
                    player.sendMessage(ChatColor.DARK_RED + "You need to write two numbers coordinate X and coordinate Z");
                }

            }
        } else {
            commandSender.sendMessage(ChatColor.DARK_RED + "Command must be written by player");
        }


        return false;
    }
}
