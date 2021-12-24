package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.lessargs;
import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;

@SuppressWarnings("unused")
public class Countdown implements TabExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (cmd.getName().equalsIgnoreCase("countdown")) {
    			if (sender.hasPermission("BlitzSsentials.countdown") || !(sender instanceof Player)) {
    				if (args.length == 1) {
    					int countdownI = Integer.parseInt(args[0]);
    					new BukkitRunnable() {
			            	int i = countdownI;
			            	@Override
    			            public void run() {
    			                if (config.getBoolean("countdown.personal.enable-prefix") && i >= 0) {
        							String prefix = config.getString("countdown.personal.prefix");
        			    			
        							prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        							prefix = ChatColor.translateAlternateColorCodes('�', prefix);
        							
        							sender.sendMessage(prefix + i);
        						} else if (i >= 0) {
        							sender.sendMessage(String.valueOf(i));
        						}
        						if (i == 0) {
        							String end = config.getString("countdown.personal.end-message");
        			    			
        							end = ChatColor.translateAlternateColorCodes('&', end);
        							end = ChatColor.translateAlternateColorCodes('�', end);
        							
        							sender.sendMessage(end);
        							cancel();
        						}
        						if (args[0].equalsIgnoreCase("cancel")) {
        							cancel();
        						}
        						i--;
    			                }
    			            }.runTaskTimer(plugin, 0, 20);
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
    					new BukkitRunnable() {
			            	int i = countdownI;
			            	@Override
    			            public void run() {
    			                if (config.getBoolean("countdown.bc.enable-prefix") && i >= 0) {
        							String prefix = config.getString("countdown.bc.prefix");
        			    			
        							prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        							prefix = ChatColor.translateAlternateColorCodes('�', prefix);
        							
        							Bukkit.getServer().broadcastMessage(prefix + i);
        						} else if (i >= 0) {
        							Bukkit.getServer().broadcastMessage(String.valueOf(i));
        						}
        						if (i == 0) {
        							String end = config.getString("countdown.bc.end-message");
        			    			
        							end = ChatColor.translateAlternateColorCodes('&', end);
        							end = ChatColor.translateAlternateColorCodes('�', end);
        							
        							Bukkit.getServer().broadcastMessage(end);
        							cancel();
        						}
        						if (args[0].equalsIgnoreCase("cancel")) {
        							cancel();
        						}
        						i--;
    			                }
    			            }.runTaskTimer(plugin, 0, 20);
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
			countdown.add("cancel");
		}
		return countdown;
	}
}
