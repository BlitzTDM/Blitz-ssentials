package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class Help implements CommandExecutor {
		
	public String line = "------------------------------------";
	public String line2 = "-----------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss ";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
		private BlitzssentialsMain plugin;
		
		public Help(BlitzssentialsMain plugin) {
			this.plugin = plugin;
			plugin.getCommand("BZssHelp").setExecutor(this);
			
		}
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	if (sender instanceof Player) {
	    		String helpmenu1 = ChatColor.DARK_AQUA + "- " + ChatColor.AQUA;
	    		sender.sendMessage(""
	    		+ ChatColor.GOLD + line + "\n"
	    		+ pluginprefix2 + "Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    		+ ChatColor.AQUA + "/Help " + helpmenu1 + "Shows this Menu." + "\n"
	    		+ ChatColor.GOLD + line);
	    		if (sender.hasPermission("BlitzSsentials.adminhelp")) {
	    			sender.sendMessage(""
	    			+ pluginprefix2 + "Admin Help Menu!" + ChatColor.DARK_AQUA + "\n"
	    			+ ChatColor.AQUA + "/gmc or /gc " + helpmenu1 + "Put's you in Creative Mode" + "\n"
	    			+ ChatColor.AQUA + "/gms or /gs " + helpmenu1 + "Put's you in Survival Mode" + "\n"
	    			+ ChatColor.AQUA + "/gmsp or /gsp " + helpmenu1 + "Put's you in Spectator Mode" + "\n"
	    			+ ChatColor.AQUA + "/gma or /ga " + helpmenu1 + "Put's you in Adventure Mode" + "\n"
	    			+ ChatColor.GOLD + line);	
	    		}
	    	} else {
	        	Bukkit.getConsoleSender().sendMessage(pluginprefix + ChatColor.RED + "No Help Menu in Console");
	    	}
			return false;
	    }
}
