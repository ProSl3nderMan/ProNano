package me.ProSl3nderMan.ProNano;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

public class PlayersConfig {
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;
	
	public void reloadPlayers() {
		if (customConfigFile == null) {
		    customConfigFile = new File(Main.plugin.getDataFolder(), "players.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(Main.plugin.getResource("players.yml"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (defConfigStream != null) {
		    YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
		    customConfig.setDefaults(defConfig);
		}
	}
	public FileConfiguration getPlayers() {
		if (customConfig == null) {
	        reloadPlayers();
	    }
	    return customConfig;
	}
	public void savePlayers() {
		if (customConfig == null || customConfigFile == null) {
	        return;
	    }
	    try {
	        getPlayers().save(customConfigFile);
	    } catch (IOException ex) {
	        Main.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
	    }
	}
	public void srPlayers() {
		savePlayers();
		reloadPlayers();
	}
	public void saveDefaultPlayers() {
	    if (customConfigFile == null) {
	        customConfigFile = new File(Main.plugin.getDataFolder(), "players.yml");
	    	Main.plugin.getLogger().info("Generating config.yml");
	    	getPlayers().options().copyDefaults(true);
	    	saveDefaultPlayers();
	      
	    	Main.plugin.getLogger().info("players.yml has been created!");
	    }
	    if (!customConfigFile.exists()) {            
	         Main.plugin.saveResource("players.yml", false);
	     }
	}
}
