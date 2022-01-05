package aethersl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Handler implements Listener {

    private final Main plugin;

    public Handler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFallDamagePlayer(EntityDamageEvent e){
        if(this.plugin.getConfig().getBoolean("modify-fall-damage.enable")){
            if (e.getEntity() instanceof Player){
                if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
                    e.setDamage(e.getDamage() * this.plugin.getConfig().getDouble("modify-fall-damage.modifier"));
                }
            }
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e){
        if(this.plugin.getConfig().getBoolean("modify-saturation.enable")) {
            e.setFoodLevel((int) (e.getFoodLevel() * this.plugin.getConfig().getDouble("modify-saturation.modifier")));
        }
    }
}
