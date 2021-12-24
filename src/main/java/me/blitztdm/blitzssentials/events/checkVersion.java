package me.blitztdm.blitzssentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class checkVersion {
    
public static String PluginUpdated = ChatColor.GREEN + line2 + "\n" 
			+ bzssprefix2 + ChatColor.GREEN + "is Up-to-Date! <Your Current Version: " + ChatColor.GOLD + pluginversion + ChatColor.GREEN + ">" + ChatColor.RESET + "\n"
			+ ChatColor.GREEN + line2;

public static String PluginOutdated = ChatColor.YELLOW + line2 + "\n" 
			+ bzssprefix2 + ChatColor.YELLOW + "is Outdated! <Your Version: " + ChatColor.GOLD + pluginversion + ChatColor.YELLOW + ">" + "\n"
			+ "Go to " + ChatColor.BLUE + "https://www.SpigotMC.org/resources/BlitzSsentials.96327/ " + ChatColor.YELLOW + "to Update!" + ChatColor.RESET + "\n"
			+ ChatColor.YELLOW + line2;

public static String VersionCheckError = ChatColor.RED + line2 + "\n" 
				+ bzssprefix2 + ChatColor.RED + "Failed to Check for Updates <Your Current Version: " + ChatColor.GOLD + pluginversion + ChatColor.RED + ">" + ChatColor.RESET + "\n"
				+ ChatColor.RED + line2;
    
private JavaPlugin plugin;

public checkVersion(JavaPlugin plugin) {
    this.plugin = plugin;
}

public void getVersion(final Consumer<String> consumer) {
    Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
        try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=96327").openStream(); Scanner scanner = new Scanner(inputStream)) {
            if (scanner.hasNext()) {
                consumer.accept(scanner.next());
            }
        } catch (IOException exception) {
        	Bukkit.getConsoleSender().sendMessage(VersionCheckError + ChatColor.RESET + "\n" + exception.getMessage());
        }
    });
}
}
