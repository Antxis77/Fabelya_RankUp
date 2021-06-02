package fr.anthonydu77.rankup.gui;

import fr.anthonydu77.rankup.utils.GuiBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.gui
 */

public class RankUpGui implements GuiBuilder {
    @Override
    public String setName() {
        return null;
    }

    @Override
    public int setSize() {
        return 0;
    }

    @Override
    public void setContents(Player player, Inventory inv) {

    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack item, int slot) {

    }
}
