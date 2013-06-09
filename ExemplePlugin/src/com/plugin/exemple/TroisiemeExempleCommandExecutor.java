package com.plugin.exemple;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class TroisiemeExempleCommandExecutor implements CommandExecutor {

	private Exemple plugin; // pointeur vers la classe principale
	 
	public TroisiemeExempleCommandExecutor(Exemple plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		
		if (cmd.getName().equalsIgnoreCase("exemple")){
			if (sender instanceof Player) {
		           Player player = (Player) sender;
		           player.sendMessage("A que coucou");
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