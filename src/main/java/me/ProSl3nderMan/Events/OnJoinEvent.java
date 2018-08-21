package me.ProSl3nderMan.Events;

import me.ProSl3nderMan.ProNano.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinEvent implements Listener{
	public OnJoinEvent(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		//Player p = e.getPlayer();
	}
}
