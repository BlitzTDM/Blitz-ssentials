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
public class GamemodeC implements CommandExecutor {
	
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
	
	public GamemodeC(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gmc").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.gmc")) {
    			if (args.length == 0) {
    			if (((Player) sender).getGameMode() == GameMode.CREATIVE) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + ((Player) sender).getGameMode());
    			((Player) sender).setGameMode(GameMode.CREATIVE);
    				}
    			} else if (sender.hasPermission("BlitzSsentials.othergm")) {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
    				} else {
    				if (arg0.getGameMode() == GameMode.CREATIVE) {
            			sender.sendMessage(pluginprefix + ChatColor.RED + args[0] + "'s " + "Already in " + arg0.getGameMode());	
        				} else {
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + args[0] + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + arg0.getGameMode());
        			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + arg0.getGameMode());
        			arg0.setGameMode(GameMode.CREATIVE);
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
			if (arg0.getGameMode() == GameMode.CREATIVE) {
    			sender.sendMessage(pluginprefix + ChatColor.RED + args[0] + "'s " + "Already in " + arg0.getGameMode());	
				} else {
			sender.sendMessage(pluginprefix + ChatColor.GREEN + args[0] + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + arg0.getGameMode());
			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "CREATIVE " + ChatColor.GREEN + "from " + arg0.getGameMode());
			arg0.setGameMode(GameMode.CREATIVE);
				}
			}
    	}
    	}
		return false;
    }
}