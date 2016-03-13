package dbz;

import dbz.abilities.AbilityObjectManager;
import dbz.player.PlayerHandler;

public class HeartBeat implements Runnable {
	
	private int currentTick = 0;
	
	private AbilityObjectManager aOM;

	public HeartBeat() {
		aOM = new AbilityObjectManager();
	}
	
	public void run() {
		
		currentTick++;
		
		PlayerHandler.updatePlayers();
		aOM.tick();
		
	}
}
