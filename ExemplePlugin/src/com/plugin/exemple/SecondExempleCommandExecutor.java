package com.plugin.exemple;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class SecondExempleCommandExecutor implements CommandExecutor {

	private Exemple plugin; // pointeur vers la classe principale
	 
	public SecondExempleCommandExecutor(Exemple plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("getPet")){ //Ajout d'un nouvelle oeuf avec un nom 
			if (sender instanceof Player) {			   //definissable et une description particuliere
		           Player player = (Player) sender;
		           player.sendMessage(ChatColor.AQUA+ " Nouvelle oeuf Ok");
		           ItemStack oeufpet;
		           oeufpet = new ItemStack(Material.EGG);
		           ItemMeta MetaOeufPet = oeufpet.getItemMeta();
		           if(args.length > 0){
		        	   MetaOeufPet.setDisplayName("Oeuf de"+ args[0]);
		           }
		           ArrayList<String> lore = new ArrayList <String>();
		           lore.add("test1");
		           lore.add("test2");
		           lore.add("test3");
		           lore.add("test4");
		           MetaOeufPet.setLore(lore);
		           oeufpet.setItemMeta(MetaOeufPet);
		          player.getInventory().addItem(oeufpet);
		        } else {
		           sender.sendMessage("You must be a player!");
		           return false;
		        }
		        // do something
		        return false;
		}else{
			return false;
		}
	}

}
