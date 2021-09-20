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
public class Gamemode implements CommandExecutor {
	
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
	public Gamemode(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gm").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    			if (label.equalsIgnoreCase("gm")) {
    				
    				//Survival
    				if (args[0].equalsIgnoreCase("0")) {
    					if (sender.hasPermission("BlitzSsentials.gms")) {
    					if (((Player) sender).getGameMode() == GameMode.SURVIVAL) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.SURVIVAL);
    	    				}
    					}
    				} else if (args[0].equalsIgnoreCase("s")) {
    					if (sender.hasPermission("BlitzSsentials.gms")) {
    					if (((Player) sender).getGameMode() == GameMode.SURVIVAL) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.SURVIVAL);
    	    				}
    					}
    					
    					//Creative
    				} else if (args[0].equalsIgnoreCase("1")) {
    					if (sender.hasPermission("BlitzSsentials.gmc")) {
    					if (((Player) sender).getGameMode() == GameMode.CREATIVE) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.CREATIVE);
    	    				}
    					}
    				} else if (args[0].equalsIgnoreCase("c")) {
    					if (sender.hasPermission("BlitzSsentials.gmc")) {
    					if (((Player) sender).getGameMode() == GameMode.CREATIVE) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.CREATIVE);
    	    				}
    					}
    					
    					//Spectator
    				} else if (args[0].equalsIgnoreCase("2")) {
    					if (sender.hasPermission("BlitzSsentials.gmsp")) {
    					if (((Player) sender).getGameMode() == GameMode.SPECTATOR) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SPECTATOR " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.SPECTATOR);
    	    				}
    					}
    				} else if (args[0].equalsIgnoreCase("sp")) {
    					if (sender.hasPermission("BlitzSsentials.gmsp")) {
    					if (((Player) sender).getGameMode() == GameMode.SPECTATOR) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SPECTATOR " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.SPECTATOR);
    	    				}
    					}
    					
    					//Adventure
    				} else if (args[0].equalsIgnoreCase("3")) {
    					if (sender.hasPermission("BlitzSsentials.gma")) {
    	    			if (((Player) sender).getGameMode() == GameMode.ADVENTURE) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "ADVENTURE " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.ADVENTURE);
    	    				}
    					}
    	    		} else if (args[0].equalsIgnoreCase("a")) {
    	    			if (sender.hasPermission("BlitzSsentials.gma")) {
    	    			if (((Player) sender).getGameMode() == GameMode.ADVENTURE) {
    	        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    	    				} else {
    	    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "ADVENTURE " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    	    			((Player) sender).setGameMode(GameMode.ADVENTURE);
    	    				}
    	    			}
    				}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(console);
    	}
		return false;
   	}
}
