package me.noku.mutils.GUI;

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

        //Items

        //placeholder
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholder_meta = placeholder.getItemMeta();
        placeholder_meta.setDisplayName("");
        placeholder.setItemMeta(placeholder_meta);

        //targtets

        //enderdragon als target
        ItemStack targetEnderDragon = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta targetEnderDragon_Meta = targetEnderDragon.getItemMeta();
        targetEnderDragon_Meta.setDisplayName(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge");
        ArrayList<String> targetEnderDragon_Lore = new ArrayList<>();
        targetEnderDragon_Lore.add(ChatColor.GRAY + "Click / Toggle");
        targetEnderDragon_Meta.setLore(targetEnderDragon_Lore);
        targetEnderDragon.setItemMeta(targetEnderDragon_Meta);

        //Wither als target
        ItemStack targetWither = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta targetWither_Meta = targetWither.getItemMeta();
        targetWither_Meta.setDisplayName(ChatColor.GOLD + "Wither töten beendet die Challenge");
        ArrayList<String> targetWither_Lore = new ArrayList<>();
        targetWither_Lore.add(ChatColor.GRAY + "Click / Toggle");
        targetWither_Meta.setLore(targetWither_Lore);
        targetWither.setItemMeta(targetWither_Meta);

        //gamerules

        //UltraHardcore
        ItemStack ultraHardCore = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta ultraHardCore_Meta = ultraHardCore.getItemMeta();
        ultraHardCore_Meta.setDisplayName(ChatColor.GOLD + "Ultra Hardcore");
        ArrayList<String> ultraHardCore_Lore = new ArrayList<>();
        ultraHardCore_Lore.add(ChatColor.GRAY + "Click / Toggle");
        ultraHardCore_Meta.setLore(ultraHardCore_Lore);
        ultraHardCore.setItemMeta(ultraHardCore_Meta);

        //Ultra Ultra HardCore
        ItemStack ultraUltraHardCore = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta ultraUltaHardCore_Meta = ultraUltraHardCore.getItemMeta();
        ultraUltaHardCore_Meta.setDisplayName(ChatColor.GOLD + "Ultra Hardcore");
        ArrayList<String> ultraUltraHardCore_Lore = new ArrayList<>();
        ultraUltraHardCore_Lore.add(ChatColor.GRAY + "Click / Toggle");
        ultraUltaHardCore_Meta.setLore(ultraUltraHardCore_Lore);
        ultraUltraHardCore.setItemMeta(ultraUltaHardCore_Meta);

        //Damage Multiplikator
        ItemStack damageMultiplier = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta damageMultiplier_Meta = damageMultiplier.getItemMeta();
        damageMultiplier_Meta.setDisplayName(ChatColor.GOLD + "Damage Multiplier");
        ArrayList<String> damageMultiplier_Lore = new ArrayList<>();
        damageMultiplier_Lore.add(ChatColor.GRAY + " Click / + 1");
        damageMultiplier_Meta.setLore(damageMultiplier_Lore);
        damageMultiplier.setItemMeta(damageMultiplier_Meta);

        //Split Herzen
        ItemStack splitHearts = new ItemStack(Material.TIPPED_ARROW);
        ItemMeta splitHearts_Meta = splitHearts.getItemMeta();
        splitHearts_Meta.setDisplayName(ChatColor.GOLD + "Split Hearts");
        ArrayList<String> splitHeartS_Lore = new ArrayList<>();
        splitHeartS_Lore.add(ChatColor.GRAY + "Click / Toggle");
        splitHearts_Meta.setLore(splitHeartS_Lore);
        splitHearts.setItemMeta(splitHearts_Meta);

        //Herzen in Tablist
        ItemStack lifeScoreTab = new ItemStack(Material.FLOWER_BANNER_PATTERN);
        ItemMeta lifeScoreTab_Meta = lifeScoreTab.getItemMeta();
        lifeScoreTab_Meta.setDisplayName(ChatColor.GOLD + "Herzen in Tablist");
        ArrayList<String> lifeScoreTab_Lore = new ArrayList<>();
        lifeScoreTab_Lore.add(ChatColor.GRAY + "Click / Toggle");
        lifeScoreTab_Meta.setLore(lifeScoreTab_Lore);
        lifeScoreTab.setItemMeta(lifeScoreTab_Meta);

        //Damage im Chat
        ItemStack damageMessage = new ItemStack(Material.CREEPER_BANNER_PATTERN);
        ItemMeta damageMessage_Meta = damageMessage.getItemMeta();
        damageMessage_Meta.setDisplayName(ChatColor.GOLD + "Schadensnachricht");
        ArrayList<String> damageMessage_Lore = new ArrayList<>();
        damageMessage_Lore.add(ChatColor.GRAY + "Click / Toggle");
        damageMessage_Meta.setLore(damageMessage_Lore);
        damageMessage.setItemMeta(damageMessage_Meta);

        //Schutzzeit
        ItemStack prottime = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta prottime_Meta = prottime.getItemMeta();
        prottime_Meta.setDisplayName(ChatColor.GOLD + "Schutzzeit");
        ArrayList<String> prottime_Lore = new ArrayList<>();
        prottime_Lore.add(ChatColor.GRAY + "Click / + 5 Min");
        prottime_Meta.setLore(prottime_Lore);
        prottime.setItemMeta(prottime_Meta);

        //Sterben erlauben
        ItemStack allowDie = new ItemStack(Material.RESPAWN_ANCHOR);
        ItemMeta allowDie_Meta = allowDie.getItemMeta();
        allowDie_Meta.setDisplayName(ChatColor.GOLD + "Sterben erlaubt");
        ArrayList<String> allowDie_Lore = new ArrayList<>();
        allowDie_Lore.add(ChatColor.GRAY + "Click / Toggle");
        allowDie_Meta.setLore(allowDie_Lore);
        allowDie.setItemMeta(allowDie_Meta);

        //Zurück

        ItemStack back = new ItemStack(Material.SPRUCE_DOOR);
        ItemMeta back_Meta = back.getItemMeta();
        back_Meta.setDisplayName(ChatColor.GOLD + "Zurück");
        ArrayList<String> back_Lore = new ArrayList<>();
        back_Lore.add(ChatColor.GRAY + "Click / Back");
        back_Meta.setLore(back_Lore);
        back.setItemMeta(back_Meta);


        //Platzierung der Items
        for(int i = 0; i <= 35; i++) {
            gui.setItem(i, placeholder);
        }

        gui.setItem(0, back);
        gui.setItem(10, targetEnderDragon);
        gui.setItem(11, ultraHardCore );
        gui.setItem(12, damageMultiplier);
        gui.setItem(13, lifeScoreTab);
        gui.setItem(14, prottime);
        gui.setItem(19, targetWither);
        gui.setItem(20, ultraUltraHardCore);
        gui.setItem(21, splitHearts);
        gui.setItem(22, damageMessage);
        gui.setItem(23, allowDie);

    }


}
