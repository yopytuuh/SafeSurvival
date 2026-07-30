package fr.yopytuuh.safesurvival.gui.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class GUI implements InventoryHolder {

    private final Inventory inventory;
    private final Map<Integer, Button> buttons = new HashMap<>();

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

    public void open(Player player) {
        player.openInventory(inventory);
    }

}
