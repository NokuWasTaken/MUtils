package me.noku.mutils.GUI;

import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class MainMenu {

    public static Inventory gui = Bukkit.createInventory( null, 54, ChatColor.GRAY + ">> "+ ChatColor.GOLD + ChatColor.BOLD + "MUtils" );

    public static void MainGUIGenerator() {
        for (int i = 0; i <= 53; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(13, new ItemBuilder(Material.NETHER_STAR).setDisplayname(ChatColor.GOLD + "" + ChatColor.BOLD + "MUtils " + ChatColor.AQUA + "v1.7.1").build());
        gui.setItem(37, new ItemBuilder(Material.CONDUIT).setDisplayname(ChatColor.DARK_PURPLE + "Challenges").setLore("Click / Open").build());
        gui.setItem(39, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname(ChatColor.GOLD + "Settings").setLore("Click / Open").build());
        gui.setItem(41, new ItemBuilder(Material.CLOCK).setDisplayname(ChatColor.GREEN + "Timer").setLore("Click / Open").build());
        gui.setItem(43, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.RED + "Life").setLore("Click / Open").build());
    }

}
