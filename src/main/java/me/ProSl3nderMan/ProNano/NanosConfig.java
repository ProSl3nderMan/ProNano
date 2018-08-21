package me.ProSl3nderMan.ProNano;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

public class NanosConfig {
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;
	
	public void reloadNanos() {
		if (customConfigFile == null) {
		    customConfigFile = new File(Main.plugin.getDataFolder(), "nanos.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(Main.plugin.getResource("nanos.yml"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (defConfigStream != null) {
		    YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
		    customConfig.setDefaults(defConfig);
		}
	}
	public FileConfiguration getNanos() {
		if (customConfig == null) {
	        reloadNanos();
	    }
	    return customConfig;
	}
	public void saveNanos() {
		if (customConfig == null || customConfigFile == null) {
	        return;
	    }
	    try {
	        getNanos().save(customConfigFile);
	    } catch (IOException ex) {
	        Main.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
	    }
	}
	public void srNanos() {
		saveNanos();
		reloadNanos();
	}
	public void saveDefaultNanos() {
	    if (customConfigFile == null) {
	        customConfigFile = new File(Main.plugin.getDataFolder(), "nanos.yml");
	    	Main.plugin.getLogger().info("Generating config.yml");
	    	getNanos().options().copyDefaults(true);
	    	saveDefaultNanos();
	      
	    	Main.plugin.getLogger().info("nanos.yml has been created!");
	    }
	    if (!customConfigFile.exists()) {            
	         Main.plugin.saveResource("nanos.yml", false);
	     }
	}
}
