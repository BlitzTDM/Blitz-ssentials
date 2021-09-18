package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class Test implements CommandExecutor {

	public String line = "------------------------------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD";
	private BlitzssentialsMain plugin;
	
	public Test(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("test").setExecutor(this);
	
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.test")) {
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Test Command Successful (" + bzssprefix2 + ChatColor.GREEN + ")");
    		} else {
    			sender.sendMessage(noperm);
    			}
    	} else {
    		Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.GREEN + "Test Command Successful (" + bzssprefix2 + ChatColor.GREEN + ")");
    	}
		return false;
    }
}

