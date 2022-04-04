package me.noku.mutils.Commands;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class ResetCommand implements CommandExecutor {

    boolean confirm;

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 0) {
            sender.sendMessage(MUtils.ResetPrefix() + ChatColor.RED + "Bist du sicher dass du die Welten resetten willst?");
            sender.sendMessage(MUtils.ResetPrefix() + ChatColor.GOLD + "wenn ja, nutze " + ChatColor.GRAY + "[  " + ChatColor.DARK_RED + "/reset confirm" + ChatColor.GRAY + "  ]");
            this.confirm = true;
        } else if (args.length == 1) {
            if (args[0].equals("confirm")) {
                if (this.confirm) {
                    sender.sendMessage(MUtils.ResetPrefix() + ChatColor.GOLD + "Die Welt wird resettet");
                    for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                        allPlayer.kickPlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Die Welt wird resettet");
                    }
                    MUtils.getInstance().getUtils().DelWorld();
                    MUtils.getInstance().getServer().shutdown();
                } else {
                    sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/reset");
                }
            } else {
                sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/reset");
            }
        } else {
            sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage : " + ChatColor.GOLD + "/reset");
        }

        return false;
    }
}
