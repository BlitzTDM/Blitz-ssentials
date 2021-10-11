package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class Feed implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    String lessargs = shortcutTags.lessargs;
	
    private BlitzssentialsMain plugin;
	public Feed(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("feed").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.feed") || !(sender instanceof Player)) {
    			if (args.length == 0 && sender instanceof Player) {
    				((Player) sender).setFoodLevel(20);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Fed!");
        			
    			} else if (sender.hasPermission("BlitzSsentials.feed.other") || !(sender instanceof Player)) {
    				if (!(sender instanceof Player) && args.length == 0) {
    					sender.sendMessage(pluginprefix + ChatColor.RED + "Specify Player");
    				} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(pluginprefix + ChatColor.RED + "Cannot find " + args[0]);
    				} else {
    				arg0.setFoodLevel(20);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Fed " + arg0.getDisplayName() + "!");
    				arg0.sendMessage(pluginprefix + ChatColor.GREEN + "You've Been Fed!");
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
