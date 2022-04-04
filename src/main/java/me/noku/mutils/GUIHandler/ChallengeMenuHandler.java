package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.MainMenu;
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
                            case 0:
                                MainMenu.MainGUIGenerator();
                                player.openInventory(MainMenu.gui);
                                break;
                            case 10:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.onlyDirt")) {
                                    MUtils.getInstance().getConfig().set("challenge.onlyDirt", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "OnlyDirt challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "OnlyDirt", ChatColor.RED + "Deaktiviert", 5, 40, 5);

                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.onlyDirt")) {
                                    MUtils.getInstance().getConfig().set("challenge.onlyDirt", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "OnlyDirt Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "OnlyDirt", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;
                            case 19:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.bedrockWalls")) {
                                    MUtils.getInstance().getConfig().set("challenge.bedrockWalls", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "BedrockWalls challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "BedrockWalls", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.bedrockWalls")) {
                                    MUtils.getInstance().getConfig().set("challenge.bedrockWalls", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "BedrockWalls Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "BedrockWalls", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;
                            case 11:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.blockDespawn")) {
                                    MUtils.getInstance().getConfig().set("challenge.blockDespawn", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "BlockDespawn challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "BlockDespawn", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.blockDespawn")) {
                                    MUtils.getInstance().getConfig().set("challenge.blockDespawn", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "BlockDespawn Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "BlockDespawn", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;
                            case 20:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.50BlocksIntoTheAir")) {
                                    MUtils.getInstance().getConfig().set("challenge.50BlocksIntoTheAir", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "50 BlocksIntoTheAir challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "50BlocksIntoTheAir", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.50BlocksIntoTheAir")) {
                                    MUtils.getInstance().getConfig().set("challenge.50BlocksIntoTheAir", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "50 BlocksIntoTheAir Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "50BlocksIntoTheAir", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;
                            case 12:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.floorHole")) {
                                    MUtils.getInstance().getConfig().set("challenge.floorHole", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "FloorHole challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "FloorHole", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.floorHole")) {
                                    MUtils.getInstance().getConfig().set("challenge.floorHole", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "FloorHole Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "FloorHole", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;
                            case 21:
                                if (MUtils.getInstance().getConfig().getBoolean("challenge.hitFreeze")) {
                                    MUtils.getInstance().getConfig().set("challenge.hitFreeze", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "HitFreeze challenge deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "HitFreeze", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("challenge.hitFreeze")) {
                                    MUtils.getInstance().getConfig().set("challenge.hitFreeze", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "HitFreeze Challenge aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "HiteFreeze", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;


                        }
                    }
                }
            }
        }
    }

}
