package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class tpHere implements CommandExecutor {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
	String cannotfind = shortcutTags.cannotfind;
	String specifyplayer = shortcutTags.specifyplayer;
    String pluginversion = shortcutTags.pluginversion;
    String lastpluginversion = shortcutTags.lastpluginversion;
    String lastpluginversionquick = shortcutTags.lastpluginversionquick;
    String apiversion = shortcutTags.apiversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    String configversionS = shortcutTags.configversionS;
    int configversionI = shortcutTags.configversionI;
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	public tpHere(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("tphere").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		if (sender.hasPermission("BlitzSsentials.tphere")) {
    			if (args.length == 1) {
    			Player arg0 = Bukkit.getPlayer(args[0]);
    			if (arg0 == null) {
    				sender.sendMessage(cannotfind + args[0]);
    			} else if (arg0 != null) {
    				sender.sendMessage(pluginprefix + "Teleported " + arg0.getName() + " to you!");
    				arg0.sendMessage(pluginprefix + "Teleported to " + sender.getName() + "!");
    				arg0.teleport(((Player) sender).getLocation());
    			} 
    			} else {
    	    		sender.sendMessage(specifyplayer);
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
