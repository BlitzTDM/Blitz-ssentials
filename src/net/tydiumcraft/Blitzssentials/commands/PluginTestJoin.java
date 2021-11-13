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
public class PluginTestJoin implements CommandExecutor {
	
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
	public PluginTestJoin(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("TestJoin").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.test") || !(sender instanceof Player)) {
    			
    			FileConfiguration config = plugin.getConfig();
    		    
    		    String globalmessage = config.getString("join-message.global.global-message");
    		    globalmessage = ChatColor.translateAlternateColorCodes('&', globalmessage);
    		    globalmessage = ChatColor.translateAlternateColorCodes('§', globalmessage);
    		    globalmessage = globalmessage.replace("%player%", sender.getName());
    		    globalmessage = globalmessage.replace("%playerfull%", ((Player)sender).getDisplayName());
    		    globalmessage = globalmessage.replace("%line%", line);
    		    
    		    String defaultmessage = config.getString("join-message.default-personal.default-personal-message");
    		    defaultmessage = ChatColor.translateAlternateColorCodes('&', defaultmessage);
    		    defaultmessage = ChatColor.translateAlternateColorCodes('§', defaultmessage);
    		    defaultmessage = defaultmessage.replace("%player%", sender.getName());
    		    defaultmessage = defaultmessage.replace("%playerfull%", ((Player)sender).getDisplayName());
    		    defaultmessage = defaultmessage.replace("%line%", line);
    			
    		    String adminmessage = config.getString("join-message.admin-personal.admin-personal-message");
    		    adminmessage = ChatColor.translateAlternateColorCodes('&', adminmessage);
    		    adminmessage = ChatColor.translateAlternateColorCodes('§', adminmessage);
    		    adminmessage = adminmessage.replace("%player%", sender.getName());
    		    adminmessage = adminmessage.replace("%playerfull%", ((Player)sender).getDisplayName());
    		    adminmessage = adminmessage.replace("%line%", line);
    		    adminmessage = adminmessage.replace("%plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
    		    adminmessage = adminmessage.replace("%api%", apiversion);
    		    
    		    
    		    sender.sendMessage(globalmessage);
    		    sender.sendMessage(defaultmessage);
    			sender.sendMessage(adminmessage);
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
