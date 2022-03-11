package com.github.just_ricky.justrickycore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Single;
import com.github.just_ricky.justrickycore.JustRickyCorePlugin;
import org.bukkit.entity.Player;

@CommandAlias("panelsync")
public class PanelSyncCommand extends BaseCommand {

    /**
     * Plugin
     */
    private final JustRickyCorePlugin plugin;

    public PanelSyncCommand(JustRickyCorePlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    public void onPanelSync(Player player, @Single String code) {
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