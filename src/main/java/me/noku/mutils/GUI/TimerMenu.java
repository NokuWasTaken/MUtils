package me.noku.mutils.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TimerMenu {

    public static Inventory gui = Bukkit.createInventory(null, 28, ChatColor.GRAY + ">> " + ChatColor.GOLD + "Timer");

    public void InventoryBuilder () {

        ItemStack placeHolder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeHolder_Meta = placeHolder.getItemMeta();
        placeHolder_Meta.setDisplayName("");
        placeHolder.setItemMeta(placeHolder_Meta);

        ItemStack back = new ItemStack(Material.SPRUCE_DOOR);
        ItemMeta back_Meta = back.getItemMeta();
        back_Meta.setDisplayName(ChatColor.GOLD + "Zurück");
        ArrayList<String> back_Lore = new ArrayList<>();
        back_Lore.add(ChatColor.GRAY + "Click / Back");
        back_Meta.setLore(back_Lore);
        back.setItemMeta(back_Meta);

        ItemStack timerStart = new ItemStack(Material.EMERALD);
        ItemMeta timerStart_Meta = timerStart.getItemMeta();
        timerStart_Meta.setDisplayName(ChatColor.GREEN + "Start");
        ArrayList<String> timerStart_Lore = new ArrayList<>();
        timerStart_Lore.add(ChatColor.GRAY + "Click / Start");
        timerStart_Meta.setLore(timerStart_Lore);
        timerStart.setItemMeta(timerStart_Meta);

        ItemStack timerPause = new ItemStack(Material.REDSTONE);
        ItemMeta timerPause_Meta = timerPause.getItemMeta();
        timerPause_Meta.setDisplayName(ChatColor.YELLOW + "Pause");
        ArrayList<String> timerPause_Lore = new ArrayList<>();
        timerPause_Lore.add(ChatColor.GRAY + "Click / Stop");
        timerPause_Meta.setLore(timerPause_Lore);
        timerPause.setItemMeta(timerPause_Meta);

        ItemStack timerReset = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta timerReset_Meta = timerReset.getItemMeta();
        timerReset_Meta.setDisplayName(ChatColor.DARK_RED + "Reset");
        ArrayList<String> timerReset_Lore = new ArrayList<>();
        timerReset_Lore.add(ChatColor.GRAY + "Click / Reset");
        timerReset.setItemMeta(timerReset_Meta);

        for (int i = 0; i <=27; i++) {
            gui.setItem(i, placeHolder);
        }

        gui.setItem(0, back);
        gui.setItem(10, timerStart);
        gui.setItem(13, timerPause);
        gui.setItem(16, timerReset);

    }
}
