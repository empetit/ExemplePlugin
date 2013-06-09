package com.plugin.exemple;


import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
 
public class ExempleListenner implements Listener {
	
	public Exemple plugin;
	
	public ExempleListenner(Exemple pl){
		plugin = pl;
	}
	
    @EventHandler
    public void joinGame(PlayerJoinEvent  event) {
    	event.getPlayer().sendMessage(ChatColor.AQUA+ " Ce serveur utilise le plugin v"+ plugin.getDescription().getVersion());
    }
}