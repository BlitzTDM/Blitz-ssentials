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
public class Help implements CommandExecutor {
		
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
		
		public Help(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZssHelp").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		sender.sendMessage(""
	    		+ ChatColor.GOLD + line + "\n"
	    		+ pluginprefix2 + "Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    		+ ChatColor.AQUA + "/Help " + helpmenu1 + "Shows this Menu." + "\n"
	    		+ ChatColor.GOLD + line);
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    			+ ChatColor.AQUA + "/gmc or /gc " + helpmenu1 + "Put's you in Creative Mode" + "\n"
	    			+ ChatColor.AQUA + "/gms or /gs " + helpmenu1 + "Put's you in Survival Mode" + "\n"
	    			+ ChatColor.AQUA + "/gmsp or /gsp " + helpmenu1 + "Put's you in Spectator Mode" + "\n"
	    			+ ChatColor.AQUA + "/gma or /ga " + helpmenu1 + "Put's you in Adventure Mode" + "\n"
	    			+ ChatColor.GOLD + line);	
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
