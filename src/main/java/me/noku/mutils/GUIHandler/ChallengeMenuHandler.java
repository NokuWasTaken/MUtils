package me.noku.mutils.GUIHandler;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ChallengeMenuHandler implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().equals(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Challenges")) {
                if (event.getCurrentItem() != null) {
                    if (event.getCurrentItem().getItemMeta() != null) {
                        event.setCancelled(true);
                        switch (event.getSlot()) {
                            case 10:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.onlyDirt")) {
                                    MUtils.getInstance().getConfig().set("challenge.onlyDirt", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "OnlyDirt challenge deaktiviert");
                                    }
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.onlyDirt")) {
                                    MUtils.getInstance().getConfig().set("challenge.onlyDirt", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "OnlyDirt Challenge aktiviert");
                                    }
                                }
                                break;
                            case 19:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.bedrockWalls")) {
                                    MUtils.getInstance().getConfig().set("challenge.bedrockWalls", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "BedrockWalls challenge deaktiviert");
                                    }
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.bedrockWalls")) {
                                    MUtils.getInstance().getConfig().set("challenge.bedrockWalls", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "BedrockWalls Challenge aktiviert");
                                    }
                                }
                                break;
                            case 11:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.blockDespawn")) {
                                    MUtils.getInstance().getConfig().set("challenge.blockDespawn", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "BlockDespawn challenge deaktiviert");
                                    }
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.blockDespawn")) {
                                    MUtils.getInstance().getConfig().set("challenge.blockDespawn", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "BlockDespawn Challenge aktiviert");
                                    }
                                }
                                break;


                        }
                    }
                }
            }
        }
    }

}
