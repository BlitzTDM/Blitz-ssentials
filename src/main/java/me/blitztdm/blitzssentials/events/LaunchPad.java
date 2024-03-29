package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LaunchPad implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

	public LaunchPad(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onMove(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
        String configtopblock = config.getString("launchpad.top-block").toUpperCase();
        String configbottomblock = config.getString("launchpad.bottom-block").toUpperCase();
        
        int volume1 = config.getInt("launchpad.sound-1.volume");
        int pitch1 = config.getInt("launchpad.sound-1.pitch");

        int volume2 = config.getInt("launchpad.sound-2.volume");
        int pitch2 = config.getInt("launchpad.sound-2.pitch");
        
        int multiplyDir = config.getInt("launchpad.XZ-launch");
        int multiplyY = config.getInt("launchpad.Y-launch");
        
        if (config.getBoolean("launchpad.enable-launchpad")) {
        	Block PBlock = player.getLocation().getBlock();
    		if (PBlock.getRelative(BlockFace.DOWN).getType() == Material.valueOf(configbottomblock) && PBlock.getType() == Material.valueOf(configtopblock)) {
    			Vector PDir = player.getLocation().getDirection();
    			
    	        String sound1 = config.getString("launchpad.sound-1.sound").toUpperCase().replace(".", "_");
    	        String particle = config.getString("launchpad.particle.particle").toUpperCase();
    	        int particlecount = config.getInt("launchpad.particle.count");
    	        
    	        player.spawnParticle(Particle.valueOf(particle), event.getFrom(), particlecount);
				player.setVelocity(new Vector().setY(multiplyY));
				player.playSound(player.getLocation(), Sound.valueOf(sound1), volume1, pitch1);

    			Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
					@Override
					public void run() {
				        String sound2 = config.getString("launchpad.sound-2.sound").toUpperCase().replace(".", "_");
				        
		    			player.setVelocity(new Vector(PDir.multiply(multiplyDir).getX(), 1, PDir.multiply(multiplyDir).getZ()));
						player.playSound(event.getFrom(), Sound.valueOf(sound2), volume2, pitch2);
					}
    			}, config.getInt("launchpad.launch-delay"));
    		}
    	}
    }
}
