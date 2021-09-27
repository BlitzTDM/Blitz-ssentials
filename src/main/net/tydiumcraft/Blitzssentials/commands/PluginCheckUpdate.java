package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.events.checkVersion;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginCheckUpdate implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String lastpluginversion = shortcutTags.lastpluginversion;
    String lastpluginversionquick = shortcutTags.lastpluginversionquick;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    
    String PluginUpdated = checkVersion.PluginUpdated;
	String PluginOutdated = checkVersion.PluginOutdated;
	String PluginError = checkVersion.VersionCheckError;
	
    private BlitzssentialsMain plugin;
	public PluginCheckUpdate(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("bzssupdate").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.admin")) {
    			new checkVersion(plugin).getVersion(version -> {
    	            if (pluginversion.equalsIgnoreCase(version)) {
    	            	sender.sendMessage(PluginUpdated);
    	            } else if (version.equalsIgnoreCase(lastpluginversion)) {
    	            	sender.sendMessage(PluginUpdated);
    	            } else if (version.equalsIgnoreCase(lastpluginversionquick)) {
    	            	sender.sendMessage(PluginUpdated);
    	            } else {
    	            	sender.sendMessage(PluginOutdated);
    	            }});
    			
    			sender.sendMessage();
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		new checkVersion(plugin).getVersion(version -> {
            if (pluginversion.equalsIgnoreCase(version)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversion)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversionquick)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else {
            	Bukkit.getConsoleSender().sendMessage(PluginOutdated);
            }});
    	}
		return false;
    }
}
