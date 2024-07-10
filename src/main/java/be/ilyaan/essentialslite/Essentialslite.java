package be.ilyaan.essentialslite;

import be.ilyaan.essentialslite.commands.*;
import be.ilyaan.essentialslite.listeners.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Essentialslite extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new RepairSignListener(), this);
        getCommand("gmc").setExecutor(new GameModeCreativeCommand());
        getCommand("gms").setExecutor(new GameModeSurvivalCommand());
        getCommand("gma").setExecutor( new GameModeAdventureCommand());
        getCommand("gmsp").setExecutor(new GameModeSpectatorCommand());
        getCommand("repair").setExecutor(new RepairCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
