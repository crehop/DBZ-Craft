package dbz.abilities;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import dbz.player.DBZPlayer;
import dbz.utils.Maths;
import dbz.utils.ParticleEffect;

/*
 *  Remember that you need to stop the player from moving and have it so they can cancel a charge up in the future!
 */
public class SpiritBomb extends Ability {

	private Location initial;
	
	private int currentTick;
	private int rh;
	
	private Vector spiritPath;
	private int ticksUntilDisapear;
	
	public SpiritBomb(String name, int kiPerTick, int chargeTickDown) {
		super("Spirit Bomb", 50, 50);
	}

	public void runAbility(DBZPlayer player) {
		isRunning = true;
		initial = player.getPlayer().getLocation().add(0, 75, 0);
		rh = 1;
		
		spiritPath = player.getPlayer().getEyeLocation().toVector().subtract(initial.toVector());
		ticksUntilDisapear = 1000;
	}

	public void tick() {
		if (isRunning = true && currentTick != chargeTickDown) {
			for (Location l : Maths.circle(initial, rh, rh, true, true, 0)) {
				ParticleEffect.REDSTONE.display(0, 0, 0, 1, 1, l, 50);
			}
			rh++;
			currentTick++;
		} else {
			
		}
	}

}
