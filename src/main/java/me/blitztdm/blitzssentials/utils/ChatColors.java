package me.blitztdm.blitzssentials.utils;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatColors implements Listener {
	
	public static Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	public ChatColors(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		event.setMessage(format(event.getMessage()));
	}

	public static String format(String msg) {
		String version = Bukkit.getVersion();
		if (version.contains("1.16") || version.contains("1.17") || version.contains("1.18") ||
			version.contains("1.19") || version.contains("1.20") || version.contains("1.21") ||
			version.contains("1.22") || version.contains("1.23") || version.contains("1.24") ||
			version.contains("1.25") || version.contains("1.26") || version.contains("1.27") ||
			version.contains("1.28") || version.contains("1.29") || version.contains("1.3")) {

			Matcher match = pattern.matcher(msg);
			while (match.find()) {
				String color = msg.substring(match.start(), match.end());
				msg = msg.replace(color, ChatColor.of(color) + "");
				match = pattern.matcher(msg);
			}
		}
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
}


