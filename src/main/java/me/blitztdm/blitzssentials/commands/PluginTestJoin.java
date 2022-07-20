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
public class PluginTestJoin implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
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
    		    globalmessage = globalmessage.replace("%player%", sender.getName());
    		    globalmessage = globalmessage.replace("%playerfull%", ((Player)sender).getDisplayName());
    		    globalmessage = globalmessage.replace("%line%", line);
    		    
    		    String defaultmessage = config.getString("join-message.default-personal.default-personal-message");
    		    defaultmessage = ChatColor.translateAlternateColorCodes('&', defaultmessage);
    		    defaultmessage = defaultmessage.replace("%player%", sender.getName());
    		    defaultmessage = defaultmessage.replace("%playerfull%", ((Player)sender).getDisplayName());
    		    defaultmessage = defaultmessage.replace("%line%", line);
    			
    		    String adminmessage = config.getString("join-message.admin-personal.admin-personal-message");
    		    adminmessage = ChatColor.translateAlternateColorCodes('&', adminmessage);
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
