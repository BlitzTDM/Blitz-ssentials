package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class MassSummon implements CommandExecutor {
	
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
	public MassSummon(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("masssummon").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		int maxammount = plugin.getConfig().getInt("mass-summon.max-amount");
    		
    		if (sender.hasPermission("BlitzSsentials.masssummon")) {
    			if (args.length >= 2) {
    				try {
    				EntityType entity = EntityType.valueOf(args[0].toUpperCase());
    				int amount = Integer.parseInt(args[1]);
    				if (plugin.getConfig().getBoolean("mass-summon.enable-max-amount")) {
    				if (amount < maxammount) {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Summoned " + ChatColor.GOLD + entity + ChatColor.GREEN + ", " + ChatColor.GOLD + amount + ChatColor.GREEN + " time(s)");
    				for (int x = 0; x < amount; x++) {
    					((Player) sender).getWorld().spawnEntity(((Player) sender).getLocation(), entity);
    				}
    				} else {
    					sender.sendMessage(pluginprefix + ChatColor.RED + "Too many Entities");
    				}
    				} else {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Summoned " + ChatColor.GOLD + entity + ChatColor.GREEN + ", " + ChatColor.GOLD + amount + ChatColor.GREEN + " time(s)");
    					for (int x = 0; x < amount; x++) {
        					((Player) sender).getWorld().spawnEntity(((Player) sender).getLocation(), entity);
    					}
    				}
    				} catch (IllegalArgumentException entity) {
    					sender.sendMessage(lessargs + "Not a Valid Entity");
    				}
    			} else {
    			  sender.sendMessage(lessargs + "/MassSummon <Entity> <Ammount>");
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
