package com.github.just_ricky.justrickycore.api.config.generic.adapter;

import com.github.just_ricky.justrickycore.api.PaperPlugin;

import java.util.List;
import java.util.Map;

public interface ConfigurationAdapter {

    PaperPlugin getPlugin();

    void reload();

    String getString(String path, String def);

    int getInteger(String path, int def);

    double getDouble(String path, double def);

    boolean getBoolean(String path, boolean def);

    List<String> getStringList(String path, List<String> def);

    List<String> getKeys(String path, List<String> def);

    Map<String, String> getStringMap(String path, Map<String, String> def);

}
