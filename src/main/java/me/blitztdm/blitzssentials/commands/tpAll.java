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
public class tpAll implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public tpAll(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("tpall").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("BlitzSsentials.tpall") || !(sender instanceof Player)) {
			if (args.length == 0 && sender instanceof Player) {
				Player executer = (Player) sender;
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.teleport(executer.getLocation());
					player.sendMessage(pluginprefix + "Teleported to " + sender.getName() + "!");
				}
			} else if (args.length == 1) {
				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
				if (arg0 != null) {
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.teleport(arg0.getLocation());
						player.sendMessage(pluginprefix + "Teleported to " + arg0.getName() + "!");
					}
				} else {
					sender.sendMessage(cannotfind + args[0]);
				}
			} else if (!(sender instanceof Player)) {
				sender.sendMessage(specifyplayer);
			}
		} else {
			sender.sendMessage(noperm);
		}
		return false;
	}
}
