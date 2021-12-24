package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;
import static me.blitztdm.blitzssentials.utils.shortcutTags.pluginprefix;

@SuppressWarnings("unused")
public class KillAll implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public KillAll(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("killall").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.kill.all")) {
    			for (Player player : Bukkit.getOnlinePlayers()) {
    				if (player.hasPermission("BlitzSsentials.kill.all.avoid")) {
    					player.sendMessage(pluginprefix + ChatColor.GREEN + "You have avoided from getting Killed");
    				} else {
    					player.setHealth(0);
    					player.sendMessage(ChatColor.RED + "You Have Been Killed");
    				}
    			}
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Killed all Players");
    		} else {
    			sender.sendMessage(noperm);
    	}
		return false;
    }
}
