package dbz.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dbz.classes.Classes;
import dbz.utils.BarAPI;

public class DBZPlayer {

	private Player player;
	private double maxHealth;
	private double health;
	private int maxKi;
	private int ki;
	private float charge;
	private boolean immobile;
	private Classes currentClass;
	
	public DBZPlayer(Player player) {
		this.player = player;
		this.currentClass = Classes.GOKU;
		this.maxHealth = currentClass.getMaxHealth();
		this.health = player.getHealth();
		this.maxKi = currentClass.getMaxKi();
		this.ki = 0;
		this.charge = 0.00F;
		this.immobile = false;
		BarAPI.setMessage(player, ChatColor.BLUE + player.getName(), true);
		BarAPI.setPercent(player, charge, true);
	}
	
	public DBZPlayer(Player player, Classes classes) {
		this.player = player;
		this.currentClass = classes;
		this.maxHealth = currentClass.getMaxHealth();
		this.health = player.getHealth();
		this.maxKi = currentClass.getMaxKi();
		this.ki = 0;
		this.charge = 0.00F;
		BarAPI.setMessage(player, ChatColor.BLUE + player.getName(), true);
		BarAPI.setPercent(player, charge, true);
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
	
	public void setCharge(float charge) {
		this.charge = charge;
		BarAPI.setPercent(player, charge, true);
	}
	
	// GETTERS AND SETTERS
	
	public double getMaxHealth() {
		return maxHealth;
	}

	public float getCharge() {
		return charge;
	}

	public int getMaxKi() {
		return maxKi;
	}

	public void setMaxKi(int maxKi) {
		this.maxKi = maxKi;
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
	
	public boolean isImmobile() {
		return immobile;
	}

	public void setImmobile(boolean immobile) {
		this.immobile = immobile;
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
