package me.noku.mutils.Commands;

import me.noku.mutils.GUI.SettingsMenu;
import me.noku.mutils.MUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SettingsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                SettingsMenu.SettingsGenerator();
                player.openInventory(SettingsMenu.gui);
            } else if (args.length == 1) {
                if (args[0].equals("1")) {
                    SettingsMenu.SettingsGenerator();
                    player.openInventory(SettingsMenu.gui);
                }else if (args[0].equals("2")) {
                    SettingsMenu.SettingsGenerator();
                    player.openInventory(SettingsMenu.gui2);
                }
            } else {
                player.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/Settings" + ChatColor.GRAY + " <" + ChatColor.AQUA + "1/2" + ChatColor.GRAY + ">");
            }

        }
        return false;
    }
}
