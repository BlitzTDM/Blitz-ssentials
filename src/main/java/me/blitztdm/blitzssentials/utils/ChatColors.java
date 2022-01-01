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
	
	private final Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	public ChatColors(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		event.setMessage(format(event.getMessage()));
	}
	private String format(String msg) {
		if (Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18")) {
			
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
