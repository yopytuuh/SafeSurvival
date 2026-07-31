package fr.yopytuuh.safesurvival.gui;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;
    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacySection();

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemBuilder name(String name) {
        meta.displayName(LEGACY.deserialize(name).decoration(TextDecoration.ITALIC, false));
        return this;
    }

    public ItemBuilder lore(String... lore) {

        List<Component> components = Arrays.stream(lore).<Component>map(line -> LEGACY.deserialize(line).decoration(TextDecoration.ITALIC, false)).toList();

        meta.lore(components);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    public ItemBuilder hideAttributes() {

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);

        return this;
    }

}
