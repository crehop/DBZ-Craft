package dbz.player;

import org.bukkit.entity.Player;

import dbz.classes.Classes;

public class DBZPlayer {

	private Player player;
	private double maxHealth;
	private double health;
	private int ki; 
	private Classes currentClass;
	
	public DBZPlayer(Player player) {
		this.player = player;
		this.currentClass = Classes.GOKU;
		this.maxHealth = currentClass.getMaxHealth();
		this.health = player.getHealth();
		this.ki = currentClass.getStartingKi();
	}
	
	public DBZPlayer(Player player, Classes classes) {
		this.player = player;
		this.currentClass = classes;
		this.maxHealth = currentClass.getMaxHealth();
		this.health = player.getHealth();
		this.ki = currentClass.getStartingKi();
	}
	
	// MODIFIED SETTERS AND GETTERS
	
	public void setDamage(double damage) {
		health = health - damage;
		player.setHealth((player.getMaxHealth() * health)/maxHealth);
	}
	
	public void setHealth(double newHealth) {
		this.health = newHealth;
		player.setHealth((player.getMaxHealth() * health)/maxHealth);
	}
	
	public void setKi(int ki) {
		this.ki = ki;
		player.setLevel(ki);
	}
	
	// GETTERS AND SETTERS
	
	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getHealth() {
		return health;
	}

	public int getKi() {
		return ki;
	}

	public Classes getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(Classes currentClass) {
		this.currentClass = currentClass;
	}

	public Player getPlayer() {
		return player;
	}
	
	
	
}
