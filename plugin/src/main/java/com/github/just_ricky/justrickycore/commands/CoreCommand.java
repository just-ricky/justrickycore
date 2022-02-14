package com.github.just_ricky.justrickycore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.just_ricky.justrickycore.JustRickyCorePlugin;
import org.bukkit.entity.Player;

@CommandAlias("core")
public class CoreCommand extends BaseCommand {

    /**
     * Plugin
     */
    private final JustRickyCorePlugin plugin;

    public CoreCommand(JustRickyCorePlugin plugin){
        this.plugin = plugin;
    }

    @Default
    public void onCore(Player player) {
        plugin.getMessages().coreDefault.message(player);
    }
}
