package com.plugin.exemple;

import java.io.Console;
import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.corba.se.impl.activation.CommandHandler;

public final class Exemple extends JavaPlugin {

	private ExempleListenner listen = new ExempleListenner(this);
	
	private ExempleSecondListenner secondListen = new ExempleSecondListenner(this);
	
	private ExempleTroisiemeListenner troisiemListen = new ExempleTroisiemeListenner(this);
	
    File configFile;
    FileConfiguration config;
	ConfigManager configManager;
    
	@Override
    public void onEnable(){

	    //chargement des données du fichier de config
		configManager = new ConfigManager(this);
	    configManager.loadYamls();
	    getLogger().info("Chargement de la configuration");
	    //création d'ub listenner
	    // 1- creation du plugin manager
		PluginManager pm = getServer().getPluginManager();
		//2- ajout du listenner au pluginmanager
		pm.registerEvents(this.listen,this);
		pm.registerEvents(this.secondListen,this);
		pm.registerEvents(this.troisiemListen,this);

	    getLogger().info("Enregistrement des evenements");
	    
		//enregistre la commande basique dont le code est détaillé dans la classe "ExempleCommandExecutor"
		// utile si on écrit ensemble des commandes on peut faire chacun un fichier
		// /!\ la commande doit etre présente dans plugin.yml
	    try {
			getCommand("exemple").setExecutor(new TroisiemeExempleCommandExecutor(this));
			getCommand("getPet").setExecutor(new SecondExempleCommandExecutor(this));
			getCommand("spawncow").setExecutor(new ExempleCommandExecutor(this));
		} catch (Exception e) {
			if(e instanceof NullPointerException){
				Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "La commande n'as pas été chargée par elle n'est pas définie dans le plugin.yml");
			}
		}

	    getLogger().info("Enregistrement des commandes");
    }
    @Override
    public void onDisable() {
    	//sauvegarde de la config
    	configManager.saveYamls();
    }
}
