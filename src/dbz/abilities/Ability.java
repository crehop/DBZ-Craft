package dbz.abilities;

import dbz.player.DBZPlayer;

public abstract class Ability {

	protected String name;
	protected int kiPerTick;
	protected int chargeTickDown;
	protected boolean isRunning;
	
	public Ability(String name, int kiPerTick, int chargeTickDown) {
		this.name = name;
		this.kiPerTick = kiPerTick;
		this.chargeTickDown = chargeTickDown;
	}
	
	public abstract void runAbility(DBZPlayer player);
	
	public abstract void tick();
	
}
