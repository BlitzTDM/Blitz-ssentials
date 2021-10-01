package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
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
	    		TextComponent helpp = new TextComponent(ChatColor.BLUE + "/BZSsHelpP or /BZSsHelpPlugin " + helpmenu1 + "Help Menu for Plugin Specific Commands");
	    		helpp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpP"));
	    		TextComponent helpg = new TextComponent(ChatColor.BLUE + "/BZSsHelpG or /BZSsHelpGamemode " + helpmenu1 + "Help Menu for Player Gamemodes");
	    		helpg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpG"));
	    		TextComponent helpw = new TextComponent(ChatColor.BLUE + "/BZSsHelpW or /BZSsHelpWeather " + helpmenu1 + "Help Menu for Weather Shortcuts");
	    		helpw.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpw.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpW"));
	    		TextComponent helpt = new TextComponent(ChatColor.BLUE + "/BZSsHelptT or /BZSsHelpTime " + helpmenu1 + "Help Menu for Time Shortcuts");
	    		helpt.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpt.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpT"));
	    		
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
	    			+ ChatColor.AQUA + "/Vanish or /v <optional-false (Hide's Join Message)> " + helpmenu1 + "The Vanish Command" + "\n"
	    			+ ChatColor.AQUA + "/Unvanish or /uv <optional-false (Hide's Leave Message)> " + helpmenu1 + "The Unvanish Command" + "\n"
	    			+ ChatColor.AQUA + "/Togglevanish or /tv <optional-false (Hide's Leave or Join Message)> " + helpmenu1 + "The Togglable Vanish Command" + "\n"
	    			+ ChatColor.AQUA + "/MassSummon " + helpmenu1 + "Summon a lot of Entities!");
	    			sender.spigot().sendMessage(helpp);
	    			sender.spigot().sendMessage(helpg);
	    			sender.spigot().sendMessage(helpw);
	    			sender.spigot().sendMessage(helpt);
	    			sender.sendMessage(ChatColor.AQUA + "Test, Heal, Feed, and Fly can also be used in Console" + "\n"
	    	    			+ ChatColor.GOLD + line);
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
