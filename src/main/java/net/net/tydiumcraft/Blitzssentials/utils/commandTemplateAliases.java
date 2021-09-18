package net.tydiumcraft.Blitzssentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class commandTemplateAliases implements CommandExecutor {
	
	public String line = "------------------------------------";
	public String line2 = "-----------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss ";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
	
    private BlitzssentialsMain plugin;
	public commandTemplateAliases(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("test").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.test")) {
    			if (label.equalsIgnoreCase("gm")) {
    				
    				//aliases
    				if (args[0].equalsIgnoreCase("alias1")) {
    					
    				} else if (args[0].equalsIgnoreCase("alias2")) {

    				} else if (args[0].equalsIgnoreCase("alias3")) {
    					
    				}
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
