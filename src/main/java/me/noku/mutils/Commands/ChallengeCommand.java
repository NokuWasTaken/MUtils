package me.noku.mutils.Commands;

import me.noku.mutils.GUI.ChallengeMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChallengeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                ChallengeMenu.InventoryBuilder();
                player.openInventory(ChallengeMenu.gui);

            }
        }
        return false;
    }
}
