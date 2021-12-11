package me.noku.mutils.Commands;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.MUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MUtilsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                MainMenu.MainGUIGenerator();
                player.openInventory(MainMenu.gui);
            } else {
                player.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/MUtils");
            }
        }
        return false;
    }
}
