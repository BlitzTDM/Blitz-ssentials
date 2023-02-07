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
public class PluginReloadPlugin implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public PluginReloadPlugin(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("BZSsReload").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.reload") || !(sender instanceof Player)) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Reloading Plugin");
				Bukkit.getPluginManager().disablePlugin(plugin);
				Bukkit.getScheduler().cancelTasks(plugin);
				Bukkit.getPluginManager().enablePlugin(plugin);
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Plugin Reloaded");
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
