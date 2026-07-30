package fr.yopytuuh.safesurvival.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SSTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        if (args.length == 1) {
            List<String> commands = new ArrayList<>();

            commands.add("config");
            commands.add("reload");

            return StringUtil.copyPartialMatches(args[0], commands, new ArrayList<>());
        }

        return Collections.emptyList();
    }
}
