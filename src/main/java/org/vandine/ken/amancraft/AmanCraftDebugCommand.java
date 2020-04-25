package org.vandine.ken.amancraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Handler for the /debug amancraft command.
 * @author SpaceManiac
 */
public class AmanCraftDebugCommand implements CommandExecutor {
    private final AmanCraftPlugin plugin;

    public AmanCraftDebugCommand(AmanCraftPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            plugin.setDebugging(player, !plugin.isDebugging(player));

            return true;
        } else {
            return false;
        }
    }
}
