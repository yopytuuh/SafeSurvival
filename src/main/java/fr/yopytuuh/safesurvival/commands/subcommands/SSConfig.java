package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.gui.GUIBuilder;
import fr.yopytuuh.safesurvival.gui.ItemBuilder;
import fr.yopytuuh.safesurvival.gui.utils.CommandInfo;
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

    private static final int[] COMMAND_SLOTS = {
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25,
            28, 29, 30, 31, 32, 33, 34,
            37, 38, 39, 40, 41, 42, 43
    };

    private ItemBuilder createCommandItem(CommandInfo command) {

        return new ItemBuilder(command.getItem())
                .name("§b§o/" + command.getName())
                .lore(config.getCommandStatus(
                        command.getName()),
                        "§e§oClick to modify"
                ).hideAttributes();
    }

    private GUI createPage(Player player, int page) {

        var commands = config.getCommands();

        int commandsPerPage = COMMAND_SLOTS.length;
        int totalPages = (int) Math.ceil((double) commands.size() / commandsPerPage);

        if(totalPages == 0) {
            totalPages = 1;
        }

        GUIBuilder builder = new GUIBuilder(
                "Safe Survival Config - Page " + page,
                54
        );

        builder.item(
                0,
                () -> new ItemBuilder(Material.LEVER)
                        .name("§b§lHow?")
                        .lore("§fClick to §2allow §f/ §cblock §fa command.")
                        .build(),
                (inv, event) -> {}
        );

        int start = (page - 1) * commandsPerPage;
        int end = Math.min(start + commandsPerPage, commands.size());

        for (int i = start; i < end; i++) {

            CommandInfo command = commands.get(i);

            int slot = COMMAND_SLOTS[i - start];

            builder.item(
                    slot,
                    () -> createCommandItem(command).build(),
                    (inv, event) -> {

                        boolean blocked = config.isCommandBlocked(command.getName());

                        config.get().set("commands." + command.getName() + ".blocked", !blocked);
                        config.save();
                        inv.refresh();
                    }
            );
        }
        if(page > 1) {
            int previous_page = page - 1;

            builder.item(
                    45,
                    () -> new ItemBuilder(Material.ARROW)
                            .name("§b§oPage " + previous_page)
                            .lore("§e§oClick to open")
                            .build(),
                    (inv, event) -> {
                        inv.close();
                        createPage(player, previous_page).open(player);
                    }
            );
        }

        if(page < totalPages) {
            int next_page = page + 1;

            builder.item(
                    53,
                    () -> new ItemBuilder(Material.ARROW)
                            .name("§e§oPage " + next_page)
                            .lore("§e§oClick to open")
                            .build(),
                    (inv, event) -> {
                        inv.close();
                        createPage(player, next_page).open(player);
                    }
            );
        }
        return builder.build();
    }

    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only a player can open in-game config.");
            return;
        }

        if(!sender.hasPermission("safesurvival.config")) {
            sender.sendMessage("§7[§2SafeSurvival§7]§c You don't have permission to use this.");
            return;
        }

        createPage(player, 1).open(player);

    }
}
