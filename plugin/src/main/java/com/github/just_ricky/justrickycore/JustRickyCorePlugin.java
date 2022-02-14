package com.github.just_ricky.justrickycore;

import com.github.just_ricky.justrickycore.api.PaperPlugin;
import com.github.just_ricky.justrickycore.commands.CommandManager;
import com.github.just_ricky.justrickycore.messages.Messages;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class JustRickyCorePlugin extends PaperPlugin {

    /**
     * Messages
     */
    private Messages messages;

    @Override
    public void load() {
        this.getLogger().info("Loading the plugin.");
    }

    @Override
    public void enable() {
        this.getLogger().info("Enabling the plugin.");

        this.messages = new Messages(this);
        new CommandManager(this);
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
}
