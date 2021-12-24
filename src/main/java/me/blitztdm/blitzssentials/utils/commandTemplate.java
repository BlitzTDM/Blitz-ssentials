package me.blitztdm.blitzssentials.utils;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class commandTemplate implements CommandExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public commandTemplate(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("test").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player) {
			Player player = (Player) sender;
    		if (sender.hasPermission("BlitzSsentials.test")) {
    			//Command Execution Here
    			sender.sendMessage();
    		} else {
    			sender.sendMessage();
    		}
    	} else {
    		Bukkit.getConsoleSender().sendMessage();
    	}
		return false;
    }
}
