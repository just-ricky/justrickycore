package com.github.just_ricky.justrickycore;

import com.github.just_ricky.justrickycore.api.PaperPlugin;
import com.github.just_ricky.justrickycore.api.message.Message;
import com.github.just_ricky.justrickycore.commands.CommandManager;
import com.github.just_ricky.justrickycore.messages.Messages;
import com.github.just_ricky.justrickycore.sync.SyncManager;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class JustRickyCorePlugin extends PaperPlugin {

    /**
     * Messages
     */
    private Messages messages;

    /**
     * Sync manager
     */
    private SyncManager syncManager;

    @Override
    public void load() {
        this.getLogger().info("Loading the plugin.");
    }

    @Override
    public void enable() {
        Message.initAudience(this);

        this.getLogger().info("Enabling the plugin.");

        this.messages = new Messages(this);
        new CommandManager(this);

        this.syncManager = new SyncManager();
    }

    @Override
    public void disable() {
        this.getLogger().info("Disabling the plugin.");
    }

    /**
     * Returns messages
     *
     * @return messages
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * Returns the sync manager
     *
     * @return sync manager
     */
    public SyncManager getSyncManager() {
        return syncManager;
    }
}
