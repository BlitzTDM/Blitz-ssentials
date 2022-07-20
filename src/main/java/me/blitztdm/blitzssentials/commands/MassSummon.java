package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class MassSummon implements TabExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
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
    			  sender.sendMessage(lessargs + "/MassSummon <Entity> <Amount>");
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(console);
    	}
		return false;
    }
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> masssummon = new ArrayList<>();
		if (args.length == 1) {
			for (EntityType entity : EntityType.values()) {
				if (args[0].length() == 0) {
					masssummon.add(entity.toString());
				} else if (entity.toString().startsWith(args[0].toUpperCase())) {
					masssummon.add(entity.toString());
				} else if (entity.toString().contains(args[0].toUpperCase())) {
					masssummon.add(entity.toString());
				} else {
					masssummon.add("<entity>");
				}
		    }
		} else if (args.length == 2) {
			masssummon.add("<amount>");
		}
		return masssummon;
	}
}
