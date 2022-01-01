package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class JoinMessage implements Listener {
    
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

	public JoinMessage(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	void onPlayerJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		String globalmessage = config.getString("join-message.global.global-message");
		globalmessage = ChatColor.translateAlternateColorCodes('&', globalmessage);
		globalmessage = globalmessage.replace("%player%", player.getName());
		globalmessage = globalmessage.replace("%playerfull%", player.getDisplayName());
		globalmessage = globalmessage.replace("%line%", line);

		String defaultmessage = config.getString("join-message.default-personal.default-personal-message");
		defaultmessage = ChatColor.translateAlternateColorCodes('&', defaultmessage);
		defaultmessage = defaultmessage.replace("%player%", player.getName());
		defaultmessage = defaultmessage.replace("%playerfull%", player.getDisplayName());
		defaultmessage = defaultmessage.replace("%line%", line);

		String adminmessage = config.getString("join-message.admin-personal.admin-personal-message");
		adminmessage = ChatColor.translateAlternateColorCodes('&', adminmessage);
		adminmessage = adminmessage.replace("%player%", player.getName());
		adminmessage = adminmessage.replace("%playerfull%", player.getDisplayName());
		adminmessage = adminmessage.replace("%line%", line);
		adminmessage = adminmessage.replace("%plugin%", pluginprefix + ChatColor.DARK_AQUA + pluginversion);
		adminmessage = adminmessage.replace("%api%", apiversion);

		if (config.getBoolean("join-sound.enable-join-sound")) {
			String sound = config.getString("join-sound.sound").toUpperCase().replace(".", "_");

			if (!(Sound.valueOf(sound) == null)) {
				player.playSound(player.getLocation(), Sound.valueOf(sound), SoundCategory.MASTER, config.getInt("join-sound.volume"), config.getInt("join-sound.pitch"));
			} else {
				Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.RED + "ERROR! Sound in Config for join-sound, '" + sound + "' is not a valid sound!");
			}
		}

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
