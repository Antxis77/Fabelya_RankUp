package fr.anthonydu77.rankup;

import fr.anthonydu77.rankup.managers.YmlFile;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup
 */

public class Main extends JavaPlugin {

    private static Main instance;
    private static final Logger log = Logger.getLogger("Minecraft");
    private final String log_prefix = "[RedLandFarm] - ";
    private static Economy economy;
    private File fFileTeams;
    private File fFilePlayers;

    @Override
    public void onEnable() {
        log.info(log_prefix + "---------- " + getDescription().getFullName() + " ----------");
        log.info(log_prefix + "Starting RedLandFarm ...");
        log.info(log_prefix + "Author : " + getDescription().getAuthors());
        log.info(log_prefix + "Description : " + getDescription().getDescription());
        log.info(log_prefix + "WebSite : " + getDescription().getWebsite());
        log.info(log_prefix + "Version : " + getDescription().getVersion());
        log.info(log_prefix + "If you have any problem contact me at discord : Antho77_#1536");
        instance = this;


        log.info(log_prefix + "RedLandFarm status is ready");
        log.info(log_prefix + "---------- " + getDescription().getFullName() + " ----------");
    }

    @Override
    public void onDisable() {
        log.info(log_prefix + "---------- " + getDescription().getFullName() + " ----------");
        log.info(log_prefix + "RedLandFarm is shutting off");
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));


        log.info(log_prefix + "RedLandFarm status is off");
        log.info(log_prefix + "---------- " + getDescription().getFullName() + " ----------");
    }

    private void registerYamls() {

        fFileTeams = new File(Main.getInstance().getDataFolder(), "teams.yml");

        fFilePlayers = new File(Main.getInstance().getDataFolder(), "players.yml");

        YmlFile.LANG.create(log);

        log.info(log_prefix + "Register Yaml is done !");
    }

    public static Main getInstance() {
        return instance;
    }

    private Object registerYamls(YmlFile yml, Class<?> clazz) {
        yml.create(log);
        try (final Reader reader = Files.newBufferedReader(yml.getFile().toPath(), StandardCharsets.UTF_8)) {
            final Yaml yaml = new Yaml(new CustomClassLoaderConstructor(getClassLoader()));
            yaml.setBeanAccess(BeanAccess.FIELD);
            log.info(log_prefix + "Configuration file read successfully");
            return yaml.loadAs(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileConfiguration loadFile(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public File getFile_teams() {
        return fFileTeams;
    }

    public File getFile_players() {
        return fFilePlayers;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public String getLog_prefix() {
        return log_prefix;
    }
}
