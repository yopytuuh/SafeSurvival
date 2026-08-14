package fr.yopytuuh.safesurvival.manager;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigManager {

    private final JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();
        validate();
    }

    public void validate() {

        FileConfiguration config = get();
        ConfigurationSection commands = config.getConfigurationSection("commands");
        InputStream resource = plugin.getResource("config.yml");

        FileConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(resource));

        if(resource == null) {
            plugin.getLogger().severe("Could not load default config.yml. SafeSurvival.jar may be corrupted");
        }

        if (commands == null) {
            plugin.getLogger().severe("Missing 'commands' section in config.yml. Delete config.yml and let it be recreated please.");
            return;
        }

        ConfigurationSection defaultCommands = defaultConfig.getConfigurationSection("commands");

        if (defaultCommands == null) {
            plugin.getLogger().severe("Missing 'commands' section in default config.yml. SafeSurvival.jar may be corrupted.");
            return;
        }

        for (String command : defaultCommands.getKeys(false)) {

            String path = "commands." + command;

            if (!config.contains(path)) {
                plugin.getLogger().info("Missing config option '" + path+ "' in config.yml. Using default value.");

                config.set(path, defaultConfig.get(path));
                continue;
            }

            Object value = config.get(path);

            if (!(value instanceof Boolean)) {
                plugin.getLogger().warning("Invalid value for '" + path+ "' in config.yml. Expected true or false.");
            }
        }

        save();
        plugin.getLogger().info("config.yml loaded and checked.");
    }

    public void validate(CommandSender sender) {

        boolean check = false;
        FileConfiguration config = get();
        ConfigurationSection commands = config.getConfigurationSection("commands");
        InputStream resource = plugin.getResource("config.yml");

        FileConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(resource));

        if(resource == null) {
            plugin.getLogger().severe("Could not load default config.yml. SafeSurvival.jar may be corrupted");
        }

        if (commands == null) {
            plugin.getLogger().severe("Missing 'commands' section in config.yml. Delete config.yml and let it be recreated please.");
            return;
        }

        ConfigurationSection defaultCommands = defaultConfig.getConfigurationSection("commands");

        if (defaultCommands == null) {
            plugin.getLogger().severe("Missing 'commands' section in default config.yml. SafeSurvival.jar may be corrupted.");
            return;
        }

        for (String command : defaultCommands.getKeys(false)) {

            String path = "commands." + command;

            if (!config.contains(path)) {
                plugin.getLogger().info("Missing config option '" + path+ "' in config.yml. Using default value.");

                config.set(path, defaultConfig.get(path));
                check = true;
                continue;
            }

            Object value = config.get(path);

            if (!(value instanceof Boolean)) {
                plugin.getLogger().warning("Invalid value for '" + path+ "' in config.yml. Expected true or false.");
                check = true;
            }
        }

        save();
        plugin.getLogger().info("config.yml loaded and checked.");
        if(check) {
            if(sender instanceof Player) {
                sender.sendMessage("§7[§2SafeSurvival§7]§6 There was a problem, please check console.");
            }
        }
    }

    public void reload() {
        plugin.reloadConfig();
        validate();
    }

    public void reload(CommandSender sender) {
        plugin.reloadConfig();
        validate(sender);
    }

    public void save() {
        plugin.saveConfig();
    }

    public boolean isCommandBlocked(String command) {
        return get().getBoolean("commands." + command);
    }

    public String getCommandStatus(String command) {
        boolean blocked = isCommandBlocked(command);
        if(blocked) {
            return "§c§lBLOCKED";
        } else {
            return "§2§lALLOWED";
        }
    }

    public FileConfiguration get() {
        return plugin.getConfig();
    }

}
