package fr.yopytuuh.safesurvival.gui.utils;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Button {

    private final Supplier<ItemStack> supplier;
    private final BiConsumer<GUI, InventoryClickEvent> action;

    public Button(Supplier<ItemStack> supplier,
                  BiConsumer<GUI, InventoryClickEvent> action) {
        this.supplier = supplier;
        this.action = action;
    }

    public ItemStack getItem() {
        return supplier.get();
    }

    public BiConsumer<GUI, InventoryClickEvent> getAction() {
        return action;
    }

    public void click(GUI gui, InventoryClickEvent event) {
        action.accept(gui, event);
    }
}
