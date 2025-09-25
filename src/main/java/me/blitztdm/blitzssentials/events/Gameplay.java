package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.bzssprefix;

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
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.WHITE + "Item Despawned by: " + dropper + " || Item: " + name + " || Amount: " + amount);
        }
    }
    @EventHandler
    public void itemSpawnLog(ItemSpawnEvent event) {
        if (config.getBoolean("log-item-spawn")) {
            ItemStack item = event.getEntity().getItemStack();
            int amount = item.getAmount();
            String name = item.getItemMeta().getDisplayName();
            String dropper;
            if (event.getEntity().getThrower() != null) {
                dropper = Bukkit.getOfflinePlayer(event.getEntity().getThrower()).getPlayer().getDisplayName();
            } else {
                dropper = event.getEntityType().name();
            }
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.WHITE + "Item Spawned by: " + dropper + " || Item: " + name + " || Amount: " + amount);
        }
    }

    @EventHandler
    public void itemDropLog(EntityDropItemEvent event) {
        if (config.getBoolean("log-item-drops")) {
            ItemStack item = event.getItemDrop().getItemStack();
            int amount = item.getAmount();
            String name = event.getItemDrop().getName();
            String dropper = event.getEntity().getName();
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.WHITE + "Item Dropped by: " + dropper + " || Item: " + name + " || Amount: " + amount);
        }
    }
    @EventHandler
    public void itemPickupLog(EntityPickupItemEvent event) {
        if (config.getBoolean("log-item-pickup")) {
            ItemStack item = event.getItem().getItemStack();
            int amount = item.getAmount();
            String name = event.getItem().getName();
            String dropper = event.getEntity().getName();
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.WHITE + "Item Picked Up by: " + dropper + " || Item: " + name + " || Amount: " + amount);
        }
    }


    @EventHandler
    public void deathChest(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        int exp = event.getDroppedExp();
        List<ItemStack> drops = event.getDrops();
        if (config.getBoolean("death-chest.enable") && player.isOnline()) {
            Location loc1 = player.getLocation();
            Block chestBlock1 = loc1.getBlock();
            Chest chest1;
            Location loc2 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY() + 1, loc1.getZ());
            Block chestBlock2 = loc2.getBlock();
            Chest chest2 = null;
            //XP
            int expBottles = exp/7;
            ItemStack xpBottle = new ItemStack(Material.EXPERIENCE_BOTTLE, expBottles);
            ItemMeta xpmeta = xpBottle.getItemMeta();
            xpmeta.setDisplayName(player.getDisplayName() + " XP");
            List<String> lore = new ArrayList<String>();
            lore.add("Obtain the XP of " + player.getName());
            xpmeta.setLore(lore);
            xpBottle.setItemMeta(xpmeta);
            drops.add(xpBottle);
            //Chest Creation
            boolean fillChest1;
            if (drops.size() > 0) {
                loc1.getBlock().setType(Material.CHEST);
                chest1 = (Chest) chestBlock1.getState();
                chest1.setCustomName(player.getDisplayName() + " Death Chest");
                if (drops.size() >= 27) {
                    loc2.getBlock().setType(Material.CHEST);
                    chest2 = (Chest) chestBlock2.getState();
                    chest2.setCustomName(player.getDisplayName() + " Death Chest");
                }
                for (int i = 0; i < ((drops.size()-1)+(Math.ceil(expBottles/64))); i++) {
                    if (i < 27) {
                        chest1.getBlockInventory().addItem(drops.get(i));
                    } else {
                        chest2.getBlockInventory().addItem(drops.get(i));
                    }
                }
            }
            event.getDrops().clear();
        }
    }

}
