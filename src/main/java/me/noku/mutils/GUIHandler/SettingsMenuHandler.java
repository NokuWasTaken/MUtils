package me.noku.mutils.GUIHandler;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.GUI.SettingsMenu;
import me.noku.mutils.MUtils;
import me.noku.mutils.UTils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsMenuHandler implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().equals(ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD + "Settings")) {
                if (event.getCurrentItem() != null) {
                    if (event.getCurrentItem().getItemMeta() != null) {
                        event.setCancelled(true);

                        switch (event.getSlot()) {

                            //Zurück

                            case 0:
                                MainMenu.MainGUIGenerator();
                                player.openInventory(MainMenu.gui);
                                break;

                            //Targets

                            //Enderdragon als Target

                            case 10:
                                if (MUtils.getInstance().getConfig().getBoolean("target.enderDragon")) {
                                    MUtils.getInstance().getConfig().set("target.enderDragon", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(10, new ItemBuilder(Material.DRAGON_HEAD).setDisplayname(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Enderdragon töten beendet die Challenge nicht");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Target", ChatColor.DARK_PURPLE + "Nothing", 5, 40, 5);


                                } else if (!MUtils.getInstance().getConfig().getBoolean("target.enderDragon")) {
                                    MUtils.getInstance().getConfig().set("target.enderDragon", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(10, new ItemBuilder(Material.DRAGON_HEAD).setDisplayname(ChatColor.GOLD + "Enderdrachen töten beendet die Challenge").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Enderdragon töten beendet die Challenge");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Target", ChatColor.DARK_PURPLE + "EnderDragon", 5, 40, 5);

                                }
                                break;

                            //wither
                            case 19:

                                if (MUtils.getInstance().getConfig().getBoolean("target.wither")) {
                                    MUtils.getInstance().getConfig().set("target.wither", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(19, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setDisplayname(ChatColor.GOLD + "Wither töten beendet die Challenge").addCustomModelData(3).setLore("Click / Set").build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Wither töten beendet die Challenge nicht");
                                        MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Target", ChatColor.DARK_PURPLE + "Nothing", 5, 40, 5);
                                    }
                                } else if (!MUtils.getInstance().getConfig().getBoolean("target.wither")) {
                                    MUtils.getInstance().getConfig().set("target.wither", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(19, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setDisplayname(ChatColor.GOLD + "Wither töten beendet die Challenge").addCustomModelData(2).setLore("Click / Set").build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Wither töten beendet die Challenge");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Target", ChatColor.DARK_PURPLE + "Wither", 5, 40, 5);
                                }
                                break;

                            //gamerules

                            //ultrahardcore
                            case 11:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.ultraHardCore")) {
                                    MUtils.getInstance().getConfig().set("gamerule.ultraHardCore", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Hardcore").setLore("Click / Set").addCustomModelData(3).build());
                                    player.getWorld().setGameRule(GameRule.NATURAL_REGENERATION, true);
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "UltraHardcore deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "UltraHardCore", ChatColor.RED + "Deaktiviert", 5, 40, 5);

                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.ultraHardcore")) {
                                    MUtils.getInstance().getConfig().set("gamerule.ultraHardCore", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Hardcore").setLore("Click / Set").addCustomModelData(2).build());
                                    player.getWorld().setGameRule(GameRule.NATURAL_REGENERATION, false);
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "UltraHardcore aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "UltraHardCore", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;

                            //ultraultrahardcore
                            case 20:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.ultraUltraHardCore")) {
                                    MUtils.getInstance().getConfig().set("gamerule.ultraUltraHardCore", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(20, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Ultra Hardcore").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "UltraUltraHardcore deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "UltraUltraHardCore", ChatColor.RED + "Deaktiviert", 5, 40, 5);

                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.ultraHardcore")) {
                                    MUtils.getInstance().getConfig().set("gamerule.ultraUltraHardCore", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(20, new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname(ChatColor.GOLD + "Ultra Ultra Hardcore").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "UltraUltraHardcore aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "UltraUltraHardCore", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;

                            //Damage Multiplier
                            case 12:
                                if (MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier") < 5) {
                                    MUtils.getInstance().getConfig().set("gamerule.damageMultiplier", MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier") + 1);
                                    MUtils.getInstance().saveConfig();
                                } else if (MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier") == 5) {
                                    MUtils.getInstance().getConfig().set("gamerule.damageMultiplier", 1);
                                    MUtils.getInstance().saveConfig();
                                }
                                for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                    allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Damage Multiplier auf " + ChatColor.DARK_PURPLE + MUtils.getInstance().getConfig().getInt("gamerule.damageMultiplier") + ChatColor.GOLD + " gesetzt");
                                }
                                MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Damage Multiplier", ChatColor.DARK_PURPLE + MUtils.getInstance().getConfig().getString("gamerule.damageMultiplier"), 5, 40, 5);
                                break;

                            //Split Hearts
                            case 21:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
                                    MUtils.getInstance().getConfig().set("gamerule.splitHearts", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(21, new ItemBuilder(Material.TIPPED_ARROW).setDisplayname(ChatColor.GOLD + "Split Hearts").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Split Herzen deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Split Herzen", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.splitHearts")) {
                                    MUtils.getInstance().getConfig().set("gamerule.splitHearts", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(21, new ItemBuilder(Material.TIPPED_ARROW).setDisplayname(ChatColor.GOLD + "Split Hearts").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Split Herzen aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Split Herzen", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;

                            //Herzen in Tablist
                            case 13:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.lifeScoreTab")) {
                                    MUtils.getInstance().getConfig().set("gamerule.lifeScoreTab", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(13, new ItemBuilder(Material.FLOWER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Herzen in Tablist").setLore("Click / Set").addCustomModelData(3).build());
                                    player.performCommand("scoreboard objectives remove Life");
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Herzen in Tablist deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Herzen in Tab", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.lifeScoreTab")) {
                                    MUtils.getInstance().getConfig().set("gamerule.lifeScoreTab", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(13, new ItemBuilder(Material.FLOWER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Herzen in Tablist").setLore("Click / Set").addCustomModelData(2).build());
                                    player.performCommand("scoreboard objectives add Life health");
                                    player.performCommand("scoreboard objectives setdisplay list Life");
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Herzen in Tablist aktiviert");
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Falls die Herzen in der Tablist nicht angezeight werden, reconnecten");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Herzen in Tab", ChatColor.GREEN + "Aktiviert", 5, 40, 5);
                                }
                                break;

                            //Damage in Chat
                            case 22:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
                                    MUtils.getInstance().getConfig().set("gamerule.damageMessage", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(22, new ItemBuilder(Material.CREEPER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Schadensnachricht").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Damage im Chat deaktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Damage im Chat", ChatColor.RED + "Deaktiviert", 5, 40, 5);
                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.damageMessage")) {
                                    MUtils.getInstance().getConfig().set("gamerule.damageMessage", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(22, new ItemBuilder(Material.CREEPER_BANNER_PATTERN).setDisplayname(ChatColor.GOLD + "Schadensnachricht").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Damage im Chat aktiviert");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Damage im Chat", ChatColor.GREEN + "Aktiviert", 5, 40, 5);

                                }
                                break;

                            //Schutzzeit
                            case 14:
                                if (MUtils.getInstance().getConfig().getInt("gamerule.prottime") < 25) {
                                    MUtils.getInstance().getConfig().set("gamerule.prottime", MUtils.getInstance().getConfig().getInt("gamerule.prottime") + 5);
                                    MUtils.getInstance().saveConfig();
                                } else if (MUtils.getInstance().getConfig().getInt("gamerule.prottime") == 25) {
                                    MUtils.getInstance().getConfig().set("gamerule.prottime", 0);
                                    MUtils.getInstance().saveConfig();
                                }
                                for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                    allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GOLD + "Schutzzeit auf " + ChatColor.DARK_PURPLE + MUtils.getInstance().getConfig().getInt("gamerule.prottime") + " Minuten" + ChatColor.GOLD + " gesetzt");
                                }
                                MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Schutzzeit", ChatColor.DARK_PURPLE + MUtils.getInstance().getConfig().getString("gamerule.prottime"), 5, 40, 5);

                                break;

                            //Sterben erlaubt
                            case 23:
                                if (MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
                                    MUtils.getInstance().getConfig().set("gamerule.allowDie", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setDisplayname(ChatColor.GOLD + "Sterben erlaubt").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Sterben nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Sterben ", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (!MUtils.getInstance().getConfig().getBoolean("gamerule.allowDie")) {
                                    MUtils.getInstance().getConfig().set("gamerule.allowDie", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setDisplayname(ChatColor.GOLD + "Sterben erlaubt").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Sterben erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Sterben", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;

                            //noXP
                            case 15:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noXP")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noXP", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(15, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayname(ChatColor.GOLD + "No XP").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "XP nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "XP", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noXP")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noXP", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(15, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setDisplayname(ChatColor.GOLD + "No XP").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "XP erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "XP", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;

                            //noCrafting
                            case 24:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noCrafting")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noCrafting", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(24, new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname(ChatColor.GOLD + "No Crafting Table").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Crafting nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Crafting", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noCrafting")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noCrafting", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(24, new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname(ChatColor.GOLD + "No Crafting Table").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Crafting erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Crafting", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;

                            //noJumping
                            case 16:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noJumping")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noJumping", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(16, new ItemBuilder(Material.ENDER_PEARL).setDisplayname(ChatColor.GOLD + "No Jumping").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Springen nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Springen", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noJumping")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noJumping", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(16, new ItemBuilder(Material.ENDER_PEARL).setDisplayname(ChatColor.GOLD + "No Jumping").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Springen erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Sterben", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;

                            //noSneak
                            case 25:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noSneak")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noSneak", true);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(25, new ItemBuilder(Material.PISTON).setDisplayname(ChatColor.GOLD + "No Sneaking").setLore("Click / Set").addCustomModelData(3).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Sneaken nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Sneaken", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noSneak")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noSneak", false);
                                    MUtils.getInstance().saveConfig();
                                    SettingsMenu.gui.setItem(25, new ItemBuilder(Material.PISTON).setDisplayname(ChatColor.GOLD + "No Sneaking").setLore("Click / Set").addCustomModelData(2).build());
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Sneaken erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Sneaken", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;
                            case 35:
                                SettingsMenu.SettingsGenerator();
                                player.openInventory(SettingsMenu.gui2);
                                break;

                        }
                    }
                }
            }
            if (event.getView().getTitle().equals(ChatColor.GRAY + ">> " + ChatColor.GOLD + ChatColor.BOLD + "Settings" + ChatColor.GRAY + " Seite 2")) {
                if (event.getCurrentItem() != null) {
                    if (event.getCurrentItem().getItemMeta() != null) {
                        event.setCancelled(true);

                        switch (event.getSlot()) {
                            case 0:
                                MainMenu.MainGUIGenerator();
                                player.openInventory(MainMenu.gui);
                                break;
                            //fallschaden
                            case 10:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noFallDamage")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noFallDamage", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Fallschaden nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Fallschaden", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noFallDamage")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noFallDamage", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Falschaden erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Fallschaden", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;
                            //noTrading
                            case 19:
                                if (!MUtils.getInstance().getConfig().getBoolean("gamerule.noTrading")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noTrading", true);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Traden nicht erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Traden", ChatColor.RED + "nicht erlaubt", 5, 40, 5);

                                } else if (MUtils.getInstance().getConfig().getBoolean("gamerule.noTrading")) {
                                    MUtils.getInstance().getConfig().set("gamerule.noTrading", false);
                                    MUtils.getInstance().saveConfig();
                                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                                        allPlayer.sendMessage(MUtils.MainPrefix() + ChatColor.GREEN + "Traden erlaubt");
                                    }
                                    MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Traden", ChatColor.GREEN + "erlaubt", 5, 40, 5);

                                }
                                break;

                            case 27:
                                SettingsMenu.SettingsGenerator();
                                player.openInventory(SettingsMenu.gui);
                                break;
                        }




                    }
                }
            }
        }
    }
}
