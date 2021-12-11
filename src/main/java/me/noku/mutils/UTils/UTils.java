package me.noku.mutils.UTils;

import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

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
}
