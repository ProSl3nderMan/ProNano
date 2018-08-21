package me.ProSl3nderMan.Events;

import me.ProSl3nderMan.ProNano.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnRightClickEvent implements Listener {
	public OnRightClickEvent(Main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInMainHand().getType() == Material.SKULL_ITEM) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Main.NM.nanoSendOut(p, p.getInventory().getHeldItemSlot());
			}
		}
	}
}
