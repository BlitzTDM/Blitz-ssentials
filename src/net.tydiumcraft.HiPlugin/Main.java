package net.tydiumcraft.HiPlugim;

import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.HiPlugim.commands.HiCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new HiCommand(this);
	}
}
