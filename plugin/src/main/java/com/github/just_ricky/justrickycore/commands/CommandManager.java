package com.github.just_ricky.justrickycore.commands;

import co.aikar.commands.PaperCommandManager;
import com.github.just_ricky.justrickycore.JustRickyCorePlugin;

public class CommandManager {

    /**
     * Command manager
     */
    private final PaperCommandManager commandManager;

    /**
     * Constructor
     *
     * @param plugin plugin
     */
    public CommandManager(JustRickyCorePlugin plugin) {
        this.commandManager = new PaperCommandManager(plugin);

        // register commands
        this.commandManager.registerCommand(new CoreCommand(plugin));
    }
}
