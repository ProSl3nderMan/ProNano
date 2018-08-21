package me.ProSl3nderMan.ProNano;

import me.ProSl3nderMan.Commands.NanoExecutor;
import me.ProSl3nderMan.Events.OnJoinEvent;
import me.ProSl3nderMan.Events.OnMoveEvent;
import me.ProSl3nderMan.Events.OnRightClickEvent;
import me.ProSl3nderMan.Managers.NanoManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;
    public static NanosConfig NC = new NanosConfig();
    public static NanoManager NM = new NanoManager();
    public static PlayersConfig PC = new PlayersConfig();

    private double y = .5;

    public void onEnable() {
        plugin = this;

        getCommand("nano").setExecutor(new NanoExecutor(this));

        new OnRightClickEvent(this);
        new OnJoinEvent(this);
        new OnMoveEvent(this);

        NC.saveDefaultNanos();
        NC.reloadNanos();
        PC.saveDefaultPlayers();
        PC.reloadPlayers();
    }

    public void onDisable() {

    }
}
