package com.plugin.exemple;


import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
 
public class ExempleSecondListenner implements Listener {
	
	public Exemple plugin;
	
	public ExempleSecondListenner(Exemple pl){
		plugin = pl;
	}
	
    @EventHandler
    public void joinGame(PlayerJoinEvent  event) {
    	event.getPlayer().sendMessage(ChatColor.AQUA+ " Second Listenner chargé"+ plugin.getDescription().getVersion());
    }
    
    
}