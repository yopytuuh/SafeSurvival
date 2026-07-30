package fr.yopytuuh.safesurvival;

import fr.yopytuuh.safesurvival.events.CommandListener;
import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class SafeSurvival extends JavaPlugin {

    private Set<String> blockedCommands = new HashSet<>();

    private ConfigManager configManager;

    @Override
    public void onEnable() {

        configManager = new ConfigManager(this);

        configManager.load();
        blockedCommands = configManager.getBlockedCommands();

        getLogger().info("[SafeSurvival] Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("[SafeSurvival] Disabled.");
    }
}