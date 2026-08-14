package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.command.CommandSender;

public class SSReload {

    private ConfigManager config;

    public SSReload(ConfigManager config) {
        this.config = config;
    }

    public void execute(CommandSender sender, String[] args) {

        config.reload(sender);
        sender.sendMessage("§7[§2SafeSurvival§7]§6 reloaded.");
    }

}
