package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class Fly implements CommandExecutor {
	
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
	public Fly(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
		
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.fly")) {
    			if (args.length == 0) {
    				if (!(((Player) sender).getAllowFlight())) {
        				((Player) sender).setAllowFlight(true);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
        			
        			} else if (((Player) sender).getAllowFlight()) {
        				((Player) sender).setAllowFlight(false);
        				sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
        			}
    			} else if (sender.hasPermission("BlitzSsentials.fly.other")) {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
    				} else {
        				if (!(arg0.getAllowFlight())) {
            				arg0.setAllowFlight(true);
            			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
            			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying for " + args[0]);
            			} else if (arg0.getAllowFlight()) {
            				arg0.setAllowFlight(false);
            				arg0.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
            				sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying for " + args[0]);
            			}
            		}
    			} else {
    				sender.sendMessage(noperm);
    			}
    			} else {
    			sender.sendMessage(noperm);
    			}
    		} else {
    			if (args.length == 0) {
    	    		sender.sendMessage(pluginprefix + ChatColor.RED + "Specify Player");
    	    		} else {
    	        		Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    	    			if (arg0 == null) {
    	    				sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
    	    			} else {
    	    				if (!(arg0.getAllowFlight())) {
                				arg0.setAllowFlight(true);
                			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
                			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying for " + args[0]);
                			} else if (arg0.getAllowFlight()) {
                				arg0.setAllowFlight(false);
                				arg0.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
                				sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying for " + args[0]);
                			}
    	    			}
    	    		}
    		}
		return false;
    }
}