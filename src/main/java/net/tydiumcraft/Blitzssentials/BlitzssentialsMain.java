package net.tydiumcraft.Blitzssentials;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import net.tydiumcraft.Blitzssentials.commands.HiCommand;

public class BlitzssentialsMain extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new HiCommand(this);
	}
}
