package fr.anthonydu77.rankup.utils;

import java.util.HashMap;
import java.util.Map;

import fr.anthonydu77.rankup.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.anthonydu77.rankup.Main;

/**
 * Created by Anthonydu77 02/06/2021 inside the package - fr.anthonydu77.rankup.utils
 */

public class GuiManager implements Listener {

    private static Map<Class<? extends GuiBuilder>, GuiBuilder> RegisteredMenus;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void setLoader(Class<? extends GuiBuilder>... Builder){
        Bukkit.getPluginManager().registerEvents(Main.getInstance().getGuiManager(), Main.getInstance());
        RegisteredMenus = new HashMap();
        for(Class<? extends GuiBuilder> Gui : Builder){
            try{
                addMenu(Gui.newInstance());
            }catch(InstantiationException | IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        ItemStack current = event.getCurrentItem();
        String name = event.getView().getTitle();

        if(event.getCurrentItem() == null){
            return;
        }

        RegisteredMenus.values().stream().filter(menu -> name.equalsIgnoreCase(menu.setName())).forEach(menu -> {
            menu.onClick(player, inv, current, event.getSlot());
            event.setCancelled(true);
        });

    }

    public void addMenu(GuiBuilder m){
        RegisteredMenus.put(m.getClass(), m);
    }

    public void open(Player player, Class<? extends GuiBuilder> gClass){

        if(!RegisteredMenus.containsKey(gClass)){
            return;
        }

        GuiBuilder menu = RegisteredMenus.get(gClass);
        Inventory inv = Bukkit.createInventory(null, menu.setSize(), menu.setName());
        menu.setContents(player, inv);

        new BukkitRunnable(){

            @Override
            public void run(){
                player.openInventory(inv);
            }

        }.runTaskLater(Main.getInstance(), 1);

    }
}
