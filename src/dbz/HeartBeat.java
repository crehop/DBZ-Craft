package dbz;

import dbz.abilities.AbilityObjectManager;

public class HeartBeat implements Runnable {
	
	private int currentTick = 0;
	
	private AbilityObjectManager aOM;

	public HeartBeat() {
		aOM = new AbilityObjectManager();
	}
	
	public void run() {
		
		currentTick++;
		
		aOM.tick();
		
	}
}
