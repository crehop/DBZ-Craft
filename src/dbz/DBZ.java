package dbz;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dbz.listeners.DoubleTapListener;
import dbz.listeners.InteractEventListener;
import dbz.listeners.PlayerJoinListener;
import dbz.player.DBZPlayer;
import dbz.player.PlayerHandler;

public class DBZ extends JavaPlugin {

	public static DBZ instance;
	
	public void onEnable() {
		instance = this;
		registerCommands();
		registerEvents();
		registerTasks();
		
		addAllOnlinePlayers();
		
		Bukkit.getServer().broadcastMessage("==========DBZ PLUGIN LOADED==========");
	}
	
	public void onDisable() {
		PlayerHandler.dBZPlayers.clear();
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
	
	public void addAllOnlinePlayers() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			PlayerHandler.addDBZPlayer(new DBZPlayer(p));
		}
 	}
	
}
