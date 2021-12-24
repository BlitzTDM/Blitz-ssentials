package me.blitztdm.blitzssentials.utils;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@SuppressWarnings("unused")
public class eventTemplate implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void Event(Event event) {
        
    }
}
