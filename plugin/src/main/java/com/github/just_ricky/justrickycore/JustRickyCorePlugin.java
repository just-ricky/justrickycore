package com.github.just_ricky.justrickycore;

import com.github.just_ricky.justrickycore.api.PaperPlugin;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class JustRickyCorePlugin extends PaperPlugin {

    @Override
    public void load() {
        this.getLogger().info("Loading the plugin.");
    }

    @Override
    public void enable() {
        this.getLogger().info("Enabling the plugin.");
    }

    @Override
    public void disable() {
        this.getLogger().info("Disabling the plugin.");
    }
}
