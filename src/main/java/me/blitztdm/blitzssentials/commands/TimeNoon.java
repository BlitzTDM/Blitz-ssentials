package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;
import static me.blitztdm.blitzssentials.utils.shortcutTags.pluginprefix;

@SuppressWarnings("unused")
public class TimeNoon implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public TimeNoon(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("noon").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.time")) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "NOON");
    			((Player) sender).getWorld().setTime(6000);
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		World mainworld = Bukkit.getWorlds().get(0);
    		sender.sendMessage(pluginprefix + ChatColor.GREEN + "Time set to " + ChatColor.GOLD + "NOON");
			mainworld.setTime(6000);
    	}
		return false;
    }
}
