package me.noku.mutils;

import me.noku.mutils.Commands.*;
import me.noku.mutils.Events.*;
import me.noku.mutils.GUIHandler.*;
import me.noku.mutils.UTils.Timer;
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

    public static String MainPrefix() {
        return ChatColor.GOLD + "MUtils" + ChatColor.GRAY + " | " + ChatColor.GRAY;
    }

    public static String DamagePrefix() {
        return ChatColor.DARK_RED + "Damage" + ChatColor.GRAY + " | " + ChatColor.GRAY;
    }

    public static String DeathPrefix() {
        return ChatColor.RED + "Tod" + ChatColor.GRAY + " | " + ChatColor.GRAY;
    }

    public static String TimerPrefix() {
        return ChatColor.GOLD + "Timer" + ChatColor.GRAY + " | " + ChatColor.GRAY;
    }

    public static String WinPrefix() {
        return ChatColor.GOLD + "Geschafft" + ChatColor.GRAY + " | " + ChatColor.GRAY;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        boot();
        saveDefaultConfig();
        CommandRegistry();
        EventRegistry();
        timer = new Timer();
    }

    @Override
    public void onDisable() {
        timer.setRunning(false);
        timer.save();
        saveConfig();
    }

    public void CommandRegistry() {
        getCommand("MUtils").setExecutor(new MUtilsCommand());
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("life").setExecutor(new LifeCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("invsee").setExecutor(new InvSeeCommand());
    }

    public void EventRegistry() {
        Bukkit.getPluginManager().registerEvents(new JoinQuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MainMenuHandler(), this);
        Bukkit.getPluginManager().registerEvents(new SettingsMenuHandler(), this);
        Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EntityregainHealtEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LifeMenuHandler(), this);
        Bukkit.getPluginManager().registerEvents(new TimerMenuHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJumpEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerSneakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new GainXPEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CraftItemEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ChallengeMenuHandler(), this);
        Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
    }

    public void Deathevent(String Time, String deathPlayer) {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            timer.setRunning(false);
            if (allPlayer.getGameMode() != GameMode.CREATIVE) {
                allPlayer.setGameMode(GameMode.SPECTATOR);
            }
            allPlayer.sendMessage(ChatColor.GOLD + "-----------------------------------\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.AQUA + deathPlayer + ChatColor.GOLD + " ist Gestorben\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.GOLD + "Die Challenge ist hiermit beendet\n" +
                    " \n" +
                    DeathPrefix() + ChatColor.GOLD + "Zeit Verschwendet: " + ChatColor.RED + Time + "\n" +
                    " \n" +
                    ChatColor.GOLD + "-----------------------------------"
            );
        }
    }

    public void KillTargetEvent(String Time, String Target) {
        timer.setRunning(false);

        if (Target == "EnderDragon") {
            for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                allPlayer.sendMessage(ChatColor.GOLD + "-----------------------------------\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Der " + ChatColor.AQUA + "EnderDragon" + ChatColor.GOLD + "wurde getötet\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Die Challenge wurde abgeschlossen\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Zeit benötigt: " + ChatColor.BLUE + Time + "\n" +
                        " \n" +
                        ChatColor.GOLD + "-----------------------------------");
            }

        } else if (Target == "Wither") {
            for (Player allPLayer : Bukkit.getOnlinePlayers()) {
                allPLayer.sendMessage(ChatColor.GOLD + "-----------------------------------\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Der " + ChatColor.AQUA + "Wither" + ChatColor.GOLD + "wurde getötet\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Die Challenge wurde abgeschlossen\n" +
                        " \n" +
                        WinPrefix() + ChatColor.GOLD + "Zeit benötigt : " + ChatColor.BLUE + Time + "\n" +
                        " \n" +
                        ChatColor.GOLD + "-----------------------------------");
            }
        }
    }

    public void boot() {
        log("--------------------------\n" +
                "       MUtils v1.0 (Beta)    \n" +
                "            by NokuHD        \n" +
                "    --------------------------");

    }

    public void log(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
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

    public Timer getTimer() {
        return timer;
    }


}
