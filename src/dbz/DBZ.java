package dbz;

import org.bukkit.plugin.java.JavaPlugin;

public class DBZ extends JavaPlugin {

	public static DBZ instance;
	
	public void onEnable() {
		instance = this;
	}
	
	public void onDisable() {
		
	}
	
}
