package be.ilyaan.essentialslite;

import be.ilyaan.essentialslite.commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Essentialslite extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("gmc").setExecutor(new GameModeCreativeCommand());
        getCommand("gms").setExecutor(new GameModeSurvivalCommand());
        getCommand("gma").setExecutor( new GameModeAdventureCommand());
        getCommand("gmsp").setExecutor(new GameModeSpectatorCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
