package net.tydiumcraft.Blitzssentials.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class GodMode implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String lastpluginversion = shortcutTags.lastpluginversion;
    String lastpluginversionquick = shortcutTags.lastpluginversionquick;
    String apiversion = shortcutTags.apiversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
	
    public static ArrayList<Player> god = new ArrayList<Player>();
    
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	public GodMode(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("god").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		Player player = (Player) sender;
    		if (sender.hasPermission("BlitzSsentials.god")) {
    			if (!god.contains(player)) {
    				((Player) sender).setInvulnerable(true);
    				((Player) sender).setFlying(true);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Now in " + ChatColor.GOLD + "GODMODE");
        			god.add(player);
    			} else {
    				((Player) sender).setInvulnerable(false);
    				((Player) sender).setFlying(false);
        			sender.sendMessage(pluginprefix + ChatColor.RED + "No longer in " + ChatColor.GOLD + "GODMODE");
        			god.remove(player);
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(console);
    	}
		return false;
    }
}
