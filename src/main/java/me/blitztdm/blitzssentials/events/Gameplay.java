package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.bzssprefix;
import static me.blitztdm.blitzssentials.utils.shortcutTags.bzssprefix2;

public class Gameplay implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    public Gameplay(BlitzssentialsMain plugin) {
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

    @EventHandler
    public void itemDespawnLog(ItemDespawnEvent event) {
        if (config.getBoolean("log-item-despawn")) {
            ItemStack item = event.getEntity().getItemStack();
            int amount = item.getAmount();
            String name = item.getItemMeta().getDisplayName();
            String dropper;
            if (event.getEntity().getThrower() != null) {
            dropper = Bukkit.getOfflinePlayer(event.getEntity().getThrower()).getPlayer().getDisplayName();
            } else {
                dropper = event.getEntityType().name();
            }
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.WHITE + "Item Dropped by: " + dropper + " || Item: " + name + " || Amount: " + amount);
        }
    }

    @EventHandler
    public void deathChest(PlayerDeathEvent event) {
        if (config.getBoolean("death-chest.enable")) {
            int exp = event.getDroppedExp();
            Player player = event.getEntity().getPlayer();
            Location loc = event.getEntity().getLocation();
            List<ItemStack> drops = event.getDrops();
            loc.getBlock().setType(Material.CHEST);
            Block chestBlock = loc.getBlock();
            Chest chest = (Chest) chestBlock.getState();
            int expBottles = exp/7;
            chest.setCustomName(player.getName() + " Death Chest");
            chest.getBlockInventory().setContents(drops.toArray(new ItemStack[0]));
            chest.getBlockInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE, expBottles));
            drops.clear();
        }
    }

}
