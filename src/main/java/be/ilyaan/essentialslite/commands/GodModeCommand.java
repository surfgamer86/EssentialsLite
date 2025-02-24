package be.ilyaan.essentialslite.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;


public class GodModeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return true;
            }
            ((Player) sender).setInvulnerable(true);
            sender.sendMessage("You are now invulnerable.");
            return true;
        }
        if (args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);
            if (target != null && args[0].equalsIgnoreCase(target.getName())) {
                target.setInvulnerable(true);
                sender.sendMessage(args[0] + " is now invulnerable.");
                target.sendMessage("You are now invulnerable.");
                return true;
            }
        }
        return true;
    }
}
