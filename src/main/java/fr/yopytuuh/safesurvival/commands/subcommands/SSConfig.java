package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.gui.GUIBuilder;
import fr.yopytuuh.safesurvival.gui.ItemBuilder;
import fr.yopytuuh.safesurvival.gui.utils.GUI;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SSConfig {

    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only a player can use this.");
            return;
        }

        GUI gui = new GUIBuilder("Safe Survival Config", 54)
                .item(13, new ItemBuilder(Material.DIAMOND).name("§e§lTest").lore("test", "test").build(), event -> {})
                .build();

        gui.open(player);
    }

}
