package aethersl;

import aethersl.commands.FullBright;
import aethersl.commands.Reload;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        File fileconfig = new File(this.getDataFolder() + File.separator + "config.yml");
        if (!fileconfig.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveDefaultConfig();
        }
        this.getCommand("fullbright").setExecutor(new FullBright(this));
        this.getCommand("reload").setExecutor(new Reload(this));
        Bukkit.getPluginManager().registerEvents(new Handler(this), this);
        Logger.getLogger("Minecraft").log(Level.INFO, ChatColor.GOLD + "[ASL]" + ChatColor.GREEN + " Plugin loaded successfully");

    }

    @Override
    public void onDisable() {
        Logger.getLogger("Minecraft").log(Level.INFO, ChatColor.GOLD + "[ASL]" + ChatColor.GREEN + " Plugin shutdown successfully");
    }
}
