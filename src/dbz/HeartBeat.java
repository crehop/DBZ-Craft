package dbz;

import org.bukkit.plugin.Plugin;

public class HeartBeat {
	private int currentTick = 0;
	public HeartBeat(Plugin main){
		main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable(){
		    @Override  
		   	public void run(){
		    	currentTick++;
		}	}, 0L, 5L);
		
	}
	public int getCurrentTick(){
		return this.currentTick;
	}
}
