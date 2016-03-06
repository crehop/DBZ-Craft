package dbz.classes;

public enum Classes {
	
	GOKU("Goku", 500.0, 750000.0), PICCOLO("PICCOLO", 700, 500000.0);
	
	private String name;
	private double maxHealth;
	private double startingKi;
	
	private Classes(String name, double maxHealth, double startingKi) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.startingKi = startingKi;
	}

	public String getName() {
		return name;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getStartingKi() {
		return startingKi;
	}
	
}
