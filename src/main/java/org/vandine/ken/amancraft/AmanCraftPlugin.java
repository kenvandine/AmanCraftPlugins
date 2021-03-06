
package org.vandine.ken.amancraft;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * AmanCraft plugin for Bukkit
 *
 * @author kenvandine
 */
public class AmanCraftPlugin extends JavaPlugin {
    private final AmanCraftPlayerListener playerListener = new AmanCraftPlayerListener(this);
    private final AmanCraftBlockListener blockListener = new AmanCraftBlockListener();
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);

        // Register our commands
        getCommand("pos").setExecutor(new AmanCraftPosCommand());
        getCommand("debug").setExecutor(new AmanCraftDebugCommand(this));
        getCommand("hideme").setExecutor(new AmanCraftHideMeCommand());
        getCommand("showme").setExecutor(new AmanCraftShowMeCommand());

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}
