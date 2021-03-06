package me.noku.mutils;

import me.noku.mutils.Commands.*;
import me.noku.mutils.Commands.TabCompletition.ResetCommandComplete;
import me.noku.mutils.Commands.TabCompletition.TimerCommandComplete;
import me.noku.mutils.Commands.TimeCommands.DayCommand;
import me.noku.mutils.Commands.TimeCommands.NightCommand;
import me.noku.mutils.Events.*;
import me.noku.mutils.GUIHandler.*;
import me.noku.mutils.UTils.Timer;
import me.noku.mutils.UTils.UTils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public final class MUtils extends JavaPlugin {

    private static MUtils instance;
    private Timer timer;
    private UTils utils;

    public static String MainPrefix() {
        return ChatColor.GOLD + "MUtils" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }
    public static String DamagePrefix() {
        return ChatColor.DARK_RED + "Damage" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }
    public static String DeathPrefix() {
        return ChatColor.RED + "Tod" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }
    public static String TimerPrefix() {
        return ChatColor.GOLD + "Timer" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }
    public static String WinPrefix() {
        return ChatColor.GOLD + "Win" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }
    public static String ResetPrefix () {
        return ChatColor.DARK_RED + "Reset" + ChatColor.BLACK + " | " + ChatColor.GRAY;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        boot();
    }

    @Override
    public void onDisable() {
        timer.setRunning(false);
        timer.save();
        saveConfig();
    }

    public void boot() {

        utils = new UTils();
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Utils Loaded");

        timer = new Timer();
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Timer loaded");

        instance = this;
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Main Instance loaded");

        saveDefaultConfig();
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Config loaded");

        CommandRegistry();
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Commands registered");

        EventRegistry();
        getUtils().log(MainPrefix() + ChatColor.GREEN + "Events registered");

        getUtils().log("--------------------------\n" +
                "                        MUtils v1.7.1        \n" +
                "                         by Noku          \n" +
                "                 --------------------------");
    }

    public void CommandRegistry() {
        getUtils().command("MUtils", new MUtilsCommand());
        getUtils().command("settings", new SettingsCommand());
        getUtils().command("life", new LifeCommand());
        getUtils().command("challenges", new ChallengeCommand());
        getUtils().command("invsee", new InvSeeCommand());
        getUtils().command("day", new DayCommand());
        getUtils().command("night", new NightCommand());
        getUtils().command("reset", new ResetCommand());
        getUtils().command("timer", new TimerCommand());

        getCommand("reset").setTabCompleter(new ResetCommandComplete());
        getCommand("timer").setTabCompleter(new TimerCommandComplete());
    }

    public void EventRegistry() {
        getUtils().event(new MainMenuHandler(), MUtils.getInstance());
        getUtils().event(new SettingsMenuHandler(), MUtils.getInstance());
        getUtils().event(new LifeMenuHandler(), MUtils.getInstance());
        getUtils().event(new TimerMenuHandler(), MUtils.getInstance());
        getUtils().event(new ChallengeMenuHandler(), MUtils.getInstance());
        getUtils().event(new InventoryClickEvent(), MUtils.getInstance());
        getUtils().event(new DamageEvent(), MUtils.getInstance());
        getUtils().event(new DeathEvent(), MUtils.getInstance());
        getUtils().event(new BlockPlaceBreakEvent(), MUtils.getInstance());
        getUtils().event(new EntityregainHealtEvent(), MUtils.getInstance());
        getUtils().event(new PlayerJumpEvent(), MUtils.getInstance());
        getUtils().event(new PlayerSneakEvent(), MUtils.getInstance());
        getUtils().event(new GainXPEvent(), MUtils.getInstance());
        getUtils().event(new CraftItemEvent(), MUtils.getInstance());
        getUtils().event(new MoveEvent(), MUtils.getInstance());
        getUtils().event(new JoinQuitEvent(), MUtils.getInstance());
        getUtils().event(new TradeEvent(), MUtils.getInstance());
    }


    public void Deathevent(String Time, String deathPlayer) {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            timer.setRunning(false);
            if (allPlayer.getGameMode() != GameMode.CREATIVE) {
                allPlayer.setGameMode(GameMode.SPECTATOR);
            }
            getUtils().broadcast(ChatColor.GOLD + "-----------------------------------\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.AQUA + deathPlayer + ChatColor.GOLD + " ist Gestorben\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.GOLD + "Die Challenge ist hiermit beendet\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.GOLD + "Zeit Verschwendet: " + ChatColor.RED + Time + "\n" +
                    " \n" +
                    ChatColor.GOLD + "-----------------------------------");

        }
    }

    public void TimeUpEvent() {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            timer.setRunning(false);
            if (allPlayer.getGameMode() != GameMode.CREATIVE) {
                allPlayer.setGameMode(GameMode.SPECTATOR);
            }
            getUtils().broadcast(ChatColor.GOLD + "-----------------------------------\n" +
                    " \n" +
                    TimerPrefix() + ChatColor.GOLD + " Der Timer Ist abgelaufen\n" +
                    " \n" +
                    TimerPrefix() + ChatColor.GOLD + "Die Challenge ist hiermit beendet\n" +
                    " \n" +
                    ChatColor.GOLD + "-----------------------------------");

        }
    }

    public void KillTargetEvent(String Time, String Target) {
        timer.setRunning(false);
        if (Target.equals("EnderDragon")) {
                getUtils().broadcast(ChatColor.GOLD + "-----------------------------------\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Der " + ChatColor.AQUA + "EnderDragon" + ChatColor.GOLD + "wurde get??tet\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Die Challenge wurde abgeschlossen\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Zeit ben??tigt: " + ChatColor.BLUE + Time + "\n" +
                        " \n" +
                        ChatColor.GOLD + "-----------------------------------");

        } else if (Target.equals("Wither")) {
                getUtils().broadcast(ChatColor.GOLD + "-----------------------------------\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Der " + ChatColor.AQUA + "Wither" + ChatColor.GOLD + "wurde get??tet\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Die Challenge wurde abgeschlossen\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Zeit ben??tigt : " + ChatColor.BLUE + Time + "\n" +
                        " \n" +
                        ChatColor.GOLD + "-----------------------------------");
        }
    }



    public void ProtTime() {
        if (getConfig().getInt("gamerule.protTime") != 0) {
            for (Player allplayer : Bukkit.getOnlinePlayers()) {
                allplayer.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, getConfig().getInt("gamerule.protTime"), 1, true));
            }
        }
    }

    public static MUtils getInstance() {
        return instance;
    }
    public UTils getUtils() {
        return utils;
    }
    public Timer getTimer() { return timer; }




}
