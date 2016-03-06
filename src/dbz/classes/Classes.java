package dbz.classes;

public enum Classes {
	
	GOKU("Goku", 500.0, 750000), PICCOLO("PICCOLO", 700, 500000);
	
	private String name;
	private double maxHealth;
	private int maxKi;
	
	private Classes(String name, double maxHealth, int maxKi) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.maxKi = maxKi;
	}

	public String getName() {
		return name;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public int getMaxKi() {
		return maxKi;
	}
	
}
