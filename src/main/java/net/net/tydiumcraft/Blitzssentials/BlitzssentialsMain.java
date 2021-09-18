
package net.tydiumcraft.Blitzssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.Blitzssentials.utils.ChatColors;
import net.tydiumcraft.Blitzssentials.utils.shortcutTags;
import net.tydiumcraft.Blitzssentials.commands.Gamemode;
import net.tydiumcraft.Blitzssentials.commands.GamemodeA;
import net.tydiumcraft.Blitzssentials.commands.GamemodeC;
import net.tydiumcraft.Blitzssentials.commands.GamemodeS;
import net.tydiumcraft.Blitzssentials.commands.GamemodeSP;
import net.tydiumcraft.Blitzssentials.commands.Help;
import net.tydiumcraft.Blitzssentials.commands.ReloadConfig;
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

@SuppressWarnings("unused")
public class BlitzssentialsMain extends JavaPlugin {
	
	public String line = "------------------------------------";
    public String pluginprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BlitzSsentials" + ChatColor.AQUA + "] ";
    public String pluginprefix2 = ChatColor.DARK_AQUA + "BlitzSsentials ";
    public String bzssprefix = ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss" + ChatColor.AQUA + "] ";
    public String bzssprefix2 = ChatColor.DARK_AQUA + "BZ" + ChatColor.BLUE + "Ss";
    public String noperm = pluginprefix + ChatColor.RED + "No Permission";
    public String console = pluginprefix + ChatColor.RED + "Not a Console CMD";
    
	@Override
	public void onEnable() {
    	Bukkit.getConsoleSender().sendMessage(""
    			+ ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
				+ pluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.GREEN + "|Plugin Enabled| " + ChatColor.AQUA + "V0.0.2" + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);
    	
    	this.getServer().getPluginManager().registerEvents(new ChatColors(), this);
		
    	
    	getConfig().options().header("BlitzSsentials Config! - Currently no use for it.");
    	saveConfig();
    	
    	
    	//Commands
    	new Help(this);
		new Test(this);
		new ReloadConfig(this);
		
		new Gamemode(this);
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
    			+ pluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
				+ ChatColor.RED + "|Plugin Disabled| " + ChatColor.AQUA + "V0.0.2" + ChatColor.RESET + "\n"
				+ ChatColor.GOLD + line);
    	
    	saveConfig();
		
	}
}