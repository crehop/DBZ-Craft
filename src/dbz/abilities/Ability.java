package dbz.abilities;

public abstract class Ability {

	protected String name;
	protected int kiCost;
	protected float chargeTickDown;
	protected float isRunning;
	
	public Ability() {
		
	}
	
	public abstract void runAbility();
	
	public abstract void tick();
	
}
