package com.github.just_ricky.justrickycore.messages;

import com.github.just_ricky.justrickycore.JustRickyCorePlugin;
import com.github.just_ricky.justrickycore.api.message.Message;

public class Messages {

    public final Message coreDefault;

    public final Message syncSyncing;

    public final Message syncFailedReason;

    public final Message syncSuccess;

    /**
     * Constructor
     *
     * @param plugin plugin
     */
    public Messages(JustRickyCorePlugin plugin) {
        this.coreDefault = Message.builder("core.default")
                .addLine("&7JustRickyCore &bv" + plugin.getDescription().getVersion())
                .build();

        this.syncSyncing = Message.builder("sync.syncing")
                .addLine("&7Syncing...")
                .build();

        this.syncFailedReason = Message.builder("sync.failed-reason")
                .addLine("&cFailed to sync your account!")
                .addLine("&7Reason: &f%reason%")
                .build();

        this.syncSuccess = Message.builder("sync.success")
                .addLine("&aSuccess! &7You synced your account.")
                .build();
    }
}
