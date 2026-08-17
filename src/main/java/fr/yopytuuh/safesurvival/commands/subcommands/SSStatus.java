package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.manager.ConfigManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SSStatus {

    private JavaPlugin plugin;
    private ConfigManager config;

    public SSStatus(JavaPlugin plugin, ConfigManager config) {
        this.plugin = plugin;
        this.config = config;
    }

    public void execute(CommandSender sender, String[] args) {

        if(!sender.hasPermission("safesurvival.status")) {
            sender.sendMessage("§7[§2SafeSurvival§7]§c You don't have permission to use this.");
            return;
        }

        int commands = 0;
        int blocked = 0;
        int allowed = 0;

        for(var command : config.getCommands()) {
            commands++;
            if(command.isBlocked()) {
                blocked++;
            } else {
                allowed++;
            }
        }

        sender.sendMessage("§6---------------------------------------------------");
        sender.sendMessage("§b§lSafeSurvival Status");
        sender.sendMessage("§7Version: §f" + plugin.getPluginMeta().getVersion());
        sender.sendMessage("");
        sender.sendMessage("§7Protection: §aActive");
        sender.sendMessage("§7Blocked commands: §c" + blocked);
        sender.sendMessage("§7Allowed commands: §a" + allowed);
        sender.sendMessage("");
        sender.sendMessage("§7Total commands: §9" + commands);
        sender.sendMessage("§6---------------------------------------------------");

    }

}
