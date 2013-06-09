package com.plugin.exemple;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
 
public class ExempleTroisiemeListenner implements Listener {
	
	public Exemple plugin;
	
	public ExempleTroisiemeListenner(Exemple pl){
		plugin = pl;
	}
	
    @EventHandler
    public void joinGame(PlayerJoinEvent  event) {
    	event.getPlayer().sendMessage(ChatColor.AQUA+ " Second Listenner chargé"+ plugin.getDescription().getVersion());
    }

    @EventHandler
    public void summonPet(PlayerInteractEvent event) {
    	if(event.getAction() == Action.LEFT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType() == Material.DRAGON_EGG ){
        	World monde = event.getPlayer().getWorld();
        	Block blocCible = event.getClickedBlock();
        	monde.spawnEntity(blocCible.getLocation().add(0, 2, 0), EntityType.BAT).setPassenger(event.getPlayer());
    	}
    }
    
}