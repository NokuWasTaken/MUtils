package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJumpEvent implements Listener {
    @EventHandler
    public void onJump (com.destroystokyo.paper.event.player.PlayerJumpEvent event) {
        Player player = event.getPlayer();
        if (MUtils.getInstance().getTimer().isRunning()) {
            if (MUtils.getInstance().getConfig().getBoolean("gamerule.noJump")) {
                player.setHealth(0);
            }
        }
    }
}
