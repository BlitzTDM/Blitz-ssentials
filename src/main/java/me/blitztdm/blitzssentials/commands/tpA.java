package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

public class tpA implements CommandExecutor {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();

    HashMap<UUID, UUID> requestMapTPA = new HashMap<UUID, UUID>();
    HashMap<UUID, UUID> requestMapTPAHere = new HashMap<UUID, UUID>();
    HashMap<UUID, Boolean> requestAcceptTPA = new HashMap<UUID, Boolean>();
    HashMap<UUID, Boolean> requestAcceptTPAHere = new HashMap<UUID, Boolean>();

    tpA(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        plugin.getCommand("tpa").setExecutor(this);
        plugin.getCommand("tpahere").setExecutor(this);
        plugin.getCommand("tpaccept").setExecutor(this);
        plugin.getCommand("tpdeny").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (config.getBoolean("tpa.enable-tpa")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("tpa") && sender.hasPermission("BlitzSsentials.tpa")) {
                    requestManager(args, requestMapTPA, player, false);
                } else if (cmd.getName().equalsIgnoreCase("tpahere") && sender.hasPermission("BlitzSsentials.tpa")) {
                    requestManager(args, requestMapTPA, player, true);
                } else if (requestMapTPA.containsValue(player.getUniqueId()) || requestMapTPAHere.containsValue(player.getUniqueId())) {
                    if (cmd.getName().equalsIgnoreCase("tpaccept") || cmd.getName().equalsIgnoreCase("tpdeny")) {
                        if (args.length == 1) {
                            Player arg0 = Bukkit.getPlayer(args[0]);
                            if (arg0 != null) {
                                if (cmd.getName().equalsIgnoreCase("tpaccept")) {
                                    if (requestMapTPA.containsValue(player.getUniqueId())) {
                                        requestAcceptTPA.put(player.getUniqueId(), true);
                                    } else if (requestMapTPAHere.containsValue(player.getUniqueId())) {
                                        requestAcceptTPAHere.put(player.getUniqueId(), true);
                                    }
                                } else if (cmd.getName().equalsIgnoreCase("tpdeny")) {
                                    if (requestMapTPA.containsValue(player.getUniqueId())) {
                                        requestAcceptTPA.put(player.getUniqueId(), false);
                                    } else if (requestMapTPAHere.containsValue(player.getUniqueId())) {
                                        requestAcceptTPAHere.put(player.getUniqueId(), false);
                                    }
                                }
                            } else {
                                player.sendMessage(cannotfind + args[0]);
                            }
                        } else {
                            player.sendMessage(specifyplayer);
                        }
                    }
                } else {
                    player.sendMessage(pluginprefix + ChatColor.RED + "You hav no TPA Requests");
                }
            } else {
                sender.sendMessage(console);
            }
        } else {
            sender.sendMessage(pluginprefix + ChatColor.RED + "This Command is Disabled, if this is an Error, please contact Administrators");
        }
        return false;
    }

    public void requestManager(String[] args, HashMap<UUID, UUID> requestMap, Player requester, Boolean tpaHere) {
        if (args.length == 1) {
            String recipientName = args[0];
            Player recipient = Bukkit.getPlayer(recipientName);
            if (recipient != null) {
                Location loc;
                if (tpaHere) {
                    loc = recipient.getLocation();
                } else {
                    loc = requester.getLocation();
                }
                UUID requesterUUID = requester.getUniqueId();
                UUID recipientUUID = recipient.getUniqueId();
                if (!requestMap.containsValue(requesterUUID) || !requestMap.get(requesterUUID).equals(recipientUUID)) {
                    requestMap.put(requesterUUID, recipientUUID);
                    int timerSet = 10;
                    new BukkitRunnable() {
                        int timer = timerSet;
                        @Override
                        public void run() {
                            if (tpaHere) {
                                if (requestAcceptTPAHere.containsKey(recipientUUID) && requestAcceptTPAHere.get(recipientUUID)) {
                                    requester.sendMessage(pluginprefix + ChatColor.GREEN + "Your TPAHere Request to " + recipient.getName() + " has been Accepted");
                                    recipient.sendMessage(pluginprefix + ChatColor.GREEN + "Your TPAHere Request from " + requester.getName() + " has been Accepted");
                                    recipient.teleport(loc);
                                    cancel();
                                } else if (requestAcceptTPAHere.containsKey(recipientUUID) && !requestAcceptTPAHere.get(recipientUUID)) {
                                    requester.sendMessage(pluginprefix + ChatColor.RED + "Your TPAHere Request to " + recipient.getName() + " has been Denied");
                                    recipient.sendMessage(pluginprefix + ChatColor.RED + "Your TPAHere Request from " + requester.getName() + " has been Denied");
                                    cancel();
                                }
                            } else {
                                if (requestAcceptTPA.containsKey(recipientUUID) && requestAcceptTPA.get(recipientUUID)) {
                                    requester.sendMessage(pluginprefix + ChatColor.GREEN + "Your TPA Request to " + recipient.getName() + " has been Accepted");
                                    recipient.sendMessage(pluginprefix + ChatColor.GREEN + "Your TPA Request from " + requester.getName() + " has been Accepted");
                                    requester.teleport(loc);
                                    cancel();
                                } else if (requestAcceptTPA.containsKey(recipientUUID) && !requestAcceptTPA.get(recipientUUID)) {
                                    requester.sendMessage(pluginprefix + ChatColor.RED + "Your TPA Request to " + recipient.getName() + " has been Denied");
                                    recipient.sendMessage(pluginprefix + ChatColor.RED + "Your TPA Request from " + requester.getName() + " has been Denied");
                                    cancel();
                                }
                            }
                            if (timer <= 0) {
                                if (tpaHere) {
                                    requester.sendMessage(pluginprefix + ChatColor.RED + "Your TPAHere Request to " + recipient.getName() + " has Expired");
                                    recipient.sendMessage(pluginprefix + ChatColor.RED + "Your TPAHere Request from " + requester.getName() + " has Expired");
                                } else {
                                    requester.sendMessage(pluginprefix + ChatColor.RED + "Your TPA Request to " + recipient.getName() + " has Expired");
                                    recipient.sendMessage(pluginprefix + ChatColor.RED + "Your TPA Request from " + requester.getName() + " has Expired");
                                }
                                cancel();
                            }
                            timer--;
                        }
                    }.runTaskTimer(plugin, 0, 20);
                } else {
                    if (tpaHere) {
                        requester.sendMessage(pluginprefix + ChatColor.YELLOW + "You have already sent a TPAHere request to " + recipient.getName());
                    } else {
                        requester.sendMessage(pluginprefix + ChatColor.YELLOW + "You have already sent a TPA request to " + recipient.getName());
                    }
                }
            } else {
                requester.sendMessage(cannotfind + recipientName);
            }
        } else {
            requester.sendMessage(specifyplayer);
        }
    }
}
