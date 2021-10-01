package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.jgit.lib.Config;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginReloadConfig implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
	
    final BlitzssentialsMain plugin;
	public PluginReloadConfig(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("BZSsConfig").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.reload")) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Config");
    			plugin.getConfig();
    			plugin.saveDefaultConfig();
    			plugin.reloadConfig();
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Config Reloaded");
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Config");
    		plugin.getConfig();
    		plugin.saveDefaultConfig();
    		plugin.reloadConfig();
    		Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.GREEN + "Config Reloaded");
    	}
		return false;
    }
}
