package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class Fly implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Fly(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
	}

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.fly") || !(sender instanceof Player)) {
				if (args.length == 0 && sender instanceof Player) {
					Player player = (Player) sender;
					if (!(player.getAllowFlight())) {
						player.setAllowFlight(true);
						sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
					} else if (player.getAllowFlight()) {
						player.setAllowFlight(false);
						sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
					}
				} else if (sender.hasPermission("BlitzSsentials.fly.other") || !(sender instanceof Player)) {
					if (args.length == 0 && !(sender instanceof Player)) {
						sender.sendMessage(specifyplayer);
					} else {
						Player arg0 = Bukkit.getServer().getPlayer(args[0]);
						if (arg0 == null) {
							sender.sendMessage(cannotfind);
						} else {
							if (!(arg0.getAllowFlight())) {
								arg0.setAllowFlight(true);
								arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
								sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying for " + arg0.getDisplayName() + "!");
							} else if (arg0.getAllowFlight()) {
								arg0.setAllowFlight(false);
								arg0.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
								sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying for " + arg0.getDisplayName() + "!");
							}
						}
					}
				} else {
					sender.sendMessage(noperm);
				}
			} else {
				sender.sendMessage(noperm);
			}
		return false;
    }
}