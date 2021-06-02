package fr.anthonydu77.rankup.managers.apiclass;

import fr.anthonydu77.rankup.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.managers.apiclass
 */

public class TeamsManagers {

    private static final TeamsManagers teamsManagers = new TeamsManagers();
    final private Main instance = Main.getInstance();

    List<String> lListPlayerTeams;
    List<String> lListPlayerInviteTeams;

    FileConfiguration data_Rankup;
    FileConfiguration data_players;

    List<String> lTeamsList;
    List<String> lPlayerList;

    public static TeamsManagers getTeamsManager() {
        return teamsManagers;
    }


    /**
     * Create teams and put the player creator on Owner of the teams
     *
     * @param player     Name of the player - not null
     * @return if the save is correct (boolean)
     */
    public boolean onCreate(Player player) {

        double dnbr_init = 0;

        data_Rankup.set(player + ".Rank", "Gueux");

        data_Rankup.set(player + ".Mobs", dnbr_init);
        data_Rankup.set(player + ".Money", dnbr_init);

        data_Rankup.set(player + ".Iron_Ingot", dnbr_init);
        data_Rankup.set(player + ".Gold_Ingot", dnbr_init);
        data_Rankup.set(player + ".Diamond_Ingot", dnbr_init);
        data_Rankup.set(player + ".Emerald_Ingot", dnbr_init);

        data_Rankup.set(player + ".Iron_Block", dnbr_init);
        data_Rankup.set(player + ".Gold_Block", dnbr_init);
        data_Rankup.set(player + ".Diamond_Block", dnbr_init);
        data_Rankup.set(player + ".Emerald_Block", dnbr_init);

        data_Rankup.set(player + ".Gold_Apple", dnbr_init);
        data_Rankup.set(player + ".Withers", dnbr_init);
        data_Rankup.set(player + ".Dragon", dnbr_init);
        data_Rankup.set(player + ".Boss_Guardian", dnbr_init);
        data_Rankup.set(player + ".Guardian", dnbr_init);
        data_Rankup.set(player + ".Enderman", dnbr_init);

        return onSave();
    }

    /**
     * Get if player have data
     *
     * @param player Name of the player - not null
     * @return Player have data
     */
    public boolean alreadyCreate(Player player) {
        onLoad();
        return data_Rankup.get(player.getName()) != null;
    }

    /**
     * Get if player rank
     *
     * @param player Name of the player - not null
     * @return Player rank name
     */
    public String getRankName(Player player) {
        return data_Rankup.getString(player.getName() + ".Rank");
    }

    /**
     * Get all player Mobs kill
     *
     * @param player Name of the player - not null
     * @return Player Mobs numbers
     */
    public double getMobs(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Mobs");
    }

    /**
     * Set player Mobs kill
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Mobs kill - not null
     * @return if the save is correct (boolean)
     */
    public boolean setMobs(Player player, double dNumbers) {
        data_Rankup.set(player + ".Mobs", dNumbers);
        return onSave();
    }

    /**
     * Get all player money
     *
     * @param player Name of the player - not null
     * @return Player money numbers
     */
    public double getMoney(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Money");
    }

    /**
     * Set player Money
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of money - not null
     * @return if the save is correct (boolean)
     */
    public boolean setMoney(Player player, double dNumbers) {
        data_Rankup.set(player + ".Money", dNumbers);
        return onSave();
    }

    /**
     * Get all player Iron_Ingot
     *
     * @param player Name of the player - not null
     * @return Player Iron_Ingot numbers
     */
    public double getIron_Ingot(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Iron_Ingot");
    }

    /**
     * Set player Iron_Ingot
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Iron_Ingot - not null
     * @return if the save is correct (boolean)
     */
    public boolean setIron_Ingot(Player player, double dNumbers) {
        data_Rankup.set(player + ".Iron_Ingot", dNumbers);
        return onSave();
    }

    /**
     * Get all player Gold_Ingot
     *
     * @param player Name of the player - not null
     * @return Player Gold_Ingot numbers
     */
    public double getGold_Ingot(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Gold_Ingot");
    }

    /**
     * Set player Gold_Ingot
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Gold_Ingot - not null
     * @return if the save is correct (boolean)
     */
    public boolean setGold_Ingot(Player player, double dNumbers) {
        data_Rankup.set(player + ".Gold_Ingot", dNumbers);
        return onSave();
    }

    /**
     * Get all player Diamond_Ingot
     *
     * @param player Name of the player - not null
     * @return Player Diamond_Ingot numbers
     */
    public double getDiamond_Ingot(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Diamond_Ingot");
    }

    /**
     * Set player Diamond_Ingot
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Diamond_Ingot - not null
     * @return if the save is correct (boolean)
     */
    public boolean setDiamond_Ingot(Player player, double dNumbers) {
        data_Rankup.set(player + ".Diamond_Ingot", dNumbers);
        return onSave();
    }

    /**
     * Get all player Emerald_Ingot
     *
     * @param player Name of the player - not null
     * @return Player Emerald_Ingot numbers
     */
    public double getEmerald_Ingot(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Emerald_Ingot");
    }

    /**
     * Set player Emerald_Ingot
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Emerald_Ingot - not null
     * @return if the save is correct (boolean)
     */
    public boolean setEmerald_Ingot(Player player, double dNumbers) {
        data_Rankup.set(player + ".Emerald_Ingot", dNumbers);
        return onSave();
    }

    /**
     * Get all player Iron_Block
     *
     * @param player Name of the player - not null
     * @return Player Iron_Block numbers
     */
    public double getIron_Block(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Iron_Block");
    }

    /**
     * Set player Iron_Block
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Iron_Block - not null
     * @return if the save is correct (boolean)
     */
    public boolean setIron_Block(Player player, double dNumbers) {
        data_Rankup.set(player + ".Iron_Block", dNumbers);
        return onSave();
    }

    /**
     * Get all player Gold_Block
     *
     * @param player Name of the player - not null
     * @return Player Gold_Block numbers
     */
    public double getGold_Block(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Gold_Block");
    }

    /**
     * Set player Gold_Block
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Gold_Block - not null
     * @return if the save is correct (boolean)
     */
    public boolean setGold_Block(Player player, double dNumbers) {
        data_Rankup.set(player + ".Gold_Block", dNumbers);
        return onSave();
    }

    /**
     * Get all player Diamond_Block
     *
     * @param player Name of the player - not null
     * @return Player Diamond_Block numbers
     */
    public double getDiamond_Block(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Diamond_Block");
    }

    /**
     * Set player Diamond_Block
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Diamond_Block - not null
     * @return if the save is correct (boolean)
     */
    public boolean setDiamond_Block(Player player, double dNumbers) {
        data_Rankup.set(player + ".Diamond_Block", dNumbers);
        return onSave();
    }

    /**
     * Get all player Emerald_Block
     *
     * @param player Name of the player - not null
     * @return Player Emerald_Block numbers
     */
    public double getEmerald_Block(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Emerald_Block");
    }

    /**
     * Set player Emerald_Block
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Emerald_Block - not null
     * @return if the save is correct (boolean)
     */
    public boolean setEmerald_Block(Player player, double dNumbers) {
        data_Rankup.set(player + ".Emerald_Block", dNumbers);
        return onSave();
    }

    /**
     * Get all player Gold_Apple
     *
     * @param player Name of the player - not null
     * @return Player Gold_Apple numbers
     */
    public double getGold_Apple(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Gold_Apple");
    }

    /**
     * Set player Gold_Apple
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Gold_Apple - not null
     * @return if the save is correct (boolean)
     */
    public boolean setGold_Apple(Player player, double dNumbers) {
        data_Rankup.set(player + ".Gold_Apple", dNumbers);
        return onSave();
    }

    /**
     * Get all player Withers
     *
     * @param player Name of the player - not null
     * @return Player Withers numbers
     */
    public double getWithers(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Withers");
    }

    /**
     * Set player Withers
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Withers - not null
     * @return if the save is correct (boolean)
     */
    public boolean setWithers(Player player, double dNumbers) {
        data_Rankup.set(player + ".Withers", dNumbers);
        return onSave();
    }

    /**
     * Get all player Dragon
     *
     * @param player Name of the player - not null
     * @return Player Dragon numbers
     */
    public double getDragon(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Dragon");
    }

    /**
     * Set player Dragon
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Dragon - not null
     * @return if the save is correct (boolean)
     */
    public boolean setDragon(Player player, double dNumbers) {
        data_Rankup.set(player + ".Dragon", dNumbers);
        return onSave();
    }

    /**
     * Get all player Boss_Guardian
     *
     * @param player Name of the player - not null
     * @return Player Boss_Guardian numbers
     */
    public double getBoss_Guardian(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Boss_Guardian");
    }

    /**
     * Set player Boss_Guardian
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Boss_Guardian - not null
     * @return if the save is correct (boolean)
     */
    public boolean setBoss_Guardian(Player player, double dNumbers) {
        data_Rankup.set(player + ".Boss_Guardian", dNumbers);
        return onSave();
    }

    /**
     * Get all player Guardian
     *
     * @param player Name of the player - not null
     * @return Player Guardian numbers
     */
    public double getGuardian(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Guardian");
    }

    /**
     * Set player Guardian
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Guardian - not null
     * @return if the save is correct (boolean)
     */
    public boolean setGuardian(Player player, double dNumbers) {
        data_Rankup.set(player + ".Guardian", dNumbers);
        return onSave();
    }

    /**
     * Get all player Enderman
     *
     * @param player Name of the player - not null
     * @return Player Enderman numbers
     */
    public double getEnderman(Player player) {
        onLoad();
        return data_Rankup.getDouble(player + ".Enderman");
    }

    /**
     * Set player Enderman
     *
     * @param player Name of the player - not null
     * @param dNumbers Numbers of Enderman - not null
     * @return if the save is correct (boolean)
     */
    public boolean setEnderman(Player player, double dNumbers) {
        data_Rankup.set(player + ".Enderman", dNumbers);
        return onSave();
    }

    /**
     * For save the players and teams files
     */
    public boolean onSave() {
        try {
            data_Rankup.save(instance.getFile_RankUp());
            data_players.save(instance.getFile_players());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * For load the players and teams files
     */
    private void onLoad() {
        data_Rankup = YamlConfiguration.loadConfiguration(instance.getFile_RankUp());
        data_players = YamlConfiguration.loadConfiguration(instance.getFile_players());
    }
}
