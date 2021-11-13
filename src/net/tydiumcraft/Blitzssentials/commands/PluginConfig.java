package net.tydiumcraft.Blitzssentials.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.eclipse.jgit.lib.Config;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginConfig implements TabExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
    String moreargs = shortcutTags.moreargs;
    String lessargs = shortcutTags.lessargs;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
	
    final BlitzssentialsMain plugin;
	public PluginConfig(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("BZSsConfig").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender.hasPermission("BlitzSsentials.reload") || !(sender instanceof Player)) {
    		if (args.length == 1 && args[0].equalsIgnoreCase("update")) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Config");
    			File confyml = new File(plugin.getDataFolder(), "config.yml");
    			File confymlbackup = new File(plugin.getDataFolder(), "configOld.yml");
    			
    			if (confyml.exists() && !(confymlbackup.exists())) {
    			confyml.renameTo(confymlbackup);
    				sender.sendMessage(bzssprefix + ChatColor.YELLOW + "Created Config Backup and Generated New Config");
    			} else {
    				sender.sendMessage(bzssprefix + ChatColor.YELLOW + "Remove or Rename configOld.yml to Create new Config and Backup current Config");
    			}
    		} else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
		    	plugin.saveDefaultConfig();
				plugin.getConfig().options().copyDefaults(true);
				plugin.reloadConfig();
				plugin.saveDefaultConfig();
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Config Reloaded");
    		} else {
    			if (args.length >= 2) {
    				sender.sendMessage(moreargs);
    			} else {
    				sender.sendMessage(lessargs);
    			}
    		}
    		} else {
    			sender.sendMessage(noperm);
    	}
		return false;
    }
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> configtab = new ArrayList<>();
		if (args.length == 1) {
			configtab.add("update");
			configtab.add("reload");
		}
		return configtab;
	}
}
