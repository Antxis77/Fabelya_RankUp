package fr.anthonydu77.rankup.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.utils
 */

public interface GuiBuilder {

    public abstract String setName();

    public abstract int setSize();

    public abstract void setContents(Player player, Inventory inv);

    public abstract void onClick(Player player, Inventory inv, ItemStack item, int slot);
}
