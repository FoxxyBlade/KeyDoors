package com.foxdev.keydoor.Interaction;

import com.foxdev.keydoor.KeyDoor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class GetDoor implements Listener {


    private KeyDoor main;

    int count = 10;

    public GetDoor(KeyDoor main){
         this.main = main;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE)) {
            if (e.getClickedBlock().getType() == Material.IRON_DOOR) {
                if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
                    p.sendMessage(ChatColor.GOLD + "U heeft een deur geopend!");


                    Door d = (Door) e.getClickedBlock().getBlockData();
                    d.setOpen(true);
                    e.getClickedBlock().setBlockData(d);

                    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                    scheduler.scheduleSyncDelayedTask(KeyDoor.Instance, new Runnable() {
                        @Override
                        public void run() {
                            if (count == 10) {
                            }
                            p.sendMessage("De deur is gesloten!");
                            d.setOpen(false);
                            e.getClickedBlock().setBlockData(d);
                            count--;
                        }

                    }, 100);

                }

            }


        }

    }

}
