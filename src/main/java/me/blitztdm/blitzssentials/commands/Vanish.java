package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class Vanish implements TabExecutor,Listener {
    
    public static ArrayList<Player> vanished = new ArrayList<Player>();
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    
	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
    		Player player = (Player) sender;

    	    String leavemessage = config.getString("leave-message.leave.leave-message");
    	    leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
    	    leavemessage = ChatColor.translateAlternateColorCodes('�', leavemessage);
    	    leavemessage = leavemessage.replace("%player%", player.getName());
    	    leavemessage = leavemessage.replace("%playerfull%", player.getDisplayName());
    	    leavemessage = leavemessage.replace("%line%", line);
    	    
    	    String globalmessage = config.getString("join-message.global.global-message");
    	    globalmessage = ChatColor.translateAlternateColorCodes('&', globalmessage);
    	    globalmessage = ChatColor.translateAlternateColorCodes('�', globalmessage);
    	    globalmessage = globalmessage.replace("%player%", player.getName());
    	    globalmessage = globalmessage.replace("%playerfull%", player.getDisplayName());
    	    globalmessage = globalmessage.replace("%line%", line);
    	    
    		//Vanish Command
    		if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
    		if (sender.hasPermission("BlitzSsentials.vanish")) {
    			if (!vanished.contains(player)) {
    				for (Player online : Bukkit.getOnlinePlayers()) {
    					online.hidePlayer(player);
    				}
        		sender.sendMessage(pluginprefix + ChatColor.GREEN + "You are now Vanished");
    			vanished.add(player);
    			((Player) sender).setCollidable(false);
    			((Player) sender).setCanPickupItems(false);
    			((Player) sender).setInvulnerable(true);
    			((Player) sender).setFlying(true);
    			
    			if (args.length == 1) {
    				if (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide")) {
    					sender.sendMessage(pluginprefix + ChatColor.RED + "Didn't send leave Message");
    				} else {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
    				    	if (config.getBoolean("leave-message.leave.enable-leave-message")) {
    				    		Bukkit.broadcastMessage(leavemessage);
    				    	} else {
    				    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " left the game");
    				    	}
    				}
    			} else {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
    				if (config.getBoolean("leave-message.leave.enable-leave-message")) {
			    		Bukkit.broadcastMessage(leavemessage);
			    	} else {
			    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " left the game");
			    	}
    			}
    			
    			} else {
					sender.sendMessage(pluginprefix + ChatColor.YELLOW + "You are already Vanished");
				}
    		} else {
    			sender.sendMessage(noperm);
    		}

        	return true;
        	
    		//Unvanish Command
    		} else if (cmd.getName().equalsIgnoreCase("unvanish") || cmd.getName().equalsIgnoreCase("uv")) {
        		if (sender.hasPermission("BlitzSsentials.vanish")) {
        			if (vanished.contains(player)) {
				for (Player online : Bukkit.getServer().getOnlinePlayers()) {
					online.showPlayer(player);
				}
				sender.sendMessage(pluginprefix + ChatColor.RED + "You are no longer Vanished");
				vanished.remove(player);
				((Player) sender).setCollidable(true);
    			((Player) sender).setCanPickupItems(true);
    			((Player) sender).setInvulnerable(false);
    			((Player) sender).setFlying(false);
				
				if (args.length == 1) {
    				if (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide")) {
    					sender.sendMessage(pluginprefix + ChatColor.RED + "Didn't send join Message");
    				} else {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
    				    	if (config.getBoolean("join-message.global.enable-global")) {
    				    		Bukkit.broadcastMessage(globalmessage);
    				    	} else {
    				    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " joined the game");
    				    	}
    				}
    			} else {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent join Message");
    				if (config.getBoolean("join-message.global.enable-global")) {
			    		Bukkit.broadcastMessage(globalmessage);
			    	} else {
			    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " joined the game");
			    	}
    			}
				
				} else {
					sender.sendMessage(pluginprefix + ChatColor.YELLOW + "You are already Unvanished");
				}
			} else {
	    		Bukkit.getConsoleSender().sendMessage(noperm);
    		}
            return true;
            
        //Toggle Vanish Command
    	} else if (cmd.getName().equalsIgnoreCase("togglevanish") || cmd.getName().equalsIgnoreCase("tv")) {
    		if (sender.hasPermission("BlitzSsentials.vanish")) {
    			if (!vanished.contains(player)) {
    				for (Player online : Bukkit.getOnlinePlayers()) {
    					online.hidePlayer(player);
    				}
        		sender.sendMessage(pluginprefix + ChatColor.GREEN + "You are now Vanished");
    			vanished.add(player);
    			((Player) sender).setCollidable(false);
    			((Player) sender).setCanPickupItems(false);
    			((Player) sender).setInvulnerable(true);
    			((Player) sender).setFlying(true);
    			
    			if (args.length == 1) {
    				if (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide")) {
    					sender.sendMessage(pluginprefix + ChatColor.RED + "Didn't send leave Message");
    				} else {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
    				    	if (config.getBoolean("leave-message.leave.enable-leave-message")) {
    				    		Bukkit.broadcastMessage(leavemessage);
    				    	} else {
    				    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " left the game");
    				    	}
    				}
    			} else {
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
    				if (config.getBoolean("leave-message.leave.enable-leave-message")) {
			    		Bukkit.broadcastMessage(leavemessage);
			    	} else {
			    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " left the game");
			    	}
    			}
    			
    			} else if (vanished.contains(player)) {
    				for (Player online : Bukkit.getServer().getOnlinePlayers()) {
    					online.showPlayer(player);
    				}
    				sender.sendMessage(pluginprefix + ChatColor.RED + "You are no longer Vanished");
    				vanished.remove(player);
    				((Player) sender).setCollidable(true);
        			((Player) sender).setCanPickupItems(true);
        			((Player) sender).setInvulnerable(false);
        			((Player) sender).setFlying(false);
    				
    				if (args.length == 1) {
        				if (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide")) {
        					sender.sendMessage(pluginprefix + ChatColor.RED + "Didn't send join Message");
        				} else {
        					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent leave Message");
        				    	if (config.getBoolean("join-message.global.enable-global")) {
        				    		Bukkit.broadcastMessage(globalmessage);
        				    	} else {
        				    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " joined the game");
        				    	}
        				}
        			} else {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Sent join Message");
        				if (config.getBoolean("join-message.global.enable-global")) {
    			    		Bukkit.broadcastMessage(globalmessage);
    			    	} else {
    			    		Bukkit.broadcastMessage(ChatColor.YELLOW + sender.getName() + " joined the game");
    			    	}
        			}
    				
    				}
    		} else {
    			sender.sendMessage(noperm);
    		}
    		}

        	return true;
    	} else {
    		sender.sendMessage(console);
    	}
    	return true;
    }
    
    @EventHandler
    @SuppressWarnings("deprecation")
    public void onJoin(PlayerJoinEvent event) {
    	for (Player player : vanished) {
    		event.getPlayer().hidePlayer(player);
    	}
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
    	if (vanished.contains(event.getPlayer())) {
    	event.setQuitMessage(null);
    	vanished.remove(event.getPlayer());
    	event.getPlayer().setCollidable(true);
    	event.getPlayer().setCanPickupItems(true);
    	event.getPlayer().setInvulnerable(false);
    	event.getPlayer().setFlying(false);
    	}
    }

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> vanish = new ArrayList<>();
		if (args.length == 1) {
			vanish.add("f");
			vanish.add("false");
			vanish.add("h");
			vanish.add("hide");
		}
		return vanish;
	}
}