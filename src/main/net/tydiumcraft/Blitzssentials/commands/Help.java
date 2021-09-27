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
			plugin.getCommand("BZSsHelp").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		sender.sendMessage(""
	    		+ ChatColor.GOLD + line + "\n"
	    		+ pluginprefix2 + "Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    		+ ChatColor.AQUA + "/BZSsHelp " + helpmenu1 + "Shows this Menu." + "\n"
	    		+ ChatColor.GOLD + line);
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/Test " + helpmenu1 + "Test if the Plugin is Working" + "\n"
	    			+ ChatColor.AQUA + "/Heal <optional-player> " + helpmenu1 + "The Heal Command" + "\n"
	    			+ ChatColor.AQUA + "/Feed <optional-player> " + helpmenu1 + "The Feed Command" + "\n"
	    			+ ChatColor.AQUA + "/Fly <optional-player> " + helpmenu1 + "The Fly Command" + "\n"
	    			+ ChatColor.AQUA + "/MassSummon " + helpmenu1 + "Summon a lot of Entities!" + "\n"
	    			+ ChatColor.AQUA + "/BZSsHelpP or /BZSsHelpPlugin " + helpmenu1 + "Help Menu for Plugin Specific Commands" + "\n"
	    			+ ChatColor.AQUA + "/BZSsHelpG or /BZSsHelpGamemode " + helpmenu1 + "Help Menu for Player Gamemodes" + "\n"
	    			+ ChatColor.AQUA + "/BZSsHelpW or /BZSsHelpWeather " + helpmenu1 + "Help Menu for Weather Shortcuts" + "\n"
	    			+ ChatColor.AQUA + "/BZSsHelptT or /BZSsHelpTime " + helpmenu1 + "Help Menu for Time Shortcuts" + "\n"
	    			+ ChatColor.AQUA + "Test, Heal, Feed, and Fly can also be used in Console" + "\n"
	    			+ ChatColor.GOLD + line);	
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
