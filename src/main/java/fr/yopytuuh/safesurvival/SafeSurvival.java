package fr.yopytuuh.safesurvival;

import fr.yopytuuh.safesurvival.events.CommandListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class SafeSurvival extends JavaPlugin {

    private final Set<String> blockedCommands = new HashSet<>();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        if (getConfig().getConfigurationSection("commands") != null) {
            for (String command : getConfig()
                    .getConfigurationSection("commands")
                    .getKeys(false)) {

                if (getConfig().getBoolean("commands." + command)) {
                    blockedCommands.add(command.toLowerCase());
                }
            }
        } else {
            getServer().getLogger().warning("[SafeSurvival] config.yml file is corrupted; please delete it to allow it to be regenerated.");
        }

        getServer().getPluginManager().registerEvents(
                new CommandListener(blockedCommands),
                this
        );

        getLogger().info("[SafeSurvival] Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("[SafeSurvival] Disabled.");
    }
}