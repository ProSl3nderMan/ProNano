package me.ProSl3nderMan.Commands;

import me.ProSl3nderMan.ProNano.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.logging.Level;

public class NanoExecutor implements CommandExecutor {

	public NanoExecutor(Main main) {}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player)sender;
		if (!p.isOp()) {
			p.sendMessage(ChatColor.RED + "You must be an op to do this.");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage(ChatColor.DARK_GREEN + "/nano usage:");
			p.sendMessage(ChatColor.GREEN + "/nano give <player> <nano name> " + ChatColor.DARK_GREEN + "- Gives a player a nano."  );
			p.sendMessage(ChatColor.GREEN + "/nano names " + ChatColor.DARK_GREEN + "- Gives a list of Nano Names.");
			p.sendMessage(ChatColor.GREEN + "/nano create <Nano Name> <Player Skull> <Ability> <Tier of Ability> " + ChatColor.DARK_GREEN + "- Creates a nano.");
			return true;
		}
		if (args[0].equalsIgnoreCase("give")) {
			if (args.length != 3) {
				p.sendMessage(ChatColor.RED + "Incorrect arguements, correct arguements: '/nano give <player> <nano name>'.");
				return true;
			}
			if (Bukkit.getPlayer(args[1]) == null) {
				p.sendMessage(ChatColor.RED + "The player " + args[1] + " does not exist.");
				return true;
			}
			if (p.getInventory().firstEmpty() == -1) {
				p.sendMessage(ChatColor.RED + "This player's inventory is full");
				return true;
			}
			
			ItemStack nano = new ItemStack(Material.SKULL_ITEM, 1);
			SkullMeta meta = (SkullMeta) nano.getItemMeta();
    		meta.setOwningPlayer(Bukkit.getPlayer(args[2].toLowerCase()));
    		meta.setDisplayName(args[2].toLowerCase() + ".name");
    		nano.setItemMeta(meta);
			p.getInventory().addItem(nano);
			p.sendMessage(ChatColor.GOLD + "Player " + args[1] + " was given the Nano " + args[2] + "!");
			Bukkit.getLogger().log(Level.FINE, "[ProNano]Player " + p.getName() + " just gave player " + args[1] + " the nano " + args[2] + ".");
			return true;
		}
		if (args[0].equalsIgnoreCase("names")) {
			
			return true;
		}
		if (args[0].equalsIgnoreCase("create")) {
			
		}
		return true;
	}

}
