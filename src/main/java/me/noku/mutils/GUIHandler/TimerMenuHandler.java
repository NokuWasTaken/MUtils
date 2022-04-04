package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.GUI.TimerMenu;
import me.noku.mutils.MUtils;
import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.Time;

public class TimerMenuHandler implements Listener{

    @EventHandler
    public void onClick (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Timer")) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    event.setCancelled(true);
                    switch (event.getSlot()) {
                        case 0:
                            MainMenu.MainGUIGenerator();
                            player.openInventory(MainMenu.gui);
                            break;
                        case 10:
                            MUtils.getInstance().getTimer().setRunning(true);
                            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                                allPLayer.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.GREEN + "gestartet");
                            }
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.GREEN + "gestartet", 5, 40, 5);
                            break;
                        case 12:
                            MUtils.getInstance().getTimer().setRunning(false);
                            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                                allPLayer.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.RED + "pausiert");
                            }
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.RED + "pausiert", 5, 40, 5);
                            break;
                        case 14:
                            if (MUtils.getInstance().getConfig().getString("timer.mode").equals("normal")) {
                                TimerMenu.gui.setItem(14, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.DARK_PURPLE + "Mode").setLore(ChatColor.GRAY + "   normal", ChatColor.GRAY +" > " + ChatColor.GREEN + "backward").build());
                                MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der TimerMode wurde auf " + ChatColor.GRAY + "[ " + ChatColor.AQUA + "backward" + ChatColor.GRAY + " ]" + ChatColor.GOLD + " Gesetzt");
                                MUtils.getInstance().getConfig().set("timer.mode", "backward");
                                MUtils.getInstance().saveConfig();
                                MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "TimerMode", ChatColor.DARK_PURPLE + "backward", 5, 40, 5);

                            } else if (MUtils.getInstance().getConfig().getString("timer.mode").equals("backward")) {
                                TimerMenu.gui.setItem(14, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.DARK_PURPLE + "Mode").setLore(ChatColor.GRAY + "> " + ChatColor.GREEN + "normal", ChatColor.GRAY + "  backward").build());
                                MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der TimerMode wurde auf " + ChatColor.GRAY + "[ " + ChatColor.AQUA + "normal" + ChatColor.GRAY + " ]" + ChatColor.GOLD + " Gesetzt");
                                MUtils.getInstance().getConfig().set("timer.mode", "normal");
                                MUtils.getInstance().saveConfig();
                                MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "TimerMode", ChatColor.DARK_PURPLE + "normal", 5, 40, 5);

                            }

                            break;
                        case 16:
                            MUtils.getInstance().getTimer().setRunning(false);
                            MUtils.getInstance().getTimer().setTime(0);
                            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                                allPLayer.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.RED + "zurückgesetzt");
                            }
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.GREEN + "zurückgesetzt", 5, 40, 5);

                            break;
                    }
                    }
                }
            }
    }
}