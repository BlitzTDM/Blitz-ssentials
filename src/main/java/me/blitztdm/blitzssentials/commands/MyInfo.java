package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class MyInfo implements CommandExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public MyInfo(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("myinfo").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
    	if (sender instanceof Player) {
			Player player = (Player) sender;
    		if (sender.hasPermission("BlitzSsentials.myinfo")) {
    			String myUUID = player.getUniqueId().toString();
    			String myPing = String.valueOf(player.getPing());
    			String myName = player.getName();
    			String myDisplayName = player.getDisplayName();
    			String myCustomName = player.getCustomName();
    			String myPlayerListName = player.getPlayerListName();
    			
    			sender.sendMessage(ChatColor.GOLD + line + "\n"
    					+ ChatColor.AQUA + "Your Player-Server Info:");
    			if (player.getPing() <= 50) {
    				sender.sendMessage(ChatColor.BLUE + "Your Ping is: " + ChatColor.GREEN + myPing);
    			} else if (player.getPing() <= 100) {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Your Ping is: " + ChatColor.YELLOW + myPing);
    			} else if (player.getPing() <= 150) {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Your Ping is: " + ChatColor.RED + myPing);
    			} else {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Your Ping is: " + ChatColor.DARK_RED + myPing);
    			}
    			sender.sendMessage(
    					ChatColor.DARK_GRAY + "Your UUID is: " + ChatColor.GRAY + myUUID + "\n" +
    	    			ChatColor.GREEN + "Your Name is: " + ChatColor.RESET + myName + "\n" +
    					ChatColor.DARK_GREEN + "Your Display Name is: " + ChatColor.RESET + myDisplayName + "\n" +
    					ChatColor.DARK_PURPLE + "Your Custom Name is: " + ChatColor.RESET + myCustomName + "\n" +
    					ChatColor.DARK_PURPLE + "Your Playerlist Name is: " + ChatColor.RESET + myPlayerListName + "\n" +
    					ChatColor.GOLD + line
    					);
    			
    		} else {
    			sender.sendMessage(noperm);
    		}
    	} else {
    		sender.sendMessage(specifyplayer);
    	}
    	} else if (sender.hasPermission("myinfo.other")) {
    		Player other = Bukkit.getServer().getPlayer(args[0]);
    		if (other == null) {
    			sender.sendMessage(cannotfind + args[0]);
    		} else {
    			String otherUUID = other.getUniqueId().toString();
    			String otherPing = String.valueOf(other.getPing());
    			String otherName = other.getName();
    			String otherDisplayName = other.getDisplayName();
    			String otherCustomName = other.getCustomName();
    			String otherPlayerListName = other.getPlayerListName();
    			
    			sender.sendMessage(ChatColor.GOLD + line + ChatColor.RESET + "\n"
    					+ ChatColor.AQUA + args[0] + " Player-Server Info:");
    			if (other.getPing() <= 50) {
    				sender.sendMessage(ChatColor.BLUE + "Their Ping is: " + ChatColor.GREEN + otherPing);
    			} else if (other.getPing() <= 100) {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Their Ping is: " + ChatColor.YELLOW + otherPing);
    			} else if (other.getPing() <= 150) {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Their Ping is: " + ChatColor.RED + otherPing);
    			} else {
    				sender.sendMessage(ChatColor.DARK_GRAY + "Their Ping is: " + ChatColor.DARK_RED + otherPing);
    			}
    			sender.sendMessage(
    					ChatColor.DARK_GRAY + "Their UUID is: " + ChatColor.GRAY + otherUUID + "\n" + ChatColor.RESET +
    	    			ChatColor.GREEN + "Their Name is: " + ChatColor.RESET + otherName + "\n" + ChatColor.RESET +
    					ChatColor.DARK_GREEN + "Their Display Name is: " + ChatColor.RESET + otherDisplayName + "\n" + ChatColor.RESET +
    					ChatColor.DARK_PURPLE + "Their Custom Name is: " + ChatColor.RESET + otherCustomName + "\n" + ChatColor.RESET +
    					ChatColor.DARK_PURPLE + "Their Playerlist Name is: " + ChatColor.RESET + otherPlayerListName + "\n" + ChatColor.RESET +
    					ChatColor.GOLD + line
    					);
    		}
    	} else {
    		sender.sendMessage(noperm);
    	}
		return false;
    }
}
