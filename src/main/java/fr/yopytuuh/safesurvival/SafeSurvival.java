package fr.yopytuuh.safesurvival;

import fr.yopytuuh.safesurvival.events.CommandListener;
import fr.yopytuuh.safesurvival.events.GUIListener;
import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class SafeSurvival extends JavaPlugin {

    @Override
    public void onEnable() {

        ConfigManager config = new ConfigManager(this);
        config.load();
        Set<String> blockedCommands = config.getBlockedCommands();

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(blockedCommands), this);

        getLogger().info("Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled.");
    }
}