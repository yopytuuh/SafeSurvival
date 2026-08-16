package fr.yopytuuh.safesurvival.manager;

import org.bukkit.Material;
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
    }

    public void reload() {
        plugin.reloadConfig();
    }

    public void save() {
        plugin.saveConfig();
    }

    public FileConfiguration get() {
        return plugin.getConfig();
    }

    public boolean isCommandBlocked(String command) {
        return get().getBoolean("commands." + command + ".blocked");
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
}