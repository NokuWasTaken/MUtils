package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.LifeMenu;
import me.noku.mutils.GUI.SettingsMenu;
import me.noku.mutils.GUI.TimerMenu;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.Time;

public class MainMenuHandler implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD +  "MUtils")) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    event.setCancelled(true);
                    switch (event.getSlot()) {
                        case 28:

                            break;
                        case 30:
                            SettingsMenu.SettingsGenerator();
                            player.openInventory(SettingsMenu.gui);
                            break;
                        case 32:
                            LifeMenu.LifeGenerator();
                            player.openInventory(LifeMenu.gui);
                            break;
                        case 34:
                            TimerMenu.InventoryBuilder();
                            player.openInventory(TimerMenu.gui);
                            break;
                    }
                }
            }
        }
    }
}
