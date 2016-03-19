package dbz.abilities.oldAbilities;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import dbz.utils.ParticleEffect;

public class Teleport {
	
	public static void intercept(Player damager, Player damagee){
		//PVPPlayer pvp = PvpHandler.getPvpPlayer(damager);
		//if(pvp.getStamina() > 50 && pvp.canIntercept() == true){
			//pvp.setStamina((int) (pvp.getStamina() - 50));
			damagee.setVelocity(new Vector(0,0,0));
			ParticleEffect.CLOUD.display(0, 0, 0, 1, 5, damager.getLocation(), 100);
			damager.teleport(damagee);
			ParticleEffect.CLOUD.display(0, 0, 0, 1, 5, damager.getLocation(), 100);
			//pvp.setCanUseSkill(false);
			//pvp.setSkillCooldown(2);
		//}
	}
	
	public static void dart(Player player){
		//PVPPlayer pvp = PvpHandler.getPvpPlayer(player);
		//if(pvp.getStamina() > 50 && pvp.canIntercept() == true){
			Vector direction = player.getLocation().getDirection();
			direction.multiply(3);
			player.setVelocity(direction);
			ParticleEffect.CLOUD.display(0, 0, 0, 1, 5, player.getLocation(), 100);
			//pvp.setCanUseSkill(false);
			//pvp.setSkillCooldown(2);
		//}
	}
}
