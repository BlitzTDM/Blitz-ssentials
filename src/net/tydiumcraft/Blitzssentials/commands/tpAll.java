package net.tydiumcraft.Blitzssentials.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.collect.Maps;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class tpAll implements CommandExecutor {
	
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
	public tpAll(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("tpall").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.tpall") || !(sender instanceof Player)) {
    			if (args.length == 0 && sender instanceof Player) {
    			for (Player player : Bukkit.getOnlinePlayers()) {
    				player.teleport(((Player) sender).getLocation());
    			}
    			} else if (args.length == 1) {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 != null) {
    					for (Player player : Bukkit.getOnlinePlayers()) {
    	    				player.teleport(arg0.getLocation());
    	    			}
    				} else {
    	    			sender.sendMessage(cannotfind + args[0]);
    				}
    			} else if (!(sender instanceof Player)) {
    				sender.sendMessage(specifyplayer);
    			}
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
