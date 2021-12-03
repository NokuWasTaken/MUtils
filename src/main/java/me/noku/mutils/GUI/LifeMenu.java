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

        //PlaceHolder
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholder_meta = placeholder.getItemMeta();
        placeholder_meta.setDisplayName("");
        placeholder.setItemMeta(placeholder_meta);

        //Zurück
        ItemStack back = new ItemStack(Material.SPRUCE_DOOR);
        ItemMeta back_Meta = back.getItemMeta();
        back_Meta.setDisplayName(ChatColor.GOLD + "Zurück");
        ArrayList<String> back_Lore = new ArrayList<>();
        back_Lore.add(ChatColor.GRAY + "Click / Back");
        back_Meta.setLore(back_Lore);
        back.setItemMeta(back_Meta);

        //Double Life

        ItemStack DoubleLife = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta DoubleLife_Meta = DoubleLife.getItemMeta();
        DoubleLife_Meta.setDisplayName(ChatColor.GOLD + "Double Lifes");
        ArrayList<String> DoubleLife_Lore = new ArrayList<>();
        DoubleLife_Lore.add(ChatColor.GRAY + "Click / Set");
        DoubleLife_Meta.setLore(DoubleLife_Lore);
        DoubleLife.setItemMeta(DoubleLife_Meta);

        //Normal Life

        ItemStack NormalLife = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta NormalLife_Meta = NormalLife.getItemMeta();
        NormalLife_Meta.setDisplayName(ChatColor.GOLD + "Normal Lifes");
        ArrayList<String> NormalLife_Lore = new ArrayList<>();
        NormalLife_Lore.add(ChatColor.GRAY + "Click / Set");
        NormalLife_Meta.setLore(NormalLife_Lore);
        NormalLife.setItemMeta(NormalLife_Meta);

        //Half Life

        ItemStack HalfLife = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta HalfLife_Meta = HalfLife.getItemMeta();
        HalfLife_Meta.setDisplayName(ChatColor.GOLD + "Half Lifes");
        ArrayList<String> HalfLife_Lore = new ArrayList<>();
        HalfLife_Lore.add(ChatColor.GRAY + "Click / Set");
        HalfLife_Meta.setLore(HalfLife_Lore);
        HalfLife.setItemMeta(HalfLife_Meta);

        //One Life

        ItemStack OneLife = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta OneLife_Meta = OneLife.getItemMeta();
        OneLife_Meta.setDisplayName(ChatColor.GOLD + "One Life");
        ArrayList<String> OneLife_Lore = new ArrayList<>();
        OneLife_Lore.add(ChatColor.GRAY + "Click / Set");
        OneLife_Meta.setLore(OneLife_Lore);
        OneLife.setItemMeta(OneLife_Meta);

        //Heal

        ItemStack Heal = new ItemStack(Material.RED_DYE);
        ItemMeta Heal_Meta = Heal.getItemMeta();
        Heal_Meta.setDisplayName(ChatColor.GOLD + "Heal");
        ArrayList<String> Heal_Lore = new ArrayList<>();
        Heal_Lore.add(ChatColor.GRAY + "Click / Heal");
        Heal_Meta.setLore(Heal_Lore);
        Heal.setItemMeta(Heal_Meta);

        //+1 HP

        ItemStack PlusHP = new ItemStack(Material.PURPLE_DYE);
        ItemMeta PlusHP_Meta = PlusHP.getItemMeta();
        PlusHP_Meta.setDisplayName(ChatColor.GOLD + "+ 1 HP");
        ArrayList<String> PlusHP_Lore = new ArrayList<>();
        PlusHP_Lore.add(ChatColor.GRAY + "Click / Set");
        PlusHP_Meta.setLore(PlusHP_Lore);
        PlusHP.setItemMeta(PlusHP_Meta);

        //- 1 HP

        ItemStack MinusHP = new ItemStack(Material.PURPLE_DYE);
        ItemMeta MinusHP_Meta = MinusHP.getItemMeta();
        MinusHP_Meta.setDisplayName(ChatColor.GOLD + "- 1 HP");
        ArrayList<String> MinusHP_Lore = new ArrayList<>();
        MinusHP_Lore.add(ChatColor.GRAY + "Click / Set");
        MinusHP_Meta.setLore(MinusHP_Lore);
        MinusHP.setItemMeta(MinusHP_Meta);

        //Platzierung der Items

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
