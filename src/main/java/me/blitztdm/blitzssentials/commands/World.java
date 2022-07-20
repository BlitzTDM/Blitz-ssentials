package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

public class World implements TabExecutor {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    public World(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        plugin.getCommand("world").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("BlitzSsentials.world") && sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {
                if (plugin.getServer().getWorld(args[0]) != null) {
                    org.bukkit.World world = plugin.getServer().getWorld(args[0]);
                    if (!player.getWorld().equals(world)) {
                        Location loc = world.getSpawnLocation();
                        player.teleport(loc);
                        player.sendMessage(pluginprefix + ChatColor.GREEN + "Teleported you to World: " + world);
                    } else {
                        player.sendMessage(pluginprefix + ChatColor.RED + "You are already in that World");
                    }
                } else {
                    player.sendMessage(pluginprefix + ChatColor.RED + "World does not Exist");
                }
            } else {
                player.sendMessage(lessargs + "/world <World>");
            }
        } else {
            sender.sendMessage(noperm);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> worlds = new ArrayList<>();
        if (args.length == 1) {
            for (org.bukkit.World world : plugin.getServer().getWorlds()) {
                if (args[0].toUpperCase().startsWith(world.toString()) || args[0].toUpperCase().contains(world.toString())) {
                    worlds.add(world.toString());
                }
            }
        }
        return worlds;
    }
}
