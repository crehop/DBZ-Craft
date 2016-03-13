package dbz.abilities.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import dbz.abilities.AbilityObjectManager;
import dbz.player.DBZPlayer;
import dbz.player.PlayerHandler;
import dbz.utils.Maths;
import dbz.utils.ParticleEffect;

public class Kamehameha {

	private Fireball fireball;
	private int damage;
	private boolean isDead;
	private List<List<Location>> allLocations;
	
	public Kamehameha(Fireball fireball, int damage) {
		this.fireball = fireball;
		this.damage = damage;
		this.isDead = fireball.isDead();
		this.allLocations = new ArrayList<List<Location>>();
		
		AbilityObjectManager.kamehamehas.add(this);
	}
	
	public void tick() {
		isDead = fireball.isDead();
		
		if (!isDead) {
			allLocations.add(Maths.circle(fireball.getLocation(), 10, 10, false, false, 0));
			for (List<Location> list : allLocations) {
				for (Location l : list) {
					ParticleEffect.BARRIER.display(0, 0, 0, 1, 1, l, 3000);
				}
			}
			
			for (Entity e : fireball.getNearbyEntities(10, 10, 10)) {
				if (e instanceof Player) {
					Player p = (Player) e;
					DBZPlayer dp = PlayerHandler.getDBZPlayer(p);
					dp.setDamage(damage); //Just for now, damage system needs help.
				}
			}
			
		} else {
			fireball.remove();
		}
	}

	public boolean isDead() {
		return isDead;
	}
	
}
