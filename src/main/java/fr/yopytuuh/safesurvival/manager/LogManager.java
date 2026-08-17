package fr.yopytuuh.safesurvival.manager;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {

    private final JavaPlugin plugin;
    private final ConfigManager config;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogManager(JavaPlugin plugin, ConfigManager config) {
        this.plugin = plugin;
        this.config = config;
    }

    public void log(String player, String command) {

        if(!config.get().getBoolean("logs-enabled", true)) {
            return;
        }

        File log_folder = new File(plugin.getDataFolder(), "logs");

        if(!log_folder.exists() && !log_folder.mkdirs()) {
            plugin.getLogger().severe("Could not create log folder.");
            return;
        }

        File log_file = new File(log_folder, "server.log");

        String timestamp = LocalDateTime.now().format(DATE_FORMAT);

        String log = String.format("[%s] PLAYER=%s USED COMMAND=%s%n", timestamp, player, command);

        try (FileWriter writer = new FileWriter(log_file, true)) {
            writer.write(log);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not write to safe_survival.log");
            e.printStackTrace();
        }
    }

}
