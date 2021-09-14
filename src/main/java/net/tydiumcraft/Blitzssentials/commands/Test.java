package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;


@SuppressWarnings("unused")
public class test implements CommandExecutor {
	
	private static final String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
	private static final String bzssprefix = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss";
	private static final String noperm = ChatColor.RED + "No Permission";
	private BlitzssentialsMain plugin;
	
	public test(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("test").setExecutor(this);
	

	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    	sender.sendMessage(pluginprefix + ChatColor.GREEN + "Test Command Successful (" + bzssprefix + ChatColor.GREEN + ")");
    	
    	
    	return false;
    	}
    	if (!(sender instanceof Player)) {
    	sender.sendMessage(pluginprefix + ChatColor.GREEN + "Test Command Successful (" + bzssprefix + ChatColor.GREEN + ")");
    	
    	
    	return false;
    	}
		Player p = (Player) sender;
		
		if (p.hasPermission("TydiumCraft.BlitzTDM.test")) {
		
    	return true;
		} else {
			p.sendMessage(ChatColor.RED + "No Permission");
			p.sendMessage(noperm);
		}
		
		
		return false;
    }
	
}
