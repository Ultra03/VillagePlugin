package net.ultra03.VillagePlugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	Main instance;
	
	@Override
	public void onEnable() {
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new MainListener(this), this);
		getCommand("mayor").setExecutor(new MayorCommand(this));
		
		instance = this;
		saveDefaultConfig();
		
		getLogger().info("Enabled VillagePlugin v1.0.1 by Ultra03");
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Disabled VillagePlugin v1.0.1 by Ultra03");
	}
	
	public boolean isMayor(Player player) {
		
		if(getConfig().getString("mayor").equalsIgnoreCase(player.getName())) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
