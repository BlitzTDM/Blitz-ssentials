package me.blitztdm.blitzssentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

@SuppressWarnings("unused")
public class shortcutTags implements Listener {

	//Plugin Prefix's
	public static String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public static String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public static String bzssprefix = ChatColor.BLUE + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss" + ChatColor.BLUE + "] ";
    public static String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss ";

    public static String defaultpluginprefix = pluginprefix;
	
	//Shortcut Tags
	public static String line = "------------------------------------";
	public static String line2 = "-----------------";
    public static String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public static String lessargs = pluginprefix + ChatColor.RED + "Not Enough Arguements: ";
    public static String moreargs = pluginprefix + ChatColor.RED + "Too Many Arguements: ";
    public static String console = pluginprefix + ChatColor.RED + "Not a Console CMD ";
    public static String cannotfind = pluginprefix + ChatColor.RED + "Cannot find ";
    public static String specifyplayer = pluginprefix + ChatColor.RED + "Specify Player";
    
    public static String apiversion = "Spigot-1.17";
    
    public static String configversionS = "000300";
    public static int configversionI = 000300;

    public static String pluginversion = "V0.3.0";
    
    public static String pluginversionreal = "V0.3.0";
    
    public static String lastpluginversion = "V0.2.2";
    public static String lastpluginversionquick = "VersionPlaceholder";
}
