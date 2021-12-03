package me.noku.mutils.GUI;

import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SettingsMenu {

    public static Inventory gui = Bukkit.createInventory(null, 36, ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD + "Settings");

    public static void SettingsGenerator () {

        for(int i = 0; i <= 35; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(0, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").build());
        gui.setItem(10, new ItemBuilder(Material.DRAGON_HEAD).setDisplayname(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge").setLore("Click / Set").build());
        gui.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Hardcore").setLore("Click / Set").build());
        gui.setItem(12, new ItemBuilder(Material.NETHERITE_AXE).setDisplayname(ChatColor.GOLD + "Damage Multiplier").setLore("Click / +1").build());
        gui.setItem(13, new ItemBuilder(Material.FLOWER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Herzen in Tablist").setLore("Click / Set").build());
        gui.setItem(14, new ItemBuilder(Material.TOTEM_OF_UNDYING).setDisplayname(ChatColor.GOLD + "Schutzzeit").setLore("Click / +5").build());
        gui.setItem(15, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayname(ChatColor.GOLD + "No XP").setLore("Click / Set").build());
        gui.setItem(16, new ItemBuilder(Material.ENDER_PEARL).setDisplayname(ChatColor.GOLD + "No Jumping").setLore("Click / Set").build());
        gui.setItem(19, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setDisplayname(ChatColor.GOLD + "Wither töten beendet die Challenge").setLore("Click / Set").build());
        gui.setItem(20, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Ultra Hardcore").setLore("Click / Set").build());
        gui.setItem(21, new ItemBuilder(Material.TIPPED_ARROW).setDisplayname(ChatColor.GOLD + "Split Hearts").setLore("Click / Set").build());
        gui.setItem(22, new ItemBuilder(Material.CREEPER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Schadensnachricht").setLore("Click / Set").build());
        gui.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setDisplayname(ChatColor.GOLD + "Sterben erlaubt").setLore("Click / Set").build());
        gui.setItem(24, new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname(ChatColor.GOLD + "No Crafting Table").setLore("Click / Set").build());
        gui.setItem(25, new ItemBuilder(Material.PISTON).setDisplayname(ChatColor.GOLD + "No Sneaking").setLore("Click / Set").build());

    }


}
