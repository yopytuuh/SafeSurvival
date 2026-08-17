package fr.yopytuuh.safesurvival.events;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import fr.yopytuuh.safesurvival.manager.LogManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GamemodeListener implements Listener {

    private ConfigManager config;
    private LogManager logger;

    public GamemodeListener(ConfigManager config, LogManager logger) {
        this.config = config;
        this.logger = logger;
    }

    @EventHandler
    public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event) {
        boolean block = config.isCommandBlocked("gamemode");


        if(block) {
            event.setCancelled(true);

            logger.log(event.getPlayer().getName(), "/gamemode " + event.getNewGameMode().toString());

            Component alert = LegacyComponentSerializer.legacySection().deserialize("§7[§2SafeSurvival§7]§6 " + event.getPlayer().getName() + " tried this: §c§o/gamemode " + event.getNewGameMode());

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

}
