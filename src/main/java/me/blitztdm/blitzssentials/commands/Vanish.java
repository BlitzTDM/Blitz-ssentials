package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
	public Vanish(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("vanish").setExecutor(this);
		plugin.getCommand("unvanish").setExecutor(this);
		plugin.getCommand("togglevanish").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			String leavemessage = config.getString("leave-message.leave.leave-message");
			leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
			leavemessage = leavemessage.replace("%player%", player.getName());
			leavemessage = leavemessage.replace("%playerfull%", player.getDisplayName());
			leavemessage = leavemessage.replace("%line%", line);

			String globalmessage = config.getString("join-message.global.global-message");
			globalmessage = ChatColor.translateAlternateColorCodes('&', globalmessage);
			globalmessage = globalmessage.replace("%player%", player.getName());
			globalmessage = globalmessage.replace("%playerfull%", player.getDisplayName());
			globalmessage = globalmessage.replace("%line%", line);

			//Vanish Command
			if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
				setVanish(sender, args, leavemessage, globalmessage, true);

				//Unvanish Command
			} else if (cmd.getName().equalsIgnoreCase("unvanish") || cmd.getName().equalsIgnoreCase("uv")) {
				setVanish(sender, args, leavemessage, globalmessage, false);

				//Toggle Vanish Command
			} else if (cmd.getName().equalsIgnoreCase("togglevanish") || cmd.getName().equalsIgnoreCase("tv")) {
				if (sender.hasPermission("BlitzSsentials.vanish")) {
					if (!vanished.contains(player)) {
						setVanish(sender, args, leavemessage, globalmessage, true);
					} else if (vanished.contains(player)) {
						setVanish(sender, args, leavemessage, globalmessage, false);
					}
				} else {
					sender.sendMessage(noperm);
				}
			}
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

	public void setVanish(CommandSender sender, String[] args, String leavemessage, String globalmessage, Boolean beVanished) {
		if (beVanished) {
			Player player = (Player) sender;
			if (sender.hasPermission("BlitzSsentials.vanish")) {
				if (!vanished.contains(player)) {
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.hidePlayer(player);
					}
					sender.sendMessage(pluginprefix + ChatColor.GREEN + "You are now Vanished");
					vanished.add(player);
					player.setCollidable(false);
					player.setCanPickupItems(false);
					player.setInvulnerable(true);
					player.setAllowFlight(true);
					if (args.length == 1 && (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide"))) {
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
					sender.sendMessage(pluginprefix + ChatColor.YELLOW + "You are already Vanished");
				}
			} else {
				sender.sendMessage(noperm);
			}
		} else {
			if (sender.hasPermission("BlitzSsentials.vanish")) {
				Player player = (Player) sender;
				if (vanished.contains(player)) {
					for (Player online : Bukkit.getServer().getOnlinePlayers()) {
						online.showPlayer(player);
					}
					sender.sendMessage(pluginprefix + ChatColor.RED + "You are no longer Vanished");
					vanished.remove(player);
					player.setCollidable(true);
					player.setCanPickupItems(true);
					player.setInvulnerable(false);
					if (player.getGameMode() != GameMode.CREATIVE || player.getGameMode() != GameMode.SPECTATOR) {
						player.setAllowFlight(false);
					}
					if (args.length == 1 && (args[0].equalsIgnoreCase("f") || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hide"))) {
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
					sender.sendMessage(pluginprefix + ChatColor.YELLOW + "You are already Unvanished");
				}
			} else {
				Bukkit.getConsoleSender().sendMessage(noperm);
			}
		}
	}
}