package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginInfo implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
	
    private BlitzssentialsMain plugin;
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
