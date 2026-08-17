package fr.yopytuuh.safesurvival.gui.utils;

import org.bukkit.Material;

public class CommandInfo {

    private final String name;
    private final Material item;
    private final boolean blocked;

    public CommandInfo(String name, Material item, boolean blocked) {
        this.name = name;
        this.item = item;
        this.blocked = blocked;
    }

    public String getName() {
        return name;
    }

    public Material getItem() {
        return item;
    }

    public boolean isBlocked() {
        return blocked;
    }

}
