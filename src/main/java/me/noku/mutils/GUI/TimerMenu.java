package me.noku.mutils.GUI;

import me.noku.mutils.MUtils;
import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class TimerMenu {

    public static Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GRAY + ">> " + ChatColor.GOLD + "Timer");

    public static void InventoryBuilder () {
        for (int i = 0; i <=26; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(0, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").build());
        gui.setItem(10, new ItemBuilder(Material.GREEN_DYE).setDisplayname(ChatColor.GREEN + "Start").setLore("Click / Start").build());
        gui.setItem(12, new ItemBuilder(Material.RED_DYE).setDisplayname(ChatColor.RED + "Pause").setLore("Click / Pause").build());
        if (MUtils.getInstance().getConfig().getString("timer.mode").equals("normal")) {
            gui.setItem(14, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.DARK_PURPLE + "Mode").setLore(ChatColor.GRAY + "> " + ChatColor.GREEN + "normal", ChatColor.GRAY + "  backward").build());
        } else if (MUtils.getInstance().getConfig().getString("timer.mode").equals("backward")) {
            gui.setItem(14, new ItemBuilder(Material.PURPLE_DYE).setDisplayname(ChatColor.DARK_PURPLE + "Mode").setLore(ChatColor.GRAY + "   normal",  ChatColor.GRAY +" > " + ChatColor.GREEN + "backward").build());
        }
        gui.setItem(16, new ItemBuilder(Material.BLACK_DYE).setDisplayname(ChatColor.DARK_RED + "Reset").setLore("Click / Reset").build());
    }
}
