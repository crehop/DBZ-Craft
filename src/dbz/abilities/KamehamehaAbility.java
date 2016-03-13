package dbz.abilities;

import java.util.concurrent.TimeUnit;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import dbz.abilities.objects.Kamehameha;
import dbz.player.DBZPlayer;
import dbz.utils.Maths;

public class KamehamehaAbility extends Ability {

	private int charge;
	
	public KamehamehaAbility() {
		super("Kamehameha", 50);
	}

	public void runAbility(DBZPlayer player) {
		charge = 0;
		player.setImmobile(true);
		try {
			while(charge < 10) {
				if (player.getKi() < kiPerTick) break;
				charge++;
				player.setCharge(charge/10);
				player.setKi(player.getKi() - kiPerTick);
				TimeUnit.SECONDS.sleep(1);
			}
			
			player.setCharge(0);
			Player p = player.getPlayer();
			Fireball f = p.launchProjectile(Fireball.class, Maths.distanceToFrom(p.getEyeLocation(), p.getLocation()));
			new Kamehameha(f, charge*5);
			player.setImmobile(false);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
}
