package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class Help implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();

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
	    		TextComponent helpt = new TextComponent(ChatColor.BLUE + "/BZSsHelpT or /BZSsHelpTime " + helpmenu1 + "Help Menu for Time Shortcuts");
	    		helpt.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpt.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpT"));
	    		TextComponent helpbc = new TextComponent(ChatColor.BLUE + "/BZSsHelpBC or /BZSsHelpBroadcast " + helpmenu1 + "Help Menu for Broadcast");
	    		helpbc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to Execute Command")));
	    		helpbc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BZSsHelpBC"));
	    		
	    		sender.sendMessage(""
	    		+ ChatColor.GOLD + line + "\n"
	    		+ pluginprefix2 + "Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    		+ ChatColor.AQUA + "/BZSsHelp " + helpmenu1 + "Shows this Menu." + "\n"
	    		+ ChatColor.AQUA + "/Spawn " + helpmenu1 + "Teleports you to the Spawn." + "\n"
	    		+ ChatColor.AQUA + "/MyInfo " + helpmenu1 + "Tells you your Player to Server Info." + "\n"
	    		+ ChatColor.GOLD + line);
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/Test " + helpmenu1 + "Test if the Plugin is Working" + "\n"
	    			+ ChatColor.AQUA + "/Heal <optional-player | all> " + helpmenu1 + "The Heal Command" + "\n"
	    			+ ChatColor.AQUA + "/Feed <optional-player | all> " + helpmenu1 + "The Feed Command" + "\n"
	    			+ ChatColor.AQUA + "/Fly <optional-player> " + helpmenu1 + "The Fly Command" + "\n"
	    			+ ChatColor.AQUA + "/MyInfo <optional-player> " + helpmenu1 + "See Someones or Your Player to Server Info" + "\n"
	    			+ ChatColor.AQUA + "/BlockTop " + helpmenu1 + "Teleport to Top Block above You" + "\n"
	    			+ ChatColor.AQUA + "/Vanish or /v <optional-false (Hide's Join Message)> " + helpmenu1 + "The Vanish Command" + "\n"
	    			+ ChatColor.AQUA + "/Unvanish or /uv <optional-false (Hide's Leave Message)> " + helpmenu1 + "The Unvanish Command" + "\n"
	    			+ ChatColor.AQUA + "/God " + helpmenu1 + "The God Command (Toggle)" + "\n"
	    			+ ChatColor.AQUA + "/Togglevanish or /tv <optional-false (Hide's Leave or Join Message)> " + helpmenu1 + "The Togglable Vanish Command" + "\n"
	    			+ ChatColor.AQUA + "/Countdown <countdown-amount> " + helpmenu1 + "Set a Countdown for Yourself" + "\n"
	    			+ ChatColor.AQUA + "/MassSummon " + helpmenu1 + "Summon a lot of Entities!");
	    			sender.spigot().sendMessage(helpp);
	    			sender.spigot().sendMessage(helpg);
	    			sender.spigot().sendMessage(helpw);
	    			sender.spigot().sendMessage(helpt);
	    			sender.spigot().sendMessage(helpbc);
	    			sender.sendMessage(ChatColor.AQUA + "Test, Heal, Feed, and Fly can also be used in Console" + "\n"
	    	    			+ ChatColor.GOLD + line);
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
