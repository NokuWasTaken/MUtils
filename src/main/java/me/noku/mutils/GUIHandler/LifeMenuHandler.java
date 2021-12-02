package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.MUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LifeMenuHandler implements Listener {
    @EventHandler
    public void onClick (InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {

            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().equals(ChatColor.GRAY + ">> " + ChatColor.GOLD + "Life Settings")) {

                event.setCancelled(true);

                switch (event.getSlot()) {
                    case 0:
                        MainMenu.MainGUIGenerator();
                        player.openInventory(MainMenu.gui);
                        break;
                    case 10:
                        player.setMaxHealth(40);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf" + ChatColor.DARK_PURPLE + " 20 " + ChatColor.GOLD + "gesetzt");
                        break;
                    case 12:
                        player.setMaxHealth(20);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf" + ChatColor.DARK_PURPLE + " 10 " + ChatColor.GOLD + "gesetzt");
                        break;
                    case 14:
                        player.setMaxHealth(10);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf" + ChatColor.DARK_PURPLE + " 5 " + ChatColor.GOLD + "gesetzt");
                        break;
                    case 16:
                        player.setMaxHealth(1);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf" + ChatColor.DARK_PURPLE + " 0.5 " + ChatColor.GOLD + "gesetzt");
                        break;
                    case 29:
                        player.setMaxHealth(player.getMaxHealth() - 1);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf " + ChatColor.DARK_PURPLE + player.getMaxHealth() + ChatColor.GOLD + " gesetzt");
                        break;
                    case 31:
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Du wurdest geheilt " + ChatColor.GRAY + "[ " + ChatColor.DARK_PURPLE + player.getMaxHealth() / 2 + ChatColor.GOLD + " Herzen" + ChatColor.GRAY + " ]");
                        break;
                    case 33:
                        player.setMaxHealth(player.getMaxHealth() + 1);
                        player.setHealth(player.getMaxHealth());
                        player.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Deine maximalen Herzen wurden auf " + ChatColor.DARK_PURPLE + player.getMaxHealth() + ChatColor.GOLD + " gesetzt");
                        break;


                }
            }
        }
    }
}
