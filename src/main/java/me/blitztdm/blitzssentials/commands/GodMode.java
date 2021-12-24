package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class GodMode implements CommandExecutor {
	
    public static ArrayList<Player> god = new ArrayList<Player>();

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public GodMode(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("god").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		Player player = (Player) sender;
    		if (sender.hasPermission("BlitzSsentials.god")) {
    			if (!god.contains(player)) {
    				player.setInvulnerable(true);
    				if (!player.getGameMode().equals(GameMode.CREATIVE) || !player.getGameMode().equals(GameMode.SPECTATOR)) {
    				player.setFlying(true);
    				}
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Now in " + ChatColor.GOLD + "GODMODE");
        			god.add(player);
    			} else {
    				player.setInvulnerable(false);
    				if (!player.getGameMode().equals(GameMode.CREATIVE) || !player.getGameMode().equals(GameMode.SPECTATOR)) {
    				player.setFlying(false);
    				}
        			sender.sendMessage(pluginprefix + ChatColor.RED + "No longer in " + ChatColor.GOLD + "GODMODE");
        			god.remove(player);
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(console);
    	}
		return false;
    }
}
