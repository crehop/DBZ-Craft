package dbz.abilities;

import dbz.player.DBZPlayer;
import dbz.player.PlayerHandler;

public abstract class Ability {

	protected String name;
	protected int kiPerTick;
	protected int chargeTickUp;
	protected PlayerHandler ph;
	protected boolean isRunning;
	
	public Ability(String name, int kiPerTick, PlayerHandler ph) {
		this.name = name;
		this.kiPerTick = kiPerTick;
		this.ph = ph;
		this.chargeTickUp = 0;
	}
	
	public abstract void runAbility(DBZPlayer player);
	
}
