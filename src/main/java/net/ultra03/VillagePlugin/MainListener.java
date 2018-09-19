package net.ultra03.VillagePlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;

public class MainListener implements Listener {
	
	private Main plugin;
	
	public MainListener(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		
		if(plugin.isMayor(event.getPlayer())) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7+ [&9Mayor&7] " + event.getPlayer().getName()));
		} else {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7+ " + event.getPlayer().getName()));
		}
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		
		if(plugin.isMayor(event.getPlayer())) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7- [&9Mayor&7] " + event.getPlayer().getName()));
		} else {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7- " + event.getPlayer().getName()));
		}
		
	}

}
