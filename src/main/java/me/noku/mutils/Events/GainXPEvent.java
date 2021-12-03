package me.noku.mutils.Events;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GainXPEvent implements Listener {
    @EventHandler
    public void onXP (PlayerPickupExperienceEvent event) {
        Player player = event.getPlayer();
        if (MUtils.getInstance().getTimer().isRunning()) {
            if (MUtils.getInstance().getConfig().getBoolean("gamerule.noXP")) {
                player.setHealth(0);
            }
        }
    }
}
