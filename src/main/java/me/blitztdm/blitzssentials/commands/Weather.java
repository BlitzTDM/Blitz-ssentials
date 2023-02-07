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
			if (sender.hasPermission("BlitzSsentials.weather") || !(sender instanceof Player)) {
				weatherChange(sender, args);
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			ArrayList<String> otherargs = new ArrayList<>();
			if (cmd.getName().equalsIgnoreCase("weatherclear")) {
				otherargs.add("clear");
			} else if (cmd.getName().equalsIgnoreCase("weatherrain")) {
				otherargs.add("rain");
			} else if (cmd.getName().equalsIgnoreCase("weatherthunder")) {
				otherargs.add("thunder");
			}
			if (args.length > 1 && Bukkit.getWorlds().contains(args[1])) {
				otherargs.add(args[1]);
			}
			weatherChange(sender, otherargs.toArray(new String[0]));
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
			} else if (args.length == 2) {
				for (World world : Bukkit.getWorlds()) {
					weather.add(world.getName());
				}
			}
			return weather;
		} else {
			return null;
		}
	}

	public void weatherChange(CommandSender sender, String[] args) {
		World world;
		if (args.length > 1 && Bukkit.getWorlds().contains(args[1])) {
			world = Bukkit.getWorld(args[1]);
		} else {
			if (sender instanceof Player) {
				world = ((Player) sender).getWorld();
			} else {
				world = Bukkit.getWorlds().get(0);
			}
		}
		if (args[0].equalsIgnoreCase("clear")) {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "CLEAR");
			world.setThundering(false);
			world.setStorm(false);
		} else if (args[0].equalsIgnoreCase("rain")) {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
			world.setThundering(false);
			world.setStorm(true);
		} else if (args[0].equalsIgnoreCase("downpour")) {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "RAIN");
			world.setThundering(false);
			world.setStorm(true);
		} else if (args[0].equalsIgnoreCase("thunder")) {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
			world.setStorm(true);
			world.setThundering(true);
		} else if (args[0].equalsIgnoreCase("lighting")) {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Weather has been set to " + ChatColor.GOLD + "LIGHTNING AND A THUNDER");
			world.setStorm(true);
			world.setThundering(true);
		}
	}
}
