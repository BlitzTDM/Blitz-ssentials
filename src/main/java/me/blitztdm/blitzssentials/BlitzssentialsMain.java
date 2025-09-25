package me.blitztdm.blitzssentials;

import me.blitztdm.blitzssentials.commands.*;
import me.blitztdm.blitzssentials.events.*;
import me.blitztdm.blitzssentials.special.bzssSpecialCommands;
import me.blitztdm.blitzssentials.utils.ChatColors;
import me.blitztdm.blitzssentials.utils.Metrics;
import me.blitztdm.blitzssentials.utils.shortcutTags;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class BlitzssentialsMain extends JavaPlugin implements Listener {

    private static BlitzssentialsMain instance;

    public static ConsoleCommandSender console;

    @Override
    public void onEnable() {
        console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.GOLD + line + ChatColor.DARK_AQUA);
        console.sendMessage(defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA);
        console.sendMessage(ChatColor.GREEN + "|Plugin Enabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET);
        console.sendMessage(ChatColor.GOLD + line);

        int pluginId = 13142;
        Metrics metrics = new Metrics(this, pluginId);

        //Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        if (getConfig().getInt("config-version") == configversionI && getConfig().contains("config-version")) {
            console.sendMessage(bzssprefix + ChatColor.GREEN + "Config is Up-to-Date!");
        } else {
            console.sendMessage(bzssprefix + ChatColor.RED + "Config is not Up-to-Date, use /BZSsConfig to Update it!");
        }

        //checkVersion
        String PluginUpdated = checkVersion.PluginUpdated;
        String PluginOutdated = checkVersion.PluginOutdated;
        String PluginError = checkVersion.VersionCheckError;
        new checkVersion(this).getVersion(version -> {
            if (pluginversion.equalsIgnoreCase(version)) {
                console.sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(pluginversionreal)) {
                console.sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversion)) {
                console.sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversionquick)) {
                console.sendMessage(PluginUpdated);
            } else {
                console.sendMessage(PluginOutdated);
            }});

        //Old PvP
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            AttributeInstance instance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
            if (getConfig().getBoolean("old-pvp.enable-old-pvp")) {
                instance.setBaseValue(255);
            } else {
                instance.setBaseValue(instance.getDefaultValue());
            }
        }

        //Events/Utils
        new shortcutTags(this);
        shortcutTags.setPrefixAddon(this);
        new ChatColors(this);
        new JoinMessage(this);
        new JoinPosition(this);
        new LeaveMessage(this);
        new LaunchPad(this);
        new OldPvp(this);
        new Gameplay(this);

        //Commands
        new Help(this);
        new HelpMenus(this);

        new PluginTest(this);
        new PluginTestJoin(this);
        new PluginTestLeave(this);
        new PluginReloadPlugin(this);
        new PluginConfig(this);
        new PluginInfo(this);
        new PluginCheckUpdate(this);

        new MassSummon(this);

        new tpHere(this);
        new tpAll(this);
        new BroadcastServer(this);
        new BroadcastAlert(this);
        new Countdown(this);

        new Feed(this);
        new Heal(this);
        new Fly(this);
        new GodMode(this);
        new KillAll(this);
        new BlockTop(this);

        new Spawn(this);
        new MyInfo(this);

        if (getConfig().getBoolean("vanish")) {
            new Vanish(this);
        }
        new Sudo(this);
        new Gamemode(this);
        new Time(this);
        new Weather(this);

        new bzssSpecialCommands(this);
    }

    @Override
    public void onDisable() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
        console.sendMessage(ChatColor.GOLD + line + ChatColor.DARK_AQUA);
        console.sendMessage(defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA);
        console.sendMessage(ChatColor.RED + "|Plugin Disabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET);
        console.sendMessage(ChatColor.GOLD + line);
    }
}