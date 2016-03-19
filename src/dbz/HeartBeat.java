package dbz;

import dbz.abilities.AbilityObjectManager;
import dbz.player.PlayerHandler;

public class HeartBeat implements Runnable {
	
	private static int currentTick = 0;
	private static int holder = 0;
	 
	private AbilityObjectManager aOM;

	public HeartBeat() {
		aOM = new AbilityObjectManager();
	}
	
	public void run() {
		
		currentTick++;
		if(currentTick > 10000000){
			currentTick = 0;
		}
		PlayerHandler.updatePlayers();
		aOM.tick();
		
	}
	public int getCurrentTick(){
		return currentTick;
	}
	public static boolean hasTimePassed(int initialTick, int time){
		if(initialTick < currentTick){
			if(currentTick - initialTick >= time){
				return true;
			}
			return false;
		}else{
			holder = 10000000 - initialTick;
			if(holder + currentTick >= time){
				return true;
			}else{
				return false;
			}
		}
	}
}
