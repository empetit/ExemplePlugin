package com.plugin.exemple;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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
    
    public void useDragonEgg(PlayerInteractEvent event){
    	if ((event.getAction()==Action.RIGHT_CLICK_BLOCK) && (event.getPlayer().getItemInHand().getType() == Material.STICK)){
    		World world = event.getPlayer().getWorld();
    		EntityType vache = EntityType.COW;
    		world.spawnEntity(event.getPlayer().getLocation(), vache);
    	}
    }
}