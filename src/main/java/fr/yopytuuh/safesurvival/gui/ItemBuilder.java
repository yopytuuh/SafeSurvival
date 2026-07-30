package fr.yopytuuh.safesurvival.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemBuilder name(String name) {
        meta.displayName(Component.text(name));
        return this;
    }

    public ItemBuilder lore(String... lore) {

        List<Component> components = new ArrayList<>();

        for(String line : lore)
            components.add(Component.text(line));

        meta.lore(components);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

}
