package me.noku.mutils.Events;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class MoveEvent implements Listener {
    @EventHandler
    public void onMove(org.bukkit.event.player.PlayerMoveEvent event) {
        Player player = event.getPlayer();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        World world = player.getLocation().getWorld();
        Location loc = new Location(world, x, y - 1, z);


        if (MUtils.getInstance().getTimer().isRunning()) {


            if (MUtils.getInstance().getConfig().getBoolean("challenge.onlyDirt")) {
                if (loc.getBlock().getType() != Material.DIRT) {
                    if (loc.getBlock().getType() != Material.AIR) {
                        player.setHealth(0);
                    }
                }
            }

            if (MUtils.getInstance().getConfig().getBoolean("challenge.blockDespawn")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        loc.getBlock().setType(Material.AIR);

                    }
                }.runTaskLater(MUtils.getInstance(), 5 * 20);
            }

            if (MUtils.getInstance().getConfig().getBoolean("challenge.bedrockWalls")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (double i = 0; i <= 256; i++) {
                            Location loc2 = new Location(world, x, i, z);
                            loc2.getBlock().setType(Material.BEDROCK);
                        }
                    }
                }.runTaskLater(MUtils.getInstance(), 10 * 20);
            }
        }
    }
}
