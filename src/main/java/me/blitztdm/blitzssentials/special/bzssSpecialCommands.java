package me.blitztdm.blitzssentials.special;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

import static me.blitztdm.blitzssentials.utils.shortcutTags.bzssprefix;

public class bzssSpecialCommands implements CommandExecutor {

	BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
	FileConfiguration config = plugin.getConfig();

	public bzssSpecialCommands(BlitzssentialsMain plugin) {
		this.plugin = plugin;
		plugin.getCommand("bzss").setExecutor(this);
	}

	ArrayList<UUID> BlitzTDMTrailArray = new ArrayList<UUID>();
	String BlitzTDMUuid = "a22cdac1-2856-44c3-8b7b-3f57f06ecf18";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		createTrail(sender, args, "BlitzTDMCosmeticTrail", BlitzTDMTrailArray, BlitzTDMUuid, 0,0,204, 0,255,255, 102,0,204, 0,128,255);

		return false;
	}

	public void createTrail(CommandSender sender, String[] args, String cmdArg, ArrayList<UUID> nameArray, String nameUUID, int r1, int g1, int b1, int r2, int g2, int b2, int r3, int g3, int b3, int r4, int g4, int b4){
		if (args.length == 1 && args[0].equalsIgnoreCase(cmdArg)) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.getUniqueId().toString().equals(nameUUID) || player.getUniqueId().toString().equals(BlitzTDMUuid)) {
					sender.sendMessage(bzssprefix + player.getUniqueId());
					if (!(nameArray.contains(player.getUniqueId()))) {
						nameArray.add(player.getUniqueId());
						sender.sendMessage(bzssprefix + ChatColor.GREEN + "Successfully Applied Special " + Bukkit.getOfflinePlayer(nameUUID).getName() + " Cosmetic Trail");
					} else {
						nameArray.remove(player.getUniqueId());
						sender.sendMessage(bzssprefix + ChatColor.RED + "Successfully Unapplied Special " + Bukkit.getOfflinePlayer(nameUUID).getName() + " Cosmetic Trail");
					}
					new BukkitRunnable() {
						@Override
						public void run() {
							if (nameArray.toString().contains(nameUUID) && player.isOnline() || nameArray.toString().contains(BlitzTDMUuid) && player.isOnline()) {
								float brightness = 1;
								DustOptions color2 = new DustOptions(Color.fromRGB(r2, g2, b2), brightness);
								DustOptions color3 = new DustOptions(Color.fromRGB(r3, g3, b3), brightness);
								DustOptions color4 = new DustOptions(Color.fromRGB(r4, g4, b4), brightness);
								DustOptions color1 = new DustOptions(Color.fromRGB(r1, g1, b1), brightness);
								for (int i = 0; i < 3; i++) {
									double x = player.getLocation().getX();
									double y = player.getLocation().getY();
									double z = player.getLocation().getZ();
									//NW (8)
									player.getWorld().spawnParticle(Particle.REDSTONE, x - 0.275 * i, y, z - 0.275 * i, 0, color4);
									//NE (2)
									player.getWorld().spawnParticle(Particle.REDSTONE, x + 0.275 * i, y, z - 0.275 * i, 0, color2);
									//SW (6)
									player.getWorld().spawnParticle(Particle.REDSTONE, x - 0.275 * i, y, z + 0.275 * i, 0, color2);
									//SE (4)
									player.getWorld().spawnParticle(Particle.REDSTONE, x + 0.275 * i, y, z + 0.275 * i, 0, color4);
									//EE (3)
									player.getWorld().spawnParticle(Particle.REDSTONE, x + 0.4 * i, y, z, 0, color3);
									//WW (7)
									player.getWorld().spawnParticle(Particle.REDSTONE, x - 0.4 * i, y, z, 0, color3);
									//NN (1)
									player.getWorld().spawnParticle(Particle.REDSTONE, x, y, z - 0.4 * i, 0, color1);
									//SS (5)
									player.getWorld().spawnParticle(Particle.REDSTONE, x, y, z + 0.4 * i, 0, color1);
								}
							} else {
								nameArray.remove(player.getUniqueId().toString());
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 2);
				} else {
					sender.sendMessage();
				}
			}
		}
	}
}
