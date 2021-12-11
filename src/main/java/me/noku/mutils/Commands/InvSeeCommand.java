package me.noku.mutils.Commands;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
            Player player = (Player) sender;
            if (args.length == 1) {
                String name = args[0];
                Player target = Bukkit.getPlayer(name);

                player.openInventory(target.getInventory());
            } else {
                player.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage " + ChatColor.GOLD + "/Invsee : " + ChatColor.GRAY + "<" + ChatColor.AQUA + "Player" + ChatColor.GRAY + ">");
            }
        }
        return false;
    }
}
