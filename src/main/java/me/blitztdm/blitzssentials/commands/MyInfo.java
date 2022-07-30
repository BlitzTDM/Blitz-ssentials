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
    			myInfo(sender, player);
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
				myInfo(sender, other);
    		}
    	} else {
    		sender.sendMessage(noperm);
    	}
		return false;
    }

	public void myInfo(CommandSender sender, Player player) {
		String myUUID = player.getUniqueId().toString();
		String ping = String.valueOf(player.getPing());
		String myName = player.getName();
		String myPing;

		if (player.getPing() <= 50) {
			myPing = ChatColor.GREEN + ping;
		} else if (player.getPing() <= 100) {
			myPing = ChatColor.YELLOW + ping;
		} else if (player.getPing() <= 150) {
			myPing = ChatColor.RED + ping;
		} else {
			myPing =  ChatColor.DARK_RED + ping;
		}
		sender.sendMessage(
				ChatColor.GOLD + line + "\n" +
						ChatColor.AQUA + "Your Player-Server Info:" + myPing + "\n" +
						ChatColor.DARK_GRAY + "Your UUID is: " + ChatColor.GRAY + myUUID + "\n" +
						ChatColor.GREEN + "Your Name is: " + ChatColor.RESET + myName + "\n" +
						ChatColor.BLUE + "Your Ping is: " + myPing + "\n" +
						ChatColor.GOLD + line
		);
	}
}
