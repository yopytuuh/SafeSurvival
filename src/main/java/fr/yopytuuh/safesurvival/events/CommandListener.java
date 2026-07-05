package fr.yopytuuh.safesurvival.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Set;

public class CommandListener implements Listener {

    private final Set<String> blockedCommands;

    public CommandListener(Set<String> blockedCommands) {
        this.blockedCommands = blockedCommands;
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

        if (blockedCommands.contains(command.toLowerCase())) {
            event.setCancelled(true);

            Bukkit.broadcast(Component.text("§7[§cSafeSurvival§7]§6 " + event.getPlayer().getName() + " tried this: §c§o" + event.getMessage()));
        }
    }
}