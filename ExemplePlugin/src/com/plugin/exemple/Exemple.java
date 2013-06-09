package com.plugin.exemple;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Exemple extends JavaPlugin {
	
	private ExempleListenner listen = new ExempleListenner(this);
	
    File configFile;
    FileConfiguration config;
	ConfigManager configManager;
    
	@Override
    public void onEnable(){

	    //chargement des donn�es du fichier de config
		configManager = new ConfigManager(this);
	    configManager.loadYamls();
	    
	    //cr�ation d'ub listenner
	    // 1- creation du plugin manager
		PluginManager pm = getServer().getPluginManager();
		//2- ajout du listenner au pluginmanager
		pm.registerEvents(this.listen,this);
		
		//enregistre la commande basique dont le code est d�taill� dans la classe "ExempleCommandExecutor"
		// utile si on �crit ensemble des commandes on peut faire chacun un fichier
		// /!\ la commande doit etre pr�sente dans plugin.yml
		getCommand("basic").setExecutor(new ExempleCommandExecutor(this));
    }
    @Override
    public void onDisable() {
    	//sauvegarde de la config
    	configManager.saveYamls();
    }
}
