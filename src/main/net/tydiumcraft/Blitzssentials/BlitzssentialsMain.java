
package net.tydiumcraft.Blitzssentials;

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
import net.tydiumcraft.Blitzssentials.events.onJoin;

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

    	//Config
    	String joinmessagedefault = "&6%Line%\n&r&aWelcome, &l%Player%!\n&6%Line%";
    	String adminjoinmessagedefault = "&6%Line%\n&r&bWelcome Admin/Operator!\n&r%Plugin%";
    	
    	getConfig().options().header(""
    			+ "BlitzSsentials Config!\n"
    			+ "\n"
    			+ "# Config for Join Messages" + "\n"
    			+ "Use %player% for Playername" + "\n"
    			+ "Use %line% for Line" + "\n"
    			+ "Use %plugin% for Plugin and Plugin Version (Admin Only)" + "\n"
    			+ "Use & for color codes!" + "\n"
    			+ "Use \n for Enter/Another Line" + "\n"
    			+ "Remember the: ''" + "\n"
    			+ "Default Join Message comes after Admin");
    	getConfig().addDefault("admin-join-message", adminjoinmessagedefault);
    	getConfig().addDefault("default-join-message", joinmessagedefault);
    	getConfig().options().header("test 1");
    	getConfig().options().copyDefaults(true);
    	saveConfig();
    	
    	//Events/Utils
    	getServer().getPluginManager().registerEvents(new ChatColors(), this);
    	getServer().getPluginManager().registerEvents(new onJoin(), this);

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