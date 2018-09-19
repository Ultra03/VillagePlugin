package net.ultra03.VillagePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class GetMayorCommand implements CommandExecutor {
	
	private Main plugin;
	
	public GetMayorCommand(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("mayor")) {
			if(args.length > 0) {
				return false;
			} else {
				if(plugin.getConfig().getString("mayor").equals("")) {
					sender.sendMessage(ChatColor.RED + "There is currently no mayor!");
				} else {
					sender.sendMessage(ChatColor.AQUA + "The current mayor is " + ChatColor.YELLOW + plugin.getConfig().getString("mayor"));
				}
			}
			return true;
		}
		return false;
	}

}
