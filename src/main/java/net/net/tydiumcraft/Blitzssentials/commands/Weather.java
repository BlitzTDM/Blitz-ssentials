package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class Weather implements CommandExecutor {
	
	public String line = "------------------------------------";
	public String line2 = "-----------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss ";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
	
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
