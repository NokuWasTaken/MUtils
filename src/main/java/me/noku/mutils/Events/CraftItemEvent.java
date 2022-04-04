package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CraftItemEvent implements Listener {
    @EventHandler
    public void onCraft (org.bukkit.event.inventory.CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (MUtils.getInstance().getTimer().isRunning()) {
            if (MUtils.getInstance().getConfig().getBoolean("gamerule.noCrafting")) {
                player.setHealth(0);
            }
        }
    }
}
