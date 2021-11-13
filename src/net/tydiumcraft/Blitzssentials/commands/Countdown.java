package net.tydiumcraft.Blitzssentials.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class Countdown implements TabExecutor {
	
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
	FileConfiguration config = plugin.getConfig();
	
    @SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (cmd.getName().equalsIgnoreCase("countdown")) {
    			if (sender.hasPermission("BlitzSsentials.countdown") || !(sender instanceof Player)) {
    				if (args.length == 1) {
    					int countdownI = Integer.parseInt(args[0]);
    			        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    					scheduler.scheduleAsyncRepeatingTask(plugin, new Runnable() {
			            	int i = countdownI;
    			            public void run() {
    			                if (config.getBoolean("countdown.personal.enable-prefix") && i >= 0) {
        							String prefix = config.getString("countdown.personal.prefix");
        			    			
        							prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        							prefix = ChatColor.translateAlternateColorCodes('§', prefix);
        							
        							Bukkit.getServer().broadcastMessage(prefix + i);
        						} else if (i >= 0) {
        							sender.sendMessage(String.valueOf(i));
        						}
        						if (i == 0) {
        							String end = config.getString("countdown.personal.end-message");
        			    			
        							end = ChatColor.translateAlternateColorCodes('&', end);
        							end = ChatColor.translateAlternateColorCodes('§', end);
        							
        							sender.sendMessage(end);
        						}
        						i--;
    			                }
    			            }, 0, 20);
    				} else {
    					sender.sendMessage(lessargs + "No countdown Number");
    				}
    			} else {
        			sender.sendMessage(noperm);
        		}
    		} else if (cmd.getName().equalsIgnoreCase("bccountdown")) {
    			if (sender.hasPermission("BlitzSsentials.broadcast.countdown") || !(sender instanceof Player)) {
    				if (args.length == 1) {
    					int countdownI = Integer.parseInt(args[0]);
    			        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    					scheduler.scheduleAsyncRepeatingTask(plugin, new Runnable() {
			            	int i = countdownI;
    			            public void run() {
    			                if (config.getBoolean("countdown.bc.enable-prefix") && i >= 0) {
        							String prefix = config.getString("countdown.bc.prefix");
        			    			
        							prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        							prefix = ChatColor.translateAlternateColorCodes('§', prefix);
        							
        							Bukkit.getServer().broadcastMessage(prefix + i);
        						} else if (i >= 0) {
        							Bukkit.getServer().broadcastMessage(String.valueOf(i));
        						}
        						if (i == 0) {
        							String end = config.getString("countdown.bc.end-message");
        			    			
        							end = ChatColor.translateAlternateColorCodes('&', end);
        							end = ChatColor.translateAlternateColorCodes('§', end);
        							
        							Bukkit.getServer().broadcastMessage(end);
        						}
        						i--;
    			                }
    			            }, 0, 20);
    				} else {
    					sender.sendMessage(lessargs + "No countdown Number");
    				}
    			} else {
        			sender.sendMessage(noperm);
        		}
    		}
		return false;
    }

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> countdown = new ArrayList<>();
		if (args.length == 1) {
			countdown.add("<countdown>");
		}
		return countdown;
	}
}
