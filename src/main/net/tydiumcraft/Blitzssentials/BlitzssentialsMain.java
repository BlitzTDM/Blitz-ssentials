
package net.tydiumcraft.Blitzssentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.Blitzssentials.utils.ChatColors;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;
import net.tydiumcraft.Blitzssentials.commands.Feed;
import net.tydiumcraft.Blitzssentials.commands.Fly;
import net.tydiumcraft.Blitzssentials.commands.GamemodeA;
import net.tydiumcraft.Blitzssentials.commands.GamemodeC;
import net.tydiumcraft.Blitzssentials.commands.GamemodeS;
import net.tydiumcraft.Blitzssentials.commands.GamemodeSP;
import net.tydiumcraft.Blitzssentials.commands.Heal;
import net.tydiumcraft.Blitzssentials.commands.Help;
import net.tydiumcraft.Blitzssentials.commands.HelpGamemode;
import net.tydiumcraft.Blitzssentials.commands.HelpPlugin;
import net.tydiumcraft.Blitzssentials.commands.HelpTime;
import net.tydiumcraft.Blitzssentials.commands.HelpWeather;
import net.tydiumcraft.Blitzssentials.commands.MassSummon;
import net.tydiumcraft.Blitzssentials.commands.PluginInfo;
import net.tydiumcraft.Blitzssentials.commands.PluginReloadConfig;
import net.tydiumcraft.Blitzssentials.commands.PluginReloadPlugin;
import net.tydiumcraft.Blitzssentials.commands.Test;
import net.tydiumcraft.Blitzssentials.commands.Time;
import net.tydiumcraft.Blitzssentials.commands.TimeDay;
import net.tydiumcraft.Blitzssentials.commands.TimeMidnight;
import net.tydiumcraft.Blitzssentials.commands.TimeNight;
import net.tydiumcraft.Blitzssentials.commands.TimeNoon;
import net.tydiumcraft.Blitzssentials.commands.Weather;
import net.tydiumcraft.Blitzssentials.commands.WeatherClear;
import net.tydiumcraft.Blitzssentials.commands.WeatherRain;
import net.tydiumcraft.Blitzssentials.commands.WeatherThunder;
import net.tydiumcraft.Blitzssentials.events.checkVersion;
import net.tydiumcraft.Blitzssentials.events.onJoin;

@SuppressWarnings("unused")
public class BlitzssentialsMain extends JavaPlugin {
	
	String line = shortcutTags.line;
	String line2 = shortcutTags.line2;
	String pluginprefix = shortcutTags.pluginprefix;
	String pluginprefix2 = shortcutTags.pluginprefix2;
	String bzssprefix = shortcutTags.bzssprefix;
	String bzssprefix2 = shortcutTags.bzssprefix2;
	String noperm = shortcutTags.noperm;
	String console = shortcutTags.console;
    String pluginversion = shortcutTags.pluginversion;
    String defaultpluginprefix = shortcutTags.defaultpluginprefix;
   
	@Override
	public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage(""
    			+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
				+ defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.GREEN + "|Plugin Enabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);

    	//Config
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
    	
    	//Events/Utils
    	getServer().getPluginManager().registerEvents(new ChatColors(), this);
    	getServer().getPluginManager().registerEvents(new onJoin(), this);
    	
    	//checkVersion
    	String PluginUpdated = checkVersion.PluginUpdated;
    	String PluginOutdated = checkVersion.PluginOutdated;
    	String PluginError = checkVersion.VersionCheckError;
    	new checkVersion(this).getVersion(version -> {
            if (pluginversion.equalsIgnoreCase(version)) {
            	Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else {
            	Bukkit.getConsoleSender().sendMessage(PluginOutdated);
            }});

    	//Commands
    	new Help(this);
    	new HelpPlugin(this);
    	new HelpGamemode(this);
    	new HelpWeather(this);
    	new HelpTime(this);
    	
		new Test(this);
		new PluginReloadPlugin(this);
		new PluginReloadConfig(this);
		new PluginInfo(this);
		
		new MassSummon(this);
		
		new Feed(this);
		new Heal(this);
		new Fly(this);
		
		new GamemodeC(this);
		new GamemodeS(this);
		new GamemodeSP(this);
		new GamemodeA(this);
		
		new Time(this);
		new TimeDay(this);
		new TimeNoon(this);
		new TimeNight(this);
		new TimeMidnight(this);
		
		new Weather(this);
		new WeatherClear(this);
		new WeatherRain(this);
		new WeatherThunder(this);
	}
	
	@Override
	public void onDisable() {
    	Bukkit.getConsoleSender().sendMessage(""
    			+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
    			+ defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.RED + "|Plugin Disabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);
    	
    	saveDefaultConfig();
		
	}
}