package io.github.thatsmusic99.headsplus.api.events;

import io.github.thatsmusic99.headsplus.api.Head;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerHeadDropEvent extends EntityHeadDropEvent {

    // M
    private static final HandlerList handlers = new HandlerList();
    private final Player deadPlayer;

    public PlayerHeadDropEvent(Player deadPlayer, Player killer, Head head, Location location, int amount) {
        super(killer, head, location, EntityType.PLAYER, amount);
        this.deadPlayer = deadPlayer;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getDeadPlayer() {
        return deadPlayer;
    }
}
