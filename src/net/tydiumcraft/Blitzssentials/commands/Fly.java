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
public class Fly implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
	String cannotfind = shortcutTags.cannotfind;
	String specifyplayer = shortcutTags.specifyplayer;
    String pluginversion = shortcutTags.pluginversion;
	
    private BlitzssentialsMain plugin;
	public Fly(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
		
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.fly") || !(sender instanceof Player)) {
    			if (args.length == 0 && sender instanceof Player) {
    				if (!(((Player) sender).getAllowFlight())) {
        				((Player) sender).setAllowFlight(true);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
        			} else if (((Player) sender).getAllowFlight()) {
        				((Player) sender).setAllowFlight(false);
        				sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
        			}
    			} else if (sender.hasPermission("BlitzSsentials.fly.other") || !(sender instanceof Player)) {
    				if (args.length == 0 && !(sender instanceof Player)) {
        	    		sender.sendMessage(specifyplayer);
    				} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(cannotfind);
    				} else {
        				if (!(arg0.getAllowFlight())) {
            				arg0.setAllowFlight(true);
            			arg0.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying!");
            			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Enabled Flying for " + arg0.getDisplayName() + "!");
            			} else if (arg0.getAllowFlight()) {
            				arg0.setAllowFlight(false);
            				arg0.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying!");
            				sender.sendMessage(pluginprefix + ChatColor.RED + "Disabled Flying for " + arg0.getDisplayName() + "!");
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