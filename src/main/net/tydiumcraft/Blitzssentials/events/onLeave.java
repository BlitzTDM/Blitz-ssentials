package net.tydiumcraft.Blitzssentials.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

public class onLeave implements Listener {
	
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

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

    @EventHandler
    void onPlayerLeave(PlayerQuitEvent event) {

		Player player = event.getPlayer();
    
    String leavemessage = config.getString("leave-message.leave.leave-message");
    leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
    leavemessage = ChatColor.translateAlternateColorCodes('§', leavemessage);
    leavemessage = leavemessage.replace("%player%", player.getName());
    leavemessage = leavemessage.replace("%playerfull%", player.getDisplayName());
    leavemessage = leavemessage.replace("%line%", line);
    
    	if (config.getBoolean("leave-message.leave.enable-leave-message")) {
    		event.setQuitMessage(leavemessage);
    	}
    }
}
