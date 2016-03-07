package dbz;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dbz.listeners.DoubleTapListener;

public class DBZ extends JavaPlugin {

	public static DBZ instance;
	
	public void onEnable() {
		instance = this;
		
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
	}
	
	public void registerTasks() {
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new HeartBeat(), 0L, 1L);
	}
	
}
