package fr.yopytuuh.safesurvival;

import fr.yopytuuh.safesurvival.commands.SSCommand;
import fr.yopytuuh.safesurvival.events.CommandListener;
import fr.yopytuuh.safesurvival.events.GUIListener;
import fr.yopytuuh.safesurvival.events.GamemodeListener;
import fr.yopytuuh.safesurvival.manager.ConfigManager;
import fr.yopytuuh.safesurvival.utils.SSTabCompleter;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SafeSurvival extends JavaPlugin {

    @Override
    public void onEnable() {

        ConfigManager config = new ConfigManager(this);
        config.load();

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(config), this);
        getServer().getPluginManager().registerEvents(new GamemodeListener(config), this);

        PluginCommand command = getCommand("ss");

        if (command != null) {
            command.setExecutor(new SSCommand(config));
            command.setTabCompleter(new SSTabCompleter());
        }

        getLogger().info("Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled.");
    }
}