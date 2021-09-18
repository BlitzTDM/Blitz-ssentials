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

@SuppressWarnings("unused")
public class onJoin implements Listener {
	
	public String line = "------------------------------------";
	public String line2 = "-----------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss ";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
    
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    String pluginversion = BlitzssentialsMain.pluginversion;
    
	@EventHandler
	void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
	    
	    String defaultmessage = plugin.getConfig().getString("default-join-message");
	    defaultmessage = ChatColor.translateAlternateColorCodes('&', defaultmessage);
	    defaultmessage = ChatColor.translateAlternateColorCodes('§', defaultmessage);
	    defaultmessage = defaultmessage.replace("%player%", player.getName());
	    defaultmessage = defaultmessage.replace("%Player%", player.getName());
	    defaultmessage = defaultmessage.replace("%line%", line);
	    defaultmessage = defaultmessage.replace("%Line%", line);
		
	    String adminmessage = plugin.getConfig().getString("admin-join-message");
	    adminmessage = ChatColor.translateAlternateColorCodes('&', adminmessage);
	    adminmessage = ChatColor.translateAlternateColorCodes('§', adminmessage);
	    adminmessage = adminmessage.replace("%player%", player.getName());
	    adminmessage = adminmessage.replace("%Player%", player.getName());
	    adminmessage = adminmessage.replace("%line%", line);
	    adminmessage = adminmessage.replace("%Line%", line);
	    adminmessage = adminmessage.replace("%plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
	    adminmessage = adminmessage.replace("%Plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
	    
	    if ((player.hasPermission("BlitzSsentials.join"))) {
	    	
	    	event.setJoinMessage(defaultmessage);
	    	
			if ((player.hasPermission("BlitzSsentials.admin"))) {
				
					player.sendMessage(adminmessage);
			    		
				
			}
	    }
	}
}
