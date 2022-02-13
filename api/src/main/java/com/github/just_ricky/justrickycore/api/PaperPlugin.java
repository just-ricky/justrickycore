package com.github.just_ricky.justrickycore.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public abstract class PaperPlugin extends JavaPlugin {

    /**
     * Plugin logger
     */
    protected final Logger logger;

    /**
     * Constructor
     */
    protected PaperPlugin() {
        logger = Bukkit.getLogger();
    }

    /**
     * Called when the plugin loads
     */
    public abstract void load();

    /**
     * Called when the plugin enables
     */
    public abstract void enable();

    /**
     * Called when the plugin disables
     */
    public abstract void disable();

    @Override
    public void onLoad() {
        super.onLoad();
        this.load();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.enable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.disable();
    }

    /**
     * Returns the plugin's logger
     *
     * @return logger
     */
    public Logger logger() {
        return this.logger;
    }
}
