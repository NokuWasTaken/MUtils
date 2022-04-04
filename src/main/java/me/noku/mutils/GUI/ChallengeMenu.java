package me.noku.mutils.GUI;

import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class ChallengeMenu {
    public static Inventory gui = Bukkit.createInventory(null, 36, ChatColor.GRAY + ">> " + ChatColor.GOLD + "Challenges");

    public static void InventoryBuilder () {
        for (int i = 0; i <=35; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname(" ").build());
        }

        gui.setItem(0, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").build());
        gui.setItem(10, new ItemBuilder(Material.DIRT).setDisplayname(ChatColor.GOLD + "Only Dirt").setLore("Click / Set").build());
        gui.setItem(19, new ItemBuilder(Material.BEDROCK).setDisplayname(ChatColor.GOLD + "Bedrock Walls").setLore("Click / Set").build());
        gui.setItem(11, new ItemBuilder(Material.BARRIER).setDisplayname(ChatColor.GOLD + "Block Despawn").setLore("Click / Set").build());
        gui.setItem(20, new ItemBuilder(Material.ELYTRA).setDisplayname(ChatColor.GOLD + "50BlocksIntoTheAir").setLore("Click / Set").build());
        gui.setItem(12, new ItemBuilder(Material.BARRIER).setDisplayname(ChatColor.GOLD + "Floor Hole").setLore("Click / Set").build());
        gui.setItem(21, new ItemBuilder(Material.POTION).setDisplayname(ChatColor.GOLD + "HitFreeze").setLore("Click / Set").build());


    }

}
