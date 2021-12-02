package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onDamage (EntityDamageEvent event) {
        if (!MUtils.getInstance().getTimer().isRunning()) {
            event.setCancelled(true);
        }
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (MUtils.getInstance().getTimer().isRunning()) {
                event.setDamage(event.getDamage() * MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier"));
            }

            if (MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
                for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                    allPlayer.setHealth(allPlayer.getHealth() - event.getDamage());
                }
            }

            if (MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
                if (MUtils.getInstance().getTimer().isRunning()) {
                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                        allPlayer.sendMessage(MUtils.DamagePrefix() + ChatColor.BLUE + ((Player) event.getEntity()).getDisplayName() + ChatColor.GOLD + " hat " + ChatColor.RED + event.getDamage() / 2 + " Herzen " + ChatColor.GRAY + "[ " + ChatColor.AQUA + event.getCause() + ChatColor.GRAY + " ] " + ChatColor.GOLD + "Schaden erhalten");
                    }
                }
            }



        }
    }
}
