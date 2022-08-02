package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import me.blitztdm.blitzssentials.commands.Vanish;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

import static me.blitztdm.blitzssentials.utils.shortcutTags.line;

public class LeaveMessage implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    
    ArrayList<Player> vanished = Vanish.vanished;

    public LeaveMessage(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    void onPlayerLeave(PlayerQuitEvent event) {

		Player player = event.getPlayer();
    
    String leavemessage = config.getString("leave-message.leave.leave-message");
    leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
    leavemessage = leavemessage.replace("%player%", player.getName());
    leavemessage = leavemessage.replace("%playerfull%", player.getDisplayName());
    leavemessage = leavemessage.replace("%line%", line);
    
    if (vanished.contains(player)) {
    	event.setQuitMessage(null);
    	} else if (config.getBoolean("leave-message.leave.enable-leave-message")) {
    		event.setQuitMessage(leavemessage);
    	} else {
            event.setQuitMessage(null);
        }
    }
}
