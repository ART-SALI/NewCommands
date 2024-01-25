package org.s4l1.s4l1;

import org.bukkit.plugin.java.JavaPlugin;
import org.s4l1.s4l1.commands.AddHP;
import org.s4l1.s4l1.commands.HealCommand;
import org.s4l1.s4l1.commands.SubtractHP;
import org.s4l1.s4l1.commands.TeleportOnHighestPosition;

public final class NewCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("teleportonhighestposition").setExecutor(new TeleportOnHighestPosition());
        getCommand("addhp").setExecutor(new AddHP());
        getCommand("subtracthp").setExecutor(new SubtractHP());
    }

}
