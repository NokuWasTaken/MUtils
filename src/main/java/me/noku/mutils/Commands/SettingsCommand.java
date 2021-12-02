package me.noku.mutils.Commands;

import me.noku.mutils.GUI.MainMenu;
import me.noku.mutils.GUI.SettingsMenu;
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
                MainMenu.MainGUIGenerator();
                player.openInventory(MainMenu.gui);
            } else if (args.length == 1) {
                switch (args[0]) {
                    case "settings" :
                        SettingsMenu.SettingsGenerator();
                        player.openInventory(SettingsMenu.gui);
                        break;

                }
            }

        }

        return false;
    }
}
