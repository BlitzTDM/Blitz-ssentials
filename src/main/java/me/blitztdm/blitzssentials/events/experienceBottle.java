package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class experienceBottle implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    public experienceBottle(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void experienceThrow(ExpBottleEvent event) {
        if (config.getBoolean("enable-sneak-exp")) {
            if (event.getEntityType().equals(EntityType.PLAYER)) {
                Player player = (Player) event.getEntity();
                if (player.isSneaking()) {
                    player.giveExp(event.getExperience());
                    event.setCancelled(true);
                }
            }
        }
    }
}
