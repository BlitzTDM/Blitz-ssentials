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
public class Feed implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Feed(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("feed").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    			if (args.length == 0 && sender.hasPermission("BlitzSsentials.feed") && sender instanceof Player) {
    				((Player) sender).setFoodLevel(20);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Fed!");
        			
    			} else if (sender.hasPermission("BlitzSsentials.feed.other") || !(sender instanceof Player)) {
    				if (!(sender instanceof Player) && args.length == 0) {
    					sender.sendMessage(specifyplayer);
    				} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(cannotfind + args[0]);
    				} else {
    				arg0.setFoodLevel(20);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Fed " + arg0.getDisplayName() + "!");
    				arg0.sendMessage(pluginprefix + ChatColor.GREEN + "You've Been Fed!");
    				}
    				}
    			} else if (sender.hasPermission("BlitzSsentials.feed.all") || !(sender instanceof Player)) {
    				if (args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("*")) {
						sender.sendMessage(pluginprefix + ChatColor.GREEN + "Fed Everyone!");
						for (Player player : Bukkit.getOnlinePlayers()) {
							player.setFoodLevel(20);
							player.sendMessage(pluginprefix + ChatColor.GREEN + "You've Been Fed!");
						}
					} else {
						sender.sendMessage(lessargs + "Did you mean '/Feed All'");
					}
    			} else {
    				sender.sendMessage(noperm);
    			}
		return false;
    }
}
