package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class PluginTest implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public PluginTest(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("test").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.test") || (!(sender instanceof Player))) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Test Command Successful ( " + bzssprefix2 + ChatColor.GREEN + ")");
    		} else {
    			sender.sendMessage(noperm);
    			}
		return false;
    }
}

