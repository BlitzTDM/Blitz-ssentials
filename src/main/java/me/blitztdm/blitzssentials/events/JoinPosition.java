package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

public class JoinPosition implements Listener,TabExecutor {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

	public JoinPosition(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("joinpos").setExecutor(this);
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
    	Player player = event.getPlayer();
    	if (config.getBoolean("join-position.enable-join-position")) {
    		String JWorld = config.getString("join-position.world");
    		double JLocX = config.getInt("join-position.x");
    		double JLocY = config.getInt("join-position.y");
    		double JLocZ = config.getInt("join-position.z");
    		float JYaw = config.getInt("join-position.yaw");
    		float JPitch = config.getInt("join-position.pitch");
    		
    		Location JoinLoc = new Location(Bukkit.getServer().getWorld(JWorld), JLocX, JLocY, JLocZ, JYaw, JPitch);
    		
    		player.teleport(JoinLoc);
    	}
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("BlitzSsentials.joinpos") && sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("joinpos") && (args.length == 1 || args.length == 7)) {
			if (cmd.getName().equalsIgnoreCase("joinpos") && args[0].equalsIgnoreCase("set") && args.length == 1) {
				Player player = (Player) sender;
				if (args.length == 1) {
				config.set("join-position.world", player.getLocation().getWorld());
				config.set("join-position.x", player.getLocation().getX());
				config.set("join-position.y", player.getLocation().getY());
				config.set("join-position.z", player.getLocation().getZ());
				config.set("join-position.pitch", player.getLocation().getPitch());
				config.set("join-position.yaw", player.getLocation().getYaw());
		    	plugin.saveDefaultConfig();
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Set Temp Join Position:" + "\n" + ChatColor.RESET +
						ChatColor.GOLD + "World: " + ChatColor.DARK_GREEN + player.getLocation().getWorld().getName() + "\n" + ChatColor.RESET +
		    	ChatColor.GOLD + "Coords: " + ChatColor.DARK_GREEN + player.getLocation().getX() + 
		    	", " + player.getLocation().getY() + 
		    	", " + player.getLocation().getZ() + "\n" + ChatColor.RESET +
		    	ChatColor.GOLD + "Pitch: " + ChatColor.DARK_GREEN + player.getLocation().getPitch() + "\n" + ChatColor.RESET +
		    	ChatColor.GOLD + "Yaw: " + ChatColor.DARK_GREEN + player.getLocation().getYaw() + "\n" + ChatColor.RESET +
		    	ChatColor.RED + "Set Permanently by Changing Config" + "\n" + ChatColor.RESET +
		    	ChatColor.GOLD + line);
				} else {
					sender.sendMessage(lessargs + "Did you mean '/JoinPos set <world> <x> <y> <z> <pitch> <yaw>' or '/JoinPos set'");
				}
				
			} else if (cmd.getName().equalsIgnoreCase("joinpos") && args[0].equalsIgnoreCase("go") && args.length == 1) {
				Player player = (Player) sender;
				String JWorld = config.getString("join-position.world");
	    		double JLocX = config.getInt("join-position.x");
	    		double JLocY = config.getInt("join-position.y");
	    		double JLocZ = config.getInt("join-position.z");
	    		float JYaw = config.getInt("join-position.yaw");
	    		float JPitch = config.getInt("join-position.pitch");
	    		
	    		player.sendMessage(pluginprefix + "Tested join-position: Success");
	    	
	    		Location JoinLoc = new Location(Bukkit.getServer().getWorld(JWorld), JLocX, JLocY, JLocZ, JYaw, JPitch);
	    		
				player.teleport(JoinLoc);
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Teleported to (Temp or Perm) Join Position:" + "\n" +
						ChatColor.GOLD + "World: " + ChatColor.DARK_GREEN + player.getLocation().getWorld().getName() + "\n" +
						ChatColor.GOLD + "Coords: " + ChatColor.DARK_GREEN + player.getLocation().getX() + 
				    	", " + player.getLocation().getY() + 
				    	", " + player.getLocation().getZ() + "\n" +
				    	ChatColor.GOLD + "Pitch: " + ChatColor.DARK_GREEN + player.getLocation().getPitch() + "\n" +
				    	ChatColor.GOLD + "Yaw: " + ChatColor.DARK_GREEN + player.getLocation().getYaw());
				
			} else if (cmd.getName().equalsIgnoreCase("joinpos") && args.length == 7) {
				if (sender instanceof Player) {
				String Wa = args[1];
				double Xa = Double.parseDouble(args[2]);
				double Ya = Double.parseDouble(args[3]);
				double Za = Double.parseDouble(args[4]);
				float PITCHa = Float.parseFloat(args[5]);
				float YAWa = Float.parseFloat(args[6]);

				config.set("join-position.world", Wa);
				config.set("join-position.x", Xa);
				config.set("join-position.y", Ya);
				config.set("join-position.z", Za);
				config.set("join-position.pitch", PITCHa);
				config.set("join-position.yaw", YAWa);
		    	plugin.saveDefaultConfig();
		    	
				sender.sendMessage(pluginprefix + ChatColor.GREEN + "Set Temp Join Position:" + "\n" +
						ChatColor.GOLD + "World: " + ChatColor.DARK_GREEN + Wa + "\n" +
		    	ChatColor.GOLD + "Coords: " + ChatColor.DARK_GREEN + Xa + 
		    	", " + Ya + 
		    	", " + Za + "\n" +
		    	ChatColor.GOLD + "Pitch: " + ChatColor.DARK_GREEN + PITCHa + "\n" +
		    	ChatColor.GOLD + "Yaw: " + ChatColor.DARK_GREEN + YAWa + "\n" +
		    	ChatColor.RED + "Set Permanently by Changing Config");
				}
				} else {
					sender.sendMessage(lessargs + "Did you mean '/JoinPos set <world> <x> <y> <z> <pitch> <yaw>'");
				}
			} else if (cmd.getName().equalsIgnoreCase("joinpos") && args.length >= 7) {
				sender.sendMessage(moreargs + "/JoinPos set <world> <x> <y> <z> <pitch> <yaw>");
			} else if (cmd.getName().equalsIgnoreCase("joinpos") && args.length >= 0) {
				sender.sendMessage(lessargs + "'/JoinPos set <world> <x> <y> <z> <pitch> <yaw>' or '/JoinPos go'");
			}
			} else if (cmd.getName().equalsIgnoreCase("joinpos") && args.length <= 6 && !(sender instanceof Player)) {
				if (args.length == 6) {
				String Wb = args[0];
				double Xb = Double.parseDouble(args[1]);
				double Yb = Double.parseDouble(args[2]);
				double Zb = Double.parseDouble(args[3]);
				float PITCHb = Float.parseFloat(args[4]);
				float YAWb = Float.parseFloat(args[5]);

				config.set("join-position.world", Wb);
				config.set("join-position.x", Xb);
				config.set("join-position.y", Yb);
				config.set("join-position.z", Zb);
				config.set("join-position.pitch", PITCHb);
				config.set("join-position.yaw", YAWb);
		    	plugin.saveDefaultConfig();
		    	
		    	sender.sendMessage(pluginprefix + ChatColor.GREEN + "Set Temp Join Position:" + "\n" +
						ChatColor.GOLD + "World: " + ChatColor.DARK_GREEN + Wb + "\n" +
		    	ChatColor.GOLD + "Coords: " + ChatColor.DARK_GREEN + Xb + 
		    	", " + Yb + 
		    	", " + Zb + "\n" +
		    	ChatColor.GOLD + "Pitch: " + ChatColor.DARK_GREEN + PITCHb + "\n" +
		    	ChatColor.GOLD + "Yaw: " + ChatColor.DARK_GREEN + YAWb + "\n" +
		    	ChatColor.RED + "Set Permanently by Changing Config");
				} else {
					sender.sendMessage(lessargs + "Did you mean '/JoinPos <world> <x> <y> <z> <pitch> <yaw>'");
				} 
			} else {
				sender.sendMessage(noperm);
			}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> joinpos = new ArrayList<>();

		if (args[0].equalsIgnoreCase("set") && args.length == 2 || args.length == 1) {
			if (args.length == 1) {
				joinpos.add("set");
				joinpos.add("go");
			}
			joinpos.add("<world> <x> <y> <z> <pitch> <yaw>");
			for (World world : Bukkit.getServer().getWorlds()) {
				joinpos.add(world.getName());
			}
			
		} else if (args[0].equalsIgnoreCase("set") && args.length == 3 || args.length == 2 && !args[0].equalsIgnoreCase("go")) {
			joinpos.add("<x> <y> <z> <pitch> <yaw>");
			if (sender instanceof Player) {
				Player player = (Player) sender;
			joinpos.add(String.valueOf(player.getLocation().getX()));
			}
			
		} else if (args[0].equalsIgnoreCase("set") && args.length == 4 || args.length == 3 && !args[0].equalsIgnoreCase("go")) {
			joinpos.add("<y> <z> <pitch> <yaw>");
			if (sender instanceof Player) {
				Player player = (Player) sender;
			joinpos.add(String.valueOf(player.getLocation().getY()));
			}
			
		} else if (args[0].equalsIgnoreCase("set") && args.length == 5 || args.length == 4 && !args[0].equalsIgnoreCase("go")) {
			joinpos.add("<z> <pitch> <yaw>");
			if (sender instanceof Player) {
				Player player = (Player) sender;
			joinpos.add(String.valueOf(player.getLocation().getZ()));
			}
			
		} else if (args[0].equalsIgnoreCase("set") && args.length == 6 || args.length == 5 && !args[0].equalsIgnoreCase("go")) {
			joinpos.add("<pitch> <yaw>");
			if (sender instanceof Player) {
				Player player = (Player) sender;
			joinpos.add(String.valueOf(player.getLocation().getPitch()));
			}
			
		} else if (args[0].equalsIgnoreCase("set") && args.length == 7 || args.length == 6 && !args[0].equalsIgnoreCase("go")) {
			joinpos.add("<yaw>");
			if (sender instanceof Player) {
				Player player = (Player) sender;
			joinpos.add(String.valueOf(player.getLocation().getYaw()));
			}
		}
		
		return joinpos;
	}
}
