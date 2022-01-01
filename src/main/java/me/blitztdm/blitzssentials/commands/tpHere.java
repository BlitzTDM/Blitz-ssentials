package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class tpHere implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public tpHere(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("tphere").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission("BlitzSsentials.tphere")) {
				if (args.length == 1) {
					Player arg0 = Bukkit.getPlayer(args[0]);
					if (arg0 == null) {
						sender.sendMessage(cannotfind + args[0]);
					} else if (arg0 != null) {
						sender.sendMessage(pluginprefix + "Teleported " + arg0.getName() + " to you!");
						arg0.sendMessage(pluginprefix + "Teleported to " + sender.getName() + "!");
						arg0.teleport(((Player) sender).getLocation());
					}
				} else {
					sender.sendMessage(specifyplayer);
				}
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			sender.sendMessage(console);
		}
		return false;
	}
}
