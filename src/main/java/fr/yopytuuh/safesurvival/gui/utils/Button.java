package fr.yopytuuh.safesurvival.gui.utils;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class Button {

    private final ItemStack item;
    private final Consumer<InventoryClickEvent> action;

    public Button(ItemStack item, Consumer<InventoryClickEvent> action) {
        this.item = item;
        this.action = action;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(InventoryClickEvent event) {
        if(action != null) {
            action.accept(event);
        }
    }

}
