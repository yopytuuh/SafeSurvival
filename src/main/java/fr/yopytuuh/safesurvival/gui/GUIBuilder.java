package fr.yopytuuh.safesurvival.gui;

import fr.yopytuuh.safesurvival.gui.utils.Button;
import fr.yopytuuh.safesurvival.gui.utils.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class GUIBuilder {

    private final GUI gui;

    public GUIBuilder(String title, int size) {
        gui = new GUI(title, size);
    }

    public GUIBuilder item(int slot,
                           Supplier<ItemStack> supplier,
                           BiConsumer<GUI, InventoryClickEvent> action) {

        gui.setButton(slot, new Button(supplier, action));
        return this;
    }

    public GUIBuilder fill(Material material) {

        ItemStack glass = new ItemStack(material);

        for(int i = 0; i < gui.getInventory().getSize(); i++) {
            if(gui.getInventory().getItem(i) == null) {
                gui.getInventory().setItem(i, glass);
            }
        }
        return this;
    }

    public GUI build() {
        return gui;
    }

}
