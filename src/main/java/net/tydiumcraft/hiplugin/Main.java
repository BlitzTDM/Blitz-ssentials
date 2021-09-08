package net.tydiumcraft.hiplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import net.tydiumcraft.hiplugin.commands.HiCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new HiCommand(this);
	}
}
