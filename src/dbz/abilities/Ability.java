package dbz.abilities;

import dbz.player.DBZPlayer;

public abstract class Ability {

	protected String name;
	protected int kiPerTick;
	protected int chargeTickUp;
	protected boolean isRunning;
	
	public Ability(String name, int kiPerTick) {
		this.name = name;
		this.kiPerTick = kiPerTick;
		this.chargeTickUp = 0;
	}
	
	public abstract void runAbility(DBZPlayer player);
	
}
