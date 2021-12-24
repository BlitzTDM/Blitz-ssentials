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

public class GamemodeSP implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public GamemodeSP(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gmsp").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.gmsp") || !(sender instanceof Player)) {
    			if (args.length == 0 && sender instanceof Player) {
					Player player = (Player) sender;
					if (((Player) sender).getGameMode() == GameMode.SPECTATOR) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + ((Player) sender).getGameMode());	
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SPECTATOR " + ChatColor.GREEN + "from " + player.getGameMode());
    			player.setGameMode(GameMode.SPECTATOR);
    				}
    			
    			} else if (sender.hasPermission("BlitzSsentials.othergm") || !(sender instanceof Player)) {
        			if (args.length == 0 && !(sender instanceof Player)) {
        				sender.sendMessage(specifyplayer);
        		} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(cannotfind + args[0]);
    				} else {
    				if (arg0.getGameMode() == GameMode.SPECTATOR) {
            			sender.sendMessage(pluginprefix + ChatColor.RED + arg0.getDisplayName() + " is " + "Already in " + arg0.getGameMode());	
        				} else {
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "SPECTATOR " + ChatColor.GREEN + "from " + arg0.getGameMode());
        			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "SPECTATOR " + ChatColor.GREEN + "from " + arg0.getGameMode());
        			arg0.setGameMode(GameMode.SPECTATOR);
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
