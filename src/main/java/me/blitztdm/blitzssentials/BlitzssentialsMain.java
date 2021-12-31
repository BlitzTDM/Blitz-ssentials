package me.blitztdm.blitzssentials;

import me.blitztdm.blitzssentials.commands.*;
import me.blitztdm.blitzssentials.events.*;
import me.blitztdm.blitzssentials.special.bzssSpecialCommands;
import me.blitztdm.blitzssentials.utils.ChatColors;
import me.blitztdm.blitzssentials.utils.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.blitztdm.blitzssentials.utils.shortcutTags.*;

@SuppressWarnings("unused")
public class BlitzssentialsMain extends JavaPlugin implements Listener {

    private static BlitzssentialsMain instance;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(""
                + ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
                + defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
                + ChatColor.GREEN + "|Plugin Enabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
                + ChatColor.GOLD + line);

        Vanish vanishclass = new Vanish();
        JoinPosition joinpositionclass = new JoinPosition();
        Countdown countdownclass = new Countdown();

        //BStats
        // All you have to do is adding the following two lines in your onEnable method.
        // You can find the plugin ids of your plugins on the page https://bstats.org/Blitzssentials
        int pluginId = 13142; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Optional: Add custom charts
        //  metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

        //Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        if (getConfig().getInt("config-version") == configversionI && getConfig().contains("config-version")) {
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.GREEN + "Config is Up-to-Date!");
        } else {
            Bukkit.getConsoleSender().sendMessage(bzssprefix + ChatColor.RED + "Config is not Up-to-Date, use /BZSsConfig to Update it!");
        }

        //checkVersion
        String PluginUpdated = checkVersion.PluginUpdated;
        String PluginOutdated = checkVersion.PluginOutdated;
        String PluginError = checkVersion.VersionCheckError;
        new checkVersion(this).getVersion(version -> {
            if (pluginversion.equalsIgnoreCase(version)) {
                Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(pluginversionreal)) {
                Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversion)) {
                Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else if (version.equalsIgnoreCase(lastpluginversionquick)) {
                Bukkit.getConsoleSender().sendMessage(PluginUpdated);
            } else {
                Bukkit.getConsoleSender().sendMessage(PluginOutdated);
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
        getServer().getPluginManager().registerEvents(new ChatColors(), this);
        getServer().getPluginManager().registerEvents(new JoinMessage(), this);
        getServer().getPluginManager().registerEvents(new JoinPosition(), this);
        getServer().getPluginManager().registerEvents(new LeaveMessage(), this);
        getServer().getPluginManager().registerEvents(new LaunchPad(), this);
        getServer().getPluginManager().registerEvents(new OldPvp(), this);

        //Commands
        new Help(this);
        new HelpPlugin(this);
        new HelpGamemode(this);
        new HelpWeather(this);
        new HelpTime(this);
        new HelpBC(this);

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
        getCommand("countdown").setExecutor(countdownclass);
        getCommand("bccountdown").setExecutor(countdownclass);

        new Feed(this);
        new Heal(this);
        new Fly(this);
        new GodMode(this);
        new KillAll(this);
        new BlockTop(this);

        new Spawn(this);
        new MyInfo(this);

        getCommand("vanish").setExecutor(vanishclass);
        getCommand("unvanish").setExecutor(vanishclass);
        getCommand("togglevanish").setExecutor(vanishclass);

        getCommand("joinpos").setExecutor(joinpositionclass);

        new Gamemode(this);
        new Time(this);
        new Weather(this);

        new bzssSpecialCommands(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(""
                + ChatColor.GOLD + line + ChatColor.DARK_AQUA + "\n"
                + defaultpluginprefix + "Plugin By BlitzTDM " + ChatColor.AQUA + "\n"
                + ChatColor.RED + "|Plugin Disabled| " + ChatColor.AQUA + pluginversion + ChatColor.RESET + "\n"
                + ChatColor.GOLD + line);

        saveDefaultConfig();

    }
}