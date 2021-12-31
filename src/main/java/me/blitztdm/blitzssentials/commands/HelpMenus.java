package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class HelpMenus implements CommandExecutor {

		private BlitzssentialsMain plugin;
		public HelpMenus(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZSsHelpPlugin").setExecutor(this);
			plugin.getCommand("BZSsHelpBroadcast").setExecutor(this);
			plugin.getCommand("BZSsHelpGamemode").setExecutor(this);
			plugin.getCommand("BZSsHelpTime").setExecutor(this);
			plugin.getCommand("BZSsHelpWeather").setExecutor(this);
		}

	public String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;

	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (cmd.getName().equalsIgnoreCase("BZSsHelpPlugin")) {
				if (sender instanceof Player) {
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
								+ ChatColor.AQUA + "/JoinPos <set | go>" + helpmenu1 + "Set or Go to the Join Position" + "\n"
								+ ChatColor.AQUA + "All of these commands can also be used in Console" + "\n"
								+ ChatColor.GOLD + line);
					} else {
						sender.sendMessage(noperm);
					}
				} else {
					Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
				}
			} else if (cmd.getName().equalsIgnoreCase("BZSsHelpBroadcast")) {
				if (sender instanceof Player) {
					if (sender.hasPermission("BlitzSsentials.adminhelp")) {
						sender.sendMessage(""
								+ pluginprefix2 + "Admin Help Menu! - Broadcast" + ChatColor.DARK_AQUA + "\n"
								+ ChatColor.AQUA + "/BC <message> " + helpmenu1 + "Broadcast a Message" + "\n"
								+ ChatColor.AQUA + "/BCAlert " + helpmenu1 + "Alert with a Message and Sound" + "\n"
								+ ChatColor.AQUA + "/BCCountdown" + helpmenu1 + "Broadcast a Countdown" + "\n"
								+ ChatColor.AQUA + "Broadcast can also be used in Console" + "\n"
								+ ChatColor.GOLD + line);
					} else {
						sender.sendMessage(noperm);
					}
				} else {
					Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
				}
			} else if (cmd.getName().equalsIgnoreCase("BZSsHelpGamemode")) {
				if (sender instanceof Player) {
					if (sender.hasPermission("BlitzSsentials.adminhelp")) {
						sender.sendMessage(""
								+ pluginprefix2 + "Admin Help Menu! - Gamemode" + ChatColor.DARK_AQUA + "\n"
								+ ChatColor.AQUA + "/gmc <optional-player> " + helpmenu1 + "Creative Mode" + "\n"
								+ ChatColor.AQUA + "/gms <optional-player> " + helpmenu1 + "Survival Mode" + "\n"
								+ ChatColor.AQUA + "/gmsp <optional-player> " + helpmenu1 + "Spectator Mode" + "\n"
								+ ChatColor.AQUA + "/gma <optional-player> " + helpmenu1 + "Adventure Mode" + "\n"
								+ ChatColor.GOLD + line);
					} else {
						sender.sendMessage(noperm);
					}
				} else {
					Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
				}
			} else if (cmd.getName().equalsIgnoreCase("BZSsHelpTime")) {
				if (sender instanceof Player) {
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
			} else if (cmd.getName().equalsIgnoreCase("BZSsHelpWeather")) {
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
			}
			return false;
	    }
}
