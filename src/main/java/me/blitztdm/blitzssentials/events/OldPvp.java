package me.blitztdm.blitzssentials.events;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class OldPvp implements Listener {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

	public OldPvp(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
    public void metaEvent(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
    	Inventory inventory = player.getInventory();
    		for (ItemStack item : inventory.getContents()) {
    			if (item != null) {
    			if (item.getType().equals(Material.WOODEN_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
    				meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -4, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			} else if (item.getType().equals(Material.STONE_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
    				meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -5, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			} else if (item.getType().equals(Material.GOLDEN_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -4, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			} else if (item.getType().equals(Material.IRON_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -4, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			} else if (item.getType().equals(Material.DIAMOND_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -3, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			} else if (item.getType().equals(Material.NETHERITE_AXE)) {
        			ItemMeta meta = item.getItemMeta();
    				ArrayList<String> lore = new ArrayList<String>();
    				lore.add("OldPvp Test | If you see this, then it is Successful");
    				meta.setLore(lore);
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", -3, Operation.ADD_NUMBER));
    				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 255, Operation.ADD_NUMBER));
    			}
    		}
    }
    }
    
    @EventHandler
    void onHit(EntityDamageByEntityEvent event) {
    	if (event.getDamager() instanceof Player) {
    	Player player = (Player) event.getDamager();
    	if (config.getBoolean("old-pvp.enable-old-pvp")) {
    		ItemStack mainhand = player.getInventory().getItemInMainHand();
    		ItemMeta meta = mainhand.getItemMeta();
    		if (mainhand.getType().equals(Material.WOODEN_SWORD)) {
    			event.setDamage(4);
    		} else if (mainhand.getType().equals(Material.STONE_SWORD)) {
    			event.setDamage(3);
    		} else if (mainhand.getType().equals(Material.GOLDEN_SWORD)) {
    			event.setDamage(4);
    		} else if (mainhand.getType().equals(Material.IRON_SWORD)) {
    			event.setDamage(6);
    		} else if (mainhand.getType().equals(Material.DIAMOND_SWORD)) {
    			event.setDamage(7);
    		} else if (mainhand.getType().equals(Material.NETHERITE_SWORD)) {
    			event.setDamage(8);
    		} else if (mainhand.getType().equals(Material.WOODEN_AXE)) {
    			event.setDamage(3);
    		} else if (mainhand.getType().equals(Material.STONE_AXE)) {
    			event.setDamage(4);
    		} else if (mainhand.getType().equals(Material.GOLDEN_AXE)) {
    			event.setDamage(3);
    		} else if (mainhand.getType().equals(Material.IRON_AXE)) {
    			event.setDamage(5);
    		} else if (mainhand.getType().equals(Material.DIAMOND_AXE)) {
    			event.setDamage(6);
    		} else if (mainhand.getType().equals(Material.NETHERITE_AXE)) {
    			event.setDamage(7);
    		}
    	}
    }
    }
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        AttributeInstance instance = event.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED);
    	if (config.getBoolean("old-pvp.enable-old-pvp")) {
            instance.setBaseValue(255);
    	} else {
    		instance.setBaseValue(instance.getDefaultValue());
    	}
    }
}
