package aethersl;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Handler implements Listener {

    private final Main plugin;

    public Handler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFallDamagePlayer(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
                e.setDamage(e.getDamage()*0.5);
            }
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e){
        if(e.getItem().getType().equals(Material.POTION)) return;
        NBTItem nbtItem = new NBTItem(e.getItem());

        e.getPlayer().setFoodLevel( e.getPlayer().getFoodLevel() + (int) (nbtItem.getInteger("FoodLevel") * 1.5));
    }
}
