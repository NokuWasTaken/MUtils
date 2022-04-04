package me.noku.mutils.Commands;


import me.noku.mutils.GUI.LifeMenu;
import me.noku.mutils.GUI.TimerMenu;
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
        if (args.length == 1) {
                switch (args[0]) {
                    default:
                        sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage " + ChatColor.GOLD + "/timer " + ChatColor.GRAY + "<" + ChatColor.AQUA + "resume/pause/reset/set" + ChatColor.GRAY + ">");
                        break;
                    case "resume":
                        Timer timer = MUtils.getInstance().getTimer();
                        if (!timer.isRunning()) {
                            timer.setRunning(true);
                            MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.GREEN + "gestartet");
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.GREEN + "gestartet", 5, 40, 5);
                            MUtils.getInstance().ProtTime();
                        }
                        break;
                    case "pause":
                        Timer timer2 = MUtils.getInstance().getTimer();
                        if (timer2.isRunning()) {
                            timer2.setRunning(false);
                            MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.RED + "pausiert");
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.RED + "pausiert", 5, 40, 5);

                        }
                        break;
                    case "reset":
                        Timer timer3 = MUtils.getInstance().getTimer();
                        timer3.setTime(0);
                        timer3.setRunning(false);
                        MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde " + ChatColor.DARK_RED + "zurückgesetzt");
                        MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "Timer", ChatColor.DARK_RED + "zurückgesetzt", 5, 40, 5);

                        break;
            }
        }else if (args.length == 2) {
            if (args[0].equals("set")) {
                Timer timer4 = MUtils.getInstance().getTimer();
                timer4.setTime(Integer.parseInt(args[1]));
                timer4.setRunning(false);
                MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der Timer wurde auf " + ChatColor.AQUA + args[1] + ChatColor.GOLD + " Gesetzt");
            } else if (args[0].equals("mode")) {
                switch (args[1]) {
                    case "normal":
                        if (!MUtils.getInstance().getConfig().getString("timer.mode").equals("normal")) {
                            MUtils.getInstance().getConfig().set("timer.mode", "normal");
                            MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der TimerMode wurde auf " + ChatColor.GRAY + "[ " + ChatColor.AQUA + "normal" + ChatColor.GRAY + " ]" + ChatColor.GOLD + " Gesetzt");
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "TimerMode", ChatColor.DARK_PURPLE + "normal", 5, 40, 5);

                        } else {
                            sender.sendMessage(MUtils.TimerPrefix() + ChatColor.GRAY + "[ " + ChatColor.DARK_RED + "Normal" + ChatColor.GRAY + " ]" + ChatColor.RED + "ist kein gültiger Parameter");
                        }
                        break;

                    case "backward":
                        if (!MUtils.getInstance().getConfig().getString("timer.mode").equals("backward")) {
                            MUtils.getInstance().getConfig().set("timer.mode", "backward");
                            MUtils.getInstance().getUtils().broadcast(MUtils.TimerPrefix() + ChatColor.GOLD + "Der TimerMode wurde auf " + ChatColor.GRAY + "[ " + ChatColor.AQUA + "backward" + ChatColor.GRAY + " ]" + ChatColor.GOLD + " Gesetzt");
                            MUtils.getInstance().getUtils().sendTitle(ChatColor.GOLD + "TimerMode", ChatColor.DARK_PURPLE + "backward", 5, 40, 5);

                        } else {
                            sender.sendMessage(MUtils.TimerPrefix() + ChatColor.GRAY + "[ " + ChatColor.DARK_RED + "backward" + ChatColor.GRAY + " ]" + ChatColor.RED + "ist kein gültiger Parameter");
                        }
                        break;
                }
            } else {
                sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage " + ChatColor.GOLD + "/timer " + ChatColor.GRAY +"<" + ChatColor.AQUA + "resume/pause/reset/set" + ChatColor.GRAY + ">");
            }

        }else if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                TimerMenu.InventoryBuilder();
                player.openInventory(TimerMenu.gui);
            } else {
                sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Du musst ein" + ChatColor.AQUA + " Spieler " + ChatColor.RED + "sein um diesen Command auszuführen");
            }
        }else {
            sender.sendMessage(MUtils.MainPrefix() + ChatColor.RED + "Usage " + ChatColor.GOLD + "/timer " + ChatColor.GRAY +"<" + ChatColor.AQUA + "resume/pause/reset/set" + ChatColor.GRAY + ">");
        }
        return false;
    }
}
