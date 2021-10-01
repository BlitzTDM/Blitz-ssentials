package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class GamemodeS implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
	private BlitzssentialsMain plugin;
	
	public GamemodeS(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gms").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (args.length == 0) {
    		if (sender.hasPermission("BlitzSsentials.gms")) {
    			if (((Player) sender).getGameMode() == GameMode.SURVIVAL) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    			((Player) sender).setGameMode(GameMode.SURVIVAL);
    				}
    		} else if (sender.hasPermission("BlitzSsentials.othergm")) {
				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
				if (arg0 == null) {
    				sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
				} else {
				if (arg0.getGameMode() == GameMode.SURVIVAL) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + arg0.getDisplayName() + " is " + "Already in " + arg0.getGameMode());	
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + arg0.getGameMode());
    			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + arg0.getGameMode());
    			arg0.setGameMode(GameMode.SURVIVAL);
    				}
			}
		} else {
			sender.sendMessage(noperm);
		}
		} else {
			sender.sendMessage(noperm);
			}
	} else {
		if (args.length == 0) {
			sender.sendMessage(pluginprefix + ChatColor.RED + "Specify Player");
	} else {
		Player arg0 = Bukkit.getServer().getPlayer(args[0]);
		if (arg0 == null) {
			sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
		} else {
		if (arg0.getGameMode() == GameMode.SURVIVAL) {
			sender.sendMessage(pluginprefix + ChatColor.RED + arg0.getDisplayName() + " is " + "Already in " + arg0.getGameMode());	
			} else {
		sender.sendMessage(pluginprefix + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + arg0.getGameMode());
		arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SURVIVAL " + ChatColor.GREEN + "from " + arg0.getGameMode());
		arg0.setGameMode(GameMode.SURVIVAL);
			}
		}
	}
	}
		return false;
    }
}
