package com.plugin.exemple;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class ExempleCommandExecutor implements CommandExecutor {

	private Exemple plugin; // pointeur vers la classe principale
	 
	public ExempleCommandExecutor(Exemple plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
			
		switch(cmd.getName().toLowerCase()){
		case "spawncow" :
			if (sender instanceof Player) {
				Player player = (Player) sender;
				EntityType vache = EntityType.COW;
				World monde = player.getWorld();
	    		monde.spawnEntity(player.getLocation().add(2, 0, 0), vache);
			}
			else{
				sender.sendMessage("You must be a player!");
			}
			break;
		case "":
			if (sender instanceof Player) {
				Player player = (Player) sender;
			    player.getInventory().addItem(new ItemStack(Material.DRAGON_EGG));
			    ItemStack eggpet = new ItemStack(Material.EGG);
			    ItemMeta MetaOeufPet = eggpet.getItemMeta();
			    MetaOeufPet.setDisplayName("BITEEEEE0");
			}
			else{
				sender.sendMessage("You must be a player!");
			}
			break;
		}
		return false;
	}
}
