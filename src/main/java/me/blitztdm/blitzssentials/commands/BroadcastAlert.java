package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;

@SuppressWarnings("unused")
public class BroadcastAlert implements TabExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public BroadcastAlert(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("alert").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("BlitzSsentials.broadcast.alert") || !(sender instanceof Player)) {
			StringBuilder message = new StringBuilder();

			for (int i = 0; i < args.length; i++) {
				message.append(args[i]).append(" ");
			}

			String alertmessage = message.toString().trim();

			alertmessage = ChatColor.translateAlternateColorCodes('&', alertmessage);

			if (config.getBoolean("broadcast.bc-alert.enable-prefix")) {
				String alertprefix = config.getString("broadcast.bc-alert.prefix");
				alertprefix = ChatColor.translateAlternateColorCodes('&', alertprefix);

				Bukkit.getServer().broadcastMessage(alertprefix + alertmessage);
			} else {
				Bukkit.getServer().broadcastMessage(alertmessage);
			}
			if (config.getBoolean("broadcast.bc-alert.enable-sound")) {
				String sound = config.getString("broadcast.bc-alert.sound").toUpperCase().replace('.', '_');

				for (Player player : Bukkit.getOnlinePlayers()) {
					player.playSound(player.getLocation(), Sound.valueOf(sound), config.getInt("broadcast.bc-alert.volume"), config.getInt("broadcast.bc-alert.pitch"));
				}
			}
		} else {
			sender.sendMessage(noperm);
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> alert = new ArrayList<>();

		alert.add("<message>");

		return alert;
	}
}
