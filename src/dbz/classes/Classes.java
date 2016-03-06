package dbz.classes;

public enum Classes {
	
	GOKU("Goku", 500.0, 750000), PICCOLO("PICCOLO", 700, 500000);
	
	private String name;
	private double maxHealth;
	private int startingKi;
	
	private Classes(String name, double maxHealth, int startingKi) {
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

	public int getStartingKi() {
		return startingKi;
	}
	
}
