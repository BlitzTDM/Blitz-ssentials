package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class PluginConfig implements TabExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
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
