package be.ilyaan.essentialslite.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeSurvivalCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return true;
            }
            ((Player) sender).setGameMode(GameMode.SURVIVAL);
            sender.sendMessage("Your gamemode has been updated to Survival");
            return true;
        }
        if (args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);
            if (target != null && args[0].equalsIgnoreCase(target.getName())) {
                target.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(args[0] + "'s gamemode has been updated to Survival");
                target.sendMessage("Your gamemode has been updated to Survival");
                return true;
            }
        }
        return true;
    }
}
