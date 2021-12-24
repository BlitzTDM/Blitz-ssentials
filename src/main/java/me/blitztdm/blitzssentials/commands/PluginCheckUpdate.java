package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import me.blitztdm.blitzssentials.events.checkVersion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class PluginCheckUpdate implements CommandExecutor {
    
    String PluginUpdated = checkVersion.PluginUpdated;
	String PluginOutdated = checkVersion.PluginOutdated;
	String PluginError = checkVersion.VersionCheckError;

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public PluginCheckUpdate(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("bzssupdate").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.admin") || (!(sender instanceof Player))) {
				new checkVersion(plugin).getVersion(version -> {
					if (pluginversion.equalsIgnoreCase(version)) {
						Bukkit.getConsoleSender().sendMessage(PluginUpdated);
					} else if (version.equalsIgnoreCase(pluginversionreal)) {
						Bukkit.getConsoleSender().sendMessage(PluginUpdated);
					} else if (version.equalsIgnoreCase(lastpluginversion)) {
						Bukkit.getConsoleSender().sendMessage(PluginUpdated);
					} else if (version.equalsIgnoreCase(lastpluginversionquick)) {
						Bukkit.getConsoleSender().sendMessage(PluginUpdated);
					} else if (version.equalsIgnoreCase(tydiumcrafteditionversion)) {
						Bukkit.getConsoleSender().sendMessage(PluginUpdated);
					} else {
						Bukkit.getConsoleSender().sendMessage(PluginOutdated);
					}});
    				if (plugin.getConfig().getInt("config-version") == configversionI) {
    					sender.sendMessage(bzssprefix + ChatColor.GREEN + "Config is Up-to-Date!");
    				} else {
    					sender.sendMessage(bzssprefix + ChatColor.RED + "Config is not Up-to-Date, use /BZSsConfig to Update it!");
    				}
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
