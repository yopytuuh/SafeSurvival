package fr.yopytuuh.safesurvival.commands.subcommands;

import fr.yopytuuh.safesurvival.commands.SSCommand;
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

        GUI commands_page3 = new GUIBuilder("Safe Survival Config - Page 3",54)
                .item(0, () -> new ItemBuilder(Material.LEVER).name("§b§lHow?").lore("§fClick to §2allow §f/ §cblock §fa command.").build(), (inv, event) -> {})
                .item(10, () -> new ItemBuilder(Material.DEBUG_STICK).name("§b§o/kick").lore(config.getCommandStatus("kick"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("kick");

                    config.get().set("commands.kick", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(11, () -> new ItemBuilder(Material.APPLE).name("§b§o/ban").lore(config.getCommandStatus("ban"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("ban");

                    config.get().set("commands.ban", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(12, () -> new ItemBuilder(Material.GOLDEN_APPLE).name("§b§o/ban-ip").lore(config.getCommandStatus("ban-ip"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("ban-ip");

                    config.get().set("commands.ban-ip", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(13, () -> new ItemBuilder(Material.OAK_LEAVES).name("§b§o/pardon").lore(config.getCommandStatus("pardon"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("pardon");

                    config.get().set("commands.pardon", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(14, () -> new ItemBuilder(Material.SPRUCE_LEAVES).name("§b§o/pardon-ip").lore(config.getCommandStatus("pardon-ip"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("pardon-ip");

                    config.get().set("commands.pardon-ip", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(15, () -> new ItemBuilder(Material.NETHERITE_INGOT).name("§b§o/publish").lore(config.getCommandStatus("publish"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("publish");

                    config.get().set("commands.publish", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(16, () -> new ItemBuilder(Material.COMMAND_BLOCK).name("§b§o/trigger").lore(config.getCommandStatus("trigger"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("trigger");

                    config.get().set("commands.trigger", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(45, () -> new ItemBuilder(Material.ARROW).name("§b§oPage 1").lore("§e§oClick to open").build(), (inv, event) -> {
                    inv.close();
                    player.performCommand("ss config");
                })
                .build();

        GUI commands_page2 = new GUIBuilder("Safe Survival Config - Page 2",54)
                .item(0, () -> new ItemBuilder(Material.LEVER).name("§b§lHow?").lore("§fClick to §2allow §f/ §cblock §fa command.").build(), (inv, event) -> {})
                .item(10, () -> new ItemBuilder(Material.MINECART).name("§b§o/function").lore(config.getCommandStatus("function"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("function");

                    config.get().set("commands.function", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(11, () -> new ItemBuilder(Material.ANVIL).name("§b§o/forceload").lore(config.getCommandStatus("forceload"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("forceload");

                    config.get().set("commands.forceload", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(12, () -> new ItemBuilder(Material.GLASS_PANE).name("§b§o/worldborder").lore(config.getCommandStatus("worldborder"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("worldborder");

                    config.get().set("commands.worldborder", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(13, () -> new ItemBuilder(Material.WHITE_BED).name("§b§o/setworldspawn").lore(config.getCommandStatus("setworldspawn"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("setworldspawn");

                    config.get().set("commands.setworldspawn", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(14, () -> new ItemBuilder(Material.BLACK_BED).name("§b§o/spawnpoint").lore(config.getCommandStatus("spawnpoint"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("spawnpoint");

                    config.get().set("commands.spawnpoint", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(15, () -> new ItemBuilder(Material.CLOCK).name("§b§o/time").lore(config.getCommandStatus("time"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("time");

                    config.get().set("commands.time", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(16, () -> new ItemBuilder(Material.CAULDRON).name("§b§o/weather").lore(config.getCommandStatus("weather"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("weather");

                    config.get().set("commands.weather", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(19, () -> new ItemBuilder(Material.REDSTONE_TORCH).name("§b§o/tick").lore(config.getCommandStatus("tick"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("tick");

                    config.get().set("commands.tick", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(20, () -> new ItemBuilder(Material.WHEAT_SEEDS).name("§b§o/seed").lore(config.getCommandStatus("seed"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("seed");

                    config.get().set("commands.seed", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(21, () -> new ItemBuilder(Material.COMPASS).name("§b§o/locate").lore(config.getCommandStatus("locate"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("locate");

                    config.get().set("commands.locate", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(22, () -> new ItemBuilder(Material.COMPASS).name("§b§o/locatebiome").lore(config.getCommandStatus("locatebiome"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("locatebiome");

                    config.get().set("commands.locatebiome", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(23, () -> new ItemBuilder(Material.CRAFTING_TABLE).name("§b§o/recipe").lore(config.getCommandStatus("recipe"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("recipe");

                    config.get().set("commands.recipe", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(24, () -> new ItemBuilder(Material.GOLD_INGOT).name("§b§o/advancement").lore(config.getCommandStatus("advancement"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("advancement");

                    config.get().set("commands.advancement", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(25, () -> new ItemBuilder(Material.OAK_SIGN).name("§b§o/title").lore(config.getCommandStatus("title"), "§e§oClick to modify").hideAttributes().build(), (inv, event)-> {
                    boolean blocked = config.isCommandBlocked("title");

                    config.get().set("commands.title", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(28, () -> new ItemBuilder(Material.ORANGE_DYE).name("§b/tellraw").lore(config.getCommandStatus("tellraw"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("tellraw");

                    config.get().set("commands.tellraw", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(29, () -> new ItemBuilder(Material.DRAGON_HEAD).name("§b/bossbar").lore(config.getCommandStatus("bossbar"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("bossbar");

                    config.get().set("commands.bossbar", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(30, () -> new ItemBuilder(Material.JUKEBOX).name("§b/playsound").lore(config.getCommandStatus("playsound"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("playsound");

                    config.get().set("commands.playsound", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(31, () -> new ItemBuilder(Material.PISTON).name("§b/reload").lore(config.getCommandStatus("reload"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("reload");

                    config.get().set("commands.reload", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(32, () -> new ItemBuilder(Material.SHIELD).name("§b/stop").lore(config.getCommandStatus("stop"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("stop");

                    config.get().set("commands.stop", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(33, () -> new ItemBuilder(Material.FISHING_ROD).name("§b/debug").lore(config.getCommandStatus("debug"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("debug");

                    config.get().set("commands.debug", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(34, () -> new ItemBuilder(Material.TOTEM_OF_UNDYING).name("§b/perf").lore(config.getCommandStatus("perf"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("perf");

                    config.get().set("commands.perf", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(37, () -> new ItemBuilder(Material.COMMAND_BLOCK_MINECART).name("§b/jfr").lore(config.getCommandStatus("jfr"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("jfr");

                    config.get().set("commands.jfr", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(38, () -> new ItemBuilder(Material.ENDER_CHEST).name("§b/save-all").lore(config.getCommandStatus("save-all"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("save-all");

                    config.get().set("commands.save-all", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(39, () -> new ItemBuilder(Material.GREEN_DYE).name("§b/save-on").lore(config.getCommandStatus("save-on"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("save-on");

                    config.get().set("commands.save-on", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(40, () -> new ItemBuilder(Material.RED_DYE).name("§b/save-off").lore(config.getCommandStatus("save-off"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("save-off");

                    config.get().set("commands.save-off", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(41, () -> new ItemBuilder(Material.WITHER_SKELETON_SKULL).name("§b/op").lore(config.getCommandStatus("op"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("op");

                    config.get().set("commands.op", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(42, () -> new ItemBuilder(Material.DIRT).name("§b/deop").lore(config.getCommandStatus("deop"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("deop");

                    config.get().set("commands.deop", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(43, () -> new ItemBuilder(Material.WHITE_BANNER).name("§b/whitelist").lore(config.getCommandStatus("whitelist"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("whitelist");

                    config.get().set("commands.whitelist", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(45, () -> new ItemBuilder(Material.ARROW).name("§b§oPage 1").lore("§e§oClick to open").build(), (inv, event) -> {
                    inv.close();
                    player.performCommand("ss config");
                })
                .item(53, () -> new ItemBuilder(Material.ARROW).name("§b§oPage 3").lore("§e§oClick to open").build(), (inv, event) -> {
                    inv.close();
                    commands_page3.open(player);
                })
                .build();

         GUI commands_page1 = new GUIBuilder("Safe Survival Config - Page 1", 54)
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
                .item(22, () -> new ItemBuilder(Material.POTION).name("§b/effect").lore(config.getCommandStatus("effect"), "§e§oClick to modify").hideAttributes().build(), (inv, event) -> {
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
                .item(29, () -> new ItemBuilder(Material.FIRE_CHARGE).name("§b/damage").lore(config.getCommandStatus("damage"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("damage");

                    config.get().set("commands.damage", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(30, () -> new ItemBuilder(Material.ENDER_PEARL).name("§b/tp").lore(config.getCommandStatus("tp"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("tp");

                    config.get().set("commands.tp", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(31, () -> new ItemBuilder(Material.ENDER_PEARL).name("§b/teleport").lore(config.getCommandStatus("teleport"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("teleport");

                    config.get().set("commands.teleport", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(32, () -> new ItemBuilder(Material.GLOWSTONE_DUST).name("§b/spreadplayers").lore(config.getCommandStatus("spreadplayers"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("spreadplayers");

                    config.get().set("commands.spreadplayers", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(33, () -> new ItemBuilder(Material.SADDLE).name("§b/ride").lore(config.getCommandStatus("ride"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("ride");

                    config.get().set("commands.ride", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(34, () -> new ItemBuilder(Material.ENDER_EYE).name("§b/spectate").lore(config.getCommandStatus("spectate"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("spectate");

                    config.get().set("commands.spectate", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(37, () -> new ItemBuilder(Material.WHITE_CONCRETE).name("§b/fill").lore(config.getCommandStatus("fill"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("fill");

                    config.get().set("commands.fill", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(38, () -> new ItemBuilder(Material.GRASS_BLOCK).name("§b/setblock").lore(config.getCommandStatus("setblock"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("setblock");

                    config.get().set("commands.setblock", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(39, () -> new ItemBuilder(Material.BREWING_STAND).name("§b/clone").lore(config.getCommandStatus("clone"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("clone");

                    config.get().set("commands.clone", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(40, () -> new ItemBuilder(Material.OAK_SAPLING).name("§b/place").lore(config.getCommandStatus("place"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("place");

                    config.get().set("commands.place", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(41, () -> new ItemBuilder(Material.WATER_BUCKET).name("§b/fillbiome").lore(config.getCommandStatus("fillbiome"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("fillbiome");

                    config.get().set("commands.fillbiome", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(42, () -> new ItemBuilder(Material.BOOK).name("§b/data").lore(config.getCommandStatus("data"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("data");

                    config.get().set("commands.data", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(43, () -> new ItemBuilder(Material.COMMAND_BLOCK).name("§b/execute").lore(config.getCommandStatus("execute"), "§e§oClick to modify").build(), (inv, event) -> {
                    boolean blocked = config.isCommandBlocked("execute");

                    config.get().set("commands.execute", !blocked);
                    config.save();

                    inv.refresh();
                })
                .item(53, () -> new ItemBuilder(Material.ARROW).name("§b§oPage 2").lore("§e§oClick to open").build(), (inv, event) -> {
                    inv.close();
                    commands_page2.open(player);
                })
                .build();

        commands_page1.open(player);
    }

}
