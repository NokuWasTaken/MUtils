package me.noku.mutils.Commands;


import me.noku.mutils.MUtils;
import me.noku.mutils.UTils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        for (Player pp : Bukkit.getOnlinePlayers()) {
            switch (args[0]) {
                case "resume":
                    Timer timer = MUtils.getInstance().getTimer();
                    if (!timer.isRunning()) {
                        timer.setRunning(true);
                        pp.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde gestartet");
                        MUtils.getInstance().ProtTime();
                    }
                    break;
                case "pause":
                    Timer timer2 = MUtils.getInstance().getTimer();
                    if (timer2.isRunning()) {
                        timer2.setRunning(false);
                        pp.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde pausiert");
                    }
                    break;
                case "reset":
                    Timer timer3 = MUtils.getInstance().getTimer();
                    timer3.setTime(0);
                    timer3.setRunning(false);
                    pp.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde Zurückgesetzt");
                    break;
                case "set":
                    Timer timer4 = MUtils.getInstance().getTimer();
                    if (args.length == 2) {
                        timer4.setTime(Integer.parseInt(args[1]));
                        timer4.setRunning(false);
                        pp.sendMessage(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde auf " + ChatColor.AQUA + args[1] + ChatColor.GOLD + " Gesetzt");
                    }
                    break;


            }



        }

        return false;
    }
}
