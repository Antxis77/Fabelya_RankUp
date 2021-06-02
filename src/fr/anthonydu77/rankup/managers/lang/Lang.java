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
    TEAMS_PREFIX,
    CONTACT_ADMIN,
    MOD_TO_CONSOLE,
    NO_PERMISSION,
    NO_ALLOW,
    MSG_FORMAT,
    NO_GAME,
    PLAYER_JOIN_EVENT,
    PLAYER_LEAVE_EVENT,

    //#######       Shop       #######
    SHOP_ALLOW,
    SHOP_DENY,
    PRICE_TEMPLATE,
    CLICK_FOR_BUY,

    //#######       OperatorCommands       #######
    PLAYER_ALREADY_ADD,
    PLAYER_ADD,
    PLAYER_ALREADY_REMOVE,
    PLAYER_REMOVE,
    LIST_PLAYER,
    LIST_PLAYER_NULL,

    //#######       GameMessage       #######
    MSG_GAME_PREPARE,
    MSG_GAMESTART,
    MSG_GAMESTOP,
    MSG_GAME_SPECTATOR,
    MSG_GAMESTART_SPECTATOR,

    //#######       SyntaxCommands       #######
    CMD_ADD,
    CMD_REMOVE,
    CMD_TEAMS,
    CMD_TEAMS_JOIN,
    CMD_TEAMS_LEAVE,
    CMD_TEAMS_CREATE,
    CMD_TEAMS_DISBAND,
    CMD_TEAMS_SHOW,
    CMD_TEAMS_DEPOSIT,
    CMD_TEAMS_INVITE_INFO,
    CMD_TEAMS_INVITE_ADD,
    CMD_TEAMS_INVITE_REMOVE,
    CMD_TEAMS_KICK,

    //#######       Perms       #######
    REDLANDFARM_ADMIN_PERM,
    REDLANDFARM_MODO_PERM,
    REDLANDFARM_PLAY_PERM,

    //#######       TEAMS       #######
    ALREADY_TEAMS,
    NO_TEAMS,
    NO_PLAYER_TEAMS,
    ALREADY_HAVE_TEAMS,
    NO_TARGET_TEAMS,

    //#Owner Teams :
    NO_OWNER,
    NO_OWNER_TEAMS,

    //#Money Teams :
    NO_MONEY,
    NO_AMOUNT,
    MONEY_TEAMS,
    PLAYER_DEPOSIT,

    //#Create Teams :
    CREATE_TEAMS_BROADCAST,
    CREATE_TEAMS,

    //#Disband Teams :
    DISBAND_TEAMS,
    DISBAND_TEAMS_PLAYER,
    DISBAND_TEAMS_BROADCAST,

    //#Invite Teams :
    ALREADY_INVITE_TEAMS,
    INVITE_TEAMS_PLAYER,
    OWNER_INVITE_TEAMS,
    TARGET_INVITE_TEAMS,
    INVITE_INFO,
    INVITE_REMOVE,
    NO_INVITATION,

    //#Join Teams :
    JOIN_TEAMS,
    NO_INVITE,
    JOIN_TEAMS_PLAYER,

    //#Leave Teams :
    LEAVE_TEAMS,
    LEAVE_PLAYER,

    //#Kick Teams :
    OWNER_KICK,
    PLAYER_KICK,
    TARGET_KICK,

    //#######       Other       #######
    NO_PLAYER,
    MSG_SYNTAXE_TEAMS,
    MSG_SYNTAXE_TEAMS_INVITE,
    MSG_SYNTAXE_PLAYER,
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
