package me.ProSl3nderMan.Events;

import me.ProSl3nderMan.ProNano.Main;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnMoveEvent implements Listener {
	public OnMoveEvent(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	public static ArmorStand m = null;

	@EventHandler
    public void onMove(PlayerMoveEvent event){
        if (m==null) return;
        Player p = event.getPlayer();
        Location to = p.getLocation().clone();
        
        double x = Math.cos(Math.toRadians(p.getLocation().getYaw() - 180)) * 1;
        double z = Math.sin(Math.toRadians(p.getLocation().getYaw() - 180)) * 1;

        to.setDirection(p.getLocation().getDirection());
        m.teleport(to);
    }

    public static void setNano(ArmorStand nano) {
	    m = nano;
    }
}
