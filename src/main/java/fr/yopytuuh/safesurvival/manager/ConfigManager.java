package fr.yopytuuh.safesurvival.manager;

import fr.yopytuuh.safesurvival.gui.utils.CommandInfo;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private final JavaPlugin plugin;

    private static final int CURRENT_CONFIG_VERSION = 2;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();
        checkConfigVersion();
    }

    public boolean reload() {
        try {
            plugin.reloadConfig();

            if(get().getConfigurationSection("commands") == null) {
                return false;
            }

            return true;

        } catch (Exception e) {
            plugin.getLogger().severe("Failed to reload config.yml.");
            e.printStackTrace();
            return false;
        }
    }

    public void save() {
        plugin.saveConfig();
    }

    public FileConfiguration get() {
        return plugin.getConfig();
    }

    public int getCurrentConfigVersion() {
        return get().getInt("config-version", 0);
    }

    public List<CommandInfo> getCommands() {

        List<CommandInfo> commands = new ArrayList<>();

        ConfigurationSection section = get().getConfigurationSection("commands");

        if(section == null) {
            return commands;
        }

        for(String command : section.getKeys(false)) {

            boolean blocked = section.getBoolean(command + ".blocked", false);
            String item = section.getString(command + ".item", "COMMAND_BLOCK");

            Material material;

            try {
                material = Material.valueOf(item.toUpperCase());
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid item name: '" + item + "' for command '" + command + "' in config.yml.");
                material = Material.COMMAND_BLOCK;
            }

            commands.add(new CommandInfo(command, material, blocked));
        }
        return commands;
    }

    public Material getCommandMaterial(String command) {
        String item = get().getString("commands." + command + ".item");
        try {
            return Material.valueOf(item);
        } catch (IllegalArgumentException | NullPointerException e) {
            return Material.COMMAND_BLOCK;
        }
    }

    public String getCommandStatus(String command) {
        boolean blocked = isCommandBlocked(command);
        if(blocked) {
            return "§c§lBLOCKED";
        } else {
            return "§2§lALLOWED";
        }
    }

    public boolean isCommandBlocked(String command) {
        return get().getBoolean("commands." + command + ".blocked");
    }

    public void backupConfig(int old_version) {

        File config_file = new File(plugin.getDataFolder(), "config.yml");

        String backup_name = "config.yml.v" + old_version + ".backup";
        File backup_file = new File(plugin.getDataFolder(), backup_name);

        try {
            Files.copy(config_file.toPath(), backup_file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            plugin.getLogger().info("Created config.yml backup.");
        } catch (IOException e) {
            plugin.getLogger().severe("Failed to backup old config.yml.");
            e.printStackTrace();
        }

    }

    private YamlConfiguration getJarConfig() {

        YamlConfiguration default_config = new YamlConfiguration();

        try (InputStream input = plugin.getResource("config.yml")) {

            if(input == null) {
                plugin.getLogger().severe("SafeSurvival.jar is broken. Could not find default config.yml");
                return default_config;
            }

            default_config.load(new InputStreamReader(input, StandardCharsets.UTF_8));

        } catch (IOException | InvalidConfigurationException e) {
            plugin.getLogger().severe("SafeSurvival.jar is broken. Could not load default config.yml");
            e.printStackTrace();
        }
        return default_config;
    }

    private boolean mergeConfigs(int old_version, ConfigurationSection old_config, ConfigurationSection new_config) {

        if (old_version == 1) {
            plugin.getLogger().severe("Config version 1 is invalid or unsupported.");
            return false;
        }

        if (old_version >= 3) {
            plugin.getLogger().severe("Config version " + old_version + " is newer than this plugin supports.");
            return false;
        }

        for (String key : old_config.getKeys(false)) {

            if (!new_config.contains(key)) {
                continue;
            }

            Object old_value = old_config.get(key);
            Object new_value = new_config.get(key);

            if (old_value instanceof Boolean && new_value instanceof ConfigurationSection section) {

                section.set("blocked", old_value);
                continue;
            }

            if (old_value instanceof ConfigurationSection old_section && new_value instanceof ConfigurationSection new_section) {

                mergeConfigs(old_version, old_section, new_section);
                continue;
            }

            if (!(new_value instanceof ConfigurationSection)) {
                new_config.set(key, old_value);
            }
        }
        return true;
    }

    private void saveNewConfig(YamlConfiguration config) {

        config.set("config-version", CURRENT_CONFIG_VERSION);

        try {
            config.save(new File(plugin.getDataFolder(), "config.yml"));

            plugin.getLogger().info("Config successfully updated.");
            plugin.reloadConfig();
            plugin.getLogger().info("Config successfully reloaded.");

        } catch (IOException e) {
            plugin.getLogger().severe("Could not save updated config.yml!");
            e.printStackTrace();
        }

    }

    public void updateConfig(int old_version) {

        plugin.getLogger().warning("Updating config.yml v" + old_version +" to config.yml v" + CURRENT_CONFIG_VERSION + "...");
        backupConfig(old_version);

        YamlConfiguration old_config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));

        YamlConfiguration new_config = getJarConfig();

        if (!mergeConfigs(old_version, old_config, new_config)) {
            return;
        }
        saveNewConfig(new_config);
        plugin.getLogger().warning("Updated config.yml v" + old_version +" to config.yml v" + CURRENT_CONFIG_VERSION + "!");
    }

    public void checkConfigVersion() {

        int version = getCurrentConfigVersion();

        if(version == CURRENT_CONFIG_VERSION) {
            return;
        }

        plugin.getLogger().warning("config.yml version outdated, launching update...");
        updateConfig(version);
    }
}