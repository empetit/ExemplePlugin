package com.plugin.exemple;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class exemple extends JavaPlugin {
	
	private ExempleListenner listen = new ExempleListenner(this);
    File configFile;
    FileConfiguration config;
	
	@Override
    public void onEnable(){
		//chargement de la configuration 
	    configFile = new File(getDataFolder(), "config.yml");
	    
	    try {
	        firstRun();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    config = new YamlConfiguration();
	    loadYamls();
	    
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.listen,this);
		
		getLogger().info("Plugin exemple active ! :)");
    }
    @Override
    public void onDisable() {
    	saveYamls();
    	getLogger().info("Plugin exemple desactive ! :(");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("exemple") && (sender instanceof Player)){
    		switch(args.length){
    			case 0 :
    				sender.sendMessage("Plugin exemple V"+getDescription().getVersion());
    				break;
		        default: return false;
    		}
	        return true;
    	} else if (cmd.getName().equalsIgnoreCase("exemple") && args.length > 0) {
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("Rechargement du plugin (fake)");
    		}
    		return true;
    	}
    	return false;
    }
    

	
	private void firstRun() throws Exception {
	    if(!configFile.exists()){
	        configFile.getParentFile().mkdirs();
	        copy(getResource("config.yml"), configFile);
	    }
	}
	
	private void copy(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void saveYamls() {
	    try {
	        config.save(configFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void loadYamls() {
	    try {
	        config.load(configFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
