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

public class GamemodeA implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public GamemodeA(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("gma").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.gma") || !(sender instanceof Player)) {
    			if (args.length == 0 && sender instanceof Player) {
					Player player = (Player) sender;
    			if (player.getGameMode() == GameMode.ADVENTURE) {
        			sender.sendMessage(pluginprefix + ChatColor.RED + "Already in " + player.getGameMode());
    				} else {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "ADVENTURE " + ChatColor.GREEN + "from " + player.getGameMode());
    			player.setGameMode(GameMode.ADVENTURE);
    				}
    			} else if (sender.hasPermission("BlitzSsentials.othergm") || !(sender instanceof Player)) {
    				if (args.length == 0 && !(sender instanceof Player)) {
    					sender.sendMessage(specifyplayer);
    			} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
    					sender.sendMessage(cannotfind + args[0]);
    				} else {
    				if (arg0.getGameMode() == GameMode.ADVENTURE) {
    					sender.sendMessage(pluginprefix + ChatColor.RED + arg0.getDisplayName() + " is " + "Already in " + arg0.getGameMode());	
    					} else {
    				sender.sendMessage(pluginprefix + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode Changed to " + ChatColor.GOLD + "ADVENTURE " + ChatColor.GREEN + "from " + arg0.getGameMode());
    				arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.GOLD + "ADVENTURE " + ChatColor.GREEN + "from " + arg0.getGameMode());
    				arg0.setGameMode(GameMode.ADVENTURE);
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
