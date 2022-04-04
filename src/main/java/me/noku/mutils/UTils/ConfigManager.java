package me.noku.mutils.UTils;

import me.noku.mutils.MUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    //gets variables in the Config
    public String getString (String path) {
        return MUtils.getInstance().getConfig().getString(path);
    }

    public Integer getInt (String path) {
        return MUtils.getInstance().getConfig().getInt(path);
    }

    public Double getDouble (String path) {
        return MUtils.getInstance().getConfig().getDouble(path);
    }

    public Boolean getBool (String path) {
        return MUtils.getInstance().getConfig().getBoolean(path);
    }

    //sets variables in the Config
    public void setString (String path, String var) {
        MUtils.getInstance().getConfig().set(path, var);
        MUtils.getInstance().saveConfig();
    }

    public void setInt (String path, Integer var) {
        MUtils.getInstance().getConfig().set(path, var);
        MUtils.getInstance().saveConfig();
    }

    public void setDouble (String path, Double var) {
        MUtils.getInstance().getConfig().set(path, var);
        MUtils.getInstance().saveConfig();
    }

    public void setBool (String path, Boolean var) {
        MUtils.getInstance().getConfig().set(path, var);
        MUtils.getInstance().saveConfig();
    }
}
