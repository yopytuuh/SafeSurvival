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

        GUI commands = new GUIBuilder("Safe Survival Config", 54)
                .item(0, () -> new ItemBuilder(Material.LEVER).name("§b§lHow?").lore("§fClick to §2allow §f/ §cblock §fa command.").build(), (inv, event) -> {})
                .item(10, () -> new ItemBuilder(Material.NETHERITE_SWORD).name("§b§o/gamemode").lore(config.getCommandStatus("gamemode"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("gamemode");

                    config.get().set("commands.gamemode", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(11, () -> new ItemBuilder(Material.DIAMOND_SWORD).name("§b§o/defaultgamemode").lore(config.getCommandStatus("defaultgamemode"), "§e§oClick to modify").hideAttributes().build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("defaultgamemode");

                    config.get().set("commands.defaultgamemode", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(12, () -> new ItemBuilder(Material.GOLDEN_SWORD).name("§b§o/gamerule").lore(config.getCommandStatus("gamerule"), "§e§oClick to modify").hideAttributes().build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("gamerule");

                    config.get().set("commands.gamerule", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(13, () -> new ItemBuilder(Material.STONE_SWORD).name("§b§o/difficulty").lore(config.getCommandStatus("difficulty"), "§e§oClick to modify").hideAttributes().build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("difficulty");

                    config.get().set("commands.difficulty", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(14, () -> new ItemBuilder(Material.DIAMOND).name("§b§o/give").lore(config.getCommandStatus("give"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("give");

                    config.get().set("commands.give", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(15, () -> new ItemBuilder(Material.STICK).name("§b§o/item").lore(config.getCommandStatus("item"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("item");

                    config.get().set("commands.item", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(16, () -> new ItemBuilder(Material.DRAGON_EGG).name("§b§o/summon").lore(config.getCommandStatus("summon"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("summon");

                    config.get().set("commands.summon", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(19, () -> new ItemBuilder(Material.CHEST).name("§b/loot").lore(config.getCommandStatus("loot"), "§eClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("loot");

                    config.get().set("commands.loot", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(20, () -> new ItemBuilder(Material.BARRIER).name("§b/clear").lore(config.getCommandStatus("clear"), "§eClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("clear");

                    config.get().set("commands.clear", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(21, () -> new ItemBuilder(Material.SKELETON_SKULL).name("§b/kill").lore(config.getCommandStatus("kill"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("kill");

                    config.get().set("commands.kill", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(22, () -> new ItemBuilder(Material.POTION).name("§b/effect").lore(config.getCommandStatus("effect"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("effect");

                    config.get().set("commands.effect", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(23, () -> new ItemBuilder(Material.ENCHANTED_BOOK).name("§b/enchant").lore(config.getCommandStatus("enchant"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("enchant");

                    config.get().set("commands.enchant", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(24, () -> new ItemBuilder(Material.EXPERIENCE_BOTTLE).name("§b/xp").lore(config.getCommandStatus("xp"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("xp");

                    config.get().set("commands.xp", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(25, () -> new ItemBuilder(Material.EXPERIENCE_BOTTLE).name("§b/experience").lore(config.getCommandStatus("experience"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("experience");

                    config.get().set("commands.experience", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(28, () -> new ItemBuilder(Material.NAME_TAG).name("§b/attribute").lore(config.getCommandStatus("attribute"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("attribute");

                    config.get().set("commands.attribute", !blocked);
                    config.save();

                    inv.refresh();
                })
                .build();

        commands.open(player);
        commands.setCloseAction(e -> {
            config.reload();
            sender.sendMessage("§7[§2SafeSurvival§7]§6 reloaded.");
        });
    }

}
