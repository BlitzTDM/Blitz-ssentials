package net.tydiumcraft.Blitzssentials.commands;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginReloadPlugin implements CommandExecutor {
	
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
	public PluginReloadPlugin(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("BZSsReload").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.reload") || !(sender instanceof Player)) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Plugin");
    			HandlerList.unregisterAll();
    			plugin.getPluginLoader().disablePlugin(plugin);
    			plugin.getPluginLoader().enablePlugin(plugin);
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Plugin Reloaded");
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
