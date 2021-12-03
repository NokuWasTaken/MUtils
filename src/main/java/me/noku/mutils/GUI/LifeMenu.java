package me.noku.mutils.GUI;


import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LifeMenu {
    public static Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GRAY + ">> " + ChatColor.GOLD + "Life Settings");

    public static void LifeGenerator () {

        for(int i = 0; i <= 44; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(0, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").build());
        gui.setItem(10, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setDisplayname(ChatColor.GOLD + "Double Lifes").setLore("Click / Set").build());
        gui.setItem(12, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname(ChatColor.GOLD + "Normal Lifes").setLore("Click / Set").build());
        gui.setItem(14, new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname(ChatColor.GOLD + "Half Lifes").setLore("Click / Set").build());
        gui.setItem(16, new ItemBuilder(Material.GOLDEN_CHESTPLATE).setDisplayname(ChatColor.GOLD + "One Life").setLore("Click / Set").build());
        gui.setItem(29, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.GOLD + "- 1 HP").setLore("Click / Set").build());
        gui.setItem(31, new ItemBuilder(Material.RED_DYE).setDisplayname(ChatColor.GOLD + "Heal").setLore("Click / Set").build());
        gui.setItem(33, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.GOLD + "+ 1 HP").setLore("Click / Set").build());
    }
}
