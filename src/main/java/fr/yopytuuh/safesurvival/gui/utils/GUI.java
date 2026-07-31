package fr.yopytuuh.safesurvival.gui.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GUI implements InventoryHolder {

    private final Inventory inventory;
    private final Map<Integer, Button> buttons = new HashMap<>();
    private Consumer<InventoryCloseEvent> closeAction;

    public GUI(String title, int size) {
        inventory = Bukkit.createInventory(this, size, Component.text(title));
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public void setButton(int slot, Button button) {
        buttons.put(slot, button);
        inventory.setItem(slot, button.getItem());
    }

    public Button getButton(int slot) {
        return buttons.get(slot);
    }

    public void setCloseAction(Consumer<InventoryCloseEvent> closeAction) {
        this.closeAction = closeAction;
    }

    public void close(InventoryCloseEvent event) {
        if(closeAction != null)
            closeAction.accept(event);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public void refresh() {

        for (Map.Entry<Integer, Button> entry : buttons.entrySet()) {
            inventory.setItem(entry.getKey(), entry.getValue().getItem());
        }
    }

}
