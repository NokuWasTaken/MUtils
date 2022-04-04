package me.noku.mutils.UTils;

import me.noku.mutils.MUtils;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;

public class UTils {
    public void command (String command, CommandExecutor executor) {
        MUtils.getInstance().getCommand(command).setExecutor(executor);
    }

    public void event (Listener listener, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public void log (String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public void broadcast (String msg) {
        Bukkit.broadcastMessage(msg);
    }

    public void sendTitle (String title, String subtitle, int fadein, int stay, int fadeout) {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            allPlayer.sendTitle(title, subtitle, fadein, stay, fadeout);
        }
    }


    public void DelWorld() {
        File world = new File("world");
        File nether = new File("world_nether");
        File end = new File("world_the_end");

        try {
            MUtils.getInstance().getServer().unloadWorld("world", false);
            FileUtils.deleteDirectory(world);
            log(ChatColor.GRAY + "[  " + ChatColor.GOLD + "world" + ChatColor.GRAY + " ]" + ChatColor.GREEN + " Deleted Succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MUtils.getInstance().getServer().unloadWorld("world_nether", false);
            FileUtils.deleteDirectory(nether);
            log(ChatColor.GRAY + "[  " + ChatColor.GOLD + "nether" + ChatColor.GRAY + " ]" + ChatColor.GREEN + " Deleted Succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MUtils.getInstance().getServer().unloadWorld("world_the_end", false);
            FileUtils.deleteDirectory(end);
            log(ChatColor.GRAY + "[  " + ChatColor.GOLD + "end" + ChatColor.GRAY + " ]" + ChatColor.GREEN + " Deleted Succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
