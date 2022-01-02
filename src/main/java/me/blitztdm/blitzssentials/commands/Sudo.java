package me.blitztdm.blitzssentials.commands;

import me.blitztdm.blitzssentials.BlitzssentialsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

public class Sudo implements TabExecutor {

    BlitzssentialsMain plugin = BlitzssentialsMain.getPlugin(BlitzssentialsMain.class);
    FileConfiguration config = plugin.getConfig();
    public Sudo(BlitzssentialsMain plugin) {
        this.plugin = plugin;
        plugin.getCommand("sudo").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("BlitzSsentials.sudo") || !(sender instanceof Player)) {
            if (args.length >= 3) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player arg0 = Bukkit.getPlayer(args[0]);
                    StringBuilder text = new StringBuilder();
                    for (int i = 0; i < (args.length-2); i++) {
                        text.append(args[i+2]).append(" ");
                    }
                    String send = text.toString().trim();
                    if (args[1].equalsIgnoreCase("chat")) {
                        arg0.chat(send);
                    } else if (args[1].equalsIgnoreCase("cmd")) {
                        arg0.performCommand(send);
                    } else {
                        sender.sendMessage(pluginprefix + ChatColor.RED + "Sudo Type not set ('chat' or 'cmd')");
                    }
                } else {
                    sender.sendMessage(cannotfind + args[0]);
                }
            } else {
                sender.sendMessage(lessargs + "/sudo <player> <chat | cmd> <input <chat | cmd>>");
            }
        } else {
            sender.sendMessage(noperm);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> sudo = new ArrayList<String>();
        if (args.length == 1) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                sudo.add(player.getName());
            }
        } else if (args.length == 2) {
            sudo.add("chat");
            sudo.add("cmd");
        } else if (args.length >= 3) {
            if (args[1].equalsIgnoreCase("cmd")) {
                sudo.add("<command>");
            } else if (args[1].equalsIgnoreCase("chat")) {
                sudo.add("<chat>");
            }
        }

        return sudo;
    }
}
