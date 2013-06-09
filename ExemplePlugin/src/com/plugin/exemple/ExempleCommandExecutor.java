package com.plugin.exemple;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class ExempleCommandExecutor implements CommandExecutor {

	private Exemple plugin; // pointeur vers la classe principale
	 
	public ExempleCommandExecutor(Exemple plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * @param sender Celui qui réalise la commande
	 * @param cmd Objet Command
	 * @param label le label de la commande
	 * @param args les paramètres de la commande
	 */
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
