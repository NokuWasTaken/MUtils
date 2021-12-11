package me.noku.mutils.Commands.TimeCommands;

import me.noku.mutils.MUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.getWorld().setTime(0);
            } else {
                sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/Night");
            }
        } else {
            sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Du musst ein" + ChatColor.AQUA + " Spieler " + ChatColor.RED + "sein um diesen Command auszuführen");
        }


        return false;
    }
}
