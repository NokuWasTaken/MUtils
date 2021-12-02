package me.noku.mutils.UTils;

import me.noku.mutils.MUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Timer {

    private boolean running;
    private int time;

    public Timer () {

        this.running = false;
        if (MUtils.getInstance().getConfig().contains("timer.time")) {
            this.time = MUtils.getInstance().getConfig().getInt("timer.time");
        } else {
            this.time = 0;
        }
        run();
    }

    public boolean isRunning () { return running; }

    public void setRunning (boolean running ) { this.running = running; }

    public String getTime () {

        int seconds = time % 60;
        int minutes = (time / 60) % 60;
        int hours = time / 60 / 60;
        return  hours + " : " + minutes + " : " + seconds;

    }

    public void setTime (int time) { this.time = time;}

    public void sendActionBar () {

        for (Player allplayer : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                allplayer.sendActionBar( ChatColor.GRAY +  "<< " + ChatColor.RED + "Timer pausiert" + ChatColor.GRAY + " >>");

                continue;
            }
        allplayer.sendActionBar(ChatColor.GRAY + "<< " + ChatColor.GOLD  + ChatColor.BOLD + ChatColor.ITALIC +   getTime() + ChatColor.RESET + ChatColor.GRAY + " >>" );


        }
    }

    public void save () {

        MUtils.getInstance().getConfig().set("timer.time", time);
        MUtils.getInstance().saveConfig();

    }

    private void run () {
        new BukkitRunnable () {
            @Override
            public void run () {
                sendActionBar();

                if (!isRunning()) {
                    return;
                }

                setTime(time + 1);
                save();
            }
        }.runTaskTimer(MUtils.getInstance(), 20, 20);
    }

}
