package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class HelpWeather implements CommandExecutor {
		
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
		
		public HelpWeather(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZSsHelpWeather").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu! - Weather" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/wclear " + helpmenu1 + "Clears Weather" + "\n"
	    			+ ChatColor.AQUA + "/wrain or /wdownpour " + helpmenu1 + "Weather to Rain" + "\n"
	    			+ ChatColor.AQUA + "/wthunder or /wlighting " + helpmenu1 + "Weather to Rain, Lighting and a Thunder" + "\n"
	    			+ ChatColor.AQUA + "Weather can also be set in Console" + "\n"
	    			+ ChatColor.GOLD + line);	
	    		} else {
	    			sender.sendMessage(noperm);
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
