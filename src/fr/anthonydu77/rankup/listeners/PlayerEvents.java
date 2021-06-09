package fr.anthonydu77.rankup.listeners;

import fr.anthonydu77.rankup.Main;
import fr.anthonydu77.rankup.managers.apiclass.RankUpManagers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.listeners
 */

public class PlayerEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!(RankUpManagers.getTeamsManager().alreadyCreate(e.getPlayer()))) {
            Main.getInstance().getLogger().info(Main.getInstance().getLog_prefix() + "data player create at player name : " + e.getPlayer());
        }
    }
}
