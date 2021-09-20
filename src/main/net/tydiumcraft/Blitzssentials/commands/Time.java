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
public class Time implements CommandExecutor {
	
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
	public Time(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("time").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.time")) {
    			if (label.equalsIgnoreCase("time")) {
    				
    				//aliases
    				if (args[0].equalsIgnoreCase("day")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "DAY");
    	    			((Player) sender).getWorld().setTime(23500);
    				} else if (args[0].equalsIgnoreCase("noon")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "NOON");
    	    			((Player) sender).getWorld().setTime(6000);
    				} else if (args[0].equalsIgnoreCase("midday")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "NOON");
    	    			((Player) sender).getWorld().setTime(6000);
    				} else if (args[0].equalsIgnoreCase("night")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "NIGHT");
    	    			((Player) sender).getWorld().setTime(13000);
    				} else if (args[0].equalsIgnoreCase("midnight")) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "MIDNIGHT");
    	    			((Player) sender).getWorld().setTime(18000);
    				}
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "Cannot set Time in Console");
    	}
		return false;
   	}
}
