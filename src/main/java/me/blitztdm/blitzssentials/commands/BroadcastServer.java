package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;

@SuppressWarnings("unused")
public class BroadcastServer implements TabExecutor {
	
    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public BroadcastServer(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("broadcast").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender.hasPermission("BlitzSsentials.broadcast.server") || !(sender instanceof Player)) {
    		StringBuilder message = new StringBuilder();

    		for (int i = 0; i < args.length; i++) {
    			message.append(args[i]).append(" ");
    		}
    			
    		String bcmessage = message.toString().trim();
    			
    		bcmessage = ChatColor.translateAlternateColorCodes('&', bcmessage);
    			
    		if (config.getBoolean("broadcast.bc-server.enable-prefix")) {
    			String bcprefix = config.getString("broadcast.bc-server.prefix");
    			bcprefix = ChatColor.translateAlternateColorCodes('&', bcprefix);
    			bcprefix = ChatColor.translateAlternateColorCodes('�', bcprefix);

        		Bukkit.getServer().broadcastMessage(bcprefix + bcmessage);
    		} else {
    			Bukkit.getServer().broadcastMessage(bcmessage);
    		}
    		
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> bc = new ArrayList<>();
		
		bc.add("<message>");
		
		return bc;
	}
}
