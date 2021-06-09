package fr.anthonydu77.rankup.commands;

import fr.anthonydu77.rankup.Main;
import fr.anthonydu77.rankup.managers.apiclass.RankUpManagers;
import fr.anthonydu77.rankup.managers.config.RankName;
import fr.anthonydu77.rankup.managers.config.RankUpSettings;
import fr.anthonydu77.rankup.managers.lang.Lang;
import fr.anthonydu77.rankup.managers.lang.LangValue;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.commands
 */

public class RankUpCommands implements TabExecutor {

    final private RankUpManagers rankUpManagers = RankUpManagers.getTeamsManager();
    final private RankUpSettings rankUpSettings = Main.getInstance().getRankUpSettings();
    String sRankName;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Lang.SERVEUR_NAME_CONSOLE.get() + Lang.MOD_TO_CONSOLE.get());
            return false;

        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("rankup")) {
            if (args.length == 0) {
                player.sendMessage(Lang.SERVEUR_NAME.get() + Lang.MSG_SYNTAXE_RANKUP.get());
                return false;
            }

            switch (args[0].toLowerCase()) {

                case "help":
                    player.sendMessage(" === === RankUp Help === ===");

                    player.sendMessage(" /rankup up   : Pour rankup");
                    player.sendMessage(" /rankup info : Savoir si on peut rankup");

                    player.sendMessage(" === === RankUp Help === ===");
                    break;

                case "up":
                    switch (rankUpManagers.getRankName(player)) {

                        /**
                         * Rank : Gueux
                         * @param 20_Mobs
                         * @param 16_Iron_Ingot
                         * @param 1000_Money
                         */
                        case "Gueux":

                            if (onLookUp(player, rankUpManagers.getMobs(player), rankUpSettings.getGueux_mobs_kill()
                                    , Lang.MSG_MOBS_KILL.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getGueux_mobs_kill() - rankUpManagers.getMobs(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getIron_Ingot(player), rankUpSettings.getGueux_iron_ingot()
                                    , Lang.MSG_IRON_INGOT.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getGueux_iron_ingot() - rankUpManagers.getIron_Ingot(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getMoney(player), rankUpSettings.getGueux_money()
                                    , Lang.MSG_MONEY.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getGueux_money() - rankUpManagers.getMoney(player)))))return true;

                            player.sendMessage("Vous etes passez au rank de Campagnard");
                            rankUpManagers.setRankName(player, RankName.CAMPAGNARD.getRankName());

                            break;

                        /**
                         * Rank : Campagnard
                         * @param 50_Mobs
                         * @param 32_Iron_Ingot
                         * @param 8_Gold_Ingot
                         * @param 3000_Money
                         */
                        case "Campagnard":

                            if (onLookUp(player, rankUpManagers.getMobs(player), rankUpSettings.getCampagnard_mobs_kill()
                                    , Lang.MSG_MOBS_KILL.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getCampagnard_mobs_kill() - rankUpManagers.getMobs(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getIron_Ingot(player), rankUpSettings.getCampagnard_iron_ingot()
                                    , Lang.MSG_IRON_INGOT.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getCampagnard_iron_ingot() - rankUpManagers.getIron_Ingot(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getIron_Ingot(player), rankUpSettings.getCampagnard_gold_ingot()
                                    , Lang.MSG_GOLD_INGOT.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getCampagnard_gold_ingot() - rankUpManagers.getIron_Ingot(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getMoney(player), rankUpSettings.getCampagnard_money()
                                    , Lang.MSG_MONEY.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getCampagnard_money() - rankUpManagers.getMoney(player)))))return true;

                            player.sendMessage("Vous etes passez au rank de Campagnard");
                            rankUpManagers.setRankName(player, RankName.VILLAGEOIS.getRankName());

                            break;

                        /**
                         * Rank : Villageois
                         * @param 100_Mobs
                         * @param 64_Iron_Ingot
                         * @param 32_Gold_Ingot
                         * @param 3_diamond_ingot
                         * @param 5_gold_apple
                         * @param 3000_Money
                         */
                        case "Villageois":

                            if (onLookUp(player, rankUpManagers.getMobs(player), rankUpSettings.getVillageois_mobs_kill()
                                    , Lang.MSG_MOBS_KILL.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_mobs_kill() - rankUpManagers.getMobs(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getIron_Ingot(player), rankUpSettings.getVillageois_iron_ingot()
                                    , Lang.MSG_IRON_INGOT.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_iron_ingot() - rankUpManagers.getIron_Ingot(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getIron_Ingot(player), rankUpSettings.getVillageois_gold_ingot()
                                    , Lang.MSG_GOLD_INGOT.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_gold_ingot() - rankUpManagers.getIron_Ingot(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getMoney(player), rankUpSettings.getVillageois_diamond_ingot()
                                    , Lang.MSG_MONEY.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_diamond_ingot() - rankUpManagers.getMoney(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getMoney(player), rankUpSettings.getVillageois_gold_apple()
                                    , Lang.MSG_MONEY.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_gold_apple() - rankUpManagers.getMoney(player)))))return true;
                            if (onLookUp(player, rankUpManagers.getMoney(player), rankUpSettings.getVillageois_money()
                                    , Lang.MSG_MONEY.get().replace(LangValue.AMOUNT.toName(), String.valueOf(rankUpSettings.getVillageois_money() - rankUpManagers.getMoney(player)))))return true;
                            player.sendMessage("Vous etes passez au rank de Ouvrier");
                            rankUpManagers.setRankName(player, RankName.OUVRIER.getRankName());


                            break;

                        case "Ouvrier":

                            break;

                        case "Ecuyer":

                            break;

                        case "Cavalier":

                            break;

                        case "Caporal":

                            break;

                        case "Colonels":

                            break;

                        case "Marechal":

                            break;

                        case "Commandant":

                            break;

                        case "Compte":

                            break;

                        case "Souverain":

                            break;

                        case "Roi":

                            break;

                        case "Empereur":

                            break;

                    }

                    // TODO: 02/06/2021 Regarder si il peux up si oui le up
                    break;

                case "info":
                    switch (rankUpManagers.getRankName(player)) {

                        case "Gueux":

                            break;

                        case "Campagnard":

                            break;

                        case "Villageois":

                            break;

                        case "Ouvrier":

                            break;

                        case "Ecuyer":

                            break;

                        case "Cavalier":

                            break;

                        case "Caporal":

                            break;

                        case "Colonels":

                            break;

                        case "Marechal":

                            break;

                        case "Commandant":

                            break;

                        case "Compte":

                            break;

                        case "Souverain":

                            break;

                        case "Roi":

                            break;

                        case "Empereur":

                            break;
                    }
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

    private boolean onLookUp(Player player, double nombrePlayer, double nombreRank, String sMessage) {
        if (nombrePlayer == nombreRank){
            player.sendMessage(Lang.SERVEUR_NAME.get() + sMessage);
            return true;
        } else {
            return false;
        }
    }
}
