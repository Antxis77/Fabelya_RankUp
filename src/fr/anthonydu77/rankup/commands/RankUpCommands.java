package fr.anthonydu77.rankup.commands;

import fr.anthonydu77.rankup.managers.lang.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.commands
 */

public class RankUpCommands implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Lang.SERVEUR_NAME_CONSOLE.get() + Lang.MOD_TO_CONSOLE.get());
            return false;

        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("rankup")) {
            if (args.length == 0) {
                player.sendMessage(Lang.SERVEUR_NAME.get() + Lang.MSG_SYNTAXE_PLAYER.get());
                return false;
            }

            switch (args[0].toLowerCase()) {

                case "help":
                    player.sendMessage(" === === RankUp Help === ===");

                    player.sendMessage(" === === RankUp Help === ===");
                    break;

                case "up":
                    // TODO: 02/06/2021 Regarder si il peux up si oui le up
                    break;

                case "info":
                    // TODO: 02/06/2021 Lire les information qui reste a faire
                    break;
            }

        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return null;
    }
}
