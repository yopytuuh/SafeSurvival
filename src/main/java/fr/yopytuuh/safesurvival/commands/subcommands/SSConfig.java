package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.gui.GUIBuilder;
import fr.yopytuuh.safesurvival.gui.ItemBuilder;
import fr.yopytuuh.safesurvival.gui.utils.GUI;
import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SSConfig {

    private final ConfigManager config;

    public SSConfig(ConfigManager config) {
        this.config = config;
    }

    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only a player can use this.");
            return;
        }

        GUI commands = new GUIBuilder("§lSafe Survival Config", 54)
                .item(0, () -> new ItemBuilder(Material.LEVER).name("§b§lHow?").lore("§fClick to §2allow §f/ §cblock §fa command.").build(), (inv, event) -> {})
                .item(1, () -> new ItemBuilder(Material.NETHERITE_SWORD).name("§b§o/gamemode").lore(config.getCommandStatus("gamemode"), "§e§oClick to modify").build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("gamemode");

                    config.get().set("commands.gamemode", !blocked);
                    config.save();

                    inv.refresh();
                })
                .build();

        commands.open(player);
    }

}
