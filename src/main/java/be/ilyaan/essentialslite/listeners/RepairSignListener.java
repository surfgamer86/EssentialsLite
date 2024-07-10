package be.ilyaan.essentialslite.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RepairSignListener implements Listener {
    @EventHandler
    public void signClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null) {
            Block clickedBlock = e.getClickedBlock();
            if (clickedBlock.getType() == Material.OAK_SIGN || clickedBlock.getType() == Material.OAK_WALL_SIGN) {
                Sign sign = (Sign) clickedBlock.getState();
                String line1 = sign.getLine(0);
                if (line1.equalsIgnoreCase("repair")) {
                    e.setCancelled(true);
                    Player player = e.getPlayer();
                    player.performCommand("repair");
                }
            }
        }
    }
}