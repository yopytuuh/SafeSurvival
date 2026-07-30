package fr.yopytuuh.safesurvival.events;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GamemodeListener implements Listener {

    private ConfigManager config;

    public GamemodeListener(ConfigManager config) {
        this.config = config;
    }

    @EventHandler
    public void onGamemode(PlayerGameModeChangeEvent event) {
        boolean block = config.isCommandBlocked("gamemode");

        if(block) {
            event.setCancelled(true);
            Bukkit.broadcastMessage("§7[§2SafeSurvival§7]§6 " + event.getPlayer().getName() + " tried this: §c§o/gamemode");
        }
    }

}
