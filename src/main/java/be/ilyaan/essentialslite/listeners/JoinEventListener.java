package be.ilyaan.essentialslite.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEventListener  implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6Welcome to the server " + player.getName() + "!"));
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(null);
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6Goodbye " + player.getName() + "!"));
    }
}
