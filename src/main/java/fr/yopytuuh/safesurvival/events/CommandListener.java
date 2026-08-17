package fr.yopytuuh.safesurvival.events;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import fr.yopytuuh.safesurvival.manager.LogManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;
import java.util.Set;

public class CommandListener implements Listener {

    private final ConfigManager config;
    private final LogManager logger;

    public CommandListener(ConfigManager config, LogManager logger) {
        this.config = config;
        this.logger = logger;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        String command = event.getMessage()
                .substring(1)
                .split(" ")[0]
                .toLowerCase();

        if (command.contains(":")) {
            command = command.substring(command.indexOf(':') + 1);
        }

        if(!config.isCommandBlocked(command)) {
            return;
        }

        event.setCancelled(true);
        logger.log(event.getPlayer().getName(), event.getMessage());
        Component alert = LegacyComponentSerializer.legacySection().deserialize("§7[§2SafeSurvival§7]§6 " + event.getPlayer().getName() + " tried this: §c§o" + event.getMessage());

        if(config.get().getBoolean("alerts.broadcast", true)) {
            Bukkit.broadcast(alert);
        } else {
            if(config.get().getBoolean("alerts.enabled", true)) {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(player.hasPermission("safesurvival.alerts")) {
                        player.sendMessage(alert);
                    }
                }
            }
        }
        if(config.get().getBoolean("alerts.console", true)) {
            Bukkit.getConsoleSender().sendMessage(alert);
        }
    }
}