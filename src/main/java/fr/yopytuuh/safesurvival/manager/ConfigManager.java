package fr.yopytuuh.safesurvival.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class ConfigManager {

    private final JavaPlugin plugin;
    private final Set<String> blockedCommands = new HashSet<>();

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();

        if (get().getConfigurationSection("commands") != null) {
            for (String command : plugin.getConfig()
                    .getConfigurationSection("commands")
                    .getKeys(false)) {

                if (plugin.getConfig().getBoolean("commands." + command)) {
                    blockedCommands.add(command.toLowerCase());
                }
            }
        } else {
            plugin.getServer().getLogger().warning("Safe Survival config.yml file is corrupted; please delete it to allow it to be regenerated.");
        }
    }

    public void reload() {
        plugin.reloadConfig();
    }

    public boolean isCommandBlocked(String command) {
        String path = "commands." + command;
        return plugin.getConfig().getBoolean(path);
    }

    public Set<String> getBlockedCommands() {
        return blockedCommands;
    }

    public FileConfiguration get() {
        return plugin.getConfig();
    }

}
