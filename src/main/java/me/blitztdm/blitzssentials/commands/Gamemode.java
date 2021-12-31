package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

public class Gamemode implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Gamemode(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gma").setExecutor(this);
		plugin.getCommand("gmc").setExecutor(this);
		plugin.getCommand("gms").setExecutor(this);
		plugin.getCommand("gmsp").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gma")) {
			changeGM(sender, args, "gma", GameMode.ADVENTURE);
		} else if (cmd.getName().equalsIgnoreCase("gmc")) {
			changeGM(sender, args, "gmc", GameMode.CREATIVE);
		} else if (cmd.getName().equalsIgnoreCase("gms")) {
			changeGM(sender, args, "gmc", GameMode.SURVIVAL);
		} else if (cmd.getName().equalsIgnoreCase("gmsp")) {
			changeGM(sender, args, "gmsp", GameMode.SPECTATOR);
		}
    	return false;
    }

	public void changeGM(CommandSender sender, String[] args, String permission, GameMode gamemode) {
		if (sender.hasPermission("BlitzSsentials." + permission) || !(sender instanceof Player)) {
			if (args.length == 0 && sender instanceof Player) {
				Player player = (Player) sender;
				if (player.getGameMode() == gamemode) {
					sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + player.getGameMode());
				} else {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + gamemode.name() + ChatColor.GREEN + " from " + player.getGameMode());
					player.setGameMode(gamemode);
				}
			} else if (sender.hasPermission("BlitzSsentials.othergm") || !(sender instanceof Player)) {
				if (args.length == 0 && !(sender instanceof Player)) {
					sender.sendMessage(specifyplayer);
				} else {
					Player arg0 = Bukkit.getServer().getPlayer(args[0]);
					if (arg0 == null) {
						sender.sendMessage(cannotfind + args[0]);
					} else {
						if (arg0.getGameMode() == gamemode) {
							sender.sendMessage(pluginprefix + ChatColor.RED + arg0.getDisplayName() + " is " + "Already in " + arg0.getGameMode());
						} else {
							sender.sendMessage(pluginprefix + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode Changed to " + ChatColor.GOLD + gamemode.name() + ChatColor.GREEN + " from " + arg0.getGameMode());
							arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + gamemode.name() + ChatColor.GREEN + " from " + arg0.getGameMode());
							arg0.setGameMode(gamemode);
						}
					}
				}
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			sender.sendMessage(noperm);
		}
	}
}
