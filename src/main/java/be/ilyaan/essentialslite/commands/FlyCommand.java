package be.ilyaan.essentialslite.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("This command can only be run by a player.");
                return true;
            }
            if (((Player) commandSender).getAllowFlight()){
                ((Player) commandSender).setAllowFlight(false);
                commandSender.sendMessage("You can no longer fly.");
                return true;
            }
            ((Player) commandSender).setAllowFlight(true);
            commandSender.sendMessage("You can now fly.");
            return true;
        }
        if (strings.length == 1){
            Player target = commandSender.getServer().getPlayer(strings[0]);
            if (target != null && strings[0].equalsIgnoreCase(target.getName())) {
                if (target.getAllowFlight()){
                    target.setAllowFlight(false);
                    commandSender.sendMessage(strings[0] + " can no longer fly.");
                    target.sendMessage("You can no longer fly.");
                    return true;
                }
                target.setAllowFlight(true);
                commandSender.sendMessage(strings[0] + " can now fly.");
                target.sendMessage("You can now fly.");
                return true;
            }
        }
        return false;
    }
}
