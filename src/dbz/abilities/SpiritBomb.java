package dbz.abilities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import dbz.player.DBZPlayer;
import dbz.player.PlayerHandler;
import dbz.utils.Maths;
import dbz.utils.ParticleEffect;

/*
 * 
 */
public class SpiritBomb extends Ability {

	private Player shooter;
	private Location bombLocation;
	
	private int radiusAndHeight = 0;
	
	public SpiritBomb(String name, int kiPerTick, int chargeTickUp, PlayerHandler ph) {
		super("Spirit Bomb", 50, ph);
	}

	public void runAbility(DBZPlayer player) {
		this.shooter = player.getPlayer();
		this.bombLocation = shooter.getLocation().add(0, 35, 0);
		player.setImmobile(true); // Tells if player cna move while charging ability
		
		boolean isCharging = true;
		
		while(isCharging) {
			if (chargeTickUp < 50 && player.getKi() >= kiPerTick) {
				chargeTickUp++;
				player.setCharge(chargeTickUp/50);
				player.setKi(player.getKi() - kiPerTick);
				
				radiusAndHeight++;
				for (Location l : Maths.circle(bombLocation, radiusAndHeight, radiusAndHeight, false, true, 0)) {
					ParticleEffect.REDSTONE.display(0, 0, 0, 1, 1, l, 5000);
				}
			}
		}
		
		Fireball f = shooter.launchProjectile(Fireball.class, Maths.distanceToFrom(shooter.getEyeLocation(), bombLocation));
		f.setShooter(shooter);
		
		while(!f.isDead()) {
			for (Location l : Maths.circle(f.getLocation(), radiusAndHeight, radiusAndHeight, false, true, 0)) {
				ParticleEffect.REDSTONE.display(0, 0, 0, 1, 1, l, 5000);
			}
			if (f.getNearbyEntities(radiusAndHeight, radiusAndHeight, radiusAndHeight) != null) {
				for (Entity e : f.getNearbyEntities(radiusAndHeight, radiusAndHeight, radiusAndHeight)) {
					if (e instanceof LivingEntity) {
						if (e instanceof Player) {
							Player p = (Player) e;
							if (p.equals(shooter)) continue;
							DBZPlayer inflicted = ph.getDBZPlayer(p);
							inflicted.setDamage(radiusAndHeight*5 + player.getMaxKi()/5);
							p.setVelocity(Maths.distanceToFrom(p.getLocation().add(bombLocation), p.getEyeLocation().multiply(-1)));
							p.setFlying(false);
						}
					}
				}
			}
			if (f.getTicksLived() >= 10000) {
				f.remove();
			}
		}
		
	}

}
