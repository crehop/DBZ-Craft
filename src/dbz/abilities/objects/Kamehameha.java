package dbz.abilities.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import code.op.utils.CustomEntityFirework;
import dbz.abilities.AbilityObjectManager;
import dbz.player.DBZPlayer;
import dbz.player.PlayerHandler;
import dbz.utils.Maths;
import dbz.utils.ParticleEffect;

public class Kamehameha {

	private Fireball fireball;
	private int damage;
	private boolean isDead;
	private List<Location> allLocations;
	
	private final FireworkEffect.Builder builder = FireworkEffect.builder();
	private final FireworkEffect fe = builder.flicker(true).with(Type.BURST).withColor(Color.AQUA).trail(false).build();
	
	public Kamehameha(Fireball fireball, int damage) {
		this.fireball = fireball;
		this.damage = damage;
		this.isDead = fireball.isDead();
		this.allLocations = new ArrayList<Location>();
		
		AbilityObjectManager.kamehamehas.add(this);
	}
	
	public void tick() {
		isDead = fireball.isDead();
		
		if (!isDead || !fireball.isOnGround()) {
			allLocations.add(fireball.getLocation());
			for (Location l : allLocations) {
				ParticleEffect.CRIT.display(0, 0, 0, 1, 1, l, 3000);
			}
			for (Location l : Maths.circle(fireball.getLocation(), 2, 2, true, true, 0)) {
				CustomEntityFirework.spawn(l, fe);			
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
