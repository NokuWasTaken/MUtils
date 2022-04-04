package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath (EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (MUtils.getInstance().getTimer().isRunning()) {
                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
                    MUtils.getInstance().Deathevent(MUtils.getInstance().getTimer().getTime(), ((Player) event.getEntity()).getDisplayName());
                }
            }
        }
        if (event.getEntity() instanceof EnderDragon) {
            if (MUtils.getInstance().getTimer().isRunning()) {
                MUtils.getInstance().KillTargetEvent(MUtils.getInstance().getTimer().getTime(), "EnderDragon");
            }
        }
        if (event.getEntity() instanceof Wither) {
            if (MUtils.getInstance().getTimer().isRunning()) {
                MUtils.getInstance().KillTargetEvent(MUtils.getInstance().getTimer().getTime(), "Wither");
            }
        }
    }

}
