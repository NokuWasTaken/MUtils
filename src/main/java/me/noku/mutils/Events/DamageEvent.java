package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import net.kyori.adventure.audience.Audience;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!MUtils.getInstance().getTimer().isRunning()) {
            event.setCancelled(true);
            return;
        }
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();


            if (MUtils.getInstance().getTimer().isRunning()) {
                event.setDamage(event.getDamage() * MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier"));
            }

            if (MUtils.getInstance().getTimer().isRunning()) {
                if (MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                        allPlayer.setHealth(allPlayer.getHealth() - event.getDamage());
                    }
                }
            }

            if (MUtils.getInstance().getTimer().isRunning()) {
                if (MUtils.getInstance().getConfig().getBoolean("gamerule.50BlocksIntoTheAir")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 42, false, false));
                }
            }

            if (MUtils.getInstance().getTimer().isRunning()) {
                if (MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                        allPlayer.sendMessage(MUtils.DamagePrefix() + ChatColor.BLUE + ((Player) event.getEntity()).getDisplayName() + ChatColor.GOLD + " hat " + ChatColor.RED + event.getDamage() / 2 + " Herzen " + ChatColor.GRAY + "[ " + ChatColor.AQUA + event.getCause() + ChatColor.GRAY + " ] " + ChatColor.GOLD + "Schaden erhalten");
                    }
                }
            }

            if (MUtils.getInstance().getTimer().isRunning()) {
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    if (MUtils.getInstance().getConfig().getBoolean("gamerule.noFallDamage")) {
                        player.setHealth(0);
                    }
                }
            }

            if (MUtils.getInstance().getTimer().isRunning()) {
                if (MUtils.getInstance().getConfig().getBoolean("challenge.hitFreeze")) {
                    if (player.hasPotionEffect(PotionEffectType.SLOW)) {
                     player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,player.getPotionEffect(PotionEffectType.SLOW).getDuration() + 5*60*20, 255 ));
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5*60*20, 255));


                    }
                }
            }
        }
    }
}
