package me.noku.mutils.GUI;

import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class MainMenu {

    public static Inventory gui = Bukkit.createInventory( null, 45, ChatColor.GRAY + ">> "+ ChatColor.GOLD + ChatColor.BOLD + "MUtils" );

    public static void MainGUIGenerator() {
        for (int i = 0; i <= 44; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(13, new ItemBuilder(Material.NETHER_STAR).setDisplayname(ChatColor.GOLD + "MUtils " + ChatColor.AQUA + "v1.4.1").build());
        gui.setItem(28, new ItemBuilder(Material.CONDUIT).setDisplayname(ChatColor.DARK_PURPLE + "Challenges").setLore("Click / Open").build());
        gui.setItem(30, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname(ChatColor.GOLD + "Settings").setLore("Click / Open").build());
        gui.setItem(32, new ItemBuilder(Material.CLOCK).setDisplayname(ChatColor.GREEN + "Timer").setLore("Click / Open").build());
        gui.setItem(34, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.RED + "Life").setLore("Click / Open").build());
    }

}
