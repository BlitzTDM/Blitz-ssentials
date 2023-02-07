package me.blitztdm.blitzssentials.utils;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class shortcutTags implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config;
    public shortcutTags(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        setPrefixAddon(plugin);
    }

	//Plugin Prefix's
    public static String defaultpluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
	public static String pluginprefix;
    public static String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public static String bzssprefix = ChatColor.BLUE + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss" + ChatColor.BLUE + "] ";
    public static String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.AQUA + "Ss ";

    public static void setPrefixAddon(JavaPlugin plugin) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("prefix-addon.enable-addon")) {
            pluginprefix = ChatColor.AQUA + "[" + ChatColor.translateAlternateColorCodes('&', config.getString("prefix-addon.prefix")) + " " + pluginprefix2.trim() + ChatColor.AQUA + "] ";
        } else {
            pluginprefix = defaultpluginprefix;
        }
    }
	
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
    
    public static String configversionS = "000400";
    public static int configversionI = 000400;

    public static String pluginversion = "V0.4.0Beta";
    
    public static String pluginversionreal = "V0.4.0Beta";
    
    public static String lastpluginversion = "V0.3.0";
    public static String lastpluginversionquick = "VersionPlaceholder";
}
