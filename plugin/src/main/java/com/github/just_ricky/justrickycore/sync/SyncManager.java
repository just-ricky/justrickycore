package com.github.just_ricky.justrickycore.sync;

import com.github.just_ricky.justrickycore.sync.network.SyncRestHandler;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class SyncManager {

    /**
     * The sync handler
     */
    private final SyncHandler syncHandler;

    public SyncManager() {
        syncHandler = new SyncRestHandler();
    }

    /**
     * Syncs a player's MC account with a JRPanel account
     *
     * @param player player
     * @param code   code
     * @return sync response
     */
    public CompletableFuture<SyncResponse> sync(Player player, String code) {
        return this.syncHandler.sync(player.getUniqueId(), code);
    }
}
