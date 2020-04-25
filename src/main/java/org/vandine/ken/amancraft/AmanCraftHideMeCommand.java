
package org.vandine.ken.amancraft;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Handler for the /hideme amancraft command.
 * @author kenvandine
 */
public class AmanCraftHideMeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("HideMe") && args.length == 1) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        // After checking to make sure that the sender is a Player, we can safely cast it to one.
        Player s = (Player) sender;

        // Gets the player who shouldn't see the sender.
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Player " + args[0] + " is not online.");
            return true;
        }
        // Hides a given Player (s) from someone (target).
        target.hidePlayer(s);
        return true;
    }
    return false;
    }
}
