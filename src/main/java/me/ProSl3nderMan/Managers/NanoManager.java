package me.ProSl3nderMan.Managers;

import me.ProSl3nderMan.Events.OnMoveEvent;
import me.ProSl3nderMan.ProNano.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class NanoManager {

    private HashMap<String, Integer> counter = new HashMap<String, Integer>();

	public void nanoReturn(Player p, Integer slot) {
		
	}

	public void nanoSendOut(final Player p, final Integer slot) {
		Location loc = p.getLocation();
		final ArmorStand m = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
		Bukkit.broadcast("" + m.getUniqueId(), "asdf");
		p.sendMessage("" + m.getUniqueId());
		m.setSmall(true);
		m.setGravity(false);
		m.setBasePlate(false);
		ItemStack nano = new ItemStack(Material.SKULL_ITEM, 1);
		SkullMeta meta = (SkullMeta) nano.getItemMeta();
		meta.setOwner(p.getName());
		nano.setItemMeta(meta);
		m.setHelmet(nano);
		ItemStack leather = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta leatherm = (LeatherArmorMeta)leather.getItemMeta();
		leatherm.setColor(Color.fromRGB(170, 170, 170));
		leather.setItemMeta(leatherm);
		m.setChestplate(leather);
		leather = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		leatherm = (LeatherArmorMeta)leather.getItemMeta();
		leatherm.setColor(Color.fromRGB(170, 170, 170));
		leather.setItemMeta(leatherm);
		m.setLeggings(leather);
		leather = new ItemStack(Material.LEATHER_BOOTS, 1);
		leatherm = (LeatherArmorMeta)leather.getItemMeta();
		leatherm.setColor(Color.fromRGB(170, 170, 170));
		leather.setItemMeta(leatherm);
		m.setLeggings(leather);


        OnMoveEvent.setNano(m);
	}
}
