package aethersl;

import aethersl.commands.FullBright;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("fullbright").setExecutor(new FullBright(this));
        Bukkit.getPluginManager().registerEvents(new Handler(this), this);
        Logger.getLogger("Minecraft").log(Level.INFO, ChatColor.GOLD + "[ASL]" + ChatColor.GREEN + " Plugin loaded successfully");

    }

    @Override
    public void onDisable() {
        Logger.getLogger("Minecraft").log(Level.INFO, ChatColor.GOLD + "[ASL]" + ChatColor.GREEN + " Plugin shutdown successfully");
    }
}
