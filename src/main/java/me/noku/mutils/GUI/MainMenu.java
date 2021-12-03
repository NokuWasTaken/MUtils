package me.noku.mutils.GUI;

import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class MainMenu {

    public static Inventory gui = Bukkit.createInventory( null, 45, ChatColor.GRAY + ">> "+ ChatColor.GOLD + ChatColor.BOLD + "MUtils" );

    public static void MainGUIGenerator() {

        //placeholder

        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholder_meta = placeholder.getItemMeta();
        placeholder_meta.setDisplayName("");
        placeholder.setItemMeta(placeholder_meta);

        //version

        ItemStack version = new ItemStack(Material.NETHER_STAR);
        ItemMeta version_Meta = version.getItemMeta();
        version_Meta.setDisplayName(ChatColor.GOLD + "MUtils " + ChatColor.WHITE + "v " + ChatColor.DARK_PURPLE + "1.0");
        ArrayList<String> version_Lore = new ArrayList<>();
        version_Lore.add(ChatColor.AQUA + "Dev build");
        version_Meta.setLore(version_Lore);
        version.setItemMeta(version_Meta);

        //menüs

        //settings menü

        ItemStack openSettings = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta openSettings_Meta = openSettings.getItemMeta();
        openSettings_Meta.setDisplayName(ChatColor.GOLD + "Settings");
        ArrayList<String> openSettings_lore = new ArrayList<>();
        openSettings_lore.add(ChatColor.GRAY + "Click / open");
        openSettings_Meta.setLore(openSettings_lore);
        openSettings.setItemMeta(openSettings_Meta);

        // Leben menü

        ItemStack openHealth = new ItemStack(Material.RED_DYE);
        ItemMeta openHealth_Meta = openHealth.getItemMeta();
        openHealth_Meta.setDisplayName(ChatColor.RED + "Life");
        ArrayList<String> openHealth_Lore = new ArrayList<>();
        openHealth_Lore.add(ChatColor.GRAY + "Click / open");
        openHealth_Meta.setLore(openHealth_Lore);
        openHealth.setItemMeta(openHealth_Meta);

        //challenge menü

        ItemStack openChallenges = new ItemStack(Material.CONDUIT);
        ItemMeta openChallenges_Meta = openChallenges.getItemMeta();
        openChallenges_Meta.setDisplayName(ChatColor.DARK_PURPLE + "Challenges");
        ArrayList<String> openChallenges_Lore = new ArrayList<>();
        openChallenges_Lore.add(ChatColor.GRAY + "Click / open");
        openChallenges_Meta.setLore(openChallenges_Lore);
        openChallenges.setItemMeta(openChallenges_Meta);

        //platzierung

        for (int i = 0; i <= 44; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(13, new ItemBuilder(Material.NETHER_STAR).setDisplayname(ChatColor.GOLD + "MUtils " + ChatColor.AQUA + "v1.2").build());
        gui.setItem(28, new ItemBuilder(Material.CONDUIT).setDisplayname(ChatColor.DARK_PURPLE + "Challenges").setLore("Click / Open").build());
        gui.setItem(30, new ItemBuilder(Material.COMMAND_BLOCK).setDisplayname(ChatColor.GOLD + "Settings").setLore("Click / Open").build());
        gui.setItem(32, new ItemBuilder(Material.CLOCK).setDisplayname(ChatColor.GREEN + "Timer").setLore("Click / Open").build());
        gui.setItem(34, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.RED + "Life").setLore("Click / Open").build());
    }

}
