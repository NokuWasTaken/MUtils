package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
                            break;
                        case 13:
                            MUtils.getInstance().getTimer().setRunning(false);
                            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                                allPLayer.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.RED + "pausiert");
                            }
                            break;
                        case 16:
                            MUtils.getInstance().getTimer().setRunning(false);
                            MUtils.getInstance().getTimer().setTime(0);
                            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                                allPLayer.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.RED + "zurückgesetzt");
                            }
                            break;
                    }
                    }
                }
            }
    }
}