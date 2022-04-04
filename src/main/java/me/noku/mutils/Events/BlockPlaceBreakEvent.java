package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceBreakEvent implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = (Player) event.getPlayer();
        if (!MUtils.getInstance().getTimer().isRunning()) {
            if (player.getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();
        if (!MUtils.getInstance().getTimer().isRunning()) {
            if (player.getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }
        }
    }
}
