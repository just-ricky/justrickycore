package com.github.just_ricky.justrickycore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Single;
import com.github.just_ricky.justrickycore.JustRickyCorePlugin;
import com.github.just_ricky.justrickycore.api.message.Message;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

@CommandAlias("sync")
public class SyncCommand extends BaseCommand {

    /**
     * Plugin
     */
    private final JustRickyCorePlugin plugin;

    public SyncCommand(JustRickyCorePlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    public void onSync(Player player, @Single String code) {
        // send initial sync message
        plugin.getMessages().syncSyncing.message(player);

        // try to sync
        plugin.getSyncManager().sync(player, code).thenAccept((syncResponse -> {
            if (syncResponse.isError()) {
                plugin.getMessages()
                        .syncFailedReason
                        .message(player, "%reason%", syncResponse.getMessage());
            } else {
                plugin.getMessages().syncSuccess.message(player);
            }
        }));
    }
}