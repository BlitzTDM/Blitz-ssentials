package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class PluginTestLeave implements CommandExecutor {
	
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
	
    private BlitzssentialsMain plugin;
	public PluginTestLeave(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("TestLeave").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.test") || !(sender instanceof Player)) {
    			
    			FileConfiguration config = plugin.getConfig();
    			
    			String leavemessage = config.getString("leave-message.leave.leave-message");
    		    leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
    		    leavemessage = ChatColor.translateAlternateColorCodes('§', leavemessage);
    		    leavemessage = leavemessage.replace("%player%", sender.getName());
    		    leavemessage = leavemessage.replace("%playerfull%", ((Player) sender).getDisplayName());
    		    leavemessage = leavemessage.replace("%line%", line);
    		    
    		    sender.sendMessage(leavemessage);
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
