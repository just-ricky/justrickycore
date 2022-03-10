package com.github.just_ricky.justrickycore.sync;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface SyncHandler {

    /**
     * Tries to sync a minecraft account with a JRPanel account
     *
     * @param uuid the uuid of the player
     * @param code the code that the player provides
     * @return the response to the sync call
     */
    CompletableFuture<SyncResponse> sync(UUID uuid, String code);
}
