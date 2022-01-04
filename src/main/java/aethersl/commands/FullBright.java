package aethersl.commands;

import aethersl.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class FullBright implements CommandExecutor {


    private final Main plugin;

    public FullBright(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
            sender.sendMessage(ChatColor.GOLD + "&6You have " + ChatColor.RED + "disable " + ChatColor.GOLD + "infinity night vision");
        } else {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
            sender.sendMessage(ChatColor.GOLD + "&6You have " + ChatColor.GREEN + "enable " + ChatColor.GOLD + "infinity night vision");
        }
        return true;
    }
}
