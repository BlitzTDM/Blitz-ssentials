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
public class KillAll implements CommandExecutor {
	
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
    String moreargs = shortcutTags.moreargs;
    String lessargs = shortcutTags.lessargs;
    String pluginversion = shortcutTags.pluginversion;
    String lastpluginversion = shortcutTags.lastpluginversion;
    String lastpluginversionquick = shortcutTags.lastpluginversionquick;
    String apiversion = shortcutTags.apiversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    String configversionS = shortcutTags.configversionS;
    int configversionI = shortcutTags.configversionI;
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	public KillAll(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("killall").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.kill.all")) {
    			for (Player player : Bukkit.getOnlinePlayers()) {
    				if (player.hasPermission("BlitzSsentials.kill.all.avoid")) {
    					player.sendMessage(pluginprefix + ChatColor.GREEN + "You have avoided from getting Killed");
    				} else {
    					player.setHealth(0);
    					player.sendMessage(ChatColor.RED + "You Have Been Killed");
    				}
    			}
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Killed all Players");
    		} else {
    			sender.sendMessage(noperm);
    	}
		return false;
    }
}
