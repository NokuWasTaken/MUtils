package me.noku.mutils.GUI;

import me.noku.mutils.MUtils;
import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class SettingsMenu {

    public static Inventory gui = Bukkit.createInventory(null, 36, ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD + "Settings");
    public static Inventory gui2 = Bukkit.createInventory(null, 36, ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD + "Settings" + ChatColor.GRAY + " Seite 2");

    public static void SettingsGenerator () {

        for(int i = 0; i <= 35; i++) {
            gui.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }

        gui.setItem(0,  new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").addCustomModelData(2).build());

            //target EnderDragon
        if (MUtils.getInstance().getConfig().getBoolean("target.enderDragon")) {
            gui.setItem(10, new ItemBuilder(Material.DRAGON_HEAD).setDisplayname(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("target.enderDragon")) {
            gui.setItem(10, new ItemBuilder(Material.DRAGON_HEAD).setDisplayname(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge").setLore("Click / Set").addCustomModelData(3).build());
        }
            //target Wither
        if (MUtils.getInstance().getConfig().getBoolean("target.wither")) {
            gui.setItem(19, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setDisplayname(ChatColor.GOLD + "Wither töten beendet die Challenge").addCustomModelData(2).setLore("Click / Set").build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("target.wither")) {
            gui.setItem(19, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setDisplayname(ChatColor.GOLD + "Wither töten beendet die Challenge").addCustomModelData(3).setLore("Click / Set").build());
        }
            // ultrahardcore
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.ultraHardCore")) {
            gui.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Hardcore").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.ultraHardCore")) {
            gui.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Hardcore").setLore("Click / Set").addCustomModelData(3).build());
        }
            //ultraultraHardCore
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.ultraUltraHardCore")) {
            gui.setItem(20, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Ultra Hardcore").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.ultraUltraHardCore")) {
            gui.setItem(20, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Ultra Hardcore").setLore("Click / Set").addCustomModelData(3).build());
        }
            //Damage Multiplier
            gui.setItem(12, new ItemBuilder(Material.NETHERITE_AXE).setDisplayname(ChatColor.GOLD + "Damage Multiplier").setLore("Click / +1").addCustomModelData(2).build());

            //Herzen in Tablist
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.lifeScoreTab")) {
            gui.setItem(13, new ItemBuilder(Material.FLOWER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Herzen in Tablist").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.lifeScoreTab")) {
            gui.setItem(13, new ItemBuilder(Material.FLOWER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Herzen in Tablist").setLore("Click / Set").addCustomModelData(3).build());
        }
            //Schutzzeit
        gui.setItem(14, new ItemBuilder(Material.TOTEM_OF_UNDYING).setDisplayname(ChatColor.GOLD + "Schutzzeit").setLore("Click / +5").addCustomModelData(2).build());

            //noXP
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.noXP")) {
            gui.setItem(15, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayname(ChatColor.GOLD + "No XP").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noXP")) {
            gui.setItem(15, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayname(ChatColor.GOLD + "No XP").setLore("Click / Set").addCustomModelData(3).build());
        }
            //noJump
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.noJump")) {
            gui.setItem(16, new ItemBuilder(Material.ENDER_PEARL).setDisplayname(ChatColor.GOLD + "No Jumping").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noJump")) {
            gui.setItem(16, new ItemBuilder(Material.ENDER_PEARL).setDisplayname(ChatColor.GOLD + "No Jumping").setLore("Click / Set").addCustomModelData(3).build());
        }
            //SplitHearts
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
            gui.setItem(21, new ItemBuilder(Material.TIPPED_ARROW).setDisplayname(ChatColor.GOLD + "Split Hearts").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
            gui.setItem(21, new ItemBuilder(Material.TIPPED_ARROW).setDisplayname(ChatColor.GOLD + "Split Hearts").setLore("Click / Set").addCustomModelData(3).build());
        }
            //Schadens Nachricht
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
            gui.setItem(22, new ItemBuilder(Material.CREEPER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Schadensnachricht").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
            gui.setItem(22, new ItemBuilder(Material.CREEPER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Schadensnachricht").setLore("Click / Set").addCustomModelData(3).build());
        }
            //sterben erlaubt
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setDisplayname(ChatColor.GOLD + "Sterben erlaubt").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setDisplayname(ChatColor.GOLD + "Sterben erlaubt").setLore("Click / Set").addCustomModelData(3).build());
        }
            //NoCrafting
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(24, new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname(ChatColor.GOLD + "No Crafting Table").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(24, new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname(ChatColor.GOLD + "No Crafting Table").setLore("Click / Set").addCustomModelData(3).build());
        }
            //NoSneak
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(25, new ItemBuilder(Material.PISTON).setDisplayname(ChatColor.GOLD + "No Sneaking").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
            gui.setItem(25, new ItemBuilder(Material.PISTON).setDisplayname(ChatColor.GOLD + "No Sneaking").setLore("Click / Set").addCustomModelData(3).build());
        }
            //NextSite
        gui.setItem(35, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Seite 2").setLore("Click / Open").addCustomModelData(2).build());


        for(int i = 0; i <= 35; i++) {
            gui2.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("").build());
        }
            //zurück
        gui2.setItem(0,  new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Zurück").setLore("Click / Open").addCustomModelData(2).build());
            //noFallDamage
        if (MUtils.getInstance().getConfig().getBoolean("gamerule.noFallDamage")) {
            gui2.setItem(10, new ItemBuilder(Material.FEATHER).setDisplayname(ChatColor.GOLD + "Fallschaden erlaubt").setLore("Click / Set").addCustomModelData(2).build());
        } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noFallDamage")) {
            gui2.setItem(10, new ItemBuilder(Material.FEATHER).setDisplayname(ChatColor.GOLD + "Fallschaden erlaubt").setLore("Click / Set").addCustomModelData(3).build());
        }
            //BackSite
        gui2.setItem(27, new ItemBuilder(Material.SPRUCE_DOOR).setDisplayname(ChatColor.GOLD + "Seite 1").setLore("Click / Open").addCustomModelData(2).build());

    }
}
