package com.github.just_ricky.justrickycore.api;

import com.github.just_ricky.justrickycore.api.config.adapter.BukkitConfigAdapter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
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

    /**
     * Resolves a configuration
     *
     * @param fileName file name
     * @return configuration path
     */
    private Path resolveConfig(String fileName) {
        Path configFile = getDataFolder().toPath().resolve(fileName);

        // if the config doesn't exist, create it based on the template in the resources dir
        if (!Files.exists(configFile)) {
            try {
                Files.createDirectories(configFile.getParent());
            } catch (IOException ignored) {
            }

            try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
                Files.copy(Objects.requireNonNull(is), configFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return configFile;
    }

    /**
     * Provides a configuration adapter
     *
     * @param fileName file name
     * @return config adapter
     */
    protected BukkitConfigAdapter provideConfigAdapter(String fileName) {
        return new BukkitConfigAdapter(this, resolveConfig(fileName).toFile());
    }
}
