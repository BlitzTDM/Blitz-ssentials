package net.tydiumcraft.Blitzssentials.commands;

import java.io.File;

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
    		if (sender.hasPermission("BlitzSsentials.reload") || (!(sender instanceof Player))) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Config");
    			File confyml = new File(plugin.getDataFolder(), "config.yml");
    			File confymlbackup = new File(plugin.getDataFolder(), "configOld.yml");
    			
    			if (confyml.exists() && !(confymlbackup.exists())) {
    			confyml.renameTo(confymlbackup);
    				sender.sendMessage(bzssprefix + ChatColor.YELLOW + "Created Config Backup and Generated New Config");
    			} else {
    				sender.sendMessage(bzssprefix + ChatColor.YELLOW + "Remove or Rename configOld.yml to Create new Config and Backup current Config");
    			}
    			
    			plugin.getConfig();
    			plugin.saveDefaultConfig();
    			plugin.reloadConfig();
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Config Reloaded");
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
