package fr.yopytuuh.safesurvival.commands;

import fr.yopytuuh.safesurvival.commands.subcommands.SSConfig;
import fr.yopytuuh.safesurvival.commands.subcommands.SSReload;
import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SSCommand implements CommandExecutor {

    private ConfigManager config;

    public SSCommand(ConfigManager config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        Player player = (Player) sender;

        final SSConfig configCommand = new SSConfig();
        final SSReload reloadCommand = new SSReload(config);

        if (args.length == 0) {
            sender.sendMessage("§cUsage : /ss <config | reload>");
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "config":
                configCommand.execute(sender, args);
                break;
            case "reload":
                reloadCommand.execute(sender, args);

            default:
                sender.sendMessage("§cThis command does not exist.");
                break;
        }

        return true;
    }
}
