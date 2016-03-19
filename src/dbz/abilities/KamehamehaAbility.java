package dbz.abilities;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import dbz.HeartBeat;
import dbz.abilities.objects.Kamehameha;
import dbz.player.DBZPlayer;
import dbz.utils.Maths;

public class KamehamehaAbility extends Ability {

	private int charge;
	private static int tick;
	
	public KamehamehaAbility() {
		super("Kamehameha", 50);
	}

	public void runAbility(DBZPlayer player) {
		tick = 0;
		charge = 0;
		player.setImmobile(true);
		while(charge < 10) {
			tick++;
			if (HeartBeat.hasTimePassed(tick, 20)) continue;
			if (player.getKi() < kiPerTick) break;
			charge++;
			player.setCharge(charge/10);
			player.setKi(player.getKi() - kiPerTick);
		}
		
		player.setCharge(0);
		Player p = player.getPlayer();
		Fireball f = p.launchProjectile(Fireball.class, Maths.distanceToFrom(p.getEyeLocation(), p.getLocation().subtract(0, 5, 0)));
		new Kamehameha(f, charge*5);
		player.setImmobile(false);
	}

	
	
}
