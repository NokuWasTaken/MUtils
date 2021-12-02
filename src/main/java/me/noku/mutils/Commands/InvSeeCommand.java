package me.noku.mutils.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class InvSeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            if (args.length == 1) {
                String name = args[0];
                Player target = Bukkit.getPlayer(name);
                Player player = (Player) sender;
                player.openInventory(target.getInventory());
            }
        }
        return false;
    }
}
