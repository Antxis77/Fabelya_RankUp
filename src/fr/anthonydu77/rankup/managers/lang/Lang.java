package fr.anthonydu77.rankup.managers.lang;

import fr.anthonydu77.rankup.Main;
import fr.anthonydu77.rankup.managers.YmlFile;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthonydu77 13/12/2020 inside the package - fr.anthonydu77.modmoderation.managers.lang
 */

public enum Lang {

    //#######       EssentialAdmin       #######
    SERVEUR_NAME,
    SERVEUR_NAME_CONSOLE,
    NO_PERMISSION,
    NO_ALLOW,
    MOD_TO_CONSOLE,

    MSG_MOBS_KILL,
    MSG_MONEY,
    MSG_IRON_INGOT,
    MSG_GOLD_INGOT,
    MSG_DIAMOND_INGOT,
    MSG_EMERALD_INGOT,
    MSG_IRON_BLOCK,
    MSG_GOLD_BLOCK,
    MSG_DIAMOND_BLOCK,
    MSG_EMERALD_BLOCK,
    MSG_GOLD_APPLE,
    MSG_CHEAT_APPLE,
    MSG_WITHERS_KILL,
    MSG_DRAGONS_KILL,
    MSG_GUARDIANS_BOSS_KILL,
    MSG_GUARDIANS_KILL,
    MSG_ENDERMANS_KILL,
    MSG_SKELETONS_KILL,
    MSG_ZOMBIES_KILL,

    MSG_SYNTAXE_RANKUP,

    EMPTY;

    private static final Map<Lang, String> VALUES = new HashMap<>();

    static {
        for (Lang lang : values()) {
            VALUES.put(lang, lang.getFromFile());
        }
        Main.getInstance().getLogger().info("Lang file read successfuly !");
    }

    public String get() {
        return VALUES.get(this);
    }

    private String getFromFile() {
        FileConfiguration config = YmlFile.LANG.getConfig();
        String key = name().toLowerCase().replace('_', '-');
        String value = config.getString(key);

        if (value == null) {
            value = "";
        }

        return ChatColor.translateAlternateColorCodes('&', value);
    }
}
