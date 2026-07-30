package fr.yopytuuh.safesurvival.events;

import fr.yopytuuh.safesurvival.gui.utils.Button;
import fr.yopytuuh.safesurvival.gui.utils.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if(!(event.getInventory().getHolder() instanceof GUI gui)) return;

        event.setCancelled(true);

        Button button = gui.getButton(event.getSlot());

        if(button != null) {
            button.click(event);
        }

    }

}
