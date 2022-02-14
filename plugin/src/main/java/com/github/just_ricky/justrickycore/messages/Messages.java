package com.github.just_ricky.justrickycore.messages;

import com.github.just_ricky.justrickycore.JustRickyCorePlugin;
import com.github.just_ricky.justrickycore.api.message.Message;

public class Messages {

    public final Message coreDefault;

    /**
     * Constructor
     *
     * @param plugin plugin
     */
    public Messages(JustRickyCorePlugin plugin) {
        this.coreDefault = Message.builder("core.default")
                .addLine("&7JustRickyCore &bv" + plugin.getDescription().getVersion())
                .build();
    }
}
