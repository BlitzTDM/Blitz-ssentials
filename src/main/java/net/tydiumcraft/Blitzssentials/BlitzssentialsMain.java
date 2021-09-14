
package net.tydiumcraft.Blitzssentials;

import org.bukkit.plugin.java.JavaPlugin;

import net.tydiumcraft.Blitzssentials.commands.Test;

public class BlitzssentialsMain extends JavaPlugin {

	@Override
	public void onEnable() {
		
		new Test(this);

	}
}
