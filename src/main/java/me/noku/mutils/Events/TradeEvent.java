package me.noku.mutils.Events;

import io.papermc.paper.event.player.PlayerTradeEvent;
import me.noku.mutils.MUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TradeEvent implements Listener {
    @EventHandler
    public void onTrade (PlayerTradeEvent event) {
        Player player = event.getPlayer();
        if (MUtils.getInstance().getTimer().isRunning()) {
            if (MUtils.getInstance().getConfig().getBoolean("gamerule.noTrading")) {
                player.setHealth(0);
            }
        }
    }
}
