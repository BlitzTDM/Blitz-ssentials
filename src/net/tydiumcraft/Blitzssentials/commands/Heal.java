package net.tydiumcraft.Blitzssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;

@SuppressWarnings("unused")
public class Heal implements CommandExecutor {
	
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
    String pluginversion = shortcutTags.pluginversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
    String lessargs = shortcutTags.lessargs;
    String moreargs = shortcutTags.moreargs;
	
    private BlitzssentialsMain plugin;
	public Heal(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("heal").setExecutor(this);
		
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    			if (args.length == 0 && sender.hasPermission("BlitzSsentials.heal") && sender instanceof Player) {
    				double maxHealth = ((Player) sender).getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
        			((Player) sender).setHealth(maxHealth);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Healed!");
        			
    			} else if (sender.hasPermission("BlitzSsentials.heal.other") || !(sender instanceof Player)) {
    				if (!(sender instanceof Player) && args.length == 0) {
    					sender.sendMessage(specifyplayer);
    				} else {
    				Player arg0 = Bukkit.getServer().getPlayer(args[0]);
    				if (arg0 == null) {
        				sender.sendMessage(cannotfind + args[0]);
    				} else {
    				double maxHealth = arg0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
    				arg0.setHealth(maxHealth);
        			sender.sendMessage(pluginprefix + ChatColor.GREEN + "Healed " + arg0.getDisplayName() + "!");
    				arg0.sendMessage(pluginprefix + ChatColor.GREEN + "You've Been Healed!");
    				}
    				}
    			} else if (sender.hasPermission("BlitzSsentials.heal.all") || !(sender instanceof Player)) {
    				if (args[0] == "all" || args[0] == "*") {
    					sender.sendMessage(pluginprefix + ChatColor.GREEN + "Healed Everyone!");
    				for (Player player : Bukkit.getOnlinePlayers()) {
    					double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
    					player.setHealth(maxHealth);
    					player.sendMessage(pluginprefix + ChatColor.GREEN + "You've Been Healed!");
    				}
    				} else {
    					sender.sendMessage(lessargs + "Did you mean '/Heal All'");
    				}
    			} else {
    				sender.sendMessage(noperm);
    			}
		return false;
    }
}
