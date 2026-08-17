package fr.yopytuuh.safesurvival.manager;

import fr.yopytuuh.safesurvival.gui.utils.CommandInfo;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                material = Material.COMMAND_BLOCK;
            }

            commands.add(new CommandInfo(command, material, blocked));
        }
        return commands;
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