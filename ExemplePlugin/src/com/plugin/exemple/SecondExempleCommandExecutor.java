package com.plugin.exemple;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public class SecondExempleCommandExecutor implements CommandExecutor {

	private Exemple plugin; // pointeur vers la classe principale
	 
	public SecondExempleCommandExecutor(Exemple plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("getPet")){
			if (sender instanceof Player) {
		           Player player = (Player) sender;
		           player.getInventory().addItem(new ItemStack(Material.DRAGON_EGG));
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
