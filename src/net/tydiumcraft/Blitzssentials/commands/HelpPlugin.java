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
public class HelpPlugin implements CommandExecutor {
		
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
		
		public HelpPlugin(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZSsHelpPlugin").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu! - Plugin" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/Test " + helpmenu1 + "Test if the Plugin is Working" + "\n"
	    	    	+ ChatColor.AQUA + "/TestJoin " + helpmenu1 + "Test the Join Message" + "\n"
	    	    	+ ChatColor.AQUA + "/TestLeave " + helpmenu1 + "Test the Leave Message" + "\n"
	    			+ ChatColor.AQUA + "/PluginInfo " + helpmenu1 + "See the Plugin Info" + "\n"
	    			+ ChatColor.AQUA + "/BZSsConfig " + helpmenu1 + "Reload the Config and Recreates it with a Backup" + "\n"
	    			+ ChatColor.AQUA + "/BZSsReload " + helpmenu1 + "Reload the Plugin" + "\n"
	    			+ ChatColor.AQUA + "/BZSsUpdate " + helpmenu1 + "Checks Spigot for an Update" + "\n"
	    			+ ChatColor.AQUA + "All of these commands can also be used in Console" + "\n"
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
