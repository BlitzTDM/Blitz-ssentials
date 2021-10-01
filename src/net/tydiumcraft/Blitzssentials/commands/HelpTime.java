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
public class HelpTime implements CommandExecutor {
		
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
		
		public HelpTime(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZSsHelpTime").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu! - Weather" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/day " + helpmenu1 + "Time to Day" + "\n"
	    			+ ChatColor.AQUA + "/night " + helpmenu1 + "Time to Night" + "\n"
	    			+ ChatColor.AQUA + "/midnight" + helpmenu1 + "Time to Midnight" + "\n"
	    			+ ChatColor.AQUA + "/noon or /midday " + helpmenu1 + "Time to Noon or Midday" + "\n"
	    			+ ChatColor.AQUA + "Time can also be set in Console" + "\n"
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
