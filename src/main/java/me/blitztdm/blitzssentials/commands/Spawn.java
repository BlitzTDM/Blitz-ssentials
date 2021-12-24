package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class Spawn implements CommandExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public Spawn(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawn").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
			Player player = (Player) sender;
    		if (sender.hasPermission("BlitzSsentials.spawn")) {
    			if (config.getBoolean("join-position.enable-join-position")) {
    			String JWorld = config.getString("join-position.world");
	    		double JLocX = config.getInt("join-position.x");
	    		double JLocY = config.getInt("join-position.y");
	    		double JLocZ = config.getInt("join-position.z");
	    		float JYaw = config.getInt("join-position.yaw");
	    		float JPitch = config.getInt("join-position.pitch");
	    	
	    		Location JoinLoc = new Location(Bukkit.getServer().getWorld(JWorld), JLocX, JLocY, JLocZ, JYaw, JPitch);

				player.teleport(JoinLoc);
    			sender.sendMessage(pluginprefix + ChatColor.GREEN + "You have been Teleported to Spawn");
    			} else {
    				sender.sendMessage(ChatColor.RED + "Command is Curremtly Disabled, if you think this is an Error, Please Contact an Administrator");
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
