package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class HelpBC implements CommandExecutor {

		private BlitzssentialsMain plugin;
		public HelpBC(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZSsHelpBroadcast").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu! - Broadcast" + ChatColor.DARK_AQUA + "\n"
	    	    	+ ChatColor.AQUA + "/BC <message> " + helpmenu1 + "Broadcast a Message" + "\n"
	    			+ ChatColor.AQUA + "/BCAlert " + helpmenu1 + "Alert with a Message and Sound" + "\n"
	    			+ ChatColor.AQUA + "/BCCountdown" + helpmenu1 + "Broadcast a Countdown" + "\n"
	    			+ ChatColor.AQUA + "Broadcast can also be used in Console" + "\n"
	    			+ ChatColor.GOLD + line);	
	    		} else {
	    			sender.sendMessage(noperm);
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
