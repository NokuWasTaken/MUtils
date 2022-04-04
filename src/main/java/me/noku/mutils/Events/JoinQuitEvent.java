package me.noku.mutils.Events;


import me.noku.mutils.MUtils;
import org.bukkit.Bukkit;
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
        if (Bukkit.getOnlinePlayers().size() == 1) {
            MUtils.getInstance().getTimer().setRunning(false);
            MUtils.getInstance().getUtils().broadcast(MUtils.MainPrefix() + ChatColor.GOLD + "Der Timer wurde gestoppt, da kein Spieler online war");
        }
    }
}
