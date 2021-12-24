package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;
import static me.blitztdm.blitzssentials.utils.shortcutTags.pluginprefix;

@SuppressWarnings("unused")
public class Weather implements TabExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Weather(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("weather").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.weather")) {
    			if (label.equalsIgnoreCase("weather")) {
    				
    				//aliases
    				if (args[0].equalsIgnoreCase("clear")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "CLEAR");
    	    			((Player) sender).getWorld().setThundering(false);
    	    			((Player) sender).getWorld().setStorm(false);
    				} else if (args[0].equalsIgnoreCase("rain")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
    	    			((Player) sender).getWorld().setThundering(false);
    	    			((Player) sender).getWorld().setStorm(true);
    				} else if (args[0].equalsIgnoreCase("downpour")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
    	    			((Player) sender).getWorld().setThundering(false);
    	    			((Player) sender).getWorld().setStorm(true);
    				} else if (args[0].equalsIgnoreCase("thunder")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND THE THUNDER");
    					((Player) sender).getWorld().setStorm(true);
    	    			((Player) sender).getWorld().setThundering(true);
    				} else if (args[0].equalsIgnoreCase("lighting")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND THE THUNDER");
    					((Player) sender).getWorld().setStorm(true);
    	    			((Player) sender).getWorld().setThundering(true);
    				}
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		World mainworld = Bukkit.getWorlds().get(0);
    		
    		if (args[0].equalsIgnoreCase("clear")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "CLEAR");
				mainworld.setThundering(false);
    			mainworld.setStorm(false);
			} else if (args[0].equalsIgnoreCase("rain")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
				mainworld.setThundering(false);
    			mainworld.setStorm(true);
			} else if (args[0].equalsIgnoreCase("downpour")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
				mainworld.setThundering(false);
    			mainworld.setStorm(true);
			} else if (args[0].equalsIgnoreCase("thunder")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
				mainworld.setStorm(true);
				mainworld.setThundering(true);
			} else if (args[0].equalsIgnoreCase("lighting")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
				mainworld.setStorm(true);
    			mainworld.setThundering(true);
			}
    	}
		return false;
   	}
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> weather = new ArrayList<>();
		if (args.length == 1) {
			weather.add("clear");
			weather.add("rain");
			weather.add("downpour");
			weather.add("thunder");
			weather.add("lightning");
		}
		
		return weather;
	}
}
