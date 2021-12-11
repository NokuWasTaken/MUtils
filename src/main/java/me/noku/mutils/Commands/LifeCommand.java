package me.noku.mutils.Commands;

import me.noku.mutils.GUI.LifeMenu;
import me.noku.mutils.MUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LifeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                LifeMenu.LifeGenerator();
                player.openInventory(LifeMenu.gui);
            } else {
                sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/Life");
            }
        } else {
            sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Du musst ein" + ChatColor.AQUA + " Spieler " + ChatColor.RED + "sein um diesen Command auszuführen");
        }
        return false;
    }
}

