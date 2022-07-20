package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.blitztdm.blitzssentials.utils.shortcutTags.line;
import static me.blitztdm.blitzssentials.utils.shortcutTags.noperm;

@SuppressWarnings("unused")
public class PluginTestLeave implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();
	public PluginTestLeave(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("TestLeave").setExecutor(this);
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		if (sender.hasPermission("BlitzSsentials.test") || !(sender instanceof Player)) {
    			
    			FileConfiguration config = plugin.getConfig();
    			
    			String leavemessage = config.getString("leave-message.leave.leave-message");
    		    leavemessage = ChatColor.translateAlternateColorCodes('&', leavemessage);
    		    leavemessage = leavemessage.replace("%player%", sender.getName());
    		    leavemessage = leavemessage.replace("%playerfull%", ((Player) sender).getDisplayName());
    		    leavemessage = leavemessage.replace("%line%", line);
    		    
    		    sender.sendMessage(leavemessage);
    		} else {
    			sender.sendMessage(noperm);
    		}
		return false;
    }
}
