package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class Weather implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
	
    private BlitzssentialsMain plugin;
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
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
    	    			((Player) sender).getWorld().setThundering(true);
    				} else if (args[0].equalsIgnoreCase("lighting")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
    	    			((Player) sender).getWorld().setThundering(true);
    				}
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "Cannot set Weather in Console");
    	}
		return false;
   	}
}
