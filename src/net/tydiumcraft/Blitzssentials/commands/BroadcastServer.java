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

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class BroadcastServer implements TabExecutor {
	
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
	public BroadcastServer(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("broadcast").setExecutor(this);
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.broadcast.server") || !(sender instanceof Player)) {
    			StringBuilder message = new StringBuilder();

    			for (var i = 0; i < args.length; i++) {
    				message.append(args[i]).append(" ");
    			}
    			
    			String bcmessage = message.toString().trim();
    			
    			bcmessage = ChatColor.translateAlternateColorCodes('&', bcmessage);
    			bcmessage = ChatColor.translateAlternateColorCodes('§', bcmessage);
    			
    			if (config.getBoolean("broadcast.bc-server.enable-prefix")) {
    				String bcprefix = config.getString("broadcast.prefix");
    				bcprefix = ChatColor.translateAlternateColorCodes('&', bcprefix);
    				bcprefix = ChatColor.translateAlternateColorCodes('§', bcprefix);

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
