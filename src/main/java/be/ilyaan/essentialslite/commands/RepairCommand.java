package be.ilyaan.essentialslite.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Damageable;

import java.io.Console;

public class RepairCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack item = player.getInventory().getItemInMainHand();
            player.sendMessage("You exist!");
            if (item.getItemMeta() instanceof Damageable) {
                Damageable damageable = (Damageable) item.getItemMeta();
                damageable.setDamage(0);
                item.setItemMeta(damageable);
                player.sendMessage("Item repaired!");
            }
            else player.sendMessage("You must hold an item to repair.");
        }
        System.out.println("You do not exist!");
        return true;
    }
}