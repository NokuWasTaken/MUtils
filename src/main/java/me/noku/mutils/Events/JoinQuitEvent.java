package me.noku.mutils.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitEvent implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GREEN + ">> " + ChatColor.GRAY + event.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + "<< " + ChatColor.GRAY + event.getPlayer().getDisplayName());
    }
}
