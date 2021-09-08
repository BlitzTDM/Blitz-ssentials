package net.tydiumcraft.blitztdm;

import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.blitztdm.helloworld.commands.HiCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new HiCommand(this);
	}
}
