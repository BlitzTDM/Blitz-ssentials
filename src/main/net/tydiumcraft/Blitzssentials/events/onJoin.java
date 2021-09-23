package net.tydiumcraft.Blitzssentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class onJoin implements Listener {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    
	@EventHandler
	void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
	    
	    String globalmessage = config.getString("join-message.global.global-message");
	    globalmessage = ChatColor.translateAlternateColorCodes('&', globalmessage);
	    globalmessage = ChatColor.translateAlternateColorCodes('§', globalmessage);
	    globalmessage = globalmessage.replace("%player%", player.getName());
	    globalmessage = globalmessage.replace("%Player%", player.getName());
	    globalmessage = globalmessage.replace("%line%", line);
	    globalmessage = globalmessage.replace("%Line%", line);
	    
	    String defaultmessage = config.getString("join-message.default-personal.default-personal-message");
	    defaultmessage = ChatColor.translateAlternateColorCodes('&', defaultmessage);
	    defaultmessage = ChatColor.translateAlternateColorCodes('§', defaultmessage);
	    defaultmessage = defaultmessage.replace("%player%", player.getName());
	    defaultmessage = defaultmessage.replace("%Player%", player.getName());
	    defaultmessage = defaultmessage.replace("%line%", line);
	    defaultmessage = defaultmessage.replace("%Line%", line);
		
	    String adminmessage = config.getString("join-message.admin-personal.admin-personal-message");
	    adminmessage = ChatColor.translateAlternateColorCodes('&', adminmessage);
	    adminmessage = ChatColor.translateAlternateColorCodes('§', adminmessage);
	    adminmessage = adminmessage.replace("%player%", player.getName());
	    adminmessage = adminmessage.replace("%Player%", player.getName());
	    adminmessage = adminmessage.replace("%line%", line);
	    adminmessage = adminmessage.replace("%Line%", line);
	    adminmessage = adminmessage.replace("%plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
	    adminmessage = adminmessage.replace("%Plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
	    
	    
	    if (config.getBoolean("join-message.global.enable-global")) {
	    	event.setJoinMessage(globalmessage);
	    }
	    if ((player.hasPermission("BlitzSsentials.join"))) {
	    	if (config.getBoolean("join-message.default-personal.enable-default-personal")) {
	    		player.sendMessage(defaultmessage);
	    	}
	    	
			if ((player.hasPermission("BlitzSsentials.adminjoin"))) {
				if (config.getBoolean("join-message.admin-personal.enable-admin-personal")) {
					player.sendMessage(adminmessage);
				}
				
			}
	    }
	}
}
