package dbz;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dbz.listeners.DoubleTapListener;
import dbz.listeners.InteractEventListener;
import dbz.listeners.PlayerJoinListener;

public class DBZ extends JavaPlugin {

	public static DBZ instance;
	
	public void onEnable() {
		instance = this;
		Bukkit.getServer().broadcastMessage("==========DBZ PLUGIN LOADED==========");
		registerCommands();
		registerEvents();
		registerTasks();
	}
	
	public void onDisable() {
		
	}
	
	public void registerCommands() {
		
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new DoubleTapListener(), this);
		pm.registerEvents(new InteractEventListener(), this);
		pm.registerEvents(new PlayerJoinListener(), this);
	}
	
	public void registerTasks() {
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new HeartBeat(), 0L, 1L);
	}
	
}
