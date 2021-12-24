package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class PluginInfo implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public PluginInfo(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("BZSsInfo").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.plugininfo")) {
    			
    			sender.sendMessage(""
    					+ ChatColor.GOLD + line + "\n"
    					+ pluginprefix2 + ChatColor.AQUA + "Plugin Version: " + pluginversion + "\n"
    					+ ChatColor.DARK_AQUA + "Current Plugin Prefix: " + ChatColor.RESET + pluginprefix + "\n"
    					+ ChatColor.GOLD + line
    					);
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(""
					+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
					+ pluginprefix2 + ChatColor.AQUA + "Plugin Version: " + pluginversion + ChatColor.AQUA + "\n"
					+ ChatColor.DARK_AQUA + "Current Plugin Prefix: " + ChatColor.RESET + pluginprefix + ChatColor.RESET + "\n"
					+ ChatColor.GOLD + line
					);
    	}
		return false;
    }
}
