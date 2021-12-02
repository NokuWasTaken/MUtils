package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityregainHealtEvent implements Listener {
    @EventHandler
    public void onRegain (EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (!MUtils.getInstance().getTimer().isRunning()) {
                event.setCancelled(true);
            }
            if (MUtils.getInstance().getConfig().getBoolean("gamerule.ultraUltraHardCore")) {
                event.setCancelled(true);
            }
        }
    }
}
