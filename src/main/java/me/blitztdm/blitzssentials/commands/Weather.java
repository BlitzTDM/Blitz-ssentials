package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;
import static me.blitztdm.blitzssentials.utils.shortcutTags.pluginprefix;

@SuppressWarnings("unused")
public class Weather implements TabExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Weather(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("weather").setExecutor(this);
		plugin.getCommand("weatherclear").setExecutor(this);
		plugin.getCommand("weatherrain").setExecutor(this);
		plugin.getCommand("weatherthunder").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("weather")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (sender.hasPermission("BlitzSsentials.weather")) {
					if (label.equalsIgnoreCase("weather")) {
						if (args[0].equalsIgnoreCase("clear")) {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "CLEAR");
							player.getWorld().setThundering(false);
							player.getWorld().setStorm(false);
						} else if (args[0].equalsIgnoreCase("rain")) {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
							player.getWorld().setThundering(false);
							player.getWorld().setStorm(true);
						} else if (args[0].equalsIgnoreCase("downpour")) {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
							player.getWorld().setThundering(false);
							player.getWorld().setStorm(true);
						} else if (args[0].equalsIgnoreCase("thunder")) {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND THE THUNDER");
							player.getWorld().setStorm(true);
							player.getWorld().setThundering(true);
						} else if (args[0].equalsIgnoreCase("lighting")) {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND THE THUNDER");
							player.getWorld().setStorm(true);
							player.getWorld().setThundering(true);
						}
					}
				} else {
					sender.sendMessage(noperm);
				}
			} else {
				World mainworld = Bukkit.getWorlds().get(0);

				if (args[0].equalsIgnoreCase("clear")) {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "CLEAR");
					mainworld.setThundering(false);
					mainworld.setStorm(false);
				} else if (args[0].equalsIgnoreCase("rain")) {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
					mainworld.setThundering(false);
					mainworld.setStorm(true);
				} else if (args[0].equalsIgnoreCase("downpour")) {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
					mainworld.setThundering(false);
					mainworld.setStorm(true);
				} else if (args[0].equalsIgnoreCase("thunder")) {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
					mainworld.setStorm(true);
					mainworld.setThundering(true);
				} else if (args[0].equalsIgnoreCase("lighting")) {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
					mainworld.setStorm(true);
					mainworld.setThundering(true);
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("weatherclear")) {
			changeW(sender, false, false, "CLEAR");
		} else if (cmd.getName().equalsIgnoreCase("weatherrain")) {
			changeW(sender, false, true, "RAIN");
		} else if (cmd.getName().equalsIgnoreCase("weatherthunder")) {
			changeW(sender, true, true, "LIGHTNING AND A THUNDER");
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("weather")) {
			List<String> weather = new ArrayList<>();
			if (args.length == 1) {
				weather.add("clear");
				weather.add("rain");
				weather.add("thunder");
			}
			return weather;
		} else {
			return null;
		}
	}

	public void changeW(CommandSender sender, Boolean thunder, Boolean storm, String name) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (sender.hasPermission("BlitzSsentials.weather")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + name);
				player.getWorld().setThundering(thunder);
				player.getWorld().setStorm(storm);
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			World mainworld = Bukkit.getWorlds().get(0);
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + name);
			mainworld.setThundering(thunder);
			mainworld.setStorm(storm);
		}
	}

}
