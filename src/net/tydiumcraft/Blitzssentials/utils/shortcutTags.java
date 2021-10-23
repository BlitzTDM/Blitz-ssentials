package net.tydiumcraft.Blitzssentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

import net.tydiumcraft.Blitzssentials.BlitzssentialsMain;

@SuppressWarnings("unused")
public class shortcutTags implements Listener {
	
	//Plugin Prefix's
	public static String defaultpluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
	public static String pluginprefix = defaultpluginprefix;
	
	//Shortcut Tags
	public static String line = "------------------------------------";
	public static String line2 = "-----------------";
    public static String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public static String bzssprefix = ChatColor.BLUE + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss" + ChatColor.BLUE + "] ";
    public static String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss ";
    public static String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public static String lessargs = pluginprefix + ChatColor.RED + "Not Enough Arguements: ";
    public static String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
    
    public static String apiversion = "Spigot-1.17";
    
    public static String pluginversion = "V0.1.4";
    public static String lastpluginversion = "V0.1.3";
    public static String lastpluginversionquick = "VersionPlaceholder";
}
