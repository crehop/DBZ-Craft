package dbz;

public class HeartBeat implements Runnable {
	
	private int currentTick = 0;

	public HeartBeat() {
		
	}
	
	public void run() {
		currentTick++;
	}
}
