package net.ultra03.VillagePlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MayorCommand implements CommandExecutor {
	
	private Main plugin;
	
	public MayorCommand(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("mayor")) {
			
			if(args.length == 0) {
				return false;
			} else if(args.length == 1) {
				
				if(plugin.getConfig().getString("mayor").equals("")) {
					Player mayor = Bukkit.getPlayer(args[0]);
					ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
					Bukkit.dispatchCommand(console, "pex user " + mayor.getName() + " group set Mayor");
					plugin.getConfig().set("mayor", args[0]);
					plugin.saveConfig();
					Bukkit.broadcastMessage(ChatColor.AQUA + "Mayorship has been successfully given to " + ChatColor.YELLOW + mayor.getName());
				} else {
					String currentMayorString = plugin.getConfig().getString("mayor");
					Player currentMayor = Bukkit.getPlayer(currentMayorString);
					ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
					
					Player newMayor = Bukkit.getPlayer(args[0]);
					if(newMayor.getName() == plugin.getConfig().getString("mayor")) {
						sender.sendMessage(ChatColor.RED + "That player is already the mayor.");
					} else {
						Bukkit.dispatchCommand(console, "pex user " + currentMayor.getName() + " group set Default");
						Bukkit.dispatchCommand(console, "pex user " + newMayor.getName() + " group set Mayor");
						plugin.getConfig().set("mayor", args[0]);
						plugin.saveConfig();
						Bukkit.broadcastMessage(ChatColor.AQUA + "Mayorship has been successfully transferred to " + ChatColor.YELLOW + newMayor.getName());
					}
				}
				
				
			} else {
				return false;
			}
			
			
			return true;
			
		}
		
		
		return false;
		
	}

}
