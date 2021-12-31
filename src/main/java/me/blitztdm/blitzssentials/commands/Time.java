package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class Time implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Time(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("day").setExecutor(this);
		plugin.getCommand("noon").setExecutor(this);
		plugin.getCommand("night").setExecutor(this);
		plugin.getCommand("midnight").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("day")) {
			changeT(sender, 23500, "DAY");
		} else if (cmd.getName().equalsIgnoreCase("noon")) {
			changeT(sender, 600, "NOON");
		} else if (cmd.getName().equalsIgnoreCase("night")) {
			changeT(sender, 13000, "NIGHT");
		} else if (cmd.getName().equalsIgnoreCase("midnight")) {
			changeT(sender, 18000, "MIDNIGHT");
		}
		return false;
    }

	public void changeT(CommandSender sender, long time, String name) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (sender.hasPermission("BlitzSsentials.time")) {
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + name);
				player.getWorld().setTime(time);
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			World mainworld = Bukkit.getWorlds().get(0);
			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + name);
			mainworld.setTime(time);
		}
	}
}
