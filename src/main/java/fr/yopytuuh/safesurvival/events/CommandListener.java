package fr.yopytuuh.safesurvival.events;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Locale;
import java.util.Set;

public class CommandListener implements Listener {

    private final ConfigManager config;

    public CommandListener(ConfigManager config) {
        this.config = config;
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

        if (config.isCommandBlocked(command.toLowerCase())) {
            event.setCancelled(true);

            Bukkit.broadcastMessage("§7[§2SafeSurvival§7]§6 " + event.getPlayer().getName() + " tried this: §c§o" + event.getMessage());
        }
    }
}