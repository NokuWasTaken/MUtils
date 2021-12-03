package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerSneakEvent implements Listener {
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (MUtils.getInstance().getTimer().isRunning()) {
            if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noSneak")) {
                player.setHealth(0);
            }
        }
    }
}
